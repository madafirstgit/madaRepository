package com.hht.service;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.ImplementedBy;
import com.hht.models.BAccountDiscount;
import com.hht.service.impl.BAccountDiscountServiceImpl;

/**
 * Created by x_li on 2016/11/28.
 */
@ImplementedBy(BAccountDiscountServiceImpl.class)
public interface BAccountDiscountService {
    // 根据id查询账单折扣信息
    JSONObject selectById(String id);


    //  设置账单折扣
    JSONObject  updateById(BAccountDiscount bAccountDiscount);

}
