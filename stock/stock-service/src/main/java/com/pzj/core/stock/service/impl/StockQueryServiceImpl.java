/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.exception.StockException;
import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.converter.StocksConverter;
import com.pzj.core.stock.entity.Stock;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.model.CheckStockModel;
import com.pzj.core.stock.model.CheckStockModel.QueryStockType;
import com.pzj.core.stock.model.ParamModel;
import com.pzj.core.stock.model.StockDateListQueryModel;
import com.pzj.core.stock.model.StockModel;
import com.pzj.core.stock.model.StockQueryRequestModel;
import com.pzj.core.stock.model.UserOccupyStockModel;
import com.pzj.core.stock.service.StockQueryService;
import com.pzj.core.stock.stockquery.QueryStockByDateListEngine;
import com.pzj.core.stock.stockquery.QueryStockByRuleEngine;
import com.pzj.core.stock.stockquery.QueryStockBySupBatchOpeEngine;
import com.pzj.core.stock.stockquery.QueryUserBatchOccupyStockEngine;
import com.pzj.core.stock.stockquery.StockQueryByDateEngine;
import com.pzj.core.stock.stockquery.StockQueryByIdEngine;
import com.pzj.core.stock.stockquery.StockQueryParamEngine;
import com.pzj.core.stock.stockquery.StockQueryRangeEngine;
import com.pzj.core.stock.validator.stock.CheckStockIsEnoughValidator;
import com.pzj.core.stock.validator.stock.QueryStockByDateListValidator;
import com.pzj.core.stock.validator.stock.QueryStockByDateValidator;
import com.pzj.core.stock.validator.stock.QueryStockByIdValidator;
import com.pzj.core.stock.validator.stock.QueryStockByMonthValidator;
import com.pzj.core.stock.validator.stock.QueryStockByRuleValidator;
import com.pzj.core.stock.validator.stock.QueryStockRangeValidator;
import com.pzj.core.stock.validator.stock.QueryStocksValidator;
import com.pzj.core.stock.validator.stock.QueryUserBatchOccupyStockValidator;
import com.pzj.core.util.DateUtil;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;
import com.pzj.framework.toolkit.Check;

/**
 * 库存查询服务接口实现
 * 
 * @author dongchunfu
 * @version $Id: StockQueryServiceImpl.java, v 0.1 2016年7月25日 下午3:40:58 dongchunfu Exp $
 */
@Service(value = "stockQueryService")
public class StockQueryServiceImpl implements StockQueryService {

    private static final Logger                logger = LoggerFactory.getLogger(StockQueryServiceImpl.class);

    @Resource(name = "stockQueryParamEngine")
    private StockQueryParamEngine              stockQueryParamEngine;
    @Resource(name = "stockQueryByIdEngine")
    private StockQueryByIdEngine               stockQueryByIdEngine;
    @Resource(name = "stockQueryByDateEngine")
    private StockQueryByDateEngine             stockQueryByDateEngine;
    @Resource(name = "stockQueryRangeEngine")
    private StockQueryRangeEngine              stockQueryRangeEngine;
    @Resource(name = "queryUserBatchOccupyStockEngine")
    private QueryUserBatchOccupyStockEngine    queryUserBatchOccupyStockEngine;
    @Resource(name = "queryStockByDateListEngine")
    private QueryStockByDateListEngine         queryStockByDateListEngine;
    @Resource(name = "queryStockByRuleEngine")
    private QueryStockByRuleEngine             queryStockByRuleEngine;
    @Resource(name = "queryStockBySupBatchOpeEngine")
    private QueryStockBySupBatchOpeEngine      queryStockBySupBatchOpeEngine;

    @Resource(name = "queryStockByIdValidator")
    private QueryStockByIdValidator            queryStockByIdValidator;
    @Resource(name = "queryStockRangeValidator")
    private QueryStockRangeValidator           queryStockRangeValidator;
    @Resource(name = "queryStockByMonthValidator")
    private QueryStockByMonthValidator         queryStockByMonthValidator;
    @Resource(name = "queryStockByDateValidator")
    private QueryStockByDateValidator          queryStockByDateValidator;
    @Resource(name = "queryStocksValidator")
    private QueryStocksValidator               queryStocksValidator;
    @Resource(name = "checkStockIsEnoughValidator")
    private CheckStockIsEnoughValidator        checkStockIsEnoughValidator;
    @Resource(name = "queryUserBatchOccupyStockValidator")
    private QueryUserBatchOccupyStockValidator queryUserBatchOccupyStockValidator;
    @Resource(name = "queryStockByDateListValidator")
    private QueryStockByDateListValidator      queryStockByDateListValidator;
    @Resource(name = "queryStockByRuleValidator")
    private QueryStockByRuleValidator          queryStockByRuleValidator;

