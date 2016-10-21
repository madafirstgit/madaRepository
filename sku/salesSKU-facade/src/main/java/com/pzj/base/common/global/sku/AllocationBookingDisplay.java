package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum AllocationBookingDisplay {
    BUTTON("button", "按钮"),
    DROPDOWN("dropdown", "下拉");

    String code, memo;

    AllocationBookingDisplay(String code, String memo) {
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
