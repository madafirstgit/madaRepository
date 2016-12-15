package controllers;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.hht.constants.Constant;
import com.hht.models.BAccountDiscount;
import com.hht.service.BAccountDiscountService;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;

/**
 * Created by x_li on 2016/11/28.
 */
public class BAccountDiscountController extends Controller{
    private BAccountDiscountService bAccountDiscountService;

    @Inject
    public BAccountDiscountController(BAccountDiscountService bAccountDiscountService){
        this.bAccountDiscountService=bAccountDiscountService;
    }
    /**
     * 查询账单折扣信息
     * @return
     */
    public Result selectById(){
        String id = request().body().asJson().textValue();
        JSONObject result=bAccountDiscountService.selectById(id);
        Logger.info("接收参数："+id);
        return ok(String.valueOf(result));
    }

    /**
     * 设置账单折扣
     * @return
     */
    public Result updateById(){
        JsonNode json=request().body().asJson();
        JSONObject json2=bAccountDiscountService.selectById(json.at("/id").textValue());

        //可以在这做判断  判断id是否与数据库中的ID一致（可作为是否有这条记录）
        BAccountDiscount bAccountDiscount=(BAccountDiscount)json2.get("discountInfo");

        bAccountDiscount.setDiscount(json.at("/discount").decimalValue());
        bAccountDiscount.setDiscountName(json.at("/discount_name").textValue());
        bAccountDiscount.setUpdateTime(new Date());
        Logger.info("bAccountDiscount--->"+bAccountDiscount);
        JSONObject result=bAccountDiscountService.updateById(bAccountDiscount);
        return ok(String.valueOf(result));
    }


}
