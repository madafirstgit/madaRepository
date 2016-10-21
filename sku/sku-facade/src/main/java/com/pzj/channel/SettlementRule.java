package com.pzj.channel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SettlementRule implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6379765846993691823L;

    private Long              id;
    /** 产品id */
    private Long              productId;
    /** 政策id */
    private Long              strategyId;
    /** 未满减结算规则类型 <h> 常量设置：StrategyGlobalDict.notTotalSettlement() 减少结算金额 2</h> */
    private Integer           notTotalSettlementType;
    /** 减少结算金额 */
    private Double            reduceSettlementMoney;
    /** 联票：主票id */
    private Long              parentProductId;
    /** 创建时间 */
    private Date              createDate;
    /** 创建人 */
    private String            createBy;
    /** 更新时间 */
    private Date              updateDate;
    /** 更新人 */
    private String            updateBy;
    /** 删除标记：删除 */
    private Integer           delFlag;
    /** 创建供应商 */
    private Long              supplierId;

    /** 查询参数：主键集合 */
    private List<Long>        queryIdList;

    /** 查询参数：政策主键集合 */
    private List<Long>        queryStartegyIdList;

    /** 查询参数：产品主键集合 */
    private List<Long>        queryProductIdList;

    /** 查询参数：主票主键集合 */
    private List<Long>        queryParentProductIdList;

    /** 设置 */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 */
    public Long getProductId() {
        return productId;
    }

    /** 设置 */
    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    /** 得到 */
    public Long getStrategyId() {
        return strategyId;
    }

    /** 设置 */
    public void setNotTotalSettlementType(Integer notTotalSettlementType) {
        this.notTotalSettlementType = notTotalSettlementType;
    }

    /** 得到 */
    public Integer getNotTotalSettlementType() {
        return notTotalSettlementType;
    }

    /**
     * 获取
     * 
     * @return reduceSettlementMoney
     */
    public Double getReduceSettlementMoney() {
        return reduceSettlementMoney;
    }

    /**
     * 设置
     * 
     * @param reduceSettlementMoney
     */
    public void setReduceSettlementMoney(Double reduceSettlementMoney) {
        this.reduceSettlementMoney = reduceSettlementMoney;
    }

    /** 设置 */
    public void setParentProductId(Long parentProductId) {
        this.parentProductId = parentProductId;
    }

    /** 得到 */
    public Long getParentProductId() {
        return parentProductId;
    }

    /** 设置 创建时间 */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /** 得到 创建时间 */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /** 设置 创建人 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 创建人 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置 更新时间 */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 更新时间 */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /** 设置 更新人 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 更新人 */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 获取删除标记：删除
     * 
     * @return delFlag 删除标记：删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记：删除
     * 
     * @param delFlag
     *            删除标记：删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /** 设置 创建供应商 */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 创建供应商 */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 获取查询参数：主键集合
     * 
     * @return queryIdList 查询参数：主键集合
     */
    public List<Long> getQueryIdList() {
        return queryIdList;
    }

    /**
     * 设置查询参数：主键集合
     * 
     * @param queryIdList
     *            查询参数：主键集合
     */
    public void setQueryIdList(List<Long> queryIdList) {
        this.queryIdList = queryIdList;
    }

    /**
     * 获取查询参数：政策主键集合
     * 
     * @return queryStartegyIdList 查询参数：政策主键集合
     */
    public List<Long> getQueryStartegyIdList() {
        return queryStartegyIdList;
    }

    /**
     * 设置查询参数：政策主键集合
     * 
     * @param queryStartegyIdList
     *            查询参数：政策主键集合
     */
    public void setQueryStartegyIdList(List<Long> queryStartegyIdList) {
        this.queryStartegyIdList = queryStartegyIdList;
    }

    /**
     * 获取查询参数：产品主键集合
     * 
     * @return queryProductIdList 查询参数：产品主键集合
     */
    public List<Long> getQueryProductIdList() {
        return queryProductIdList;
    }

    /**
     * 设置查询参数：产品主键集合
     * 
     * @param queryProductIdList
     *            查询参数：产品主键集合
     */
    public void setQueryProductIdList(List<Long> queryProductIdList) {
        this.queryProductIdList = queryProductIdList;
    }

    /**
     * 获取查询参数：主票主键集合
     * 
     * @return queryParentProductIdList 查询参数：主票主键集合
     */
    public List<Long> getQueryParentProductIdList() {
        return queryParentProductIdList;
    }

    /**
     * 设置查询参数：主票主键集合
     * 
     * @param queryParentProductIdList
     *            查询参数：主票主键集合
     */
    public void setQueryParentProductIdList(List<Long> queryParentProductIdList) {
        this.queryParentProductIdList = queryParentProductIdList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
