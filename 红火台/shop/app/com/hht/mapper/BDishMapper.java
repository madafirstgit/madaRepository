package com.hht.mapper;

import com.hht.models.BDish;

public interface BDishMapper {

    int deleteByPrimaryKey(String id);

    int insert(BDish record);

    int insertSelective(BDish record);

    BDish selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BDish record);

    int updateByPrimaryKey(BDish record);

    BDish selectByDishCode(String dishCode);
}