/*
 * ProductRelease.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-30 created
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.utils.PropertiesLoader;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.product.pms.ProductBed;
import com.pzj.base.entity.product.pms.ProductPenalty;
import com.pzj.base.entity.product.pms.ProductPriceRule;
import com.pzj.base.entity.product.query.DateQuery;
import com.pzj.base.entity.query.DateQueryParam;

/**
 * 产品发布关系 票之家公司 ----------------------* 2015-09-30created
 */
public class ProductRelease extends BaseEntity implements Serializable {

    private static final long      serialVersionUID = -5457364474953816017L;
    
    private static PropertiesLoader  loader;
    

    /** 支持in查询，扩展属性，不持久化 */
    private List<Long>             ids;

    /**
     * 扩展属性，用于查询，产品类别集合
     */
    private List<String>           proCategorys;
    private List<String>           proCategorys2;
    /**
     * 扩展属性，用于查询，产品有效期ids
     */
    private List<Long>             productIds;

    /**
     * 扩展属性，用于查询，产品关联政策Ids
     */
    private List<Long>             strategyIds;

    /**
     * 扩展属性，只在程序中使用
     */
    private String                 tempNo;

    /**
     * 扩展属性，票种票品不等于，注意前后顺序
     */
    private String                 notEqual;

    /**
     * 审核状态集合,扩展属性，为了支持查询
     */
    private List<Long>             auditStatusList;

    /**  */
    private String                 name;
    /**
     * 俗称：备注名称
     * <p/>
     * 为了方便查询使用，对应ProductInfo中的name
     */
    private String                 popularName;

    /** 产品id */
    private Long                   productId;

    /**
     * 发布内部序号
     */
    private String                 roductNo;

    /** 产品code */
    private String                 productCode;

    /** 发布价格 */
    private Double                 productPrice;

    /** 产品类型(票型) */
    private String                 productType;

    /** 剧场区域 */
    private String                 region;

    /** 剧场场次 */
    private String                 ronda;

    /**
     * 剧场ID
     */
    private Long                   theaterId;

    /**  */
    private String                 createBy;

    /**  */
    private java.util.Date         createDate;

    /**  */
    private String                 updateBy;

    /**  */
    private java.util.Date         updateDate;

    /** 排序 */
    private Integer                sort;

    /** 使用状态1启用0禁用2删除3已生成联票4未生成联票 */
    private String                 flag;

    /** 介绍 */
    private String                 remarks;

    /** 审核状态 0未审核 1 通过 2 拒绝 */
    private String                 auditStatus;

    /**
     * 拒绝理由
     */
    private String                 reasonRejection;

    /** 产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票 */
    private String                 proCategory;

    /** 拒绝理由 */
    private String                 reason;

    /** 供应商 */
    private String                 supplierId;

    /** 联票子票状态（1未生成 2已生成） */
    private String                 packageStatus;

    /** 入园方式 */
    private String                 checkInType;

    /** 景区id，只用作查询 */
    private Long                   scenicId;

    /** 供应商id集合，作为查询条件 */
    private List<String>           supplierIdList;

    /**
     * 目标供应商，查询此供应商共享给supplierId的产品，queryByUserRelation用到
     */
    private String                 targetSupplierId;

    /**
     * 当前如果是子票，则是否被组合过
     */
    private Boolean                isComposed;

    private String                 composeMark;

    private ProductInfo            productInfo;

    /**
     * 检票次数
     */
    private Integer                ticketNumber;

    /**检票时间段 :开始时间  格式：hh:mm*/
    private String                 startTime;

    /**检票时间段 :结束时间 格式：hh:mm*/
    private String                 endTime;

    /**
     * 是否代下单
     */
    private Integer                isNeedTakeOrder;
    /**
     * 核销规则类型
     */
    private Integer                verificationRuleType;
    /**
     * 条件核销单位
     */
    private Integer                fixedVerificationUnit;
    /**
     * 条件核销数值
     */
    private Integer                fixedVerificationTime;
    /**
     * 是否手动核销
     */
    private Integer                isManualVerification;
    /**
     * 退款日期类型
     */
    private Integer                refundDateType;
    /**
     * 退款日期前天数
     */
    private Integer                prerefundDays;
    /**
     * 退款日期前当天时刻-(时）
     */
    private Integer                prerefundHour;
    /**
     * 退款日期前当天时刻-（分）
     */
    private Integer                prerefundMinute;
    /**
     * 退款日期前给供应商退款金额类型
     */
    private Integer                prerefundSupplierFeetype;
    /**
     * 退款日期前给供应商退款金额数值
     */
    private Double                 prerefundSupplierFeevalue;
    /**
     * 退款日期前给分销商退款金额类型
     */
    private Integer                prerefundDistributorFeetype;
    /**
     * 退款日期前给分销商退款金额数值
     */
    private Double                 prerefundDistributorFeevalue;
    /**
     * 退款日期后天数
     */
    private Integer                prorefundDays;
    /**
     * 退款日期后当天时刻-(时）
     */
    private Integer                prorefundHour;
    /**
     * 退款日期后当天时刻-（分）
     */
    private Integer                prorefundMinute;
    /**
     * 退款日期后给供应商退款金额类型
     */
    private Integer                prorefundSupplierFeetype;
    /**
     * 退款日期后给供应商退款金额数值
     */
    private Double                 prorefundSupplierFeevalue;
    /**
     * 退款日期后给分销商退款金额类型
     */
    private Integer                prorefundDistributorFeetype;
    /**
     * 退款日期后给分销商退款金额数值
     */
    private Double                 prorefundDistributorFeevalue;
    /**
     * 提审时间
     */
    private Date                   checkDate;

    private DateQuery              checkDateParam;
    /**
     * 通审时间
     */
    private Date                   publishDate;

    private DateQuery              publishDateParam;

    /** 是否是无限库存
     * 是：SkuProductGlobal.IS_UNLIMITED_INVENTORY
     * 否：SkuProductGlobal.IS_NOT_UNLIMITED_INVENTORY
     * */
    private Boolean                unlimitedInventory;
    
    /** 库存规则id */
    private Long           stockRuleId;



    /** 是否是简单产品 */
    private Boolean                isSimple;

    /** SKU分组类型（父产品、组合产品） */
    private String                 skuGrouping;

