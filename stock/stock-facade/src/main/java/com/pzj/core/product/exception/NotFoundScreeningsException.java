/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.exception;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.product.exception.errorcode.ActingExceptionCode;

/**
 * 
 * @author Administrator
 * @version $Id: NotFoundScreeningsException.java, v 0.1 2016年8月31日 下午4:30:46 Administrator Exp $
 */
public class NotFoundScreeningsException extends StockException {
    private static final long serialVersionUID = -7859643616509697239L;

    public NotFoundScreeningsException(String message) {
        super(message);
        initParam();
    }

    /**
     * @param message
     * @param cause
     */
    public NotFoundScreeningsException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(ActingExceptionCode.NOT_FOUND_SCREENINGS_ERR_CODE);
        this.setErrMsg(ActingExceptionCode.NOT_FOUND_SCREENINGS_ERR_MSG);
    }
}
