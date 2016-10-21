package com.pzj.base.entity.sku;

import java.io.Serializable;

public class XzSkuPkgAttrMappingDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private Integer packageId;

    private Integer skuAttrId;

    private Integer pkgSkuAttrId;

    private XzSkuPkgDto xzSkuPkgDto;

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

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(Integer skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    public Integer getPkgSkuAttrId() {
        return pkgSkuAttrId;
    }

    public void setPkgSkuAttrId(Integer pkgSkuAttrId) {
        this.pkgSkuAttrId = pkgSkuAttrId;
    }

    public XzSkuPkgDto getXzSkuPkgDto() {
        return xzSkuPkgDto;
    }

    public void setXzSkuPkgDto(XzSkuPkgDto xzSkuPkgDto) {
        this.xzSkuPkgDto = xzSkuPkgDto;
    }
}