    /** 价格属性id */
    private String                 attrInfoId;
    /** 默认值 */
    private Integer                defaultValue;
    /** 是否有价格 */
    private Boolean                hasPrice;
    /** 是否显示价格范围 */
    private Boolean                isDisplayRange;
    /** 是否必选 */
    private Boolean                isRequired;
    /** 参数名称 */
    private String                 skuParamsName;
    /** 基础价格-参数-是否分组 */
    private Integer                paramIsGroup;
    /** 基础价格-参数-分组-最小数 */
    private Integer                minNumber;
    /** 基础价格-参数-分组-最大数 */
    private Integer                maxNumber;

    /** 邮件通知内容 */
    private String                 emailNotification;

    /** 是否二次确认 1是，0否 **/
    private String                 twiceSure;

    /** 逾期清算规则日期类型
     *
     * 游玩有效期结束后 SkuProductGlobal.OVERDUE_DATE_AFTER_PLAYTIME
     * */
    private Integer                overdueVerificationDatetype;

    /** 逾期清算规则日期单位
     * 天  SkuProductGlobal.DATE_UNIT_DAY
     * 时  SkuProductGlobal.DATE_UNIT_HOUR
     * 分  SkuProductGlobal.DATE_UNIT_MINUTE
     * */
    private Integer                overdueVerificationUnit;

    /** 逾期清算规则日期数值*/
    private Integer                overdueVerificationTime;

    /** 逾期清算规则金额类型*/
    private Integer                overdueVerificationFeetype;

    /** 逾期清算规则金额*/
    private Double             overdueVerificationFeevalue;

    /** 消费凭证类型*/
    private Integer                consumerCardType;

    /** 是否是一证一票*/
    private Boolean                isOneVote;

    /** 是否需要选坐*/
    private Boolean                isSelectSeat;
    
    /** 退款日期前是否可退
     * SkuProductGlobal.IS_NEED_REFUND  可退款
     * SkuProductGlobal.IS_NOT_NEED_REFUND  不可退款
     * 
     * */
    private Boolean isNeedPrerefund;
    
    /** 退款日期前退款数量类型
     * SkuProductGlobal.REFUND_QUANTITY_TYPE_ALL 整单退
     * SkuProductGlobal.REFUND_QUANTITY_TYPE_PART 部分退
     * */
    private Integer prerefundQuantityType;
    
    /** 退款日期后是否可退
     * SkuProductGlobal.IS_NEED_REFUND  可退款
     * SkuProductGlobal.IS_NOT_NEED_REFUND  不可退款
     * 
     * */
    private Boolean isNeedProrefund;
    
    /** 退款日期后退款数量类型
     * SkuProductGlobal.REFUND_QUANTITY_TYPE_ALL 整单退
     * SkuProductGlobal.REFUND_QUANTITY_TYPE_PART 部分退
     * */
    private Integer prorefundQuantityType;
    
    
    


    /** 库存数量 */
    @Deprecated
    private Integer                inventory;

    /** 供应商详细信息（查询结果封装使用） */
    @Deprecated
    private SysUser                sysUser;

    /** 产品种类（票种） 线上 线下 */
    @Deprecated
    private String                 productKind;

    /** 产品分类（票品） 团散 */
    @Deprecated
    private String                 productClassify;

    /** 渠道来源(比如客栈渠道来源) */
    @Deprecated
    private String                 productChannel;

    /** 当日时间节点(小时) */
    @Deprecated
    private Integer                hourNode;

    /** 当日时间节点(分钟) */
    @Deprecated
    private Integer                minutesNode;

    /**
     * 零售价
     */
    @Deprecated
    private Double                 retailPrice;

    /**
     * 魔方价
     */
    @Deprecated
    private Double                 mfPrice;
    /**非持久化数据，用于查询结果封装*/
    @Deprecated
    private Double                 minPrice;
    /**
     * 住宿单产品新佣金比例
     */
    @Deprecated
    private Double                 newMfPrice;

    /**
     * 未满减结算规则类型（团）
     *
     */
    @Deprecated
    private Integer                notTotalSettlementType;

    /**
     * 减少结算金额（团）
     */
    @Deprecated
    private Double                 reduceSettlementMoney;

    /**
     * 未满减结算规则类型（散）
     *
     */
    @Deprecated
    private Integer                notTotalSettlementType2nd;

    /**
     * 减少结算金额（散）
     */
    @Deprecated
    private Double                 reduceSettlementMoney2nd;
    
    
    /** 库存id */
    @Deprecated
    private String                   inventoryFkId;

    /**
     * 供应商ID
     * <p/>
     * 用于查询产品，查询时排查此供应商的产品
     */
    private Long                   exSupplierId;

    /**
     * 房间数量
     */
    @Deprecated
    private Integer                bedNum;

    /****************************** pms属性专用start ********************************/
    /**
     * 楼层
     */
    @Deprecated
    private String                 floor;

    /**
     * 房型类型
     */
    @Deprecated
    private String                 roomType;

    /**
     * 房间信息集合
     */
    @Deprecated
    private List<ProductBed>       bedList;

    /**
     * 面积
     */
    @Deprecated
    private String                 area;

    /**
     * 可住人数
     */
    @Deprecated
    private String                 headCount;

    /**
     * 窗户
     */
    @Deprecated
    private String                 windows;

    /**
     * 房间设施
     */
    @Deprecated
    private String                 facilities;

    /**
     * 房型简介
     */
    @Deprecated
    private String                 intro;

    /**
     * 房型照片，多个以,分隔
     */
    @Deprecated
    private String                 photos;

    /** pms房型更新通知状态 ：1 目前与业务段数据一致 2 需要更新业务端数据 */
    @Deprecated
    private String                 notifyUpdateState;

    /**
     * 房型违约金规则
     */
    @Deprecated
    private List<ProductPenalty>   productPenaltys;

    /**
     * 房型价格信息
     */
    @Deprecated
    private List<ProductPriceRule> productPriceRules;

    /**
     * 查询参数：房型类别集合
     */
    @Deprecated
    private List<String>           roomTypes;

    /**
     * 查询参数：房型房间
     */
    @Deprecated
    private ProductBed             queryBed;

    /**
     * 查询参数：房型价格
     */
    @Deprecated
    private ProductPriceRule       queryPriceRule;

    /**
     * 查询参数：房型违约金
     */
    @Deprecated
    private ProductPenalty         queryPenalty;

    /****************************** pms属性专用end **********************************/

    /******************************* sku属性 start **********************************/

    /** skuId */
    @Deprecated
    private String                 skuId;
    /** sku分类id */
    @Deprecated
    private String                 categoryId;

