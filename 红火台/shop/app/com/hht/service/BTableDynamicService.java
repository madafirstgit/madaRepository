package com.hht.service;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.ImplementedBy;
import com.hht.models.BTableDynamic;
import com.hht.service.impl.BTableDynamicServiceImpl;


/**
 * Created by LNN on 2016/11/21.
 */
@ImplementedBy(BTableDynamicServiceImpl.class)
public interface BTableDynamicService {

    public JSONObject doClearTable(String tableCode, String Operator);

    BTableDynamic selectByTableCode(String tableCode);

    int addOpreateLog(String tableCode,String Operator);
}
