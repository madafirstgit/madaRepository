package com.pzj.core.stock.model.query;

import java.io.Serializable;
import java.util.List;

public class StockListParam implements Serializable{
	
	/**
	 * 库存id集合
	 */
	private List<Long> stockRuleIdList;

	public List<Long> getStockIdList() {
		return stockRuleIdList;
	}

	public void setStockIdList(List<Long> stockIdList) {
		this.stockRuleIdList = stockIdList;
	}
	
	public boolean isIllegalParam(){
		return stockRuleIdList ==null || stockRuleIdList.isEmpty();
	}
	
	
	
	

}
