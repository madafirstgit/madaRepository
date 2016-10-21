package com.pzj.regulation.service;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.authority.service.AuthorityUtil;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.entity.*;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.service.product.IProductReleaseService;
import com.pzj.base.service.sys.IChannelStrategyService;
import com.pzj.base.service.sys.IExtraRebateStrategyService;
import com.pzj.base.service.sys.IRebateStrategyService;
import com.pzj.base.service.sys.ISpcreRelationService;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.impl.ChannelVoUtil;
import com.pzj.regulation.entity.CusProductPriceVO;
import com.pzj.regulation.entity.ExtraRebateStrategyVo;
import com.pzj.regulation.entity.RebateStrategyVo;
import com.pzj.regulation.entity.StrategyVo;
import com.pzj.util.KeyValueVo;

@Component
public class StrategyVoUtil {
    @Autowired
    private IRebateStrategyService irebateStrategyService = null;
    @Autowired
    private IChannelStrategyService ichannelStrategyService = null;
    @Autowired
    private IExtraRebateStrategyService iextraRebateStrategyService = null;
    @Autowired
    private IProductReleaseService iproductReleaseService = null;
    @Autowired
    private ISpcreRelationService ispcreRelationService = null;
    @Autowired
    private AuthorityUtil authorityUtil = null;
    @Autowired
    private ChannelVoUtil channelVoUtil = null;

    /**
     * 遍历列表，拼接Ids
     */
    public String getIds(List<StrategyVo> records) {

        if (records == null || records.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (StrategyVo vo : records) {
            Long id = vo.getId();
            if (id != null) {
                buff.append(id).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    /**
     * 根据ids获取所有政策列表
     * 
     * @throws Exception
     */
    public List<StrategyVo> getStrategyListByIds(String ids)
            throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ids)) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.STRATEGY_MAP_KEY, ids);
        }

