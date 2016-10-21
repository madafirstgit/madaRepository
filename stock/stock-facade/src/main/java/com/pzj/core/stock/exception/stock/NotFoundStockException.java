package com.pzj.core.stock.exception.stock;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 库存规则未绑定产品异常
 * @author dongchunfu
 *
 */
public class NotFoundStockException extends StockException {

    private static final long serialVersionUID = -5519133143607923777L;

    public NotFoundStockException(String message) {
        super(message);
        initParam();
    }

    public NotFoundStockException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.NOT_FOUND_STOCK_ERR_CODE);
        this.setErrMsg(StockExceptionCode.NOT_FOUND_STOCK_ERR_MSG);
    }
}
