package com.hht.mapper;

import com.hht.models.BOrderDishList;

public interface BOrderDishListMapper {
    int deleteByPrimaryKey(String id);

    int insert(BOrderDishList record);

    int insertSelective(BOrderDishList record);

    BOrderDishList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BOrderDishList record);

    int updateByPrimaryKey(BOrderDishList record);
}