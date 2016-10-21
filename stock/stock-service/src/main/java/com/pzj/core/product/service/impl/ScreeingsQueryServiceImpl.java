/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.exception.StockException;
import com.pzj.core.product.converter.ScreeingsConverter;
import com.pzj.core.product.converter.ScreeingsesConverter;
import com.pzj.core.product.entity.Screeings;
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.core.product.model.ScreeingsQueryRequestModel;
import com.pzj.core.product.screeings.ScreeingsQueryByIdEngine;
import com.pzj.core.product.screeings.ScreeingsQueryByParamEngine;
import com.pzj.core.product.service.ScreeingsQueryService;
import com.pzj.core.product.validator.screeings.QueryScreeingsByIdValidator;
import com.pzj.core.product.validator.screeings.QueryScreeingsByParamValidator;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;

/**
 * 演绎场次读服务实现
 * 
 * @author dongchunfu
 * @version $Id: ScreeingsQueryServiceImpl.java, v 0.1 2016年8月1日 下午2:45:54 dongchunfu Exp $
 */
@Service(value = "screeingsQueryService")
public class ScreeingsQueryServiceImpl implements ScreeingsQueryService {

    private static final Logger            logger = LoggerFactory.getLogger(ScreeingsQueryServiceImpl.class);

    @Resource(name = "screeingsQueryByIdEngine")
    private ScreeingsQueryByIdEngine       screeingsQueryByIdEngine;
    @Resource(name = "screeingsQueryByParamEngine")
    private ScreeingsQueryByParamEngine    screeingsQueryByParamEngine;

    @Resource(name = "screeingsesConverter")
    private ScreeingsesConverter           screeingsesConverter;
    @Resource(name = "screeingsConverter")
    private ScreeingsConverter             screeingsConverter;
    @Resource(name = "queryScreeingsByIdValidator")
    private QueryScreeingsByIdValidator    QueryScreeingsByIdValidator;
    @Resource(name = "queryScreeingsByParamValidator")
    private QueryScreeingsByParamValidator queryScreeingsByParamValidator;

    /** 
     * @see com.pzj.stock.service.product.ScreeingsQueryService#queryScreeingsById(com.pzj.stock.model.AreaQueryRequestBean, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ScreeingsModel> queryScreeingsById(ScreeingsQueryRequestModel model, ServiceContext context) {

        if (!QueryScreeingsByIdValidator.convert(model, context)) {
            logger.error("query screeings by id error ,request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering screeings by id ,request:{},context:{}.", model, context);
        }

        try {
            Long screeingsId = model.getScreeingsId();
            Screeings screeings = screeingsQueryByIdEngine.queryScreeingsById(screeingsId);

            if (logger.isDebugEnabled())
                logger.debug(" query screeings by id success , request:{},context:{},response:{}.", model, context, screeings);

            if (null == screeings) {
                logger.info("query result is null.");
                return new Result<ScreeingsModel>();
            }

            ScreeingsModel resultModel = screeingsConverter.convert(screeings, context);

            return new Result<ScreeingsModel>(resultModel);

        } catch (Throwable t) {

            logger.error("query screeings by id fail ,request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

    /** 
     * @see com.pzj.core.product.service.ScreeingsQueryService#queryScreeingsesByParam(com.pzj.core.product.model.ScreeingsQueryRequestModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<ScreeingsModel>> queryScreeingsesByParam(ScreeingsQueryRequestModel model, ServiceContext context) {

        Boolean success = queryScreeingsByParamValidator.convert(model, context);
        if (!success) {
            logger.error("query screeings by param error ,request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering screeings by param ,request:{},context:{}.", model, context);
        }

        try {

            ArrayList<Screeings> list = screeingsQueryByParamEngine.queryScreeingsByParam(model, context);

            if (logger.isDebugEnabled())
                logger.debug(" query screeings by param success , request:{},context:{},response:{}.", model, context, list);

            if (null == list || list.size() == 0) {
                logger.info("query result is null.");
                return new Result<ArrayList<ScreeingsModel>>();
            }

            ArrayList<ScreeingsModel> result = screeingsesConverter.convert(list, context);

            return new Result<ArrayList<ScreeingsModel>>(result);

        } catch (Throwable t) {

            logger.error("query screeings by id fail ,request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

}
