package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum CalendarStatus {
    AVAILABLE("A", "可用"),
    UNAVAILABLE("U", "不可用"),
    DISABLED("D", "禁止");

    String code, memo;

    CalendarStatus(String code, String memo) {
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
