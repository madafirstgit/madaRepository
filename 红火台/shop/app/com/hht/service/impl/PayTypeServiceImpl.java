package com.hht.service.impl;

import com.google.inject.Inject;
import com.hht.mapper.BPayTypeMapper;
import com.hht.models.BPayType;
import com.hht.service.PayTypeService;
import com.hht.utils.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panghui
 * @version 1.0
 * @since 2016-11-29
 */
public class PayTypeServiceImpl implements PayTypeService {

    @Inject
    private BPayTypeMapper bPayTypeMapper;

    /**
     * 根据支付方式名称，查询支付方式列表
     *
     * @param params
     * @return
     */
    @Override
    public List<BPayType> getPayTypeList(String params) {

        Map<String,Object> map = new HashMap<String,Object>();

        if(params != null){
            map = JsonUtil.jsonToMap(params);
        }

        return bPayTypeMapper.selectPayList(String.valueOf(map.get("payName")));
    }
}
