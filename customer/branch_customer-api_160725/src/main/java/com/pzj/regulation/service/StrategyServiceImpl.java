package com.pzj.regulation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.authority.service.AuthorityUtil;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict.StrategyGlobalDict;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.entity.query.SysDateQuery;
import com.pzj.base.service.sys.IChannelStrategyService;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.impl.ChannelVoUtil;
import com.pzj.common.DateQueryVo;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.service.CustomerUtil;
import com.pzj.regulation.convertUtil.SettlementRuleConvertUtil;
import com.pzj.regulation.entity.RebatePlus;
import com.pzj.regulation.entity.RebateStrategyVo;
import com.pzj.regulation.entity.StrategySettlementRule;
import com.pzj.regulation.entity.StrategyVo;
import com.pzj.util.KeyValueVo;

/**
 * 渠道政策接口实现
 * 
 * @author apple
 * 
 */
@Service
public class StrategyServiceImpl implements StrategyService {

    // 创建日志对象
    Logger                                  logger         = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IChannelStrategyService         ichannelStrategyService;

    @Autowired
    private StrategyVoUtil                  strategyVoUtil = null;

    @Autowired
    private AuthorityUtil                   authorityUtil  = null;

    @Autowired
    private CustomerUtil                    customerUtil   = null;

    @Autowired
    private ChannelVoUtil                   channelVoUtil  = null;

    private final SettlementRuleConvertUtil settlementUtil = SettlementRuleConvertUtil.getInstance();

