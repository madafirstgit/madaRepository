package com.pzj.base.sku.entity;

import java.math.BigDecimal;

public class XzSkuPriceBase {

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private String bookingPriceType;

    private Integer skuParamsId;

    private BigDecimal price;

    private String bookingPriceUnit;

    private Short isGroup;

    private Integer minNumber;

    private Integer maxNumber;

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

    public String getBookingPriceType() {
        return bookingPriceType;
    }

    public void setBookingPriceType(String bookingPriceType) {
        this.bookingPriceType = bookingPriceType == null ? null : bookingPriceType.trim();
    }

    public Integer getSkuParamsId() {
        return skuParamsId;
    }

    public void setSkuParamsId(Integer skuParamsId) {
        this.skuParamsId = skuParamsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBookingPriceUnit() {
        return bookingPriceUnit;
    }

    public void setBookingPriceUnit(String bookingPriceUnit) {
        this.bookingPriceUnit = bookingPriceUnit == null ? null : bookingPriceUnit.trim();
    }

    public Short getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Short isGroup) {
        this.isGroup = isGroup;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    @Override
	public String toString() {
		return "XzSkuPriceBase [id=" + id + ", bossid=" + bossid + ", skuId=" + skuId + ", bookingPriceType="
				+ bookingPriceType + ", skuParamsId=" + skuParamsId + ", price=" + price + ", bookingPriceUnit="
				+ bookingPriceUnit + ", isGroup=" + isGroup + ", minNumber=" + minNumber + ", maxNumber=" + maxNumber
				+ "]";
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