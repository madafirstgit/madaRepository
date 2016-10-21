package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum DynamicPriceType {
    PERCENT("P", "百分比"),
    FIX("F", "固定数");

    String code, memo;

    DynamicPriceType(String code, String memo) {
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
