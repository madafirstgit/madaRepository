/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.stockupdate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.entity.LockRecord;
import com.pzj.core.stock.entity.Stock;
import com.pzj.core.stock.enums.OperateStockBussinessType;
import com.pzj.core.stock.enums.StockStateEnum;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.exception.stock.LimitedException;
import com.pzj.core.stock.exception.stock.NoExistBatchLockStockRecordException;
import com.pzj.core.stock.exception.stock.NotFoundStockException;
import com.pzj.core.stock.exception.stock.NotFoundStockRecordException;
import com.pzj.core.stock.exception.stock.ReleaseNumException;
import com.pzj.core.stock.exception.stock.ShortageStockException;
import com.pzj.core.stock.exception.stock.StockStateException;
import com.pzj.core.stock.model.StockBatchLockModel;
import com.pzj.core.stock.read.LockRecordReadMapper;
import com.pzj.core.stock.write.LockRecordWriteMapper;
import com.pzj.core.stock.write.StockWriteMapper;
import com.pzj.framework.toolkit.Check;

/**
 * 
 * @author Administrator
 * @version $Id: StockBatchLockEngine.java, v 0.1 2016年8月3日 下午7:46:47 Administrator Exp $
 */
@Component("stockBatchLockEngine")
public class StockBatchLockEngine {
    @Resource(name = "stockWriteMapper")
    private StockWriteMapper      stockWriteMapper;

    @Resource(name = "lockRecordWriteMapper")
    private LockRecordWriteMapper lockRecordWriteMapper;

    @Resource(name = "lockRecordReadMapper")
    private LockRecordReadMapper  lockRecordReadMapper;

