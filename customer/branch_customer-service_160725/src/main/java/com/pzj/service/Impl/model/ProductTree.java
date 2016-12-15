package com.pzj.service.Impl.model;

import java.util.List;

public class ProductTree {
	private Long productId;

	private List<CPSCRelation> realtions;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<CPSCRelation> getRealtions() {
		return realtions;
	}

	public void setRealtions(List<CPSCRelation> realtions) {
		this.realtions = realtions;
	}

	

}
