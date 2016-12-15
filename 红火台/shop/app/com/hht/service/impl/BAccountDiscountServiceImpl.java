package com.hht.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.hht.constants.Constant;
import com.hht.mapper.BAccountDiscountMapper;
import com.hht.models.BAccountDiscount;

import com.hht.service.BAccountDiscountService;



/**
 * Created by x_li on 2016/11/28.
 */
public class BAccountDiscountServiceImpl implements BAccountDiscountService {
    @Inject
    private BAccountDiscountMapper bAccountDiscountMapper;


    /**
     * 根据id查询账单折扣信息
     * @param id 账单号
     * @return
     */
    @Override
    public JSONObject selectById(String id) {
        JSONObject result = new JSONObject();
        BAccountDiscount bAccountDiscount = bAccountDiscountMapper.selectByPrimaryKey(id);
        if (bAccountDiscount == null) {
            result.put("resultcode", Constant.RESULT_CODE_FAIL);
            result.put("resultdesc", "未找到相关账单");
        } else {
            BAccountDiscount list = bAccountDiscountMapper.selectByPrimaryKey(id);
            //result.put("remarkId", id);
            result.put("discountInfo", list);
            result.put("resultcode", Constant.RESULT_CODE_SUCCESS);
            result.put("resultdesc", "成功!");
        }
        return result;
    }


    /**
     * 设置账单折扣
     * @param bAccountDiscount 账单折扣信息
     * @return
     */
    @Override
    public JSONObject updateById(BAccountDiscount bAccountDiscount) {
        JSONObject jsonObject=new JSONObject();
        int result = bAccountDiscountMapper.updateByPrimaryKey(bAccountDiscount);
        if(result>0){
            jsonObject.put("resultcode", Constant.RESULT_CODE_SUCCESS);
            jsonObject.put("resultdesc", "成功!");
        }else{
            jsonObject.put("resultcode", Constant.RESULT_CODE_FAIL);
            jsonObject.put("resultdesc", "失败!");
        }
        return jsonObject;
    }

}
