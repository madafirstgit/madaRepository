package com.pzj.core.stock.stockupdate;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.pzj.core.stock.entity.LockRecord;
import com.pzj.core.stock.entity.Stock;
import com.pzj.core.stock.entity.StockRule;
import com.pzj.core.stock.enums.StockReturnTypeEnum;
import com.pzj.core.stock.enums.StockRuleTypeEnum;
import com.pzj.core.stock.enums.StockStateEnum;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.exception.errcode.StockRuleExceptionCode;
import com.pzj.core.stock.exception.rule.NotFoundStockRuleException;
import com.pzj.core.stock.exception.rule.StockReturnTypeException;
import com.pzj.core.stock.exception.stock.NotFoundStockException;
import com.pzj.core.stock.exception.stock.ReleaseNumException;
import com.pzj.core.stock.exception.stock.StockStateException;
import com.pzj.core.stock.model.OccupyStockRequestModel;
import com.pzj.core.stock.read.LockRecordReadMapper;
import com.pzj.core.stock.read.StockReadMapper;
import com.pzj.core.stock.read.StockRuleReadMapper;
import com.pzj.core.stock.write.LockRecordWriteMapper;
import com.pzj.core.stock.write.StockWriteMapper;

/**
 * 释放库存执行引擎.
 * @author YRJ
 *
 */
@Component(value = "releaseStockEngine")
public class ReleaseStockEngine {

    @Resource(name = "lockRecordReadMapper")
    private LockRecordReadMapper  lockRecordReadMapper;

    @Resource(name = "stockReadMapper")
    private StockReadMapper       stockReadMapper;

    @Resource(name = "lockRecordWriteMapper")
    private LockRecordWriteMapper lockRecordWriteMapper;

    @Resource(name = "stockWriteMapper")
    private StockWriteMapper      stockWriteMapper;

    @Resource(name = "stockRuleReadMapper")
    private StockRuleReadMapper   stockRuleReadMapper;

    public void releaseStock(OccupyStockRequestModel requestModel) {
        //1. 判断库存是否已被锁定, 无被锁库存则无需释放.
        LockRecord record = lockRecordReadMapper.queryLockedRecord(requestModel.getTransactionId(), requestModel.getProductId());
        if (record == null) {
            return; // 容错机制, 当锁库存记录不存在时, 无需释放.
        }

        //2. 获取库存和库存记录信息 加锁.
        record = lockRecordWriteMapper.queryLockRecordByIdForUpdate(record.getId());
        Stock stock = stockWriteMapper.queryStockByIdForUpdate(record.getStockId());

        //3. 判断是否可以释放锁库存记录
        int releaseNum = requestModel.getStockNum();
        canReleaseStockRecord(record, releaseNum);
        canReleaseStock(stock);

        //4. 计算库存数量.
        computeLockRecordNum(record, releaseNum);
        computeStockNum(stock, releaseNum);

        //5. 更新库存记录.
        lockRecordWriteMapper.updateLockRecordNum(record.getId(), record.getLockNum());
        stockWriteMapper.updateStockNum(stock.getId(), stock.getUsedNum(), stock.getRemainNum());
    }

    /**
     * 根据锁库存记录判断是否可以释放库存
     * @param record
     * @param releaseNum
     */
    private void canReleaseStockRecord(LockRecord record, int releaseNum) {
        if (record.getLockNum() < releaseNum) {
            throw new ReleaseNumException(StockExceptionCode.RELEASE_STOCK_NUM_ERR_MSG);
        }
    }

    /**
     * 判断库存可被释放.
     * @param stock
     */
    private void canReleaseStock(Stock stock) {
        if (null == stock) {
            throw new NotFoundStockException(StockExceptionCode.NOT_FOUND_STOCK_ERR_MSG);
        }

        int state = stock.getState();
        if (state != StockStateEnum.AVAILABLE.getState()) {
            throw new StockStateException(StockExceptionCode.STOCK_STATE_ERR_MSG);
        }

        StockRule stockRule = stockRuleReadMapper.queryRuleValidateStockById(stock.getRuleId());
        if (null == stockRule) {
            throw new NotFoundStockRuleException(StockRuleExceptionCode.NOT_FOUND_STOCK_RULE_ERR_MSG);
        }

        int ruleType = stockRule.getType() == null ? 0 : stockRule.getType();
        int isNeedReturn = stockRule.getWhetherReturn() == null ? 0 : stockRule.getWhetherReturn();
        if (ruleType == StockRuleTypeEnum.SINGLE.getRuleType() && isNeedReturn == StockReturnTypeEnum.NOT_NEED_RETURN.getReturnType()) {
            throw new StockReturnTypeException(StockRuleExceptionCode.RETURN_TYPE_ERR_MSG);
        }

    }

    /**
     * 计算锁库存记录.
     * @param record
     * @param releaseNum
     */
    private void computeLockRecordNum(LockRecord record, int releaseNum) {
        record.setLockNum(record.getLockNum() - releaseNum);
    }

    /**
     * 计算库存数量.
     * @param stock
     * @param releaseNum
     */
    private void computeStockNum(Stock stock, int releaseNum) {
        stock.setUsedNum(stock.getUsedNum() - releaseNum);
        stock.setRemainNum(stock.getRemainNum() + releaseNum);
    }

}
