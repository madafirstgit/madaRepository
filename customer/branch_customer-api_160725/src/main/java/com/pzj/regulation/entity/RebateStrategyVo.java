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
import com.pzj.base.entity.SysRebateStrategy;

public class RebateStrategyVo extends BaseVO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 82815693628916550L;

    private Long id;

    /**
     * 景区ID
     */
    private Long sceneId;

    /**
     * 多个反例ID，用于查询
     */
    private List<Long> ids;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 返利价格
     */
    private Double rebatePrice;

    /**
     * 返利对象(总社H、地接部门D、优先部门DH、导游G)
     */
    private String rebateObject;

    /**
     * 返利周期类型（定期返1、按月按天返2）
     */
    private Integer rebateCycleType;

    /**
     * 返利周期(YEAR/MONTH/WEEK/DAY)
     */
    private String rebateCycle;

    /**
     * 返利按月按天返数量
     */
    private Integer rebatePerMonth;

    /**
     * 返利结算周期值
     */
    private Integer rebateCycleValue;

    /**
     * 返利数量
     */
    private Double rebateAmount;

    /**
     * 返利形式 参考字典，根据ChannelGlobalDict中的rebateMethod()获取字典数据， 0为现金返利，2为返利积分
     */
    private Integer rebateType;

    /**
     * 结算方式
     * 
     */
    private Integer rebateSettlement;

    /**
     * 状态（1：启动、 0 ：禁用 2: 删除）参照GlobalParam.FLAG'
     */
    private Integer delFlag;

    /**
     * 返利类型(（1 前返， 2， 后返 默认2）)
     */
    private Integer type;

    /**
     * 创建平台
     */
    private String dataSource;;

    /**
     * 创建供应商ID
     */
    private Long supplierId;

    /**
     * 积分规则ID
     */
    private Long integralId;

    /**
     * 积分规则数量
     */
    private Integer integralValue;

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
    private Date updateDate;

    /**
     * 是否存在加点返利(0否，1是)
     */
    private Integer isExtraRebate;

    /*** pms/一日游新加字段 ******************************************/

    /** 返利比类型： 成人：1 儿童：2 （pms）不分类型：0 */
    private Integer rebateRateType;

    /** 返利比 */
    private Double rebateRate;

    /*** pms新加字段 ******************************************/

    /**
     * 获取pms新加字段
     * 
     * @return rebateRateType pms新加字段
     */
    public Integer getRebateRateType() {
        return rebateRateType;
    }

    /**
     * 设置pms新加字段
     * 
     * @param rebateRateType
     *            pms新加字段
     */
    public void setRebateRateType(Integer rebateRateType) {
        this.rebateRateType = rebateRateType;
    }

    /**
     * 获取rebateRate
     * 
     * @return rebateRate rebateRate
     */
    public Double getRebateRate() {
        return rebateRate;
    }

    /**
     * 设置rebateRate
     * 
     * @param rebateRate
     *            rebateRate
     */
    public void setRebateRate(Double rebateRate) {
        this.rebateRate = rebateRate;
    }

    /**
     * 加点返利规则
     */
    private List<ExtraRebateStrategyVo> sysExtraRebateStrategyList;

    public List<ExtraRebateStrategyVo> getSysExtraRebateStrategyList() {
        return sysExtraRebateStrategyList;
    }

    public void setSysExtraRebateStrategyList(List<ExtraRebateStrategyVo> sysExtraRebateStrategyList) {
        this.sysExtraRebateStrategyList = sysExtraRebateStrategyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(Double rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    /**
     * <h3>获取返利形式</h3>
     * <p>
     * 参考字典，根据ChannelGlobalDict中的rebateMethod()获取字典数据。
     * </p>
     * <p>
     * 1为现金返利，2为按票返利，3返利积分，以数据库中为准。
     * </p>
     * 
     * @return
     */
    public Integer getRebateType() {
        return rebateType;
    }

    /**
     * <h3>设置返利形式</h3>
     * <p>
     * 参考字典，根据ChannelGlobalDict中的rebateMethod()获取字典数据。
     * </p>
     * <p>
     * 1为现金返利，2为按票返利，3返利积分，以数据库中为准。
     * </p>
     * 
     * @param rebateType
     */
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

    /**
     * 多个反例ID，用于查询
     * 
     * @return
     */
    public List<Long> getIds() {
        return ids;
    }

    /**
     * 多个反例ID，用于查询
     * 
     * @param ids
     */
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Integer getRebateCycleValue() {
        return rebateCycleValue;
    }

    public void setRebateCycleValue(Integer rebateCycleValue) {
        this.rebateCycleValue = rebateCycleValue;
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
     * Vo转换为底层实体
     * 
     * @param rebateStrategyVo
     * @return
     * @throws Exception
     */
    public static SysRebateStrategy changeTSysBean(RebateStrategyVo rebateStrategyVo) throws Exception {
        if (rebateStrategyVo == null) {
            return null;
        }
        SysRebateStrategy sysRebateStrategy = new SysRebateStrategy();
        sysRebateStrategy.setId(rebateStrategyVo.getId());
        sysRebateStrategy.setSceneId(rebateStrategyVo.getSceneId());
        sysRebateStrategy.setProductId(rebateStrategyVo.getProductId());
        sysRebateStrategy.setProductName(rebateStrategyVo.getProductName());
        sysRebateStrategy.setRebatePrice(rebateStrategyVo.getRebatePrice());
        sysRebateStrategy.setRebateObject(rebateStrategyVo.getRebateObject());
        sysRebateStrategy.setRebateCycle(rebateStrategyVo.getRebateCycle());
        sysRebateStrategy.setRebateAmount(rebateStrategyVo.getRebateAmount());
        sysRebateStrategy.setRebateType(rebateStrategyVo.getRebateType());
        sysRebateStrategy.setDelFlag(rebateStrategyVo.getDelFlag());
        sysRebateStrategy.setType(rebateStrategyVo.getType());
        sysRebateStrategy.setDataSource(rebateStrategyVo.getDataSource());
        sysRebateStrategy.setSupplierId(rebateStrategyVo.getSupplierId());
        sysRebateStrategy.setIntegralId(rebateStrategyVo.getIntegralId());
        sysRebateStrategy.setIntegralValue(rebateStrategyVo.getIntegralValue());
        sysRebateStrategy.setCreateBy(rebateStrategyVo.getCreateBy());
        sysRebateStrategy.setCreateDate(rebateStrategyVo.getCreateDate());
        sysRebateStrategy.setUpdateBy(rebateStrategyVo.getUpdateBy());
        sysRebateStrategy.setUpdateDate(rebateStrategyVo.getUpdateDate());
        sysRebateStrategy.setSysExtraRebateStrategyList(ExtraRebateStrategyVo.cList2SList(rebateStrategyVo.getSysExtraRebateStrategyList()));

        sysRebateStrategy.setIsExtraRebate(rebateStrategyVo.getIsExtraRebate());
        sysRebateStrategy.setIds(rebateStrategyVo.getIds());
        sysRebateStrategy.setRebateCycleValue(rebateStrategyVo.getRebateCycleValue());
        sysRebateStrategy.setRebateSettlement(rebateStrategyVo.getRebateSettlement());
        sysRebateStrategy.setRebatePerMonth(rebateStrategyVo.getRebatePerMonth());
        sysRebateStrategy.setRebateCycleType(rebateStrategyVo.getRebateCycleType());
        sysRebateStrategy.setRebateRate(rebateStrategyVo.getRebateRate());
        sysRebateStrategy.setRebateRateType(rebateStrategyVo.getRebateRateType());

        return sysRebateStrategy;
    }

    /**
     * 底层实体转换为Vo
     * 
     * @param sysRebateStrategy
     * @return
     * @throws Exception
     */
    public static RebateStrategyVo changeTAPIBean(SysRebateStrategy sysRebateStrategy) throws Exception {
        if (sysRebateStrategy == null) {
            return null;
        }
        RebateStrategyVo rebateStrategyVo = new RebateStrategyVo();
        rebateStrategyVo.setId(sysRebateStrategy.getId());
        rebateStrategyVo.setSceneId(sysRebateStrategy.getSceneId());
        rebateStrategyVo.setProductId(sysRebateStrategy.getProductId());
        rebateStrategyVo.setProductName(sysRebateStrategy.getProductName());
        rebateStrategyVo.setRebatePrice(sysRebateStrategy.getRebatePrice());
        rebateStrategyVo.setRebateObject(sysRebateStrategy.getRebateObject());
        rebateStrategyVo.setRebateCycle(sysRebateStrategy.getRebateCycle());
        rebateStrategyVo.setRebateAmount(sysRebateStrategy.getRebateAmount());
        rebateStrategyVo.setRebateType(sysRebateStrategy.getRebateType());
        rebateStrategyVo.setDelFlag(sysRebateStrategy.getDelFlag());
        rebateStrategyVo.setType(sysRebateStrategy.getType());
        rebateStrategyVo.setDataSource(sysRebateStrategy.getDataSource());
        Long supplierId = sysRebateStrategy.getSupplierId();
        if (supplierId != null && !supplierId.equals(0L))
            rebateStrategyVo.setSupplierId(supplierId);
        Long integralId = sysRebateStrategy.getIntegralId();
        if (integralId != null && !integralId.equals(0L))
            rebateStrategyVo.setIntegralId(integralId);
        rebateStrategyVo.setIntegralValue(sysRebateStrategy.getIntegralValue());
        rebateStrategyVo.setCreateBy(sysRebateStrategy.getCreateBy());
        rebateStrategyVo.setCreateDate(sysRebateStrategy.getCreateDate());
        rebateStrategyVo.setUpdateBy(sysRebateStrategy.getUpdateBy());
        rebateStrategyVo.setUpdateDate(sysRebateStrategy.getUpdateDate());
        rebateStrategyVo.setSysExtraRebateStrategyList(ExtraRebateStrategyVo.sList2CList(sysRebateStrategy.getSysExtraRebateStrategyList()));

        rebateStrategyVo.setIsExtraRebate(sysRebateStrategy.getIsExtraRebate());
        rebateStrategyVo.setRebateCycleValue(sysRebateStrategy.getRebateCycleValue());
        rebateStrategyVo.setRebateCycleType(sysRebateStrategy.getRebateCycleType());
        rebateStrategyVo.setRebatePerMonth(sysRebateStrategy.getRebatePerMonth());
        rebateStrategyVo.setRebateSettlement(sysRebateStrategy.getRebateSettlement());

        rebateStrategyVo.setRebateRate(sysRebateStrategy.getRebateRate());
        rebateStrategyVo.setRebateRateType(sysRebateStrategy.getRebateRateType());
        return rebateStrategyVo;
    }

    public static SysRebateStrategy createNew(RebateStrategyVo vo) throws Exception {
        // 验证
        validData(vo);

        // 设置默认参数
        setDefaultData(vo);

        // 转换
        return changeTSysBean(vo);

    }

    public static List<SysRebateStrategy> cList2SList(List<RebateStrategyVo> beanList) throws Exception {
        List<SysRebateStrategy> sysList = null;
        if (beanList != null) {
            sysList = new ArrayList<SysRebateStrategy>();
            for (RebateStrategyVo vo : beanList) {

                Long id = vo.getId();
                SysRebateStrategy sysbean = null;
                if (id == null) {
                    sysbean = createNew(vo);
                } else {
                    sysbean = changeTSysBean(vo);
                }

                List<ExtraRebateStrategyVo> sfw = vo.getSysExtraRebateStrategyList();

                if (null != sfw && !sfw.isEmpty()) {
                    List<SysExtraRebateStrategy> strategyList = ExtraRebateStrategyVo.cList2SList(sfw);
                    sysbean.setSysExtraRebateStrategyList(strategyList);
                }

                sysList.add(sysbean);
            }
        }
        return sysList;
    }

    public static List<RebateStrategyVo> sList2CList(List<SysRebateStrategy> sysList) throws Exception {
        List<RebateStrategyVo> list = null;
        if (sysList != null) {
            list = new ArrayList<RebateStrategyVo>();
            for (SysRebateStrategy record : sysList) {
                RebateStrategyVo vo = changeTAPIBean(record);

                List<SysExtraRebateStrategy> qwe = record.getSysExtraRebateStrategyList();

                if (null != qwe && !qwe.isEmpty()) {
                    List<ExtraRebateStrategyVo> sList2CList = ExtraRebateStrategyVo.sList2CList(qwe);
                    vo.setSysExtraRebateStrategyList(sList2CList);
                }

                list.add(vo);
            }
        }
        return list;
    }

    public static void validData(RebateStrategyVo vo) throws ServiceException {
        checkNull(vo, "返利实体不能为null");
    }

    public static void validDataAll(RebateStrategyVo vo) throws ServiceException {
        validData(vo);

        /******* 长度校验 */
    }

    protected static void setDefaultData(RebateStrategyVo vo) {
        if (null == vo.getCreateDate()) {
            vo.setCreateDate(new Date());
        }
        if (null == vo.getDelFlag()) {
            vo.setDelFlag(GlobalParam.FLAG.agree());
        }

    }
}