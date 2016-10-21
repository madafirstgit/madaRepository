package com.pzj.base.sku.entity;

public class XzSkuPkg {

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private String skuTitle;

    private String packageType;

    private Integer packageSkuId;

    private Integer packagePricePercentage;

    private String packageInType;
    
    private Double price;
    private Double togetherPrice;
    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }

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

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType == null ? null : packageType.trim();
    }

    public Integer getPackageSkuId() {
        return packageSkuId;
    }

    public void setPackageSkuId(Integer packageSkuId) {
        this.packageSkuId = packageSkuId;
    }

    public Integer getPackagePricePercentage() {
        return packagePricePercentage;
    }

    public void setPackagePricePercentage(Integer packagePricePercentage) {
        this.packagePricePercentage = packagePricePercentage;
    }

    public String getPackageInType() {
        return packageInType;
    }

    public void setPackageInType(String packageInType) {
        this.packageInType = packageInType == null ? null : packageInType.trim();
    }

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTogetherPrice() {
		return togetherPrice;
	}

	public void setTogetherPrice(Double togetherPrice) {
		this.togetherPrice = togetherPrice;
	}
}