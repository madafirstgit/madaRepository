/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.seat;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.SeatExceptionCode;

/**
 * 
 * @author Administrator
 * @version $Id: SeatChartDataErrorException.java, v 0.1 2016年8月10日 上午11:18:58 Administrator Exp $
 */
public class SeatChartDataErrorException extends StockException {

    private static final long serialVersionUID = 3254547280719943339L;

    public SeatChartDataErrorException(String message) {
        super(message);
        initParam();
    }

    /**
     * @param error
     * @param cause
     */
    public SeatChartDataErrorException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(SeatExceptionCode.SEAT_CHART_DATA_ERR_CODE);
        this.setErrMsg(SeatExceptionCode.SEAT_CHART_DATA_ERR_MSG);
    }
}
