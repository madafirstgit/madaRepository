package com.hht.mapper;

import com.hht.models.BPaymenList;

public interface BPaymenListMapper {
    int deleteByPrimaryKey(String id);

    int insert(BPaymenList record);

    int insertSelective(BPaymenList record);

    BPaymenList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BPaymenList record);

    int updateByPrimaryKey(BPaymenList record);
}