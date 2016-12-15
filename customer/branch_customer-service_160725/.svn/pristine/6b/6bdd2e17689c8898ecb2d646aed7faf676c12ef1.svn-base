package com.pzj.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.common.global.UserGlobalDict.ChannelGlobalDict;
import com.pzj.base.common.global.UserGlobalDict.StrategyGlobalDict;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.entity.SysSettlementRule;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.entity.common.SysObjectDictRelation;
import com.pzj.base.entity.common.SysObjectDictRelationChild;
import com.pzj.base.entity.query.SysDateQuery;
import com.pzj.base.entity.voUtil.SysChannelStrategyUtil;
import com.pzj.base.service.sys.IChannelService;
import com.pzj.base.service.sys.IChannelStrategyService;
import com.pzj.base.service.sys.IExtraRebateStrategyService;
import com.pzj.base.service.sys.ILabelRelationService;
import com.pzj.base.service.sys.IRebateStrategyService;
import com.pzj.base.service.sys.ISpcreRelationService;
import com.pzj.base.service.sys.ISysObjectDictRelationService;
import com.pzj.base.service.sys.ISysSettlementRuleService;
import com.pzj.channel.Channel;
import com.pzj.channel.RebateStrategy;
import com.pzj.channel.SettlementRule;
import com.pzj.channel.Strategy;
import com.pzj.channel.service.IStrategyService;
import com.pzj.channel.vo.queryParam.CanSaledStrategyParam;
import com.pzj.channel.vo.queryParam.PCSstrategyParam;
import com.pzj.channel.vo.queryParam.StrategyJudgeParam;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.channel.vo.resultParam.StrategyJudgeResult;
import com.pzj.channel.vo.resultParam.StrategyJudgeResult.JudgeHaveReason;
import com.pzj.common.util.AuthorityUtil;
import com.pzj.common.util.UserEntityUtil;
import com.pzj.dao.SysChannelStrategyMapper;
import com.pzj.framework.context.Result;
import com.pzj.service.Impl.model.CPSCRelation;
import com.pzj.service.Impl.model.ChannelTree;
import com.pzj.service.Impl.model.ProductTree;
import com.pzj.service.Impl.model.SysSpcreRelationIDKey;
import com.pzj.service.Impl.util.CommonConvert;
import com.pzj.service.Impl.util.StrategyConvertUtil;

