/*
 * SysArea.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.product;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * vo.区域
 * 
 * @author 票之家
 */

public class SysArea extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1605050779178218387L;

    /** 父级编号 */
    private String            parentId;

    /** 所有父级编号 */
    private String            parentIds;

    /** 区域编码 */
    private String            code;

    /** 区域名称 */
    private String            name;

    /** 区域类型 */
    private String            type;

    /** 创建者 */
    private String            createBy;

    /** 创建时间 */
    private java.util.Date    createDate;

    /** 更新者 */
    private String            updateBy;

    /** 更新时间 */
    private java.util.Date    updateDate;

    /** 备注信息 */
    private String            remarks;

    /** 删除标记 */
    private String            delFlag;

    /** 设置 父级编号 */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /** 得到 父级编号 */
    public String getParentId() {
        return parentId;
    }

    /** 设置 所有父级编号 */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /** 得到 所有父级编号 */
    public String getParentIds() {
        return parentIds;
    }

    /** 设置 区域编码 */
    public void setCode(String code) {
        this.code = code;
    }

    /** 得到 区域编码 */
    public String getCode() {
        return code;
    }

    /** 设置 区域名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 得到 区域名称 */
    public String getName() {
        return name;
    }

    /** 设置 区域类型 */
    public void setType(String type) {
        this.type = type;
    }

    /** 得到 区域类型 */
    public String getType() {
        return type;
    }

    /** 设置 创建者 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 创建者 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置 创建时间 */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /** 得到 创建时间 */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /** 设置 更新者 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 更新者 */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 设置 更新时间 */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 更新时间 */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /** 设置 备注信息 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /** 得到 备注信息 */
    public String getRemarks() {
        return remarks;
    }

    /** 设置 删除标记 */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /** 得到 删除标记 */
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("parentId:").append(this.getParentId()).append(",");
        strBuff.append("parentIds:").append(this.getParentIds()).append(",");
        strBuff.append("code:").append(this.getCode()).append(",");
        strBuff.append("name:").append(this.getName()).append(",");
        strBuff.append("type:").append(this.getType()).append(",");
        strBuff.append("createBy:").append(this.getCreateBy()).append(",");
        strBuff.append("createDate:").append(this.getCreateDate()).append(",");
        strBuff.append("updateBy:").append(this.getUpdateBy()).append(",");
        strBuff.append("updateDate:").append(this.getUpdateDate()).append(",");
        strBuff.append("remarks:").append(this.getRemarks()).append(",");
        strBuff.append("delFlag:").append(this.getDelFlag());
        strBuff.append("}");
        return strBuff.toString();
    }
}
