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
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.core.product.screeings.ScreeingsCreateEngine;
import com.pzj.core.product.screeings.ScreeingsUpdateEngine;
import com.pzj.core.product.service.ScreeingsService;
import com.pzj.core.product.validator.screeings.CreateScreeingsValidator;
import com.pzj.core.product.validator.screeings.UpdateScreeingsValidator;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;

/**
 * 演绎场次写服务实现
 * @author dongchunfu
 * @version $Id: AreaServiceImpl.java, v 0.1 2016年8月1日 上午10:48:26 dongchunfu Exp $
 */
@Service(value = "screeingsService")
public class ScreeingsServiceImpl implements ScreeingsService {

    private static final Logger      logger = LoggerFactory.getLogger(ScreeingsServiceImpl.class);

    @Resource(name = "screeingsCreateEngine")
    private ScreeingsCreateEngine    screeingsCreateEngine;
    @Resource(name = "screeingsUpdateEngine")
    private ScreeingsUpdateEngine    screeingsUpdateEngine;

    @Resource(name = "createScreeingsValidator")
    private CreateScreeingsValidator createScreeingsValidator;
    @Resource(name = "updateScreeingsValidator")
    private UpdateScreeingsValidator updateScreeingsValidator;

    /** 
     * @see com.pzj.stock.service.product.ScreeingsService#createScreeings(com.pzj.stock.vo.product.ScreeingsModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Long> createScreeings(ScreeingsModel model, ServiceContext context) {
        Boolean success = createScreeingsValidator.convert(model, context);
        if (!success) {
            logger.warn("create screeings illegal param, request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("creating screeings ,request：{},context:{}.", model, context);
        }
        try {
            Long id = screeingsCreateEngine.insertScreeings(model, context);
            if (logger.isDebugEnabled()) {
                logger.debug("creating screeings success ,request：{},context:{},response:{}.", model, context, id);
            }
            return new Result<Long>(id);
        } catch (Throwable t) {

            logger.error("create acting fail ,request:{},context:{}.", model, context, t);
            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

    }

    /** 
     * @see com.pzj.stock.service.product.ScreeingsService#updateArea(com.pzj.stock.vo.product.ScreeingsModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Integer> updateScreeings(ScreeingsModel model, ServiceContext context) {
        if (!updateScreeingsValidator.convert(model, context)) {
            logger.warn("update screeings error, request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }
        if (logger.isDebugEnabled()) {
            logger.debug(" updating screeings success ,request:{},context:{}.", model, context);
        }
        try {
            int count = screeingsUpdateEngine.updateScreeings(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug(" update screeings success ,request:{},context:{},response:{}.", model, context, count);
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

}
