package com.pzj.regulation.convertUtil;

import java.util.Date;

import com.pzj.base.common.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysSettlementRule;
import com.pzj.common.BaseVoConvertUtil;
import com.pzj.regulation.entity.StrategySettlementRule;

public class SettlementRuleConvertUtil extends BaseVoConvertUtil<StrategySettlementRule, SysSettlementRule> {
    private static SettlementRuleConvertUtil util = new SettlementRuleConvertUtil();

    private SettlementRuleConvertUtil() {

    }

    public static SettlementRuleConvertUtil getInstance() {
        return util;
    }

    @Override
    public SysSettlementRule convertTSysBean(StrategySettlementRule vo) {
        if (vo == null)
            return null;
        SysSettlementRule bean = new SysSettlementRule();
        bean.setCreateBy(vo.getCreateBy());
        bean.setCreateDate(vo.getCreateDate());
        bean.setDelFlag(vo.getDelFlag());
        bean.setId(vo.getId());
        bean.setNotTotalSettlementType(vo.getNotTotalSettlementType());
        bean.setParentProductId(vo.getParentProductId());
        bean.setProductId(vo.getProductId());
        bean.setReduceSettlementMoney(vo.getReduceSettlementMoney());
        bean.setStrategyId(vo.getStrategyId());
        bean.setSupplierId(vo.getSupplierId());
        bean.setUpdateBy(vo.getUpdateBy());
        bean.setUpdateDate(vo.getUpdateDate());
        bean.setIsNeedUpdateNull(vo.getIsNeedUpdateNull());
        return bean;
    }

    @Override
    public StrategySettlementRule convertTApiBean(SysSettlementRule vo) {
        if (vo == null)
            return null;
        StrategySettlementRule bean = new StrategySettlementRule();
        bean.setCreateBy(vo.getCreateBy());
        bean.setCreateDate(vo.getCreateDate());
        bean.setDelFlag(vo.getDelFlag());
        bean.setId(vo.getId());
        bean.setNotTotalSettlementType(vo.getNotTotalSettlementType());
        bean.setParentProductId(vo.getParentProductId());
        bean.setProductId(vo.getProductId());
        bean.setReduceSettlementMoney(vo.getReduceSettlementMoney());
        bean.setStrategyId(vo.getStrategyId());
        bean.setSupplierId(vo.getSupplierId());
        bean.setUpdateBy(vo.getUpdateBy());
        bean.setUpdateDate(vo.getUpdateDate());
        bean.setIsNeedUpdateNull(vo.getIsNeedUpdateNull());
        return bean;
    }

    public SysSettlementRule convertTSysBeanForIU(StrategySettlementRule vo) throws Exception {
        if (vo == null) {
            return null;
        }
        if (vo.getId() == null) {
            // 1.设置默认数据
            if (vo.getCreateDate() == null) {
                vo.setCreateDate(new Date());
            }
            if (vo.getDelFlag() == null) {
                vo.setDelFlag(GlobalParam.FLAG.start());
            }
            validData(vo);
        } else {
            // 1.设置默认数据
            if (vo.getUpdateDate() == null) {
                vo.setUpdateDate(new Date());
            }

            // 2.验证数据
            if (vo.getIsNeedUpdateNull())
                validData(vo);
        }

        // 3.数据转换
        return convertTSysBean(vo);

    }

    public SysSettlementRule convertTSysBeanForS(StrategySettlementRule vo) throws Exception {
        // 1.基础查询参数转换
        SysSettlementRule bean = convertTSysBean(vo);

        // 2.关联查询参数转换
        bean.setQueryIdList(vo.getQueryIdList());
        bean.setQueryParentProductIdList(vo.getQueryParentProductIdList());
        bean.setQueryProductIdList(vo.getQueryProductIdList());
        bean.setQueryStartegyIdList(vo.getQueryStartegyIdList());

        return bean;
    }

    public void validData(StrategySettlementRule vo) throws ServiceException {
        // TODO Auto-generated method stub

    }

}
