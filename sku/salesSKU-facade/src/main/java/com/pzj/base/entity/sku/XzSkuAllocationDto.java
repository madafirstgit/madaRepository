package com.pzj.base.entity.sku;

import java.io.Serializable;
import java.util.List;

public class XzSkuAllocationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private String allocation;

    private Integer fixedLength;

    private String fixedStartTime;

    private Integer defaultLength;

    private String unit;

    private String bookingDisplay;

    private Short showEndTimes;

    private Short showUnavailableSlots;

    private List<XzSkuAllocationTimeslotDto> xzSkuAllocationTimeslotDtos;

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

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation == null ? null : allocation.trim();
    }

    public Integer getFixedLength() {
        return fixedLength;
    }

    public void setFixedLength(Integer fixedLength) {
        this.fixedLength = fixedLength;
    }

    public String getFixedStartTime() {
        return fixedStartTime;
    }

    public void setFixedStartTime(String fixedStartTime) {
        this.fixedStartTime = fixedStartTime == null ? null : fixedStartTime.trim();
    }

    public Integer getDefaultLength() {
        return defaultLength;
    }

    public void setDefaultLength(Integer defaultLength) {
        this.defaultLength = defaultLength;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getBookingDisplay() {
        return bookingDisplay;
    }

    public void setBookingDisplay(String bookingDisplay) {
        this.bookingDisplay = bookingDisplay == null ? null : bookingDisplay.trim();
    }

    public Short getShowEndTimes() {
        return showEndTimes;
    }

    public void setShowEndTimes(Short showEndTimes) {
        this.showEndTimes = showEndTimes;
    }

    public Short getShowUnavailableSlots() {
        return showUnavailableSlots;
    }

    public void setShowUnavailableSlots(Short showUnavailableSlots) {
        this.showUnavailableSlots = showUnavailableSlots;
    }

    public List<XzSkuAllocationTimeslotDto> getXzSkuAllocationTimeslotDtos() {
        return xzSkuAllocationTimeslotDtos;
    }

    public void setXzSkuAllocationTimeslotDtos(List<XzSkuAllocationTimeslotDto> xzSkuAllocationTimeslotDtos) {
        this.xzSkuAllocationTimeslotDtos = xzSkuAllocationTimeslotDtos;
    }
}