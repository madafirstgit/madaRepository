package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum AttrVisibility {
    ALL("all", "所有人"),
    STAFF("staff", "员工"),
    HIDDEN("hidden", "对所有人隐藏");

    String code, memo;

    AttrVisibility(String code, String memo) {
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
