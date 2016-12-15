/*
 * ProductRebateRule.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.product;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * vo.加点返产品
 * 
 * @author 票之家
 */

public class ProductRebateRule extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3083044741485072072L;

    /** 名称 */
    private String            name;

    /** 产品（子票）id */
    private Long              productId;

    /**  */
    private String            productName;

    /**  */
    private String            flag;

    /**  */
    private java.util.Date    createDate;

    /**  */
    private String            createBy;

    /** 期望配对书 */
    private Integer           matchCnt;

    /** 审核状态 */
    private String            auditStatus;

    private String            supplierId;

    /** 设置 名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 得到 名称 */
    public String getName() {
        return name;
    }

    /** 设置 产品（子票）id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 产品（子票）id */
    public Long getProductId() {
        return productId;
    }

    /** 设置 */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /** 得到 */
    public String getProductName() {
        return productName;
    }

    /** 设置 */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /** 得到 */
    public String getFlag() {
        return flag;
    }

    /** 设置 */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /** 得到 */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /** 设置 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置 期望配对书 */
    public void setMatchCnt(Integer matchCnt) {
        this.matchCnt = matchCnt;
    }

    /** 得到 期望配对书 */
    public Integer getMatchCnt() {
        return matchCnt;
    }

    /** 设置 审核状态 */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    /** 得到 审核状态 */
    public String getAuditStatus() {
        return auditStatus;
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("name:").append(this.getName()).append(",");
        strBuff.append("productId:").append(this.getProductId()).append(",");
        strBuff.append("productName:").append(this.getProductName()).append(",");
        strBuff.append("flag:").append(this.getFlag()).append(",");
        strBuff.append("createDate:").append(this.getCreateDate()).append(",");
        strBuff.append("createBy:").append(this.getCreateBy()).append(",");
        strBuff.append("matchCnt:").append(this.getMatchCnt()).append(",");
        strBuff.append("auditStatus:").append(this.getAuditStatus());
        strBuff.append("supplierId:").append(this.getSupplierId());
        strBuff.append("}");
        return strBuff.toString();
    }
}
