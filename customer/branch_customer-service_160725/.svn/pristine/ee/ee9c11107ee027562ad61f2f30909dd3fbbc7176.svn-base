package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.service.sys.IExtraRebateStrategyService;
import com.pzj.base.service.sys.ISpcreRelationService;
import com.pzj.dao.SysSpcreRelationMapper;

@Service("spcreRelationService")
public class SpcreRelationServiceImpl
		extends
		BaseRelationshipServiceImpl<SysSpcreRelationKey, SysSpcreRelationMapper>
		implements ISpcreRelationService {
	@Autowired
	private IExtraRebateStrategyService extraRebateStrategyService;
	
	
	public Map<String, String> getRelationIds(List<SysSpcreRelationKey> records) {
		if (records == null || records.isEmpty()) {
			return null;
		}

		StringBuffer strategyIds = new StringBuffer();
		StringBuffer productIds = new StringBuffer();
		StringBuffer channelIds = new StringBuffer();

		for (SysSpcreRelationKey record : records) {
			String strategyId = record.getStrategyId();
			String productId = record.getProductId();
			String channelId = record.getChannelId();

			if (StringUtils.isNotBlank(strategyId)
					&& strategyIds.indexOf(strategyId + ",") < 0) {
				strategyIds.append(strategyId).append(",");
			}
			if (StringUtils.isNotBlank(productId)
					&& productIds.indexOf(productId + ",") < 0) {
				productIds.append(productId).append(",");
			}
			if (StringUtils.isNotBlank(channelId)
					&& channelIds.indexOf(channelId + ",") < 0) {
				channelIds.append(channelId).append(",");
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotBlank(strategyIds)) {
			map.put(ChannelMapKeyParam.STRATEGY_MAP_KEY,
					strategyIds.substring(0, strategyIds.length() - 1));
		}
		if (StringUtils.isNotBlank(productIds)) {
			map.put(ChannelMapKeyParam.PRODUCT_MAP_KEY,
					productIds.substring(0, productIds.length() - 1));
		}
		if (StringUtils.isNotBlank(channelIds)) {
			map.put(ChannelMapKeyParam.CHANNEL_MAP_KEY,
					channelIds.substring(0, channelIds.length() - 1));
		}

		return map;
	}
	
	

	public Long delAuthBatch(List<SysSpcreRelationKey> records,
							 boolean syncOtherRelation) {
		Long num = 0l;
		try {
			if (records == null || records.isEmpty()) {
				logger.error("方法[SpcreRelationServiceImpl.delAuthBatch],参数records不可以为空");
				return num;
			}
			// 删除关系
			num += deleteBatchSelective(records);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	public Long insertAuthBatch(List<SysSpcreRelationKey> records,
								boolean syncOtherRelation) {
		Long num = 0l;
		String regx = ",";
		try {
			if (records == null || records.isEmpty()) {
				logger.error("方法[SpcreRelationServiceImpl.insertAuthBatch],参数records不可以为空");
				return num;
			}
			if (records != null && !records.isEmpty()) {
				num += insertBatch(records);
			}

		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return num;
	}

	@Override
	public String genMapKey(SysSpcreRelationKey record, String regx) {
		String key = "";
		if (StringUtils.isBlank(regx)) {
			regx = ",";
		}
		if (record == null) {
			return key;
		}
		String strategyId = record.getStrategyId();
		String productId = record.getProductId();
		String channelId = record.getChannelId();
	
		if (StringUtils.isBlank(strategyId)) {
			return key;
		}
		if (StringUtils.isBlank(productId)) {
			return key;
		}
		if (StringUtils.isBlank(channelId)) {
			return key;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(strategyId).append(regx).append(productId).append(regx).append(channelId);

		return sb.toString();
	}

	public PageList<SysSpcreRelationKey> findPageSpcreRelation(PageModel pager,
															   SysSpcreRelationKey entity) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pParam", pager);
		params.put("bParam", entity);
		List<SysSpcreRelationKey> listBean = mapper.findSpcreRelation(params);
		Integer count = mapper.findCouSpcreRelation(params);
		PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
		PageList<SysSpcreRelationKey> pagelist = null;
		pagelist = new PageList<SysSpcreRelationKey>(listBean, pageObj);
		return pagelist;
	}

	public Integer updateByChannelStrategy(List<SysSpcreRelationKey> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		List<SysSpcreRelationKey> updateList = new ArrayList<SysSpcreRelationKey>();
		for (SysSpcreRelationKey key : list) {
			if (StringUtils.isBlank(key.getStatus())) {
				continue;
			}
			updateList.add(key);
		}

		// 1.更新加点返对象给的状态
		extraRebateStrategyService.updateRebateStatusByList(updateList);

		// 2.更新加点返关联表的状态
		return mapper.updateByChannelStrategy(updateList);
	}

	@Override
	public List<SysSpcreRelationKey> findSpcreRelationsByStrategyIds(
			List<Long> strategyIds) {
		if(CollectionUtils.isEmpty(strategyIds)){
			return null;
		}
		SysSpcreRelationKey query = new SysSpcreRelationKey();
		query.setQueryStrategyIds(strategyIds);
		
		List<SysSpcreRelationKey> relations = this.findListByParams(query);
		
		//过滤重复数据
	    filterRepeatData(relations);
		
		return relations;
	}
	

	@Override
	public SysSpcreRelationKey findSpcreRelationsByStrategyId(
			Long strategyId) {
		if(strategyId == null){
			return null;
		}
		List<Long> strategyIds = new ArrayList<Long>();
		strategyIds.add(strategyId);
		List<SysSpcreRelationKey> results = findSpcreRelationsByStrategyIds(strategyIds);
		if(CollectionUtils.isNotEmpty(results)){
			return results.get(0);
		}
		return null;
	}
	
	
	public void filterRepeatData(List<SysSpcreRelationKey> relations){
		if(CollectionUtils.isEmpty(relations)){
			return ;
		}
		Set<String> keys = new HashSet<String>();
		Iterator<SysSpcreRelationKey> it = relations.iterator();
		
		while(it.hasNext()){
			SysSpcreRelationKey relation = it.next();
			String key = genMapKey(relation,"#");
            if(keys.contains(key)){
            	it.remove();
			}else{
				keys.add(key);
			}		
		}
	}

	public List<SysSpcreRelationKey> findSpcreRelationsByChannelIds(
			List<Long> channelIds) {
		if(CollectionUtils.isEmpty(channelIds)){
			return null;
		}
		SysSpcreRelationKey query = new SysSpcreRelationKey();
		query.setQueryChannelIds(channelIds);
		
		List<SysSpcreRelationKey> relations = this.findListByParams(query);
		
		//过滤重复数据
	    filterRepeatData(relations);
		
		return relations;
	}

	@Override
	public List<SysSpcreRelationKey> findSpcreRelationsByChannelId(
			Long channelId) {
		if(channelId == null){
			return null;
		}
		List<Long> channelIds = new ArrayList<Long>();
		channelIds.add(channelId);
		return findSpcreRelationsByChannelIds(channelIds);
	}

	public List<SysSpcreRelationKey> findSpcreRelationsByProductIds(
			List<Long> productIds) {
		if(CollectionUtils.isEmpty(productIds)){
			return null;
		}
		SysSpcreRelationKey query = new SysSpcreRelationKey();
		query.setQueryProductIds(productIds);
		
		List<SysSpcreRelationKey> relations = this.findListByParams(query);
		
		//过滤重复数据
	    filterRepeatData(relations);
		
		return relations;
	}

	@Override
	public List<SysSpcreRelationKey> findSpcreRelationsByProductId(
			Long productId) {
		if(productId == null){
			return null;
		}
		List<Long> productIds = new ArrayList<Long>();
		productIds.add(productId);
		return findSpcreRelationsByProductIds(productIds);
	}


}
