package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.interceptor.Page;
import com.hht.models.ebeans.BDishEntity;
import com.hht.service.impl.BDishQueryServiceImpl;
import com.hht.service.impl.BIllDishServiceImpl;

/**
 * Created by Zhu Tao on 2016-11-23.
 */
@ImplementedBy(BDishQueryServiceImpl.class)
public interface BDishQueryService {

    /**
     * 获取菜品信息操作
     * @param 菜品id
     * @return 菜品内容
     */
    public String getDishInfoListPage(Page page);
}
