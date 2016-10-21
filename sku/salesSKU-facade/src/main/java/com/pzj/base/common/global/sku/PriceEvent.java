package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum PriceEvent {
    SPECIAL("SP", "特殊事件"),
    SEASONAL("SE", "季节事件");

    String code, memo;

    PriceEvent(String code, String memo) {
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
