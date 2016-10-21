package com.pzj.core.stock.exception.stock;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 库存上限异常.
 * @author YRJ
 *
 */
public class LimitedException extends StockException {

    private static final long serialVersionUID = 5037812024120051144L;

    public LimitedException(String message) {
        super(message);
        initParam();
    }

    public LimitedException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.MAX_STOCK_NUM_ERR_CODE);
        this.setErrMsg(StockExceptionCode.MAX_STOCK_NUM_ERR_MSG);
    }
}
