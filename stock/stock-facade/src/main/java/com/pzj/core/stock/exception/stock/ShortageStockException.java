package com.pzj.core.stock.exception.stock;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 库存不足异常.
 * @author YRJ
 *
 */
public class ShortageStockException extends StockException {

    private static final long serialVersionUID = -2633835879610174343L;

    public ShortageStockException(String message) {
        super(message);
        initParam();
    }

    public ShortageStockException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.STOCK_SHORTAGE_ERR_CODE);
        this.setErrMsg(StockExceptionCode.STOCK_SHORTAGE_ERR_MSG);
    }
}
