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
 * @version $Id: QueryStockDateIllegalException.java, v 0.1 2016年8月29日 下午2:37:56 Administrator Exp $
 */
public class QueryStockDateIllegalException extends StockException {
    private static final long serialVersionUID = -4372224406749131923L;

    public QueryStockDateIllegalException(String message) {
        super(message);
        initParam();
    }

    public QueryStockDateIllegalException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.STOCK_QUERY_DATE_ILLEGAL_ERR_CODE);
        this.setErrMsg(StockExceptionCode.STOCK_QUERY_DATE_ILLEGAL_ERR_MSG);
    }
}
