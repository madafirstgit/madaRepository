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
 * @version $Id: ReleaseNumException.java, v 0.1 2016年8月5日 上午9:52:50 Administrator Exp $
 */
public class ReleaseNumException extends StockException {

    private static final long serialVersionUID = -1170055332485879729L;

    /**
     * @param error
     */
    public ReleaseNumException(String message) {
        super(message);
        initParam();
    }

    public ReleaseNumException(String message, Throwable e) {
        super(message, e);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.RELEASE_STOCK_NUM_ERR_CODE);
        this.setErrMsg(StockExceptionCode.RELEASE_STOCK_NUM_ERR_MSG);
    }
}
