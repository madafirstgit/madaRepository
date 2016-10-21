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
 * @version $Id: LimitedSeatException.java, v 0.1 2016年8月9日 下午5:26:05 Administrator Exp $
 */
public class LimitedSeatException extends StockException {

    private static final long serialVersionUID = 2383642491081796137L;

    public LimitedSeatException(String message) {
        super(message);
        initParam();
    }

    /**
     * @param error
     * @param cause
     */
    public LimitedSeatException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(SeatExceptionCode.MAX_SEAT_NUM_ERR_CODE);
        this.setErrMsg(SeatExceptionCode.MAX_SEAT_NUM_ERR_MSG);
    }
}
