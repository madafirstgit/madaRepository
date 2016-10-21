package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum Allocation {
    DAY("D", "天"),
    NIGHT("N", "晚"),
    TEN_MINUTE("10M", "10分钟"),
    FIFTEEN_MINUTE("15M", "15分钟"),
    TWENTY_MINUTE("20M", "20分钟"),
    THIRTY_MINUTE("30M", "30分钟"),
    HOUR("H", "小时"),
    TIMESLOT("TS", "时间段");

    String code, memo;

    Allocation(String code, String memo){
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
