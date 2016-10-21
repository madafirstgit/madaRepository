package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum priceEventRecurrence {
    ONCE("once", "一次"),
    WEEKLY("weekly", "按周"),
    ALWAYS("always", "一直");

    String code, memo;

    priceEventRecurrence(String code, String memo) {
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
