package com.pzj.base.entity.product.query;

import java.util.List;

import com.pzj.base.entity.product.ProductStockRelation;

public class ProductStockRelationQuery extends ProductStockRelation {
	/**查询：产品id集合*/
	private List<Long> productIds;
	
	/**查询：产品组id集合*/
	private List<Long> productInfoIds;
	
	/**查询：库存id集合*/
	private List<Long> stockRuleIds;

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	

	public List<Long> getStockRuleIds() {
		return stockRuleIds;
	}

	public void setStockRuleIds(List<Long> stockRuleIds) {
		this.stockRuleIds = stockRuleIds;
	}

	public List<Long> getProductInfoIds() {
		return productInfoIds;
	}

	public void setProductInfoIds(List<Long> productInfoIds) {
		this.productInfoIds = productInfoIds;
	}
	
	

}
