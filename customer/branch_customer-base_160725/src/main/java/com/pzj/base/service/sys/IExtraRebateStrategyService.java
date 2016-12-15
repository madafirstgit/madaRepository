package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.entity.SysExtraRebateStrategy;
import com.pzj.base.entity.SysSpcreRelationKey;

/**
 * 加点返利规则管理（CRUD）
 *
 * @author LIANGNING
 */
public interface IExtraRebateStrategyService extends
		IBaseUserService<SysExtraRebateStrategy> {

	/**
	 * 创建加点返利规则
	 *
	 * @param extraRebateStrategy
	 */
	public void createExtraRebateStrategy(
			SysExtraRebateStrategy extraRebateStrategy);

	/**
	 * 更新加点返利规则
	 *
	 * @param extraRebateStrategy
	 */
	public void updateExtraRebateStrategy(
			SysExtraRebateStrategy extraRebateStrategy);

	/**
	 * 修改加点返利规则状态
	 *
	 * @param extraRebateStrategyId
	 * @param state
	 */
	public void updateExtraRebateStrategyState(Long extraRebateStrategyId,
											   Integer state);

	/**
	 * 根据返利规则获取加点返利规则列表
	 *
	 * @param rebateStrategyId
	 * @return
	 */
	public List<SysExtraRebateStrategy> querySysExtraRebateStrategyByrebateStrategyId(
			Long rebateStrategyId);

	/**
	 * 更新加点返利审核状态
	 *
	 * @param records
	 * @return
	 */
	public Integer updateRebateStatusByList(List<SysSpcreRelationKey> records);

}
