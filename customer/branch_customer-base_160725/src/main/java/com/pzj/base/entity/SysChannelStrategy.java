package com.pzj.base.entity;

import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.entity.common.SysObjectDictRelation;
import com.pzj.base.entity.query.SysDateQuery;

public class SysChannelStrategy extends BaseEntity {

    private static final long       serialVersionUID = -4061503967576771121L;

    /** 渠道政策类型1直销2分销 */
    private String                  type;

    /** 政策名称 */
    private String                  name;

    /** 备注 */
    private String                  remark;

    /** 政策有效期类型（1永久，2设置时长） */
    private Integer                 strategyExpireType;

    /** 政策有效期：起始时间 */
    private Date                    beginDate;

    /** 政策有效期：政策结束时间 */
    private Date                    endDate;

    /** 首检及游玩时间（1当日，2产品有效期内） */
    private Integer                 checkinExpireType;

    /** 有效期天数 */
    private Integer                 checkinExpireNum;

    /** 有效期计时方式（1小时，2日） */
    private Integer                 checkinExpireUnit;

    /** 票品（数据字典ticketvarie） */
    private String                  ticketVarie;

    /** 渠道价 */
    private Double                  price;

    /** 结算价 */
    private Double                  settlementPrice;

    /** 销售端口（type：value，type=） */
    private String                  salesType;

    /**
     * 销售端口值
     */
    private List<String>            salesTypeValues;

    /** 购买时限：个数 */
    private Integer                 expire;

    /** 购买时限：计时单位（1 小时，2 日） */
    private Integer                 expireMode;

    /** 适用范围、可多选(1周一 2周二 3周三 4周四 5周五 6周六 7周日) */
    private String                  scope;

    /** 状态（1启用 2停用 默认停用2） */
    private Integer                 status;

    /** 发布状态 */
    private Integer                 publishStatus;

    /** 发布人 */
    private String                  publishBy;

    /** 发布时间 */
    private Date                    publishDate;

    /** 审核状态（1待审核，2通过，3拒绝） */
    private Integer                 auditStatus;

    /** 审核拒绝原因 */
    private String                  refuseReason;

    /** 是否是魔方渠道政策（1是，0否） */
    private Integer                 isMF;

    /** 创建时间 */
    private Date                    createDate;

    /** 创建人 */
    private String                  createBy;

    /** 更新时间 */
    private Date                    updateDate;

    /** 更新人 */
    private String                  updateBy;

    /** 删除标记：删除 */
    private String                  delFlag;

    /**
     * 数据来源
     */
    private String                  dataSource;

    /**
     * 创建供应商ID
     */
    private Long                    supplierId;

    /**
     * 联票子产品id
     */
    private Long                    subProductId;

    /**
     * pms独有属性:返利比
     */
    private Double                  rebateRate;

    /**
     * 未满减结算规则类型
     * 
     */
    private Integer                 notTotalSettlementType;

    /**
     * 减少结算金额
     */
    private Double                  reduceSettlementMoney;

    /**
     * 门市价
     */
    private Double                  marketPrice;

    /**
     * 建议零售价
     */
    private Double                  advicePrice;

    /**
     * 减免结算规则
     */
    private List<SysSettlementRule> settlementRuleList;

    /**
     * 上级政策主键Id
     */
    private Long                    parentId;

    /** 预售天数 */
    @Deprecated
    private Integer                 preSale;

    /** 预售计时单位（1小时，2日） */
    @Deprecated
    private Integer                 preSaleMode;

    /** 直销渠道数据字典 **/
    @Deprecated
    private String                  dictValue;

    /** 购买数量 */
    @Deprecated
    private Integer                 quantity;

    /** 是否开启多级返利 **/
    @Deprecated
    private Integer                 isOpenMultiRebate;

    /**
     * 渠道列表集合
     */
    private List<SysChannel>        channelList;

    /**
     * 产品id集合
     */
    private List<Long>              productList;

