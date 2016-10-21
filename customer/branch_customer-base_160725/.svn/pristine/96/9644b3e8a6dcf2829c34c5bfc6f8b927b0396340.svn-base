/*
 * ProductPenalty.java
 
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

public class ProductPenalty extends BaseEntity implements Serializable {
    /** 违约金类型（1：通用违约金 2：单产品违约金） */
    private Integer    category;
    /** 违约金取消类型（1.不可取消 2.限时取消 3免费取消） */
    private Integer    penaltyCancel;
    /** 违约金收取方式(1 收取首单 2 收取全单) */
    private Integer    penaltyCollectType;
    /** 限时取消：时间类型 */
    private String     cancelTimeType;
    /** 收取金额:暂不用 */
    private Double     penaltyCollectMoney;
    /** 单产品违约金关联的产品id */
    private Long       productId;
    /** 违约金所属供应商id */
    private Long       supplierId;

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

    /**
     * 查询参数：违约金规则主键集合
     */
    private List<Long> queryIdList;

    /**
     * 查询参数：房型主键集合
     */
    private List<Long> queryParentIdList;

    /** 设置 违约金类型（1：通用违约金 2：单产品违约金） */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /** 得到 违约金类型（1：通用违约金 2：单产品违约金） */
    public Integer getCategory() {
        return category;
    }

    /**
     * 获取违约金类型（1.不可取消2.限时取消3免费取消）
     * 
     * @return penaltyCancel 违约金类型（1.不可取消2.限时取消3免费取消）
     */
    public Integer getPenaltyCancel() {
        return penaltyCancel;
    }

    /**
     * 设置违约金类型（1.不可取消2.限时取消3免费取消）
     * 
     * @param penaltyCancel
     *            违约金类型（1.不可取消2.限时取消3免费取消）
     */
    public void setPenaltyCancel(Integer penaltyCancel) {
        this.penaltyCancel = penaltyCancel;
    }

    /** 设置 违约金收取方式(1 收取首单 2 收取全单) */
    public void setPenaltyCollectType(Integer penaltyCollectType) {
        this.penaltyCollectType = penaltyCollectType;
    }

    /** 得到 违约金收取方式(1 收取首单 2 收取全单) */
    public Integer getPenaltyCollectType() {
        return penaltyCollectType;
    }

    /**
     * 获取限时取消：时间类型
     * 
     * @return cancelTimeType 限时取消：时间类型
     */
    public String getCancelTimeType() {
        return cancelTimeType;
    }

    /**
     * 设置限时取消：时间类型
     * 
     * @param cancelTimeType
     *            限时取消：时间类型
     */
    public void setCancelTimeType(String cancelTimeType) {
        this.cancelTimeType = cancelTimeType;
    }

    /**
     * 获取收取金额:暂不用
     * 
     * @return penaltyCollectMoney 收取金额:暂不用
     */
    public Double getPenaltyCollectMoney() {
        return penaltyCollectMoney;
    }

    /**
     * 设置收取金额:暂不用
     * 
     * @param penaltyCollectMoney
     *            收取金额:暂不用
     */
    public void setPenaltyCollectMoney(Double penaltyCollectMoney) {
        this.penaltyCollectMoney = penaltyCollectMoney;
    }

    /** 设置 单产品违约金关联的产品id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 单产品违约金关联的产品id */
    public Long getProductId() {
        return productId;
    }

    /**
     * 获取查询参数：违约金规则主键集合
     * 
     * @return queryIdList 查询参数：违约金规则主键集合
     */
    public List<Long> getQueryIdList() {
        return queryIdList;
    }

    /**
     * 设置查询参数：违约金规则主键集合
     * 
     * @param queryIdList
     *            查询参数：违约金规则主键集合
     */
    public void setQueryIdList(List<Long> queryIdList) {
        this.queryIdList = queryIdList;
    }

    /**
     * 获取查询参数：房型主键集合
     * 
     * @return queryParentIdList 查询参数：房型主键集合
     */
    public List<Long> getQueryParentIdList() {
        return queryParentIdList;
    }

    /**
     * 设置查询参数：房型主键集合
     * 
     * @param queryParentIdList
     *            查询参数：房型主键集合
     */
    public void setQueryParentIdList(List<Long> queryParentIdList) {
        this.queryParentIdList = queryParentIdList;
    }

    /**
     * 获取违约金所属供应商id
     * 
     * @return supplierId 违约金所属供应商id
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 设置违约金所属供应商id
     * 
     * @param supplierId
     *            违约金所属供应商id
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("category:").append(this.getCategory()).append(",");
        strBuff.append("penaltyType:").append(this.getPenaltyCancel()).append(",");
        strBuff.append("penaltyCollectType:").append(this.getPenaltyCollectType()).append(",");
        strBuff.append("cancelTimeType:").append(this.getCancelTimeType()).append(",");
        strBuff.append("penaltyCollectMoney:").append(this.getPenaltyCollectMoney()).append(",");
        strBuff.append("productId:").append(this.getProductId());
        strBuff.append("}");
        return strBuff.toString();
    }
}
