package com.hht.mapper;

import com.hht.models.YBillDetail;

public interface YBillDetailMapper {

    int deleteByPrimaryKey(String id);

    int insert(YBillDetail record);

    int insertSelective(YBillDetail record);

    YBillDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YBillDetail record);

    int updateByPrimaryKey(YBillDetail record);
}