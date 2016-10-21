package com.pzj.base.entity.sku;

import java.io.Serializable;
import java.math.BigDecimal;

public class XzSkuPriceBaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private String bookingPriceType;

    private Integer skuParamsId;

    private BigDecimal price;

    private String bookingPriceUnit;

    private Short isGroup = 0;

    private Integer minNumber;

    private Integer maxNumber;

    private XzSkuAttrDto xzSkuAttrDto;

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

    public XzSkuAttrDto getXzSkuAttrDto() {
        return xzSkuAttrDto;
    }

    public void setXzSkuAttrDto(XzSkuAttrDto xzSkuAttrDto) {
        this.xzSkuAttrDto = xzSkuAttrDto;
    }
}