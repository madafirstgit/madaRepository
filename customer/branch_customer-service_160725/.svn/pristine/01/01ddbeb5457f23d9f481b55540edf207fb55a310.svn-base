/*
 * SysSettlementRuleService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.child.impl.BaseChildCommonServiceImpl;
import com.pzj.base.entity.SysSettlementRule;
import com.pzj.base.service.sys.ISysSettlementRuleService;
import com.pzj.dao.SysSettlementRuleMapper;

/**
 * service接口实现.区域
 * 
 * @author 票之家
 */
@Service("sysSettlementRuleService")
public class SysSettlementRuleServiceImpl extends
        BaseChildCommonServiceImpl<SysSettlementRule, SysSettlementRuleMapper>
        implements ISysSettlementRuleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysSettlementRuleMapper sysSettlementRuleMapper;

    @Override
    public void setParentId(SysSettlementRule child, Long parentId) {
        if (child == null || parentId == null) {
            return;
        }
        child.setStrategyId(parentId);

    }

    public List<SysSettlementRule> findByParentIdList(List<Long> parentIdList) {
        if (parentIdList == null || parentIdList.isEmpty()) {
            return null;
        }
        SysSettlementRule param = new SysSettlementRule();
        param.setQueryStartegyIdList(parentIdList);
        return findListByParams(param);

    }

    @Override
    public List<SysSettlementRule> findByIdList(List<Long> idList) {
        if (idList == null || idList.isEmpty()) {
            return null;
        }
        SysSettlementRule param = new SysSettlementRule();
        param.setQueryIdList(idList);
        return findListByParams(param);

    }

}
