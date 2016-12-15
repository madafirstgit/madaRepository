package com.hht.mapper;

import com.hht.interceptor.Page;
import com.hht.models.ebeans.BDishEntity;

import java.util.List;

/**
 * Created by Zhu Tao on 2016-11-23.
 */
public interface BDishQueryMapper {

    /**
     * 通过菜品id进行菜品查询
     * @param dish_id
     * @return
     */
    List<BDishEntity> getDishInfoListPage(Page page);

}
