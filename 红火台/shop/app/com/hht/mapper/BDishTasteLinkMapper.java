package com.hht.mapper;

import com.hht.models.BDishTasteLink;

import java.util.List;
import java.util.Map;

public interface BDishTasteLinkMapper {
    
    int deleteByPrimaryKey(String id);
    
    int insert(BDishTasteLink record);

    int insertSelective(BDishTasteLink record);

    BDishTasteLink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BDishTasteLink record);
    
    int updateByPrimaryKey(BDishTasteLink record);

    List<BDishTasteLink> selectByParams(Map<String, String> map);
}