package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.service.impl.BIllDishServiceImpl;

import java.util.Map;

/**
 * Created by qi_grui on 2016/11/22.
 */
@ImplementedBy(BIllDishServiceImpl.class)
public interface BillDishService {
    /**
     * 下单操作
     * @param map
     * @return
     */
    public Map<String,Object> billDishOrder(String tableNo, String billNo, String dishListNo, String waiterNo, String chooseData);
}
