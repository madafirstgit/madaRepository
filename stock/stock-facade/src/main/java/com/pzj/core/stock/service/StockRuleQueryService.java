/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service;

import java.util.ArrayList;

import com.pzj.core.stock.model.StockRuleModel;
import com.pzj.core.stock.model.StockRuleQueryRequestModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.entity.QueryResult;

/**
 * 库存规则查询服务
 * @author Administrator
 * @version $Id: StockQueryService.java, v 0.1 2016年7月22日 下午6:01:38 Administrator Exp $
 */
public interface StockRuleQueryService {

    /**
     * 根据库存规则ID查询库存规则
     * @author dongchunfu
     */
    public Result<StockRuleModel> queryStockRuleById(StockRuleQueryRequestModel model, ServiceContext context);

    /**
     * 根据参数集合查询库存规则
     * @author dongchunfu
     */
    public Result<ArrayList<StockRuleModel>> queryStockRulesByParam(StockRuleQueryRequestModel model, ServiceContext context);

    /**
     * 分页查询库存规则
     * @author dongchunfu
     */
    public Result<QueryResult<StockRuleModel>> queryStockRulePage(StockRuleQueryRequestModel model, ServiceContext context);

    /**
     * 对库存规则按类别进行分类查询
     * 
     * @param request
     * @param context
     * @return
     */
    public Result<StockRuleModel> queryStockRule4Category(StockRuleQueryRequestModel model, ServiceContext context);

}
