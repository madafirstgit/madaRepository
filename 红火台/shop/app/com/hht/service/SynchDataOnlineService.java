package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.service.impl.SynchDataOnlineServiceImpl;

/**
 * Created by qi_grui on 2016/12/8.
 */
@ImplementedBy(SynchDataOnlineServiceImpl.class)
public interface SynchDataOnlineService {
    /**
     * 餐厅基础数据同步
     */
    public void synchDataFromOnline();
}
