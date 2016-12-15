package com.pzj.dao;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysRebateStrategy;

@MyBatisDao
public interface SysRebateStrategyMapper extends BaseUserMapper<SysRebateStrategy> {

    /**
     * 根据DictValue值和新生成的微店返利政策更新微店返利政策
     * @param SysRebateStrategy
     * @param dictvalue值
     * @return
     */
    int updateRebateByDictValue(@Param("rebate") SysRebateStrategy strategy, @Param("bParam") String DictValue);

}