    /**
     * 创建渠道政策
     */
    @Deprecated
    public Long create(StrategyVo vo) throws Exception {
        Long id = 0l;
        try {
            if (vo == null) {
                logger.error("接口方法[StrategyService.create],参数vo不能为空");
            }
            SysChannelStrategy cs = StrategyVo.createNew(vo);

            // 渠道关联
            List<SysChannel> csList = null;
            // 分销渠道返利规则
            List<SysRebateStrategy> rslist = null;
            if (vo != null) {
                List<ChannelVo> cvLict = vo.getChannelList();
                if (cvLict != null && !cvLict.isEmpty()) {
                    csList = ChannelVo.cList2SList(cvLict);
                }
                List<RebateStrategyVo> svList = vo.getRebateStrategyList();
                if (svList != null && !svList.isEmpty()) {
                    rslist = RebateStrategyVo.cList2SList(svList);
                }
            }

            id = ichannelStrategyService.addStrategyAndAuth(cs, vo.getProductList(), csList, rslist);// 创建增加渠道政策服务接口，重写
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return id;
    }

    /**
     * 编辑渠道政策
     */
    @Deprecated
    public Integer update(StrategyVo vo) throws Exception {

        Integer num = 0;
        try {
            if (vo == null) {
                logger.error("接口方法[StrategyService.create],参数vo不能为空");
            }
            SysChannelStrategy cs = StrategyVo.changeTSysBean(vo);

            // 渠道关联
            List<SysChannel> csList = null;
            // 分销渠道返利规则
            List<SysRebateStrategy> rslist = null;
            if (vo != null) {
                List<ChannelVo> cvLict = vo.getChannelList();
                if (cvLict != null && !cvLict.isEmpty()) {
                    csList = ChannelVo.cList2SList(cvLict);
                }
                List<RebateStrategyVo> svList = vo.getRebateStrategyList();
                if (svList != null && !svList.isEmpty()) {
                    rslist = RebateStrategyVo.cList2SList(svList);
                }
            }

            Long updateNum = ichannelStrategyService.updateStrategyAndAuth(cs, vo.getProductList(), csList, rslist);
            num = Integer.valueOf(String.valueOf(updateNum));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * 批量修改政策实体
     * 
     * @param records
     *            政策实体列表
     * 
     * @throws Exception
     */
    public Integer updateBatch(List<StrategyVo> records) throws Exception {
        Integer num = 0;
        try {
            if (records == null || records.isEmpty()) {
                logger.error("接口方法[StrategyService.updateBatchStrategy],参数records不能为空");
                return num;
            }
            List<SysChannelStrategy> list = StrategyVo.cList2SList(records);

            num = ichannelStrategyService.updateBatchByPrimaryKey(list);

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }

        return num;
    }

    /**
     * 通过id查询单个政策对象
     */
    public StrategyVo getById(Long id) throws Exception {
        StrategyVo bean = null;
        try {
            if (id == null || id < 1) {
                logger.error("接口方法[StrategyService.getById],参数id不能为空");
                return null;
            }

            SysChannelStrategy sysBean = ichannelStrategyService.getById(id);
            if (sysBean != null) {
                bean = StrategyVo.changeTAPIBean(sysBean);
            }
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return bean;
    }

    public List<StrategyVo> getByIdList(List<Long> ids) throws Exception {
        List<StrategyVo> beans = null;
        try {
            if (ids == null || ids.isEmpty()) {
                logger.error("接口方法[StrategyService.getByIdList],参数ids不能为空");
                return null;
            }
            beans = strategyVoUtil.getStrategyListByIdList(ids);

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return beans;

    }

    public List<StrategyVo> getAuthByIdList(List<Long> ids) throws Exception {
        List<StrategyVo> beans = null;
        try {
            if (ids == null || ids.isEmpty()) {
                logger.error("接口方法[StrategyService.getByIdList],参数ids不能为空");
                return null;
            }
            beans = strategyVoUtil.getStrategyListByIdList(ids);

            // 设置政策的关联关系
            strategyVoUtil.setStrategyrAuthorityList(beans);

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return beans;

    }

    /**
     * 分页显示
     */
    @Deprecated
    public PageList<StrategyVo> queryPageByParamMap(PageModel pager, StrategyVo vo) throws Exception {

        PageList<StrategyVo> list = new PageList<StrategyVo>();
        try {
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);

            PageList<SysChannelStrategy> pageList = ichannelStrategyService.queryPageByParamMap(pager, sysBean);

            List<StrategyVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannelStrategy> records = pageList.getResultList();
                voList = StrategyVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Deprecated
    public PageList<StrategyVo> queryPageAuthByParamMap(PageModel pager, StrategyVo vo, List<DateQueryVo> queryDateList,

                                                        List<Long> productIds) throws Exception {

        PageList<StrategyVo> list = new PageList<StrategyVo>();
        try {
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);

            List<SysDateQuery> queryList = DateQueryVo.cList2SList(queryDateList);

            PageList<SysChannelStrategy> pageList = ichannelStrategyService.queryPageByAuthParamMap(pager, sysBean, queryList, productIds);

            List<StrategyVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannelStrategy> records = pageList.getResultList();
                voList = StrategyVo.sList2CList(records);

                // 设置政策的所有关系
                strategyVoUtil.setStrategyrAuthorityList(voList);

            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Deprecated
    public PageList<StrategyVo> queryPageAuthByParamMap(PageModel pager, StrategyVo vo) throws Exception {

        PageList<StrategyVo> list = new PageList<StrategyVo>();
        try {
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);

            PageList<SysChannelStrategy> pageList = ichannelStrategyService.queryPageByParamMap(pager, sysBean);

            List<StrategyVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannelStrategy> records = pageList.getResultList();
                voList = StrategyVo.sList2CList(records);

                // 设置政策的所有关系
                strategyVoUtil.setStrategyrAuthorityList(voList);

            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    /**
     * 给政策封装对应渠道列表
     * 
     * @param records
     *            政策列表
     * 
     */
    @Deprecated
    public List<StrategyVo> getStrategyChannelList(List<StrategyVo> records) throws Exception {
        try {
            if (records == null || records.isEmpty()) {
                return null;
            }

            // 查询用户
            String ids = strategyVoUtil.getIds(records);
            records = strategyVoUtil.getStrategyListByIds(ids);
            if (records != null && !records.isEmpty()) {
                strategyVoUtil.setStrategyChannelList(records);

            }
            return records;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    @Deprecated
    public PageList<StrategyVo> queryPageByChannelId(PageModel pager, StrategyVo vo, Long channelId) throws Exception {
        PageList<StrategyVo> list = new PageList<StrategyVo>();
        try {
            if (channelId == null || channelId < 1) {
                logger.error("接口方法[StrategyService.queryPageByChannelId],参数channelId不能为空");
                return list;
            }
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);

            PageList<SysChannelStrategy> pageList = ichannelStrategyService.queryPageByRefId(pager, sysBean, channelId,
                ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);

            List<StrategyVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannelStrategy> records = pageList.getResultList();
                voList = StrategyVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Deprecated
    public PageList<StrategyVo> queryPageAuthByChannelId(PageModel pager, StrategyVo vo, Long channelId) throws Exception {
        PageList<StrategyVo> list = new PageList<StrategyVo>();
        try {
            if (channelId == null || channelId < 1) {
                logger.error("接口方法[StrategyService.queryPageByChannelId],参数channelId不能为空");
                return list;
            }
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);

            PageList<SysChannelStrategy> pageList = ichannelStrategyService.queryPageByRefId(pager, sysBean, channelId,
                ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);

            List<StrategyVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannelStrategy> records = pageList.getResultList();
                voList = StrategyVo.sList2CList(records);

                // 设置政策的所有关系
                strategyVoUtil.setStrategyrAuthorityList(voList);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Deprecated
    public List<StrategyVo> queryByProductIdAndChannelId(Long productId, Long channelId) throws Exception {
        List<StrategyVo> list = null;
        try {
            if (productId == null || productId < 1) {
                logger.error("接口方法[StrategyService.queryPageByProductIdAndChannelId],参数productId不能为空");
                return list;
            }
            if (channelId == null || channelId < 1) {
                logger.error("接口方法[StrategyService.queryPageByProductIdAndChannelId],参数channelId不能为空");
                return list;
            }
            List<SysChannelStrategy> sList = ichannelStrategyService.queryPageByPIDAndCID(productId, channelId);
            if (sList != null && !sList.isEmpty()) {
                list = StrategyVo.sList2CList(sList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    /**
     * 给政策封装对应返利列表
     * 
     * @param records
     *            政策列表
     * 
     */
    @Deprecated
    public List<StrategyVo> getStrategyRebateList(List<StrategyVo> records) throws Exception {
        try {
            if (records == null || records.isEmpty()) {
                return null;
            }

            // 查询用户
            String ids = strategyVoUtil.getIds(records);
            records = strategyVoUtil.getStrategyListByIds(ids);
            if (records != null && !records.isEmpty()) {
                strategyVoUtil.setStrategyRebateList(records);
            }
            return records;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    @Deprecated
    public List<StrategyVo> getStrategyProductList(List<StrategyVo> records) throws Exception {
        try {
            if (records == null || records.isEmpty()) {
                return null;
            }

            // 查询用户
            String ids = strategyVoUtil.getIds(records);
            records = strategyVoUtil.getStrategyListByIds(ids);
            if (records != null && !records.isEmpty()) {
                strategyVoUtil.setStrategyProductList(records);
            }
            return records;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    @Deprecated
    public List<StrategyVo> getStrategyAuthlList(List<StrategyVo> records) throws Exception {
        try {
            if (records == null || records.isEmpty()) {
                return null;
            }

            // 查询用户
            String ids = strategyVoUtil.getIds(records);
            records = strategyVoUtil.getStrategyListByIds(ids);
            if (records != null && !records.isEmpty()) {
                // 设置政策的所有关系
                strategyVoUtil.setStrategyrAuthorityList(records);
            }
            return records;
        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
    }

    /**
     * 批量修改政策状态
     */
    @Deprecated
    public Integer updateBatchStrategyPrimaryKey(List<Long> ids, Integer status) {
        Integer num = 0;
        try {
            if (ids == null || ids.isEmpty()) {
                logger.error("接口方法[StrategyService.updateBatchStrategyPrimaryKey],参数ids不能为空");
                return num;
            }
            if (status == null) {
                logger.error("接口方法[StrategyService.updateBatchStrategyPrimaryKey],参数status不能为空");
                return num;
            }
            List<SysChannelStrategy> list = new ArrayList<SysChannelStrategy>();
            for (Long id : ids) {
                if (id == null || id < 1) {
                    continue;
                }
                SysChannelStrategy bean = new SysChannelStrategy();
                bean.setId(id);

                bean.setStatus(status);
                list.add(bean);
            }
            num = ichannelStrategyService.updateBatchByPrimaryKey(list);

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }

        return num;
    }

    @Deprecated
    public List<StrategyVo> getSpcreStrategyByChannel(List<ChannelVo> channels) throws Exception {
        List<StrategyVo> strategyList = null;
        try {
            if (channels == null || channels.isEmpty()) {
                logger.error("接口方法[StrategyService.getSpcreStrategyByChannel],参数channels不能为空");
                return strategyList;
            }
            List<SysSpcreRelationKey> relationList = authorityUtil.getStrategySpcreByChannel(channels);
            // 根据加点返利关系，获取政策
            strategyList = strategyVoUtil.getStrategySpcre(relationList);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    @Deprecated
    public List<StrategyVo> getSpcreStrategyByRebatePlus(List<RebatePlus> voList) throws Exception {
        List<StrategyVo> strategyList = null;
        try {
            if (voList == null || voList.isEmpty()) {
                logger.error("接口方法[StrategyService.getSpcreStrategyByRebatePlus],参数voList不能为空");
                return strategyList;
            }
            List<SysSpcreRelationKey> relationList = authorityUtil.getStrategySpcreByRebatePlus(voList);

            strategyList = strategyVoUtil.getStrategySpcre(relationList);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    @Deprecated
    public List<StrategyVo> getSpcreStrategyByProductId(List<Long> productIds) throws Exception {
        List<StrategyVo> strategyList = null;
        try {
            if (productIds == null || productIds.isEmpty()) {
                logger.error("接口方法[StrategyService.getSpcreStrategyByProductId],参数productIds不能为空");
                return strategyList;
            }
            List<SysSpcreRelationKey> relationList = authorityUtil.getStrategySpcreByProductId(productIds);
            strategyList = strategyVoUtil.getStrategySpcre(relationList);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    @Deprecated
    public List<StrategyVo> queryAuthByProductIdAndChannelId(Long productId, Long channelId) throws Exception {
        List<StrategyVo> list = null;
        try {
            if (productId == null || productId < 1) {
                logger.error("接口方法[StrategyService.queryPageByProductIdAndChannelId],参数productId不能为空");
                return list;
            }
            if (channelId == null || channelId < 1) {
                logger.error("接口方法[StrategyService.queryPageByProductIdAndChannelId],参数channelId不能为空");
                return list;
            }
            List<SysChannelStrategy> sList = ichannelStrategyService.queryPageByPIDAndCID(productId, channelId);
            if (sList != null && !sList.isEmpty()) {
                list = StrategyVo.sList2CList(sList);
                // 设置政策的所有关系
                strategyVoUtil.setStrategyrAuthorityList(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;

    }

    @Deprecated
    public Integer isHaveDirectProductBySupplier(Long customerId, Long supplierId, String salesType, String ticketVarie) throws Exception {
        Integer result = 0;
        try {
            if (customerId == null) {
                logger.error("接口方法[StrategyService.isHaveDirectProductBySupplier],参数customerId不能为空");
                return result;
            }
            if (supplierId == null) {
                logger.error("接口方法[StrategyService.isHaveDirectProductBySupplier],参数supplierId不能为空");
                return result;
            }

            // 先判断一个供应商下是否有直销的产品
            PageList<SysChannelStrategy> sList = ichannelStrategyService.queryCustomerDirectStrategyVoByScenic(null, null, customerId, supplierId, salesType,
                ticketVarie);
            if (sList != null && !sList.isEmpty()) {
                result = 1;
            } else {
                // 判断一个供应商下是否有分销的产品
                sList = ichannelStrategyService.queryCustomerDistributionStrategyVoByScenic(null, null, customerId, supplierId, salesType, ticketVarie);
                if (sList != null && !sList.isEmpty()) {
                    result = 2;
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    @Deprecated
    public List<StrategyVo> findCustomerDirectStrategyVoByScenic(Long scenicId, Long customerId, Long supplierId, String salesType,
                                                                 String ticketVarie) throws Exception {
        List<StrategyVo> strategyList = null;
        try {
            if (supplierId == null) {
                logger.error("接口方法[StrategyService.findCustomerDirectStrategyVoByScenic],参数supplierId不能为空");
                return strategyList;
            }
            if (scenicId == null) {
                logger.error("接口方法[StrategyService.findCustomerDirectStrategyVoByScenic],参数scenicId不能为空");
                return strategyList;
            }
            if (customerId == null) {
                logger.error("接口方法[StrategyService.findCustomerDirectStrategyVoByScenic],参数customerId不能为空");
                return strategyList;
            }

            PageList<SysChannelStrategy> sList = ichannelStrategyService.queryCustomerDirectStrategyVoByScenic(null, scenicId, customerId, supplierId,
                salesType, ticketVarie);
            if (sList != null && !sList.isEmpty()) {

                strategyList = StrategyVo.sList2CList(sList.getResultList());
                // 设置政策的渠道和产品
                strategyVoUtil.setStrategyChannelList(strategyList);
                strategyVoUtil.setStrategyProductList(strategyList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    @Deprecated
    public List<StrategyVo> findCustomerDistributionStrategyVoByScenic(Long scenicId, Long customerId, Long supplierId, String salesType,
                                                                       String ticketVarie) throws Exception {
        List<StrategyVo> strategyList = null;
        try {
            if (supplierId == null) {
                logger.error("接口方法[StrategyService.findCustomerDistributionStrategyVoByScenic],参数supplierId不能为空");
                return strategyList;
            }
            if (scenicId == null) {
                logger.error("接口方法[StrategyService.findCustomerDistributionStrategyVoByScenic],参数scenicId不能为空");
                return strategyList;
            }
            if (customerId == null) {
                logger.error("接口方法[StrategyService.findCustomerDistributionStrategyVoByScenic],参数customerId不能为空");
                return strategyList;
            }

            PageList<SysChannelStrategy> sList = ichannelStrategyService.queryCustomerDistributionStrategyVoByScenic(null, scenicId, customerId, supplierId,
                salesType, ticketVarie);
            if (sList != null && !sList.isEmpty()) {

                strategyList = StrategyVo.sList2CList(sList.getResultList());
                // 设置政策的渠道和产品
                strategyVoUtil.setStrategyChannelList(strategyList);
                strategyVoUtil.setStrategyProductList(strategyList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    @Deprecated
    public Map<String, List<StrategyVo>> findCustomerDirectStrategyVoByProductIds(Long customerId, Map<Long, Long> pidAndSids, String salesType,
                                                                                  String ticketVarie) throws Exception {
        Map<String, List<StrategyVo>> returnMap = null;
        try {
            if (customerId == null) {
                logger.error("接口方法[StrategyService.findCustomerDirectStrategyVoByProductIds],参数customerId不能为空");
                return returnMap;
            }
            if (pidAndSids == null || pidAndSids.isEmpty()) {
                logger.error("接口方法[StrategyService.findCustomerDirectStrategyVoByProductIds],参数pidAndSids不能为空");
                return returnMap;
            }

            Map<String, List<SysChannelStrategy>> map = new HashMap<String, List<SysChannelStrategy>>();
            for (Map.Entry<Long, Long> entry : pidAndSids.entrySet()) {
                Long key = entry.getKey();
                Long value = entry.getValue();
                if (key == null || value == null) {
                    continue;
                }
                List<SysChannelStrategy> listBean = ichannelStrategyService.queryCustomerDirectStrategyVoByProductIds(customerId, key, value, salesType,
                    ticketVarie);
                map.put(customerId + "," + key, listBean);
            }
            if (map != null && !map.isEmpty()) {
                returnMap = new HashMap<String, List<StrategyVo>>();
                for (Map.Entry<String, List<SysChannelStrategy>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<SysChannelStrategy> value = entry.getValue();
                    if (value == null || value.isEmpty()) {
                        continue;
                    }
                    List<StrategyVo> volist = StrategyVo.sList2CList(value);
                    // 设置政策的所有关系
                    strategyVoUtil.setStrategyrAuthorityList(volist);
                    returnMap.put(key, volist);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return returnMap;
    }

    @Deprecated
    public Map<String, List<StrategyVo>> findCustomerDistributionStrategyVoByProductIds(Long customerId, Map<Long, Long> pidAndSids, String salesType,
                                                                                        String ticketVarie) throws Exception {
        Map<String, List<StrategyVo>> returnMap = null;
        try {
            if (customerId == null) {
                logger.error("接口方法[StrategyService.findCustomerDistributionStrategyVoByProductIds],参数customerId不能为空");
                return returnMap;
            }
            if (pidAndSids == null || pidAndSids.isEmpty()) {
                logger.error("接口方法[StrategyService.findCustomerDistributionStrategyVoByProductIds],参数pidAndSids不能为空");
                return returnMap;
            }

            Map<String, List<SysChannelStrategy>> sysMap = new HashMap<String, List<SysChannelStrategy>>();
            for (Map.Entry<Long, Long> entry : pidAndSids.entrySet()) {
                Long key = entry.getKey();
                Long value = entry.getValue();
                if (key == null || value == null) {
                    continue;
                }
                List<SysChannelStrategy> listBean = ichannelStrategyService.queryCustomerDistributionStrategyVoByProductIds(customerId, key, value, salesType,
                    ticketVarie);

                if (listBean != null && !listBean.isEmpty()) {
                    sysMap.put(customerId + "," + key, listBean);
                    for (SysChannelStrategy bean : listBean) {
                        Long supplierId = bean.getSupplierId();
                        if (supplierId != null) {
                            recursionDistributionStrategyVo(sysMap, supplierId, key, salesType, ticketVarie);
                        }

                    }

                }

            }

            if (sysMap != null && !sysMap.isEmpty()) {
                returnMap = new HashMap<String, List<StrategyVo>>();
                for (Map.Entry<String, List<SysChannelStrategy>> entry : sysMap.entrySet()) {
                    String key = entry.getKey();
                    List<SysChannelStrategy> value = entry.getValue();
                    if (value == null || value.isEmpty()) {
                        continue;
                    }
                    List<StrategyVo> volist = new LinkedList<StrategyVo>();
                    for (SysChannelStrategy bean : value) {
                        StrategyVo vo = StrategyVo.changeTAPIBean(bean);
                        volist.add(vo);

                    }
                    // 设置政策的所有关系
                    strategyVoUtil.setStrategyrAuthorityList(volist);
                    returnMap.put(key, volist);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return returnMap;
    }

    /**
     * 递归
     */
    private void recursionDistributionStrategyVo(Map<String, List<SysChannelStrategy>> returnMap, Long customerId, Long pid, String salesType,
                                                 String ticketVarie) {

        List<SysChannelStrategy> listBean = ichannelStrategyService.queryCustomerDistributionStrategyVoByProductIds(customerId, pid, null, salesType,
            ticketVarie);
        if (listBean == null || listBean.isEmpty()) {
            return;
        } else {
            returnMap.put(customerId + "," + pid, listBean);
            for (SysChannelStrategy bean : listBean) {
                customerId = bean.getSupplierId();
                if (customerId == null) {
                    continue;
                }
                recursionDistributionStrategyVo(returnMap, customerId, pid, salesType, ticketVarie);
            }
        }

    }

    private List<SysChannelStrategy> convertTSysBean(List<StrategyVo> beans) {
        try {
            List<SysChannelStrategy> entityList = new ArrayList<SysChannelStrategy>();
            for (StrategyVo vo : beans) {
                SysChannelStrategy cs = StrategyVo.createNew(vo);

                List<ChannelVo> cvLict = vo.getChannelList();
                // 渠道关联
                if (cvLict != null && !cvLict.isEmpty()) {
                    cs.setChannelList(ChannelVo.cList2SList(cvLict));
                }
                // 分销渠道返利规则
                List<RebateStrategyVo> svList = vo.getRebateStrategyList();
                if (svList != null && !svList.isEmpty()) {
                    cs.setRebateStrategyList(RebateStrategyVo.cList2SList(svList));
                }

                // 减免结算规则
                List<StrategySettlementRule> settlementList = vo.getSettlementRuleList();
                cs.setSettlementRuleList(settlementUtil.convertListTSysBeanForIU(settlementList));

                cs.setProductIds(vo.getProductList());
                entityList.add(cs);
            }
            return entityList;

        } catch (Exception e) {
            logger.error("政策数据转换错误", e);
        }
        return null;

    }

    public Integer createBatchAndAuth(List<StrategyVo> beans) throws Exception {

        try {
            if (beans == null) {
                logger.error("接口方法[StrategyService.createBatchAndAuth],参数beans不能为空");
            }
            List<SysChannelStrategy> entityList = convertTSysBean(beans);

            return ichannelStrategyService.addBatchAndAuth(entityList, false);// 批量新增渠道政策服务接口
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

    }

    public Integer createBatchAndAuthWithMicroshop(List<StrategyVo> beans) throws Exception {

        try {
            if (beans == null) {
                logger.error("接口方法[StrategyService.createBatchAndAuth],参数beans不能为空");
            }
            List<SysChannelStrategy> entityList = convertTSysBean(beans);

            return ichannelStrategyService.addBatchAndAuth(entityList, true);// 批量新增渠道政策服务接口
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

    }

    @Override
    public Integer updateBatchAndAuth(List<StrategyVo> beans) throws Exception {

        Integer num = 0;
        try {
            if (beans == null) {
                logger.error("接口方法[StrategyService.updateBatchAndAuth],参数beans不能为空");
            }
            List<SysChannelStrategy> entityList = new ArrayList<SysChannelStrategy>();
            for (StrategyVo vo : beans) {
                SysChannelStrategy cs = StrategyVo.changeTSysBean(vo);
                if (vo != null) {
                    List<ChannelVo> cvLict = vo.getChannelList();
                    if (cvLict != null && !cvLict.isEmpty()) {// 关联渠道
                        cs.setChannelList(ChannelVo.cList2SList(cvLict));
                    }

                    List<RebateStrategyVo> svList = vo.getRebateStrategyList();
                    if (svList != null && !svList.isEmpty()) {// 返利
                        cs.setRebateStrategyList(RebateStrategyVo.cList2SList(svList));
                    }

                    // 减免结算规则
                    List<StrategySettlementRule> settlementList = vo.getSettlementRuleList();
                    cs.setSettlementRuleList(settlementUtil.convertListTSysBeanForIU(settlementList));

                    cs.setProductIds(vo.getProductList());// 政策关联的产品
                }

                entityList.add(cs);
            }
            ichannelStrategyService.updateBatchAndAuth(entityList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    @Override
    public List<StrategyVo> queryListByAllParamMap(StrategyVo vo) throws Exception {
        List<StrategyVo> list = null;
        try {
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);

            // 暂时先做模糊查询
            if (sysBean != null && StringUtils.isNotBlank(sysBean.getSalesType())) {
                sysBean.setSalesType("%" + sysBean.getSalesType() + "%");
            }

            PageList<SysChannelStrategy> spList = ichannelStrategyService.queryByAllParam(null, sysBean);
            if (spList != null && !spList.isEmpty()) {
                List<SysChannelStrategy> sList = spList.getResultList();
                list = StrategyVo.sList2CList(sList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    /**
     * 分页查询政策及政策关联的实体（空方法）
     * 
     * @param vo
     * @return
     */
    @Override
    public PageList<StrategyVo> queryPageByAllParamMap(PageModel page, StrategyVo vo) throws Exception {

        PageList<StrategyVo> list = new PageList<StrategyVo>();
        try {
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);
            PageList<SysChannelStrategy> pageList = ichannelStrategyService.queryByAllParam(page, sysBean);
            List<StrategyVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannelStrategy> records = pageList.getResultList();
                voList = StrategyVo.sList2CList(records);

            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Override
    public List<StrategyVo> queryListAuthByAllParamMap(StrategyVo vo) throws Exception {
        List<StrategyVo> list = null;
        try {
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);
            PageList<SysChannelStrategy> spList = ichannelStrategyService.queryByAllParam(null, sysBean);
            if (spList != null && !spList.isEmpty()) {
                List<SysChannelStrategy> sList = spList.getResultList();
                list = StrategyVo.sList2CList(sList);
                // 设置政策的所有关系
                strategyVoUtil.setStrategyrAuthorityList(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    public PageList<StrategyVo> queryPageAuthByAllParamMap(PageModel page, StrategyVo vo) throws Exception {
        PageList<StrategyVo> list = new PageList<StrategyVo>();
        try {
            SysChannelStrategy sysBean = StrategyVo.changeTSysBean(vo);

            if (sysBean != null) {
                if (sysBean.getName() != null)
                    sysBean.setName(sysBean.getName() + "%");
            }

            PageList<SysChannelStrategy> pageList = ichannelStrategyService.queryByAllParam(page, sysBean);
            List<StrategyVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannelStrategy> records = pageList.getResultList();
                voList = StrategyVo.sList2CList(records);

                // 设置政策的所有关系
                strategyVoUtil.setStrategyrAuthorityList(voList);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    public List<StrategyVo> isHaveStrategyByDate(StrategyVo vo, Date startDate, Date endDate) throws Exception {
        Long startDateTime = null;
        Long endDateTime = null;
        if (startDate != null) {
            startDateTime = startDate.getTime();
        }
        if (endDate != null) {
            endDateTime = endDate.getTime();
        }
        // 销售端口过滤,无法用SQL直接过滤，需要程序匹配过滤
        List<KeyValueVo> haveSaleType = vo.getSalesType();
        vo.setSalesType(null);

        List<StrategyVo> returnList = new ArrayList<StrategyVo>();
        List<StrategyVo> list = queryListByAllParamMap(vo);

        // 销售端口程序过滤
        strategyVoUtil.filterStrategyBySaleType(list, haveSaleType);

        if (list == null || list.isEmpty()) {
            return null;
        }
        for (StrategyVo bean : list) {
            if (StrategyGlobalDict.strategyStatusEnbaled() != bean.getStatus()) {
                continue;
            }
            if (StrategyGlobalDict.finalStrategyExpire() == bean.getStrategyExpireType()) {
                returnList.add(bean);
            } else {
                Date sDate = bean.getBeginDate();
                Date eDate = bean.getEndDate();
                Long sDateTime = null;
                Long eDateTime = null;
                if (sDate == null || eDate == null) {
                    continue;
                }
                sDateTime = sDate.getTime();
                eDateTime = eDate.getTime();
                if ((startDateTime != null && startDateTime >= sDateTime) || (endDateTime != null && endDateTime <= eDateTime)
                    || (startDateTime != null && endDateTime != null && startDateTime < sDateTime && endDateTime > eDateTime)) {
                    returnList.add(bean);
                }

            }

        }
        return returnList;
    }

    public List<StrategyVo> findStrategyByScenic(Long scenicId, String ticketVarie) throws Exception {
        if (scenicId == null) {
            logger.error("接口方法[StrategyService.findStrategyByScenic],参数scenicId不能为空");
            return null;
        }
        List<StrategyVo> strategyList = null;
        try {
            /** 获取直销政策 */
            PageList<SysChannelStrategy> directList = ichannelStrategyService.queryDirectStrategyVoByScenic(null, scenicId, null, ticketVarie);

            /** 获取分销直连政策 */
            PageList<SysChannelStrategy> customerdirectList = ichannelStrategyService.queryCustomerDirectStrategyVoByScenic(null, scenicId, null, null, null,
                ticketVarie);

            List<SysChannelStrategy> sList = new ArrayList<SysChannelStrategy>();
            if (directList != null && !directList.isEmpty()) {
                sList.addAll(directList.getResultList());
            }
            if (customerdirectList != null && !customerdirectList.isEmpty()) {
                sList.addAll(customerdirectList.getResultList());
            }

            if (sList != null && !sList.isEmpty()) {

                strategyList = StrategyVo.sList2CList(sList);
                // 设置政策的渠道,产品,返利
                strategyVoUtil.setStrategyrAuthorityList(strategyList);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    public List<StrategyVo> findStrategyByScenic(Long customerId, Long scenicId, Long supplierId, String ticketVarie) throws Exception {
        if (supplierId == null) {
            logger.error("接口方法[StrategyService.findStrategyByScenic],参数customerId不能为空");
            return null;
        }
        if (scenicId == null) {
            logger.error("接口方法[StrategyService.findStrategyByScenic],参数scenicId不能为空");
            return null;
        }

        List<StrategyVo> strategyList = null;
        try {
            /** 获取直销政策 */
            PageList<SysChannelStrategy> directList = ichannelStrategyService.queryDirectStrategyVoByScenic(null, scenicId, null, ticketVarie);

            /** 获取分销直连政策 */
            PageList<SysChannelStrategy> customerdirectList = ichannelStrategyService.queryCustomerDirectStrategyVoByScenic(null, scenicId, customerId,
                supplierId, null, ticketVarie);

            /** 获取分销政策 */
            PageList<SysChannelStrategy> customerDistributionList = ichannelStrategyService.queryCustomerDistributionStrategyVoByScenic(null, scenicId,
                customerId, supplierId, null, ticketVarie);

            List<SysChannelStrategy> sList = new ArrayList<SysChannelStrategy>();
            if (directList != null && !directList.isEmpty()) {
                sList.addAll(directList.getResultList());
            }
            if (customerdirectList != null && !customerdirectList.isEmpty()) {
                sList.addAll(customerdirectList.getResultList());
            }
            if (customerDistributionList != null && !customerDistributionList.isEmpty()) {
                sList.addAll(customerDistributionList.getResultList());
            }

            if (sList != null && !sList.isEmpty()) {

                strategyList = StrategyVo.sList2CList(sList);
                // 设置政策的渠道,产品,返利
                strategyVoUtil.setStrategyrAuthorityList(strategyList);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    private List<StrategyVo> findStrategyByScenicCommon(Long customerId, Long scenicId, Long supplierId, String ticketVarie) throws Exception {
        List<StrategyVo> strategyList = null;
        try {
            /** 获取直销政策 */
            PageList<SysChannelStrategy> directList = ichannelStrategyService.queryDirectStrategyVoByScenic(null, scenicId, null, ticketVarie);

            /** 获取分销直连政策 */
            PageList<SysChannelStrategy> customerdirectList = ichannelStrategyService.queryCustomerDirectStrategyVoByScenic(null, scenicId, customerId,
                supplierId, null, ticketVarie);

            /** 获取分销政策 */
            PageList<SysChannelStrategy> customerDistributionList = ichannelStrategyService.queryCustomerDistributionStrategyVoByScenic(null, scenicId,
                customerId, supplierId, null, ticketVarie);

            List<SysChannelStrategy> sList = new ArrayList<SysChannelStrategy>();
            if (directList != null && !directList.isEmpty()) {
                sList.addAll(directList.getResultList());
            }
            if (customerdirectList != null && !customerdirectList.isEmpty()) {
                sList.addAll(customerdirectList.getResultList());
            }

            if (sList != null && !sList.isEmpty()) {

                strategyList = StrategyVo.sList2CList(sList);
                // 设置政策的渠道,产品,返利
                strategyVoUtil.setStrategyrAuthorityList(strategyList);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    public Map<String, List<StrategyVo>> findStrategyByProductIds(Map<Long, String> pidAndCid, Long customerId, String ticketVarie) throws Exception {
        Map<String, List<StrategyVo>> returnMap = new HashMap<String, List<StrategyVo>>();
        try {
            if (customerId == null) {
                logger.error("接口方法[StrategyService.findStrategyByProductIds],参数customerId不能为空");
                return returnMap;
            }
            if (pidAndCid == null || pidAndCid.isEmpty()) {
                logger.error("接口方法[StrategyService.findStrategyByProductIds],参数pidAndSids不能为空");
                return returnMap;
            }

            List<StrategyVo> voList = new ArrayList<StrategyVo>();
            for (Map.Entry<Long, String> entry : pidAndCid.entrySet()) {
                Long key = entry.getKey();
                if (key == null) {
                    logger.error("接口[StrategyService.findStrategyByProductIds]，参数pidAndCid中有产品id为空");
                    continue;
                }
                String value = entry.getValue();
                if (StringUtils.isBlank(value)) {
                    continue;
                }
                String[] valueArray = value.split(",");
                if (valueArray.length < 2) {
                    continue;
                }
                if (valueArray[0] == null || valueArray[0].equals("")) {
                    continue;
                }
                if (valueArray[1] == null || valueArray[1].equals("")) {
                    continue;
                }
                /** 获取渠道 */
                ChannelVo vo = channelVoUtil.getRecordById(Long.valueOf(valueArray[1]));
                if (vo != null) {
                    recursionStrategyVo(returnMap, key, Long.valueOf(valueArray[0]), vo, customerId, ticketVarie, voList);
                }

            }
            if (voList != null && !voList.isEmpty()) {
                strategyVoUtil.setStrategyProductList(voList);
                strategyVoUtil.setStrategyRebateList(voList);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return returnMap;
    }

    /**
     * 递归
     * 
     * @param returnMap
     *            key:分销商Id+","+产品，value:产品和分销商对应的政策
     * 
     * @throws Exception
     */
    private void recursionStrategyVo(Map<String, List<StrategyVo>> returnMap, Long productId, Long pSupplierId, ChannelVo channel, Long customerId,
                                     String ticketVarie, List<StrategyVo> voList) throws Exception {

        if (customerId == null || productId == null || pSupplierId == null) {
            return;
        }

        // 1.获取分销商对应的渠道
        if (channel == null) {
            Customer customer = customerUtil.getCustomerChannelById(customerId);
            if (customer == null) {
                throw new Exception("没有分销商用户：" + customerId);
            }
            List<ChannelVo> channelList = customer.getChannelVoList();
            channelVoUtil.filterChannelFlag(channelList, String.valueOf(GlobalParam.FLAG.off()), String.valueOf(GlobalParam.FLAG.del()));
            if (channelList == null || channelList.isEmpty()) {
                throw new Exception("分销商：" + customerId + " 没有关联有效的渠道");
            }
            channel = channelList.get(0);
        }

        List<ChannelVo> channelList = new ArrayList<ChannelVo>();
        channelList.add(channel);

        StrategyVo paramVo = new StrategyVo();
        paramVo.setTicketVarie(ticketVarie);
        List<Long> channelIds = new ArrayList<Long>();
        channelIds.add(channel.getId());
        paramVo.setChannelIds(channelIds);
        List<Long> productIds = new ArrayList<Long>();
        productIds.add(productId);
        paramVo.setProductList(productIds);
        List<StrategyVo> listBean = queryListByAllParamMap(paramVo);

        // 按照政策的供应商id对政策列表进行拆分
        Map<Long, List<StrategyVo>> map = new HashMap<Long, List<StrategyVo>>();
        if (listBean == null || listBean.isEmpty()) {
            return;
        }
        for (StrategyVo vo : listBean) {
            Long supplierId = vo.getSupplierId();
            if (supplierId == null)
                continue;
            // 给政策添加渠道信息
            vo.setChannelList(channelList);
            if (map.get(supplierId) == null) {
                List<StrategyVo> strategyList = new ArrayList<StrategyVo>();
                strategyList.add(vo);
                map.put(supplierId, strategyList);
            } else {
                List<StrategyVo> strategyList = map.get(supplierId);
                strategyList.add(vo);
            }
        }

        // 放入该分销商+产品对应的所有政策
        returnMap.put(customerId + "," + productId, listBean);
        voList.addAll(listBean);

        // 将政策的供应商作为分销商向上递归查找
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<Long, List<StrategyVo>> entry : map.entrySet()) {
            Long key = entry.getKey();

            if (key.longValue() != pSupplierId.longValue()) {
                recursionStrategyVo(returnMap, productId, pSupplierId, null, key, ticketVarie, voList);
            }
        }

    }

    @Override
    public List<StrategyVo> findComposeStrategyByScenic(Long customerId, Long scenicId, String ticketVarie) throws Exception {
        List<StrategyVo> strategyList = null;
        try {
            if (customerId == null) {
                logger.error("接口方法[StrategyService.findComposeStrategyByScenic],参数customerId不能为空");
                return strategyList;
            }
            if (scenicId == null) {
                logger.error("接口方法[StrategyService.findComposeStrategyByScenic],参数scenicId不能为空");
                return strategyList;
            }

            /** 获取直销政策 */
            PageList<SysChannelStrategy> directList = ichannelStrategyService.queryComposeDirectStrategyVoByScenic(null, scenicId, ticketVarie);

            /** 获取分销政策 */
            PageList<SysChannelStrategy> customerdirectList = ichannelStrategyService.queryComposeDistributionStrategyVoByScenic(null, scenicId, customerId,
                ticketVarie);

            List<SysChannelStrategy> sList = new ArrayList<SysChannelStrategy>();
            if (directList != null && !directList.isEmpty()) {
                sList.addAll(directList.getResultList());
            }
            if (customerdirectList != null && !customerdirectList.isEmpty()) {
                sList.addAll(customerdirectList.getResultList());
            }

            if (sList != null && !sList.isEmpty()) {

                strategyList = StrategyVo.sList2CList(sList);
                // 设置政策的渠道,产品,返利
                strategyVoUtil.setStrategyrAuthorityList(strategyList);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return strategyList;
    }

    public Map<String, List<StrategyVo>> findComposeStrategyByProductIds(List<Long> productIds, Long customerId, String ticketVarie) throws Exception {
        Map<String, List<StrategyVo>> returnMap = new HashMap<String, List<StrategyVo>>();
        try {
            if (customerId == null) {
                logger.error("接口方法[StrategyService.findComposeStrategyByProductIds],参数customerId不能为空");
                return returnMap;
            }
            if (productIds == null || productIds.isEmpty()) {
                logger.error("接口方法[StrategyService.findComposeStrategyByProductIds],参数productIds不能为空");
                return returnMap;
            }
            if (StringUtils.isBlank(ticketVarie)) {
                logger.error("接口方法[StrategyService.findComposeStrategyByProductIds],参数ticketVarie不能为空");
                return returnMap;
            }
            // 查询的所有产品的政策集合，为了统一给这些政策设置产品，渠道和返利
            List<StrategyVo> allList = new ArrayList<StrategyVo>();
            for (Long productId : productIds) {
                List<SysChannelStrategy> productAllSList = new ArrayList<SysChannelStrategy>();

                /** 1.获取产品的直销政策 */
                List<SysChannelStrategy> directList = ichannelStrategyService.queryDirectStrategyVoByProductIds(productId, null, ticketVarie);
                productAllSList.addAll(directList);

                /** 2.获取产品的分销（直签或魔方政策） */
                List<SysChannelStrategy> distributionList = ichannelStrategyService.queryCustomerDistributionStrategyVoByProductIds(customerId, productId, null,
                    null, ticketVarie);

                productAllSList.addAll(distributionList);

                // 服务层和API层实体转换
                List<StrategyVo> allProductList = StrategyVo.sList2CList(productAllSList);
                allList.addAll(allProductList);

                returnMap.put(String.valueOf(productId), allProductList);
            }

            // 给政策设置产品，渠道和返利
            strategyVoUtil.setStrategyrAuthorityList(allList);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }
        return returnMap;
    }

    public Map<String, List<StrategyVo>> findStrategyForPMS(StrategyVo param, Long customerId) throws Exception {
        Map<String, List<StrategyVo>> returnMap = new HashMap<String, List<StrategyVo>>();
        return null;
    }

    /**
     * 编辑平台渠道政策
     */
    @Override
    public Integer updateForPlatform(StrategyVo vo) throws Exception {
        Integer num = 0;
        try {
            if (vo == null) {
                logger.error("接口方法[StrategyService.updateForPlatform],参数vo不能为空");
            }
            SysChannelStrategy cs = StrategyVo.changeTSysBean(vo);

            // 渠道关联
            List<SysChannel> csList = null;
            // 分销渠道返利规则
            List<SysRebateStrategy> rslist = null;
            if (vo != null) {
                List<ChannelVo> cvLict = vo.getChannelList();
                if (cvLict != null && !cvLict.isEmpty()) {
                    csList = ChannelVo.cList2SList(cvLict);
                }
                List<RebateStrategyVo> svList = vo.getRebateStrategyList();
                if (svList != null && !svList.isEmpty()) {
                    rslist = RebateStrategyVo.cList2SList(svList);
                }
            }

            Long updateNum = ichannelStrategyService.updateStrategyAndAuthForPlatform(cs, vo.getProductList(), csList, rslist);
            num = Integer.valueOf(String.valueOf(updateNum));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    @Override
    public Integer updateBatchAndAuthForPlatform(List<StrategyVo> beans) throws Exception {
        Integer num = 0;
        try {
            if (beans == null) {
                logger.error("接口方法[StrategyService.updateBatchAndAuth],参数beans不能为空");
            }
            List<SysChannelStrategy> entityList = new ArrayList<SysChannelStrategy>();
            for (StrategyVo vo : beans) {
                SysChannelStrategy cs = StrategyVo.changeTSysBean(vo);
                if (vo != null) {
                    List<ChannelVo> cvLict = vo.getChannelList();
                    if (cvLict != null && !cvLict.isEmpty()) {// 关联渠道
                        cs.setChannelList(ChannelVo.cList2SList(cvLict));
                    }

                    List<RebateStrategyVo> svList = vo.getRebateStrategyList();
                    if (svList != null && !svList.isEmpty()) {// 返利
                        cs.setRebateStrategyList(RebateStrategyVo.cList2SList(svList));
                    }

                    // 减免结算规则
                    List<StrategySettlementRule> settlementList = vo.getSettlementRuleList();
                    cs.setSettlementRuleList(settlementUtil.convertListTSysBeanForIU(settlementList));

                    cs.setProductIds(vo.getProductList());// 政策关联的产品
                }

                entityList.add(cs);
            }
            ichannelStrategyService.updateBatchAndAuthForPlatform(entityList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

}
