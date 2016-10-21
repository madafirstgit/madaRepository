/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.context.UserSeatResponse;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.model.ParamModel;
import com.pzj.core.stock.model.SeatModel;
import com.pzj.core.stock.model.UserSeatModel;
import com.pzj.core.stock.seat.CreateSeatEngine;
import com.pzj.core.stock.seat.UserSeatQueryEngine;
import com.pzj.core.stock.service.SeatService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;
import com.pzj.framework.exception.ServiceException;

/**
 * 
 * @author Administrator
 * @version $Id: SeatServiceImpl.java, v 0.1 2016年8月4日 下午5:10:33 Administrator Exp $
 */
@Service("seatService")
public class SeatServiceImpl implements SeatService {
    private static final Logger                                        logger = LoggerFactory.getLogger(SeatServiceImpl.class);
    @Resource(name = "seatValidator")
    private ObjectConverter<SeatModel, Void, Boolean>                  seatValidator;
    @Resource(name = "userSeatValidator")
    private ObjectConverter<UserSeatModel, ServiceContext, ParamModel> userSeatValidator;

    @Resource(name = "createSeatEngine")
    private CreateSeatEngine                                           createSeatEngine;
    @Resource(name = "userSeatQueryEngine")
    private UserSeatQueryEngine                                        userSeatQueryEngine;

    @Override
    public void createSeat(SeatModel seatModel, ServiceContext context) {
        boolean legality = seatValidator.convert(seatModel, null);
        if (!legality) {
            logger.error("create seat fail, Illegal params. request: {}, context: {}.", seatModel, context);
            throw new ParameterErrorException(StockExceptionCode.PARAM_ERR_MSG);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("create seat. request: {}, context: {}.", seatModel, context);
        }

        try {
            createSeatEngine.createSeat(seatModel);
        } catch (Throwable e) {
            logger.error("create seat fail. request: " + seatModel + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("create seat success. request: {}, context: {}.", seatModel, context);
        }
    }

    @Override
    public Result<UserSeatResponse> queryAlreadyOccupySeat(UserSeatModel userSeatModel, ServiceContext context) {
        ParamModel paramModel = userSeatValidator.convert(userSeatModel, null);
        if (!paramModel.paramIsOk()) {
            logger.error("query already occupy seat fail, Illegal params. request: {}, context: {}.", userSeatModel, context);
            throw new ParameterErrorException(paramModel.getParamErrorMsg());
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query already occupy seat. request: {}, context: {}.", userSeatModel, context);
        }

        Result<UserSeatResponse> result = new Result<UserSeatResponse>();
        try {
            List<String> userOccupySeatList = userSeatQueryEngine.queryOccupySeats(userSeatModel);

            //封装返回对象
            UserSeatResponse userSeatResponse = new UserSeatResponse();
            userSeatResponse.setOccupySeat(userOccupySeatList);
            result.setData(userSeatResponse);
        } catch (Throwable e) {
            logger.error("query already occupy seat fail. request: " + userSeatModel + ", context: " + context, e);

            if (e instanceof ServiceException) {
                throw e;
            }
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("query already occupy seat success. request: {}, context: {}.", userSeatModel, context);
        }

        return result;
    }
}
