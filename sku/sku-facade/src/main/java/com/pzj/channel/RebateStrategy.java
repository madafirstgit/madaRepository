package com.pzj.channel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RebateStrategy implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5495770016890550454L;

    private Long              id;

    /**
     * 景区ID
     */
    private Long              sceneId;

    /**
     * 返利ID集合，查询多个时用
     */
    private List<Long>        ids;

    /**
     * 产品ID
     */
    private Long              productId;

    /**
     * 产品名称
     */
    private String            productName;

    /**
     * 返利价格
     */
    private Double            rebatePrice;

    /**
     * 返利对象(总社H、地接部门D、优先部门DH、导游G)
     */
    private String            rebateObject;

    /**
     * 返利周期类型（定期返1、按月按天返2）
     */
    private Integer           rebateCycleType;

    /**
     * 返利周期(YEAR/MONTH/WEEK/DAY)
     */
    private String            rebateCycle;

    /**
     * 返利按月按天返数量
     */
    private Integer           rebatePerMonth;

    /**
     * 线上返利周期数
     */
    private Integer           rebateCycleValue;

    /**
     * 返利金额
     */
    private Double            rebateAmount;

    /**
     * 结算方式(即时返1/周期返0)
     * 
     */
    private Integer           rebateSettlement;

    /**
     * 返利形式(0为现金返利，1为按票返利，2返利积分)
     */
    private Integer           rebateType;

    /**
     * 状态（1：启动、 0 ：禁用 2: 删除）参照GlobalParam.FLAG'
     */
    private Integer           delFlag;

    /**
     * 返利类型
     */
    private Integer           type;

    /**
     * 创建平台
     */
    private String            dataSource;                              ;

    /**
     * 创建供应商ID
     */
    private Long              supplierId;

    /**
     * 积分规则ID
     */
    private Long              integralId;

    /**
     * 积分规则数量
     */
    private Integer           integralValue;

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
    private Date              updateDate;

    /**
     * 是否存在加点返利(0否，1是)
     */
    private Integer           isExtraRebate;

    /** 返利比类型： 成人：1 儿童：2 （pms）不分类型：0 */
    private Integer           rebateRateType;

    /** 返利比 */
    private Double            rebateRate;

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getRebatePrice() {
        return rebatePrice;
    }

    public void setRebatePrice(Double rebatePrice) {
        this.rebatePrice = rebatePrice;
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

    public Integer getRebateCycleValue() {
        return rebateCycleValue;
    }

    public void setRebateCycleValue(Integer rebateCycleValue) {
        this.rebateCycleValue = rebateCycleValue;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 设置是否存在加点返利(0否，1是)
     * 
     * @return the isExtraRebate
     */
    public Integer getIsExtraRebate() {
        return isExtraRebate;
    }

    /**
     * 获取是否存在加点返利(0否，1是)
     * 
     * @param isExtraRebate
     *            the isExtraRebate to set
     */
    public void setIsExtraRebate(Integer isExtraRebate) {
        this.isExtraRebate = isExtraRebate;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Integer getRebateSettlement() {
        return rebateSettlement;
    }

    public void setRebateSettlement(Integer rebateSettlement) {
        this.rebateSettlement = rebateSettlement;
    }

    public Integer getRebatePerMonth() {
        return rebatePerMonth;
    }

    public void setRebatePerMonth(Integer rebatePerMonth) {
        this.rebatePerMonth = rebatePerMonth;
    }

    public Integer getRebateCycleType() {
        return rebateCycleType;
    }

    public void setRebateCycleType(Integer rebateCycleType) {
        this.rebateCycleType = rebateCycleType;
    }

    /**
     * 获取返利比类型：成人：1儿童：2（pms）不分类型：0
     * 
     * @return rebateRateType 返利比类型：成人：1儿童：2（pms）不分类型：0
     */
    public Integer getRebateRateType() {
        return rebateRateType;
    }

    /**
     * 设置返利比类型：成人：1儿童：2（pms）不分类型：0
     * 
     * @param rebateRateType
     *            返利比类型：成人：1儿童：2（pms）不分类型：0
     */
    public void setRebateRateType(Integer rebateRateType) {
        this.rebateRateType = rebateRateType;
    }

    /**
     * 获取返利比
     * 
     * @return rebateRate 返利比
     */
    public Double getRebateRate() {
        return rebateRate;
    }

    /**
     * 设置返利比
     * 
     * @param rebateRate
     *            返利比
     */
    public void setRebateRate(Double rebateRate) {
        this.rebateRate = rebateRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
