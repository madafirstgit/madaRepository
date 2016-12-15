package com.hht.mapper;


import com.hht.models.BDishTaste;

import java.util.List;
import java.util.Map;

public interface BDishTasteMapper {
   
    int deleteByPrimaryKey(String id);

    int insert(BDishTaste record);

    int insertSelective(BDishTaste record);

    BDishTaste selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BDishTaste record);

    int updateByPrimaryKey(BDishTaste record);

    List<BDishTaste> selectByParams(Map<String, String> map);
}