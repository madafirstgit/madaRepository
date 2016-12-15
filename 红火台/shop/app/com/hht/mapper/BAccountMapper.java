package com.hht.mapper;



import com.hht.models.BAccount;

import java.util.List;
import java.util.Map;

public interface BAccountMapper {
   
    int deleteByPrimaryKey(String loginAccount);
   
    int insert(BAccount record);
   
    int insertSelective(BAccount record);
   
    BAccount selectByPrimaryKey(String loginAccount);

    int updateByPrimaryKeySelective(BAccount record);

    int updateByPrimaryKey(BAccount record);

    List<BAccount> selectByParams(Map<String, String> map);
    //批量删除
    int batchDelete(List<BAccount> accountList);

    //批量删除
    int batchInsert(List<BAccount> accountList);
}