package com.pzj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysChannelStrategy;

@MyBatisDao
public interface SysChannelStrategyMapper extends BaseUserMapper<SysChannelStrategy> {

    List<SysChannelStrategy> findListByAllParam(Map<String, Object> params);

    int countListByAllParam(Map<String, Object> params);

    List<SysChannelStrategy> findListByObjID(Map<String, Object> params);

    int countByObjID(Map<String, Object> params);

    List<SysChannelStrategy> findListByRefID(Map<String, Object> params);

    int countByRefID(Map<String, Object> params);

    List<SysChannelStrategy> findListByChannelIDAndProductID(Map<String, Object> params);

    int countByChannelIDAndProductID(Map<String, Object> params);

    List<SysChannelStrategy> findListByProductID(Map<String, Object> params);

    int countByProductID(Map<String, Object> params);

    List<SysChannelStrategy> findDirectStrategyVoByScenic(Map<String, Object> params);

    int countDirectStrategyVoByScenic(Map<String, Object> params);

    List<SysChannelStrategy> findDirectStrategyVoByProductIds(Map<String, Object> params);

    List<SysChannelStrategy> findCustomerDirectStrategyVoByScenic(Map<String, Object> params);

    int countCustomerDirectStrategyVoByScenic(Map<String, Object> params);

    List<SysChannelStrategy> findCustomerDistributionStrategyVoByScenic(Map<String, Object> params);

    int countCustomerDistributionStrategyVoByScenic(Map<String, Object> params);

    List<SysChannelStrategy> findCustomerDirectStrategyVoByProductIds(Map<String, Object> params);

    List<SysChannelStrategy> findCustomerDistributionStrategyVoByProductIds(Map<String, Object> params);

    List<SysChannelStrategy> findComposeDirectStrategyVoByScenic(Map<String, Object> params);

    int countComposeDirectStrategyVoByScenic(Map<String, Object> params);

    List<SysChannelStrategy> findComposeDistributionStrategyVoByScenic(Map<String, Object> params);

    int countComposeDistributionStrategyVoByScenic(Map<String, Object> params);

    /**
     * 根据政策实体对象查询对应的政策表记录中dictvalue字段值
     * @param strategyId
     * @return
     */
    String selectByStrategyIdForUpdate(@Param("strategyId") Long strategyId);

    /**
     * 根据政策实体对象的DictValue值更新所有dictvalue同值得政策表记录中
     * @param SysChannelStrategy
     * @param dictvalue值
     * @return
     */
    int updateBatchByDictValue(@Param("strategy") SysChannelStrategy strategy, @Param("bParam") String parDictValue);
}
