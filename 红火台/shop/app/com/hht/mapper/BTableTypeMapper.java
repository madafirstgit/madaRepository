package com.hht.mapper;


import com.hht.models.BTableType;

import java.util.List;
import java.util.Map;

public interface BTableTypeMapper {
   
    int deleteByPrimaryKey(String id);
   
    int insert(BTableType record);
   
    int insertSelective(BTableType record);
   
    BTableType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BTableType record);

    int updateByPrimaryKey(BTableType record);

    List<BTableType> selectByParams(Map<String, String> map);
}