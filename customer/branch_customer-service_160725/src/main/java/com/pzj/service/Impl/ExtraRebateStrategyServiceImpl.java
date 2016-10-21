package com.pzj.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysExtraRebateStrategy;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.service.sys.IExtraRebateStrategyService;
import com.pzj.dao.SysExtraRebateStrategyMapper;

@Service("extraRebateStrategyService")
public class ExtraRebateStrategyServiceImpl
		extends
		BaseUserServiceImpl<SysExtraRebateStrategy, SysExtraRebateStrategyMapper>
		implements IExtraRebateStrategyService {

	@Override
	public void createExtraRebateStrategy(
			SysExtraRebateStrategy extraRebateStrategy) {

		this.mapper.insert(extraRebateStrategy);

	}

	@Override
	public void updateExtraRebateStrategy(
			SysExtraRebateStrategy extraRebateStrategy) {
		this.mapper.updateByPrimaryKey(extraRebateStrategy);
	}

	@Override
	public void updateExtraRebateStrategyState(Long extraRebateStrategyId,
											   Integer state) {
		SysExtraRebateStrategy extraRebateStrategy = this.mapper
				.selectByPrimaryKey(extraRebateStrategyId);
		extraRebateStrategy.setDelFlag(state);

		this.mapper.updateByPrimaryKey(extraRebateStrategy);
	}

	@Override
	public List<SysExtraRebateStrategy> querySysExtraRebateStrategyByrebateStrategyId(
			Long rebateStrategyId) {

		return this.mapper
				.querySysExtraRebateStrategyListByRebateStrategyId(rebateStrategyId);
	}

	@Override
	public Integer updateRebateStatusByList(List<SysSpcreRelationKey> records) {

		return mapper.updateRebateStatusByChannelStrategy(records);
	}

}
