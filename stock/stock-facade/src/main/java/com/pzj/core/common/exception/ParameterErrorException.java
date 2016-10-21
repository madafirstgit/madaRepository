/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.common.exception;

import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 
 * @author Administrator
 * @version $Id: ParameterErrorException.java, v 0.1 2016年8月3日 上午11:29:13 Administrator Exp $
 */
public class ParameterErrorException extends StockException {

    private static final long serialVersionUID = -8995289669417979986L;

    /**
     * @param error
     */
    public ParameterErrorException(String message) {
        super(message);
        initParam();
    }

    public ParameterErrorException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.PARAM_ERR_CODE);
        this.setErrMsg(StockExceptionCode.PARAM_ERR_MSG);
    }
}