    /**
     * 返利规则
     */
    private List<SysRebateStrategy> rebateStrategyList;

    /**
     * 查询参数 政策主键集合
     */
    private List<Long>              ids;

    /**
     * 查询参数 渠道主键集合
     */
    private List<Long>              channelIds;

    /**
     * 查询参数 产品主键集合
     */
    private List<Long>              productIds;

    /**
     * 查询参数 日期集合
     */
    private List<SysDateQuery>      queryDateList;

    /**
     * 查询参数 返利集合
     */
    private List<Long>              rebateIds;

    /**
     * 查询参数 魔方二次审核状态
     */
    private List<Integer>           auditStatusList;

    /**
     * 查询参数 首检及游玩时间类型
     */
    private List<Integer>           checkinExpireTypeList;

    /**
     * 查询参数 政策发布状态集合
     */
    private List<Integer>           publishStatusList;

    /**
     * 提前预订时间限制
     */
    private Integer                 isLimitAdvanceDue;
    /**
     * 日期前天数可预订
     */
    private Integer                 advanceDueDays;
    /**
     * 日期前时刻-（时）可预订
     */
    private Integer                 advanceDueHour;
    /**
     * 日期前时刻-（分）可预订
     */
    private Integer                 advanceDueMinute;
    /**
     * 延迟消费时间限制
     */
    private Integer                 isLimitDelayConsume;
    /**
     * 预订时刻-（时）可兑换
     */
    private Integer                 delayConsumeHour;
    /**
     * 每单最少购买份数
     */
    private Integer                 leastPerdueNumber;
    /**
     * 每单最多购买份数
     */
    private Integer                 mostPerdueNumber;

    /**
     * 日期前可预订单位
     */
    private Integer                 advanceDueUnit;

    /**
     * 产品id
     */
    private Long                    productId;

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getAdvicePrice() {
        return advicePrice;
    }

    public void setAdvicePrice(Double advicePrice) {
        this.advicePrice = advicePrice;
    }

    /**
     * 获取渠道政策类型1直销2分销
     * 
     * @return type 渠道政策类型1直销2分销
     */
    public String getType() {
        return type;
    }

    /**
     * 设置渠道政策类型1直销2分销
     * 
     * @param type
     *            渠道政策类型1直销2分销
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取政策名称
     * 
     * @return name 政策名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置政策名称
     * 
     * @param name
     *            政策名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取备注
     * 
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     * 
     * @param remark
     *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取政策有效期类型（1永久，2设置时长）
     * 
     * @return strategyExpireType 政策有效期类型（1永久，2设置时长）
     */
    public Integer getStrategyExpireType() {
        return strategyExpireType;
    }

    /**
     * 设置政策有效期类型（1永久，2设置时长）
     * 
     * @param strategyExpireType
     *            政策有效期类型（1永久，2设置时长）
     */
    public void setStrategyExpireType(Integer strategyExpireType) {
        this.strategyExpireType = strategyExpireType;
    }

    /**
     * 获取政策有效期：起始时间
     * 
     * @return beginDate 政策有效期：起始时间
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置政策有效期：起始时间
     * 
     * @param beginDate
     *            政策有效期：起始时间
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取政策有效期：政策结束时间
     * 
     * @return endDate 政策有效期：政策结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置政策有效期：政策结束时间
     * 
     * @param endDate
     *            政策有效期：政策结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取首检及游玩时间（1当日，2产品有效期内）
     * 
     * @return checkinExpireType 首检及游玩时间（1当日，2产品有效期内）
     */
    public Integer getCheckinExpireType() {
        return checkinExpireType;
    }

    /**
     * 设置首检及游玩时间（1当日，2产品有效期内）
     * 
     * @param checkinExpireType
     *            首检及游玩时间（1当日，2产品有效期内）
     */
    public void setCheckinExpireType(Integer checkinExpireType) {
        this.checkinExpireType = checkinExpireType;
    }

