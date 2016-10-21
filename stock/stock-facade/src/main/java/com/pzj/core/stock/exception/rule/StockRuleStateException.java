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
 * @version $Id: StockRuleStateException.java, v 0.1 2016年8月29日 下午3:40:31 Administrator Exp $
 */
public class StockRuleStateException extends StockException {
    private static final long serialVersionUID = 5052127223956241546L;

    public StockRuleStateException(String message) {
        super(message);
        initParam();
    }

    public StockRuleStateException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockRuleExceptionCode.STOCK_RULE_STATE_ERR_CODE);
        this.setErrMsg(StockRuleExceptionCode.STOCK_RULE_STATE_ERR_MSG);
    }
}
