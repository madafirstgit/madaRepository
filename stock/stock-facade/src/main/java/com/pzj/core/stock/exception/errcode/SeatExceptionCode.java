/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.exception.errcode;

/**
 * 
 * @author Administrator
 * @version $Id: SeatExceptionCode.java, v 0.1 2016年8月23日 上午11:33:44 Administrator Exp $
 */
public class SeatExceptionCode {

    public static final int    UNABLE_RELEASE_SEAT_ERR_CODE        = 52041;
    public static final String UNABLE_RELEASE_SEAT_ERR_MSG         = "不能释放座位";

    public static final int    SEAT_CHART_DATA_ERR_CODE            = 52042;
    public static final String SEAT_CHART_DATA_ERR_MSG             = "录入座位图数据有误";

    public static final int    REPEAT_OCCUPY_SEAT_ERR_CODE         = 52043;
    public static final String REPEAT_OCCUPY_SEAT_ERR_MSG          = "业务重复占座";

    public static final int    NOT_FOUND_RELEASE_SEAT_ERR_CODE     = 52044;
    public static final String NOT_FOUND_RELEASE_SEAT_ERR_MSG      = "没找到释放的座位";

    public static final int    NOT_FOUND_SEAT_ERR_CODE             = 52046;
    public static final String NOT_FOUND_SEAT_ERR_MSG              = "找不到对应的座位";

    public static final int    NOT_FOUND_SEAT_CHART_ERR_CODE       = 52047;
    public static final String NOT_FOUND_SEAT_CHART_ERR_MSG        = "找不到对应的座位图";

    public static final int    MAX_SEAT_NUM_ERR_CODE               = 52048;
    public static final String MAX_SEAT_NUM_ERR_MSG                = "超过可选座位最大数量";

    public static final int    NOT_RELEASE_SEAT_ERR_CODE           = 52049;
    public static final String NOT_RELEASE_SEAT_ERR_MSG            = "不能释放座位列表：";

    public static final int    NOT_OCCUPY_SEAT_ERR_CODE            = 52050;
    public static final String NOT_OCCUPY_SEAT_ERR_MSG             = "不能占用座位列表：";

    public static final int    NOT_OPERATE_RELEASE_SEAT_ERR_CODE   = 52051;
    public static final String NOT_OPERATE_RELEASE_SEAT_ERR_MSG    = "不能操作释放座位";

    public static final int    OCCUPY_SEAT_BUSSINESS_TYPE_ERR_CODE = 52052;
    public static final String OCCUPY_SEAT_BUSSINESS_TYPE_ERR_MSG  = "不能操作释放座位";

}
