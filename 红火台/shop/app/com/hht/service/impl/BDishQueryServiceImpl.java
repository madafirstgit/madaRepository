package com.hht.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.hht.interceptor.Page;
import com.hht.mapper.BDishQueryMapper;
import com.hht.models.ebeans.BDishEntity;
import com.hht.service.BDishQueryService;
import com.hht.utils.JsonUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhu Tao on 2016-11-23.
 */
public class BDishQueryServiceImpl implements BDishQueryService {
    private BDishQueryMapper bDishQueryDao;

    @Inject
    public BDishQueryServiceImpl(BDishQueryMapper bDishQueryMapper){
        this.bDishQueryDao = bDishQueryMapper;
    }
    @Override
    public String getDishInfoListPage(Page page) {
        String jsonForm = null;
        String id = null;
        if(((Map)page.getParams()).get("id")!=null) {
             id = ((Map) page.getParams()).get("id").toString();
        }
        List<BDishEntity> bDishEntitys =  bDishQueryDao.getDishInfoListPage(page);
        jsonForm = JsonUtil.objectToJson(bDishEntitys);
        return jsonForm;
    }
}
