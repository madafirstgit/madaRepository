package com.pzj.base.common.global.sku;

/**
 * @author zhengxw
 */
public enum ProductVisibility {
    ALL("*", "任何人可见"),
    STAFF("S", "员工"),
    PACKAGE("P", "只在打包产品中显示");

    String code, memo;

    ProductVisibility(String code, String memo){
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
