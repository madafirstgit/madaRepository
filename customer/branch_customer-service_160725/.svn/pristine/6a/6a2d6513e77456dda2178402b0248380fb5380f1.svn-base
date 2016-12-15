package com.pzj.dao;

import java.util.List;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysExtraRebateStrategy;
import com.pzj.base.entity.SysSpcreRelationKey;

@MyBatisDao
public interface SysExtraRebateStrategyMapper extends
        BaseUserMapper<SysExtraRebateStrategy> {

    List<SysExtraRebateStrategy> querySysExtraRebateStrategyListByRebateStrategyId(
            Long rebateStrategyId);

    Integer updateRebateStatusByChannelStrategy(
            List<SysSpcreRelationKey> records);
}