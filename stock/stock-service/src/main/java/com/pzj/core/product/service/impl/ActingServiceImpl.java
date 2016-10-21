/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.exception.StockException;
import com.pzj.core.product.acting.ActingCreateEngine;
import com.pzj.core.product.acting.ActingUpdateEngine;
import com.pzj.core.product.acting.AddActingEngine;
import com.pzj.core.product.model.ActingModel;
import com.pzj.core.product.model.AddActingModel;
import com.pzj.core.product.service.ActingService;
import com.pzj.core.product.validator.acting.AddActingValidator;
import com.pzj.core.product.validator.acting.CreateActingValidator;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;
import com.pzj.framework.toolkit.Check;

/**
 * 演绎写服务实现
 * @author dongchunfu
 * @version $Id: ActingServiceImpl.java, v 0.1 2016年8月1日 下午3:09:07 dongchunfu Exp $
 */
@Service(value = "actingService")
public class ActingServiceImpl implements ActingService {
    private static final Logger   logger = LoggerFactory.getLogger(ActingServiceImpl.class);

    @Resource(name = "actingCreateEngine")
    private ActingCreateEngine    actingCreateEngine;
    @Resource(name = "actingUpdateEngine")
    private ActingUpdateEngine    actingUpdateEngine;
    @Resource(name = "addActingEngine")
    private AddActingEngine       addActingEngine;

    @Resource(name = "createActingValidator")
    private CreateActingValidator createActingValidator;
    @Resource(name = "addActingValidator")
    private AddActingValidator    addActingValidator;

    /** 
     * @see com.pzj.stock.service.product.ActingService#createActing(com.pzj.stock.vo.product.ActingModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Long> createActing(ActingModel model, ServiceContext context) {
        Boolean success = createActingValidator.convert(model, context);
        if (!success) {
            logger.warn("create acting illegal param , request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("creating acting ,request：{},context:{}.", model, context);
        }
        try {

            Long count = actingCreateEngine.insertActing(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug("create acting success , request：{},context:{},response:{}.", model, context, count);
            }
            return new Result<Long>(count);

        } catch (Throwable t) {

            logger.error("create acting fail ,request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

    }

    /** 
     * @see com.pzj.stock.service.product.ActingService#updateActing(com.pzj.stock.vo.product.ActingModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Integer> updateActing(ActingModel model, ServiceContext context) {

        if (Check.NuNObject(model, context)) {
            logger.warn("update acting param error, request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("updating acting ,request：{},context:{}.", model, context);
        }

        try {

            Integer count = actingUpdateEngine.updateActing(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug("create acting success , request：{},context:{},response:{}.", model, context, count);
            }
            return new Result<Integer>(count);

        } catch (Throwable t) {

            logger.error("create acting fail ,request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

    /** 
     * @see com.pzj.core.product.service.ActingService#addActing(com.pzj.core.product.model.AddActingModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Boolean> addActing(AddActingModel model, ServiceContext serviceContext) {
        boolean legality = addActingValidator.convert(model, serviceContext);
        if (!legality) {
            logger.warn("add acting fail, Illegal params. request: {}, context: {}.", model, serviceContext);

            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("add acting. request: {}, context: {}.", model, serviceContext);
        }
        boolean flag = true;
        try {
            flag = addActingEngine.addActing(model);
        } catch (Throwable e) {
            logger.error("add acting fail. request: " + model + ", context: " + serviceContext, e);

            if (e instanceof ServiceException) {
                throw e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("add acting success. request: {}, context: {}.", model, serviceContext);
        }

        return new Result<Boolean>(flag);
    }

}
