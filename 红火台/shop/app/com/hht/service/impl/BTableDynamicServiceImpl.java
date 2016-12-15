package com.hht.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.hht.constants.Constant;
import com.hht.mapper.BTableDynamicMapper;
import com.hht.mapper.YTableOprrecordMapper;
import com.hht.models.BTableDynamic;
import com.hht.models.YTableOprrecord;
import com.hht.service.BTableDynamicService;
import com.hht.utils.UUidUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LNN on 2016/11/21.
 */
public class BTableDynamicServiceImpl implements BTableDynamicService{
    @Inject
    private BTableDynamicMapper bTableDynamicMapper;

    @Inject
    private YTableOprrecordMapper yTableOprrecordMapper;


   public JSONObject doClearTable(String tableCode,String Operator){
          JSONObject result = new JSONObject();
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("tableCode",tableCode);
           BTableDynamic bTableDynamic = bTableDynamicMapper.selectByTableCode(map);
           if (bTableDynamic != null  ){
               if(2 ==  bTableDynamic.getTableStatus() ) {
                   result.put("resultcode", Constant.RESULT_CODE_SUCCESS);
                   result.put("resultdesc", "清扫完毕");
                   addOpreateLog(tableCode, Operator);
               }
               else{
                   //1 未清台
                   result.put("resultcode",Constant.RESULT_CODE_FAIL);
                   result.put("resultdesc","未清台");
               }
       }
       return  result;
   }

     /*
     * 查询桌位状态
     * */


    public BTableDynamic selectByTableCode (String tableCode){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("tableCode",tableCode);
        BTableDynamic bTableDynamic =bTableDynamicMapper.selectByTableCode(map);
        // BTableDynamic bTableDynamic = new BTableDynamic();
        //  bTableDynamic.setId(a);
        return bTableDynamic;
    }

    /**
     * 插入操作日志
     */
    public int addOpreateLog(String tableCode,String Operator){

        YTableOprrecord yTableOprrecord = new YTableOprrecord();
        yTableOprrecord.setId(UUidUtil.generateId());
        yTableOprrecord.setTableCode(tableCode);
        // 设置操作类型为清台
        yTableOprrecord.setOperType("10");
        yTableOprrecord.setOperator(Operator);
        yTableOprrecord.setOperTime(new Date());

        return yTableOprrecordMapper.insert(yTableOprrecord);
    }
}
