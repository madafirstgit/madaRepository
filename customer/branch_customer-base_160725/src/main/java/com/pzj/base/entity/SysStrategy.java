/*
 * SysStrategy.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.政策V2
 * @author 票之家
 */

public class SysStrategy extends BaseEntity implements Serializable {
    /** 政策所属产品id */
    private Long           productId;
    /** 政策名称 */
    private String         name;
    /** 备注 */
    private String         remark;
    /** 政策起始时间 */
    private java.util.Date beginDate;
    /** 政策结束时间 */
    private java.util.Date endDate;
    /** 政策有效期类型（1永久，2设置时长） */
    private Integer        strategyExpireType;
    /** 首检及游玩时间（1当日，2产品有效期内） */
    private Integer        checkinExpireType;
    /** 有效期天数 */
    private Integer        checkinExpireNum;
    /** 有效期计时方式（1小时，2日） */
    private Integer        checkinExpireUnit;
    /** 状态（1启用 0停用） */
    private Integer        status;
    /** 审核状态（1待审核，2通过，3拒绝） */
    private Integer        auditStatus;
    /** 是否是魔方渠道政策（1是，0否） */
    private Integer        isMF;
    /** 创建时间 */
    private java.util.Date createDate;
    /** 创建人 */
    private String         createBy;
    /** 更新时间 */
    private java.util.Date updateDate;
    /** 更新人 */
    private String         updateBy;
    /** 渠道政策类型1直销2分销 */
    private String         type;
    /** 删除标记：删除 */
    private String         delFlag;
    /** 发布时间 */
    private java.util.Date publishDate;
    /** 数据来源 */
    private String         dataSource;
    /** 发布人 */
    private String         publishBy;
    /** 发布状态 1:已发布 0:未发布 */
    private Integer        publishStatus;
    /** 创建供应商 */
    private Long           supplierId;
    /** 渠道id集合（多个id以 */
    private String         channelIds;
    /** 政策子表id集合 */
    private String         childIds;
    /**  */
    private String         column1;
    /**  */
    private String         column2;
    /**  */
    private String         column3;
    /**  */
    private String         column4;

    /**查询用 政策Id集合*/
    private List<Long>     idList;

    /**查询用 产品Id集合*/
    private List<Long>     productIdList;

    /**查询用 渠道Id集合*/
    private List<Long>     channelIdList;

    /**查询用 审核状态集合*/
    private List<Integer>  auditStatusList;

    /** 设置 政策所属产品id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 政策所属产品id */
    public Long getProductId() {
        return productId;
    }

    /** 设置 政策名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 得到 政策名称 */
    public String getName() {
        return name;
    }

    /** 设置 备注 */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 得到 备注 */
    public String getRemark() {
        return remark;
    }

    /** 设置 政策起始时间 */
    public void setBeginDate(java.util.Date beginDate) {
        this.beginDate = beginDate;
    }

    /** 得到 政策起始时间 */
    public java.util.Date getBeginDate() {
        return beginDate;
    }

    /** 设置 政策结束时间 */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    /** 得到 政策结束时间 */
    public java.util.Date getEndDate() {
        return endDate;
    }

    /** 设置 政策有效期类型（1永久，2设置时长） */
    public void setStrategyExpireType(Integer strategyExpireType) {
        this.strategyExpireType = strategyExpireType;
    }

    /** 得到 政策有效期类型（1永久，2设置时长） */
    public Integer getStrategyExpireType() {
        return strategyExpireType;
    }

    /** 设置 首检及游玩时间（1当日，2产品有效期内） */
    public void setCheckinExpireType(Integer checkinExpireType) {
        this.checkinExpireType = checkinExpireType;
    }

    /** 得到 首检及游玩时间（1当日，2产品有效期内） */
    public Integer getCheckinExpireType() {
        return checkinExpireType;
    }

    /** 设置 有效期天数 */
    public void setCheckinExpireNum(Integer checkinExpireNum) {
        this.checkinExpireNum = checkinExpireNum;
    }

    /** 得到 有效期天数 */
    public Integer getCheckinExpireNum() {
        return checkinExpireNum;
    }

    /** 设置 有效期计时方式（1小时，2日） */
    public void setCheckinExpireUnit(Integer checkinExpireUnit) {
        this.checkinExpireUnit = checkinExpireUnit;
    }

    /** 得到 有效期计时方式（1小时，2日） */
    public Integer getCheckinExpireUnit() {
        return checkinExpireUnit;
    }

    /** 设置 状态（1启用 0停用） */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 得到 状态（1启用 0停用） */
    public Integer getStatus() {
        return status;
    }