    /** 产品时间类型（天、晚、时分、时间段) */
    @Deprecated
    private String                 allocation;
    /** 可见权限 */
    @Deprecated
    private String                 visibility;
    /** 保留时间 */
    @Deprecated
    private Integer                maintenanceTime;
    /** 计费方式 */
    @Deprecated
    private String                 pricePer;

    /** 地址信(地址或坐标) */
    @Deprecated
    private String                 location;
    /** 地图坐标标题 */
    @Deprecated
    private String                 markerTitle;
    /** 地图坐标描述 */
    @Deprecated
    private String                 markerDescription;
    /** 窗口链接文本 */
    @Deprecated
    private String                 markerLinkText;
    /** 地图缩放级别 */
    @Deprecated
    private Integer                mapZoom;

    /** 更多信息 */
    @Deprecated
    private String                 moreInfoUrl;
    /** 视频URL */
    @Deprecated
    private String                 videoUrl;
    /** 视频开始播放时间 */
    @Deprecated
    private String                 videoStartTime;
    /** 详细信息 */
    @Deprecated
    private String                 details;
    /** 图片信息列表 */
    @Deprecated
    private String                 photoinfoId;
    /** 动态属性id集合 */
    @Deprecated
    private String                 dyncPropId;
    /** 套餐ID */
    @Deprecated
    private String                 pkgId;
    /** 套餐名称 */
    @Deprecated
    private String                 pkgName;
    /** 时间属性id */
    @Deprecated
    private String                 timeSlotsId;

    /** startTime和endTime之间差值（单位与pricePer对应） */
    @Deprecated
    private Double                 timeLength;
    /** 长度默认单位（天、晚、时分） */
    @Deprecated
    private String                 timeUnit;

    /** 事件id */
    @Deprecated
    private String                 scheduleId;
    /** 事件名称 */
    @Deprecated
    private String                 scheduleName;
    /** 按星期设置 */
    @Deprecated
    private String                 weekAvailable;
    /** 权重 */
    @Deprecated
    private Integer                weights;
    /** 适用日期-开始 */
    @Deprecated
    private Date                   startDate;
    /** 适用日期-结束 */
    @Deprecated
    private Date                   endDate;

    @Deprecated
    private String                 skuStartTime;

    @Deprecated
    private String                 skuEndTime;
    /** 卖价 */
    @Deprecated
    private Double                 originalPrice;
    /** 打包关系ID */
    @Deprecated
    private String                 skuPkgId;
    /** 一起买类型（强制、可选） */
    @Deprecated
    private String                 packageType;
    /** 一起买时，折扣信息 */
    @Deprecated
    private Double                 packageDiscount;

    /** 最晚预定设置  0不设置，1最晚预定时间**/
    @Deprecated
    private String                 latestPreset;

    /** 最晚预定设置 提前天数**/
    @Deprecated
    private Integer                latestPresetDays;

    /** 最晚预定设置 预定时间**/
    @Deprecated
    private String                 latestPresetTime;

    /** 省**/
    @Deprecated
    private String                 province;

    /** 市**/
    @Deprecated
    private String                 city;

    /** 区县**/
    @Deprecated
    private String                 county;

    /** 查询参数：适用日期-开始*/
    @Deprecated
    private DateQueryParam         startDateQuery;

    /** 查询参数：适用日期-结束*/
    @Deprecated
    private DateQueryParam         endDateQuery;

    /** 查询参数：查询日期是否在产品可售日期之内*/
    @Deprecated
    private DateQueryParam         dateQuery;

    /**
     * 用于查询，关联渠道id
     */
    private List<Long>             channelIds;

    public DateQueryParam getStartDateQuery() {
        return startDateQuery;
    }

    public void setStartDateQuery(DateQueryParam startDateQuery) {
        this.startDateQuery = startDateQuery;
    }

    public DateQueryParam getEndDateQuery() {
        return endDateQuery;
    }

    public void setEndDateQuery(DateQueryParam endDateQuery) {
        this.endDateQuery = endDateQuery;
    }

    public DateQueryParam getDateQuery() {
        return dateQuery;
    }

    public void setDateQuery(DateQueryParam dateQuery) {
        this.dateQuery = dateQuery;
    }

    /********************************************* sku属性 end *****************************/

    public Long getExSupplierId() {
        return exSupplierId;
    }

    public void setExSupplierId(Long exSupplierId) {
        this.exSupplierId = exSupplierId;
    }

    /** 得到 */
    public String getName() {
        return name;
    }

    /** 设置 */
    public void setName(String name) {
        this.name = name;
    }

    /** 得到 产品id */
    public Long getProductId() {
        return productId;
    }

    /** 设置 产品id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 得到 发布内部序号
     */
    public String getRoductNo() {
        return roductNo;
    }

    /**
     * 设置 发布内部序号
     */
    public void setRoductNo(String roductNo) {
        this.roductNo = roductNo;
    }

    /** 得到 产品code */
    public String getProductCode() {
        return productCode;
    }

    /** 设置 产品code */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /** 得到 发布价格 */
    public Double getProductPrice() {
        return productPrice;
    }

    /** 设置 发布价格 */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    /** 得到 产品类型(票型) */
    public String getProductType() {
        return productType;
    }

    /** 设置 产品类型(票型) */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /** 得到 产品种类（票种） 线上 线下 */
    public String getProductKind() {
        return productKind;
    }

    /** 设置 产品种类（票种） 线上 线下 */
    public void setProductKind(String productKind) {
        this.productKind = productKind;
    }

    /** 得到 产品分类（票品） 团散 */
    public String getProductClassify() {
        return productClassify;
    }

    /** 设置 产品分类（票品） 团散 */
    public void setProductClassify(String productClassify) {
        this.productClassify = productClassify;
    }

    /** 得到 渠道来源(比如客栈渠道来源) */
    public String getProductChannel() {
        return productChannel;
    }

    /** 设置 渠道来源(比如客栈渠道来源) */
    public void setProductChannel(String productChannel) {
        this.productChannel = productChannel;
    }

    /** 得到 剧场区域 */
    public String getRegion() {
        return region;
    }

    /** 设置 剧场区域 */
    public void setRegion(String region) {
        this.region = region;
    }

    /** 得到 剧场场次 */
    public String getRonda() {
        return ronda;
    }

    /** 设置 剧场场次 */
    public void setRonda(String ronda) {
        this.ronda = ronda;
    }

    /** 得到 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /** 设置 */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /** 得到 */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 设置 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /** 设置 */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 排序 */
    public Integer getSort() {
        return sort;
    }

