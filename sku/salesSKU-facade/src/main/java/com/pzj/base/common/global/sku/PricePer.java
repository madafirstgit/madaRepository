package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum PricePer {
    BOOKING("B", "每订单"),
    DAY("24H", "每24小时"),
    UNIT("U", "分配单位");

    String code, memo;

    PricePer(String code, String memo) {
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
