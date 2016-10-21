package com.pzj.core.common.exception;

import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.framework.exception.ServiceException;

/**
 * 库存异常基类.
 * @author YRJ
 *
 */
public class StockException extends ServiceException {

    private static final long serialVersionUID = 7282302020938367713L;

    private int               errCode;
    private String            errMsg;

    public StockException(String message) {
        super(message);
        initParam();
    }

    public StockException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.STOCK_ERR_CODE);
        this.setErrMsg(StockExceptionCode.STOCK_ERR_MSG);
    }
}