    /** 设置 审核状态（1待审核，2通过，3拒绝） */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /** 得到 审核状态（1待审核，2通过，3拒绝） */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /** 设置 是否是魔方渠道政策（1是，0否） */
    public void setIsMF(Integer isMF) {
        this.isMF = isMF;
    }

    /** 得到 是否是魔方渠道政策（1是，0否） */
    public Integer getIsMF() {
        return isMF;
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

    /** 设置 渠道政策类型1直销2分销 */
    public void setType(String type) {
        this.type = type;
    }

    /** 得到 渠道政策类型1直销2分销 */
    public String getType() {
        return type;
    }

    /** 设置 删除标记：删除 */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /** 得到 删除标记：删除 */
    public String getDelFlag() {
        return delFlag;
    }

    /** 设置 发布时间 */
    public void setPublishDate(java.util.Date publishDate) {
        this.publishDate = publishDate;
    }

    /** 得到 发布时间 */
    public java.util.Date getPublishDate() {
        return publishDate;
    }

    /** 设置 数据来源 */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /** 得到 数据来源 */
    public String getDataSource() {
        return dataSource;
    }

    /** 设置 发布人 */
    public void setPublishBy(String publishBy) {
        this.publishBy = publishBy;
    }

    /** 得到 发布人 */
    public String getPublishBy() {
        return publishBy;
    }

    /** 设置 发布状态 1:已发布 0:未发布 */
    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    /** 得到 发布状态 1:已发布 0:未发布 */
    public Integer getPublishStatus() {
        return publishStatus;
    }

    /** 设置 创建供应商 */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 创建供应商 */
    public Long getSupplierId() {
        return supplierId;
    }

    /** 设置 渠道id集合（多个id以 */
    public void setChannelIds(String channelIds) {
        this.channelIds = channelIds;
    }

    /** 得到 渠道id集合（多个id以 */
    public String getChannelIds() {
        return channelIds;
    }

    /** 设置 政策子表id集合 */
    public void setChildIds(String childIds) {
        this.childIds = childIds;
    }

    /** 得到 政策子表id集合 */
    public String getChildIds() {
        return childIds;
    }

    /** 设置  */
    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    /** 得到  */
    public String getColumn1() {
        return column1;
    }

    /** 设置  */
    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    /** 得到  */
    public String getColumn2() {
        return column2;
    }

    /** 设置  */
    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    /** 得到  */
    public String getColumn3() {
        return column3;
    }

    /** 设置  */
    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    /** 得到  */
    public String getColumn4() {
        return column4;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("productId:").append(this.getProductId()).append(",");
        strBuff.append("name:").append(this.getName()).append(",");
        strBuff.append("remark:").append(this.getRemark()).append(",");
        strBuff.append("beginDate:").append(this.getBeginDate()).append(",");
        strBuff.append("endDate:").append(this.getEndDate()).append(",");
        strBuff.append("strategyExpireType:").append(this.getStrategyExpireType()).append(",");
        strBuff.append("checkinExpireType:").append(this.getCheckinExpireType()).append(",");
        strBuff.append("checkinExpireNum:").append(this.getCheckinExpireNum()).append(",");
        strBuff.append("checkinExpireUnit:").append(this.getCheckinExpireUnit()).append(",");
        strBuff.append("status:").append(this.getStatus()).append(",");
        strBuff.append("auditStatus:").append(this.getAuditStatus()).append(",");
        strBuff.append("isMF:").append(this.getIsMF()).append(",");
        strBuff.append("createDate:").append(this.getCreateDate()).append(",");
        strBuff.append("createBy:").append(this.getCreateBy()).append(",");
        strBuff.append("updateDate:").append(this.getUpdateDate()).append(",");
        strBuff.append("updateBy:").append(this.getUpdateBy()).append(",");
        strBuff.append("type:").append(this.getType()).append(",");
        strBuff.append("delFlag:").append(this.getDelFlag()).append(",");
        strBuff.append("publishDate:").append(this.getPublishDate()).append(",");
        strBuff.append("dataSource:").append(this.getDataSource()).append(",");
        strBuff.append("publishBy:").append(this.getPublishBy()).append(",");
        strBuff.append("publishStatus:").append(this.getPublishStatus()).append(",");
        strBuff.append("supplierId:").append(this.getSupplierId()).append(",");
        strBuff.append("channelIds:").append(this.getChannelIds()).append(",");
        strBuff.append("childIds:").append(this.getChildIds()).append(",");
        strBuff.append("column1:").append(this.getColumn1()).append(",");
        strBuff.append("column2:").append(this.getColumn2()).append(",");
        strBuff.append("column3:").append(this.getColumn3()).append(",");
        strBuff.append("column4:").append(this.getColumn4());
        strBuff.append("}");
        return strBuff.toString();
    }
}
