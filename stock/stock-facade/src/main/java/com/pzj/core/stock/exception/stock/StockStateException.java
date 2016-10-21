package com.pzj.core.stock.exception.stock;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 库存状态异常.
 * @author YRJ
 *
 */
public class StockStateException extends StockException {

    private static final long serialVersionUID = -854553329462532437L;

    public StockStateException(String message) {
        super(message);
        initParam();
    }

    public StockStateException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.STOCK_STATE_ERR_CODE);
        this.setErrMsg(StockExceptionCode.STOCK_STATE_ERR_MSG);
    }
}
