package com.hht.mapper;

import com.hht.models.BDishClass;

public interface BDishClassMapper {

    int deleteByPrimaryKey(String id);

    int insert(BDishClass record);

    int insertSelective(BDishClass record);

    BDishClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BDishClass record);

    int updateByPrimaryKey(BDishClass record);
}