package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum PackageInType {
    OPTIONAL("O", "可选"),
    PRESELECT("C", "预选"),
    REQUIRED("R", "必须"),
    REQUIRED_HIDDEN("RH", "必须隐藏");

    String code, memo;

    PackageInType(String code, String memo) {
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
