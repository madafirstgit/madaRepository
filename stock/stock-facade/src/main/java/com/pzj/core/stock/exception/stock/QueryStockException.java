package com.pzj.core.stock.exception.stock;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;

/**
 * 库存查询异常.
 * @author YRJ
 *
 */
public class QueryStockException extends StockException {

    private static final long serialVersionUID = 4866241544384054781L;

    public QueryStockException(String message) {
        super(message);
        initParam();
    }

    public QueryStockException(String message, Throwable cause) {
        super(message, cause);
        initParam();
    }

    private void initParam() {
        this.setErrCode(StockExceptionCode.STOCK_QUERY_ERR_CODE);
        this.setErrMsg(StockExceptionCode.STOCK_QUERY_ERR_MSG);
    }
}
