/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.errcode;

/**
 * 库存异常code定义
 * 52开头
 * 40001 传入参数异常
 * 001~010 全局异常码
 * 011~030 库存异常码
 * 031~040 库存规则异常码
 * 041~060 演艺座位异常码
 */
public class StockExceptionCode {

    public static final int    PARAM_ERR_CODE                     = 40001;
    public static final String PARAM_ERR_MSG                      = "参数错误";

    /*****操作库存相关异常码信息 开始*****/
    public static final int    STOCK_ERR_CODE                     = 52001;
    public static final String STOCK_ERR_MSG                      = "库存服务异常";

    /*****操作库存相关异常码信息 结束*****/

    /*****操作库存相关异常码信息 开始*****/
    public static final int    STOCK_STATE_ERR_CODE               = 52011;
    public static final String STOCK_STATE_ERR_MSG                = "库存状态不可用";

    public static final int    STOCK_SEAT_STATE_ERR_CODE          = 52012;
    public static final String STOCK_SEAT_STATE_ERR_MSG           = "库存座位关联状态不可用";

    public static final int    STOCK_SHORTAGE_ERR_CODE            = 52013;
    public static final String STOCK_SHORTAGE_ERR_MSG             = "锁定库存数不可大于现有库存";

    public static final int    STOCK_QUERY_ERR_CODE               = 52014;
    public static final String STOCK_QUERY_ERR_MSG                = "查询库存数据异常";

    public static final int    NOT_FOUND_STOCK_RECORD_ERR_CODE    = 52015;
    public static final String NOT_FOUND_STOCK_RECORD_ERR_MSG     = "找不到相应库存操作记录";

    public static final int    NOT_FOUND_STOCK_ERR_CODE           = 52016;
    public static final String NOT_FOUND_STOCK_ERR_MSG            = "找不到相应库存数据";

    public static final int    NOTEXIST_BATCH_LOCK_STOCK_ERR_CODE = 52017;
    public static final String NOTEXIST_BATCH_LOCK_STOCK_ERR_MSG  = "不存在批量锁库存记录";

    public static final int    LOCKNUM_OUT_OF_STOCK_ERR_CODE      = 52018;
    public static final String LOCKNUM_OUT_OF_STOCK_ERR_MSG       = "锁库存数量超出库存数量";

    public static final int    MAX_STOCK_NUM_ERR_CODE             = 52019;
    public static final String MAX_STOCK_NUM_ERR_MSG              = "超过库存最大数量";

    public static final int    STOCK_EXPIRE_ERR_CODE              = 52020;
    public static final String STOCK_EXPIRE_ERR_MSG               = "库存已经过期";

    public static final int    RELEASE_STOCK_NUM_ERR_CODE         = 52021;
    public static final String RELEASE_STOCK_NUM_ERR_MSG          = "解锁库存数不可大于已锁库存";

    public static final int    EXIST_BATCH_LOCK_STOCK_ERR_CODE    = 52022;
    public static final String EXIST_BATCH_LOCK_STOCK_ERR_MSG     = "存在批量操作库存数据：";

    public static final int    STOCK_QUERY_DATE_ILLEGAL_ERR_CODE  = 52023;
    public static final String STOCK_QUERY_DATE_ILLEGAL_ERR_MSG   = "库存查询日期格式不合法";
}
