package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysSpcreRelationKey;

public interface ISpcreRelationService extends
		IBaseRelationshipService<SysSpcreRelationKey> {

	public PageList<SysSpcreRelationKey> findPageSpcreRelation(PageModel pager,
			SysSpcreRelationKey entity);

	public Integer updateByChannelStrategy(List<SysSpcreRelationKey> list);
	
	/**
	 * 根据政策id集合获取政策产品渠道关系
	 * @param strategyIds
	 * @return
	 */
	public List<SysSpcreRelationKey> findSpcreRelationsByStrategyIds(List<Long> strategyIds);
	
	/**
	 * 根据渠道id集合获取政策产品渠道关系
	 * @param strategyIds
	 * @return
	 */
	public List<SysSpcreRelationKey> findSpcreRelationsByChannelIds(List<Long> channelIds);
	
	
	/**
	 * 根据政策id集合获取政策产品渠道关系
	 * @param strategyIds
	 * @return
	 */
	public List<SysSpcreRelationKey> findSpcreRelationsByProductIds(List<Long> productIds);
	
	
	/**
	 * 根据政策id获取政策产品渠道关系
	 * @param strategyIds
	 * @return
	 */
	public SysSpcreRelationKey findSpcreRelationsByStrategyId(Long strategyId);
	
	
	/**
	 * 根据渠道id获取政策产品渠道关系
	 * @param strategyIds
	 * @return
	 */
	public List<SysSpcreRelationKey> findSpcreRelationsByChannelId(Long channelId);
	
	
	/**
	 * 根据产品id获取政策产品渠道关系
	 * @param strategyIds
	 * @return
	 */
	public List<SysSpcreRelationKey> findSpcreRelationsByProductId(Long productId);
	
	
	/**
	 * 过滤重复数据
	 * @param relations
	 */
	public void filterRepeatData(List<SysSpcreRelationKey> relations);
	
}
