/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.exception.errorcode;

/**
 * 演艺库存异常code定义
 * 52开头
 * 101~110 库存演艺异常码
 */
public class ActingExceptionCode {

    public static final int    ACTING_STATE_ERR_CODE                 = 52101;
    public static final String ACTING_STATE_ERR_MSG                  = "演艺数据状态不可用";

    public static final int    NOT_FOUND_ACTING_ERR_CODE             = 52102;
    public static final String NOT_FOUND_ACTING_ERR_MSG              = "找不到对应的演绎信息";

    public static final int    NOT_FOUND_AREA_SCREEINGS_REL_ERR_CODE = 52103;
    public static final String NOT_FOUND_AREA_SCREEINGS_REL_ERR_MSG  = "找不到对应的区域及场次信息";

    public static final int    AREA_SCREEINGS_STATE_ERR_CODE         = 52104;
    public static final String AREA_SCREEINGS_STATE_ERR_MSG          = "演艺区域场次对应数据状态不可用";

    public static final int    NOT_FOUND_SCREENINGS_ERR_CODE         = 52105;
    public static final String NOT_FOUND_SCREENINGS_ERR_MSG          = "找不到场次信息";
}
