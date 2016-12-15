/*
 * ProductPackage.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.联票子票
 * 
 * @author 票之家
 */

public class ProductPackage extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long       serialVersionUID = -8920357559140393841L;

    /** 子票名称 */
    private String                  name;

    /** 联票子票返利规则，所有规则都存到本字段中 */
    private String                  subRebateRule;

    /** 子票类型（1普通票 2积分票） */
    private Integer                 packageType;

    /** 状态（1启用0禁用2删除） */
    private Integer                 status;

    /**  */
    private String                  createBy;

    /**  */
    private java.util.Date          createDate;

    /**  */
    private String                  updateBy;

    /**  */
    private java.util.Date          updateDate;

    /** 产品id */
    private Long                    productId;

    private String                  supplierId;

    /** 关系集合 */
    private List<ProductRelation>   relList;

    /** 联票子票返利政策集合 */
    private List<ProductPackageSub> subList;

    /** 设置 子票名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 得到 子票名称 */
    public String getName() {
        return name;
    }

    /** 设置 联票子票返利规则，所有规则都存到本字段中 */
    public void setSubRebateRule(String subRebateRule) {
        this.subRebateRule = subRebateRule;
    }

    /** 得到 联票子票返利规则，所有规则都存到本字段中 */
    public String getSubRebateRule() {
        return subRebateRule;
    }

    /** 设置 子票类型（1普通票 2积分票） */
    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    /** 得到 子票类型（1普通票 2积分票） */
    public Integer getPackageType() {
        return packageType;
    }

    /** 设置 状态（1启用0禁用2删除） */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 得到 状态（1启用0禁用2删除） */
    public Integer getStatus() {
        return status;
    }

    /** 设置 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 */
    public String getCreateBy() {
        return createBy;
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
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 设置 */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /** 设置 产品id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 产品id */
    public Long getProductId() {
        return productId;
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public List<ProductRelation> getRelList() {
        return relList;
    }

    public void setRelList(List<ProductRelation> relList) {
        this.relList = relList;
    }

    public List<ProductPackageSub> getSubList() {
        return subList;
    }

    public void setSubList(List<ProductPackageSub> subList) {
        this.subList = subList;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("name:").append(this.getName()).append(",");
        strBuff.append("subRebateRule:").append(this.getSubRebateRule()).append(",");
        strBuff.append("packageType:").append(this.getPackageType()).append(",");
        strBuff.append("status:").append(this.getStatus()).append(",");
        strBuff.append("createBy:").append(this.getCreateBy()).append(",");
        strBuff.append("createDate:").append(this.getCreateDate()).append(",");
        strBuff.append("updateBy:").append(this.getUpdateBy()).append(",");
        strBuff.append("updateDate:").append(this.getUpdateDate()).append(",");
        strBuff.append("productId:").append(this.getProductId());
        strBuff.append("supplierId:").append(this.getSupplierId());
        strBuff.append("}");
        return strBuff.toString();
    }
}
