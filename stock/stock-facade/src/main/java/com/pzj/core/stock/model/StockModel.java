/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 库存VO
 * 
 * @author dongchunfu
 * @version $Id: StockModel.java, v 0.1 2016年8月2日 上午11:28:34 dongchunfu Exp $
 */
public class StockModel implements Serializable {
    private static Logger     logger           = LoggerFactory.getLogger(StockModel.class);

    private static final long serialVersionUID = -8009898135291739306L;

    /**
     * 库存主键id
     */
    private Long              id;
    /** 
     * 库存规则主键id 
     */
    private Long              ruleId;
    /** 
     * 库存状态（1 正常 2 停用，默认为1） 
     */
    private Integer           state;
    /** 
     * 库存时间 
     */
    private Integer           stockTime;
    /**
     * 库存时间（日期格式）
     */
    private Date              stockDate;
    /** 
     * 库存总数 
     */
    private Integer           totalNum;
    /** 
     * 已用库存数量 
     */
    private Integer           usedNum;
    /** 
     * 剩余库存数 
     */
    private Integer           remainNum;
    /** 
     * 创建时间 
     */
    private Date              createTime;
    /**
     * 更新时间 
     */
    private Date              updateTime;

    /**
     * 辅助查询
     */
    /** 
     * 开始时间（含） 
     */
    private Integer           beginTime;
    /** 
     * 结束时间（含） 
     */
    private Integer           endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStockTime() {
        return stockTime;
    }

    public void setStockTime(Integer stockTime) {
        this.stockTime = stockTime;
        try {
            if (this.stockTime > 0) {
                this.setStockDate(CommonUtils.IntegerConvertDate(stockTime));
            }
        } catch (ParseException e) {
            logger.error("---库存整型日期转日期格式异常-------", e);
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG);
        }
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getUsedNum() {
        return usedNum;
    }

    public void setUsedNum(Integer usedNum) {
        this.usedNum = usedNum;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    @Override
    public String toString() {
        return "StockModel [id=" + id + ", ruleId=" + ruleId + ", state=" + state + ", stockTime=" + stockTime + ", stockDate=" + stockDate + ", totalNum="
               + totalNum + ", usedNum=" + usedNum + ", remainNum=" + remainNum + ", createTime=" + createTime + ", updateTime=" + updateTime + ", beginTime="
               + beginTime + ", endTime=" + endTime + "]";
    }

}