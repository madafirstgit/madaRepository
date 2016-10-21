/*
 * ScenicRelation.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-10-23 created
 */
package com.pzj.base.entity.product;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * 景区关系表 票之家公司 ----------------------* 2015-10-23created
 */
public class ProductScenicRelation extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 707175851183355443L;

    /**
     * 景区id
     */
    private Long              scenicId;

    /**
     * 关联对象id
     */
    private Long              relId;

    /**
     * 关联对象类型
     */
    private String            relType;

    /**
     * 景区名称,处理加点返利关联景区时用到
     */
    private String            scenicName;

    /**
     * 关联对象名称,处理加点返利关联景区时用到
     */
    private String            relationName;

    private String            supplierId;
    /** 期望关联供应商id */
    private String            targetSupplierId;

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getTargetSupplierId() {
        return targetSupplierId;
    }

    public void setTargetSupplierId(String targetSupplierId) {
        this.targetSupplierId = targetSupplierId;
    }

}