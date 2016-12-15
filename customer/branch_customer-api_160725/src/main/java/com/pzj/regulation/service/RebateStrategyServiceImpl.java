package com.pzj.regulation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.service.sys.IRebateStrategyService;
import com.pzj.regulation.entity.RebateStrategyVo;

@Service
public class RebateStrategyServiceImpl implements RebateStrategyService {
    // 创建日志对象
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRebateStrategyService rebateStrategyService;

    public List<RebateStrategyVo> queryByRebateStrategy(RebateStrategyVo rebate) throws Exception {
        if (null == rebate) {
            return null;
        }

        SysRebateStrategy sysrebate = RebateStrategyVo.changeTSysBean(rebate);
        List<SysRebateStrategy> syrebateList = rebateStrategyService.findListByParams(sysrebate);
        List<RebateStrategyVo> result = RebateStrategyVo.sList2CList(syrebateList);
        return result;
    }
}
