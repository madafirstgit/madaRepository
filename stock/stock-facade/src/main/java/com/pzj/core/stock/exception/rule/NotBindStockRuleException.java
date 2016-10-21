package com.pzj.core.stock.exception.rule;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockRuleExceptionCode;

/**
 * 库存不存在异常.
 * @author YRJ
 *
 */
public class NotBindStockRuleException extends StockException {

    private static final long serialVersionUID = -5519133143607923777L;

    public NotBindStockRuleException(String message) {
        super(message);
        initParam();
    }

    public NotBindStockRuleException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockRuleExceptionCode.NOT_BIND_PRODUCT_ERR_CODE);
        this.setErrMsg(StockRuleExceptionCode.NOT_BIND_PRODUCT_ERR_MSG);
    }
}
