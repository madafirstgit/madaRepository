package com.pzj.regulation.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.pzj.base.common.BaseVO;

public class StrategySettlementRule extends BaseVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4654357676389892341L;

    /** 产品id */
    private Long productId;
    /** 政策id */
    private Long strategyId;
    /**
     * 未满减结算规则类型 <h> 常量设置：StrategyGlobalDict.notTotalSettlement() 减少结算金额 2</h>
     */
    private Integer notTotalSettlementType;
    /** 减少结算金额 */
    private Double reduceSettlementMoney;
    /** 联票：主票id */
    private Long parentProductId;

    /** 删除标记：删除 */
    private Integer delFlag;
    /** 创建供应商 */
    private Long supplierId;

    /**
     * 标记位更新实体，是否将字段值为NULL的数据更新到数据库
     */
    private Boolean isNeedUpdateNull = false;

    /** 查询参数：主键集合 */
    private List<Long> queryIdList;

    /** 查询参数：政策主键集合 */
    private List<Long> queryStartegyIdList;

    /** 查询参数：产品主键集合 */
    private List<Long> queryProductIdList;

    /** 查询参数：主票主键集合 */
    private List<Long> queryParentProductIdList;

    /**
     * 获取产品id
     * 
     * @return productId 产品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     * 
     * @param productId
     *            产品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取政策id
     * 
     * @return strategyId 政策id
     */
    public Long getStrategyId() {
        return strategyId;
    }

    /**
     * 设置政策id
     * 
     * @param strategyId
     *            政策id
     */
    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    /**
     * 获取未满减结算规则类型<h>常量设置：StrategyGlobalDict.notTotalSettlement()减少结算金额2<h>
     * 
     * @return notTotalSettlementType
     *         未满减结算规则类型<h>常量设置：StrategyGlobalDict.notTotalSettlement
     *         ()减少结算金额2<h>
     */
    public Integer getNotTotalSettlementType() {
        return notTotalSettlementType;
    }

    /**
     * 设置未满减结算规则类型<h>常量设置：StrategyGlobalDict.notTotalSettlement()减少结算金额2<h>
     * 
     * @param notTotalSettlementType
     *            未满减结算规则类型<h>常量设置：StrategyGlobalDict.notTotalSettlement()
     *            减少结算金额2<h>
     */
    public void setNotTotalSettlementType(Integer notTotalSettlementType) {
        this.notTotalSettlementType = notTotalSettlementType;
    }

    /**
     * 获取减少结算金额
     * 
     * @return reduceSettlementMoney 减少结算金额
     */
    public Double getReduceSettlementMoney() {
        return reduceSettlementMoney;
    }

    /**
     * 设置减少结算金额
     * 
     * @param reduceSettlementMoney
     *            减少结算金额
     */
    public void setReduceSettlementMoney(Double reduceSettlementMoney) {
        this.reduceSettlementMoney = reduceSettlementMoney;
    }

    /**
     * 获取联票：主票id
     * 
     * @return parentProductId 联票：主票id
     */
    public Long getParentProductId() {
        return parentProductId;
    }

    /**
     * 设置联票：主票id
     * 
     * @param parentProductId
     *            联票：主票id
     */
    public void setParentProductId(Long parentProductId) {
        this.parentProductId = parentProductId;
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

    /**
     * 获取创建供应商
     * 
     * @return supplierId 创建供应商
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 设置创建供应商
     * 
     * @param supplierId
     *            创建供应商
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    /**
     * 获取标记位更新实体，是否将字段值为NULL的数据更新到数据库
     * 
     * @return isNeedUpdateNull 标记位更新实体，是否将字段值为NULL的数据更新到数据库
     */
    public Boolean getIsNeedUpdateNull() {
        return isNeedUpdateNull;
    }

    /**
     * 设置标记位更新实体，是否将字段值为NULL的数据更新到数据库
     * 
     * @param isNeedUpdateNull
     *            标记位更新实体，是否将字段值为NULL的数据更新到数据库
     */
    public void setIsNeedUpdateNull(Boolean isNeedUpdateNull) {
        this.isNeedUpdateNull = isNeedUpdateNull;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}
