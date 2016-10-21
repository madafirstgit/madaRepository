/*
 * SysSettlementRuleService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.impl.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysSettlementRule;
import com.pzj.base.product.ISettlementRuleSearchMapper;
import com.pzj.base.service.product.ISettlementSearchService;
import com.pzj.channel.SettlementRule;
import com.pzj.util.productConvertUtil.CommonConvert;

/**
 * service接口实现.区域
 * 
 * @author 票之家
 */
@Service
public class SettlementRuleSearchServiceImpl implements ISettlementSearchService {
    private final Logger                logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISettlementRuleSearchMapper sysSettlementRuleMapper;

    @Override
    public List<SettlementRule> findListByParams(SettlementRule params) {
        try {
            SysSettlementRule sysSettlementRule = new SysSettlementRule();
            CommonConvert.copyProperties(sysSettlementRule, params);
            return findListByParams(params);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private List<SettlementRule> findListByParams(SysSettlementRule params) {
        Map<String, Object> mapParams = new HashMap<>();
        mapParams.put("bParam", params);
        List<SysSettlementRule> listBean = sysSettlementRuleMapper.queryByParamMap(mapParams);
        List<SettlementRule> settlementRules = CommonConvert.convertList(listBean,
            SettlementRule.class);
        return settlementRules;
    }

    @Override
    public List<SettlementRule> findListByProductIds(List<Long> productIds) {
        SysSettlementRule params = new SysSettlementRule();
        params.setQueryProductIdList(productIds);
        return findListByParams(params);
    }
}
