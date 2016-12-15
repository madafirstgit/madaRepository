package com.hht.mapper;

import com.hht.models.YBillAccount;

public interface YBillAccountMapper {

    int deleteByPrimaryKey(String id);

    int insert(YBillAccount record);

    int insertSelective(YBillAccount record);

    YBillAccount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YBillAccount record);

    int updateByPrimaryKey(YBillAccount record);

    YBillAccount selectByBillNo(String billNo);
}