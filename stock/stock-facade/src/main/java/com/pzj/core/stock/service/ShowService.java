package com.pzj.core.stock.service;

import com.pzj.core.stock.context.ShowResponse;
import com.pzj.core.stock.model.ShowModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

public interface ShowService {
    /**
     * 占座
     * @param showVO
     * @param serviceContext
     * @return
     */
    public void occupySeat(ShowModel showModel, ServiceContext serviceContext);

    /**
     * 释放座位
     * @param showVO
     * @param serviceContext
     * @return
     */
    public void releaseSeat(ShowModel showModel, ServiceContext serviceContext);

    /**
     * 动态分配座位
     * @param showModel
     * @param serviceContext
     * @return
     */
    public Result<ShowResponse> randomAssignSeat(ShowModel showModel, ServiceContext serviceContext);

    /**
     * 回滚占座信息
     * @param showModel
     * @param serviceContext
     */
    public void rollbackOccupySeat(ShowModel showModel, ServiceContext serviceContext);
}
