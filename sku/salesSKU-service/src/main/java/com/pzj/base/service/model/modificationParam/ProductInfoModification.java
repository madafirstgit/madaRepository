package com.pzj.base.service.model.modificationParam;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRondaRelation;
import com.pzj.base.entity.product.ProductSiteRelation;

public class ProductInfoModification {
	private ProductInfo info;
	
	private List<ProductRelease> prList;
	
	private List<ProductCloseTimeslot> slotList;
	
	private List<Long> scenicList;
	
	private List<ProductSiteRelation> siteRelationList;
	
	private Map<ProductRelease, List<ProductRondaRelation>> rondaRelation;

	public ProductInfo getInfo() {
		return info;
	}

	public void setInfo(ProductInfo info) {
		this.info = info;
	}    

	public List<ProductRelease> getPrList() {
		return prList;
	}

	public void setPrList(List<ProductRelease> prList) {
		this.prList = prList;
	}

	public List<ProductCloseTimeslot> getSlotList() {
		return slotList;
	}

	public void setSlotList(List<ProductCloseTimeslot> slotList) {
		this.slotList = slotList;
	}

	public List<ProductSiteRelation> getSiteRelationList() {
		return siteRelationList;
	}

	public void setSiteRelationList(List<ProductSiteRelation> siteRelationList) {
		this.siteRelationList = siteRelationList;
	}

	public Map<ProductRelease, List<ProductRondaRelation>> getRondaRelation() {
		return rondaRelation;
	}

	public void setRondaRelation(
			Map<ProductRelease, List<ProductRondaRelation>> rondaRelation) {
		this.rondaRelation = rondaRelation;
	}

	public List<Long> getScenicList() {
		return scenicList;
	}

	public void setScenicList(List<Long> scenicList) {
		this.scenicList = scenicList;
	}
	  public String toString() {
	        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	    }

}
