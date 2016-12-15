package com.hht.mapper;

import com.hht.models.BTableInfo;

public interface BTableInfoMapper {

    int deleteByPrimaryKey(String id);

    int insert(BTableInfo record);

    int insertSelective(BTableInfo record);

    BTableInfo selectByPrimaryKey(String id);

    BTableInfo selectByTableCode(String tableCode);

    int updateByPrimaryKeySelective(BTableInfo record);

    int updateByPrimaryKey(BTableInfo record);
}