@Service("channelStrategyService")
public class ChannelStrategyServiceImpl extends BaseUserServiceImpl<SysChannelStrategy, SysChannelStrategyMapper>
                                        implements IChannelStrategyService, IStrategyService {

    @Autowired
    private IChannelService               channelService;

    @Autowired
    private IRebateStrategyService        rebateStrategyService;

    @Autowired
    private ILabelRelationService         labelRelationService;

    @Autowired
    private ISpcreRelationService         spcreRelationService;

    @Autowired
    private IExtraRebateStrategyService   extraRebateStrategyService;

    @Autowired
    private ISysSettlementRuleService     sysSettlementRuleService;

    @Autowired
    private ISysObjectDictRelationService sysObjectDictRelationService;

    @Autowired
    private AuthorityUtil                 authorityUtil;

    @Autowired
    private SysChannelStrategyMapper      tSysChannelStrategyMapper;

    private final SysChannelStrategyUtil  voUtil             = SysChannelStrategyUtil.getInstance();

    private String                        MicroshopSalesType = null;

    public ChannelStrategyServiceImpl() {
        StringBuffer sb = new StringBuffer();
        sb.append(StrategyGlobalDict.salesType()).append("#").append(UserGlobalDict.StrategyGlobalDict.windowTenantMicroshop());

        MicroshopSalesType = sb.toString();
    }

    /**
     * 添加政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 
     * @param strategyList
     *            政策实体
     * 
     * @return 操作成功的数量
     * @throws Exception
     */
    public Integer addBatchAndAuth(List<SysChannelStrategy> strategyList, Boolean isNeedMicroshop) throws Exception {

        Integer num = 0;
        try {
            if (strategyList == null) {
                this.logger.error("方法[ChannelStrategyService.addBatchAndAuth],参数strategyList不可以为空");
                return num;
            }

            logger.info("开始创建政策，参数  isNeedMicroshop ： {} ; strategyList : {}", isNeedMicroshop, JSON.toJSONString(strategyList));

            //添加微店政策
            if (isNeedMicroshop) {
                List<SysChannelStrategy> smicrosList = constructSMicroshopData(strategyList);
                if (!CollectionUtils.isEmpty(smicrosList)) {
                    strategyList.addAll(smicrosList);
                }
            }

            logger.info("开始创建政策： {}", JSON.toJSONString(strategyList));

            for (SysChannelStrategy strategy : strategyList) {
                setStrategyProductId(strategy);

                if (strategy.getIsOpenMultiRebate() == null) {
                    strategy.setIsOpenMultiRebate(StrategyGlobalDict.is_not_microshop_strategy);
                }
                this.insertOrUpdate(strategy);
                List<Long> productIds = strategy.getProductIds();
                List<SysChannel> csList = strategy.getChannelList();
                List<SysRebateStrategy> rslist = strategy.getRebateStrategyList();
                setRebateStrategyId(strategy, rslist);
                this.saveStrategyAllRelation(strategy, productIds, csList, rslist);

            }

        } catch (NumberFormatException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    private List<SysChannelStrategy> constructSMicroshopData(List<SysChannelStrategy> strategyList) throws Exception {
        try {
            if (CollectionUtils.isEmpty(strategyList)) {
                return null;
            }
            List<SysChannelStrategy> result = new ArrayList<SysChannelStrategy>();
            for (SysChannelStrategy bean : strategyList) {
                if (UserGlobalDict.StrategyGlobalDict.groupTicketVarie().equals(bean.getTicketVarie())) {
                    continue;
                }
                if ("1".equals(bean.getIsMF())) {
                    continue;
                }

                SysChannelStrategy newBean = new SysChannelStrategy();
                PropertyUtils.copyProperties(newBean, bean);

                newBean.setName(bean.getName() + "（微店）");
                newBean.setSalesType(MicroshopSalesType);
                newBean.setIsOpenMultiRebate(StrategyGlobalDict.is_microshop_strategy);

                // 用UUID关联普通和微店政策
                UUID uuid = UUID.randomUUID();
                String uuidString = uuid.toString();
                newBean.setDictValue(uuidString);
                bean.setDictValue(uuidString);

                newBean.setRebateStrategyList(constructRSMicroshopData(bean));
                result.add(newBean);
            }
            return result;
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
    }

    // 创建微店返利
    private List<SysRebateStrategy> constructRSMicroshopData(SysChannelStrategy bean) throws Exception {
        if (bean == null) {
            return null;
        }

        if (CollectionUtils.isEmpty(bean.getRebateStrategyList())) {
            List<SysRebateStrategy> result = new ArrayList<SysRebateStrategy>();
            SysRebateStrategy rebate = new SysRebateStrategy();
            rebate.setCreateBy("admin");
            rebate.setCreateDate(new Date());
            rebate.setDataSource(bean.getDataSource());
            rebate.setDelFlag(GlobalParam.FLAG.start());
            rebate.setProductId(bean.getProductId());
            if (null != bean.getAdvicePrice() && !"".equals(bean.getAdvicePrice())) {
                BigDecimal b = new BigDecimal(bean.getAdvicePrice() - bean.getSettlementPrice());
                double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                rebate.setRebateAmount(f1);
            }
            rebate.setRebateObject(UserGlobalDict.ChannelGlobalDict.rebateObjectDistributor());
            rebate.setRebateSettlement(UserGlobalDict.ChannelGlobalDict.rebateSettlementNow());
            rebate.setRebateType(UserGlobalDict.ChannelGlobalDict.rebateMethodMoney());
            rebate.setSupplierId(bean.getSupplierId());
            result.add(rebate);
            return result;
        } else {
            return bean.getRebateStrategyList();
        }

    }

    private void setRebateStrategyId(SysChannelStrategy strategy, List<SysRebateStrategy> rslist) {
        if (CollectionUtils.isNotEmpty(rslist)) {
            Long id = strategy.getId();
            for (SysRebateStrategy rebateStrategy : rslist)
                rebateStrategy.setStrategyId(id);
        }
    }

    private void setStrategyProductId(SysChannelStrategy strategy) {
        List<Long> productIds = strategy.getProductIds();

        setStrategyProductId(strategy, productIds);
    }

    private void setStrategyProductId(SysChannelStrategy strategy, List<Long> productIds) {
        if (strategy.getProductId() == null && productIds != null && productIds.size() > 0) {
            strategy.setProductId(productIds.get(0));
            return;
        }

        if (strategy.getProductId() != null) {
            if (productIds == null) {
                productIds = new ArrayList<>(1);
                productIds.add(strategy.getProductId());
                strategy.setProductIds(productIds);
            } else if (productIds.size() == 0) {
                productIds.add(strategy.getProductId());
            }
        }
    }

    @Override
    public Integer updateBatchAndAuth(List<SysChannelStrategy> strategyList) throws Exception {
        Integer num = 0;
        try {
            if (strategyList == null) {
                this.logger.error("方法[ChannelStrategyService.updateBatchAndAuth],参数strategyList不可以为空");
                return num;
            }
            for (SysChannelStrategy strategy : strategyList) {

                Long id = strategy.getId();
                if (id == null || id < 1) {
                    this.logger.error("方法[ChannelStrategyService.updateStrategyAndAuth],参数strategy的id不可以为空");
                    return num;
                }
                setStrategyProductId(strategy);

                // 新建或更新用户
                num += this.updateByPrimaryKey(strategy);
                List<Long> productIds = strategy.getProductIds();
                List<SysChannel> csList = strategy.getChannelList();
                List<SysRebateStrategy> rslist = strategy.getRebateStrategyList();
                setRebateStrategyId(strategy, rslist);
                this.saveStrategyAllRelation(strategy, productIds, csList, rslist);
            }
        } catch (NumberFormatException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    /**
     * 添加政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 
     * @param strategy
     *            政策实体
     * 
     * @param productIds
     *            产品主键列表
     * 
     * @param csList
     *            渠道实体列表
     * 
     * @param rslist
     *            返利实体列表
     * 
     * @return 政策主键Id
     * @throws Exception
     */
    @Override
    public Long addStrategyAndAuth(SysChannelStrategy strategy, List<Long> productIds, List<SysChannel> csList,
                                   List<SysRebateStrategy> rslist) throws Exception {
        Long id = null;
        try {
            if (strategy == null) {
                this.logger.error("方法[ChannelStrategyService.addStrategyAndAuth],参数strategy不可以为空");
                return id;
            }
            setStrategyProductId(strategy, productIds);
            // 新建或更新政策
            id = this.insertOrUpdate(strategy);

            this.saveStrategyAllRelation(strategy, productIds, csList, rslist);
        } catch (NumberFormatException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return id;
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<SysChannelStrategy> entityList) {
        if (CollectionUtils.isEmpty(entityList))
            return 0;

        Integer integer = super.updateBatchByPrimaryKey(entityList);

        saveSysObjectDictRelationChild(entityList);

        return integer;
    }

    /**
     * 添加政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 
     * @param strategy
     *            政策实体
     * 
     * @param productIds
     *            产品主键列表
     * 
     * @param csList
     *            渠道实体列表
     * 
     * @param rslist
     *            返利实体列表
     * 
     * @return 更新条数
     * @throws Exception
     */
    @Override
    public Long updateStrategyAndAuth(SysChannelStrategy strategy, List<Long> productIds, List<SysChannel> csList,
                                      List<SysRebateStrategy> rslist) throws Exception {
        Long num = 0l;
        try {
            if (strategy == null) {
                this.logger.error("方法[ChannelStrategyService.updateStrategyAndAuth],参数strategy不可以为空");
                return num;
            }
            Long id = strategy.getId();
            if (id == null || id < 1) {
                this.logger.error("方法[ChannelStrategyService.updateStrategyAndAuth],参数strategy的id不可以为空");
                return num;
            }
            setStrategyProductId(strategy, productIds);

            // 新建或更新用户
            num += this.updateByPrimaryKey(strategy);
            setRebateStrategyId(strategy, rslist);
            this.saveStrategyAllRelation(strategy, productIds, csList, rslist);
        } catch (NumberFormatException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    /**
     * 添加政策的所有关系（产品，渠道，返利，减免结算）
     */
    private Long saveStrategyAllRelation(SysChannelStrategy strategy, List<Long> productIds, List<SysChannel> csList,
                                         List<SysRebateStrategy> rslist) throws Exception {
        Long num = 0l;
        Long id = strategy.getId();
        if (id != null) {
            // 添加政策与产品关系信息
            if (productIds != null) {
                num += this.saveStrategyProduct(strategy, productIds, false);
            }

            // 添加政策与渠道关系信息
            if (csList != null) {
                num += this.saveStrategyChannel(strategy, csList, false);
            }

            // 添加政策与返利关系信息
            if (csList != null) {
                num += this.saveStrategyRebate(strategy, rslist, false);
            }

            // 添加加点返关系信息
            num += this.saveSPCRERelation(strategy, productIds, csList, rslist);

            // 添加政策与结算规则关系
            num += this.saveStrategySettlementRule(strategy, false);

            // 保存一些多值字段
            num += saveSysObjectDictRelationChild(strategy);

        }
        return num;

    }

    private List<SysObjectDictRelation> getSysObjectDictRelationChildList(SysChannelStrategy strategy) {

        List<String> salesTypeList = strategy.getSalesTypeValues();

        int salesTypeListSize = 0;
        if (CollectionUtils.isNotEmpty(salesTypeList))
            salesTypeListSize = salesTypeList.size();

        if (salesTypeListSize == 0)
            return null;

        List<SysObjectDictRelation> sysObjectDictRelations = new ArrayList<>(1);

        if (salesTypeListSize > 0) {
            Long strategyId = strategy.getId();
            Long supplierId = strategy.getSupplierId();

            if (strategyId == null || supplierId == null)
                return null;

            SysObjectDictRelation relation = new SysObjectDictRelation();
            relation.setObject("sys_channel_strategy");
            relation.setAttribute("sales_type");
            relation.setObjectId(strategyId);

            List<SysObjectDictRelationChild> sysObjectDictRelationList = new ArrayList<>(salesTypeListSize);
            relation.setChildList(sysObjectDictRelationList);

            for (String keyValueVo : salesTypeList) {
                SysObjectDictRelationChild relationChild = new SysObjectDictRelationChild();
                relationChild.setType(UserGlobalDict.StrategyGlobalDict.salesType());
                relationChild.setValue(keyValueVo);
                relationChild.setObject("sys_channel_strategy");
                relationChild.setAttribute("sales_type");
                relationChild.setObjectId(strategyId);
                relationChild.setSupplierId(supplierId);
                sysObjectDictRelationList.add(relationChild);
            }

            sysObjectDictRelations.add(relation);
        }

        return sysObjectDictRelations;
    }

    private List<SysObjectDictRelation> getSysObjectDictRelationChildList(List<SysChannelStrategy> strategyList) {

        List<SysObjectDictRelation> sysObjectDictRelations = new ArrayList<>();

        for (SysChannelStrategy strategy : strategyList) {
            List<SysObjectDictRelation> sysObjectDictRelationChildList = getSysObjectDictRelationChildList(strategy);
            if (CollectionUtils.isNotEmpty(sysObjectDictRelationChildList))
                sysObjectDictRelations.addAll(sysObjectDictRelationChildList);
        }

        if (sysObjectDictRelations.size() > 0)
            return sysObjectDictRelations;
        return null;
    }

    private int saveSysObjectDictRelationChild(SysChannelStrategy strategy) {
        List<SysObjectDictRelation> sysObjectDictRelationList = getSysObjectDictRelationChildList(strategy);
        if (CollectionUtils.isNotEmpty(sysObjectDictRelationList)) {
            return sysObjectDictRelationService.updateBatch(sysObjectDictRelationList);
        }
        return 0;
    }

    private int saveSysObjectDictRelationChild(List<SysChannelStrategy> strategyList) {
        List<SysObjectDictRelation> sysObjectDictRelationList = getSysObjectDictRelationChildList(strategyList);
        if (CollectionUtils.isNotEmpty(sysObjectDictRelationList)) {
            return sysObjectDictRelationService.updateBatch(sysObjectDictRelationList);
        }
        return 0;
    }

    /**
     * 更新政策产品关系列表
     * 
     * @param bean
     *            政策实体
     * 
     * @param records
     *            产品主键列表
     * 
     * @param isNeedUpdate
     *            是否更新实体信息
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    @Override
    public Long saveStrategyProduct(SysChannelStrategy bean, List<Long> records, boolean isNeedUpdate) throws Exception {
        Long num = 0l;
        try {
            if (bean == null) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyProduct],参数bean不可以为空");
                return num;
            }

            if (bean.getId() == null || bean.getId() < 1) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyProduct],参数bean的实体Id不可以为空");
                return num;
            }
            if (records == null) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyProduct],参数records不可以为空");
                return num;
            }

            setStrategyProductId(bean, records);

            // 更新用户
            if (isNeedUpdate) {
                num += this.insertOrUpdate(bean);
            }

            String objId = String.valueOf(bean.getId());

            // 更新政策产品关系
            List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
            for (Long ref : records) {
                if (ref == null || ref < 1) {
                    continue;
                }
                SysLabelRelationKey key = new SysLabelRelationKey();
                key.setObjId(objId);
                key.setRelId(String.valueOf(ref));
                key.setRelType(ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
                relationList.add(key);

            }

            List<SysChannelStrategy> list = new ArrayList<SysChannelStrategy>();
            list.add(bean);

            Map<String, String> searchMap = new HashMap<String, String>();
            searchMap.put(ChannelMapKeyParam.OBJ_MAP_KEY, this.getIds(list));
            searchMap.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
            num += this.labelRelationService.updateAuthBatch(searchMap, relationList);

        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    /**
     * 更新政策渠道关系列表
     * 
     * @param bean
     *            政策实体
     * 
     * @param records
     *            渠道实体列表
     * 
     * @param isNeedUpdate
     *            是否更新实体信息
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    @Override
    public Long saveStrategyChannel(SysChannelStrategy bean, List<SysChannel> records, boolean isNeedUpdate) throws Exception {
        Long num = 0l;
        try {
            if (bean == null) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyChannel],参数bean不可以为空");
                return num;
            }

            if (bean.getId() == null || bean.getId() < 1) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyChannel],参数bean的实体Id不可以为空");
                return num;
            }
            if (records == null) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyChannel],参数records不可以为空");
                return num;
            }

            // 更新用户
            if (isNeedUpdate) {
                num += this.insertOrUpdate(bean);

            }

            // 新建或更新渠道信息
            num += this.channelService.insertOrUpdateBatch(records);

            String objId = String.valueOf(bean.getId());

            // 更新政策产品关系
            List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
            for (SysChannel ref : records) {
                Long refId = ref.getId();
                if (refId == null || refId < 1) {
                    continue;
                }
                SysLabelRelationKey key = new SysLabelRelationKey();
                key.setObjId(objId);
                key.setRelId(String.valueOf(refId));
                key.setRelType(ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
                relationList.add(key);

            }

            List<SysChannelStrategy> list = new ArrayList<SysChannelStrategy>();
            list.add(bean);

            Map<String, String> searchMap = new HashMap<String, String>();
            searchMap.put(ChannelMapKeyParam.OBJ_MAP_KEY, this.getIds(list));
            searchMap.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
            num += this.labelRelationService.updateAuthBatch(searchMap, relationList);

        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    /**
     * 更新政策产品的减免结算列表
     * 
     * @param bean
     *            政策实体
     * 
     * 
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    public Long saveStrategySettlementRule(SysChannelStrategy bean, boolean isNeedSaveStrategy) {
        Long num = 0l;
        try {
            if (bean == null) {
                this.logger.error("方法[ChannelStrategyService.saveStrategySettlementRule],参数bean不可以为空");
                return num;
            }

            // 新建或更新产品信息
            if (isNeedSaveStrategy) {
                num += this.insertOrUpdate(bean);
            }
            // key:房型 value ：房间集合
            List<SysChannelStrategy> list = new ArrayList<SysChannelStrategy>();
            list.add(bean);
            Map<Long, List<SysSettlementRule>> entityMap = this.voUtil.getSettlementRuleMap(list);
            num += this.sysSettlementRuleService.updateParentRelationBatch(entityMap, false);

        } catch (NumberFormatException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    /**
     * 更新政策产品渠道返利加点返关系列表
     * 
     * @param strategy
     *            政策实体
     * 
     * @param productList
     *            产品主键列表
     * 
     * @param channelList
     *            渠道实体列表
     * 
     * @param rebateList
     *            返利实体列表
     * 
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    public Long saveSPCRERelation(SysChannelStrategy strategy, List<Long> productList, List<SysChannel> channelList,
                                  List<SysRebateStrategy> rebateList) throws Exception {
        Long num = 0l;
        try {
            if (strategy == null) {
                this.logger.error("方法[ChannelStrategyService.saveSPCRERelation],参数strategy不可以为空");
                return num;
            }

            if (strategy.getId() == null || strategy.getId() < 1) {
                this.logger.error("方法[ChannelStrategyService.saveSPCRERelation],参数strategy的实体Id不可以为空");
                return num;
            }
            String strategyId = String.valueOf(strategy.getId());
            if (productList == null || productList.isEmpty()) {
                this.logger.error("方法[ChannelStrategyService.saveSPCRERelation],参数productList不可以为空");
                return num;
            }
            if (channelList == null || channelList.isEmpty()) {
                this.logger.error("方法[ChannelStrategyService.saveSPCRERelation],参数channelList不可以为空");
                return num;
            }

            // 添加 政策 产品 渠道 返利 加点返的关系
            List<SysSpcreRelationKey> relationList = new ArrayList<SysSpcreRelationKey>();

            for (Long productId : productList) {
                if (productId == null || productId < 1) {
                    continue;
                }
                String productId_ = String.valueOf(productId);
                for (SysChannel channel : channelList) {
                    Long channelId = channel.getId();
                    if (channelId == null || channelId < 1) {
                        continue;
                    }
                    String channelId_ = String.valueOf(channelId);

                    SysSpcreRelationKey key = new SysSpcreRelationKey();
                    key.setStrategyId(strategyId);
                    key.setProductId(productId_);
                    key.setChannelId(channelId_);
                    if (ChannelGlobalDict.channelMF().equals(channel.getChannelCategory())) {
                        key.setStatus(String.valueOf(StrategyGlobalDict.publishStatusNotreviewed()));
                    } else {
                        key.setStatus(String.valueOf(StrategyGlobalDict.publishStatusPassed()));
                    }
                    relationList.add(key);

                }
            }
            if (relationList != null && !relationList.isEmpty()) {
                List<Long> list = new ArrayList<Long>();
                list.add(strategy.getId());

                Map<String, Object> searchMap = new HashMap<String, Object>();
                searchMap.put(ChannelMapKeyParam.STRATEGY_MAP_KEY, list);

                // 1.更新加点返对象的状态
                this.extraRebateStrategyService.updateRebateStatusByList(relationList);

                // 2.更新加点返关系列表
                this.spcreRelationService.updateAuthBatchByList(searchMap, relationList);

            }

        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    /**
     * 更新政策返利关系列表
     * 
     * @param bean
     *            政策实体
     * 
     * @param records
     *            返利实体列表
     * 
     * @param isNeedUpdate
     *            是否更新实体信息
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    @Override
    public Long saveStrategyRebate(SysChannelStrategy bean, List<SysRebateStrategy> records, boolean isNeedUpdate) throws Exception {
        Long num = 0l;
        try {
            if (bean == null) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyRebate],参数bean不可以为空");
                return num;
            }

            if (bean.getId() == null || bean.getId() < 1) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyRebate],参数bean的实体Id不可以为空");
                return num;
            }
            if (records == null) {
                this.logger.error("方法[ChannelStrategyService.saveStrategyRebate],参数records不可以为空");
                return num;
            }

            // 更新用户
            if (isNeedUpdate) {
                num += this.updateByPrimaryKey(bean);

            }

            // 新建或更新返利信息
            this.rebateStrategyService.createRebateStrategyBatch(records);

            // 维护政策与返利信息的关系
            num += this.saveStrategyRelation(bean, records);

        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    private Long saveStrategyRelation(SysChannelStrategy bean, List<SysRebateStrategy> records) {
        Long num = 0L;
        String objId = String.valueOf(bean.getId());

        // 维护政策与返利关系
        List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
        for (SysRebateStrategy ref : records) {
            Long refId = ref.getId();
            if (refId == null || refId < 1) {
                continue;
            }
            SysLabelRelationKey key = new SysLabelRelationKey();
            key.setObjId(objId);
            key.setRelId(String.valueOf(refId));
            key.setRelType(ChannelMapKeyParam.STRATEGY_REBATE_RELATION_TYPE);
            relationList.add(key);

        }

        List<SysChannelStrategy> list = new ArrayList<SysChannelStrategy>();
        list.add(bean);

        Map<String, String> searchMap = new HashMap<String, String>();
        searchMap.put(ChannelMapKeyParam.OBJ_MAP_KEY, this.getIds(list));
        searchMap.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.STRATEGY_REBATE_RELATION_TYPE);
        num += this.labelRelationService.updateAuthBatch(searchMap, relationList);
        return num;
    }

    @Override
    public PageList<SysChannelStrategy> queryPageByObjId(PageModel pager, SysChannelStrategy vo, Long objId, String refType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", vo);
        params.put("idParam", objId);
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);
        List<SysChannelStrategy> listBean = this.mapper.findListByObjID(params);
        Integer count = this.mapper.countByObjID(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = null;
        pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<SysChannelStrategy> queryPageByRefId(PageModel pager, SysChannelStrategy vo, Long refId, String refType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", vo);
        params.put("idParam", refId);
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);
        List<SysChannelStrategy> listBean = this.mapper.findListByRefID(params);
        Integer count = this.mapper.countByRefID(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = null;
        pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<SysChannelStrategy> queryPageByAuthParamMap(PageModel pager, SysChannelStrategy vo, List<SysDateQuery> dateList, List<Long> productIds) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", vo);
        if (dateList != null && !dateList.isEmpty()) {
            params.put("dateParam", dateList);
        }
        if (productIds != null && !productIds.isEmpty()) {
            params.put(ChannelMapKeyParam.REF_MAP_KEY, productIds);
        }
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
        List<SysChannelStrategy> listBean = this.mapper.findListByProductID(params);
        Integer count = this.mapper.countByProductID(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = null;
        pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public List<SysChannelStrategy> queryPageByPIDAndCID(Long productId, Long channelId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("strategyChannel", ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
        params.put("strategyProduct", ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
        params.put("productId", productId);
        params.put("channelId", channelId);
        List<SysChannelStrategy> listBean = this.mapper.findListByChannelIDAndProductID(params);

        return listBean;
    }

    private Map<String, Object> gengerateQueryMapParam(PageModel pager, Long scenicId, Long userId, Long productId, Long supplierId, String salesType,
                                                       String ticketVarie, String strategyType) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (pager != null) {
            params.put("pParam", pager);
        }
        if (scenicId != null) {
            params.put("scenicId", scenicId);
        }
        if (userId != null) {
            params.put("userId", userId);
        }
        if (productId != null) {
            params.put("productId", productId);
        }
        if (supplierId != null) {
            params.put("supplierId", supplierId);
        }

        SysChannelStrategy vo = new SysChannelStrategy();
        params.put("bParam", vo);

        if (ticketVarie != null) {
            vo.setTicketVarie(ticketVarie);
        }
        if (salesType != null) {
            vo.setSalesType("%" + salesType + "%");
        }
        if (strategyType != null) {
            vo.setType(strategyType);
        }

        return params;

    }

    @Override
    @Deprecated
    public PageList<SysChannelStrategy> queryDirectStrategyVoByScenic(PageModel pager, Long scenicId, String salesType, String ticketVarie) {
        Map<String, Object> params = this.gengerateQueryMapParam(pager, scenicId, null, null, null, salesType, ticketVarie,
            StrategyGlobalDict.directStrategy());
        List<SysChannelStrategy> listBean = this.mapper.findDirectStrategyVoByScenic(params);
        Integer count = this.mapper.countDirectStrategyVoByScenic(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    @Deprecated
    public List<SysChannelStrategy> queryDirectStrategyVoByProductIds(Long productId, String salesType, String ticketVarie) {
        Map<String, Object> params = this.gengerateQueryMapParam(null, null, null, productId, null, salesType, ticketVarie,
            StrategyGlobalDict.directStrategy());
        List<SysChannelStrategy> listBean = this.mapper.findDirectStrategyVoByProductIds(params);
        return listBean;
    }

    @Override
    @Deprecated
    public PageList<SysChannelStrategy> queryCustomerDirectStrategyVoByScenic(PageModel pager, Long scenicId, Long userId, Long supplierId, String salesType,
                                                                              String ticketVarie) {
        Map<String, Object> params = this.gengerateQueryMapParam(pager, scenicId, userId, null, supplierId, salesType, ticketVarie,
            StrategyGlobalDict.distributionStrategy());

        List<SysChannelStrategy> listBean = this.mapper.findCustomerDirectStrategyVoByScenic(params);
        Integer count = this.mapper.countCustomerDirectStrategyVoByScenic(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;

    }

    @Override
    @Deprecated
    public PageList<SysChannelStrategy> queryCustomerDistributionStrategyVoByScenic(PageModel pager, Long scenicId, Long userId, Long supplierId,
                                                                                    String salesType, String ticketVarie) {
        Map<String, Object> params = this.gengerateQueryMapParam(pager, scenicId, userId, null, supplierId, salesType, ticketVarie,
            StrategyGlobalDict.distributionStrategy());
        List<SysChannelStrategy> listBean = this.mapper.findCustomerDistributionStrategyVoByScenic(params);
        Integer count = this.mapper.countCustomerDistributionStrategyVoByScenic(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    @Deprecated
    public List<SysChannelStrategy> queryCustomerDirectStrategyVoByProductIds(Long userId, Long productId, Long supplierId, String salesType,
                                                                              String ticketVarie) {

        Map<String, Object> params = this.gengerateQueryMapParam(null, null, userId, productId, supplierId, salesType, ticketVarie,
            StrategyGlobalDict.distributionStrategy());
        List<SysChannelStrategy> listBean = this.mapper.findCustomerDirectStrategyVoByProductIds(params);
        return listBean;
    }

    @Override
    public List<SysChannelStrategy> queryCustomerDistributionStrategyVoByProductIds(Long userId, Long productId, Long supplierId, String salesType,
                                                                                    String ticketVarie) {

        Map<String, Object> params = this.gengerateQueryMapParam(null, null, userId, productId, supplierId, salesType, ticketVarie, null);

        return this.mapper.findCustomerDistributionStrategyVoByProductIds(params);
    }

    @Override
    public PageList<SysChannelStrategy> queryByAllParam(PageModel pager, SysChannelStrategy vo) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", vo);

        List<SysChannelStrategy> listBean = this.mapper.findListByAllParam(params);
        Integer count = this.mapper.countListByAllParam(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = null;
        pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<SysChannelStrategy> queryComposeDirectStrategyVoByScenic(PageModel pager, Long scenicId, String ticketVarie) {
        Map<String, Object> params = this.gengerateQueryMapParam(pager, scenicId, null, null, null, null, ticketVarie, StrategyGlobalDict.directStrategy());

        List<SysChannelStrategy> listBean = this.mapper.findComposeDirectStrategyVoByScenic(params);
        Integer count = this.mapper.countComposeDirectStrategyVoByScenic(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<SysChannelStrategy> queryComposeDistributionStrategyVoByScenic(PageModel pager, Long scenicId, Long userId, String ticketVarie) {
        Map<String, Object> params = this.gengerateQueryMapParam(pager, scenicId, userId, null, null, null, ticketVarie, null);

        List<SysChannelStrategy> listBean = this.mapper.findComposeDistributionStrategyVoByScenic(params);
        Integer count = this.mapper.countComposeDistributionStrategyVoByScenic(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannelStrategy> pagelist = new PageList<SysChannelStrategy>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public List<PCStrategyResult> queryValidStrategyByProductIds(List<PCSstrategyParam> params) {
        if (params == null) {
            this.logger.error("方法[queryValidStrategyByProductIds],查询参数不全");
            return null;
        }
        try {
            Map<Long, PCStrategyResult> filterProductMap = new HashMap<Long, PCStrategyResult>();
            Map<Long, PCStrategyResult> filterChannelMap = new HashMap<Long, PCStrategyResult>();
            List<PCStrategyResult> resultList = new ArrayList<PCStrategyResult>();
            List<Long> channelIdList = new ArrayList<Long>();
            List<Long> productIdList = new ArrayList<Long>();
            for (PCSstrategyParam param : params) {
                Long productId = param.getProductId();
                Long channelId = param.getChannelId();
                if (productId == null || channelId == null) {
                    this.logger.error("方法[queryValidStrategyByProductIds],参数productId：{},参数channelId：{} 不能为空", productId, channelId);
                }
                channelIdList.add(channelId);
                productIdList.add(productId);

                // 组装返回结果
                PCStrategyResult result = new PCStrategyResult();
                result.setProductId(productId);

                // 组装政策
                Strategy queryParam = param.getStrategyParam();
                result.setStrategyList(this.queryValidStrategyByPCId(productId, channelId, queryParam));

                filterProductMap.put(productId, result);
                filterChannelMap.put(channelId, result);
                resultList.add(result);

            }

            // 组装渠道
            this.setChannelTPCStrategyResult(channelIdList, filterChannelMap);

            // 组装结算规则
            this.setSettlementTPCStrategyResult(productIdList, filterProductMap);
            return resultList;
        } catch (Exception ex) {
            this.logger.error("方法[queryValidStrategyByProductIds]出错");
            ex.printStackTrace();
        }

        return null;
    }

    public List<Strategy> queryValidStrategyByPCId(Long productId, Long channelId, Strategy queryParam) {
        SysChannelStrategy beanParam = new SysChannelStrategy();
        try {
            if (null != queryParam)
                PropertyUtils.copyProperties(beanParam, queryParam);
            // 政策有效参数
            beanParam.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
            // 渠道参数
            List<Long> channelIds = new ArrayList<Long>();
            channelIds.add(channelId);
            beanParam.setChannelIds(channelIds);
            // 产品参数
            List<Long> productIds = new ArrayList<Long>();
            productIds.add(productId);
            beanParam.setProductIds(productIds);
            // 结果转换
            List<Strategy> returnlist = null;
            PageList<SysChannelStrategy> pagelist = this.queryByAllParam(null, beanParam);
            if (pagelist != null && !pagelist.isEmpty()) {
                List<SysChannelStrategy> strList = pagelist.getResultList();
                // 设置返利信息
                this.setStrategyRebateList(strList);
                returnlist = new ArrayList<Strategy>();
                for (SysChannelStrategy bean : strList) {
                    Strategy sbean = AuthorityUtil.changeTStrategy(bean);
                    returnlist.add(sbean);
                }
            }
            return returnlist;
        } catch (Exception e) {
            this.logger.error("方法[queryValidStrategyByPCId], 参数Strategy转换出错");
        }
        return null;
    }

    private void setChannelTPCStrategyResult(List<Long> channelIds, Map<Long, PCStrategyResult> filterChannelMap) throws Exception {
        SysChannel channelParam = new SysChannel();
        channelParam.setQueryIds(channelIds);
        channelParam.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));

        List<SysChannel> channels = this.channelService.findListByParams(channelParam);
        if (channels != null && !channelIds.isEmpty()) {
            for (SysChannel channel : channels) {
                Long channelId = channel.getId();
                if (filterChannelMap.containsKey(channelId)) {
                    PCStrategyResult result = filterChannelMap.get(channelId);
                    Channel vo = new Channel();
                    PropertyUtils.copyProperties(vo, channel);
                    result.setChannel(vo);
                }
            }
        }

    }

    private void setSettlementTPCStrategyResult(List<Long> productIds, Map<Long, PCStrategyResult> filterProductMap) throws Exception {
        SysSettlementRule ruleParam = new SysSettlementRule();
        ruleParam.setQueryProductIdList(productIds);

        List<SysSettlementRule> rules = this.sysSettlementRuleService.findListByParams(ruleParam);
        if (rules != null && !rules.isEmpty()) {
            for (SysSettlementRule rule : rules) {
                Long productId = rule.getId();
                if (filterProductMap.containsKey(productId)) {
                    PCStrategyResult result = filterProductMap.get(productId);
                    List<SettlementRule> ruleList = result.getRuleList();
                    if (ruleList == null) {
                        ruleList = new ArrayList<SettlementRule>();
                        result.setRuleList(ruleList);
                    }
                    SettlementRule rule_ = new SettlementRule();
                    PropertyUtils.copyProperties(rule_, rule);
                    ruleList.add(rule_);
                }
            }
        }

    }

    public void setStrategyRebateList(List<SysChannelStrategy> strList) {
        if (strList == null || strList.isEmpty()) {
            return;
        }
        List<Long> strIds = UserEntityUtil.getEntityIdList(strList);
        if (strIds == null || strIds.isEmpty()) {
            return;
        }
        List<SysLabelRelationKey> relationList = this.authorityUtil.getRelationList(strIds, null,
            UserGlobalParam.ChannelMapKeyParam.STRATEGY_REBATE_RELATION_TYPE);
        if (relationList == null) {
            return;
        }
        List<Long> relIdList = AuthorityUtil.getRelIdList(relationList);
        SysRebateStrategy queryRebate = new SysRebateStrategy();
        queryRebate.setIds(relIdList);
        List<SysRebateStrategy> rebateList = this.rebateStrategyService.findListByParams(queryRebate);
        Map<String, SysChannelStrategy> sMap = this.listTMap(strList, null);
        Map<String, SysRebateStrategy> rebateMap = this.rebateStrategyService.listTMap(rebateList, null);

        for (SysLabelRelationKey key : relationList) {
            String objId_ = String.valueOf(key.getObjId());
            String relId_ = String.valueOf(key.getRelId());
            SysChannelStrategy obj = sMap.get(objId_);
            if (obj == null) {
                continue;
            }
            SysRebateStrategy rel = rebateMap.get(relId_);
            if (rel != null) {
                List<SysRebateStrategy> srebate = obj.getRebateStrategyList();
                if (srebate == null) {
                    srebate = new ArrayList<SysRebateStrategy>();
                    obj.setRebateStrategyList(srebate);
                }
                srebate.add(rel);
            }

        }

    }

    public Map<Long, Integer> isCanSaled(List<CanSaledStrategyParam> params) {
        /*
         * if (params == null) { return null; } Map<Long, Integer> returnMap =
         * new HashMap<Long, Integer>(); for (CanSaledStrategyParam param :
         * params) { Long productId = param.getProductId(); Long channelId =
         * param.getChannelId(); List<Long> productIds = null; List<Long>
         * channelIds = null; if (productId != null) { productIds = new
         * ArrayList<Long>(); productIds.add(productId); } if (channelId !=
         * null) { channelIds = new ArrayList<Long>();
         * channelIds.add(channelId); } SysChannelStrategy strategyQuery = new
         * SysChannelStrategy(); // String.valueOf(GlobalParam.FLAG.agree())
         * strategyQuery.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
         * strategyQuery.setChannelIds(channelIds);
         * strategyQuery.setProductIds(productIds);
         * 
         * QueryPageList<SysChannelStrategy> resultList = this.queryByAllParam(null,
         * strategyQuery); boolean result =
         * haveValidStrategy(resultList.getResultList(),
         * UserGlobalDict.StrategyGlobalDict.strategyStatusEnbaled(), null,
         * param.getSaleType()); Integer result =
         * SkuProductGlobal.isCanSaled_yes; switch (1) { case 1: if (resultList
         * == null) { result = SkuProductGlobal.isCanSaled_no; break; }
         * 
         * case 2: if (!this.isCanSaled(param.getSaleType(),
         * resultList.getResultList())) { result =
         * SkuProductGlobal.isCanSaled_no; break; } }
         * 
         * returnMap.put(productId, result);
         * 
         * } return returnMap;
         */
        return null;
    }

    public Map<Long, List<Strategy>> getStrategyByDidAndPid(Long distributorId, String saleType, Date date, List<Long> productIds) {

        /*
         * if (distributorId == null) {
         * this.logger.error("查询方法【getStrategyByDidAndPid】,查询distributorId不能为空"
         * ); return null; } if (productIds == null || productIds.isEmpty()) {
         * this.logger.error("查询方法【getStrategyByDidAndPid】,查询productIds不能为空");
         * return null; } // 获取渠道 List<Long> userIds = new ArrayList<Long>();
         * userIds.add(distributorId); SysChannel channelQuery = new
         * SysChannel(); channelQuery.setQueryUserIds(userIds);
         * channelQuery.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
         * List<SysChannel> channelList =
         * this.channelService.findListByParams(channelQuery); List<Long>
         * channelIds = UserEntityUtil.getEntityIdList(channelList);
         * SysChannelStrategy strategyQuery = new SysChannelStrategy();
         * strategyQuery.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
         * strategyQuery.setChannelIds(channelIds);
         * strategyQuery.setProductIds(productIds); QueryPageList<SysChannelStrategy>
         * pageList = this.queryByAllParam(null, strategyQuery);
         * 
         * return this.setProductStrategy(productIds,
         * resultList.getResultList());
         */

        return null;
    }

    private void fiterValidStrategyList(List<SysChannelStrategy> list, String saleType, Date date) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (date == null) {
            date = new Date();
        }
        for (SysChannelStrategy bean : list) {

        }
    }

    public List<Strategy> queryStrategyAndRebateByIds(List<Long> ids) {

        List<SysChannelStrategy> channelStrategyList = this.findByIdList(ids);

        List<Strategy> strategyList = this.convertToStrategy(channelStrategyList);

        List<SysLabelRelationKey> keyList = this.findStrategyRebateRelation(ids);

        List<Long> rebateIds = this.getRebateIds(keyList);

        List<SysRebateStrategy> rebateStrategyList = this.findRebateByIds(rebateIds);

        List<RebateStrategy> rebateStrategies = this.convertToRebate(rebateStrategyList);

        this.composStrategyAndRebate(strategyList, keyList, rebateStrategies);

        return strategyList;
    }

    /**
     * 通过政策ID集合查询政策
     * 
     * @param ids
     * @return
     */
    private List<SysChannelStrategy> findByIdList(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids))
            return null;

        Map<String, Object> params = new HashMap<>(1);
        params.put(ChannelMapKeyParam.STRATEGY_MAP_KEY, ids);
        List<SysChannelStrategy> byIdList = this.mapper.findByIdList(params);
        return byIdList;
    }

    private List<Strategy> convertToStrategy(List<SysChannelStrategy> channelStrategyList) {
        if (CollectionUtils.isEmpty(channelStrategyList))
            return null;
        List<Strategy> strategyList = new ArrayList<>(channelStrategyList.size());
        for (SysChannelStrategy channelStrategy : channelStrategyList) {
            Strategy strategy = new Strategy();
            try {
                PropertyUtils.copyProperties(strategy, channelStrategy);
                strategyList.add(strategy);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return strategyList;
    }

    private List<SysLabelRelationKey> findStrategyRebateRelation(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids))
            return null;

        Map<String, Object> params = new HashMap<>(2);
        params.put(ChannelMapKeyParam.OBJ_MAP_KEY, ids);
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.STRATEGY_REBATE_RELATION_TYPE);

        List<SysLabelRelationKey> relationKeyList = this.labelRelationService.findByIdList(params);
        return relationKeyList;
    }

    private List<Long> getRebateIds(List<SysLabelRelationKey> keyList) {
        if (CollectionUtils.isEmpty(keyList))
            return null;
        Set<Long> ss = new HashSet<>();

        for (SysLabelRelationKey key : keyList) {
            String relId = key.getRelId();
            if (StringUtils.isNoneBlank(relId))
                ss.add(Long.valueOf(relId));
        }

        return new ArrayList<>(ss);
    }

    private List<SysRebateStrategy> findRebateByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids))
            return null;

        Map<String, Object> params = new HashMap<>(1);
        params.put(ChannelMapKeyParam.REBATE_MAP_KEY, ids);

        List<SysRebateStrategy> byIdList = this.rebateStrategyService.findByIdList(params);
        return byIdList;
    }

    private List<RebateStrategy> convertToRebate(List<SysRebateStrategy> rebateStrategyList) {
        if (CollectionUtils.isEmpty(rebateStrategyList))
            return null;
        List<RebateStrategy> rebateStrategyList1 = new ArrayList<>(rebateStrategyList.size());
        for (SysRebateStrategy rebateStrategy : rebateStrategyList) {
            RebateStrategy rebateStrategy1 = new RebateStrategy();
            try {
                PropertyUtils.copyProperties(rebateStrategy1, rebateStrategy);
                rebateStrategyList1.add(rebateStrategy1);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return rebateStrategyList1;
    }

    private void composStrategyAndRebate(List<Strategy> strategyList, List<SysLabelRelationKey> keyList, List<RebateStrategy> rebateStrategyList) {
        if (CollectionUtils.isEmpty(strategyList) || CollectionUtils.isEmpty(keyList) || CollectionUtils.isEmpty(rebateStrategyList))
            return;

        Map<Long, Strategy> strategyMap = new HashMap<>(strategyList.size());
        for (Strategy strategy : strategyList)
            strategyMap.put(strategy.getId(), strategy);

        Map<Long, RebateStrategy> rebateStrategyHashMap = new HashMap<>(rebateStrategyList.size());
        for (RebateStrategy rebateStrategy : rebateStrategyList)
            rebateStrategyHashMap.put(rebateStrategy.getId(), rebateStrategy);

        for (SysLabelRelationKey key : keyList) {
            String objId = key.getObjId();
            Long objIdLong = Long.valueOf(objId);
            String relId = key.getRelId();
            Long relIdLong = Long.valueOf(relId);
            Strategy strategy = strategyMap.get(objIdLong);
            RebateStrategy rebateStrategy = rebateStrategyHashMap.get(relIdLong);

            List<RebateStrategy> rebateStrategyList1 = strategy.getRebateStrategyList();
            if (CollectionUtils.isEmpty(rebateStrategyList1)) {
                rebateStrategyList1 = new ArrayList<>();
                strategy.setRebateStrategyList(rebateStrategyList1);
            }
            rebateStrategyList1.add(rebateStrategy);
        }

    }

    public Map<Long, List<Strategy>> setProductStrategy(List<Long> productIds, List<SysChannelStrategy> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<Long, List<Strategy>> returnMap = new HashMap<Long, List<Strategy>>();
        try {
            Map<String, SysChannelStrategy> resultMap = this.listTMap(list, null);
            List<SysLabelRelationKey> relationList = this.authorityUtil.getRelationList(null, productIds,
                UserGlobalParam.ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
            Map<String, List<String>> relationMap = this.authorityUtil.getRelMap(relationList);

            for (Long productId : productIds) {
                String productId_ = String.valueOf(productId);
                List<String> strIdList = relationMap.get(productId_);
                List<Strategy> strList = null;
                if (strIdList != null) {
                    strList = new ArrayList<Strategy>();
                    for (String sid : strIdList) {
                        SysChannelStrategy cstr = resultMap.get(sid);
                        if (cstr != null) {
                            Strategy vo = new Strategy();

                            PropertyUtils.copyProperties(vo, cstr);

                            strList.add(vo);
                        }
                    }
                }
                returnMap.put(productId, strList);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return returnMap;
    }

    public Map<Long, List<Strategy>> getStrategyByDidAndPid(Long distributorId, List<Long> productIds) {
        if (distributorId == null) {
            this.logger.error("查询方法【getStrategyByDidAndPid】,查询distributorId不能为空");
            return null;
        }
        if (productIds == null || productIds.isEmpty()) {
            this.logger.error("查询方法【getStrategyByDidAndPid】,查询productIds不能为空");
            return null;
        }
        // 获取渠道
        List<Long> userIds = new ArrayList<Long>();
        userIds.add(distributorId);
        SysChannel channelQuery = new SysChannel();
        channelQuery.setQueryUserIds(userIds);
        channelQuery.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
        List<SysChannel> channelList = this.channelService.findListByParams(channelQuery);
        List<Long> channelIds = UserEntityUtil.getEntityIdList(channelList);
        SysChannelStrategy strategyQuery = new SysChannelStrategy();
        strategyQuery.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
        strategyQuery.setChannelIds(channelIds);
        strategyQuery.setProductIds(productIds);
        PageList<SysChannelStrategy> resultList = this.queryByAllParam(null, strategyQuery);
        return this.setProductStrategy(productIds, resultList.getResultList());
    }

    @Override
    public Result<ArrayList<StrategyJudgeResult>> judgeHaveValidStrategyByCPid(List<StrategyJudgeParam> judgeParams) {
        if (CollectionUtils.isEmpty(judgeParams)) {
            this.logger.error("查询方法【judgeHaveValidStrategyByCPid】,查询参数不能为空");
            return new Result(20000, "查询参数{judgeParam}不能为空");
        }

        if (!checkParamData(judgeParams)) {
            this.logger.error("查询方法【judgeHaveValidStrategyByCPid】,查询参数不能为空");
            return new Result(20000, "查询参数{judgeParam}不能为空");
        }

        logger.info("查询方法【judgeHaveValidStrategyByCPid】的入参为{}", JSON.toJSONString(judgeParams));

        //1.构造产品树	
        Map<String, ProductTree> productTrees = getProductTrees(StrategyConvertUtil.getProductIds(judgeParams));

        //2.构造渠道树
        Map<StrategyJudgeParam, List<ChannelTree>> channelTrees = getChannelTreeFJudge(judgeParams);

        //3.获取结果
        ArrayList<StrategyJudgeResult> data = getJudgeResult(judgeParams, productTrees, channelTrees);

        return new Result(data);
    }

    private boolean checkParamData(List<StrategyJudgeParam> judgeParams) {
        for (StrategyJudgeParam judgeParam : judgeParams) {
            if (!judgeParam.isValidData()) {
                this.logger.error("查询方法【judgeHaveValidStrategyByCPid】,查询参数有错:{}", JSON.toJSONString(judgeParams));
                return false;

            }
        }
        return true;
    }

    private ArrayList<StrategyJudgeResult> getJudgeResult(List<StrategyJudgeParam> judgeParams, Map<String, ProductTree> productTrees,
                                                          Map<StrategyJudgeParam, List<ChannelTree>> channelTrees) {
        if (productTrees == null || channelTrees == null)
            return null;
        ArrayList<StrategyJudgeResult> results = new ArrayList<StrategyJudgeResult>();
        for (StrategyJudgeParam judge : judgeParams) {
            StrategyJudgeResult result = getJudgeHaveReason(judge, productTrees.get(judge.getProductId().toString()), channelTrees.get(judge));
            if (result != null)
                results.add(result);
        }
        return results;
    }

    private StrategyJudgeResult getJudgeHaveReason(StrategyJudgeParam param, ProductTree tree, List<ChannelTree> channelTrees) {
        if (tree == null)
            return null;

        List<JudgeHaveReason> reasons = new ArrayList<JudgeHaveReason>();
        List<CPSCRelation> relations = tree.getRealtions();
        Boolean judgeResult = true;
        StrategyJudgeResult result = new StrategyJudgeResult(param, reasons);
        result.setJudgeResult(judgeResult);
        if (tree == null || CollectionUtils.isEmpty(channelTrees)) {
            return result;
        }
        Map<String, ChannelTree> trees = CommonConvert.convertToMap(channelTrees);

        for (ChannelTree channelTree : channelTrees) {
            List<Long> c_userIds = channelTree.getUserId();
            for (CPSCRelation relation : relations) {
                if (relation.getChannelId() != null && !trees.containsKey(String.valueOf(relation.getChannelId()))) {
                    Long userId = relation.getUserId();
                    if (c_userIds.contains(userId)) {
                        JudgeHaveReason reason = new JudgeHaveReason(relation.getStrategy(), relation.getStrategyId(), channelTree.getChannel(),
                            channelTree.getChannelId(), relation.getChannel(), relation.getChannelId(), userId);
                        reasons.add(reason);
                        judgeResult = false;
                    }
                }
            }
        }
        result.setJudgeResult(judgeResult);
        return result;

    }

    private Map<StrategyJudgeParam, List<ChannelTree>> getChannelTreeFJudge(List<StrategyJudgeParam> judgeParams) {

        Map<StrategyJudgeParam, List<ChannelTree>> result = new HashMap<StrategyJudgeParam, List<ChannelTree>>();

        Map<String, ChannelTree> channelMap = getChannelTreeMap(StrategyConvertUtil.getChannelIds(judgeParams));
        if (channelMap == null || channelMap.isEmpty()) {
            return result;
        }

        for (StrategyJudgeParam judgeParam : judgeParams) {
            List<Long> channelIds = judgeParam.getChannelIds();
            List<ChannelTree> treeList = new ArrayList<ChannelTree>();
            for (Long channelId : channelIds) {
                ChannelTree channelTree = channelMap.get(channelId.toString());
                if (channelTree != null)
                    treeList.add(channelTree);
            }
            result.put(judgeParam, treeList);
        }
        return result;
    }

    public Map<String, ProductTree> getProductTrees(List<Long> productIds) {

        Map<String, List<CPSCRelation>> relations = getCPSCRelationTree(productIds);

        return structProductTree(productIds, relations);

    }

    public Map<String, List<CPSCRelation>> getCPSCRelationTree(List<Long> productIds) {
        List<SysSpcreRelationKey> relations = spcreRelationService.findSpcreRelationsByProductIds(productIds);

        SysSpcreRelationIDKey keys = StrategyConvertUtil.getRelationIdList(relations);

        Map<String, ChannelTree> channels = getChannelTreeMap(keys.getChannelIds());

        List<Strategy> strategys = findValidStrategyByIds(keys.getStrategyIds());

        Map<String, Strategy> strategyMap = CommonConvert.convertToMap(strategys);

        return structCPSCRelation(strategyMap, channels, relations);
    }

    public Map<String, ChannelTree> getChannelTreeMap(List<Long> channelIds) {

        List<SysChannel> channels = channelService.findValidChannelsByIds(channelIds);

        List<SysLabelRelationKey> relations = labelRelationService.findCURelationByChanneIds(channelIds);

        return structChannelTree(channels, relations);

    }

    public Map<String, ProductTree> structProductTree(List<Long> productIds, Map<String, List<CPSCRelation>> relations) {
        if (CollectionUtils.isEmpty(productIds) || relations == null || relations.isEmpty()) {
            return null;
        }

        Map<String, ProductTree> result = new HashMap<String, ProductTree>();
        for (Long productId : productIds) {
            if (productId == null) {
                continue;
            }
            List<CPSCRelation> list = relations.get(productId.toString());
            if (CollectionUtils.isEmpty(list)) {
                continue;
            }

            ProductTree ptree = new ProductTree();
            ptree.setProductId(productId);
            ptree.setRealtions(list);
            result.put(productId.toString(), ptree);
        }

        return result;
    }

    public Map<String, List<CPSCRelation>> structCPSCRelation(Map<String, Strategy> strategys, Map<String, ChannelTree> channelMap,
                                                              List<SysSpcreRelationKey> relations) {
        if (channelMap == null || channelMap.isEmpty() || CollectionUtils.isEmpty(relations) || strategys == null) {
            return null;
        }

        Map<String, List<CPSCRelation>> result = new HashMap<String, List<CPSCRelation>>();
        for (SysSpcreRelationKey relation : relations) {
            ChannelTree channelTree = channelMap.get(relation.getChannelId());
            Strategy strategy = strategys.get(relation.getStrategyId());
            if (relation.isValidData() && (channelTree != null) && (strategy != null)) {
                List<CPSCRelation> prelation = result.get(relation.getProductId());
                if (prelation == null) {
                    prelation = new ArrayList<CPSCRelation>();
                    result.put(relation.getProductId(), prelation);
                }
                List<Long> userIds = channelTree.getUserId();
                for (Long userId : userIds) {
                    CPSCRelation cpsc = new CPSCRelation();
                    cpsc.setChannelId(relation.getLongFChannelId());
                    cpsc.setProductId(relation.getLongFProductId());
                    cpsc.setStrategyId(relation.getLongFStrategyId());
                    cpsc.setStrategy(strategy);
                    cpsc.setUserId(userId);
                    prelation.add(cpsc);
                }
            }
        }
        return result;
    }

    public Map<String, ChannelTree> structChannelTree(List<SysChannel> channels, List<SysLabelRelationKey> relations) {
        if (CollectionUtils.isEmpty(channels) || CollectionUtils.isEmpty(relations)) {
            return null;
        }
        Map<String, List<Long>> objMap = StrategyConvertUtil.getObjMap(relations);
        Map<String, ChannelTree> result = new HashMap<String, ChannelTree>();
        for (SysChannel channel : channels) {
            List<Long> userIds = objMap.get(channel.getId().toString());
            if (channel.hasValidID() && !CollectionUtils.isEmpty(userIds)) {
                ChannelTree tree = new ChannelTree();
                tree.setChannelId(channel.getId());
                tree.setChannel(StrategyConvertUtil.convertTChannel(channel));
                tree.setUserId(userIds);
                result.put(channel.getId().toString(), tree);
            }

        }

        return result;

    }

    public List<Strategy> findValidStrategyByIds(List<Long> strategyIds) {
        List<Strategy> result = new ArrayList<Strategy>();
        if (CollectionUtils.isEmpty(strategyIds)) {
            return result;
        }

        SysChannelStrategy queryParam = new SysChannelStrategy();
        queryParam.setIds(strategyIds);
        queryParam.setDelFlag(GlobalParam.FLAG.start().toString());
        queryParam.setStatus(UserGlobalDict.StrategyGlobalDict.strategyStatusEnbaled());
        queryParam.setPublishStatus(UserGlobalDict.StrategyGlobalDict.publishStatusPassed());
        List<SysChannelStrategy> list = findListByParams(queryParam);
        if (CollectionUtils.isNotEmpty(list)) {
            StrategyConvertUtil.convertTStrategyList(result, list);
        }

        return result;

    }

    /**
     * 根据DictVlaue更新政策信息及对应的微店政策和微店政策对应的返利
     * @param bean政策实体
     * @return 政策主键Id
     */
    public int updateStrategyByDictVlaue(SysChannelStrategy bean) {
        int num = 0;
        try {
            if (bean == null) {
                logger.error("接口方法[ChannelStrategyServiceImpl.updateStrategyByDictVlaue],参数bean不能为空");
                return num;
            }
            // 根据主键查dictValue值
            String dictValue = tSysChannelStrategyMapper.selectByStrategyIdForUpdate(bean.getId());
            // 根据主键更新记录
            if (null != dictValue && !"".equals(dictValue)) {
                String name = bean.getName();
                // 根据dictValue更新记录
                if (null != bean.getName() && !"".equals(bean.getName())) {
                    bean.setName(bean.getName() + "（微店）");
                }
                num = tSysChannelStrategyMapper.updateBatchByDictValue(bean, dictValue);
                bean.setName(name);
                // 为微店政策生成新的返利政策
                List<SysRebateStrategy> rebateList = constructRSMicroshopData(bean);
                // 根据dictValue和新生成的微店返利政策更新原返利政策
                if (null != rebateList && rebateList.size() > 0) {
                    num = rebateStrategyService.updateRebateByDictValue(rebateList.get(0), dictValue);
                } else {
                    logger.error("接口方法[ChannelStrategyService.updateStrategyByDictVlaue],参数bean新生成的微店返利为空");
                    return 0;
                }
            }
            num = tSysChannelStrategyMapper.updateByPrimaryKey(bean);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return num;
    }

    /**
     * 添加政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 
     * @param strategy
     *            政策实体
     * 
     * @param productIds
     *            产品主键列表
     * 
     * @param csList
     *            渠道实体列表
     * 
     * @param rslist
     *            返利实体列表
     * 
     * @return 更新条数
     * @throws Exception
     */
    public Long updateStrategyAndAuthForPlatform(SysChannelStrategy strategy, List<Long> productIds, List<SysChannel> csList,
                                                 List<SysRebateStrategy> rslist) throws Exception {
        Long num = 0l;
        try {
            if (strategy == null) {
                this.logger.error("方法[ChannelStrategyService.updateStrategyAndAuthForPlatform],参数strategy不可以为空");
                return num;
            }
            Long id = strategy.getId();
            if (id == null || id < 1) {
                this.logger.error("方法[ChannelStrategyService.updateStrategyAndAuthForPlatform],参数strategy的id不可以为空");
                return num;
            }
            // setStrategyProductId(strategy, productIds);

            // 根据UUID 更新微店政策
            num += this.updateStrategyByDictVlaue(strategy);
            /*setRebateStrategyId(strategy, rslist);
            this.saveStrategyAllRelation(strategy, productIds, csList, rslist);*/
        } catch (NumberFormatException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    public Integer updateBatchAndAuthForPlatform(List<SysChannelStrategy> strategyList) throws Exception {
        Integer num = 0;
        try {
            if (strategyList == null) {
                this.logger.error("方法[ChannelStrategyService.updateBatchAndAuth],参数strategyList不可以为空");
                return num;
            }
            for (SysChannelStrategy strategy : strategyList) {

                Long id = strategy.getId();
                if (id == null || id < 1) {
                    this.logger.error("方法[ChannelStrategyService.updateStrategyAndAuth],参数strategy的id不可以为空");
                    return num;
                }
                // setStrategyProductId(strategy);

                // 根据UUID 更新微店政策
                num += this.updateStrategyByDictVlaue(strategy);
                /* List<Long> productIds = strategy.getProductIds();
                List<SysChannel> csList = strategy.getChannelList();
                List<SysRebateStrategy> rslist = strategy.getRebateStrategyList();
                setRebateStrategyId(strategy, rslist);
                this.saveStrategyAllRelation(strategy, productIds, csList, rslist);*/
            }
        } catch (NumberFormatException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

}
