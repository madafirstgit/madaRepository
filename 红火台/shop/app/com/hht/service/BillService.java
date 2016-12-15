package com.hht.service;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.ImplementedBy;
import com.hht.interceptor.Page;
import com.hht.service.impl.BillServiceImpl;
import com.hht.models.YTableBill;

import java.util.Map;

/**
 * 账单相关service
 * Created by wujiawen on 2016/11/21.
 */
@ImplementedBy(BillServiceImpl.class)
public interface BillService {

    public JSONObject getBillInfo(String billNo);

    public Page<YTableBill,Map<String,String>> getBillListPage(Page page);

    /**
     * 确认结账
     *
     * @param params
     * @return
     */
    public String confirmCheckOut(String params);
}
