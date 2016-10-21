package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum PackageType {
    GROUP("G", "组合产品"),
    EXTEND("P", "父子产品");

    String code, memo;

    PackageType(String code, String memo) {
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
