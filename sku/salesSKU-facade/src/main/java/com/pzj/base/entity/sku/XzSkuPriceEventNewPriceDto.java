package com.pzj.base.entity.sku;

import java.io.Serializable;
import java.math.BigDecimal;

public class XzSkuPriceEventNewPriceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private Integer eventId;

    private Integer paramsId;

    private BigDecimal eventPrice;

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

    public Integer getParamsId() {
        return paramsId;
    }

    public void setParamsId(Integer paramsId) {
        this.paramsId = paramsId;
    }

    public BigDecimal getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(BigDecimal eventPrice) {
        this.eventPrice = eventPrice;
    }
}