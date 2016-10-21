/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.converter.StockRulesConverter;
import com.pzj.core.stock.entity.StockRule;
import com.pzj.core.stock.event.PackagResult4Category;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.model.StockRuleModel;
import com.pzj.core.stock.model.StockRuleQueryRequestModel;
import com.pzj.core.stock.rulequery.StockRuleQueryByIdEngine;
import com.pzj.core.stock.rulequery.StockRuleQueryByPageEngine;
import com.pzj.core.stock.rulequery.StockRuleQueryByParamEngine;
import com.pzj.core.stock.service.StockRuleQueryService;
import com.pzj.core.stock.validator.rule.QueryStockRuleByIdValidator;
import com.pzj.core.stock.validator.rule.QueryStockRulePageValidator;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.entity.QueryResult;
import com.pzj.framework.exception.ServiceException;

/**
 * 
 * @author dongchunfu
 * @version $Id: StockRuleQueryServiceImpl.java, v 0.1 2016年7月25日 下午3:35:37 dongchunfu Exp $
 */
@Service(value = "stockRuleQueryService")
public class StockRuleQueryServiceImpl implements StockRuleQueryService {
    private static final Logger         logger = LoggerFactory.getLogger(StockRuleQueryServiceImpl.class);

    @Resource(name = "stockRuleQueryByPageEngine")
    private StockRuleQueryByPageEngine  stockRuleQueryByPageEngine;
    @Resource(name = "stockRuleQueryByIdEngine")
    private StockRuleQueryByIdEngine    stockRuleQueryByIdEngine;
    @Resource(name = "stockRuleQueryByParamEngine")
    private StockRuleQueryByParamEngine stockRuleQueryByParamEngine;

    @Resource(name = "queryStockRuleByIdValidator")
    private QueryStockRuleByIdValidator queryStockRuleByIdValidator;
    @Resource(name = "queryStockRulePageValidator")
    private QueryStockRulePageValidator queryStockRulePageValidator;

    @Resource(name = "stockRulesConverter")
    private StockRulesConverter         stockRulesConverter;
    @Resource(name = "packagResult4Category")
    private PackagResult4Category       packagResult4Category;

    /** 
     * @see com.pzj.stock.service.stock.StockRuleQueryService#queryStockRuleById(java.lang.Long)
     */
    @Override
    public Result<StockRuleModel> queryStockRuleById(StockRuleQueryRequestModel model, ServiceContext context) {
        Boolean success = queryStockRuleByIdValidator.convert(model, context);
        if (!success) {
            logger.warn("illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering stock ruel by id ,request: {}, context: {}.", model, context);
        }

        try {
            StockRule response = stockRuleQueryByIdEngine.selectStockRuleById(model.getRuleId(), context);

            if (logger.isDebugEnabled()) {
                logger.debug("query stock rule id success ,request: {}, context: {},response: {}.", model, context, response);
            }

            if (null == response) {
                return new Result<StockRuleModel>();
            }

            StockRuleModel result = new StockRuleModel();
            PropertyUtils.copyProperties(result, response);

            return new Result<StockRuleModel>(result);

        } catch (Throwable t) {
            logger.error("query stock rule by id,request:{},context:{}.", model, context, t);

            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);

        }
    }

    /** 
     * @see com.pzj.stock.service.stock.StockRuleQueryService#queryStockRuleBySupplierId(java.lang.Long)
     */
    @Override
    public Result<QueryResult<StockRuleModel>> queryStockRulePage(StockRuleQueryRequestModel model, ServiceContext context) {

        Boolean success = queryStockRulePageValidator.convert(model, context);
        if (!success) {
            logger.warn(" illegal param ,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering stock rule ,request:{},context:{}.", model, context);
        }

        try {
            QueryResult<StockRule> qr = stockRuleQueryByPageEngine.queryRuleByPage(model);
            List<StockRule> list = qr.getRecords();
            ArrayList<StockRuleModel> response = stockRulesConverter.convert(list, context);
            QueryResult<StockRuleModel> result = new QueryResult<StockRuleModel>(model.getCurrentPage(), model.getPageSize());

            result.setTotal(qr.getTotal());
            result.setRecords(response);
            return new Result<QueryResult<StockRuleModel>>(result);
        } catch (Throwable t) {
            logger.error("query stock rule by page fail,request:{},context:{}.", model, context, t);

            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);

        }
    }

    /** 
     * @see com.pzj.core.stock.service.StockRuleQueryService#queryStockRule4Category(com.pzj.core.stock.model.StockRuleQueryRequestModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<StockRuleModel> queryStockRule4Category(StockRuleQueryRequestModel model, ServiceContext context) {

        try {

            Result<ArrayList<StockRuleModel>> result = queryStockRulesByParam(model, context);

            if (result.isOk()) {

                ArrayList<StockRuleModel> data = result.getData();
                return new Result<StockRuleModel>(packagResult4Category.packagResult(data, context));

            } else {
                throw new StockException(StockExceptionCode.STOCK_ERR_MSG);
            }
        } catch (Throwable t) {

            logger.error("query stock rule for category  failed ,request:{},context:{}.", model, context, t);

            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

    }

    /** 
     * @see com.pzj.core.stock.service.StockRuleQueryService#queryStockRulesByParam(com.pzj.core.stock.model.StockRuleQueryRequestModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<StockRuleModel>> queryStockRulesByParam(StockRuleQueryRequestModel model, ServiceContext context) {

        if (null == model || null == context) {
            logger.warn(" illegal param ,request:{},context:{}.", model, context);
            //throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
            return new Result<>(StockExceptionCode.PARAM_ERR_CODE, StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering stock rule by param ,request:{},context:{}.", model, context);
        }
        try {

            List<StockRule> rules = stockRuleQueryByParamEngine.queryRuleByParam(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug("query stock rule by param success,request:{},response:{},context:{}.", model, rules, context);
            }

            return null == rules ? new Result<ArrayList<StockRuleModel>>() : new Result<ArrayList<StockRuleModel>>(stockRulesConverter.convert(rules, context));

        } catch (Throwable t) {

            logger.error("query stock rule by param failed ,request:{},context:{}.", model, context, t);

            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }
}
