package com.hht.mapper;

import com.hht.models.YNotifyLog;

public interface YNotifyLogMapper {

    int deleteByPrimaryKey(String id);

    int insert(YNotifyLog record);

    int insertSelective(YNotifyLog record);

    YNotifyLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YNotifyLog record);

    int updateByPrimaryKey(YNotifyLog record);
}