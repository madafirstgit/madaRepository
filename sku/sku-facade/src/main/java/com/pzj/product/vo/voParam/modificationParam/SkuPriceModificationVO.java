package com.pzj.product.vo.voParam.modificationParam;

import java.io.Serializable;

public class SkuPriceModificationVO implements Serializable{
	/**产品id*/
	private Long skuId;
	
	/**产品新价格*/
	private Double newPrice;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}
	
	

}
