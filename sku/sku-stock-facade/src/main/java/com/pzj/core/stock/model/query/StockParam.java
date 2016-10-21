package com.pzj.core.stock.model.query;

import java.io.Serializable;

public class StockParam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1573588724703764829L;
	
	/**库存规则id*/
	private Long stockRuleId;


	public Long getStockRuleId() {
		return stockRuleId;
	}

	public void setStockRuleId(Long stockRuleId) {
		this.stockRuleId = stockRuleId;
	}
	public boolean isIllegalParam(){
		return stockRuleId == null || stockRuleId < 1;
	}
	
	
}