        List<StrategyVo> list = null;
        List<SysChannelStrategy> sysList = ichannelStrategyService
                .findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            list = StrategyVo.sList2CList(sysList);
        }
        return list;
    }

    /**
     * 根据id列表获取所有政策列表
     * 
     * @throws Exception
     */
    public List<StrategyVo> getStrategyListByIdList(List<Long> idList)
            throws Exception {
        if (idList == null || idList.isEmpty()) {
            return null;
        }
        idList = authorityUtil.checkIDRepetition(idList);
        Map<String, Object> idsMap = new HashMap<String, Object>();

        if (idList != null && !idList.isEmpty()) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.STRATEGY_MAP_KEY,
                    idList);
        }

        List<StrategyVo> list = null;
        List<SysChannelStrategy> sysList = ichannelStrategyService
                .findByIdList(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            list = StrategyVo.sList2CList(sysList);
        }
        return list;
    }

    /**
     * 根据产品主键集合返回产品列表
     */
    public Map<Long, CusProductPriceVO> getProductByIdList(List<Long> ids) {
        Map<Long, CusProductPriceVO> volist = null;
        ProductRelease vo = new ProductRelease();
        vo.setIds(ids);
        List<ProductRelease> list = iproductReleaseService.findListByParams(vo);
        if (list != null && !list.isEmpty()) {
            volist = new HashMap<Long, CusProductPriceVO>();
            for (ProductRelease bean : list) {
                Long productId = bean.getId();
                CusProductPriceVO cvo = CusProductPriceVO
                        .proReleaseToProPrice(bean);

                volist.put(productId, cvo);
            }
        }
        return volist;
    }

    /**
     * 根据ids获取所有返利列表
     * 
     * @throws Exception
     */
    public List<RebateStrategyVo> getRStrategyListByIds(String ids)
            throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ids)) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.REBATE_MAP_KEY, ids);
        }

        List<RebateStrategyVo> list = null;
        List<SysRebateStrategy> sysList = irebateStrategyService
                .findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            list = RebateStrategyVo.sList2CList(sysList);
        }
        return list;
    }

    /**
     * 根据ids获取所有返利Map
     * 
     * @throws Exception
     */
    public Map<Long, RebateStrategyVo> getRStrategyMapByIds(String ids)
            throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ids)) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.REBATE_MAP_KEY, ids);
        }

        Map<Long, RebateStrategyVo> map = null;
        List<SysRebateStrategy> sysList = irebateStrategyService
                .findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            map = new HashMap<Long, RebateStrategyVo>();
            for (SysRebateStrategy bean : sysList) {
                map.put(bean.getId(), RebateStrategyVo.changeTAPIBean(bean));
            }
        }
        return map;
    }

    /**
     * 根据ids获取所有加点返利列表
     * 
     * @throws Exception
     */
    public List<ExtraRebateStrategyVo> getExtraRStrategyListByIds(
            String ids) throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ids)) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.EXTRA_REBATE_MAP_KEY,
                    ids);
        }

        List<ExtraRebateStrategyVo> list = null;
        List<SysExtraRebateStrategy> sysList = iextraRebateStrategyService
                .findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            list = ExtraRebateStrategyVo.sList2CList(sysList);
        }
        return list;
    }

    /**
     * 根据ids获取所有加点返利列表
     * 
     * @throws Exception
     */
    public Map<Long, ExtraRebateStrategyVo> getExtraRStrategyMapByIds(
            String ids) throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ids)) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.EXTRA_REBATE_MAP_KEY,
                    ids);
        }

        Map<Long, ExtraRebateStrategyVo> map = null;
        List<SysExtraRebateStrategy> sysList = iextraRebateStrategyService
                .findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            map = new HashMap<Long, ExtraRebateStrategyVo>();
            for (SysExtraRebateStrategy vo : sysList) {
                map.put(vo.getId(), ExtraRebateStrategyVo.changeTAPIBean(vo));
            }

        }
        return map;
    }

    /**
     * 给政策封装对应所有的产品列表
     * 
     * @throws Exception
     */
    public void setStrategyProductList(List<StrategyVo> records)
            throws Exception {
        if (records == null || records.isEmpty()) {
            return;
        }
        String objIds = getIds(records);
        List<SysLabelRelationKey> relationList = authorityUtil
                .getRelationList(objIds, null,
                        ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);

        if (relationList == null || relationList.isEmpty()) {
            return;
        }
        Map<String, List<Long>> idMaps = authorityUtil
                .getRelationIdList(relationList);
        List<Long> refIds = idMaps.get(ChannelMapKeyParam.REF_MAP_KEY);
        Map<Long, CusProductPriceVO> allpList = getProductByIdList(refIds);

        if (allpList == null || allpList.isEmpty()) {
            return;
        }
        for (StrategyVo record : records) {
            List<Long> productList = new ArrayList<Long>();
            List<CusProductPriceVO> productVoList = new ArrayList<CusProductPriceVO>();
            String id = String.valueOf(record.getId());
            for (SysLabelRelationKey relation : relationList) {
                if (id.equals(relation.getObjId())) {
                    String relId = relation.getRelId();
                    Long relId_ = Long.valueOf(relId);
                    CusProductPriceVO vo = allpList.get(relId_);
                    if (vo == null)
                        continue;
                    productList.add(relId_);
                    productVoList.add(vo);
                }

            }
            record.setProductList(productList);
            record.setProductVoList(productVoList);
        }
    }

    /**
     * 给政策封装对应的有效渠道列表
     * 
     * @throws Exception
     */
    public void setStrategyChannelList(List<StrategyVo> records)
            throws Exception {
        if (records != null && !records.isEmpty()) {
            String objIds = getIds(records);
            List<SysLabelRelationKey> relationList = authorityUtil
                    .getRelationList(objIds, null,
                            ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
            if (relationList != null && !relationList.isEmpty()) {
                Map<String, String> idMaps = authorityUtil
                        .getRelationIds(relationList);

                String refIds = idMaps.get(ChannelMapKeyParam.REF_MAP_KEY);

                List<ChannelVo> voList = channelVoUtil
                        .getRecordListByIds(refIds);
                if (voList != null && !voList.isEmpty()) {
                    for (StrategyVo record : records) {
                        List<ChannelVo> labelList = new ArrayList<ChannelVo>();
                        String id = String.valueOf(record.getId());
                        for (SysLabelRelationKey relation : relationList) {
                            if (id.equals(relation.getObjId())) {
                                for (ChannelVo vo : voList) {
                                    if (relation.getRelId().equals(
                                            String.valueOf(vo.getId()))) {
                                        labelList.add(vo);
                                    }
                                }
                            }

                        }
                        record.setChannelList(labelList);
                    }
                }

            }

        }

    }

    /**
     * 给政策封装对应的有效返利列表
     * 
     * @throws Exception
     */
    public void setStrategyRebateList(List<StrategyVo> strategyList)
            throws Exception {
        if (CollectionUtils.isEmpty(strategyList))
            return;
        String objIds = getIds(strategyList);
        List<SysLabelRelationKey> relationList = authorityUtil.getRelationList(
                objIds, null, ChannelMapKeyParam.STRATEGY_REBATE_RELATION_TYPE);
        if (CollectionUtils.isEmpty(relationList))
            return;

        List<RebateStrategyVo> rebateList = getRebateOfRelations(relationList);
        if (CollectionUtils.isEmpty(rebateList))
            return;

        Map<Long, RebateStrategyVo> rebateMap = buildupRebateToStrategy(
                strategyList, relationList, rebateList);

        buildupExtraRebate(rebateList, rebateMap);
    }

    /**
     * 给政策封装对应的所有关系列表
     * 
     * @throws Exception
     */
    public void setStrategyrAuthorityList(List<StrategyVo> records)
            throws Exception {
        if (records != null && !records.isEmpty()) {
            // 设置渠道
            setStrategyChannelList(records);

            // 设置产品
            setStrategyProductList(records);

            // 设置返利
            setStrategyRebateList(records);
        }
    }

    /**
     * huxn---给加点返封装对应的前置景区对象
     * 
     * @param extraList
     * @param extraList
     */
    public void setExtraRebateStrategyProductList(
            List<ExtraRebateStrategyVo> extraList) {
        if (extraList == null || extraList.isEmpty()) {
            return;
        }
        List<Long> productIds = new ArrayList<Long>();
        for (ExtraRebateStrategyVo vo : extraList) {
            Long productId = vo.getFrontProductId();
            if (productId == null) {
                continue;
            }
            productIds.add(productId);
        }

        if (productIds == null || productIds.isEmpty()) {
            return;
        }
        Map<Long, CusProductPriceVO> productVoList = getProductByIdList(productIds);
        if (productVoList == null || productVoList.isEmpty()) {
            return;
        }
        for (ExtraRebateStrategyVo vo : extraList) {
            Long productId = vo.getFrontProductId();
            if (productId == null) {
                continue;
            }
            CusProductPriceVO proVo = productVoList.get(productId);
            if (proVo == null)
                continue;
            vo.setFrontProductVo(proVo);
        }

    }

    /**
     * 根据政策加点返利关系获取政策
     * 
     * @throws Exception
     * 
     */
    public List<StrategyVo> getStrategySpcre(
            List<SysSpcreRelationKey> relationList) throws Exception {
        List<StrategyVo> records = null;
        if (relationList == null || relationList.isEmpty()) {
            return records;
        }

        Map<String, String> idsMap = ispcreRelationService
                .getRelationIds(relationList);
        String strategyIds = idsMap.get(ChannelMapKeyParam.STRATEGY_MAP_KEY);
        String productIds = idsMap.get(ChannelMapKeyParam.PRODUCT_MAP_KEY);
        String channelIds = idsMap.get(ChannelMapKeyParam.CHANNEL_MAP_KEY);
        String rebateIds = idsMap.get(ChannelMapKeyParam.REBATE_MAP_KEY);
        String extraRebateIds = idsMap
                .get(ChannelMapKeyParam.EXTRA_REBATE_MAP_KEY);

        records = getStrategyListByIds(strategyIds);
        if (records == null || records.isEmpty()) {
            return null;
        }

        // 获取全部渠道
        Map<Long, ChannelVo> channels = channelVoUtil
                .getRecordMapByIds(channelIds);
        if (channels == null || channels.isEmpty()) {
            return null;
        }

        // 获取全部产品
        if (productIds == null || productIds.isEmpty()) {
            return null;
        }
        List<Long> productIdList = new ArrayList<Long>();
        for (String productId : productIds.split(",")) {
            productIdList.add(Long.valueOf(productId));
        }
        Map<Long, CusProductPriceVO> productVoMap = getProductByIdList(productIdList);
        if (productVoMap == null || productVoMap.isEmpty()) {
            return null;
        }

        Map<Long, RebateStrategyVo> rebates = getRStrategyMapByIds(rebateIds);
        if (rebates == null || rebates.isEmpty()) {
            return null;
        }

        Map<Long, ExtraRebateStrategyVo> extraReabtes = getExtraRStrategyMapByIds(extraRebateIds);
        if (extraReabtes == null || extraReabtes.isEmpty()) {
            return null;
        }

        // 1.给返利对象添加加点返
        List<ExtraRebateStrategyVo> extraRebateList = new ArrayList<ExtraRebateStrategyVo>();
        for (Map.Entry<Long, ExtraRebateStrategyVo> entry : extraReabtes
                .entrySet()) {
            ExtraRebateStrategyVo extra = entry.getValue();
            Long frontRebateRuleId = extra.getFrontRebateRuleId();
            RebateStrategyVo front = rebates.get(frontRebateRuleId);
            if (front == null) {
                continue;
            }
            List<ExtraRebateStrategyVo> havExtraList = front
                    .getSysExtraRebateStrategyList();
            if (havExtraList == null) {
                havExtraList = new ArrayList<ExtraRebateStrategyVo>();
                front.setSysExtraRebateStrategyList(havExtraList);
            }
            havExtraList.add(extra);
            extraRebateList.add(extra);
        }
        // 1.给加点返对象添加前置产品对象
        setExtraRebateStrategyProductList(extraRebateList);

        for (Map.Entry<Long, RebateStrategyVo> entry : rebates.entrySet()) {
            RebateStrategyVo rebate = entry.getValue();
            List<ExtraRebateStrategyVo> havExtraList = rebate
                    .getSysExtraRebateStrategyList();
            if (havExtraList == null || havExtraList.isEmpty()) {
                entry.setValue(null);
            }
        }

        for (StrategyVo record : records) {
            List<Long> productList = new ArrayList<Long>();
            List<CusProductPriceVO> productVoList = new ArrayList<CusProductPriceVO>();
            List<ChannelVo> channelList = new ArrayList<ChannelVo>();
            List<RebateStrategyVo> rebateList = new ArrayList<RebateStrategyVo>();

            StringBuffer haveProduct = new StringBuffer();
            StringBuffer haveChannel = new StringBuffer();
            StringBuffer haveRebate = new StringBuffer();

            Long strategyId = record.getId();
            if (strategyId == null || strategyId < 1) {
                continue;
            }
            String strategyId_ = String.valueOf(strategyId);

            for (SysSpcreRelationKey key : relationList) {
                if (!strategyId_.equals(key.getStrategyId())) {
                    continue;
                }

                // 封装政策产品
                Long pid = Long.valueOf(key.getProductId());
                CusProductPriceVO pvo = productVoMap.get(pid);
                if (pvo == null || haveProduct.indexOf(pid + ",") > -1) {
                    continue;
                }
                productList.add(pid);
                productVoList.add(pvo);
                haveProduct.append(pid).append(",");

                // 封装渠道
                Long cid = Long.valueOf(key.getChannelId());
                ChannelVo cvo = channels.get(cid);
                if (cvo == null || haveChannel.indexOf(cid + ",") > -1) {
                    continue;
                }
                channelList.add(cvo);
                haveChannel.append(cid).append(",");

                // 封装返利
                Long rid = Long.valueOf(key.getRebateId());
                RebateStrategyVo rvo = rebates.get(rid);
                if (rvo == null || haveRebate.indexOf(rid + ",") > -1) {
                    continue;
                }
                rebateList.add(rvo);
            }
            if (channelList == null || channelList.isEmpty()) {
                continue;
            }
            if (productList == null || productList.isEmpty()) {
                continue;
            }
            if (rebateList == null || rebateList.isEmpty()) {
                continue;
            }

            record.setChannelList(channelList);
            record.setProductList(productList);
            record.setProductVoList(productVoList);
            record.setRebateStrategyList(rebateList);
        }
        return records;

    }

    private List<RebateStrategyVo> getRebateOfRelations(
            List<SysLabelRelationKey> relationList) throws Exception {
        List<RebateStrategyVo> voList;
        Map<String, String> idMaps = authorityUtil.getRelationIds(relationList);

        String refIds = idMaps.get(ChannelMapKeyParam.REF_MAP_KEY);

        voList = getRStrategyListByIds(refIds);
        return voList;
    }

    private Map<Long, RebateStrategyVo> buildupRebateToStrategy(
            List<StrategyVo> strategyList,
            List<SysLabelRelationKey> relationList,
            List<RebateStrategyVo> rebateList) {
        Map<Long, StrategyVo> strategyMap = new HashMap<>(strategyList.size());
        for (StrategyVo strategy : strategyList) {
            strategyMap.put(strategy.getId(), strategy);
        }

        Map<Long, RebateStrategyVo> rebateMap = new HashMap<>(rebateList.size());
        for (RebateStrategyVo rebate : rebateList) {
            rebateMap.put(rebate.getId(), rebate);
        }

        for (SysLabelRelationKey relation : relationList) {
            String strategyIdString = relation.getObjId();
            String rebateIdString = relation.getRelId();

            if (null == strategyIdString || null == rebateIdString)
                continue;

            Long strategyId = Long.valueOf(strategyIdString);
            Long rebateId = Long.valueOf(rebateIdString);

            StrategyVo strategy = strategyMap.get(strategyId);
            RebateStrategyVo rebate = rebateMap.get(rebateId);

            if (null == strategy || null == rebate)
                continue;

            List<RebateStrategyVo> rebateListOfStrategy = strategy
                    .getRebateStrategyList();
            if (null == rebateListOfStrategy) {
                rebateListOfStrategy = new ArrayList<>();
                strategy.setRebateStrategyList(rebateListOfStrategy);
            }

            rebateListOfStrategy.add(rebate);
        }

        return rebateMap;
    }

    private List<SysExtraRebateStrategy> getExtraRebateOfRebate(
            List<RebateStrategyVo> rebateList) {
        SysExtraRebateStrategy param = new SysExtraRebateStrategy();

        List<Long> ids = new ArrayList<>(rebateList.size());
        for (RebateStrategyVo rebate : rebateList) {
            Long id = rebate.getId();
            if (null != id)
                ids.add(id);
        }
        param.setFrontRebateRuleIds(ids);

        List<SysExtraRebateStrategy> result = iextraRebateStrategyService
                .findListByParams(param);

        return result;
    }

    private void buildupExtraRebate(List<RebateStrategyVo> rebateList,
            Map<Long, RebateStrategyVo> rebateMap) {
        if (CollectionUtils.isEmpty(rebateList))
            return;

        if (null == rebateMap)
            return;

        List<SysExtraRebateStrategy> extraRebateList = getExtraRebateOfRebate(rebateList);
        if (extraRebateList == null || extraRebateList.isEmpty()) {
            return;
        }

        for (SysExtraRebateStrategy extraRebate : extraRebateList) {
            Long rebateRuleId = extraRebate.getFrontRebateRuleId();

            RebateStrategyVo rebate = rebateMap.get(rebateRuleId);

            List<ExtraRebateStrategyVo> extraRebateListOfRebate = rebate
                    .getSysExtraRebateStrategyList();
            if (null == extraRebateListOfRebate) {
                extraRebateListOfRebate = new ArrayList<>();
                rebate.setSysExtraRebateStrategyList(extraRebateListOfRebate);
            }

            ExtraRebateStrategyVo extraRebateStrategyVo = ExtraRebateStrategyVo
                    .changeTAPIBean(extraRebate);
            extraRebateListOfRebate.add(extraRebateStrategyVo);
        }
    }

    /**
     * 过滤掉政策haveSaleType端口的政策
     */
    public void filterStrategyBySaleType(List<StrategyVo> list,
            List<KeyValueVo> haveSaleType) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (haveSaleType == null || haveSaleType.isEmpty()) {
            return;
        }
        Iterator<StrategyVo> it = list.iterator();
        while (it.hasNext()) {
            StrategyVo vo = it.next();
            List<KeyValueVo> voSaleType = vo.getSalesType();
            String strSaleType = KeyValueVo.getString(voSaleType);
            boolean isNotRemove = false;
            for (KeyValueVo keyValue : haveSaleType) {
                String saleType = KeyValueVo.getString(keyValue);
                if (strSaleType.indexOf(saleType) > -1) {
                    isNotRemove = true;
                    break;
                }
            }
            if (!isNotRemove)
                it.remove();
        }
    }
}
