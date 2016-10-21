/*
 * ProductBedService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.channel.vo.resultParam.PCStrategyResult;

/**
 * @Description:service接口.$ENTITY_NOTE$
 * @author: 票之家
 */
public interface IStrategySearchService {
	/**
	 * 根据分销商，销售端口，团散获取产品对应的政策列表
	 * @param distributorId
	 * @param saleType
	 * @param ticketVarie
	 * @return
	 * @throws Exception
	 */
	Map<Long, List<PCStrategyResult>> querySkuStrategyByDistributorId(
			Long distributorId, String saleType, String ticketVarie) throws Exception;
	
	/**
	 * 根据分销商，销售端口，团散获取产品对应的政策列表
	 * @param distributorId
	 * @param saleType
	 * @param ticketVarie
	 * @return
	 * @throws Exception
	 */
	Map<Long, List<PCStrategyResult>> querySkuStrategyByDistributorId(
			Long distributorId, String saleType, String ticketVarie,List<Long> skuIds) throws Exception;
	
	/**
	 * 根据分销商id查询分销商关联的某个供应商的渠道id列表
	 * @param userId 分销商id
	 * @param supplierId  供应商id
	 * @return
	 */
	List<Long> queryChannelIdByUSid(Long userId,Long supplierId);
	
	/**
	 * 根据分销商id查询分销商关联的某个供应商的渠道列表
	 * @param userId 分销商id
	 * @param supplierId  供应商id
	 * @return
	 */
	List<SysChannel> queryValidChannelsByUSid(Long distributorId,Long supplierId);


	List<SysChannel> queryValidChannelsByUSid(Long distributorId, Long supplierId, List<Long> channelIds);

	/**
	 * 根据渠道id和销售端口集合查询渠道关联的有效政策列表
	 * @param channelIds 渠道id集合
	 * @return
	 */
	List<SysChannelStrategy> queryValidStrategysByCids(List<Long> channelIds, String saleType);
	
	
	/**
	 * 根据渠道id集合查询渠道关联的政策id列表
	 * @param channelIds 渠道id集合
	 * @return
	 */
	List<Long> queryStrategyIdByCids(List<Long> channelIds);
	
	
	/**
	 * 根据渠道id查询渠道关联的分销商id列表
	 * @param channelId 渠道id
	 * @return
	 */
	List<Long> queryUserIdByCid(Long channelId);
	

   /**
    * 根据关系表对象的相关信息查询对象列表
    * @param bParam 关系对象 
    * @return
    */
	List<SysLabelRelationKey> queryLabelRelationByParam(SysLabelRelationKey bParam);
	

	
	/**
	 * 根据渠道查询参数查询渠道集合
	 * @param bParam
	 * @return
	 */
   List<SysChannel> queryChannelByParam(SysChannel bParam);
   
   /**
    * 根据政策查询参数查询政策集合
    * @param bParam
    * @return
    */
   List<SysChannelStrategy> queryStratgyByParam(SysChannelStrategy bParam);
   
   
   /**
    * 查询产品渠道政策关系集合
    * @param bParam
    * @return
    */
   List<SysSpcreRelationKey> querySpcreByParam(SysSpcreRelationKey bParam);
   
   /**
    * 根据渠道id集合查询有效的渠道集合
    * @param channelIds
    * @return
    */
   List<SysChannel>  getValidChannelByIds(List<Long> channelIds);
   
   /**
    * 根据政策id集合查询有效的政策集合
    * @param strategyIds
    * @return
    */
   List<SysChannelStrategy> getValidStrategyByIds(List<Long> strategyIds) ;
   
   
   Map<Long, List<PCStrategyResult>> combinationProductCS(List<Long> productIds,List<SysChannel> channels,List<SysChannelStrategy> strategys)throws Exception;

   /**
    * 根据渠道id集合，产品id集合，销售端口获取当前日期有效的政策数据
    * @param channelIds
    * @param saleType
    * @param productIds
    * @return
    */
	List<SysChannelStrategy> queryValidStrategysByCids(List<Long> channelIds, String saleType, List<Long> productIds);

	/**
	 * 根据政策和关系查询政策
	 * @param channelStrategy
	 * @param sysSpcreRelationKey
     * @return
     */
	List<SysChannelStrategy> queryStratgyBySpace(SysChannelStrategy channelStrategy, SysSpcreRelationKey sysSpcreRelationKey);



	/**
	    * 根据渠道id集合，产品id集合，销售端口,团散获取当前日期有效的政策数据
	    * @param channelIds
	    * @param saleType
	    * @param productIds
	    * @return
	    */
	List<SysChannelStrategy> queryValidStrategysByCids(List<Long> channelIds, String saleType, List<Long> productIds, String ticketVarie);
}
