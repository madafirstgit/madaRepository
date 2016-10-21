package com.pzj.regulation.entity;

import static com.pzj.util.ServiceUtil.checkNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseVO;
import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysExtraRebateStrategy;

/**
 * 加点返利规则VO
 * 
 * @author LIANGNING
 */
public class ExtraRebateStrategyVo extends BaseVO implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 605577430263249739L;

    private Long id;

    /**
     * 返利对象(总社H、地接部门D、优先部门DH、导游G)
     */
    private String rebateObject;

    /**
     * 返利周期(YEAR/MONTH/WEEK/DAY/CURRENT)
     */
    private String rebateCycle;

    /**
     * 返利金额
     */
    private Double rebateAmount;

    /**
     * 返利形式(0为现金返利，1为按票返利，2返利积分)
     */
    private Integer rebateType;

    /**
     * 状态标识（1：启动、 0 ：禁用 2: 删除）参照GlobalParam.FLAG'
     */
    private Integer delFlag;

    /**
     * 积分ID
     */
    private Long integralId;

    /**
     * 积分数量
     */
    private Integer integralValue;

    /**
     * 前置返利 ID
     */
    private Long frontRebateRuleId;

    /**
     * 多个前置返利 ID
     * 
     * 用于查询多个返利的加点返利
     */
    private List<Long> frontRebateRuleIds;

    /**
     * 前置产品ID
     */
    private Long frontProductId;

    /**
     * 前置产品供应商ID
     */
    private CusProductPriceVO frontProductVo;

    /**
     * 时效（单位:小时）
     */
    private Integer validityPeriod;

    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updataDate;

    /**
     * 所属平台
     */
    private String dataSource;

    /**
     * 创建供应商ID
     */
    private Long supplierId;

    /**
     * 时效类型：0小时，1天
     */
    private Integer validityType;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
     * 获取前置产品供应商ID
     * 
     * @return frontProductVo 前置产品供应商ID
     */
    public CusProductPriceVO getFrontProductVo() {
        return frontProductVo;
    }

    /**
     * 设置前置产品供应商ID
     * 
     * @param frontProductVo
     *            前置产品供应商ID
     */
    public void setFrontProductVo(CusProductPriceVO frontProductVo) {
        this.frontProductVo = frontProductVo;
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

    public static SysExtraRebateStrategy createNew(ExtraRebateStrategyVo vo)
            throws Exception {
        // 验证
        validData(vo);

        // 设置默认参数
        setDefaultData(vo);

        // 转换
        return changeTSysBean(vo);

    }

    /**
     * Vo转换为底层实体
     * 
     * @param extraRebateStrategyVo
     * @return
     */
    public static SysExtraRebateStrategy changeTSysBean(
            ExtraRebateStrategyVo extraRebateStrategyVo) {
        if (extraRebateStrategyVo == null) {
            return null;
        }

        SysExtraRebateStrategy sysExtraRebateStrategy = new SysExtraRebateStrategy();
        sysExtraRebateStrategy.setId(extraRebateStrategyVo.getId());
        sysExtraRebateStrategy.setRebateObject(extraRebateStrategyVo
                .getRebateObject());
        sysExtraRebateStrategy.setRebateCycle(extraRebateStrategyVo
                .getRebateCycle());
        sysExtraRebateStrategy.setRebateAmount(extraRebateStrategyVo
                .getRebateAmount());
        sysExtraRebateStrategy.setRebateType(extraRebateStrategyVo
                .getRebateType());
        sysExtraRebateStrategy.setDelFlag(extraRebateStrategyVo.getDelFlag());
        sysExtraRebateStrategy.setIntegralId(extraRebateStrategyVo
                .getIntegralId());
        sysExtraRebateStrategy.setIntegralValue(extraRebateStrategyVo
                .getIntegralValue());
        sysExtraRebateStrategy.setFrontRebateRuleId(extraRebateStrategyVo
                .getFrontRebateRuleId());
        sysExtraRebateStrategy.setFrontProductId(extraRebateStrategyVo
                .getFrontProductId());
        sysExtraRebateStrategy.setValidityPeriod(extraRebateStrategyVo
                .getValidityPeriod());
        sysExtraRebateStrategy.setCreateBy(extraRebateStrategyVo.getCreateBy());
        sysExtraRebateStrategy.setCreateDate(extraRebateStrategyVo
                .getCreateDate());
        sysExtraRebateStrategy.setUpdateBy(extraRebateStrategyVo.getUpdateBy());
        sysExtraRebateStrategy.setUpdataDate(extraRebateStrategyVo
                .getUpdataDate());
        sysExtraRebateStrategy.setDataSource(extraRebateStrategyVo
                .getDataSource());
        sysExtraRebateStrategy.setSupplierId(extraRebateStrategyVo
                .getSupplierId());
        sysExtraRebateStrategy.setValidityType(extraRebateStrategyVo
                .getValidityType());
        return sysExtraRebateStrategy;
    }

    /**
     * 底层实体转换为Vo
     * 
     * @param sysExtraRebateStrategy
     * @return
     */
    public static ExtraRebateStrategyVo changeTAPIBean(
            SysExtraRebateStrategy sysExtraRebateStrategy) {

        if (sysExtraRebateStrategy == null) {
            return null;
        }
        ExtraRebateStrategyVo extraRebateStrategyVo = new ExtraRebateStrategyVo();
        extraRebateStrategyVo.setId(sysExtraRebateStrategy.getId());
        extraRebateStrategyVo.setRebateObject(sysExtraRebateStrategy
                .getRebateObject());
        extraRebateStrategyVo.setRebateCycle(sysExtraRebateStrategy
                .getRebateCycle());
        extraRebateStrategyVo.setRebateAmount(sysExtraRebateStrategy
                .getRebateAmount());
        extraRebateStrategyVo.setRebateType(sysExtraRebateStrategy
                .getRebateType());
        extraRebateStrategyVo.setDelFlag(sysExtraRebateStrategy.getDelFlag());
        extraRebateStrategyVo.setIntegralId(sysExtraRebateStrategy
                .getIntegralId());
        extraRebateStrategyVo.setIntegralValue(sysExtraRebateStrategy
                .getIntegralValue());
        extraRebateStrategyVo.setFrontRebateRuleId(sysExtraRebateStrategy
                .getFrontRebateRuleId());
        extraRebateStrategyVo.setFrontProductId(sysExtraRebateStrategy
                .getFrontProductId());
        extraRebateStrategyVo.setValidityPeriod(sysExtraRebateStrategy
                .getValidityPeriod());
        extraRebateStrategyVo.setCreateBy(sysExtraRebateStrategy.getCreateBy());
        extraRebateStrategyVo.setCreateDate(sysExtraRebateStrategy
                .getCreateDate());
        extraRebateStrategyVo.setUpdateBy(sysExtraRebateStrategy.getUpdateBy());
        extraRebateStrategyVo.setUpdataDate(sysExtraRebateStrategy
                .getUpdataDate());
        extraRebateStrategyVo.setDataSource(sysExtraRebateStrategy
                .getDataSource());
        extraRebateStrategyVo.setSupplierId(sysExtraRebateStrategy
                .getSupplierId());
        extraRebateStrategyVo.setValidityType(sysExtraRebateStrategy
                .getValidityType());
        return extraRebateStrategyVo;
    }

    /**
     * 
     * @param beanList
     * @return
     * @throws Exception
     */
    public static List<SysExtraRebateStrategy> cList2SList(
            List<ExtraRebateStrategyVo> beanList) throws Exception {
        List<SysExtraRebateStrategy> sysList = null;
        if (beanList != null) {
            sysList = new ArrayList<SysExtraRebateStrategy>();
            for (ExtraRebateStrategyVo vo : beanList) {

                SysExtraRebateStrategy sysbean = null;
                Long id = vo.getId();
                if (id == null) {
                    sysbean = createNew(vo);
                } else {
                    sysbean = changeTSysBean(vo);
                }

                sysList.add(sysbean);
            }
        }
        return sysList;
    }

    /**
     * 
     * @param sysList
     * @return
     * @throws Exception
     */
    public static List<ExtraRebateStrategyVo> sList2CList(
            List<SysExtraRebateStrategy> sysList) throws Exception {
        List<ExtraRebateStrategyVo> list = null;
        if (sysList != null) {
            list = new ArrayList<ExtraRebateStrategyVo>();
            for (SysExtraRebateStrategy record : sysList) {
                ExtraRebateStrategyVo vo = changeTAPIBean(record);
                list.add(vo);
            }
        }
        return list;
    }

    public static void validData(ExtraRebateStrategyVo vo)
            throws ServiceException {
        checkNull(vo, "返利实体不能为null");
    }

    protected static void setDefaultData(ExtraRebateStrategyVo vo) {
        if (null == vo.getCreateDate()) {
            vo.setCreateDate(new Date());
        }
        if (null == vo.getDelFlag()) {
            vo.setDelFlag(GlobalParam.FLAG.agree());
        }

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