    /** 设置 排序 */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /** 得到 使用状态1启用0禁用2删除3已生成联票4未生成联票 */
    public String getFlag() {
        return flag;
    }

    /** 设置 使用状态1启用0禁用2删除3已生成联票4未生成联票 */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /** 得到 介绍 */
    public String getRemarks() {
        return remarks;
    }

    /** 设置 介绍 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /** 得到 审核状态 0未审核 1 通过 2 拒绝 */
    public String getAuditStatus() {
        return auditStatus;
    }

    /** 设置 审核状态 0未审核 1 通过 2 拒绝 */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    /** 得到 产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票 */
    public String getProCategory() {
        return proCategory;
    }

    /** 设置 产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票 */
    public void setProCategory(String proCategory) {
        this.proCategory = proCategory;
    }

    /** 得到 拒绝理由 */
    public String getReason() {
        return reason;
    }

    /** 设置 拒绝理由 */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /** 得到 供应商 */
    public String getSupplierId() {
        return supplierId;
    }

    /** 设置 供应商 */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 联票子票状态（1未生成 2已生成） */
    public String getPackageStatus() {
        return packageStatus;
    }

    /** 设置 联票子票状态（1未生成 2已生成） */
    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    /** 支持in查询，扩展属性，不持久化 */
    public List<Long> getIds() {
        return ids;
    }

    /** 支持in查询，扩展属性，不持久化 */
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    /** 扩展属性，用于查询，产品类别集合 */
    public List<String> getProCategorys() {
        return proCategorys;
    }

    /** 扩展属性，用于查询，产品类别集合 */
    public void setProCategorys(List<String> proCategorys) {
        this.proCategorys = proCategorys;
    }

    /** 扩展属性，只在程序中使用 */
    public String getTempNo() {
        return tempNo;
    }

    /** 扩展属性，只在程序中使用 */
    public void setTempNo(String tempNo) {
        this.tempNo = tempNo;
    }

    /** 审核状态集合扩展属性，为了支持查询 */
    public List<Long> getAuditStatusList() {
        return auditStatusList;
    }

    /** 审核状态集合扩展属性，为了支持查询 */
    public void setAuditStatusList(List<Long> auditStatusList) {
        this.auditStatusList = auditStatusList;
    }

    /** 扩展属性，票种票品不等于，注意前后顺序 */
    public String getNotEqual() {
        return notEqual;
    }

    /** 扩展属性，票种票品不等于，注意前后顺序 */
    public void setNotEqual(String notEqual) {
        this.notEqual = notEqual;
    }

    public String getCheckInType() {
        return checkInType;
    }

