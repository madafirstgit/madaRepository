package com.pzj.product.vo.product;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SpuProduct implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5572202561238134597L;

    private Long              id;

    /** 备注名称 */
    private String            name;

    /** 产品类别: 
     *  常量 ：GlobalDict.ProductCategory
     * */
    private Integer           productType;

    /** 缩略图 */
    private String            releaseThurl;

    /** 检票时间段:开始时间 */
    private String            startTime;

    /** 检票时间段:结束时间 */
    private String            endTime;

    /** 内部序号 */
    private String            productNo;

    /**  */
    private String            createBy;

    /**  */
    private Date              createDate;

    /**  */
    private String            updateBy;

    /**  */
    private Date              updateDate;

    /** 排序 */
    private Integer           sort;

    /** 使用状态1启用0禁用2删除
     *  
     * */
    private String            flag;

    /** 备注 */
    private String            remarks;

    /** 组合名称 */
    private String            combinationName;

    /** 组合产品编号 */
    private String            combinationCode;

    /** 短信模板 */
    private String            reeaseMessage;

    /** 产品简介 */
    private String            reeaseInfo;

    /** 供应商id*/
    private String            supplierId;

    /**
     * 领票类型
     * <br/>
     * 请参考常量{@link GlobalDict.GainType}
     */
    private Integer           gainType;

    /**
     * 领票人数限制，如果为-1表示不限制
     */
    private Integer           gainPeopleNum;

    /**
     * 同取票人领票时间范围单位
     * <br/>
     * 请参考{@link GlobalParam.DateTime} 中的常量
     */
    private Integer           gainPeopleTimeLimitUnit;

    /**
     * 同取票人领票时间范围数量
     */
    private Integer           gainPeopleTimeLimitValue;

    /**
     * 同取票人领票时间范围值，如果为-1，则不限制
     */
    private Integer           gainPeopleTimePurchaseNum;

    /**
     * 同订单最小起定量
     */
    private Integer           minPurchaseNumInOrder;

    /** 产品是否需要绑定景区*/
    private Integer           isNeedScenic;

    /** 场次名称*/
    private String            rondaName;

    /** 入园方式*/
    private String            checkInType;

    /**入园地址 */
    private String            checkinAddress;

    /** 产品销售开始日期*/
    private Date              saleStartDate;

    /** 产品销售结束日期*/
    private Date              saleEndDate;

    /** 下单是否填写游玩时间
     * 
     * SkuProductGlobal.NEED_PLAYTIME  需要
     * SkuProductGlobal.NOT_NEED_PLAYTIME 需要
     * */
    private Integer           isNeedPlaytime;

    /** 不填写游玩时间下单计算时间类型*/
    private Integer           noPlaytimeOrdertimeType;

    /** 游玩时间/下单后时间数值*/
    private Integer           ordertimeValue;

    /** 游玩时间/下单后时间单位*/
    private Integer           ordertimeUnit;

    /** 产品详情*/
    private String            productInfoDetail;

    /** 一句话特色*/
    private String            oneWordFeature;

    /** 预订须知*/
    private String            orderInfo;

    /** 费用说明*/
    private String            expenseInfo;

    /** 销售技巧*/
    private String            salesmanship;

    /** 重要条款*/
    private String            importantClause;

    /** 注意事项 */
    private String            attentions;

    /** 使用方法*/
    private String            useMethod;

    /**产品可用开始日期 */
    private Date              startDate;

    /** 产品可用结束日期*/
    private Date              endDate;

    /** 产品图片列表*/
    private String            photoinfoId;

    /** URL*/
    private String            moreInfoUrl;

    /** 省*/
    private String            province;

    /** 市*/
    private String            city;

    /** 县 */
    private String            county;

    /** SKU分组类型（父产品、
    组合产品）*/
    private String            skuGrouping;

    /** 当日时间节点 ：*/
    private Integer           hourNode;

    /** 当日时间节点 */
    private Integer           minutesNode;

    /** 总库存 */
    @Deprecated
    private Integer           productSumRepertory;

    /** 可用库存 */
    @Deprecated
    private Integer           productUsableRepertory;

    /**
     * 游玩时间的开始时间的方式
     */
    @Deprecated
    private Integer           playtimeMode;

    /**
     * 游玩时间的数量
     */
    @Deprecated
    private Integer           playtimeValue;

    /**
     * 游玩时间的单位
     */
    @Deprecated
    private Integer           playtimeUnit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getReleaseThurl() {
        return releaseThurl;
    }

    public void setReleaseThurl(String releaseThurl) {
        this.releaseThurl = releaseThurl;
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

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Integer getHourNode() {
        return hourNode;
    }

    public void setHourNode(Integer hourNode) {
        this.hourNode = hourNode;
    }

    public Integer getMinutesNode() {
        return minutesNode;
    }

    public void setMinutesNode(Integer minutesNode) {
        this.minutesNode = minutesNode;
    }

    public Integer getProductSumRepertory() {
        return productSumRepertory;
    }

    public void setProductSumRepertory(Integer productSumRepertory) {
        this.productSumRepertory = productSumRepertory;
    }

    public Integer getProductUsableRepertory() {
        return productUsableRepertory;
    }

    public void setProductUsableRepertory(Integer productUsableRepertory) {
        this.productUsableRepertory = productUsableRepertory;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCombinationName() {
        return combinationName;
    }

    public void setCombinationName(String combinationName) {
        this.combinationName = combinationName;
    }

    public String getCombinationCode() {
        return combinationCode;
    }

    public void setCombinationCode(String combinationCode) {
        this.combinationCode = combinationCode;
    }

    public String getReeaseMessage() {
        return reeaseMessage;
    }

    public void setReeaseMessage(String reeaseMessage) {
        this.reeaseMessage = reeaseMessage;
    }

    public String getReeaseInfo() {
        return reeaseInfo;
    }

    public void setReeaseInfo(String reeaseInfo) {
        this.reeaseInfo = reeaseInfo;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getPlaytimeMode() {
        return playtimeMode;
    }

    public void setPlaytimeMode(Integer playtimeMode) {
        this.playtimeMode = playtimeMode;
    }

    public Integer getPlaytimeValue() {
        return playtimeValue;
    }

    public void setPlaytimeValue(Integer playtimeValue) {
        this.playtimeValue = playtimeValue;
    }

    public Integer getPlaytimeUnit() {
        return playtimeUnit;
    }

    public void setPlaytimeUnit(Integer playtimeUnit) {
        this.playtimeUnit = playtimeUnit;
    }

    public Integer getGainType() {
        return gainType;
    }

    public void setGainType(Integer gainType) {
        this.gainType = gainType;
    }

    public Integer getGainPeopleNum() {
        return gainPeopleNum;
    }

    public void setGainPeopleNum(Integer gainPeopleNum) {
        this.gainPeopleNum = gainPeopleNum;
    }

    public Integer getGainPeopleTimeLimitUnit() {
        return gainPeopleTimeLimitUnit;
    }

    public void setGainPeopleTimeLimitUnit(Integer gainPeopleTimeLimitUnit) {
        this.gainPeopleTimeLimitUnit = gainPeopleTimeLimitUnit;
    }

    public Integer getGainPeopleTimeLimitValue() {
        return gainPeopleTimeLimitValue;
    }

    public void setGainPeopleTimeLimitValue(Integer gainPeopleTimeLimitValue) {
        this.gainPeopleTimeLimitValue = gainPeopleTimeLimitValue;
    }

    public Integer getGainPeopleTimePurchaseNum() {
        return gainPeopleTimePurchaseNum;
    }

    public void setGainPeopleTimePurchaseNum(Integer gainPeopleTimePurchaseNum) {
        this.gainPeopleTimePurchaseNum = gainPeopleTimePurchaseNum;
    }

    public Integer getMinPurchaseNumInOrder() {
        return minPurchaseNumInOrder;
    }

    public void setMinPurchaseNumInOrder(Integer minPurchaseNumInOrder) {
        this.minPurchaseNumInOrder = minPurchaseNumInOrder;
    }

    public Integer getIsNeedScenic() {
        return isNeedScenic;
    }

    public void setIsNeedScenic(Integer isNeedScenic) {
        this.isNeedScenic = isNeedScenic;
    }

    public String getRondaName() {
        return rondaName;
    }

    public void setRondaName(String rondaName) {
        this.rondaName = rondaName;
    }

    public String getCheckInType() {
        return checkInType;
    }

    public void setCheckInType(String checkInType) {
        this.checkInType = checkInType;
    }

    public String getCheckinAddress() {
        return checkinAddress;
    }

    public void setCheckinAddress(String checkinAddress) {
        this.checkinAddress = checkinAddress;
    }

    public Date getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(Date saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public Date getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(Date saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public Integer getIsNeedPlaytime() {
        return isNeedPlaytime;
    }

    public void setIsNeedPlaytime(Integer isNeedPlaytime) {
        this.isNeedPlaytime = isNeedPlaytime;
    }

    public Integer getNoPlaytimeOrdertimeType() {
        return noPlaytimeOrdertimeType;
    }

    public void setNoPlaytimeOrdertimeType(Integer noPlaytimeOrdertimeType) {
        this.noPlaytimeOrdertimeType = noPlaytimeOrdertimeType;
    }

    public Integer getOrdertimeValue() {
        return ordertimeValue;
    }

    public void setOrdertimeValue(Integer ordertimeValue) {
        this.ordertimeValue = ordertimeValue;
    }

    public Integer getOrdertimeUnit() {
        return ordertimeUnit;
    }

    public void setOrdertimeUnit(Integer ordertimeUnit) {
        this.ordertimeUnit = ordertimeUnit;
    }

    public String getOneWordFeature() {
        return oneWordFeature;
    }

    public void setOneWordFeature(String oneWordFeature) {
        this.oneWordFeature = oneWordFeature;
    }

    public String getProductInfoDetail() {
        return productInfoDetail;
    }

    public void setProductInfoDetail(String productInfoDetail) {
        this.productInfoDetail = productInfoDetail;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getExpenseInfo() {
        return expenseInfo;
    }

    public void setExpenseInfo(String expenseInfo) {
        this.expenseInfo = expenseInfo;
    }

    public String getSalesmanship() {
        return salesmanship;
    }

    public void setSalesmanship(String salesmanship) {
        this.salesmanship = salesmanship;
    }

    public String getImportantClause() {
        return importantClause;
    }

    public void setImportantClause(String importantClause) {
        this.importantClause = importantClause;
    }

    public String getAttentions() {
        return attentions;
    }

    public void setAttentions(String attentions) {
        this.attentions = attentions;
    }


    public String getUseMethod() {
		return useMethod;
	}

	public void setUseMethod(String useMethod) {
		this.useMethod = useMethod;
	}

	public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPhotoinfoId() {
        return photoinfoId;
    }

    public void setPhotoinfoId(String photoinfoId) {
        this.photoinfoId = photoinfoId;
    }

    public String getMoreInfoUrl() {
        return moreInfoUrl;
    }

    public void setMoreInfoUrl(String moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSkuGrouping() {
        return skuGrouping;
    }

    public void setSkuGrouping(String skuGrouping) {
        this.skuGrouping = skuGrouping;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
