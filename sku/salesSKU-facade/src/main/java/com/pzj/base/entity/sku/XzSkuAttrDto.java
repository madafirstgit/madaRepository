package com.pzj.base.entity.sku;

import java.io.Serializable;

public class XzSkuAttrDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer           id;

    private Integer           bossid;

    private Integer           defaultValue;

    private Boolean           hasPrice;

    private Boolean           isDisplayRange;

    private Boolean           isCtrlInventory;

    private Boolean           isRequired;

    private String            visibility;

    private XzSkuAttrI18nDto  xzSkuAttrI18nDto;

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

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(Boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public Boolean getIsDisplayRange() {
        return isDisplayRange;
    }

    public void setIsDisplayRange(Boolean isDisplayRange) {
        this.isDisplayRange = isDisplayRange;
    }

    public Boolean getIsCtrlInventory() {
        return isCtrlInventory;
    }

    public void setIsCtrlInventory(Boolean isCtrlInventory) {
        this.isCtrlInventory = isCtrlInventory;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility == null ? null : visibility.trim();
    }

    public XzSkuAttrI18nDto getXzSkuAttrI18nDto() {
        return xzSkuAttrI18nDto;
    }

    public void setXzSkuAttrI18nDto(XzSkuAttrI18nDto xzSkuAttrI18nDto) {
        this.xzSkuAttrI18nDto = xzSkuAttrI18nDto;
    }
}