    public void setCheckInType(String checkInType) {
        this.checkInType = checkInType;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public List<String> getSupplierIdList() {
        return supplierIdList;
    }

    public void setSupplierIdList(List<String> supplierIdList) {
        this.supplierIdList = supplierIdList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getHourNode() {
        return hourNode;
    }

    public void setHourNode(Integer hourNode) {
        this.hourNode = hourNode;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getMfPrice() {
        return mfPrice;
    }

    public void setMfPrice(Double mfPrice) {
        this.mfPrice = mfPrice;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public String getTargetSupplierId() {
        return targetSupplierId;
    }

    public void setTargetSupplierId(String targetSupplierId) {
        this.targetSupplierId = targetSupplierId;
    }

    public Integer getMinutesNode() {
        return minutesNode;
    }

    public void setMinutesNode(Integer minutesNode) {
        this.minutesNode = minutesNode;
    }

    public Boolean getIsComposed() {
        return isComposed;
    }

    public void setIsComposed(Boolean isComposed) {
        this.isComposed = isComposed;
    }

    public String getComposeMark() {
        return composeMark;
    }

    public void setComposeMark(String composeMark) {
        this.composeMark = composeMark;
    }

    public String getPopularName() {
        return popularName;
    }

    public void setPopularName(String popularName) {
        this.popularName = popularName;
    }

    public List<String> getProCategorys2() {
        return proCategorys2;
    }

    /** 扩展属性，用于查询，产品类别集合 */
    public void setProCategorys2(List<String> proCategorys) {
        this.proCategorys2 = proCategorys;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Deprecated
    public Double getReduceSettlementMoney() {
        return reduceSettlementMoney;
    }

    @Deprecated
    public void setReduceSettlementMoney(Double reduceSettlementMoney) {
        this.reduceSettlementMoney = reduceSettlementMoney;
    }

    @Deprecated
    public Integer getNotTotalSettlementType() {
        return notTotalSettlementType;
    }

    @Deprecated
    public void setNotTotalSettlementType(Integer notTotalSettlementType) {
        this.notTotalSettlementType = notTotalSettlementType;
    }

    @Deprecated
    public Integer getNotTotalSettlementType2nd() {
        return notTotalSettlementType2nd;
    }

    @Deprecated
    public void setNotTotalSettlementType2nd(Integer notTotalSettlementType2nd) {
        this.notTotalSettlementType2nd = notTotalSettlementType2nd;
    }

    @Deprecated
    public Double getReduceSettlementMoney2nd() {
        return reduceSettlementMoney2nd;
    }

    @Deprecated
    public void setReduceSettlementMoney2nd(Double reduceSettlementMoney2nd) {
        this.reduceSettlementMoney2nd = reduceSettlementMoney2nd;
    }

    public String getReasonRejection() {
        return reasonRejection;
    }

    public void setReasonRejection(String reasonRejection) {
        this.reasonRejection = reasonRejection;
    }

    public Double getNewMfPrice() {
        return newMfPrice;
    }

    public void setNewMfPrice(Double newMfPrice) {
        this.newMfPrice = newMfPrice;
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    /**
     * 获取
     *
     * @return skuId
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * 设置
     *
     * @param skuId
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取sku分类id
     *
     * @return categoryId sku分类id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置sku分类id
     *
     * @param categoryId
     *            sku分类id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取库存数量
     *
     * @return inventory 库存数量
     */
    public Integer getInventory() {
        return inventory;
    }

    /**
     * 设置库存数量
     *
     * @param inventory
     *            库存数量
     */
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    /**
     * 获取是否是无限库存
     *
     * @return unlimitedInventory 是否是无限库存
     */
    public Boolean getUnlimitedInventory() {
        return unlimitedInventory;
    }

    /**
     * 设置是否是无限库存
     *
     * @param unlimitedInventory
     *            是否是无限库存
     */
    public void setUnlimitedInventory(Boolean unlimitedInventory) {
        this.unlimitedInventory = unlimitedInventory;
    }

    /**
     * 获取是否是简单产品
     *
     * @return isSimple 是否是简单产品
     */
    public Boolean getIsSimple() {
        return isSimple;
    }

    /**
     * 设置是否是简单产品
     *
     * @param isSimple
     *            是否是简单产品
     */
    public void setIsSimple(Boolean isSimple) {
        this.isSimple = isSimple;
    }

    /**
     * 获取产品时间类型（天、晚、时分、时间段)
     *
     * @return allocation 产品时间类型（天、晚、时分、时间段)
     */
    public String getAllocation() {
        return allocation;
    }

    /**
     * 设置产品时间类型（天、晚、时分、时间段)
     *
     * @param allocation
     *            产品时间类型（天、晚、时分、时间段)
     */
    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    /**
     * 获取可见权限
     *
     * @return visibility 可见权限
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * 设置可见权限
     *
     * @param visibility
     *            可见权限
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    /**
     * 获取保留时间
     *
     * @return maintenanceTime 保留时间
     */
    public Integer getMaintenanceTime() {
        return maintenanceTime;
    }

    /**
     * 设置保留时间
     *
     * @param maintenanceTime
     *            保留时间
     */
    public void setMaintenanceTime(Integer maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    /**
     * 获取计费方式
     *
     * @return pricePer 计费方式
     */
    public String getPricePer() {
        return pricePer;
    }

    /**
     * 设置计费方式
     *
     * @param pricePer
     *            计费方式
     */
    public void setPricePer(String pricePer) {
        this.pricePer = pricePer;
    }

    /**
     * 获取SKU分组类型（父产品、组合产品）
     *
     * @return skuGrouping SKU分组类型（父产品、组合产品）
     */
    public String getSkuGrouping() {
        return skuGrouping;
    }

    /**
     * 设置SKU分组类型（父产品、组合产品）
     *
     * @param skuGrouping
     *            SKU分组类型（父产品、组合产品）
     */
    public void setSkuGrouping(String skuGrouping) {
        this.skuGrouping = skuGrouping;
    }

    /**
     * 获取地址信(地址或坐标)
     *
     * @return location 地址信(地址或坐标)
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置地址信(地址或坐标)
     *
     * @param location
     *            地址信(地址或坐标)
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取地图坐标标题
     *
     * @return markerTitle 地图坐标标题
     */
    public String getMarkerTitle() {
        return markerTitle;
    }

    /**
     * 设置地图坐标标题
     *
     * @param markerTitle
     *            地图坐标标题
     */
    public void setMarkerTitle(String markerTitle) {
        this.markerTitle = markerTitle;
    }

    /**
     * 获取地图坐标描述
     *
     * @return markerDescription 地图坐标描述
     */
    public String getMarkerDescription() {
        return markerDescription;
    }

    /**
     * 设置地图坐标描述
     *
     * @param markerDescription
     *            地图坐标描述
     */
    public void setMarkerDescription(String markerDescription) {
        this.markerDescription = markerDescription;
    }

    /**
     * 获取窗口链接文本
     *
     * @return markerLinkText 窗口链接文本
     */
    public String getMarkerLinkText() {
        return markerLinkText;
    }

    /**
     * 设置窗口链接文本
     *
     * @param markerLinkText
     *            窗口链接文本
     */
    public void setMarkerLinkText(String markerLinkText) {
        this.markerLinkText = markerLinkText;
    }

    /**
     * 获取地图缩放级别
     *
     * @return mapZoom 地图缩放级别
     */
    public Integer getMapZoom() {
        return mapZoom;
    }

    /**
     * 设置地图缩放级别
     *
     * @param mapZoom
     *            地图缩放级别
     */
    public void setMapZoom(Integer mapZoom) {
        this.mapZoom = mapZoom;
    }

    /**
     * 获取邮件通知内容
     *
     * @return emailNotification 邮件通知内容
     */
    public String getEmailNotification() {
        return emailNotification;
    }

    /**
     * 设置邮件通知内容
     *
     * @param emailNotification
     *            邮件通知内容
     */
    public void setEmailNotification(String emailNotification) {
        this.emailNotification = emailNotification;
    }

    /**
     * 获取更多信息
     *
     * @return moreInfoUrl 更多信息
     */
    public String getMoreInfoUrl() {
        return moreInfoUrl;
    }

    /**
     * 设置更多信息
     *
     * @param moreInfoUrl
     *            更多信息
     */
    public void setMoreInfoUrl(String moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl;
    }

    /**
     * 获取视频URL
     *
     * @return videoUrl 视频URL
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频URL
     *
     * @param videoUrl
     *            视频URL
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * 获取视频开始播放时间
     *
     * @return videoStartTime 视频开始播放时间
     */
    public String getVideoStartTime() {
        return videoStartTime;
    }

    /**
     * 设置视频开始播放时间
     *
     * @param videoStartTime
     *            视频开始播放时间
     */
    public void setVideoStartTime(String videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    /**
     * 获取详细信息
     *
     * @return details 详细信息
     */
    public String getDetails() {
        return details;
    }

    /**
     * 设置详细信息
     *
     * @param details
     *            详细信息
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * 获取图片信息列表
     *
     * @return photoinfoId 图片信息列表
     */
    public String getPhotoinfoId() {
        return photoinfoId;
    }

    /**
     * 设置图片信息列表
     *
     * @param photoinfoId
     *            图片信息列表
     */
    public void setPhotoinfoId(String photoinfoId) {
        this.photoinfoId = photoinfoId;
    }

    /**
     * 获取动态属性id集合
     *
     * @return dyncPropId 动态属性id集合
     */
    public String getDyncPropId() {
        return dyncPropId;
    }

    /**
     * 设置动态属性id集合
     *
     * @param dyncPropId
     *            动态属性id集合
     */
    public void setDyncPropId(String dyncPropId) {
        this.dyncPropId = dyncPropId;
    }

    /**
     * 获取套餐ID
     *
     * @return pkgId 套餐ID
     */
    public String getPkgId() {
        return pkgId;
    }

    /**
     * 设置套餐ID
     *
     * @param pkgId
     *            套餐ID
     */
    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }

    /**
     * 获取套餐名称
     *
     * @return pkgName 套餐名称
     */
    public String getPkgName() {
        return pkgName;
    }

    /**
     * 设置套餐名称
     *
     * @param pkgName
     *            套餐名称
     */
    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    /**
     * 获取时间属性id
     *
     * @return timeSlotsId 时间属性id
     */
    public String getTimeSlotsId() {
        return timeSlotsId;
    }

    /**
     * 设置时间属性id
     *
     * @param timeSlotsId
     *            时间属性id
     */
    public void setTimeSlotsId(String timeSlotsId) {
        this.timeSlotsId = timeSlotsId;
    }

    /**
     * 获取startTime和endTime之间差值（单位与pricePer对应）
     *
     * @return timeLength startTime和endTime之间差值（单位与pricePer对应）
     */
    public Double getTimeLength() {
        return timeLength;
    }

    /**
     * 设置startTime和endTime之间差值（单位与pricePer对应）
     *
     * @param timeLength
     *            startTime和endTime之间差值（单位与pricePer对应）
     */
    public void setTimeLength(Double timeLength) {
        this.timeLength = timeLength;
    }

    /**
     * 获取长度默认单位（天、晚、时分）
     *
     * @return timeUnit 长度默认单位（天、晚、时分）
     */
    public String getTimeUnit() {
        return timeUnit;
    }

    /**
     * 设置长度默认单位（天、晚、时分）
     *
     * @param timeUnit
     *            长度默认单位（天、晚、时分）
     */
    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    /**
     * 获取价格属性id
     *
     * @return attrInfoId 价格属性id
     */
    public String getAttrInfoId() {
        return attrInfoId;
    }

    /**
     * 设置价格属性id
     *
     * @param attrInfoId
     *            价格属性id
     */
    public void setAttrInfoId(String attrInfoId) {
        this.attrInfoId = attrInfoId;
    }

    /**
     * 获取默认值
     *
     * @return defaultValue 默认值
     */
    public Integer getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置默认值
     *
     * @param defaultValue
     *            默认值
     */
    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * 获取是否有价格
     *
     * @return hasPrice 是否有价格
     */
    public Boolean getHasPrice() {
        return hasPrice;
    }

    /**
     * 设置是否有价格
     *
     * @param hasPrice
     *            是否有价格
     */
    public void setHasPrice(Boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    /**
     * 获取是否显示价格范围
     *
     * @return isDisplayRange 是否显示价格范围
     */
    public Boolean getIsDisplayRange() {
        return isDisplayRange;
    }

    /**
     * 设置是否显示价格范围
     *
     * @param isDisplayRange
     *            是否显示价格范围
     */
    public void setIsDisplayRange(Boolean isDisplayRange) {
        this.isDisplayRange = isDisplayRange;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * 获取参数名称
     *
     * @return skuParamsName 参数名称
     */
    public String getSkuParamsName() {
        return skuParamsName;
    }

    /**
     * 设置参数名称
     *
     * @param skuParamsName
     *            参数名称
     */
    public void setSkuParamsName(String skuParamsName) {
        this.skuParamsName = skuParamsName;
    }

    /**
     * 获取基础价格-参数-是否分组
     *
     * @return paramIsGroup 基础价格-参数-是否分组
     */
    public Integer getParamIsGroup() {
        return paramIsGroup;
    }

    /**
     * 设置基础价格-参数-是否分组
     *
     * @param paramIsGroup
     *            基础价格-参数-是否分组
     */
    public void setParamIsGroup(Integer paramIsGroup) {
        this.paramIsGroup = paramIsGroup;
    }

    /**
     * 获取基础价格-参数-分组-最小数
     *
     * @return minNumber 基础价格-参数-分组-最小数
     */
    public Integer getMinNumber() {
        return minNumber;
    }

    /**
     * 设置基础价格-参数-分组-最小数
     *
     * @param minNumber
     *            基础价格-参数-分组-最小数
     */
    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    /**
     * 获取基础价格-参数-分组-最大数
     *
     * @return maxNumber 基础价格-参数-分组-最大数
     */
    public Integer getMaxNumber() {
        return maxNumber;
    }

    /**
     * 设置基础价格-参数-分组-最大数
     *
     * @param maxNumber
     *            基础价格-参数-分组-最大数
     */
    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * 获取事件id
     *
     * @return scheduleId 事件id
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * 设置事件id
     *
     * @param scheduleId
     *            事件id
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * 获取事件名称
     *
     * @return scheduleName 事件名称
     */
    public String getScheduleName() {
        return scheduleName;
    }

    /**
     * 设置事件名称
     *
     * @param scheduleName
     *            事件名称
     */
    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    /**
     * 获取按星期设置
     *
     * @return weekAvailable 按星期设置
     */
    public String getWeekAvailable() {
        return weekAvailable;
    }

    /**
     * 设置按星期设置
     *
     * @param weekAvailable
     *            按星期设置
     */
    public void setWeekAvailable(String weekAvailable) {
        this.weekAvailable = weekAvailable;
    }

    /**
     * 获取权重
     *
     * @return weights 权重
     */
    public Integer getWeights() {
        return weights;
    }

    /**
     * 设置权重
     *
     * @param weights
     *            权重
     */
    public void setWeights(Integer weights) {
        this.weights = weights;
    }

    /**
     * 获取适用日期-开始
     *
     * @return startDate 适用日期-开始
     */
    public java.util.Date getStartDate() {
        return startDate;
    }

    /**
     * 设置适用日期-开始
     *
     * @param startDate
     *            适用日期-开始
     */
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取适用日期-结束
     *
     * @return endDate 适用日期-结束
     */
    public java.util.Date getEndDate() {
        return endDate;
    }

    /**
     * 设置适用日期-结束
     *
     * @param endDate
     *            适用日期-结束
     */
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取卖价
     *
     * @return originalPrice 卖价
     */
    public Double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置卖价
     *
     * @param originalPrice
     *            卖价
     */
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取打包关系ID
     *
     * @return skuPkgId 打包关系ID
     */
    public String getSkuPkgId() {
        return skuPkgId;
    }

    /**
     * 设置打包关系ID
     *
     * @param skuPkgId
     *            打包关系ID
     */
    public void setSkuPkgId(String skuPkgId) {
        this.skuPkgId = skuPkgId;
    }

    /**
     * 获取一起买类型（强制、可选）
     *
     * @return packageType 一起买类型（强制、可选）
     */
    public String getPackageType() {
        return packageType;
    }

    /**
     * 设置一起买类型（强制、可选）
     *
     * @param packageType
     *            一起买类型（强制、可选）
     */
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    /**
     * 获取一起买时，折扣信息
     *
     * @return packageDiscount 一起买时，折扣信息
     */
    public Double getPackageDiscount() {
        return packageDiscount;
    }

    /**
     * 设置一起买时，折扣信息
     *
     * @param packageDiscount
     *            一起买时，折扣信息
     */
    public void setPackageDiscount(Double packageDiscount) {
        this.packageDiscount = packageDiscount;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    /**
     * 获取扩展属性，用于查询，产品关联政策Ids
     *
     * @return strategyIds 扩展属性，用于查询，产品关联政策Ids
     */
    public List<Long> getStrategyIds() {
        return strategyIds;
    }

    /**
     * 设置扩展属性，用于查询，产品关联政策Ids
     *
     * @param strategyIds
     *            扩展属性，用于查询，产品关联政策Ids
     */
    public void setStrategyIds(List<Long> strategyIds) {
        this.strategyIds = strategyIds;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getTwiceSure() {
        return twiceSure;
    }

    public void setTwiceSure(String twiceSure) {
        this.twiceSure = twiceSure;
    }

    public String getLatestPreset() {
        return latestPreset;
    }

    public void setLatestPreset(String latestPreset) {
        this.latestPreset = latestPreset;
    }

    public Integer getLatestPresetDays() {
        return latestPresetDays;
    }

    public void setLatestPresetDays(Integer latestPresetDays) {
        this.latestPresetDays = latestPresetDays;
    }

    public String getLatestPresetTime() {
        return latestPresetTime;
    }

    public void setLatestPresetTime(String latestPresetTime) {
        this.latestPresetTime = latestPresetTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getIsNeedTakeOrder() {
        return isNeedTakeOrder;
    }

    public void setIsNeedTakeOrder(Integer isNeedTakeOrder) {
        this.isNeedTakeOrder = isNeedTakeOrder;
    }

    public Integer getVerificationRuleType() {
        return verificationRuleType;
    }

    public void setVerificationRuleType(Integer verificationRuleType) {
        this.verificationRuleType = verificationRuleType;
    }

    public Integer getFixedVerificationUnit() {
        return fixedVerificationUnit;
    }

    public void setFixedVerificationUnit(Integer fixedVerificationUnit) {
        this.fixedVerificationUnit = fixedVerificationUnit;
    }

    public Integer getFixedVerificationTime() {
        return fixedVerificationTime;
    }

    public void setFixedVerificationTime(Integer fixedVerificationTime) {
        this.fixedVerificationTime = fixedVerificationTime;
    }

    public Integer getIsManualVerification() {
        return isManualVerification;
    }

    public void setIsManualVerification(Integer isManualVerification) {
        this.isManualVerification = isManualVerification;
    }

    public Integer getRefundDateType() {
        return refundDateType;
    }

    public void setRefundDateType(Integer refundDateType) {
        this.refundDateType = refundDateType;
    }

    public Integer getPrerefundDays() {
        return prerefundDays;
    }

    public void setPrerefundDays(Integer prerefundDays) {
        this.prerefundDays = prerefundDays;
    }

    public Integer getPrerefundHour() {
        return prerefundHour;
    }

    public void setPrerefundHour(Integer prerefundHour) {
        this.prerefundHour = prerefundHour;
    }

    public Integer getPrerefundMinute() {
        return prerefundMinute;
    }

    public void setPrerefundMinute(Integer prerefundMinute) {
        this.prerefundMinute = prerefundMinute;
    }

    public Integer getPrerefundSupplierFeetype() {
        return prerefundSupplierFeetype;
    }

    public void setPrerefundSupplierFeetype(Integer prerefundSupplierFeetype) {
        this.prerefundSupplierFeetype = prerefundSupplierFeetype;
    }

    public Double getPrerefundSupplierFeevalue() {
        return prerefundSupplierFeevalue;
    }

    public void setPrerefundSupplierFeevalue(Double prerefundSupplierFeevalue) {
        this.prerefundSupplierFeevalue = prerefundSupplierFeevalue;
    }

    public Integer getPrerefundDistributorFeetype() {
        return prerefundDistributorFeetype;
    }

    public void setPrerefundDistributorFeetype(Integer prerefundDistributorFeetype) {
        this.prerefundDistributorFeetype = prerefundDistributorFeetype;
    }

    public Double getPrerefundDistributorFeevalue() {
        return prerefundDistributorFeevalue;
    }

    public void setPrerefundDistributorFeevalue(Double prerefundDistributorFeevalue) {
        this.prerefundDistributorFeevalue = prerefundDistributorFeevalue;
    }

    public Integer getProrefundDays() {
        return prorefundDays;
    }

    public void setProrefundDays(Integer prorefundDays) {
        this.prorefundDays = prorefundDays;
    }

    public Integer getProrefundHour() {
        return prorefundHour;
    }

    public void setProrefundHour(Integer prorefundHour) {
        this.prorefundHour = prorefundHour;
    }

    public Integer getProrefundMinute() {
        return prorefundMinute;
    }

    public void setProrefundMinute(Integer prorefundMinute) {
        this.prorefundMinute = prorefundMinute;
    }

    public Integer getProrefundSupplierFeetype() {
        return prorefundSupplierFeetype;
    }

    public void setProrefundSupplierFeetype(Integer prorefundSupplierFeetype) {
        this.prorefundSupplierFeetype = prorefundSupplierFeetype;
    }

    public Double getProrefundSupplierFeevalue() {
        return prorefundSupplierFeevalue;
    }

    public void setProrefundSupplierFeevalue(Double prorefundSupplierFeevalue) {
        this.prorefundSupplierFeevalue = prorefundSupplierFeevalue;
    }

    public Integer getProrefundDistributorFeetype() {
        return prorefundDistributorFeetype;
    }

    public void setProrefundDistributorFeetype(Integer prorefundDistributorFeetype) {
        this.prorefundDistributorFeetype = prorefundDistributorFeetype;
    }

    public Double getProrefundDistributorFeevalue() {
        return prorefundDistributorFeevalue;
    }

    public void setProrefundDistributorFeevalue(Double prorefundDistributorFeevalue) {
        this.prorefundDistributorFeevalue = prorefundDistributorFeevalue;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    

    public Integer getOverdueVerificationDatetype() {
        return overdueVerificationDatetype;
    }

    public void setOverdueVerificationDatetype(Integer overdueVerificationDatetype) {
        this.overdueVerificationDatetype = overdueVerificationDatetype;
    }

    public Integer getOverdueVerificationUnit() {
        return overdueVerificationUnit;
    }

    public void setOverdueVerificationUnit(Integer overdueVerificationUnit) {
        this.overdueVerificationUnit = overdueVerificationUnit;
    }

    public Integer getOverdueVerificationTime() {
        return overdueVerificationTime;
    }

    public void setOverdueVerificationTime(Integer overdueVerificationTime) {
        this.overdueVerificationTime = overdueVerificationTime;
    }

    public Integer getOverdueVerificationFeetype() {
        return overdueVerificationFeetype;
    }

    public void setOverdueVerificationFeetype(Integer overdueVerificationFeetype) {
        this.overdueVerificationFeetype = overdueVerificationFeetype;
    }

    public Double getOverdueVerificationFeevalue() {
        return overdueVerificationFeevalue;
    }

    public void setOverdueVerificationFeevalue(Double overdueVerificationFeevalue) {
        this.overdueVerificationFeevalue = overdueVerificationFeevalue;
    }

    public Integer getConsumerCardType() {
        return consumerCardType;
    }

    public void setConsumerCardType(Integer consumerCardType) {
        this.consumerCardType = consumerCardType;
    }

    public Boolean getIsOneVote() {
    	
    	return getIsSupplierIsOneVote() || getIsProductIsOneVote();

    }
    private Boolean getIsProductIsOneVote(){
    	if(this.getId() == null){
    		return false;
    	}
    	String isOneVote = getLoader().getProperty("sku.isOneVote");
        return StringUtils.isNotBlank(isOneVote) && isOneVote.contains(this.getId().toString());
    }
    private Boolean getIsSupplierIsOneVote(){
    	if(this.supplierId == null)
    		return false;
    	String supplierIsOneVote = getLoader().getProperty("supplier.isOneVote");
    	return StringUtils.isNotBlank(supplierIsOneVote) && supplierIsOneVote.contains(this.supplierId);
    }

    public void setIsOneVote(Boolean isOneVote) {
        this.isOneVote = isOneVote;
    }

    public Boolean getIsSelectSeat() {
    
        return getIsSupplierIsSelectSeat() || getIsProductIsSelectSeat();
    }
    
    private Boolean getIsProductIsSelectSeat(){
    	if(this.getId() == null){
    		return false;
    	}
    	String isSelectSeat = getLoader().getProperty("sku.isSelectSeat");
        return StringUtils.isNotBlank(isSelectSeat) && isSelectSeat.contains(this.getId().toString());
    }
    private Boolean getIsSupplierIsSelectSeat(){
    	if(this.supplierId == null ){
    		return false;
    	}
    	String supplierIsSelectSeat = getLoader().getProperty("supplier.isSelectSeat");
    	return StringUtils.isNotBlank(supplierIsSelectSeat) && supplierIsSelectSeat.contains(this.supplierId);
    }

    public void setIsSelectSeat(Boolean isSelectSeat) {
        this.isSelectSeat = isSelectSeat;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSkuStartTime() {
        return skuStartTime;
    }

    public void setSkuStartTime(String skuStartTime) {
        this.skuStartTime = skuStartTime;
    }

    public String getSkuEndTime() {
        return skuEndTime;
    }

    public void setSkuEndTime(String skuEndTime) {
        this.skuEndTime = skuEndTime;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public List<ProductBed> getBedList() {
        return bedList;
    }

    public void setBedList(List<ProductBed> bedList) {
        this.bedList = bedList;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHeadCount() {
        return headCount;
    }

    public void setHeadCount(String headCount) {
        this.headCount = headCount;
    }

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getNotifyUpdateState() {
        return notifyUpdateState;
    }

    public void setNotifyUpdateState(String notifyUpdateState) {
        this.notifyUpdateState = notifyUpdateState;
    }

    public List<ProductPenalty> getProductPenaltys() {
        return productPenaltys;
    }

    public void setProductPenaltys(List<ProductPenalty> productPenaltys) {
        this.productPenaltys = productPenaltys;
    }

    public List<ProductPriceRule> getProductPriceRules() {
        return productPriceRules;
    }

    public void setProductPriceRules(List<ProductPriceRule> productPriceRules) {
        this.productPriceRules = productPriceRules;
    }

    public List<String> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<String> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public ProductBed getQueryBed() {
        return queryBed;
    }

    public void setQueryBed(ProductBed queryBed) {
        this.queryBed = queryBed;
    }

    public ProductPriceRule getQueryPriceRule() {
        return queryPriceRule;
    }

    public void setQueryPriceRule(ProductPriceRule queryPriceRule) {
        this.queryPriceRule = queryPriceRule;
    }

    public ProductPenalty getQueryPenalty() {
        return queryPenalty;
    }

    public DateQuery getCheckDateParam() {
        return checkDateParam;
    }

    public void setCheckDateParam(DateQuery checkDateParam) {
        this.checkDateParam = checkDateParam;
    }

    public DateQuery getPublishDateParam() {
        return publishDateParam;
    }

    public void setPublishDateParam(DateQuery publishDateParam) {
        this.publishDateParam = publishDateParam;
    }

    public List<Long> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Long> channelIds) {
        this.channelIds = channelIds;
    }

	public Long getStockRuleId() {
		return stockRuleId;
	}

	public void setStockRuleId(Long stockRuleId) {
		this.stockRuleId = stockRuleId;
	}

	public String getInventoryFkId() {
		return inventoryFkId;
	}

	public void setInventoryFkId(String inventoryFkId) {
		this.inventoryFkId = inventoryFkId;
	}
	
	
	
	
	public Boolean getIsNeedPrerefund() {
		return isNeedPrerefund;
	}

	public void setIsNeedPrerefund(Boolean isNeedPrerefund) {
		this.isNeedPrerefund = isNeedPrerefund;
	}

	public Integer getPrerefundQuantityType() {
		return prerefundQuantityType;
	}

	public void setPrerefundQuantityType(Integer prerefundQuantityType) {
		this.prerefundQuantityType = prerefundQuantityType;
	}

	public Boolean getIsNeedProrefund() {
		return isNeedProrefund;
	}

	public void setIsNeedProrefund(Boolean isNeedProrefund) {
		this.isNeedProrefund = isNeedProrefund;
	}

	public Integer getProrefundQuantityType() {
		return prorefundQuantityType;
	}

	public void setProrefundQuantityType(Integer prorefundQuantityType) {
		this.prorefundQuantityType = prorefundQuantityType;
	}

	private PropertiesLoader getLoader(){
		try{
			if(loader == null){
				loader = new PropertiesLoader("sku_configure.properties");
			}
			return loader;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}
	
    
}