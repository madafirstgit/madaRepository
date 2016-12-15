package com.hht.models;

import java.math.BigDecimal;
import java.util.Date;

public class BDish {

    private String id;

    private String dishCode;

    private String name;

    private String dishPy;

    private BigDecimal price;

    private String unit;

    private BigDecimal guidePrice;

    private String description;

    private String hotRate;

    private String isFree;

    private String isStopped;

    private String healthIndex;

    private String discountFlag;

    private String sourceInfo;

    private String dishClass;

    private String innerClass;

    private Long linkStoreDishid;

    private String amount;

    private String type;

    private String producingArea;

    private String provider;

    private String foodSafety;

    private String yyzs;

    private String shrq;

    private String bshrq;

    private String jggy;

    private String bigimageurl;

    private String mediumimageurl;

    private String smallimageurl;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode == null ? null : dishCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDishPy() {
        return dishPy;
    }

    public void setDishPy(String dishPy) {
        this.dishPy = dishPy == null ? null : dishPy.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getHotRate() {
        return hotRate;
    }

    public void setHotRate(String hotRate) {
        this.hotRate = hotRate == null ? null : hotRate.trim();
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree == null ? null : isFree.trim();
    }

    public String getIsStopped() {
        return isStopped;
    }

    public void setIsStopped(String isStopped) {
        this.isStopped = isStopped == null ? null : isStopped.trim();
    }

    public String getHealthIndex() {
        return healthIndex;
    }

    public void setHealthIndex(String healthIndex) {
        this.healthIndex = healthIndex == null ? null : healthIndex.trim();
    }

    public String getDiscountFlag() {
        return discountFlag;
    }

    public void setDiscountFlag(String discountFlag) {
        this.discountFlag = discountFlag == null ? null : discountFlag.trim();
    }

    public String getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(String sourceInfo) {
        this.sourceInfo = sourceInfo == null ? null : sourceInfo.trim();
    }

    public String getDishClass() {
        return dishClass;
    }

    public void setDishClass(String dishClass) {
        this.dishClass = dishClass == null ? null : dishClass.trim();
    }

    public String getInnerClass() {
        return innerClass;
    }

    public void setInnerClass(String innerClass) {
        this.innerClass = innerClass == null ? null : innerClass.trim();
    }

    public Long getLinkStoreDishid() {
        return linkStoreDishid;
    }

    public void setLinkStoreDishid(Long linkStoreDishid) {
        this.linkStoreDishid = linkStoreDishid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea == null ? null : producingArea.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getFoodSafety() {
        return foodSafety;
    }

    public void setFoodSafety(String foodSafety) {
        this.foodSafety = foodSafety == null ? null : foodSafety.trim();
    }

    public String getYyzs() {
        return yyzs;
    }

    public void setYyzs(String yyzs) {
        this.yyzs = yyzs == null ? null : yyzs.trim();
    }

    public String getShrq() {
        return shrq;
    }

    public void setShrq(String shrq) {
        this.shrq = shrq == null ? null : shrq.trim();
    }

    public String getBshrq() {
        return bshrq;
    }

    public void setBshrq(String bshrq) {
        this.bshrq = bshrq == null ? null : bshrq.trim();
    }

    public String getJggy() {
        return jggy;
    }

    public void setJggy(String jggy) {
        this.jggy = jggy == null ? null : jggy.trim();
    }

    public String getBigimageurl() {
        return bigimageurl;
    }

    public void setBigimageurl(String bigimageurl) {
        this.bigimageurl = bigimageurl == null ? null : bigimageurl.trim();
    }

    public String getMediumimageurl() {
        return mediumimageurl;
    }

    public void setMediumimageurl(String mediumimageurl) {
        this.mediumimageurl = mediumimageurl == null ? null : mediumimageurl.trim();
    }

    public String getSmallimageurl() {
        return smallimageurl;
    }

    public void setSmallimageurl(String smallimageurl) {
        this.smallimageurl = smallimageurl == null ? null : smallimageurl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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