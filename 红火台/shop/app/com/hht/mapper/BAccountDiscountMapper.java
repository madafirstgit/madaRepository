package com.hht.mapper;

import com.hht.models.BAccountDiscount;

public interface BAccountDiscountMapper {

    int deleteByPrimaryKey(String id);

    int insert(BAccountDiscount record);

    int insertSelective(BAccountDiscount record);

    BAccountDiscount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BAccountDiscount record);

    int updateByPrimaryKey(BAccountDiscount record);

}
