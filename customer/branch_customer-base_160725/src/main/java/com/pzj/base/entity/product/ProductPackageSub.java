/*
 * ProductPackageSub.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.联票子票从
 * 
 * @author 票之家
 */

public class ProductPackageSub extends BaseEntity implements Serializable {

    /** 返利方式（1现金 2积分） */
    private Integer              rebateType;

    /** 关联景区数量 */
    private Integer              scenicCnt;

    /** 返利金额/积分 */
    private java.math.BigDecimal rebateSum;

    /** 积分类型 */
    private Integer              pointsType;

    /**  */
    private String               remarks;

    /** 联票子票id */
    private Long                 packageId;

    // /** 返利规则类型 1默认，2自定义 */
    // private Integer type;

    /** 关联的景区 */
    private List<ProductScenic>  scenicList;

    private String               supplierId;

    /** 设置 返利方式（1现金 2积分） */
    public void setRebateType(Integer rebateType) {
        this.rebateType = rebateType;
    }

    /** 得到 返利方式（1现金 2积分） */
    public Integer getRebateType() {
        return rebateType;
    }

    /** 设置 关联景区数量 */
    public void setScenicCnt(Integer scenicCnt) {
        this.scenicCnt = scenicCnt;
    }

    /** 得到 关联景区数量 */
    public Integer getScenicCnt() {
        return scenicCnt;
    }

    /** 设置 返利金额/积分 */
    public void setRebateSum(java.math.BigDecimal rebateSum) {
        this.rebateSum = rebateSum;
    }

    /** 得到 返利金额/积分 */
    public java.math.BigDecimal getRebateSum() {
        return rebateSum;
    }

    /** 设置 积分类型 */
    public void setPointsType(Integer pointsType) {
        this.pointsType = pointsType;
    }

    /** 得到 积分类型 */
    public Integer getPointsType() {
        return pointsType;
    }

    /** 设置 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /** 得到 */
    public String getRemarks() {
        return remarks;
    }

    /** 设置 联票子票id */
    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    /** 得到 联票子票id */
    public Long getPackageId() {
        return packageId;
    }

    public List<ProductScenic> getScenicList() {
        return scenicList;
    }

    public void setScenicList(List<ProductScenic> scenicList) {
        this.scenicList = scenicList;
    }

    // public Integer getType() {
    // return type;
    // }
    //
    // public void setType(Integer type) {
    // this.type = type;
    // }

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
        strBuff.append("rebateType:").append(this.getRebateType()).append(",");
        strBuff.append("scenicCnt:").append(this.getScenicCnt()).append(",");
        strBuff.append("rebateSum:").append(this.getRebateSum()).append(",");
        strBuff.append("pointsType:").append(this.getPointsType()).append(",");
        strBuff.append("remarks:").append(this.getRemarks()).append(",");
        strBuff.append("packageId:").append(this.getPackageId());
        strBuff.append("}");
        return strBuff.toString();
    }
}
