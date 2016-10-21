package com.pzj.base.entity.sku;

import java.io.Serializable;

public class XzSkuDyncPropDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private Integer attrDefId;

    private String attrValue;

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

    public Integer getAttrDefId() {
        return attrDefId;
    }

    public void setAttrDefId(Integer attrDefId) {
        this.attrDefId = attrDefId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }
}