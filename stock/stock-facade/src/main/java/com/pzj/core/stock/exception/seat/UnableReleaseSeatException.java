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
 * @version $Id: UnableReleaseSeatException.java, v 0.1 2016年8月8日 下午7:24:14 Administrator Exp $
 */
public class UnableReleaseSeatException extends StockException {

    private static final long serialVersionUID = 4595826140960310364L;

    /**
     * @param error
     * @param cause
     */
    public UnableReleaseSeatException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    public UnableReleaseSeatException(String message) {
        super(message);
        initParam();
    }

    private void initParam() {
        this.setErrCode(SeatExceptionCode.NOT_RELEASE_SEAT_ERR_CODE);
        this.setErrMsg(SeatExceptionCode.NOT_RELEASE_SEAT_ERR_MSG);
    }
}
