package com.pzj.base.service.model.queryResult;

import java.util.List;

import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;

public class Product {
	private ProductInfo info;
	
	private ProductRelease release;
	
	private List<ProductCloseTimeslot> slotList;

	public ProductInfo getInfo() {
		return info;
	}

	public void setInfo(ProductInfo info) {
		this.info = info;
	}

	public ProductRelease getRelease() {
		return release;
	}

	public void setRelease(ProductRelease release) {
		this.release = release;
	}

	public List<ProductCloseTimeslot> getSlotList() {
		return slotList;
	}

	public void setSlotList(List<ProductCloseTimeslot> slotList) {
		this.slotList = slotList;
	}
	
	

}
