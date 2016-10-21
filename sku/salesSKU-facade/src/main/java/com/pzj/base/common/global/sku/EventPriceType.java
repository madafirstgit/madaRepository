package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum EventPriceType {
    BASE_PRICE("B", "基础价格"),
    NEW_PRICE("N", "新价格"),
    DYNAMIC_PRICE("D", "动态价格");

    String code, memo;

    EventPriceType(String code, String memo) {
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
