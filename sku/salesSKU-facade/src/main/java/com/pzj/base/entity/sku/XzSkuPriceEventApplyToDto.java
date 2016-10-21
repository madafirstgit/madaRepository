package com.pzj.base.entity.sku;

import java.io.Serializable;

public class XzSkuPriceEventApplyToDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private Integer eventId;

    private Integer targetId;

    private Integer applyToType;

    private XzSkuPriceEventDto xzSkuPriceEventDto;

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

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getApplyToType() {
        return applyToType;
    }

    public void setApplyToType(Integer applyToType) {
        this.applyToType = applyToType;
    }

    public XzSkuPriceEventDto getXzSkuPriceEventDto() {
        return xzSkuPriceEventDto;
    }

    public void setXzSkuPriceEventDto(XzSkuPriceEventDto xzSkuPriceEventDto) {
        this.xzSkuPriceEventDto = xzSkuPriceEventDto;
    }
}