    @Resource(name = "stocksConverter")
    private StocksConverter                    stocksConverter;

    @Resource(name = "dateUtil")
    private DateUtil                           dateUtil;

    /** 
     * @see com.pzj.stock.service.stock.StockQueryService#queryStockById(java.lang.Long, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<StockModel> queryStockById(StockQueryRequestModel model, ServiceContext context) {
        Boolean success = queryStockByIdValidator.convert(model, context);
        if (!success) {
            logger.error("illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering stock by id ,request:{},context:{}.", model, context);
        }

        try {

            Stock stock = stockQueryByIdEngine.selectStockById(model.getStockId(), context);

            if (null == stock) {
                return new Result<StockModel>();
            }

            if (logger.isDebugEnabled()) {
                logger.debug("query stock by id success ,request: {}, context: {}, response: {}.", model, context, stock);
            }

            StockModel result = new StockModel();
            PropertyUtils.copyProperties(result, stock);
            return new Result<StockModel>(result);

        } catch (Throwable t) {

            logger.error("query stock by id fail,request:{},context:{}.", model, context, t);

            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);

        }

    }

    /** 
     * @see com.pzj.stock.service.stock.StockQueryService#queryStockByDate(java.lang.Long, java.util.Date, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<StockModel> queryStockByDate(StockQueryRequestModel model, ServiceContext context) {

        Boolean success = Boolean.FALSE;
        try {
            success = queryStockByDateValidator.convert(model, context);
        } catch (Throwable t) {
            logger.error("query stock by date illegal param ,request:" + model + ",context:" + context, t);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }
        if (!success) {
            logger.warn("query stock by date illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        StockQueryRequestModel request = new StockQueryRequestModel();
        request.setRuleId(model.getRuleId());
        request.setStockTime(String.valueOf(model.getStockTime()));
        if (logger.isDebugEnabled()) {
            logger.debug(" quering stock by date ,request: {}, context: {}.", model, context);
        }
        try {
            ArrayList<Stock> list = stockQueryByDateEngine.queryStockByDate(model, context);
            if (logger.isDebugEnabled()) {
                logger.debug(" query stock by date success ,request: {}, context: {}, response: {}.", model, context, list);
            }
            if (list == null || list.size() == 0) {
                return new Result<StockModel>();
            }

            StockModel result = new StockModel();
            PropertyUtils.copyProperties(result, list.get(0));
            return new Result<StockModel>(result);

        } catch (Throwable t) {
            logger.error("query stock by date fail ,request:{},context:{}.", model, context, t);
            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);

        }
    }

    /** 
     * @see com.pzj.stock.service.stock.StockQueryService#queryAllStocks(java.lang.Long, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<StockModel>> queryAllStocks(StockQueryRequestModel model, ServiceContext context) {

        Boolean success = queryStocksValidator.convert(model, context);
        if (!success) {
            logger.error("illegal param ,request: {}, context: {}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering all stocks ,request: {}, context: {}.", model, context);
        }
        try {

            ArrayList<Stock> list = stockQueryParamEngine.queryStockByParam(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug("quering all stocks success ,request: {}, context: {}, response: {}.", model, context, list);
            }
            if (null == list || list.size() == 0) {
                return new Result<ArrayList<StockModel>>();
            }
            return new Result<ArrayList<StockModel>>(stocksConverter.convert(list, context));

        } catch (Throwable t) {
            logger.error(" query all stocks error,request:{},context:{}. ", model, context, t);
            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);

        }

    }

    /** 
     * @see com.pzj.stock.service.stock.StockQueryService#queryRangeStocks(com.pzj.stock.StockRequestModel.StockQueryRequestBean, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<StockModel>> queryRangeStocks(StockQueryRequestModel model, ServiceContext context) {
        Boolean success = Boolean.FALSE;
        try {
            queryStockRangeValidator.convert(model, context);
        } catch (Throwable t) {
            logger.error("query stock by range illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }
        if (!success) {
            logger.error("query stock by range illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering range stocks ,request: {}, context: {}.", model, context);
        }

        try {

            ArrayList<Stock> list = stockQueryRangeEngine.queryRangeStocks(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug("query range stocks success ,request: {}, context: {}, response: {}.", model, context, list);
            }

            if (null == list || list.size() == 0) {
                return new Result<ArrayList<StockModel>>();
            }
            return new Result<ArrayList<StockModel>>(stocksConverter.convert(list, context));

        } catch (Throwable t) {
            logger.error(" query range stocks fail,request:{},context:{}. ", model, context, t);
            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

    }

    /** 
     * @see com.pzj.stock.service.stock.StockQueryService#queryMonthStocks(com.pzj.stock.StockRequestModel.StockQueryRequestBean, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<StockModel>> queryMonthStocks(StockQueryRequestModel model, ServiceContext context) {
        Boolean success = Boolean.FALSE;

        try {
            success = queryStockByMonthValidator.convert(model, context);
        } catch (Throwable t) {
            logger.error("query stock by month illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (!success) {
            logger.warn("query stock by month illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }
        int queryMonth;
        try {
            queryMonth = model.getQueryMonth();
        } catch (Throwable t) {
            logger.error(" number formate exception .", t);
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

        Integer month = Integer.valueOf(String.valueOf(queryMonth).substring(4, 6));//查询月份
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;//当前月份
        Date currentDate = new Date();
        int beginStockTime;
        int endStockTime;

        try {
            if (month == currentMonth) {
                beginStockTime = dateUtil.getIntegerTime(currentDate);
                int lastDay = dateUtil.getLastDay(currentDate);
                endStockTime = queryMonth / 100 * 100 + lastDay;
                model.setBeginStockTime(String.valueOf(beginStockTime));
                model.setEndStockTime(String.valueOf(endStockTime));
                if (logger.isDebugEnabled()) {
                    logger.debug("quering month stocks ,request: {}, context: {}.", model, context);
                }
                return queryRangeStocks(model, context);

            } else {
                model.setBeginStockTime(String.valueOf(queryMonth));
                model.setEndStockTime(String.valueOf(queryMonth / 100 * 100 + dateUtil.getLastDay(dateUtil.getDate(queryMonth))));
                if (logger.isDebugEnabled()) {
                    logger.debug("quering month stocks success ,request: {}, context: {}.", model, context);
                }
                return queryRangeStocks(model, context);
            }
        } catch (Throwable t) {

            logger.error(" query month stocks fail,request:{},context:{}. ", model, context, t);
            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

    }

    /** 
     * @see com.pzj.core.stock.service.StockQueryService#judgeStockIsEnough(com.pzj.core.stock.model.CheckStockModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Boolean> judgeStockIsEnough(CheckStockModel checkStockModel, ServiceContext context) {
        ParamModel paramModel = checkStockIsEnoughValidator.convert(checkStockModel, context);
        if (!paramModel.paramIsOk()) {
            logger.error("judge stock is enough fail, Illegal params. request: {}, context: {}.", checkStockModel, context);
            throw new ParameterErrorException(paramModel.getParamErrorMsg());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("judge stock is enough. request: {}, context: {}.", checkStockModel, context);
        }
        Result<Boolean> result = new Result<Boolean>(Boolean.FALSE);
        try {
            Result<StockModel> stockResult = null;
            StockQueryRequestModel model = new StockQueryRequestModel();
            model.setRuleId(checkStockModel.getStockRuleId());
            model.setStockId(checkStockModel.getStockId());
            model.setStockTime(checkStockModel.getStockTime());
            if (QueryStockType.STOCK_ID.key == checkStockModel.getQueryType()) {
                stockResult = this.queryStockById(model, context);
            } else if (QueryStockType.STOCK_RULE_ID.key == checkStockModel.getQueryType()) {
                stockResult = this.queryStockByRule(model, context);
            }

            if (!Check.NuNObject(stockResult, stockResult.getData())) {
                StockModel stockModel = stockResult.getData();
                int remainNum = stockModel.getRemainNum();
                int occupyNum = checkStockModel.getOccupyNum();
                if (remainNum >= occupyNum) {
                    result.setData(Boolean.TRUE);
                }
            }
        } catch (Throwable e) {
            logger.error("judge stock is enough fail. request: " + checkStockModel + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("judge stock is enough. request: {}, context: {}.", checkStockModel, context);
        }

        return result;
    }

    /** 
     * @see com.pzj.core.stock.service.StockQueryService#queryUserBatchOccupyStock(com.pzj.core.stock.model.UserOccupyStockModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<UserOccupyStockModel> queryUserBatchOccupyStock(UserOccupyStockModel userOccupyStockModel, ServiceContext context) {
        ParamModel paramModel = queryUserBatchOccupyStockValidator.convert(userOccupyStockModel, context);
        if (!paramModel.paramIsOk()) {
            logger.error("query user batch occupy stock fail, Illegal params. request: {}, context: {}.", userOccupyStockModel, context);
            throw new ParameterErrorException(paramModel.getParamErrorMsg());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query user batch occupy stock. request: {}, context: {}.", userOccupyStockModel, context);
        }
        Result<UserOccupyStockModel> result = new Result<UserOccupyStockModel>();
        try {
            queryUserBatchOccupyStockEngine.queryUserOneRuleOccupyStock(userOccupyStockModel);
            result.setData(userOccupyStockModel);
        } catch (Throwable e) {
            logger.error("query user batch occupy stock fail. request: " + userOccupyStockModel + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query user batch occupy stock. request: {}, context: {}.", userOccupyStockModel, context);
        }

        return result;
    }

    /** 
     * @see com.pzj.core.stock.service.StockQueryService#queryStockByDateList(com.pzj.core.stock.model.StockDateListQueryModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<StockModel>> queryStockByDateList(StockDateListQueryModel model, ServiceContext context) {
        ParamModel paramModel = queryStockByDateListValidator.convert(model, context);
        if (!paramModel.paramIsOk()) {
            logger.error("query stock by date list fail, Illegal params. request: {}, context: {}.", model, context);
            throw new ParameterErrorException(paramModel.getParamErrorMsg());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query stock by date list. request: {}, context: {}.", model, context);
        }
        Result<ArrayList<StockModel>> result = new Result<ArrayList<StockModel>>();
        try {
            List<Stock> stockList = queryStockByDateListEngine.queryStockByDateList(model);
            if (!CommonUtils.checkObjectIsNull(stockList)) {
                ArrayList<StockModel> stockModelList = new ArrayList<StockModel>();
                StockModel stockModel = null;
                for (Stock stock : stockList) {
                    stockModel = new StockModel();
                    PropertyUtils.copyProperties(stockModel, stock);
                    stockModelList.add(stockModel);
                }
                result.setData(stockModelList);
            }

        } catch (Throwable e) {
            logger.error("query stock by date list fail. request: " + model + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw (ServiceException) e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query stock by date list. request: {}, context: {}.", model, context);
        }

        return result;
    }

    /** 
     * @see com.pzj.core.stock.service.StockQueryService#queryStockByRule(com.pzj.core.stock.model.StockQueryRequestModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<StockModel> queryStockByRule(StockQueryRequestModel model, ServiceContext context) {
        ParamModel paramModel = queryStockByRuleValidator.convert(model, context);
        if (!paramModel.paramIsOk()) {
            logger.error("query stock by rule fail, Illegal params. request: {}, context: {}.", model, context);
            throw new ParameterErrorException(paramModel.getParamErrorMsg());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query stock by rule. request: {}, context: {}.", model, context);
        }

        Result<StockModel> result = new Result<StockModel>();
        try {
            Stock stock = queryStockByRuleEngine.queryStockByRule(model);
            if (!CommonUtils.checkObjectIsNull(stock)) {
                StockModel stockModel = new StockModel();
                PropertyUtils.copyProperties(stockModel, stock);
                result.setData(stockModel);
            }
        } catch (Throwable e) {
            logger.error("query stock by rule fail. request: " + model + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw (ServiceException) e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query stock by rule. request: {}, context: {}.", model, context);
        }

        return result;
    }

    /** 
     * @see com.pzj.core.stock.service.StockQueryService#querySupplierOperateStockList(com.pzj.core.stock.model.StockDateListQueryModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<StockModel>> querySupplierBatchOperateStockList(StockDateListQueryModel model, ServiceContext context) {
        ParamModel paramModel = queryStockByDateListValidator.convert(model, context);
        if (!paramModel.paramIsOk()) {
            logger.error("query supplier batch operate stock fail, Illegal params. request: {}, context: {}.", model, context);
            throw new ParameterErrorException(paramModel.getParamErrorMsg());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query supplier batch operate stock. request: {}, context: {}.", model, context);
        }

        Result<ArrayList<StockModel>> result = new Result<ArrayList<StockModel>>();
        try {
            //            List<Stock> stockList = queryStockBySupBatchOpeEngine.queryStockByDateList(model);
            //            if (!CommonUtils.checkObjectIsNull(stockList)) {
            //                ArrayList<StockModel> stockModelList = new ArrayList<StockModel>();
            //                StockModel stockModel = null;
            //                for (Stock stock : stockList) {
            //                    stockModel = new StockModel();
            //                    PropertyUtils.copyProperties(stockModel, stock);
            //                    stockModelList.add(stockModel);
            //                }
            //                result.setData(stockModelList);
            //            }

        } catch (Throwable e) {
            logger.error("query supplier batch operate stock fail. request: " + model + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw (ServiceException) e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query supplier batch operate stock. request: {}, context: {}.", model, context);
        }

        return result;
    }

}
