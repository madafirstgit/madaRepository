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
 * @version $Id: NoExistBatchLockStockRecordException.java, v 0.1 2016年8月10日 上午10:15:28 Administrator Exp $
 */
public class NoExistBatchLockStockRecordException extends StockException {

    private static final long serialVersionUID = -1255323517914104402L;

    public NoExistBatchLockStockRecordException(String message) {
        super(message);
        initParam();
    }

    /**
     * @param error
     * @param cause
     */
    public NoExistBatchLockStockRecordException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.NOTEXIST_BATCH_LOCK_STOCK_ERR_CODE);
        this.setErrMsg(StockExceptionCode.NOTEXIST_BATCH_LOCK_STOCK_ERR_MSG);
    }
}
