/*
 * SysStrategyChild.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * vo.政策子表V2
 * @author 票之家
 */

public class SysStrategyChild extends BaseEntity implements Serializable {
    /** 政策ID */
    private Long                 strategyId;
    /** 产品ID（返利票种ID） */
    private Long                 productId;
    /** 渠道价 */
    private java.math.BigDecimal price;
    /** 结算价 */
    private java.math.BigDecimal settlementPrice;
    /** 票品（数据字典ticketvarie） */
    private String               ticketVarie;
    /** 有效期天数 */
    private Integer              expire;
    /** 有效期计时方式（1小时，2日） */
    private Integer              expireMode;
    /** 销售端口（type：value，type=） */
    private String               salesType;
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
    /** 渠道id集合 */
    private String               channelIds;
    /** 返利id集合 */
    private String               rebateIds;

    /** 设置 政策ID */
    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    /** 得到 政策ID */
    public Long getStrategyId() {
        return strategyId;
    }

    /** 设置 产品ID（返利票种ID） */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 产品ID（返利票种ID） */
    public Long getProductId() {
        return productId;
    }

    /** 设置 渠道价 */
    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    /** 得到 渠道价 */
    public java.math.BigDecimal getPrice() {
        return price;
    }

    /** 设置 结算价 */
    public void setSettlementPrice(java.math.BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    /** 得到 结算价 */
    public java.math.BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    /** 设置 票品（数据字典ticketvarie） */
    public void setTicketVarie(String ticketVarie) {
        this.ticketVarie = ticketVarie;
    }

    /** 得到 票品（数据字典ticketvarie） */
    public String getTicketVarie() {
        return ticketVarie;
    }

    /** 设置 有效期天数 */
    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    /** 得到 有效期天数 */
    public Integer getExpire() {
        return expire;
    }

    /** 设置 有效期计时方式（1小时，2日） */
    public void setExpireMode(Integer expireMode) {
        this.expireMode = expireMode;
    }

    /** 得到 有效期计时方式（1小时，2日） */
    public Integer getExpireMode() {
        return expireMode;
    }

    /** 设置 销售端口（type：value，type=） */
    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    /** 得到 销售端口（type：value，type=） */
    public String getSalesType() {
        return salesType;
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

    /** 设置 渠道id集合 */
    public void setChannelIds(String channelIds) {
        this.channelIds = channelIds;
    }

    /** 得到 渠道id集合 */
    public String getChannelIds() {
        return channelIds;
    }

    /** 设置 返利id集合 */
    public void setRebateIds(String rebateIds) {
        this.rebateIds = rebateIds;
    }

    /** 得到 返利id集合 */
    public String getRebateIds() {
        return rebateIds;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("strategyId:").append(this.getStrategyId()).append(",");
        strBuff.append("productId:").append(this.getProductId()).append(",");
        strBuff.append("price:").append(this.getPrice()).append(",");
        strBuff.append("settlementPrice:").append(this.getSettlementPrice()).append(",");
        strBuff.append("ticketVarie:").append(this.getTicketVarie()).append(",");
        strBuff.append("expire:").append(this.getExpire()).append(",");
        strBuff.append("expireMode:").append(this.getExpireMode()).append(",");
        strBuff.append("salesType:").append(this.getSalesType()).append(",");
        strBuff.append("supplierId:").append(this.getSupplierId()).append(",");
        strBuff.append("createBy:").append(this.getCreateBy()).append(",");
        strBuff.append("createTime:").append(this.getCreateTime()).append(",");
        strBuff.append("updateBy:").append(this.getUpdateBy()).append(",");
        strBuff.append("updateDate:").append(this.getUpdateDate()).append(",");
        strBuff.append("dataSource:").append(this.getDataSource()).append(",");
        strBuff.append("channelIds:").append(this.getChannelIds()).append(",");
        strBuff.append("rebateIds:").append(this.getRebateIds());
        strBuff.append("}");
        return strBuff.toString();
    }
}
