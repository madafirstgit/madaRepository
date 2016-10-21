/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service;

import java.util.ArrayList;

import com.pzj.core.stock.model.CheckStockModel;
import com.pzj.core.stock.model.StockDateListQueryModel;
import com.pzj.core.stock.model.StockModel;
import com.pzj.core.stock.model.StockQueryRequestModel;
import com.pzj.core.stock.model.UserOccupyStockModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 库存查询服务
 * @author dongchunfu
 * @version $Id: StockQueryService.java, v 0.1 2016年7月22日 下午6:01:38 dongchunfu Exp $
 */
public interface StockQueryService {

    /**
     * 根据库存id查找库存
     * @author dongchunfu
     * @param request 请求参数
     * @param serviceContext 服务上下文
     * @return Result<StockModel> 统一返回结果
     */
    Result<StockModel> queryStockById(StockQueryRequestModel model, ServiceContext context);

    /**
     * 查询指定日期的库存信息
     * 
     * @param stockRuleId 库存规则id
     * @param request 请求参数
     * @param serviceContext 服务上下文
     * @return Result<StockModel> 统一返回结果
     */
    @Deprecated
    Result<StockModel> queryStockByDate(StockQueryRequestModel model, ServiceContext context);

    /**
     * 查询符合条件(除ID)的所有库存信息
     * @author dongchunfu
     * @param request 请求参数
     * @param serviceContext 服务上下文
     * @return Result<ArrayList<StockModel>> 统一返回结果(未区分库存类型)
     */
    Result<ArrayList<StockModel>> queryAllStocks(StockQueryRequestModel model, ServiceContext context);

    /**
     * 查询当前日期（含）及之后 时间范围内 的所有库存信息
     * @author dongchunfu
     * @param request 请求参数
     * @param serviceContext 服务上下文
     * @return Result<ArrayList<StockModel>> 统一返回结果(未区分库存类型)
     */
    Result<ArrayList<StockModel>> queryRangeStocks(StockQueryRequestModel model, ServiceContext context);

    /**
     * 查询某月（当前日期（含）之后）范围内的所有库存信息
     * @author dongchunfu
     * @param request 请求参数
     * @param serviceContext 服务上下文
     * @return Result<ArrayList<StockModel>> 统一返回结果(未区分库存类型)
     */
    Result<ArrayList<StockModel>> queryMonthStocks(StockQueryRequestModel model, ServiceContext context);

    /**
     * 判断库存是否足够
     * @param model
     * @param context
     * @return  Result<Boolean>
     */
    Result<Boolean> judgeStockIsEnough(CheckStockModel checkStockModel, ServiceContext context);

    /**
     * 获取用户针对一个库存规则批量占用的库存信息
     * @param userOccupyStockModel
     * @param context
     * @return Result<UserOccupyStockModel>
     */
    Result<UserOccupyStockModel> queryUserBatchOccupyStock(UserOccupyStockModel userOccupyStockModel, ServiceContext context);

    /**
     * 通过多个日期查找库存集合
     * @param model
     * @param context
     * @return Result<ArrayList<StockModel>>
     */
    Result<ArrayList<StockModel>> queryStockByDateList(StockDateListQueryModel model, ServiceContext context);

    /**
     * 根据库存规则查库存，如果是每日库存则需要传时间
     * @param model
     * @param context
     * @return Result<StockModel>
     */
    Result<StockModel> queryStockByRule(StockQueryRequestModel model, ServiceContext context);

    /**
     * 供应端根据日历查询操作锁库存集合
     * @param model
     * @param context
     * @return Result<ArrayList<StockModel>>
     */
    Result<ArrayList<StockModel>> querySupplierBatchOperateStockList(StockDateListQueryModel model, ServiceContext context);

}
