package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum SkuParentChild {
    PARENT("P","父产品"),
    CHILD("C","子产品");

    String code, memo;

    SkuParentChild(String code, String memo) {
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
