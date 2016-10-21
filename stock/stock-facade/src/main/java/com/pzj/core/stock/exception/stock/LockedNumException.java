package com.pzj.core.stock.exception.stock;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 库存锁定数量异常.
 * @author YRJ
 *
 */
public class LockedNumException extends StockException {

    private static final long serialVersionUID = 6257522763468339983L;

    public LockedNumException(String message) {
        super(message);
        initParam();
    }

    public LockedNumException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.LOCKNUM_OUT_OF_STOCK_ERR_CODE);
        this.setErrMsg(StockExceptionCode.LOCKNUM_OUT_OF_STOCK_ERR_MSG);
    }
}
