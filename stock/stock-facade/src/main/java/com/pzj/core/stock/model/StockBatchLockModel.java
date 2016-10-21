/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.model;

import java.util.Map;

/**
 * 
 * @author Administrator
 * @version $Id: StockBatchLockModel.java, v 0.1 2016年7月28日 下午6:00:42 Administrator Exp $
 */
public class StockBatchLockModel implements java.io.Serializable {

    private static final long  serialVersionUID = -8845830128791513769L;
    /**
     * 操作库存的map对象，针对某个库存锁定或者释放库存数量
     */
    private Map<Long, Integer> operateStockMap;

    /**
     * 释放库存数量
     */
    private Integer            operateType;

    /**
     * 用户id
     */
    private Long               userId;

    public Map<Long, Integer> getOperateStockMap() {
        return operateStockMap;
    }

    public void setOperateStockMap(Map<Long, Integer> operateStockMap) {
        this.operateStockMap = operateStockMap;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "StockBatchLockModel [operateStockMap=" + operateStockMap + ", operateType=" + operateType + ", userId=" + userId + "]";
    }

}
