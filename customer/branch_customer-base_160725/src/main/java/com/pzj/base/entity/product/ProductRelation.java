/*
 * ProductRelation.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-10-13 created
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * 产品关系表 票之家公司 ----------------------* 2015-10-13created
 */
public class ProductRelation extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3610661645886850227L;

    /**
     * 对象id
     */
    private Long              objId;

    /**
     * 对象id集合，扩展属性，不持久化，用于查询
     */
    private List<Long>        objIds;

    /**
     * 关联对象id集合，扩展属性，不持久化，用于查询
     */
    private List<Long>        relIds;

    /**
     * 关联id
     */
    private Long              relId;

    /**
     * 关联类型
     */
    private String            relType;

    /**
     * 对象类型
     */
    private String            objType;

    private String            createBy;

    private Date              createDate;

    private String            updateBy;

    private Date              updateDate;

    /**
     * 排序
     */
    private Integer           sort;

    /**
     * 使用状态1启用0禁用2删除
     */
    private String            flag;

    /**
     * 一组数据标识
     */
    private String            groupCode;

    /**
     * 字段信息
     */
    private String            remarks;

    private String            supplierId;

    public ProductRelation() {
        super();
    }

    /** 对象id */
    public Long getObjId() {
        return objId;
    }

    /** 对象id */
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    /** 对象id集合，扩展属性，不持久化，用于查询 */
    public List<Long> getObjIds() {
        return objIds;
    }

    /** 对象id集合，扩展属性，不持久化，用于查询 */
    public void setObjIds(List<Long> objIds) {
        this.objIds = objIds;
    }

    /** 关联id */
    public Long getRelId() {
        return relId;
    }

    /** 关联id */
    public void setRelId(Long relId) {
        this.relId = relId;
    }

    /** 关联类型 */
    public String getRelType() {
        return relType;
    }

    /** 关联类型 */
    public void setRelType(String relType) {
        this.relType = relType;
    }

    /** 对象类型 */
    public String getObjType() {
        return objType;
    }

    /** 对象类型 */
    public void setObjType(String objType) {
        this.objType = objType;
    }

    /** createBy */
    public String getCreateBy() {
        return createBy;
    }

    /** createBy */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** createDate */
    public Date getCreateDate() {
        return createDate;
    }

    /** createDate */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /** updateBy */
    public String getUpdateBy() {
        return updateBy;
    }

    /** updateBy */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** updateDate */
    public Date getUpdateDate() {
        return updateDate;
    }

    /** updateDate */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 排序 */
    public Integer getSort() {
        return sort;
    }

    /** 排序 */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /** 使用状态1启用0禁用2删除 */
    public String getFlag() {
        return flag;
    }

    /** 使用状态1启用0禁用2删除 */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /** 一组数据标识 */
    public String getGroupCode() {
        return groupCode;
    }

    /** 一组数据标识 */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /** 字段信息 */
    public String getRemarks() {
        return remarks;
    }

    /** 字段信息 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public List<Long> getRelIds() {
        return relIds;
    }

    public void setRelIds(List<Long> relIds) {
        this.relIds = relIds;
    }

}