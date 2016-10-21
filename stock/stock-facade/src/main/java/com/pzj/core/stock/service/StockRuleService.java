/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service;

import com.pzj.core.stock.model.StockRuleModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 库存规则写入相关操作
 * @author dongchunfu
 * @version $Id: StockQueryService.java, v 0.1 2016年7月22日 下午6:01:38 dongchunfu Exp $
 */
public interface StockRuleService {
    /**
     * 创建库存规则
     * @author dongchunfu
     * @param model 库存规则业务实体
     * @return 新增实体ID
     */
    public Result<Long> createStockRule(StockRuleModel model, ServiceContext context);

    /**
     * 更新库存规则
     * @author dongchunfu
     * @param model 库存规则实体
     * @return 更新条数
     */
    public Result<Integer> updateStockRule(StockRuleModel model, ServiceContext context);

    /**
     * 更新库存规则状态
     * @author dongchunfu
     * @param model 库存规则实体
     * @return 统一响应结果
     */
    @Deprecated
    public Result<Integer> updateStockRuleState(StockRuleModel model, ServiceContext context);

    /**
     * 更新库存规则状态
     * @author dongchunfu
     * @param model 库存规则实体
     * @return 统一响应结果
     */
    public Result<Integer> fakeDeleteStockRule(StockRuleModel model, ServiceContext context);

}
