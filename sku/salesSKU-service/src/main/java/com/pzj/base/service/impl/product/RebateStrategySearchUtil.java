package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.product.IRebateStrategySearchMapper;
import com.pzj.channel.RebateStrategy;
import com.pzj.channel.Strategy;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.StrategyConvert;

/**
 * Created by Administrator on 2016-8-4.
 */
@Component
public class RebateStrategySearchUtil {
    @Autowired
    private IRebateStrategySearchMapper rebateStrategySearchMapper;

    public Map<Long, Strategy> fillReabteFroStrategy(List<SysChannelStrategy> strategyList) {
        List<Long> idList = CommonConvert.getIdList(strategyList);
        List<SysRebateStrategy> sysRebateStrategyList = queryRebateByStrategyIds(idList);
        Map<Long, Strategy> strategyMap = new HashMap<>(strategyList.size());
        for (SysChannelStrategy channelStrategy : strategyList) {
            Strategy strategy = StrategyConvert.convertTStrategy(channelStrategy);
            strategyMap.put(strategy.getId(), strategy);
        }
        fillReabteFroStrategy(strategyMap, sysRebateStrategyList);
        return strategyMap;
    }

    private void fillReabteFroStrategy(Map<Long, Strategy> strategyMap,
                                       List<SysRebateStrategy> rebateStrategyList) {
        for (SysRebateStrategy rebateStrategy : rebateStrategyList) {
            Long strategyId = rebateStrategy.getStrategyId();
            Strategy strategy = strategyMap.get(strategyId);
            if (strategy != null) {
                List<RebateStrategy> strategyRebateStrategyList = strategy.getRebateStrategyList();
                if (CollectionUtils.isEmpty(strategyRebateStrategyList)) {
                    strategyRebateStrategyList = new ArrayList<>();
                    strategy.setRebateStrategyList(strategyRebateStrategyList);
                }
                RebateStrategy rebate = StrategyConvert.convertTRebate(rebateStrategy);
                strategyRebateStrategyList.add(rebate);
            }
        }
    }

    public List<SysRebateStrategy> queryRebateByStrategyIds(List<Long> strategyIds) {
        SysRebateStrategy param = new SysRebateStrategy();
        param.setStrategyIds(strategyIds);
        return rebateStrategySearchMapper.queryByParamMap(param, null);
    }
}
