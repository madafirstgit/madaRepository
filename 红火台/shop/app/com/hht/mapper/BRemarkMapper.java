package com.hht.mapper;

import com.hht.models.BRemark;

public interface BRemarkMapper {

    int deleteByPrimaryKey(String remarkId);

    int insert(BRemark record);

    int insertSelective(BRemark record);

    BRemark selectByPrimaryKey(String remarkId);

    int updateByPrimaryKeySelective(BRemark record);

    int updateByPrimaryKey(BRemark record);
}