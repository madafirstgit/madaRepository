package com.hht.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.hht.constants.Constant;
import com.hht.interceptor.Page;
import com.hht.mapper.BTableDynamicMapper;
import com.hht.mapper.YDishListDetailMapper;
import com.hht.mapper.YTableBillMapper;
import com.hht.models.BTableDynamic;
import com.hht.models.YDishListDetail;
import com.hht.models.YTableBill;
import com.hht.service.BillService;
import com.hht.service.ResultViewService;
import com.hht.utils.JsonUtil;
import com.hht.utils.PropertiesUtil;
import com.hht.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wujiawen on 2016/11/21.
 */
public class BillServiceImpl extends ResultViewService implements BillService {

    @Inject
    private YTableBillMapper yTableBillMapper;
    @Inject
    private YDishListDetailMapper yDishListDetailMapper;

    @Inject
    private BTableDynamicMapper bTableDynamicMapper;

    /**
     * 根据账单编号查询账单明细
     * @param  billNo 账单编号
     * */
    @Override
    public JSONObject getBillInfo(String billNo){
        JSONObject result = new JSONObject();
        YTableBill tableBill = yTableBillMapper.selectByBillNo(billNo);
        if(tableBill == null){
            result.put("resultcode", Constant.RESULT_CODE_FAIL);
            result.put("resultdesc","未查找到相关账单信息");
        }else{
            List<YDishListDetail> list = yDishListDetailMapper.selectByDishListCode(tableBill.getDishListCode());
            result.put("bill",tableBill);
            result.put("dishList",list);
            result.put("resultcode", Constant.RESULT_CODE_SUCCESS);
            result.put("resultdesc","成功");
        }
        return result;
    }

    @Override
    public Page<YTableBill,Map<String,String>> getBillListPage(Page page){
       page.setList(yTableBillMapper.getBillListPage(page));
       return page;
    }

    /**
     * 确认结账
     *
     * @param params
     * @return
     */
    @Override
    public String confirmCheckOut(String params) {


        Map<String,Object> map = JsonUtil.jsonToMap(params);

        if(map.get("tableCode") != null && map.get("billNo") != null){

            BTableDynamic bTableDynamic = bTableDynamicMapper.selectByTableCode(map);

            if(bTableDynamic != null){
                // 将桌台状态设置为清理状态
                bTableDynamic.setTableStatus(2);

                if(bTableDynamicMapper.updateByPrimaryKeySelective(bTableDynamic)>0){
                    return ok(null,PropertiesUtil.getValueByKey("BILL_CHECKOUT_MSG1")).toJsonString();
                }else{
                    return error(PropertiesUtil.getValueByKey("BILL_CHECKOUT_MSG2")).toJsonString();
                }

            }else{
                return error(PropertiesUtil.getValueByKey("BILL_CHECKOUT_MSG3")).toJsonString();
            }

        }else{
            return error(PropertiesUtil.getValueByKey("BILL_CHECKOUT_MSG4")).toJsonString();
        }
    }
}
