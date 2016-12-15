package com.hht.mapper;

import com.hht.models.UdAccountOrder;

public interface UdAccountOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(UdAccountOrder record);

    int insertSelective(UdAccountOrder record);

    UdAccountOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UdAccountOrder record);

    int updateByPrimaryKey(UdAccountOrder record);
}