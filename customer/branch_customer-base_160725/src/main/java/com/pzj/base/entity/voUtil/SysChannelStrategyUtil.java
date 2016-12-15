package com.pzj.base.entity.voUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysSettlementRule;

public class SysChannelStrategyUtil {

    private static SysChannelStrategyUtil productUtil = new SysChannelStrategyUtil();

    private SysChannelStrategyUtil() {
    }

    public static SysChannelStrategyUtil getInstance() {
        return productUtil;
    }

    public Map<Long, List<SysSettlementRule>> getSettlementRuleMap(
            List<SysChannelStrategy> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<Long, List<SysSettlementRule>> map = new HashMap<Long, List<SysSettlementRule>>();
        for (SysChannelStrategy vo : list) {
            List<SysSettlementRule> childList = vo.getSettlementRuleList();
            map.put(vo.getId(), childList);
        }
        return map;

    }

}
