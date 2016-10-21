package com.pzj.base.sku.entity;

public class XzSkuAllocationTimeslot {

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private Integer allocationId;

    private String startTime;

    private String endTime;

    private Integer dayOfWeek;
    //在转换时使用
    private XzSkuAllocation allocation;

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

    public Integer getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Integer allocationId) {
        this.allocationId = allocationId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

	public XzSkuAllocation getAllocation() {
		return allocation;
	}

	public void setAllocation(XzSkuAllocation allocation) {
		this.allocation = allocation;
	}
}