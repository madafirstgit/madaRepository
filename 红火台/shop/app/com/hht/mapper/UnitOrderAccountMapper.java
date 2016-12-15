package com.hht.mapper;

import com.hht.models.UnitOrderAccount;

public interface UnitOrderAccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(UnitOrderAccount record);

    int insertSelective(UnitOrderAccount record);

    UnitOrderAccount selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(UnitOrderAccount record);

    int updateByPrimaryKey(UnitOrderAccount record);

    /*通过账单编号查询*/
    UnitOrderAccount selectByBillNo(String id);
}