package com.hht.mapper;

import com.hht.models.BDishCooking;

public interface BDishCookingMapper {

    int deleteByPrimaryKey(String id);

    int insert(BDishCooking record);

    int insertSelective(BDishCooking record);

    BDishCooking selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BDishCooking record);

    int updateByPrimaryKey(BDishCooking record);
}