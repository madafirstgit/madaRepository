/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.exception.StockException;
import com.pzj.core.product.acting.ActingQueryByIdEngine;
import com.pzj.core.product.acting.ActingQueryByParamEngine;
import com.pzj.core.product.converter.ActingsConverter;
import com.pzj.core.product.entity.Acting;
import com.pzj.core.product.model.ActingModel;
import com.pzj.core.product.model.ActingQueryRequestModel;
import com.pzj.core.product.service.ActingQueryService;
import com.pzj.core.product.validator.acting.QueryActingByIdValidator;
import com.pzj.core.product.validator.acting.QueryActingsByParamValidator;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;

/**
 * 演绎区域读服务实现
 * @author dongchunfu
 * @version $Id: AreaServiceImpl.java, v 0.1 2016年8月1日 上午10:48:26 dongchunfu Exp $
 */
@Service(value = "actingQueryService")
public class ActingQueryServiceImpl implements ActingQueryService {

    private static final Logger          logger = LoggerFactory.getLogger(ActingQueryServiceImpl.class);
    @Resource(name = "actingQueryByIdEngine")
    private ActingQueryByIdEngine        actingQueryByIdEngine;
    @Resource(name = "actingQueryByParamEngine")
    private ActingQueryByParamEngine     actingQueryByParamEngine;

    @Resource(name = "queryActingByIdValidator")
    private QueryActingByIdValidator     queryActingByIdValidator;
    @Resource(name = "queryActingsByParamValidator")
    private QueryActingsByParamValidator queryActingsByParamValidator;

    @Resource(name = "actingsConverter")
    private ActingsConverter             actingsConverter;

    /** 
     * @see com.pzj.core.product.service.ActingQueryService#queryActingById(com.pzj.core.product.model.ActingQueryRequestModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ActingModel> queryActingById(ActingQueryRequestModel request, ServiceContext context) {
        Boolean success = queryActingByIdValidator.convert(request, context);
        if (!success) {
            logger.error("query acting by id illegal param , request：{},context:{}.", request, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering acting by id, request:{},context:{}.", request, context);
        }

        try {

            Acting acting = actingQueryByIdEngine.queryActingById(request.getActingId());

            if (logger.isDebugEnabled())
                logger.debug("query acting by id success , request:{},context:{},response:{}.", request, context, acting);
            if (null == acting) {
                logger.info("query result is null.");
                return new Result<ActingModel>();
            }

            ActingModel model = new ActingModel();
            PropertyUtils.copyProperties(model, acting);

            return new Result<ActingModel>(model);

        } catch (Throwable t) {

            logger.error("query acting by id fail , request:{},context:{}.", request, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

    /** 
     * @see com.pzj.core.product.service.ActingQueryService#queryActingByParam(com.pzj.core.product.model.ActingQueryRequestModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<ActingModel>> queryActingByParam(ActingQueryRequestModel request, ServiceContext context) {
        Boolean success = queryActingsByParamValidator.convert(request, context);
        if (!success) {
            logger.error("query areas by param illegal param , request：{},context:{}.", request, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled())
            logger.debug("quering acting by param request:{},context:{}.", request, context);

        try {

            ArrayList<Acting> list = actingQueryByParamEngine.queryActingByParam(request, context);

            if (logger.isDebugEnabled())
                logger.debug("query areas by param success ,request:{},context:{},response:{}.", request, context, list);

            if (null == list || list.size() == 0) {
                logger.info("query result is null.");
                return new Result<ArrayList<ActingModel>>();
            }

            ArrayList<ActingModel> result = actingsConverter.convert(list, context);

            return new Result<ArrayList<ActingModel>>(result);

        } catch (Throwable t) {

            logger.error("query areas by param fail ,request:{},context:{}.", request, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

}
