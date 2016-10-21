/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.stock;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 
 * @author Administrator
 * @version $Id: StockSeatRelStateException.java, v 0.1 2016年8月6日 下午2:46:07 Administrator Exp $
 */
public class StockSeatRelStateException extends StockException {

    private static final long serialVersionUID = -3645400955991020791L;

    public StockSeatRelStateException(String message) {
        super(message);
        initParam();
    }

    /**
     * @param error
     * @param cause
     */
    public StockSeatRelStateException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.STOCK_SEAT_STATE_ERR_CODE);
        this.setErrMsg(StockExceptionCode.STOCK_SEAT_STATE_ERR_MSG);
    }
}
