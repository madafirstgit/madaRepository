package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.product.IStrategySearchMapper;
import com.pzj.base.service.exception.SkuSearchException;
import com.pzj.base.service.product.IStrategySearchService;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.StrategyConvert;

@Service
public class StrategySearchServiceImpl implements IStrategySearchService{
	private Logger logger = LoggerFactory.getLogger(StrategySearchServiceImpl.class);

	@Autowired
	IStrategySearchMapper mapper;

	@Override
	public List<SysChannel> queryChannelByParam(SysChannel bParam) {

		return mapper.selectChannelByParam(bParam);
	}

	@Override
	public List<SysChannelStrategy> queryStratgyByParam(
			SysChannelStrategy bParam) {


		return mapper.selectStratgyByParam(bParam);
	}
	@Override
	public List<SysLabelRelationKey> queryLabelRelationByParam(
			SysLabelRelationKey bParam) {

		return mapper.selectLabelRelationByParam(bParam);
	}

	public List<Long> queryStrategyIdByUSid(Long userId, Long supplierId, List<Long> channelIds) {
		logger.debug("IStrategySearchService.queryChannelIdByUSid的入参:userId = {},supplierId = {}",userId,supplierId);
		if(userId == null){
			return null;
		}
		SysLabelRelationKey key = new SysLabelRelationKey();
		key.setRelId(String.valueOf(userId));
		key.setQueryObjIds(channelIds);
		key.setsId(supplierId);
		key.setRelType(UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
		List<SysLabelRelationKey> keyList =  queryLabelRelationByParam(key);
		List<Long> result = StrategyConvert.getObjIdList(keyList);
		logger.debug("IStrategySearchService.queryChannelIdByUSid的出参:{}",result);
		return result;

	}

	@Override
	public List<Long> queryChannelIdByUSid(Long userId, Long supplierId) {
		return queryChannelIdByUSid(userId, supplierId, null);
	}

	public List<Long> queryChannelIdByUSid(Long userId, Long supplierId, List<Long> channelIds) {
		logger.debug("IStrategySearchService.queryChannelIdByUSid的入参:userId = {},supplierId = {}",userId,supplierId);
		SysLabelRelationKey key = new SysLabelRelationKey();
		key.setRelId(String.valueOf(userId));
		key.setQueryObjIds(channelIds);
		key.setsId(supplierId);
		key.setRelType(UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
		List<SysLabelRelationKey> keyList =  queryLabelRelationByParam(key);
		List<Long> result = StrategyConvert.getObjIdList(keyList);
		logger.debug("IStrategySearchService.queryChannelIdByUSid的出参:{}",result);
		return result;
	}

	@Override
	public List<Long> queryUserIdByCid(Long channelId) {
		logger.debug("IStrategySearchService.queryUserIdByCSid的入参:channelId = {}",channelId);
		SysLabelRelationKey key = new SysLabelRelationKey();
		key.setObjId(String.valueOf(channelId));
		key.setRelType(UserGlobalParam.ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
		List<SysLabelRelationKey> keyList =  queryLabelRelationByParam(key);
		List<Long> result = StrategyConvert.getRelIdList(keyList);
		logger.debug("IStrategySearchService.queryUserIdByCSid的出参:{}",result);
		return result;
	}

	@Override
	public List<Long> queryStrategyIdByCids(List<Long> channelIds) {
		logger.debug("IStrategySearchService.queryStrategyIdByCids的渠道id集合入参:channelIds = {}",channelIds);
		List<Long> queryrelIds = StrategyConvert.lListTSList(channelIds);
		SysLabelRelationKey key = new SysLabelRelationKey();
		key.setQueryRelIds(queryrelIds);
		key.setRelType(UserGlobalParam.ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
		List<SysLabelRelationKey> keyList =  queryLabelRelationByParam(key);
		List<Long> result = StrategyConvert.getObjIdList(keyList);
		return result;
	}

	public List<SysChannel>  getValidChannelByIds(List<Long> channelIds){
		if(CollectionUtils.isEmpty(channelIds)){
			return null;
		}
		logger.debug("IStrategySearchService.getValidChannelByIds的渠道id集合入参:channelIds = {}",channelIds);
		SysChannel channelQuery = new SysChannel();
		channelQuery.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
		channelQuery.setQueryIds(channelIds);
		List<SysChannel> channels = queryChannelByParam(channelQuery);
		return channels;
	}

	@Override
	public List<SysChannelStrategy> getValidStrategyByIds(List<Long> strategyIds) {
		return getValidStrategyByIds(strategyIds, null);
	}

	private List<SysChannelStrategy> getValidStrategyByIds(List<Long> strategyIds, List<Long> productIds) {
//		logger.info("IStrategySearchService.getValidStrategyByIds的政策id集合入参:strategyIds = {}",strategyIds);
		SysChannelStrategy strategyQuery = new SysChannelStrategy();
		strategyQuery.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
		strategyQuery.setIds(strategyIds);
		strategyQuery.setProductIds(productIds);
		List<SysChannelStrategy> strategys = queryStratgyByParam(strategyQuery);
		return strategys;
	}

	public List<SysChannel> queryValidChannelsByUSid(Long distributorId,Long supplierId){
		return queryValidChannelsByUSid(distributorId, supplierId, null);
	}

	@Override
	public List<SysChannel> queryValidChannelsByUSid(Long distributorId, Long supplierId, List<Long> channelIds){
		//1.查询分销商对应的渠道id列表
		List<Long> channelIdList = queryChannelIdByUSid(distributorId, null, channelIds);

		return getValidChannelByIds(channelIdList);
	}

	public List<SysChannelStrategy> queryValidStrategysByCids(List<Long> channelIds, String saleType){
		return queryValidStrategysByCids(channelIds, saleType, null);
	}

	@Override
	public List<SysChannelStrategy> queryValidStrategysByCids(List<Long> channelIds, String saleType, List<Long> productIds){

		return queryValidStrategysByCids(channelIds,saleType,productIds, null);
	}


	public List<SysChannelStrategy> queryValidStrategysByCids(List<Long> channelIds, String saleType, List<Long> productIds, String ticketVarie){

		//1.查询渠道对应的政策id列表
		List<SysSpcreRelationKey> relations = querySpcreByParam(productIds,channelIds, null);
		List<Long> strategyIds = StrategyConvert.getStrategyIdsList(relations);
		if(CollectionUtils.isEmpty(strategyIds)){
			throw new SkuSearchException("根据渠道id集合{"+channelIds+"}和产品id集合{"+productIds+"}获取不到关联的政策数据");
		}

		//2.查询有效的政策

		List<SysChannelStrategy> strategys = new ArrayList<SysChannelStrategy>();
		List<List<Long>> allIds = CommonConvert.splitIdList(strategyIds,100);
		int i = 0;
		for(List<Long> ids : allIds){
			List<SysChannelStrategy> subStrategys = getValidStrategyByIds(ids, null);
			if(CollectionUtils.isEmpty(subStrategys)){
				continue;
			}
			strategys.addAll(subStrategys);
			
			
		}
		if(strategys == null){
			throw new SkuSearchException("根据政策id集合{"+strategyIds+"}获取不到有效的政策数据");
		}

		//过滤政策数据
		filterStrategy(strategys,UserGlobalDict.StrategyGlobalDict.publishStatusPassed(),UserGlobalDict.StrategyGlobalDict.strategyStatusEnbaled(),saleType, null,ticketVarie);
		if(strategys == null || strategys.isEmpty()){
			throw new SkuSearchException("政策数据{"+strategys+"},根据发布状态，销售端口，团散过滤没有获取到有效的政策数据");
		}

		return strategys;
	}

	/**
	 * 根据销售端口，适用范围，启用状态，发布状态等过滤政策数据
	 * @param strategys
	 * @param salesType
	 * @param date
	 */
	private void filterStrategy(List<SysChannelStrategy> strategys, Integer publishStatus, Integer status,String salesType, Date date,String ticketVarie){
		if(strategys == null)return;

		Calendar dr = Calendar.getInstance();
		if(date != null)
			dr.setTime(date);
		Integer weekNo = dr.get(Calendar.DAY_OF_WEEK)-1;
		if(weekNo == 0) weekNo = 7;
		Iterator<SysChannelStrategy> it = strategys.iterator();
		while(it.hasNext()){
			SysChannelStrategy bean = it.next();

			// 检查启用状态、发布状态、销售端口、适用范围
			if(checkSatatus(status, bean)
					|| checkAuditStatus(publishStatus, bean)
					// || checkPublishStatus(publishStatus, bean)
					|| checkSalesType(salesType, bean)
					|| checkScope(String.valueOf(weekNo),bean) || checkTicketVarie(ticketVarie,bean) ){
				it.remove();
			}


		}

	}



	/**
	 * 检查政策团散
	 * @param status
	 * @param bean
	 * @return
	 */
	private boolean checkTicketVarie(String ticketVarie,SysChannelStrategy bean){
		return ticketVarie != null && (!ticketVarie.equals(bean.getTicketVarie()));
	}


	/**
	 * 检查启用状态
	 * @param status
	 * @param bean
	 * @return
	 */
	private boolean checkSatatus(Integer status,SysChannelStrategy bean){
		return status != null && (!status.equals(bean.getStatus()));
	}

	/**
	 * 检查审核状态
	 * @param auditStatus
	 * @param bean
	 * @return
	 */
	private boolean checkAuditStatus(Integer auditStatus, SysChannelStrategy bean){
		return auditStatus != null && (!auditStatus.equals(bean.getAuditStatus()));
	}

	/**
	 * 检查发布状态
	 * @param publishStatus
	 * @param bean
	 * @return
	 */
	private boolean checkPublishStatus(Integer publishStatus, SysChannelStrategy bean){
		return publishStatus != null && (!publishStatus.equals(bean.getPublishStatus()));
	}

	/**
	 * 检查销售端口
	 * @param salesType
	 * @param bean
	 * @return
	 */
	private boolean checkSalesType(String salesType, SysChannelStrategy bean){
		return StringUtils.isNotBlank(salesType) && StringUtils.isNotBlank(bean.getSalesType()) && (bean.getSalesType().indexOf(salesType) < 0);
	}

	/**
	 * 检查适用范围
	 * @param weekNo
	 * @param bean
	 * @return
	 */
	private boolean checkScope(String weekNo, SysChannelStrategy bean){
		return StringUtils.isNotBlank(bean.getScope()) && (bean.getScope().indexOf(String.valueOf(weekNo)) < 0);
	}

	@Override
	public List<SysSpcreRelationKey> querySpcreByParam(
			SysSpcreRelationKey bParam) {
		// TODO Auto-generated method stub
		return mapper.selectSpcreByParam(bParam);
	}

	public List<SysSpcreRelationKey> querySpcreByParam(
			List<Long> productIds,List<Long> channelIds, List<Long> strategyIds) {

		SysSpcreRelationKey bParam = new SysSpcreRelationKey();

		//添加产品查询参数
		bParam.setQueryProductIds(productIds);

		bParam.setQueryChannelIds(channelIds);

		bParam.setQueryStrategyIds(strategyIds);

		return querySpcreByParam(bParam);
	}

	@Override
	public Map<Long, List<PCStrategyResult>> combinationProductCS(
			List<Long> productIds, List<SysChannel> channels,
			List<SysChannelStrategy> strategys) throws Exception {
		//获取产品渠道政策三者的关系
		List<SysSpcreRelationKey> queryList = querySpcreByParam(productIds,CommonConvert.getIdList(channels),CommonConvert.getIdList(strategys));

		//组合成产品Id+渠道Id的map对象

		return StrategyConvert.combinationProductCS(queryList,productIds,channels,strategys);
	}


	@Override
	public List<SysChannelStrategy> queryStratgyBySpace(SysChannelStrategy channelStrategy, SysSpcreRelationKey sysSpcreRelationKey){
		if (channelStrategy == null && sysSpcreRelationKey == null)
			return null;
		List<SysChannelStrategy> channelStrategyList = mapper.selectStratgyBySpace(channelStrategy, sysSpcreRelationKey);
		return channelStrategyList;
	}

	@Override
	public Map<Long, List<PCStrategyResult>> querySkuStrategyByDistributorId(
			Long distributorId, String saleType, String ticketVarie,List<Long> skuIds)
			throws Exception {
		if (distributorId == null) {
			return null;
		}
		// 1.根据分销商id查询有效的渠道
		List<SysChannel> channels = queryValidChannelsByUSid(distributorId, null);
		if (channels == null) {
			logger.error("分销商:{}没有关联有效的渠道数据",distributorId);
		    return null;
		}

		// 2.查询渠道id对应的有效政策列表
		List<Long> channelIds = CommonConvert.getIdList(channels);
		List<SysChannelStrategy> strategys = queryValidStrategysByCids(channelIds,
				saleType,skuIds,ticketVarie);
		if (strategys == null) {
			logger.error("渠道id:{}没有关联有效的政策数据",channelIds);
			return null;
		}

		// 3.获取产品id集合
		List<Long> productIds = StrategyConvert
				.getProductIdsByStategys(strategys);
		if (CollectionUtils.isEmpty(productIds)) {
			logger.error("政策id:{}没有关联有效的产品数据",CommonConvert.getIdList(strategys));
			return null;
		}

		// 4.组合产品渠道政策的结果

		return combinationProductCS(productIds,
				channels, strategys);
	}
	
	@Override
	public Map<Long, List<PCStrategyResult>> querySkuStrategyByDistributorId(
			Long distributorId, String saleType, String ticketVarie)
			throws Exception {
		if (distributorId == null) {
			return null;
		}
		// 1.根据分销商id查询有效的渠道
		List<SysChannel> channels = queryValidChannelsByUSid(distributorId, null);
		if (channels == null) {
			throw new SkuSearchException("分销商{" + distributorId
					+ "}没有关联有效的渠道数据");
		}

		// 2.查询渠道id对应的有效政策列表

		List<SysChannelStrategy> strategys = queryValidStrategysByCids(CommonConvert.getIdList(channels),
				saleType,null,ticketVarie);
		if (strategys == null) {
			throw new SkuSearchException("渠道{" + channels + "}没有关联有效的政策数据");
		}

		// 3.获取产品id集合
		List<Long> productIds1 = StrategyConvert
				.getProductIdsByStategys(strategys);
		if (strategys == null) {
			throw new SkuSearchException("政策{" + strategys + "}没有关联有效的产品");
		}

		// 4.组合产品渠道政策的结果

		return combinationProductCS(productIds1,
				channels, strategys);
	}

}
