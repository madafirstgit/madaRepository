package com.pzj.base.sku.entity;

import java.util.ArrayList;
import java.util.List;

public class XzSkuAttr {

    private Integer id;

    private Integer bossid;

    private Integer defaultValue;

    private Boolean hasPrice;

    private Boolean isDisplayRange;

    private Boolean isCtrlInventory;

    private Boolean isRequired;

    private String visibility;
    
    //转换时使用
    private XzSkuAttrI18n i18n;
    
    private XzSkuPriceBase priceBase;
    
    private List<XzSkuPriceEvent> events;
    
    private List<XzSkuAttrApplyTo> applyTos = new ArrayList<XzSkuAttrApplyTo>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBossid() {
        return bossid;
    }

    public void setBossid(Integer bossid) {
        this.bossid = bossid;
    }

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(Boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public Boolean getIsDisplayRange() {
        return isDisplayRange;
    }

    public void setIsDisplayRange(Boolean isDisplayRange) {
        this.isDisplayRange = isDisplayRange;
    }

    public Boolean getIsCtrlInventory() {
        return isCtrlInventory;
    }

    public void setIsCtrlInventory(Boolean isCtrlInventory) {
        this.isCtrlInventory = isCtrlInventory;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility == null ? null : visibility.trim();
    }

	public XzSkuAttrI18n getI18n() {
		return i18n;
	}

	public void setI18n(XzSkuAttrI18n i18n) {
		this.i18n = i18n;
	}

	public XzSkuPriceBase getPriceBase() {
		return priceBase;
	}

	public void setPriceBase(XzSkuPriceBase priceBase) {
		this.priceBase = priceBase;
	}

	public List<XzSkuPriceEvent> getEvents() {
		return events;
	}

	public void setEvents(List<XzSkuPriceEvent> events) {
		this.events = events;
	}
	
	public List<XzSkuAttrApplyTo> getApplyTos() {
		return applyTos;
	}

	public void setApplyTos(List<XzSkuAttrApplyTo> applyTos) {
		this.applyTos = applyTos;
	}

	@Override
	public String toString() {
		return "XzSkuAttr [id=" + id + ", bossid=" + bossid + ", defaultValue=" + defaultValue + ", hasPrice="
				+ hasPrice + ", isDisplayRange=" + isDisplayRange + ", isCtrlInventory=" + isCtrlInventory
				+ ", isRequired=" + isRequired + ", visibility=" + visibility + "]";
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
	
}