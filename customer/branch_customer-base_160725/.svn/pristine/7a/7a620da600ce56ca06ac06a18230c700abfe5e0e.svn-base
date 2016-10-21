package com.pzj.base.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * 加点返利规则
 * 
 * @author liangning
 */
public class SysExtraRebateStrategy extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7386496415661725450L;

    /**
     * 返利对象(总社H、地接部门D、优先部门DH、导游G)
     */
    private String            rebateObject;

    /**
     * 返利周期(YEAR/MONTH/WEEK/DAY/CURRENT)
     */
    private String            rebateCycle;

    /**
     * 返利金额
     */
    private Double            rebateAmount;

    /**
     * 返利形式(0为现金返利，1为按票返利，2返利积分)
     */
    private Integer           rebateType;

    /**
     * 状态标识（1：启动、 0 ：禁用 2: 删除）参照GlobalParam.FLAG'
     */
    private Integer           delFlag;

    /**
     * 积分ID
     */
    private Long              integralId;

    /**
     * 积分数量
     */
    private Integer           integralValue;

    /**
     * 前置返利 ID
     */
    private Long              frontRebateRuleId;

    /**
     * 多个前置返利 ID
     *
     * 用于查询多个返利的加点返利
     */
    private List<Long>        frontRebateRuleIds;

    /**
     * 前置产品ID
     */
    private Long              frontProductId;

    /**
     * 时效（单位:小时）
     */
    private Integer           validityPeriod;

    /**
     * 创建人
     */
    private String            createBy;

    /**
     * 创建时间
     */
    private Date              createDate;

    /**
     * 更新人
     */
    private String            updateBy;

    /**
     * 更新时间
     */
    private Date              updataDate;

    /**
     * 所属平台
     */
    private String            dataSource;

    private Integer           validityType;

    /**
     * 创建供应商ID
     */
    private Long              supplierId;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getRebateObject() {
        return rebateObject;
    }

    public void setRebateObject(String rebateObject) {
        this.rebateObject = rebateObject == null ? null : rebateObject.trim();
    }

    public String getRebateCycle() {
        return rebateCycle;
    }

    public void setRebateCycle(String rebateCycle) {
        this.rebateCycle = rebateCycle == null ? null : rebateCycle.trim();
    }

    public Double getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(Double rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public Integer getRebateType() {
        return rebateType;
    }

    public void setRebateType(Integer rebateType) {
        this.rebateType = rebateType;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Long getIntegralId() {
        return integralId;
    }

    public void setIntegralId(Long integralId) {
        this.integralId = integralId;
    }

    public Integer getIntegralValue() {
        return integralValue;
    }

    public void setIntegralValue(Integer integralValue) {
        this.integralValue = integralValue;
    }

    public Long getFrontRebateRuleId() {
        return frontRebateRuleId;
    }

    public void setFrontRebateRuleId(Long frontRebateRuleId) {
        this.frontRebateRuleId = frontRebateRuleId;
    }

    public Long getFrontProductId() {
        return frontProductId;
    }

    public void setFrontProductId(Long frontProductId) {
        this.frontProductId = frontProductId;
    }

    public Integer getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
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

    public Date getUpdataDate() {
        return updataDate;
    }

    public void setUpdataDate(Date updataDate) {
        this.updataDate = updataDate;
    }

    /**
     * 获取创建供应商ID
     * 
     * @return supplierId 创建供应商ID
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 设置创建供应商ID
     * 
     * @param supplierId
     *            创建供应商ID
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getValidityType() {
        return validityType;
    }

    public void setValidityType(Integer validityType) {
        this.validityType = validityType;
    }

    public List<Long> getFrontRebateRuleIds() {
        return frontRebateRuleIds;
    }

    public void setFrontRebateRuleIds(List<Long> frontRebateRuleIds) {
        this.frontRebateRuleIds = frontRebateRuleIds;
    }
}