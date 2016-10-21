/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.exception;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.product.exception.errorcode.ActingExceptionCode;

/**
 * 
 * 
 * @author dongchunfu
 * @version $Id: NotFoundActingException.java, v 0.1 2016年8月8日 下午7:07:56 dongchunfu Exp $
 */
public class NotFoundAreaScreeingsRelException extends StockException {

    private static final long serialVersionUID = -145572626995565658L;

    public NotFoundAreaScreeingsRelException(String message) {
        super(message);
        initParam();
    }

    public NotFoundAreaScreeingsRelException(String message, Throwable e) {
        super(message, e);
        initParam();
    }

    private void initParam() {
        this.setErrCode(ActingExceptionCode.NOT_FOUND_AREA_SCREEINGS_REL_ERR_CODE);
        this.setErrMsg(ActingExceptionCode.NOT_FOUND_AREA_SCREEINGS_REL_ERR_MSG);
    }
}
