package com.pzj.base.entity.sku;

import java.io.Serializable;

public class XzSkuAttrApplyToDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private Integer skuAttrId;

    private Integer minNum;

    private Integer maxNum;

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

    public Integer getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(Integer skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    public Integer getMinNum() {
        return minNum;
    }

    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public XzSkuAttrDto getXzSkuAttrDto() {
        return xzSkuAttrDto;
    }

    public void setXzSkuAttrDto(XzSkuAttrDto xzSkuAttrDto) {
        this.xzSkuAttrDto = xzSkuAttrDto;
    }
}