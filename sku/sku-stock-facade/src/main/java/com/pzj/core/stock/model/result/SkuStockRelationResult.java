package com.pzj.core.stock.model.result;

import java.io.Serializable;

public class SkuStockRelationResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3664472523144615957L;
	
	/**产品id*/
	private Long productId;
	
	/**库存规则id*/
	private Long stockRuleId;
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getStockRuleId() {
		return stockRuleId;
	}

	public void setStockRuleId(Long stockRuleId) {
		this.stockRuleId = stockRuleId;
	}
	
	

}
