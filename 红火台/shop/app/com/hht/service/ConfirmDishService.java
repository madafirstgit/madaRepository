package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.annotation.Transaction;
import com.hht.models.YDishListDetail;
import com.hht.service.impl.ConfirmDishServiceImpl;

/**
 * Created by Zhu Tao on 2016-11-18.
 */
@ImplementedBy(ConfirmDishServiceImpl.class)
public interface ConfirmDishService {
    /**
     * 更新菜单明细
     * @param yDishListDetail
     * @return 成功与否
     */
    public String updateYDishListDetail(YDishListDetail yDishListDetail);
}
