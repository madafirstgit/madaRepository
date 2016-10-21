package com.pzj.base.entity.sku;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class XzSkuPriceEventDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private String eventName;

    private String eventType;

    private String priceType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Integer applicableDays;

    private String applicableTime;

    private String dynamicPriceType;

    private String dynamicPriceValue;

    private Integer ruleset;

    private Boolean inventoryStatus;

    private String recurrence;

    private Boolean applyAll;

    private XzSkuPriceEventRulesDto xzSkuPriceEventRulesDto;

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

    public XzSkuPriceEventRulesDto getXzSkuPriceEventRulesDto() {
        return xzSkuPriceEventRulesDto;
    }

    public void setXzSkuPriceEventRulesDto(XzSkuPriceEventRulesDto xzSkuPriceEventRulesDto) {
        this.xzSkuPriceEventRulesDto = xzSkuPriceEventRulesDto;
    }
}