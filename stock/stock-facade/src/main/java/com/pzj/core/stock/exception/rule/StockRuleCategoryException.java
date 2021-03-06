/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.rule;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockRuleExceptionCode;

/**
 * 
 * 
 * @author dongchunfu
 * @version $Id: StockRuleCategoryException.java, v 0.1 2016年8月17日 下午3:59:47 dongchunfu Exp $
 */
public class StockRuleCategoryException extends StockException {

    private static final long serialVersionUID = 5660693517911893191L;

    public StockRuleCategoryException(String message) {
        super(message);
        initParam();
    }

    public StockRuleCategoryException(String message, Throwable e) {
        super(message, e);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockRuleExceptionCode.CATEGORY_NOTEXIST_ERR_CODE);
        this.setErrMsg(StockRuleExceptionCode.CATEGORY_NOTEXIST_ERR_MSG);
    }
}
