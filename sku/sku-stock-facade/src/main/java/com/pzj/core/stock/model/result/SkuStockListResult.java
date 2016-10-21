package com.pzj.core.stock.model.result;

import java.io.Serializable;
import java.util.ArrayList;

public class SkuStockListResult implements Serializable {
	
	/** 库存id*/
	private Long stockRuleId;
	
	/** 产品集合*/
	private ArrayList<SkuStockResult> skuList;

	public Long getStockRuleId() {
		return stockRuleId;
	}

	public void setStockRuleId(Long stockId) {
		this.stockRuleId = stockId;
	}

	public ArrayList<SkuStockResult> getSkuList() {
		return skuList;
	}

	public void setSkuList(ArrayList<SkuStockResult> skuList) {
		this.skuList = skuList;
	}

	
	
	

}
