/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.seat;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.SeatExceptionCode;

/**
 * 
 * @author Administrator
 * @version $Id: CannotOccupySeatException.java, v 0.1 2016年8月9日 下午6:43:58 Administrator Exp $
 */
public class CannotOccupySeatException extends StockException {

    /**  */
    private static final long serialVersionUID = -3434239962882880725L;

    public CannotOccupySeatException(String errMsg) {
        super(SeatExceptionCode.NOT_OCCUPY_SEAT_ERR_MSG + errMsg);
        initParam(errMsg);
    }

    /**
     * @param error
     * @param cause
     */
    public CannotOccupySeatException(String errMsg, Throwable cause) {
        super(SeatExceptionCode.NOT_OCCUPY_SEAT_ERR_MSG + errMsg, cause);
        initParam(errMsg);
    }

    private void initParam(String errMsg) {
        this.setErrCode(SeatExceptionCode.NOT_OCCUPY_SEAT_ERR_CODE);
        this.setErrMsg(SeatExceptionCode.NOT_OCCUPY_SEAT_ERR_MSG + errMsg);
    }

}
