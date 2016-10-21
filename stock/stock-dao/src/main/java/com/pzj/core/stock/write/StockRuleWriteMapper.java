package com.pzj.core.stock.write;

import com.pzj.core.stock.entity.StockRule;

public interface StockRuleWriteMapper {
    //插入实体
    int insertStockRule(StockRule rule);

    //根据主键更新非空字段
    int updateStockRuleById(StockRule rule);

    //更改库存规则状态
    int updateStockRuleStateById(StockRule rule);

    //伪删除库存规则
    int fakeDeleteStockRule(Long id);

}