package com.pzj.util.productConvertUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.service.exception.SkuParamConvertException;
import com.pzj.channel.Channel;
import com.pzj.channel.RebateStrategy;
import com.pzj.channel.Strategy;
import com.pzj.channel.vo.resultParam.PCStrategyResult;

public class StrategyConvert {

    private static Logger logger = LoggerFactory.getLogger(ProductConvert.class);
    
    
    public static List<Long> getStrategyIdsList(List<SysSpcreRelationKey> records){
		if (CollectionUtils.isEmpty(records)) {
			return null;
		}

	    Set<Long> strategyIds = new HashSet<Long>();	   
			
		for (SysSpcreRelationKey record : records) {
			strategyIds.add(record.getLongFStrategyId());	
		}
		
		

		return new ArrayList<Long>(strategyIds);
		
	}

    public static List<Long> getObjIdList(List<SysLabelRelationKey> keyList) {
        if (keyList == null)
            return null;
        Set<Long> set = new HashSet<Long>();
        for (SysLabelRelationKey key : keyList) {
            if (key.getObjId() == null) {
                continue;
            }
            set.add(Long.valueOf(key.getObjId()));
        }
        return new ArrayList<Long>(set);
    }

    public static List<Long> getRelIdList(List<SysLabelRelationKey> keyList) {
        if (keyList == null)
            return null;
        Set<Long> set = new HashSet<Long>();
        for (SysLabelRelationKey key : keyList) {
            if (key.getRelId() == null) {
                continue;
            }
            set.add(Long.valueOf(key.getRelId()));
        }
        return new ArrayList<Long>(set);
    }

    public static List<Long> lListTSList(List<Long> ids) {
        if (ids == null)
            return null;
        Set<Long> set = new HashSet<Long>();
        for (Long id : ids) {
            set.add(id);
        }
        return new ArrayList<Long>(set);
    }

    public static List<Long> getProductIdsByStategys(List<SysChannelStrategy> strategys) {
        if (strategys == null) {
            return null;
        }
        Set<Long> set = new HashSet<Long>();
        for (SysChannelStrategy bean : strategys) {
            if (bean.getProductId() != null)
                set.add(bean.getProductId());
        }
        return new ArrayList<Long>(set);
    }

    public static Strategy convertTStrategy(SysChannelStrategy vo) {
        if (vo == null)
            return null;
        Strategy result = new Strategy();
        try {
        	CommonConvert.copyProperties(result, vo);
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
            throw new SkuParamConvertException("政策实体转换出错",throwable);
        }
        return result;
    }

    public static RebateStrategy convertTRebate(SysRebateStrategy vo) {
        if (vo == null)
            return null;
        RebateStrategy result = new RebateStrategy();
        CommonConvert.copyProperties(result, vo);
        return result;
    }

    public static SysChannelStrategy convertTSysStrategy(Strategy vo) throws Exception {
        if (vo == null)
            return null;
        SysChannelStrategy result = new SysChannelStrategy();
        CommonConvert.copyProperties(result, vo);
        return result;
    }

    public static Channel convertTChannel(SysChannel vo) throws RuntimeException {
        if (vo == null)
            return null;
        Channel result = new Channel();
        CommonConvert.copyProperties(result, vo);
        return result;
    }

    public static SysChannel convertTSysChannel(Channel vo) throws Exception {
        if (vo == null)
            return null;
        SysChannel result = new SysChannel();
        CommonConvert.copyProperties(result, vo);
        return result;
    }
    
    public static Map<String, List<SysSpcreRelationKey>> getSpcreMapFProduct(List<SysSpcreRelationKey> spcreList){
    	Map<String, List<SysSpcreRelationKey>> result = new HashMap<String, List<SysSpcreRelationKey>>();
    	if(CollectionUtils.isEmpty(spcreList)){
    		return result;
    	}
    	for(SysSpcreRelationKey key : spcreList){
    		if(key.getProductId() == null) continue;
    		List<SysSpcreRelationKey> relation = result.get(key.getProductId());
    		if(relation == null){
    			relation = new ArrayList<SysSpcreRelationKey>();
    			result.put(key.getProductId(), relation);
    		}
    		relation.add(key);
    	}
    	return result;
    }
    

    public static Map<Long, List<PCStrategyResult>> combinationProductCS(List<SysSpcreRelationKey> spcreList,
                                                                         List<Long> productIds,
                                                                         List<SysChannel> channels,
                                                                         List<SysChannelStrategy> strategys) throws RuntimeException {
        if (productIds == null) {
            return null;
        }
        Map<Long, List<PCStrategyResult>> result = new HashMap<Long, List<PCStrategyResult>>();
        for (Long productId : productIds) {
            if (productId == null)
                continue;
            result.put(productId, null);
        }

        if (CollectionUtils.isNotEmpty(spcreList)) {
            Map<Long, SysChannel> channelMap = CommonConvert.convertListTMap(channels);
            Map<Long, SysChannelStrategy> strategyMap = CommonConvert.convertListTMap(strategys);
            Map<String, PCStrategyResult> map = new HashMap<String, PCStrategyResult>();
            for (SysSpcreRelationKey relation : spcreList) {
                Long productId = Long.valueOf(relation.getProductId());
                Long channelId = Long.valueOf(relation.getChannelId());
                Long strategyId = Long.valueOf(relation.getStrategyId());
                List<PCStrategyResult> pcsList = result.get(productId);
                if (pcsList == null) {
                    pcsList = new ArrayList<PCStrategyResult>();
                    result.put(productId, pcsList);
                }
                SysChannel channel = channelMap.get(channelId);
                SysChannelStrategy strategy = strategyMap.get(strategyId);

                if (strategy == null){
                    continue;
                }

                String key = productId + "#" + channelId;
                PCStrategyResult pcs = map.get(key);
                if (pcs == null) {
                    pcs = new PCStrategyResult();
                    pcsList.add(pcs);
                    map.put(key, pcs);
                }
                pcs.setProductId(productId);
                pcs.setChannel(convertTChannel(channel));
                List<Strategy> strategyList = pcs.getStrategyList();
                if (strategyList == null) {
                    strategyList = new ArrayList<Strategy>();
                    pcs.setStrategyList(strategyList);
                }
                strategyList.add(StrategyConvert.convertTStrategy(strategy));

            }
        }
        return result;

    }

}
