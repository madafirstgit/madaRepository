/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.stockupdate;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.entity.LockRecord;
import com.pzj.core.stock.entity.Stock;
import com.pzj.core.stock.enums.StockStateEnum;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.exception.stock.NotFoundStockException;
import com.pzj.core.stock.exception.stock.StockStateException;
import com.pzj.core.stock.model.OccupyStockRequestModel;
import com.pzj.core.stock.read.LockRecordReadMapper;
import com.pzj.core.stock.write.LockRecordWriteMapper;
import com.pzj.core.stock.write.StockWriteMapper;
import com.pzj.framework.toolkit.Check;

/**
 * 
 * @author Administrator
 * @version $Id: RollbackOccupyStockEngine.java, v 0.1 2016年8月19日 下午3:18:02 Administrator Exp $
 */
@Component("rollbackOccupyStockEngine")
public class RollbackOccupyStockEngine {
    @Resource(name = "lockRecordReadMapper")
    private LockRecordReadMapper  lockRecordReadMapper;
    @Resource(name = "lockRecordWriteMapper")
    private LockRecordWriteMapper lockRecordWriteMapper;
    @Resource(name = "stockWriteMapper")
    private StockWriteMapper      stockWriteMapper;

    @Transactional(value = "stock.transactionManager", timeout = 2)
    public void rollbackOccupyStock(OccupyStockRequestModel requestModel) {
        //1. 查看回滚库存数据是否存在.
        LockRecord lockRecord = lockRecordReadMapper.queryLockedRecord(requestModel.getTransactionId(), requestModel.getProductId());
        if (Check.NuNObject(lockRecord) || CommonUtils.checkIntegerIsNull(lockRecord.getLockNum(), true)) {
            return; //容错机制, 若无相同交易流水, 产品, 则认为成功.
        }
        //2. 获取修改库存数据
        Stock stock = stockWriteMapper.queryStockByIdForUpdate(lockRecord.getStockId());
        canOperateStock(stock);

        //3. 计算库存
        computeStockNum(stock, lockRecord.getLockNum());

        //3. 操作数据库回滚数据.
        stockWriteMapper.updateStockNum(stock.getId(), stock.getUsedNum(), stock.getRemainNum());
        lockRecordWriteMapper.deleteLockRecordById(lockRecord.getId()); //删除锁库存记录
    }

    /**
     * 判断库存是否可以回滚
     * @param stock
     */
    private void canOperateStock(Stock stock) {
        if (stock == null) {
            throw new NotFoundStockException(StockExceptionCode.NOT_FOUND_STOCK_ERR_MSG);
        }

        int state = stock.getState();
        if (state != StockStateEnum.AVAILABLE.getState()) {
            throw new StockStateException(StockExceptionCode.STOCK_STATE_ERR_MSG);
        }
    }

    /**
     * 计算库存数量.
     * @param stock
     * @param releaseNum
     */
    private void computeStockNum(Stock stock, int releaseNum) {
        int used = stock.getUsedNum() == null ? 0 : stock.getUsedNum();
        stock.setUsedNum(used - releaseNum);
        stock.setRemainNum(stock.getRemainNum() + releaseNum);
    }
}