    /**
     * 获取有效期天数
     * 
     * @return checkinExpireNum 有效期天数
     */
    public Integer getCheckinExpireNum() {
        return checkinExpireNum;
    }

    /**
     * 设置有效期天数
     * 
     * @param checkinExpireNum
     *            有效期天数
     */
    public void setCheckinExpireNum(Integer checkinExpireNum) {
        this.checkinExpireNum = checkinExpireNum;
    }

    /**
     * 获取有效期计时方式（1小时，2日）
     * 
     * @return checkinExpireUnit 有效期计时方式（1小时，2日）
     */
    public Integer getCheckinExpireUnit() {
        return checkinExpireUnit;
    }

    /**
     * 设置有效期计时方式（1小时，2日）
     * 
     * @param checkinExpireUnit
     *            有效期计时方式（1小时，2日）
     */
    public void setCheckinExpireUnit(Integer checkinExpireUnit) {
        this.checkinExpireUnit = checkinExpireUnit;
    }

    /**
     * 获取票品（数据字典ticketvarie）
     * 
     * @return ticketVarie 票品（数据字典ticketvarie）
     */
    public String getTicketVarie() {
        return ticketVarie;
    }

    /**
     * 设置票品（数据字典ticketvarie）
     * 
     * @param ticketVarie
     *            票品（数据字典ticketvarie）
     */
    public void setTicketVarie(String ticketVarie) {
        this.ticketVarie = ticketVarie;
    }

    /**
     * 获取渠道价
     * 
     * @return price 渠道价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置渠道价
     * 
     * @param price
     *            渠道价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取结算价
     * 
     * @return settlementPrice 结算价
     */
    public Double getSettlementPrice() {
        return settlementPrice;
    }

