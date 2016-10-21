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
 * @version $Id: StockExpiredException.java, v 0.1 2016年8月17日 下午5:16:30 Administrator Exp $
 */
public class StockExpiredException extends StockException {
    private static final long serialVersionUID = 4764252585707909065L;

    public StockExpiredException(String message) {
        super(message);
        initParam();
    }

    public StockExpiredException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.STOCK_EXPIRE_ERR_CODE);
        this.setErrMsg(StockExceptionCode.STOCK_EXPIRE_ERR_MSG);
    }
}
