/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service;

import com.pzj.core.stock.context.UserSeatResponse;
import com.pzj.core.stock.model.SeatModel;
import com.pzj.core.stock.model.UserSeatModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author Administrator
 * @version $Id: SeatService.java, v 0.1 2016年8月4日 下午5:11:18 Administrator Exp $
 */
public interface SeatService {
    /**
     * 生成座位
     * @param seatModel
     * @param context
     */
    public void createSeat(SeatModel seatModel, ServiceContext context);

    /**
     * 查找占用的座位
     * @param userSeatModel
     * @param context
     * @return
     */
    public Result<UserSeatResponse> queryAlreadyOccupySeat(UserSeatModel userSeatModel, ServiceContext context);
}
