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
import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.product.acting.ActingQueryByParamEngine;
import com.pzj.core.product.actingproduct.ActingProductCreateEngine;
import com.pzj.core.product.actingproduct.QueryActProInfoEngine;
import com.pzj.core.product.actingproduct.QueryActProRelAllInfoEngine;
import com.pzj.core.product.actingproduct.QueryActProScreeningsEngine;
import com.pzj.core.product.actingproduct.QueryInfoForCreateActingProductEngine;
import com.pzj.core.product.actingproduct.QueryInfoForSkuProductEngine;
import com.pzj.core.product.area.AreaQueryByParamEngine;
import com.pzj.core.product.converter.ActingsConverter;
import com.pzj.core.product.converter.AreaScreeingsRelsConverter;
import com.pzj.core.product.converter.AreasConverter;
import com.pzj.core.product.converter.ScreeingsesConverter;
import com.pzj.core.product.entity.Acting;
import com.pzj.core.product.entity.Area;
import com.pzj.core.product.entity.AreaScreeingsRel;
import com.pzj.core.product.entity.Screeings;
import com.pzj.core.product.model.ActingModel;
import com.pzj.core.product.model.ActingProductModel;
import com.pzj.core.product.model.ActingProductQueryRequstModel;
import com.pzj.core.product.model.AreaModel;
import com.pzj.core.product.model.AreaScreeingsRelModel;
import com.pzj.core.product.model.ProScreeningsQueryModel;
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.core.product.model.ThreeDulpe;
import com.pzj.core.product.screeings.ScreeingsQueryByParamEngine;
import com.pzj.core.product.service.ActingProductService;
import com.pzj.core.product.validator.actingproduct.CreatActingProductValidator;
import com.pzj.core.product.validator.actingproduct.QueryActProInfoValidator;
import com.pzj.core.product.validator.actingproduct.QueryInfoValidator;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;
import com.pzj.framework.toolkit.Check;

/**
 * 
 * @author dongchunfu
 * @version $Id: ActingProductServiceImpl.java, v 0.1 2016年8月8日 下午4:23:05 dongchunfu Exp $
 */
@Service(value = "actingProductService")
public class ActingProductServiceImpl implements ActingProductService {

    private static final Logger                   logger = LoggerFactory.getLogger(ActingProductServiceImpl.class);

    @Resource(name = "actingProductCreateEngine")
    private ActingProductCreateEngine             actingProductCreateEngine;

    @Resource(name = "actingQueryByParamEngine")
    private ActingQueryByParamEngine              actingQueryByParamEngine;
    @Resource(name = "areaQueryByParamEngine")
    private AreaQueryByParamEngine                areaQueryByParamEngine;
    @Resource(name = "screeingsQueryByParamEngine")
    private ScreeingsQueryByParamEngine           screeingsQueryByParamEngine;
    @Resource(name = "queryInfoForCreateActingProductEngine")
    private QueryInfoForCreateActingProductEngine queryInfoForCreateActingProductEngine;
    @Resource(name = "queryInfoForSkuProductEngine")
    private QueryInfoForSkuProductEngine          queryInfoForSkuProductEngine;
    @Resource(name = "queryActProInfoEngine")
    private QueryActProInfoEngine                 queryActProInfoEngine;
    @Resource(name = "queryActProScreeningsEngine")
    private QueryActProScreeningsEngine           queryActProScreeningsEngine;
    @Resource(name = "queryActProRelAllInfoEngine")
    private QueryActProRelAllInfoEngine           queryActProRelAllInfoEngine;

    @Resource(name = "queryInfoValidator")
    private QueryInfoValidator                    queryInfoValidator;
    @Resource(name = "creatActingProductValidator")
    private CreatActingProductValidator           creatActingProductValidator;
    @Resource(name = "queryActProInfoValidator")
    private QueryActProInfoValidator              queryActProInfoValidator;

    @Resource(name = "areaScreeingsRelsConverter")
    private AreaScreeingsRelsConverter            areaScreeingsRelsConverter;
    @Resource(name = "screeingsesConverter")
    private ScreeingsesConverter                  screeingsesConverter;
    @Resource(name = "areasConverter")
    private AreasConverter                        areasConverter;
    @Resource(name = "actingsConverter")
    private ActingsConverter                      actingsConverter;

