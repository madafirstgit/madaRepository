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
 * @version $Id: NotFoundSeatException.java, v 0.1 2016年8月9日 下午4:45:25 Administrator Exp $
 */
public class NotFoundSeatException extends StockException {

    private static final long serialVersionUID = 8796871636675914665L;

    public NotFoundSeatException(String message) {
        super(message);
        initParam();
    }

    /**
     * @param error
     * @param cause
     */
    public NotFoundSeatException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(SeatExceptionCode.NOT_FOUND_SEAT_ERR_CODE);
        this.setErrMsg(SeatExceptionCode.NOT_FOUND_SEAT_ERR_MSG);
    }
}
