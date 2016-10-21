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
 * @version $Id: NotFoundStockRecordException.java, v 0.1 2016年8月5日 上午10:05:38 Administrator Exp $
 */
public class NotFoundStockRecordException extends StockException {

    private static final long serialVersionUID = -145572626995565658L;

    public NotFoundStockRecordException(String message) {
        super(message);
        initParam();
    }

    public NotFoundStockRecordException(String message, Throwable e) {
        super(message, e);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.NOT_FOUND_STOCK_RECORD_ERR_CODE);
        this.setErrMsg(StockExceptionCode.NOT_FOUND_STOCK_RECORD_ERR_MSG);
    }
}
