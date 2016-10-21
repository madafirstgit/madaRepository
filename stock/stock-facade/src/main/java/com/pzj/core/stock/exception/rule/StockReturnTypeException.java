/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.rule;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockRuleExceptionCode;

/**
 * 
 * @author Administrator
 * @version $Id: StockReturnTypeException.java, v 0.1 2016年8月3日 下午6:53:34 Administrator Exp $
 */
public class StockReturnTypeException extends StockException {

    private static final long serialVersionUID = -7958104188015299937L;

    public StockReturnTypeException(String message) {
        super(message);
        initParam();
    }

    public StockReturnTypeException(String message, Throwable e) {
        super(message, e);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockRuleExceptionCode.RETURN_TYPE_ERR_CODE);
        this.setErrMsg(StockRuleExceptionCode.RETURN_TYPE_ERR_MSG);
    }
}