    @SuppressWarnings("unchecked")
    @Transactional(value = "stock.transactionManager", timeout = 2)
    public void batchLockAndReleaseStock(StockBatchLockModel stockBatchLockModel) {
        //1、获取库存id集合
        List<Long> stockIds = getStockIds(stockBatchLockModel);

        //2、查询库存集合
        List<Stock> stockList = stockWriteMapper.queryStockByIdsForUpdate(stockIds);
        if (Check.NuNCollections(stockList)) {
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        int operateType = stockBatchLockModel.getOperateType();
        Map<Long, Integer> operateStockMap = stockBatchLockModel.getOperateStockMap();
        Long userId = stockBatchLockModel.getUserId();
        List<LockRecord> lockRecordList = null;

        //获取用户锁库存记录信息
        List<LockRecord> lockRecordHistory = lockRecordReadMapper.queryLockRecordByUser(stockIds, userId, OperateStockBussinessType.BATCH_OCCUPY_STOCK.key);
        if (operateType == OperateStockBussinessType.BATCH_OCCUPY_STOCK.key) {
            List<LockRecord> historyLocks = null;
            if (!Check.NuNCollections(lockRecordHistory)) {
                List<Long> lockRecordIds = new ArrayList<Long>();
                for (LockRecord lockRecord : lockRecordHistory) {
                    lockRecordIds.add(lockRecord.getId());
                }

                historyLocks = lockRecordWriteMapper.queryLockRecordByIdsForUpdate(lockRecordIds);
            }

            //组织生成锁库存记录
            Object[] lockObjects = organizeLockRecord(stockList, historyLocks, operateStockMap, userId);
            lockRecordList = (List<LockRecord>) lockObjects[0];
            List<LockRecord> updHistoryLockRecordList = (List<LockRecord>) lockObjects[1];

            //判断是否可以锁库存
            canLockStock(stockList, operateStockMap);

            //计算锁库存数量
            lockStockNum(stockList, operateStockMap);

            //更新数据库记录
            if (updHistoryLockRecordList.size() > 0) {
                lockRecordWriteMapper.userUpdateBatchLock(updHistoryLockRecordList);
            }
            if (lockRecordList.size() > 0) {
                lockRecordWriteMapper.userAddBatchLock(lockRecordList);
            }
            stockWriteMapper.batchUpdateStockNum(stockList);

        } else if (operateType == OperateStockBussinessType.BATCH_RELEASE_STOCK.key) {
            if (Check.NuNCollections(lockRecordHistory)) {
                throw new NoExistBatchLockStockRecordException(StockExceptionCode.NOTEXIST_BATCH_LOCK_STOCK_ERR_MSG);
            }
            List<Long> lockRecordIds = new ArrayList<Long>();
            for (LockRecord lockRecord : lockRecordHistory) {
                lockRecordIds.add(lockRecord.getId());
            }
            lockRecordList = lockRecordWriteMapper.queryLockRecordByIdsForUpdate(lockRecordIds);

            //判断是否可以释放库存
            canReleaseStockRecord(lockRecordList, operateStockMap);
            canReleaseStock(stockList, operateStockMap);

            //计算释放库存数量
            releaseStockRecordNum(lockRecordList, operateStockMap);
            releaseStockNum(stockList, operateStockMap);

            List<Long> delLockRecord = new ArrayList<Long>();
            Iterator<LockRecord> itera = lockRecordList.iterator();
            while (itera.hasNext()) {
                LockRecord lockRecord = itera.next();
                if (lockRecord.getLockNum() == 0) {
                    delLockRecord.add(lockRecord.getId());
                    itera.remove();
                }
            }

            //更新数据库记录
            if (delLockRecord.size() > 0) {
                lockRecordWriteMapper.delBatchLockByIds(delLockRecord);
            }
            if (lockRecordList.size() > 0) {
                lockRecordWriteMapper.userUpdateBatchLock(lockRecordList);
            }
            stockWriteMapper.batchUpdateStockNum(stockList);
        }

    }

    /**
     * 锁库存操作.
     * @param stockList
     * @param operateStockMap
     */
    private void lockStockNum(List<Stock> stockList, Map<Long, Integer> operateStockMap) {
        for (Stock stock : stockList) {
            int used = stock.getUsedNum() == null ? 0 : stock.getUsedNum();
            int occupyNum = operateStockMap.get(stock.getId());
            stock.setUsedNum(used + occupyNum);
            stock.setRemainNum(stock.getRemainNum() - occupyNum);
        }

    }

    /**
     * 释放库存操作.
     * @param stockList
     * @param operateStockMap
     */
    private void releaseStockNum(List<Stock> stockList, Map<Long, Integer> operateStockMap) {
        for (Stock stock : stockList) {
            int releaseNum = operateStockMap.get(stock.getId());
            stock.setUsedNum(stock.getUsedNum() - releaseNum);
            stock.setRemainNum(stock.getRemainNum() + releaseNum);
        }
    }

    /**
     * 释放库存记录操作
     * @param lockRecordList
     * @param operateStockMap
     */
    private void releaseStockRecordNum(List<LockRecord> lockRecordList, Map<Long, Integer> operateStockMap) {
        for (LockRecord lockRecord : lockRecordList) {
            int releaseNum = operateStockMap.get(lockRecord.getStockId());
            lockRecord.setLockNum(lockRecord.getLockNum() - releaseNum);
        }
    }

    /**
     * 获取库存id集合
     * @param stockBatchLockModel
     * @return
     */
    private List<Long> getStockIds(StockBatchLockModel stockBatchLockModel) {
        List<Long> stockIds = new ArrayList<Long>();
        Iterator<Long> itera = stockBatchLockModel.getOperateStockMap().keySet().iterator();
        while (itera.hasNext()) {
            Long stockId = itera.next();
            if (CommonUtils.checkLongIsNull(stockId, true)) {
                throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
            }
            stockIds.add(stockId);
        }
        return stockIds;
    }

    /**
     * 组织生成锁库存记录
     * @param stockList
     * @param historyStockMap
     * @param operateStockMap
     * @param userId
     * @return Object[]
     */
    private Object[] organizeLockRecord(List<Stock> stockList, List<LockRecord> historyLocks, Map<Long, Integer> operateStockMap, Long userId) {
        List<LockRecord> addLockRecordList = new ArrayList<LockRecord>();
        List<LockRecord> updHistoryLockRecordList = new ArrayList<LockRecord>();
        Long stockId = 0l;
        int historyLockNum = 0;
        LockRecord historyLockRecord = null;
        for (Stock stock : stockList) {
            stockId = stock.getId();
            historyLockNum = 0;
            historyLockRecord = null;

            if (!Check.NuNCollections(historyLocks)) {
                for (LockRecord lockRecord : historyLocks) {
                    if (stockId == lockRecord.getStockId().longValue()) {
                        historyLockRecord = lockRecord;
                        historyLockNum = lockRecord.getLockNum();
                        break;
                    }
                }
            }

            int lockNum = operateStockMap.get(stockId);

            if (historyLockNum > 0) {
                historyLockRecord.setLockNum(lockNum + historyLockNum);
                updHistoryLockRecordList.add(historyLockRecord);
            } else {
                LockRecord lockRecord = new LockRecord();
                lockRecord.setBizType(OperateStockBussinessType.BATCH_OCCUPY_STOCK.key);
                lockRecord.setOperatorId(userId);
                lockRecord.setStockId(stockId);
                lockRecord.setLockNum(lockNum);
                addLockRecordList.add(lockRecord);
            }
        }

        return new Object[] { addLockRecordList, updHistoryLockRecordList };
    }

    /**
     * 判断库存可被占用.
     * @param stockList
     * @param opeStockMap
     */
    private void canLockStock(List<Stock> stockList, Map<Long, Integer> opeStockMap) {
        for (Stock stock : stockList) {
            if (stock == null) {
                throw new NotFoundStockException(StockExceptionCode.NOT_FOUND_STOCK_ERR_MSG);
            }

            int state = stock.getState();
            if (state != StockStateEnum.AVAILABLE.getState()) {
                throw new StockStateException(StockExceptionCode.STOCK_STATE_ERR_MSG);
            }

            int remain = stock.getRemainNum();
            Integer lockNum = opeStockMap.get(stock.getId());
            if (CommonUtils.checkIntegerIsNull(lockNum, true)) {
                throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
            }

            if (remain < lockNum) {
                throw new ShortageStockException(StockExceptionCode.STOCK_SHORTAGE_ERR_MSG);
            }

            int total = stock.getTotalNum();
            int used = stock.getUsedNum() == null ? 0 : stock.getUsedNum();
            if ((used + lockNum) > total) {
                throw new LimitedException(StockExceptionCode.MAX_STOCK_NUM_ERR_MSG);
            }
        }
    }

    /**
     * 判断库存可被释放.
     * @param stockList
     */
    private void canReleaseStock(List<Stock> stockList, Map<Long, Integer> opeStockMap) {
        for (Stock stock : stockList) {
            if (stock == null) {
                throw new NotFoundStockException(StockExceptionCode.NOT_FOUND_STOCK_ERR_MSG);
            }

            int state = stock.getState();
            if (state != StockStateEnum.AVAILABLE.getState()) {
                throw new StockStateException(StockExceptionCode.STOCK_STATE_ERR_MSG);
            }

        }
    }

    /**
     * 判断库存记录是否可被释放
     * @param recordList
     * @param opeStockMap
     */
    private void canReleaseStockRecord(List<LockRecord> recordList, Map<Long, Integer> opeStockMap) {
        for (LockRecord record : recordList) {
            if (record == null) {
                throw new NotFoundStockRecordException(StockExceptionCode.NOT_FOUND_STOCK_RECORD_ERR_MSG);
            }

            Integer releaseNum = opeStockMap.get(record.getStockId());
            if (CommonUtils.checkIntegerIsNull(releaseNum, true)) {
                throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
            }

            if (record.getLockNum() < releaseNum) {
                throw new ReleaseNumException(StockExceptionCode.RELEASE_STOCK_NUM_ERR_MSG);
            }
        }
    }

}
