package com.hht.mapper;

import com.hht.models.YTableBill;

import java.util.List;
import com.hht.interceptor.Page;

public interface YTableBillMapper {

    int deleteByPrimaryKey(String id);


    int insert(YTableBill record);

    int insertSelective(YTableBill record);

    YTableBill selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YTableBill record);

    int updateByPrimaryKey(YTableBill record);

    YTableBill selectByBillNo(String billNo);

    List<YTableBill> getBillListPage(Page page);
}