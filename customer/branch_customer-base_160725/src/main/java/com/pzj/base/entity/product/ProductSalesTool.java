/*
 * ProductSalesTool.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-30 created
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * 直销工具 票之家公司 ----------------------* 2015-09-30created
 */
public class ProductSalesTool extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8820131252180908062L;

    /**
     * 工具类型
     */
    private String            pDict;

    /**
     * 工具名称
     */
    private String            toolName;

    private List<String>      toolNames;

    /**
     * 微信用户
     */
    private Long              wechatUid;

    /**
     * 微信账户
     */
    private String            wechatAccount;

    /**
     * 账户密码
     */
    private String            wechatPasswd;

    /**
     * 自动售货机地址
     */
    private String            selfServiceAddress;

    /**
     * 自动售货机ip
     */
    private String            selfServiceIp;

    /**
     * 自动售货机key
     */
    private String            selfServiceKey;

    /**
     * 二维码地址
     */
    private String            dimensionCodeAddress;

    private String            createBy;

    private Date              createDate;

    private String            updateBy;

    private Date              updateDate;

    /**
     * 备注
     */
    private String            remarks;

    /**
     * 状态1启用0禁用2删除
     */
    private String            flag;

    private String            supplierId;

    private String            supplierName;

    public String getpDict() {
        return pDict;
    }

    public void setpDict(String pDict) {
        this.pDict = pDict;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName == null ? null : toolName.trim();
    }

    public Long getWechatUid() {
        return wechatUid;
    }

    public void setWechatUid(Long wechatUid) {
        this.wechatUid = wechatUid;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount == null ? null : wechatAccount.trim();
    }

    public String getWechatPasswd() {
        return wechatPasswd;
    }

    public void setWechatPasswd(String wechatPasswd) {
        this.wechatPasswd = wechatPasswd == null ? null : wechatPasswd.trim();
    }

    public String getSelfServiceAddress() {
        return selfServiceAddress;
    }

    public void setSelfServiceAddress(String selfServiceAddress) {
        this.selfServiceAddress = selfServiceAddress == null ? null : selfServiceAddress.trim();
    }

    public String getSelfServiceIp() {
        return selfServiceIp;
    }

    public void setSelfServiceIp(String selfServiceIp) {
        this.selfServiceIp = selfServiceIp == null ? null : selfServiceIp.trim();
    }

    public String getSelfServiceKey() {
        return selfServiceKey;
    }

    public void setSelfServiceKey(String selfServiceKey) {
        this.selfServiceKey = selfServiceKey == null ? null : selfServiceKey.trim();
    }

    public String getDimensionCodeAddress() {
        return dimensionCodeAddress;
    }

    public void setDimensionCodeAddress(String dimensionCodeAddress) {
        this.dimensionCodeAddress = dimensionCodeAddress == null ? null
            : dimensionCodeAddress.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<String> getToolNames() {
        return toolNames;
    }

    public void setToolNames(List<String> toolNames) {
        this.toolNames = toolNames;
    }

}