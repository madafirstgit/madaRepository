package com.pzj.base.sku.entity;

import java.util.Date;

public class XzSkuPriceEvent {

    private Integer id;

    private Integer bossid;

    private String eventName;

    private String eventType;

    private String priceType;

    private Date startDate;

    private Date endDate;

    private Integer applicableDays;

    private String applicableTime;

    private String dynamicPriceType;

    private String dynamicPriceValue;

    private Integer ruleset;

    private Boolean inventoryStatus;

    private String recurrence;

    private Boolean applyAll;
    //存储计算后的价格
    private Double price;
    //存储权重信息
    private Integer weight;
    
    private XzSkuPriceEventApplyTo applyTo;

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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType == null ? null : priceType.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getApplicableDays() {
        return applicableDays;
    }

    public void setApplicableDays(Integer applicableDays) {
        this.applicableDays = applicableDays;
    }

    public String getApplicableTime() {
        return applicableTime;
    }

    public void setApplicableTime(String applicableTime) {
        this.applicableTime = applicableTime == null ? null : applicableTime.trim();
    }

    public String getDynamicPriceType() {
        return dynamicPriceType;
    }

    public void setDynamicPriceType(String dynamicPriceType) {
        this.dynamicPriceType = dynamicPriceType == null ? null : dynamicPriceType.trim();
    }

    public String getDynamicPriceValue() {
        return dynamicPriceValue;
    }

    public void setDynamicPriceValue(String dynamicPriceValue) {
        this.dynamicPriceValue = dynamicPriceValue == null ? null : dynamicPriceValue.trim();
    }

    public Integer getRuleset() {
        return ruleset;
    }

    public void setRuleset(Integer ruleset) {
        this.ruleset = ruleset;
    }

    public Boolean getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(Boolean inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence == null ? null : recurrence.trim();
    }

    public Boolean getApplyAll() {
        return applyAll;
    }

    public void setApplyAll(Boolean applyAll) {
        this.applyAll = applyAll;
    }

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public XzSkuPriceEventApplyTo getApplyTo() {
		return applyTo;
	}

	public void setApplyTo(XzSkuPriceEventApplyTo applyTo) {
		this.applyTo = applyTo;
	}
	
	@Override
	public String toString() {
		return "XzSkuPriceEvent [id=" + id + ", bossid=" + bossid + ", eventName=" + eventName + ", eventType="
				+ eventType + ", priceType=" + priceType + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", applicableDays=" + applicableDays + ", applicableTime=" + applicableTime + ", dynamicPriceType="
				+ dynamicPriceType + ", dynamicPriceValue=" + dynamicPriceValue + ", ruleset=" + ruleset
				+ ", inventoryStatus=" + inventoryStatus + ", recurrence=" + recurrence + ", applyAll=" + applyAll
				+ ", price=" + price + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		XzSkuPriceEvent s = (XzSkuPriceEvent)obj;
		return this.toString().equals(s.toString());
	}
}