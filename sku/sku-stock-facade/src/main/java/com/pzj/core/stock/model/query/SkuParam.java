package com.pzj.core.stock.model.query;

import java.io.Serializable;

public class SkuParam implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4211004608279097590L;
	/** 产品id*/
	private Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	

}
