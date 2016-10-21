/*
 * ProductPriceRule.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.entity.product.pms;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.区域
 * 
 * @author 票之家
 */

public class ProductPriceRule extends BaseEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8363747564671867255L;
    /** 优先级 */
    private Integer           priority;
    /**
     * 政策价格类型（1平日价 2周末价 3节日价） 常量设置： GlobalDict.PmsProductDict 1 平日价
     * usualPriceType() 2 周末价 weekPriceType() 3 节日价 holidayPriceType()
     * */
    private String            type;
    /** 节日开始时间 */
    private Date              startDate;
    /** 节日结束时间 */
    private Date              endDate;
    /** 周 */
    private Integer           weekday;
    /** 挂牌价 */
    private Double            marketPrice;
    /** 政策主键Id */
    private Long              productId;
    /** 创建供应商id */
    private String            supplierId;
    /** 卖价 */
    private Double            retailPrice;
    /** 固定佣金比例 */
    private Double            mfPrice;

    /** 创建人 */
    private String            createBy;
    /**
     * 创建时间
     */
    private Date              createDate;

    /** 最新更新人 */
    private String            updateBy;
    /**
     * 修改时间
     */
    private Date              updateDate;

    /** 状态（1启用 0停用 默认启用1） */
    private Integer           flag;

    /**
     * 查询参数：违约金规则主键集合
     */
    private List<Long>        queryIdList;

    /**
     * 查询参数：房型主键集合
     */
    private List<Long>        queryParentIdList;

    /** 设置 优先级 */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /** 得到 优先级 */
    public Integer getPriority() {
        return priority;
    }

    /** 设置 政策价格类型（1平日价 2周末价 3节日价） */
    public void setType(String type) {
        this.type = type;
    }

    /** 得到 政策价格类型（1平日价 2周末价 3节日价） */
    public String getType() {
        return type;
    }

    /** 设置 节日开始时间 */
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    /** 得到 节日开始时间 */
    public java.util.Date getStartDate() {
        return startDate;
    }

    /** 设置 节日结束时间 */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    /** 得到 节日结束时间 */
    public java.util.Date getEndDate() {
        return endDate;
    }

    /** 设置 周 */
    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    /** 得到 周 */
    public Integer getWeekday() {
        return weekday;
    }

    /**
     * 获取挂牌价
     * 
     * @return marketPrice 挂牌价
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * 设置挂牌价
     * 
     * @param marketPrice
     *            挂牌价
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 获取政策主键Id
     * 
     * @return productId 政策主键Id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置政策主键Id
     * 
     * @param productId
     *            政策主键Id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 设置 创建供应商id */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 创建供应商id */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * 获取卖价
     * 
     * @return retailPrice 卖价
     */
    public Double getRetailPrice() {
        return retailPrice;
    }

    /**
     * 设置卖价
     * 
     * @param retailPrice
     *            卖价
     */
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获取固定佣金比例
     * 
     * @return mfPrice 固定佣金比例
     */
    public Double getMfPrice() {
        return mfPrice;
    }

    /**
     * 设置固定佣金比例
     * 
     * @param mfPrice
     *            固定佣金比例
     */
    public void setMfPrice(Double mfPrice) {
        this.mfPrice = mfPrice;
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

    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("priority:").append(this.getPriority()).append(",");
        strBuff.append("type:").append(this.getType()).append(",");
        strBuff.append("startDate:").append(this.getStartDate()).append(",");
        strBuff.append("endDate:").append(this.getEndDate()).append(",");
        strBuff.append("weekday:").append(this.getWeekday()).append(",");
        strBuff.append("marketPrice:").append(this.getMarketPrice()).append(",");
        strBuff.append("productId:").append(this.getProductId()).append(",");
        strBuff.append("supplierId:").append(this.getSupplierId()).append(",");
        strBuff.append("retailPrice:").append(this.getRetailPrice()).append(",");
        strBuff.append("mfPrice:").append(this.getMfPrice());
        strBuff.append("}");
        return strBuff.toString();
    }
}
