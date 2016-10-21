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
 * @version $Id: AreaScreeingsRelStateException.java, v 0.1 2016年8月9日 上午11:44:57 Administrator Exp $
 */
public class StateException extends StockException {
    private static final long serialVersionUID = 2514946885675571304L;

    public StateException(String message) {
        super(message);
        initParam();
    }

    public StateException(String message, Throwable e) {
        super(message, e);
        initParam();
    }

    private void initParam() {
        this.setErrCode(ActingExceptionCode.ACTING_STATE_ERR_CODE);
        this.setErrMsg(ActingExceptionCode.ACTING_STATE_ERR_MSG);
    }
}
