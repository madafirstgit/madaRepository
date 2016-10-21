/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service;

import java.util.ArrayList;

import com.pzj.core.stock.model.SeatChartModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author Administrator
 * @version $Id: SeatChartService.java, v 0.1 2016年8月11日 上午10:50:40 Administrator Exp $
 */
public interface SeatChartService {
    /**
     * 添加座位图
     * @param seatChartModel
     * @param context
     */
    public void addSeatChart(SeatChartModel seatChartModel, ServiceContext context);

    /**
     * 根据景区和区域查询座位图
     * @param seatChartModel
     * @param context
     * @return
     */
    public Result<ArrayList<SeatChartModel>> querySeatChartByScenicAndAreaRel(SeatChartModel seatChartModel, ServiceContext context);

    /**
     * 添加座位图并初始化座位数据
     * @param seatChartModel
     * @param context
     */
    public Result<Boolean> addSeatChartInitSeat(SeatChartModel seatChartModel, ServiceContext context);
}
