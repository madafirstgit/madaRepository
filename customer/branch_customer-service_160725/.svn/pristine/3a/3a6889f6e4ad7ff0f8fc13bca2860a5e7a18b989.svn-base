package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysExtraRebateStrategy;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.service.sys.IExtraRebateStrategyService;
import com.pzj.base.service.sys.IRebateStrategyService;
import com.pzj.dao.SysRebateStrategyMapper;

@Service("rebateStrategyService")
public class RebateStrategyServiceImpl extends BaseUserServiceImpl<SysRebateStrategy, SysRebateStrategyMapper> implements IRebateStrategyService {

    @Autowired
    private IExtraRebateStrategyService extraRebateService;

    public void createRebateStrategyBatch(List<SysRebateStrategy> RebateList) {
        /*
         * 批量插入返利规则
         * 如果每个元素SysRebateStrategy对象的sysExtraRebateStrategyList属性有值，就表示说返利规则中存在加点返利规则，
         * 则汇集所有的SysExtraRebateStrategy对象（加点返利规则）后批量创建。
         */

        if (null == RebateList)
            return;

        this.insertBatch(RebateList);

        //插入加点返利规则
        List<SysExtraRebateStrategy> extraRebateList = new ArrayList<SysExtraRebateStrategy>();

        // 循环返利规则集合
        for (SysRebateStrategy sysRebateStrategy : RebateList) {
            List<SysExtraRebateStrategy> list = sysRebateStrategy.getSysExtraRebateStrategyList();
            if (null == list) {
                continue;
            }

            // 循环当前返利规则中的加点返利规则集合
            for (SysExtraRebateStrategy sysExtraRebateStrategy : list) {

                // 关联返利规则与加点返利规则
                sysExtraRebateStrategy.setFrontRebateRuleId(sysRebateStrategy.getId());
                extraRebateList.add(sysExtraRebateStrategy);
            }
        }

        this.extraRebateService.insertOrUpdateBatch(extraRebateList);
    }

    /**
     * 创建返利规则
     */
    @Override
    public void createRebateStrategy(SysRebateStrategy rebateStrategy) {

        if (null == rebateStrategy)
            return;

        this.insertOrUpdate(rebateStrategy);

        //获取加点返利规则
        List<SysExtraRebateStrategy> extraRebateList = rebateStrategy.getSysExtraRebateStrategyList();
        if (null == extraRebateList) {
            return;
        }

        for (SysExtraRebateStrategy extraRebate : extraRebateList) {
            extraRebate.setFrontRebateRuleId(rebateStrategy.getId());
        }

        this.extraRebateService.insertOrUpdateBatch(extraRebateList);
    }

    /**
     * 更新返利规则
     */
    @Override
    public void UpdateRebateStrategy(SysRebateStrategy rebateStrategy) {
        createRebateStrategy(rebateStrategy);
    }

    /**
     * 批量更新返利规则
     */
    @Override
    public void UpdateRebateStrategyBatch(List<SysRebateStrategy> rebateStrategyList) {
        createRebateStrategyBatch(rebateStrategyList);
    }

    /**
     * 更新状态
     */
    @Override
    public void updateRebateStrategyStatus(Long rebateStrategyId, Integer state) {
        SysRebateStrategy rebateStrategy = this.mapper.selectByPrimaryKey(rebateStrategyId);
        rebateStrategy.setDelFlag(state);
        this.mapper.updateByPrimaryKey(rebateStrategy);
    }

    /**
     * <h3>根据ID获取返利规则及加点返利规则<h3>
     * <p>
     * 根据id查询返利规则，再查询此返利规则的加点返利规则，如果没有就设置一个空的加点返利规则集合。
     * </p>
     */
    @Override
    public SysRebateStrategy querySysRebateStrategyById(Long rebateStrategyId) {
        SysRebateStrategy sysRebateStrategy = this.mapper.selectByPrimaryKey(rebateStrategyId);
        if (sysRebateStrategy != null) {
            List<SysExtraRebateStrategy> sysExtraRebateStrategyList = this.extraRebateService
                .querySysExtraRebateStrategyByrebateStrategyId(sysRebateStrategy.getId());

            if (sysExtraRebateStrategyList != null) {
                sysRebateStrategy.setSysExtraRebateStrategyList(sysExtraRebateStrategyList);
            } else {
                sysRebateStrategy.setSysExtraRebateStrategyList(new ArrayList<SysExtraRebateStrategy>(0));
            }
        }

        return sysRebateStrategy;
    }

    public int updateRebateByDictValue(SysRebateStrategy strategy, String DictValue) {
        int num = 0;
        if (strategy == null) {
            this.logger.error("方法[IRebateStrategyService.updateRebateByDictValue],参数SysRebateStrategy不可以为空");
            return num;
        }
        if (null == DictValue || "".equals(DictValue)) {
            this.logger.error("方法[IRebateStrategyService.updateRebateByDictValue],参数DictValue不可以为空");
            return num;
        }
        return num = this.mapper.updateRebateByDictValue(strategy, DictValue);
    }
}
