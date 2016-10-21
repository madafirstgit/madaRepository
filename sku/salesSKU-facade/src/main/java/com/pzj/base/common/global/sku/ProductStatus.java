package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum ProductStatus {
    ENABLE(10, "可用"),
    DISABLE(20, "不可用"),
    ARCHIVE(30, "存档");


    int code;
    String memo;

    ProductStatus(int code, String memo) {
        this.code = code;
        this.memo = memo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
