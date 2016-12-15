/*
 * ProductBed.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.entity.product.pms;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.$ENTITY_NOTE$
 * 
 * @author 票之家
 */

public class ProductBed extends BaseEntity implements Serializable {
    /** 房型主键Id */
    private Long       productReleaseId;
    /** 床类型 */
    private String     bedType;
    /** 床数量 */
    private Integer    bedNums;
    /** 床规格 */
    private String     bedSizes;

    /** 创建人 */
    private String     createBy;
    /**
     * 创建时间
     */
    private Date       createDate;

    /** 最新更新人 */
    private String     updateBy;
    /**
     * 修改时间
     */
    private Date       updateDate;

    /** 状态（1启用 0停用 默认启用1） */
    private Integer    flag;

    /** 供应商Id */
    private Long       supplierId;

    /**
     * 查询参数:主键集合
     */
    private List<Long> queryIdList;

    /**
     * 查询参数：房型主键集合
     */
    private List<Long> queryParentIdList;

    /** 设置 房型主键Id */
    public void setProductReleaseId(Long productReleaseId) {
        this.productReleaseId = productReleaseId;
    }

    /** 得到 房型主键Id */
    public Long getProductReleaseId() {
        return productReleaseId;
    }

    /**
     * 获取床类型
     * 
     * @return bedType 床类型
     */
    public String getBedType() {
        return bedType;
    }

    /**
     * 设置床类型
     * 
     * @param bedType
     *            床类型
     */
    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    /** 设置 床数量 */
    public void setBedNums(Integer bedNums) {
        this.bedNums = bedNums;
    }

    /** 得到 床数量 */
    public Integer getBedNums() {
        return bedNums;
    }

    /** 设置 床规格 */
    public void setBedSizes(String bedSizes) {
        this.bedSizes = bedSizes;
    }

    /** 得到 床规格 */
    public String getBedSizes() {
        return bedSizes;
    }

    /**
     * 获取创建人
     * 
     * @return createBy 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     * 
     * @param createBy
     *            创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     * 
     * @return createDate 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     * 
     * @param createDate
     *            创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取最新更新人
     * 
     * @return updateBy 最新更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置最新更新人
     * 
     * @param updateBy
     *            最新更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取修改时间
     * 
     * @return updateDate 修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改时间
     * 
     * @param updateDate
     *            修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取状态（1启用0停用默认启用1）
     * 
     * @return flag 状态（1启用0停用默认启用1）
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置状态（1启用0停用默认启用1）
     * 
     * @param flag
     *            状态（1启用0停用默认启用1）
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取供应商Id
     * 
     * @return supplierId 供应商Id
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 设置供应商Id
     * 
     * @param supplierId
     *            供应商Id
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 获取查询参数:主键集合
     * 
     * @return queryIdList 查询参数:主键集合
     */
    public List<Long> getQueryIdList() {
        return queryIdList;
    }

    /**
     * 设置查询参数:主键集合
     * 
     * @param queryIdList
     *            查询参数:主键集合
     */
    public void setQueryIdList(List<Long> queryIdList) {
        this.queryIdList = queryIdList;
    }

    /**
     * 获取查询参数：房型主键id集合
     * 
     * @return queryParentIdList 查询参数：房型主键id集合
     */
    public List<Long> getQueryParentIdList() {
        return queryParentIdList;
    }

    /**
     * 设置查询参数：房型主键id集合
     * 
     * @param queryParentIdList
     *            查询参数：房型主键id集合
     */
    public void setQueryParentIdList(List<Long> queryParentIdList) {
        this.queryParentIdList = queryParentIdList;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("productReleaseId:").append(this.getProductReleaseId()).append(",");
        strBuff.append("bedType:").append(this.getBedType()).append(",");
        strBuff.append("bedNums:").append(this.getBedNums()).append(",");
        strBuff.append("bedSizes:").append(this.getBedSizes());
        strBuff.append("}");
        return strBuff.toString();
    }
}
