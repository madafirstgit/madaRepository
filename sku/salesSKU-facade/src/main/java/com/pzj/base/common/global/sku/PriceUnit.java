package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum PriceUnit {
    QTY("q", "按数量报价"),
    GROUP("g", "按组报价");

    String code, memo;

    PriceUnit(String code, String memo) {
        this.code = code;
        this.memo = memo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
