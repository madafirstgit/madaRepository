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
 * @version $Id: AreaScreeningsRelStateException.java, v 0.1 2016年8月24日 下午4:19:35 Administrator Exp $
 */
public class AreaScreeningsRelStateException extends StockException {

    private static final long serialVersionUID = 2823228467480898792L;

    public AreaScreeningsRelStateException(String message) {
        super(message);
        initParam();
    }

    public AreaScreeningsRelStateException(String message, Throwable e) {
        super(message, e);
        initParam();
    }

    private void initParam() {
        this.setErrCode(ActingExceptionCode.AREA_SCREEINGS_STATE_ERR_CODE);
        this.setErrMsg(ActingExceptionCode.AREA_SCREEINGS_STATE_ERR_MSG);
    }
}
