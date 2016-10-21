package com.pzj.base.entity.product;

import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * @Author :DongChf
 * @Date :2016年6月5日
 * @Describe:退换票规则
 */
public class TicketRule extends BaseEntity {
    private static final long    serialVersionUID = 1L;

    /** 供应商ID */
    private Long                 supId;
    /** 规则名称 */
    private String               name;
    /** 规则排序 */
    private Integer              sort;
    /** 规则启用状态 */
    private Integer              status;
    /** 是否允许退票 */
    private Boolean              refund;
    /** 退换票时间类型 */
    private Integer              timeType;
    /** 时限相关 */
    /** N 天 */
    private Integer              days;
    /** N 小时 */
    private Double               hours;
    /** N 分钟 */
    private Integer              minutes;
    /** 退票扣费方式 */
    private Byte                 refundType;
    /** 退票扣费值 */
    private Double               refundValue;
    /** 换票扣费方式 */
    private Byte                 exchangeType;
    /** 换票扣费值 */
    private Double               exchangeValue;
    /** 绑定产品的主键集合 */
    private List<Long>           proIds;

    /** 辅助查询属性 BEGIN */
    /** 创建时间 */
    private Date                 createDate;
    /** 更新时间 */
    private Date                 updateDate;
    /** 规则id 集合 */
    private List<Long>           ruleIds;
    /** 通用产品转换 */
    private Integer              skuId;
    /** 查询结果封装 */
    private List<ProductRuleRel> rels;

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /** 辅助查询属性 END */
    public TicketRule() {
        super();
    }

    public Long getSupId() {
        return supId;
    }

    public void setSupId(Long supId) {
        this.supId = supId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Byte getRefundType() {
        return refundType;
    }

    public void setRefundType(Byte refundType) {
        this.refundType = refundType;
    }

    public Byte getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Byte exchangeType) {
        this.exchangeType = exchangeType;
    }

    public Double getRefundValue() {
        return refundValue;
    }

    public void setRefundValue(Double refundValue) {
        this.refundValue = refundValue;
    }

    public Double getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(Double exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public List<Long> getRuleIds() {
        return ruleIds;
    }

    public void setRuleIds(List<Long> ruleIds) {
        this.ruleIds = ruleIds;
    }

    public List<Long> getProIds() {
        return proIds;
    }

    public void setProIds(List<Long> proIds) {
        this.proIds = proIds;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<ProductRuleRel> getRels() {
        return rels;
    }

    public void setRels(List<ProductRuleRel> rels) {
        this.rels = rels;
    }
}