package com.pzj.service.Impl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.channel.Channel;
import com.pzj.channel.Strategy;
import com.pzj.channel.vo.queryParam.StrategyJudgeParam;
import com.pzj.service.Impl.model.ChannelTree;
import com.pzj.service.Impl.model.SysSpcreRelationIDKey;

public class StrategyConvertUtil {
	
	public static Strategy convertTStrategy(SysChannelStrategy bean){
		Strategy result = new Strategy();
		CommonConvert.copyProperties(result, bean);		
		return result;
	}
	
	public static void convertTStrategyList(List<Strategy> result,List<SysChannelStrategy> beans){
		if(CollectionUtils.isEmpty(beans)){
			return;
		}
		for(SysChannelStrategy bean : beans){
			result.add(convertTStrategy(bean));
		}
	}
	
	
	public static Channel convertTChannel(SysChannel bean){
		Channel result = new Channel();
		CommonConvert.copyProperties(result, bean);		
		return result;
	}
	
	public static void convertTChannelList(List<Channel> result,List<SysChannel> beans){
		if(CollectionUtils.isEmpty(beans)){
			return;
		}
		for(SysChannel bean : beans){
			result.add(convertTChannel(bean));
		}
	}
	
	public static Map<String,ChannelTree> convertTChannelTreeMap(List<ChannelTree> list){
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		Map<String,ChannelTree> result = new HashMap<String,ChannelTree>();
		for(ChannelTree tree : list){
			if(tree.isValidData()){
				result.put(tree.getChannelId().toString(), tree);
			}
		}
		return result;
		
	}
	
	
	public static SysSpcreRelationIDKey getRelationIdList(List<SysSpcreRelationKey> records){
		if (CollectionUtils.isEmpty(records)) {
			return null;
		}

	    Set<Long> strategyIds = new HashSet<Long>();
	    Set<Long> productIds = new HashSet<Long>();
	    Set<Long> channelIds = new HashSet<Long>();
	    SysSpcreRelationIDKey result = new SysSpcreRelationIDKey();
			
		for (SysSpcreRelationKey record : records) {
			strategyIds.add(record.getLongFStrategyId());
			productIds.add(record.getLongFProductId());
			channelIds.add(record.getLongFChannelId());
		}
		
		result.setChannelIds(new ArrayList<Long>(channelIds));
		result.setProductIds(new ArrayList<Long>(productIds));
		result.setStrategyIds(new ArrayList<Long>(strategyIds));
		

		return result;
		
	}
	
	public static Map<String, List<Long>> getObjMap(List<SysLabelRelationKey> keys){
		if(CollectionUtils.isEmpty(keys)){
			return null;
		}
		Map<String, List<Long>> objMap = new HashMap<String,List<Long>>();
		for(SysLabelRelationKey key : keys){
			String objId = key.getObjId();
			String relId = key.getRelId();
			if(StringUtils.isBlank(objId) || StringUtils.isBlank(relId)){
				continue;
			}
			List<Long> relIds = objMap.get(objId);
			if(relIds == null){
				relIds = new ArrayList<Long>();
				objMap.put(objId, relIds);
			}
			relIds.add(Long.valueOf(relId));
			
		}
		
		return objMap;
	}
	
	public static Map<String, List<Long>> getRelMap(List<SysLabelRelationKey> keys){
		if(CollectionUtils.isEmpty(keys)){
			return null;
		}
		Map<String, List<Long>> relMap = new HashMap<String,List<Long>>();
		for(SysLabelRelationKey key : keys){
			String objId = key.getObjId();
			String relId = key.getRelId();
			if(StringUtils.isBlank(objId) || StringUtils.isBlank(relId)){
				continue;
			}
			List<Long> objIds = relMap.get(relId);
			if(objIds == null){
				objIds = new ArrayList<Long>();
				relMap.put(objId, objIds);
			}
			objIds.add(Long.valueOf(objId));
			
		}
		
		return relMap;
	}
	
	public static List<Long> getProductIds(List<StrategyJudgeParam> judgeParams){
		Set<Long> result = new HashSet<Long>();
		
		for(StrategyJudgeParam judgeParam : judgeParams){
		    result.add(judgeParam.getProductId());
		}
		
		return new ArrayList<Long>(result);
	}
	
	public static List<Long> getChannelIds(List<StrategyJudgeParam> judgeParams){
		Set<Long> result = new HashSet<Long>();

		if (CollectionUtils.isEmpty(judgeParams)) {
			for (StrategyJudgeParam judgeParam : judgeParams) {
				if (CollectionUtils.isEmpty(judgeParam.getChannelIds())) {
					continue;
				}
				result.addAll(judgeParam.getChannelIds());
			}
		}
		
		return new ArrayList<Long>(result);
	}


}
