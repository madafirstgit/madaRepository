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
import com.pzj.core.product.area.AreaCreateEngine;
import com.pzj.core.product.area.AreaUpdateEngine;
import com.pzj.core.product.model.AreaModel;
import com.pzj.core.product.service.AreaService;
import com.pzj.core.product.validator.area.CreateAreaValidator;
import com.pzj.core.product.validator.area.UpdateAreaValidator;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;

/**
 * 演绎区域写服务实现
 * @author dongchunfu
 * @version $Id: AreaServiceImpl.java, v 0.1 2016年8月1日 上午10:48:26 dongchunfu Exp $
 */
@Service(value = "areaService")
public class AreaServiceImpl implements AreaService {

    private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

    @Resource(name = "areaCreateEngine")
    private AreaCreateEngine    areaCreateEngine;
    @Resource(name = "areaUpdateEngine")
    private AreaUpdateEngine    areaUpdateEngine;

    @Resource(name = "createAreaValidator")
    private CreateAreaValidator createAreaValidator;
    @Resource(name = "updateAreaValidator")
    private UpdateAreaValidator updateAreaValidator;

    /** 
     * @see com.pzj.stock.service.product.AreaService#createArea(java.awt.geom.Area, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Long> createArea(AreaModel model, ServiceContext context) {

        Boolean success = createAreaValidator.convert(model, context);
        if (!success) {
            logger.warn(" create area illegal param , request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug(" creating area ,request:{},context:{}.", model, context);
        }

        try {

            Long id = areaCreateEngine.createArea(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug(" creating area success ,request:{},context:{},response:{}.", model, context, id);
            }

            return new Result<Long>(id);

        } catch (Throwable t) {

            logger.error("create area fail ,request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

    }

    /** 
     * @see com.pzj.stock.service.product.AreaService#updateArea(java.awt.geom.Area, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Integer> updateArea(AreaModel model, ServiceContext context) {
        Boolean success = updateAreaValidator.convert(model, context);
        if (!success) {
            logger.warn(" update area illegal param , request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug(" updating area ,request:{},context:{}.", model, context);
        }

        try {

            int count = areaUpdateEngine.updateArea(model, context);

            if (logger.isDebugEnabled()) {
                logger.debug(" update area success ,request:{},context:{},response:{}.", model, context, count);
            }
            return new Result<Integer>(count);

        } catch (Throwable t) {

            logger.error("update area fail ,request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

}
