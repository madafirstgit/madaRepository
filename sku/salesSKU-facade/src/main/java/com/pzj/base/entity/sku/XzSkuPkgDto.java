package com.pzj.base.entity.sku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class XzSkuPkgDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private String skuTitle;

    private String packageType;

    private Integer packageSkuId;

    private Integer packagePricePercentage;

    private String packageInType;

    private List<XzSkuPkgAttrMappingDto> xzSkuPkgAttrMappingDtos;

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

    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
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

    public List<XzSkuPkgAttrMappingDto> getXzSkuPkgAttrMappingDtos() {
        return xzSkuPkgAttrMappingDtos;
    }

    public void setXzSkuPkgAttrMappingDtos(List<XzSkuPkgAttrMappingDto> xzSkuPkgAttrMappingDtos) {
        this.xzSkuPkgAttrMappingDtos = xzSkuPkgAttrMappingDtos;
    }
}