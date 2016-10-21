/*
 * ProductRondaRelation.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.entity.product;


import java.io.Serializable;

import com.pzj.base.common.BaseEntity;
/**
 * vo.区域
 * @author 票之家
 */

public class ProductRondaRelation extends BaseEntity implements Serializable{
    /** 产品组id */
    private Long productInfoId;
    /** 产品id */
    private Long productId;
    /** 场次id */
    private Long rondaId;
    /** 场次名称 */
    private String rondaName;
    /** 区域id */
    private Long regionId;
    /** 区域名称 */
    private String regionName;
    /** 是否有效 */
    private Integer flag;
    /** 提供者id */
    private Long supplierId;
    /** 创建人 */
    private String createBy;
    /** 更新人 */
    private String updateBy;
    /** 创建时间 */
    private java.util.Date createDate;
    /** 更新时间 */
    private java.util.Date updateDate;
 
    /** 设置 产品组id */
    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    /** 得到 产品组id */
    public Long getProductInfoId() {
        return productInfoId;
    }
    /** 设置 产品id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 产品id */
    public Long getProductId() {
        return productId;
    }
    /** 设置 场次id */
    public void setRondaId(Long rondaId) {
        this.rondaId = rondaId;
    }

    /** 得到 场次id */
    public Long getRondaId() {
        return rondaId;
    }
    /** 设置 场次名称 */
    public void setRondaName(String rondaName) {
        this.rondaName = rondaName;
    }

    /** 得到 场次名称 */
    public String getRondaName() {
        return rondaName;
    }
    /** 设置 区域id */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /** 得到 区域id */
    public Long getRegionId() {
        return regionId;
    }
    /** 设置 区域名称 */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /** 得到 区域名称 */
    public String getRegionName() {
        return regionName;
    }
    /** 设置 是否有效 */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /** 得到 是否有效 */
    public Integer getFlag() {
        return flag;
    }
    /** 设置 提供者id */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 提供者id */
    public Long getSupplierId() {
        return supplierId;
    }
    /** 设置 创建人 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 创建人 */
    public String getCreateBy() {
        return createBy;
    }
    /** 设置 更新人 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 更新人 */
    public String getUpdateBy() {
        return updateBy;
    }
    /** 设置 创建时间 */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /** 得到 创建时间 */
    public java.util.Date getCreateDate() {
        return createDate;
    }
    /** 设置 更新时间 */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 更新时间 */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }


}
