package com.hht.models;

import java.util.Date;

public class BShopVersion {

    private String id;

    private String tenantId;

    private String shopId;

    private String businessVersion;

    private Integer dishVersion;

    private Integer tasteVersion;

    private Integer cookVersion;

    private Integer discountVersion;

    private Integer payTypeVersion;

    private Integer tableVersion;

    private Integer accountVersion;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getBusinessVersion() {
        return businessVersion;
    }

    public void setBusinessVersion(String businessVersion) {
        this.businessVersion = businessVersion == null ? null : businessVersion.trim();
    }

    public Integer getDishVersion() {
        return dishVersion;
    }

    public void setDishVersion(Integer dishVersion) {
        this.dishVersion = dishVersion;
    }

    public Integer getTasteVersion() {
        return tasteVersion;
    }

    public void setTasteVersion(Integer tasteVersion) {
        this.tasteVersion = tasteVersion;
    }

    public Integer getCookVersion() {
        return cookVersion;
    }

    public void setCookVersion(Integer cookVersion) {
        this.cookVersion = cookVersion;
    }

    public Integer getDiscountVersion() {
        return discountVersion;
    }

    public void setDiscountVersion(Integer discountVersion) {
        this.discountVersion = discountVersion;
    }

    public Integer getPayTypeVersion() {
        return payTypeVersion;
    }

    public void setPayTypeVersion(Integer payTypeVersion) {
        this.payTypeVersion = payTypeVersion;
    }

    public Integer getTableVersion() {
        return tableVersion;
    }

    public void setTableVersion(Integer tableVersion) {
        this.tableVersion = tableVersion;
    }

    public Integer getAccountVersion() {
        return accountVersion;
    }

    public void setAccountVersion(Integer accountVersion) {
        this.accountVersion = accountVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}