    /** 
     * @see com.pzj.core.product.service.ActingProductService#createActingProduct(com.pzj.core.product.model.AreaScreeingsRelModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<Integer> createActingProduct(ActingProductModel model, ServiceContext context) {

        Boolean success = creatActingProductValidator.convert(model, context);
        if (!success) {
            logger.warn(" illegal param , request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("creating acting product , request:{},context:{}.", model, context);
        }

        try {
            Integer count = actingProductCreateEngine.insertActingProduct(model, context);
            if (logger.isDebugEnabled()) {
                logger.debug("create acting product success, request:{},context:{},response:{}.", model, context, count);
            }
            return new Result<Integer>(count);

        } catch (Throwable t) {

            logger.error("create acting product fail , request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }

    }

    /** 
     * @see com.pzj.core.product.service.ActingProductService#queryActingInfoByIds(com.pzj.core.product.model.ActingQueryRequestModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ArrayList<AreaScreeingsRelModel>> queryInfoForSkuProduct(ActingProductQueryRequstModel model, ServiceContext context) {

        Boolean success = queryInfoValidator.convert(model, context);
        if (!success) {
            logger.warn(" illegal param , request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering info by supplierId and scenicId , request:{},context:{}.", model, context);
        }

        try {
            ArrayList<AreaScreeingsRel> list = queryInfoForSkuProductEngine.selectInfoForSkuProductEngine(model, context);

            ArrayList<AreaScreeingsRelModel> convert = areaScreeingsRelsConverter.convert(list, context);

            return new Result<ArrayList<AreaScreeingsRelModel>>(convert);

        } catch (Throwable t) {

            logger.error("query info for sku product fail , request:{},context:{}.", model, context, t);

            if (t instanceof ServiceException) {
                throw (ServiceException) t;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

    /** 
     * @see com.pzj.core.product.service.ActingProductService#queryInfoForCreateActingProduct(com.pzj.core.product.model.ActingProductQueryRequstModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ActingProductModel> queryInfoForCreateActingProduct(ActingProductQueryRequstModel model, ServiceContext context) {

        Boolean success = queryInfoValidator.convert(model, context);
        if (!success) {
            logger.warn(" illegal param , request：{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering info by supplierId and scenicId , request:{},context:{}.", model, context);
        }

        try {
            ThreeDulpe<ArrayList<Acting>, ArrayList<Screeings>, ArrayList<Area>> result = queryInfoForCreateActingProductEngine.selectInfoForSkuProductEngine(
                model, context);

            ArrayList<ScreeingsModel> screeingsModels = screeingsesConverter.convert(result.getE(), context);
            ArrayList<ActingModel> actingModels = actingsConverter.convert(result.getT(), context);
            ArrayList<AreaModel> areaModels = areasConverter.convert(result.getF(), context);
            ActingProductModel apm = new ActingProductModel();
            apm.setActings(actingModels);
            apm.setAreas(areaModels);
            apm.setScreeingses(screeingsModels);
            return new Result<ActingProductModel>(apm);

        } catch (Throwable t) {

            logger.error("query info for create acting product fail , request:{},context:{}.", model, context, t);
            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

    /** 
     * @see com.pzj.core.product.service.ActingProductService#queryActProInfo(com.pzj.core.product.model.ActingProductQueryRequstModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ActingProductModel> queryActProInfo(ActingProductQueryRequstModel model, ServiceContext context) {

        Boolean success = queryActProInfoValidator.convert(model, context);
        if (!success) {
            logger.error(" illegal param ,when query acting product,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("quering acting prodct ,request:{},context:{}.", model, context);
        }

        try {

            ActingProductModel apm = queryActProInfoEngine.qureyActProInfo(model, context);

            return new Result<ActingProductModel>(apm);

        } catch (Throwable t) {

            logger.error("query acting product failed , request:{},context:{}.", model, context, t);

            throw t instanceof ServiceException ? (ServiceException) t : new StockException(StockExceptionCode.STOCK_ERR_MSG, t);
        }
    }

    /** 
     * @see com.pzj.core.product.service.ActingProductService#queryScreeningsByActProductId(com.pzj.core.product.model.ProScreeningsQueryModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<ScreeingsModel> queryScreeningsByActProductId(ProScreeningsQueryModel model, ServiceContext context) {
        if (Check.NuNObject(model) || CommonUtils.checkLongIsNull(model.getActProId(), true)) {
            logger.error("query screenings by actProductid fail, Illegal params. request: {}, context: {}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query screenings by actProductid. request: {}, context: {}.", model, context);
        }

        Result<ScreeingsModel> result = new Result<ScreeingsModel>();
        try {
            ScreeingsModel screeingsModel = queryActProScreeningsEngine.queryActProScreenings(model);
            if (null != screeingsModel) {
                result.setData(screeingsModel);
            }
        } catch (Throwable e) {
            logger.error("query screenings by actProductid fail. request: " + model + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query screenings by actProductid. request: {}, context: {}.", model, context);
        }

        return result;
    }

    /** 
     * @see com.pzj.core.product.service.ActingProductService#queryAreaScreeRelByProAct(com.pzj.core.product.model.ProScreeningsQueryModel, com.pzj.framework.context.ServiceContext)
     */
    @Override
    public Result<AreaScreeingsRelModel> queryAreaScreeRelByProAct(ActingProductQueryRequstModel model, ServiceContext context) {
        boolean legal = queryActProInfoValidator.convert(model, context);
        if (!legal) {
            logger.error("illegal param ,when query occupy seat area scree rel product,request:{},context:{}.", model, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("query occupy seat area scree rel product. request: {}, context: {}.", model, context);
        }

        Result<AreaScreeingsRelModel> result = new Result<AreaScreeingsRelModel>();
        try {
            AreaScreeingsRelModel areaScreeRelAllInfo = queryActProRelAllInfoEngine.queryOccupySeatActProRel(model);
            if (null != areaScreeRelAllInfo) {
                result.setData(areaScreeRelAllInfo);
            }
        } catch (Throwable e) {
            logger.error("query occupy seat area scree rel product fail. request: " + model + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query occupy seat area scree rel product. request: {}, context: {}.", model, context);
        }

        return result;
    }
}
