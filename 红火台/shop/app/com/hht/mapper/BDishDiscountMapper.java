package com.hht.mapper;

import com.hht.models.BDishDiscount;

import java.util.List;
import java.util.Map;

public interface BDishDiscountMapper {
    
    int deleteByPrimaryKey(String id);

    int insert(BDishDiscount record);
 
    int insertSelective(BDishDiscount record);
   
    BDishDiscount selectByPrimaryKey(String id);
   
    int updateByPrimaryKeySelective(BDishDiscount record);
  
    int updateByPrimaryKey(BDishDiscount record);

    List<BDishDiscount> selectByParams(Map<String, String> map);
}