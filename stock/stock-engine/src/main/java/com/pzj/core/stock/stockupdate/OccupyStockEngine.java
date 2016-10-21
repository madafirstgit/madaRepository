package com.pzj.core.stock.stockupdate;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pzj.core.stock.entity.LockRecord;
import com.pzj.core.stock.entity.Stock;
import com.pzj.core.stock.enums.OperateStockBussinessType;
import com.pzj.core.stock.enums.StockStateEnum;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.exception.stock.LimitedException;
import com.pzj.core.stock.exception.stock.NotFoundStockException;
import com.pzj.core.stock.exception.stock.ShortageStockException;
import com.pzj.core.stock.exception.stock.StockStateException;
import com.pzj.core.stock.model.OccupyStockRequestModel;
import com.pzj.core.stock.read.LockRecordReadMapper;
import com.pzj.core.stock.read.StockReadMapper;
import com.pzj.core.stock.write.LockRecordWriteMapper;
import com.pzj.core.stock.write.StockWriteMapper;

/**
 * 占库存执行引擎.
 * @author YRJ
 *
 */
@Component(value = "occupyStockEngine")
public class OccupyStockEngine {

    @Resource(name = "stockReadMapper")
    private StockReadMapper       stockReadMapper;

    @Resource(name = "stockWriteMapper")
    private StockWriteMapper      stockWriteMapper;

    @Resource(name = "lockRecordWriteMapper")
    private LockRecordWriteMapper lockRecordWriteMapper;

    @Resource(name = "lockRecordReadMapper")
    private LockRecordReadMapper  lockRecordReadMapper;

    @Transactional(value = "stock.transactionManager", timeout = 2)
    public void occupyStock(OccupyStockRequestModel requestModel) {
        //1. 根据库存ID获取库存的基本信息.
        Stock stock = stockWriteMapper.queryStockByIdForUpdate(requestModel.getStockId());

        canOccupyStock(stock, requestModel.getStockNum());

        //2. 判断库存是否已被锁定.
        int count = lockRecordReadMapper.existLocked(requestModel.getTransactionId(), requestModel.getProductId());
        if (count > 0) {
            return;//容错机制, 若相同交易流水, 产品已经锁定, 则认为成功.
        }

        //3. 计算库存数量.
        computeStockNum(stock, requestModel.getStockNum());

        //4. 更新库存记录.
        LockRecord lockRecord = generateStockLockRecord(requestModel);
        lockRecordWriteMapper.insert(lockRecord);
        stockWriteMapper.updateStockNum(stock.getId(), stock.getUsedNum(), stock.getRemainNum());
    }

    /**
     * 判断库存可被占用.
     * @param stock
     * @param occupyNum
     */
    private void canOccupyStock(Stock stock, int occupyNum) {
        if (stock == null) {
            throw new NotFoundStockException(StockExceptionCode.NOT_FOUND_STOCK_ERR_MSG);
        }

        int state = stock.getState();
        if (state != StockStateEnum.AVAILABLE.getState()) {
            throw new StockStateException(StockExceptionCode.STOCK_STATE_ERR_MSG);
        }

        int remain = stock.getRemainNum();
        if (remain < occupyNum) {
            throw new ShortageStockException(StockExceptionCode.STOCK_SHORTAGE_ERR_MSG);
        }

        int total = stock.getTotalNum();
        int used = stock.getUsedNum() == null ? 0 : stock.getUsedNum();
        if ((used + occupyNum) > total) {
            throw new LimitedException(StockExceptionCode.MAX_STOCK_NUM_ERR_MSG);
        }
    }

    /**
     * 生成锁库存记录.
     * @param requestModel
     * @return
     */
    private LockRecord generateStockLockRecord(OccupyStockRequestModel requestModel) {
        LockRecord lockRecord = new LockRecord();
        lockRecord.setStockId(requestModel.getStockId());
        lockRecord.setTransactionId(requestModel.getTransactionId());
        lockRecord.setProductId(requestModel.getProductId());
        lockRecord.setBizType(OperateStockBussinessType.ORDER_OCCUPY_STOCK.key);
        lockRecord.setLockNum(requestModel.getStockNum());
        lockRecord.setOperatorId(requestModel.getUserId());
        return lockRecord;
    }

    /**
     * 计算库存数量.
     * @param stock
     * @param stockNum
     */
    private void computeStockNum(Stock stock, int occupyNum) {
        int used = stock.getUsedNum() == null ? 0 : stock.getUsedNum();
        stock.setUsedNum(used + occupyNum);
        stock.setRemainNum(stock.getRemainNum() - occupyNum);
    }
}
