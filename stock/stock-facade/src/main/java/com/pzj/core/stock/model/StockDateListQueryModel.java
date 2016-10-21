/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.model;

import java.util.ArrayList;

/**
 * 
 * @author Administrator
 * @version $Id: StockDateListQueryModel.java, v 0.1 2016年8月29日 下午1:44:58 Administrator Exp $
 */
public class StockDateListQueryModel implements java.io.Serializable {

    private static final long serialVersionUID = 2796297496011689636L;

    private Long              stockRuleId;

    private ArrayList<String> stockTimeList;

    public Long getStockRuleId() {
        return stockRuleId;
    }

    public void setStockRuleId(Long stockRuleId) {
        this.stockRuleId = stockRuleId;
    }

    public ArrayList<String> getStockTimeList() {
        return stockTimeList;
    }

    public void setStockTimeList(ArrayList<String> stockTimeList) {
        this.stockTimeList = stockTimeList;
    }

}
