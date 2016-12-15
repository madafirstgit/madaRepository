/*
 * SysStrategyRebate.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * vo.渠道返利规则V2
 * @author 票之家
 */

public class SysStrategyRebate extends BaseEntity implements Serializable {
    /** 政策id */
    private Long                 strategyId;
    /** 政策子表id */
    private Long                 strategyChildId;
    /** 产品ID（返利票种ID） */
    private Long                 productId;
    /** 返利对象返利对象(总社H、地接部门D、优先部门DH、导游G) */
    private String               rebateObject;
    /** 结算方式（1即时解冻，定时解冻，固定日期解冻） */
    private String               settlementType;
    /** 返利时间（天数，0为检票后解冻） */
    private String               rebateCycle;
    /** 返利周期单位（YEAR/QUARTER/MONTH/WEEK/DAY/CURRENT） */
    private String               rebateCycleUnit;
    /** 返利形式(0为现金返利，2返利积分) */
    private String               rebateType;
    /** 返利数量，和返利类型配合使用 */
    private java.math.BigDecimal rebateAmount;
    /** 积分规则id */
    private Long                 integralId;
    /** 规则状态（1：启动、 0 ：禁用   2: 删除）参照GlobalParam.FLAG */
    private Integer              status;
    /** 返利类型（1 前置， 2， 后置    默认2） */
    private Integer              type;
    /** 创建供应商 */
    private Long                 supplierId;
    /** 创建人 */
    private String               createBy;
    /** 创建时间 */
    private java.util.Date       createTime;
    /** 修改人 */
    private String               updateBy;
    /** 修改时间 */
    private java.util.Date       updateDate;
    /** 数据来源 */
    private String               dataSource;
    /** 是否存在加点返利(0否，1是) */
    private Integer              isExtraRebate;

    /** 设置 政策id */
    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    /** 得到 政策id */
    public Long getStrategyId() {
        return strategyId;
    }

    /** 设置 政策子表id */
    public void setStrategyChildId(Long strategyChildId) {
        this.strategyChildId = strategyChildId;
    }

    /** 得到 政策子表id */
    public Long getStrategyChildId() {
        return strategyChildId;
    }

    /** 设置 产品ID（返利票种ID） */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 产品ID（返利票种ID） */
    public Long getProductId() {
        return productId;
    }

    /** 设置 返利对象返利对象(总社H、地接部门D、优先部门DH、导游G) */
    public void setRebateObject(String rebateObject) {
        this.rebateObject = rebateObject;
    }

    /** 得到 返利对象返利对象(总社H、地接部门D、优先部门DH、导游G) */
    public String getRebateObject() {
        return rebateObject;
    }

    /** 设置 结算方式（1即时解冻，定时解冻，固定日期解冻） */
    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    /** 得到 结算方式（1即时解冻，定时解冻，固定日期解冻） */
    public String getSettlementType() {
        return settlementType;
    }

    /** 设置 返利时间（天数，0为检票后解冻） */
    public void setRebateCycle(String rebateCycle) {
        this.rebateCycle = rebateCycle;
    }

    /** 得到 返利时间（天数，0为检票后解冻） */
    public String getRebateCycle() {
        return rebateCycle;
    }

    /** 设置 返利周期单位（YEAR/QUARTER/MONTH/WEEK/DAY/CURRENT） */
    public void setRebateCycleUnit(String rebateCycleUnit) {
        this.rebateCycleUnit = rebateCycleUnit;
    }

    /** 得到 返利周期单位（YEAR/QUARTER/MONTH/WEEK/DAY/CURRENT） */
    public String getRebateCycleUnit() {
        return rebateCycleUnit;
    }

    /** 设置 返利形式(0为现金返利，2返利积分) */
    public void setRebateType(String rebateType) {
        this.rebateType = rebateType;
    }

    /** 得到 返利形式(0为现金返利，2返利积分) */
    public String getRebateType() {
        return rebateType;
    }

    /** 设置 返利数量，和返利类型配合使用 */
    public void setRebateAmount(java.math.BigDecimal rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    /** 得到 返利数量，和返利类型配合使用 */
    public java.math.BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    /** 设置 积分规则id */
    public void setIntegralId(Long integralId) {
        this.integralId = integralId;
    }

    /** 得到 积分规则id */
    public Long getIntegralId() {
        return integralId;
    }

    /** 设置 规则状态（1：启动、 0 ：禁用   2: 删除）参照GlobalParam.FLAG */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 得到 规则状态（1：启动、 0 ：禁用   2: 删除）参照GlobalParam.FLAG */
    public Integer getStatus() {
        return status;
    }

    /** 设置 返利类型（1 前置， 2， 后置    默认2） */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 得到 返利类型（1 前置， 2， 后置    默认2） */
    public Integer getType() {
        return type;
    }

    /** 设置 创建供应商 */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 创建供应商 */
    public Long getSupplierId() {
        return supplierId;
    }

    /** 设置 创建人 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 创建人 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置 创建时间 */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /** 得到 创建时间 */
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /** 设置 修改人 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 修改人 */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 设置 修改时间 */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 修改时间 */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /** 设置 数据来源 */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /** 得到 数据来源 */
    public String getDataSource() {
        return dataSource;
    }

    /** 设置 是否存在加点返利(0否，1是) */
    public void setIsExtraRebate(Integer isExtraRebate) {
        this.isExtraRebate = isExtraRebate;
    }

    /** 得到 是否存在加点返利(0否，1是) */
    public Integer getIsExtraRebate() {
        return isExtraRebate;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("strategyId:").append(this.getStrategyId()).append(",");
        strBuff.append("strategyChildId:").append(this.getStrategyChildId()).append(",");
        strBuff.append("productId:").append(this.getProductId()).append(",");
        strBuff.append("rebateObject:").append(this.getRebateObject()).append(",");
        strBuff.append("settlementType:").append(this.getSettlementType()).append(",");
        strBuff.append("rebateCycle:").append(this.getRebateCycle()).append(",");
        strBuff.append("rebateCycleUnit:").append(this.getRebateCycleUnit()).append(",");
        strBuff.append("rebateType:").append(this.getRebateType()).append(",");
        strBuff.append("rebateAmount:").append(this.getRebateAmount()).append(",");
        strBuff.append("integralId:").append(this.getIntegralId()).append(",");
        strBuff.append("status:").append(this.getStatus()).append(",");
        strBuff.append("type:").append(this.getType()).append(",");
        strBuff.append("supplierId:").append(this.getSupplierId()).append(",");
        strBuff.append("createBy:").append(this.getCreateBy()).append(",");
        strBuff.append("createTime:").append(this.getCreateTime()).append(",");
        strBuff.append("updateBy:").append(this.getUpdateBy()).append(",");
        strBuff.append("updateDate:").append(this.getUpdateDate()).append(",");
        strBuff.append("dataSource:").append(this.getDataSource()).append(",");
        strBuff.append("isExtraRebate:").append(this.getIsExtraRebate());
        strBuff.append("}");
        return strBuff.toString();
    }
}
