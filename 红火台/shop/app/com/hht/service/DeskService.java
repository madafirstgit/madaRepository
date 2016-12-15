package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.service.impl.DeskServiceImpl;

/**
 * @author panghui
 * @version 1.0
 * @since 2016/11/18
 */
@ImplementedBy(DeskServiceImpl.class)
public interface DeskService {

    /**
     * 根据传入参数开台
     *
     * @param params
     * @return
     */
    public String openDesk(String params);

    /**
     * 确认账单
     *
     * @param params
     * @param operate 1=确认账单，2=账单解锁
     * @return
     */
    public String operateBill(String params,int operate);

}