    /**
     * 设置结算价
     * 
     * @param settlementPrice
     *            结算价
     */
    public void setSettlementPrice(Double settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    /**
     * 获取销售端口（type：value，type=）
     * 
     * @return salesType 销售端口（type：value，type=）
     */
    public String getSalesType() {
        return salesType;
    }

    /**
     * 设置销售端口（type：value，type=）
     * 
     * @param salesType
     *            销售端口（type：value，type=）
     */
    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    /**
     * 获取购买时限：个数
     * 
     * @return expire 购买时限：个数
     */
    public Integer getExpire() {
        return expire;
    }

    /**
     * 设置购买时限：个数
     * 
     * @param expire
     *            购买时限：个数
     */
    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    /**
     * 获取购买时限：计时单位（1小时，2日）
     * 
     * @return expireMode 购买时限：计时单位（1小时，2日）
     */
    public Integer getExpireMode() {
        return expireMode;
    }

    /**
     * 设置购买时限：计时单位（1小时，2日）
     * 
     * @param expireMode
     *            购买时限：计时单位（1小时，2日）
     */
    public void setExpireMode(Integer expireMode) {
        this.expireMode = expireMode;
    }

    /**
     * 获取适用范围、可多选(1周一2周二3周三4周四5周五6周六7周日)
     * 
     * @return scope 适用范围、可多选(1周一2周二3周三4周四5周五6周六7周日)
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置适用范围、可多选(1周一2周二3周三4周四5周五6周六7周日)
     * 
     * @param scope
     *            适用范围、可多选(1周一2周二3周三4周四5周五6周六7周日)
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 获取状态（1启用2停用默认停用2）
     * 
     * @return status 状态（1启用2停用默认停用2）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（1启用2停用默认停用2）
     * 
     * @param status
     *            状态（1启用2停用默认停用2）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取发布状态
     * 
     * @return publishStatus 发布状态
     */
    public Integer getPublishStatus() {
        return publishStatus;
    }

    /**
     * 设置发布状态
     * 
     * @param publishStatus
     *            发布状态
     */
    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 获取发布人
     * 
     * @return publishBy 发布人
     */
    public String getPublishBy() {
        return publishBy;
    }

    /**
     * 设置发布人
     * 
     * @param publishBy
     *            发布人
     */
    public void setPublishBy(String publishBy) {
        this.publishBy = publishBy;
    }

    /**
     * 获取发布时间
     * 
     * @return publishDate 发布时间
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置发布时间
     * 
     * @param publishDate
     *            发布时间
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取审核状态（1待审核，2通过，3拒绝）
     * 
     * @return auditStatus 审核状态（1待审核，2通过，3拒绝）
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态（1待审核，2通过，3拒绝）
     * 
     * @param auditStatus
     *            审核状态（1待审核，2通过，3拒绝）
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取审核拒绝原因
     * 
     * @return refuseReason 审核拒绝原因
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 设置审核拒绝原因
     * 
     * @param refuseReason
     *            审核拒绝原因
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    /**
     * 获取是否是魔方渠道政策（1是，0否）
     * 
     * @return isMF 是否是魔方渠道政策（1是，0否）
     */
    public Integer getIsMF() {
        return isMF;
    }

    /**
     * 设置是否是魔方渠道政策（1是，0否）
     * 
     * @param isMF
     *            是否是魔方渠道政策（1是，0否）
     */
    public void setIsMF(Integer isMF) {
        this.isMF = isMF;
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
     * 获取更新时间
     * 
     * @return updateDate 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     * 
     * @param updateDate
     *            更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取更新人
     * 
     * @return updateBy 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     * 
     * @param updateBy
     *            更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取删除标记：删除
     * 
     * @return delFlag 删除标记：删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记：删除
     * 
     * @param delFlag
     *            删除标记：删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取数据来源
     * 
     * @return dataSource 数据来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据来源
     * 
     * @param dataSource
     *            数据来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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

    /**
     * 获取预售天数
     * 
     * @return preSale 预售天数
     */
    public Integer getPreSale() {
        return preSale;
    }

    /**
     * 设置预售天数
     * 
     * @param preSale
     *            预售天数
     */
    public void setPreSale(Integer preSale) {
        this.preSale = preSale;
    }

    /**
     * 获取预售计时方式（1小时，2日）
     * 
     * @return preSaleMode 预售计时方式（1小时，2日）
     */
    public Integer getPreSaleMode() {
        return preSaleMode;
    }

    /**
     * 设置预售计时方式（1小时，2日）
     * 
     * @param preSaleMode
     *            预售计时方式（1小时，2日）
     */
    public void setPreSaleMode(Integer preSaleMode) {
        this.preSaleMode = preSaleMode;
    }

    /**
     * 获取直销渠道数据字典
     * 
     * @return dictValue 直销渠道数据字典
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置直销渠道数据字典
     * 
     * @param dictValue
     *            直销渠道数据字典
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取购买数量
     * 
     * @return quantity 购买数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置购买数量
     * 
     * @param quantity
     *            购买数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取是否开启多级返利
     * 
     * @return isOpenMultiRebate 是否开启多级返利
     */
    public Integer getIsOpenMultiRebate() {
        return isOpenMultiRebate;
    }

    /**
     * 设置是否开启多级返利
     * 
     * @param isOpenMultiRebate
     *            是否开启多级返利
     */
    public void setIsOpenMultiRebate(Integer isOpenMultiRebate) {
        this.isOpenMultiRebate = isOpenMultiRebate;
    }

    /**
     * 获取联票子产品id
     * 
     * @return subProductId 联票子产品id
     */
    public Long getSubProductId() {
        return subProductId;
    }

    /**
     * 设置联票子产品id
     * 
     * @param subProductId
     *            联票子产品id
     */
    public void setSubProductId(Long subProductId) {
        this.subProductId = subProductId;
    }

    /**
     * 获取渠道列表集合
     * 
     * @return channelList 渠道列表集合
     */
    public List<SysChannel> getChannelList() {
        return channelList;
    }

    /**
     * 设置渠道列表集合
     * 
     * @param channelList
     *            渠道列表集合
     */
    public void setChannelList(List<SysChannel> channelList) {
        this.channelList = channelList;
    }

    /**
     * 获取产品id集合
     * 
     * @return productList 产品id集合
     */
    public List<Long> getProductList() {
        return productList;
    }

    /**
     * 设置产品id集合
     * 
     * @param productList
     *            产品id集合
     */
    public void setProductList(List<Long> productList) {
        this.productList = productList;
    }

    /**
     * 获取返利规则
     * 
     * @return rebateStrategyList 返利规则
     */
    public List<SysRebateStrategy> getRebateStrategyList() {
        return rebateStrategyList;
    }

    /**
     * 设置返利规则
     * 
     * @param rebateStrategyList
     *            返利规则
     */
    public void setRebateStrategyList(List<SysRebateStrategy> rebateStrategyList) {
        this.rebateStrategyList = rebateStrategyList;
    }

    /**
     * 获取查询参数渠道主键集合
     * 
     * @return channelIds 查询参数渠道主键集合
     */
    public List<Long> getChannelIds() {
        if (channelIds != null && channelIds.size() == 0)
            return null;
        return channelIds;
    }

    /**
     * 设置查询参数渠道主键集合
     * 
     * @param channelIds
     *            查询参数渠道主键集合
     */
    public void setChannelIds(List<Long> channelIds) {
        this.channelIds = channelIds;
    }

    /**
     * 获取查询参数产品主键集合
     * 
     * @return productIds 查询参数产品主键集合
     */
    public List<Long> getProductIds() {
        if (productIds == null || productIds.size() == 0)
            return null;
        return productIds;
    }

    /**
     * 设置查询参数产品主键集合
     * 
     * @param productIds
     *            查询参数产品主键集合
     */
    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    /**
     * 获取查询参数日期集合
     * 
     * @return queryDateList 查询参数日期集合
     */
    public List<SysDateQuery> getQueryDateList() {
        return queryDateList;
    }

    /**
     * 设置查询参数日期集合
     * 
     * @param queryDateList
     *            查询参数日期集合
     */
    public void setQueryDateList(List<SysDateQuery> queryDateList) {
        this.queryDateList = queryDateList;
    }

    /**
     * 获取查询参数返利集合
     * 
     * @return rebateIds 查询参数返利集合
     */
    public List<Long> getRebateIds() {
        return rebateIds;
    }

    /**
     * 设置查询参数返利集合
     * 
     * @param rebateIds
     *            查询参数返利集合
     */
    public void setRebateIds(List<Long> rebateIds) {
        this.rebateIds = rebateIds;
    }

    /**
     * 获取查询参数魔方二次审核状态
     * 
     * @return auditStatusList 查询参数魔方二次审核状态
     */
    public List<Integer> getAuditStatusList() {
        return auditStatusList;
    }

    /**
     * 设置查询参数魔方二次审核状态
     * 
     * @param auditStatusList
     *            查询参数魔方二次审核状态
     */
    public void setAuditStatusList(List<Integer> auditStatusList) {
        this.auditStatusList = auditStatusList;
    }

    /**
     * 获取查询参数首检及游玩时间类型
     * 
     * @return checkinExpireTypeList 查询参数首检及游玩时间类型
     */
    public List<Integer> getCheckinExpireTypeList() {
        return checkinExpireTypeList;
    }

    /**
     * 设置查询参数首检及游玩时间类型
     * 
     * @param checkinExpireTypeList
     *            查询参数首检及游玩时间类型
     */
    public void setCheckinExpireTypeList(List<Integer> checkinExpireTypeList) {
        this.checkinExpireTypeList = checkinExpireTypeList;
    }

    /**
     * 获取查询参数政策发布状态集合
     * 
     * @return publishStatusList 查询参数政策发布状态集合
     */
    public List<Integer> getPublishStatusList() {
        return publishStatusList;
    }

    /**
     * 设置查询参数政策发布状态集合
     * 
     * @param publishStatusList
     *            查询参数政策发布状态集合
     */
    public void setPublishStatusList(List<Integer> publishStatusList) {
        this.publishStatusList = publishStatusList;
    }

    /**
     * 获取查询参数政策主键集合
     * 
     * @return ids 查询参数政策主键集合
     */
    public List<Long> getIds() {
        return ids;
    }

    /**
     * 设置查询参数政策主键集合
     * 
     * @param ids
     *            查询参数政策主键集合
     */
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    /**
     * 获取pms独有属性:返利比
     * 
     * @return rebateRate pms独有属性:返利比
     */
    public Double getRebateRate() {
        return rebateRate;
    }

    /**
     * 设置pms独有属性:返利比
     * 
     * @param rebateRate
     *            pms独有属性:返利比
     */
    public void setRebateRate(Double rebateRate) {
        this.rebateRate = rebateRate;
    }

    /**
     * 获取未满减结算规则类型
     * 
     * @return notTotalSettlementType 未满减结算规则类型
     */
    public Integer getNotTotalSettlementType() {
        return notTotalSettlementType;
    }

    /**
     * 设置未满减结算规则类型
     * 
     * @param notTotalSettlementType
     *            未满减结算规则类型
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
     * 获取上级政策主键Id
     * 
     * @return parentId 上级政策主键Id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级政策主键Id
     * 
     * @param parentId
     *            上级政策主键Id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取减免结算规则
     * 
     * @return settlementRuleList 减免结算规则
     */
    public List<SysSettlementRule> getSettlementRuleList() {
        return settlementRuleList;
    }

    /**
     * 设置减免结算规则
     * 
     * @param settlementRuleList
     *            减免结算规则
     */
    public void setSettlementRuleList(List<SysSettlementRule> settlementRuleList) {
        this.settlementRuleList = settlementRuleList;
    }

    public Integer getIsLimitAdvanceDue() {
        return isLimitAdvanceDue;
    }

    public void setIsLimitAdvanceDue(Integer isLimitAdvanceDue) {
        this.isLimitAdvanceDue = isLimitAdvanceDue;
    }

    public Integer getAdvanceDueDays() {
        return advanceDueDays;
    }

    public void setAdvanceDueDays(Integer advanceDueDays) {
        this.advanceDueDays = advanceDueDays;
    }

    public Integer getAdvanceDueHour() {
        return advanceDueHour;
    }

    public void setAdvanceDueHour(Integer advanceDueHour) {
        this.advanceDueHour = advanceDueHour;
    }

    public Integer getAdvanceDueMinute() {
        return advanceDueMinute;
    }

    public void setAdvanceDueMinute(Integer advanceDueMinute) {
        this.advanceDueMinute = advanceDueMinute;
    }

    public Integer getIsLimitDelayConsume() {
        return isLimitDelayConsume;
    }

    public void setIsLimitDelayConsume(Integer isLimitDelayConsume) {
        this.isLimitDelayConsume = isLimitDelayConsume;
    }

    public Integer getDelayConsumeHour() {
        return delayConsumeHour;
    }

    public void setDelayConsumeHour(Integer delayConsumeHour) {
        this.delayConsumeHour = delayConsumeHour;
    }

    public Integer getLeastPerdueNumber() {
        return leastPerdueNumber;
    }

    public void setLeastPerdueNumber(Integer leastPerdueNumber) {
        this.leastPerdueNumber = leastPerdueNumber;
    }

    public Integer getMostPerdueNumber() {
        return mostPerdueNumber;
    }

    public void setMostPerdueNumber(Integer mostPerdueNumber) {
        this.mostPerdueNumber = mostPerdueNumber;
    }

    public Integer getAdvanceDueUnit() {
        return advanceDueUnit;
    }

    public void setAdvanceDueUnit(Integer advanceDueUnit) {
        this.advanceDueUnit = advanceDueUnit;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<String> getSalesTypeValues() {
        return salesTypeValues;
    }

    public void setSalesTypeValues(List<String> salesTypeValues) {
        this.salesTypeValues = salesTypeValues;
    }
}
