package com.hht.mapper;


import com.hht.models.BDishCookingLink;

import java.util.List;
import java.util.Map;

public interface BDishCookingLinkMapper {
    
    int deleteByPrimaryKey(String id);
    
    int insert(BDishCookingLink record);
    
    int insertSelective(BDishCookingLink record);

    BDishCookingLink selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BDishCookingLink record);
    
    int updateByPrimaryKey(BDishCookingLink record);

    List<BDishCookingLink> selectByParams(Map<String, String> map);
}