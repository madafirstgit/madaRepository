/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.errcode;

/**
 * 库存规则异常code定义
 * 52开头
 * 40001 传入参数异常
 * 001~010 全局异常码
 * 011~030 库存异常码
 * 031~040 库存规则异常码
 * 041~060 演艺座位异常码
 */
public class StockRuleExceptionCode {
    public static final int    TYPE_NOTEXIST_ERR_CODE              = 52031;
    public static final String TYPE_NOTEXIST_ERR_MSG               = "库存规则类型不存在";

    public static final int    CATEGORY_NOTEXIST_ERR_CODE          = 52032;
    public static final String CATEGORY_NOTEXIST_ERR_MSG           = "库存规则类别不存在";

    public static final int    RETURN_TYPE_ERR_CODE                = 52033;
    public static final String RETURN_TYPE_ERR_MSG                 = "库存归还类型不匹配";

    public static final int    NOT_FOUND_STOCK_RULE_ERR_CODE       = 52034;
    public static final String NOT_FOUND_STOCK_RULE_ERR_MSG        = "找不到相应库存规则数据";

    public static final int    NOT_BIND_PRODUCT_ERR_CODE           = 52035;
    public static final String NOT_BIND_PRODUCT_ERR_MSG            = "库存规则未绑定产品";

    public static final int    STOCK_RULE_ERR_CODE                 = 52036;
    public static final String STOCK_RULE_ERR_MSG                  = "库存规则异常";

    public static final int    GET_STOCK_RULE_REL_PRODUCT_ERR_CODE = 52037;
    public static final String GET_STOCK_RULE_REL_PRODUCT_ERR_MSG  = "调用产品服务获取库存规则和产品关系异常";

    public static final int    GET_PRODUCT_DATE_ERR_CODE           = 52038;
    public static final String GET_PRODUCT_DATE_ERR_MSG            = "调用产品服务获取产品日期数据异常";

    public static final int    STOCK_RULE_STATE_ERR_CODE           = 52039;
    public static final String STOCK_RULE_STATE_ERR_MSG            = "库存规则状态不可用";

}
