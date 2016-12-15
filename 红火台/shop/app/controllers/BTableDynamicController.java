package controllers;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.hht.service.BTableDynamicService;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * Created by LNN on 2016/11/21.
 */
public class BTableDynamicController extends Controller{

    private BTableDynamicService bTableDynamicService;


    @Inject
    public BTableDynamicController(BTableDynamicService bTableDynamicService){

        this.bTableDynamicService=bTableDynamicService;

    }

    /**
     *
     * @param tableCode
     * @return
     */
    public Result doClearTable(String tableCode, String Operator){
        JSONObject result= bTableDynamicService.doClearTable(tableCode,Operator);
        return  ok(result.toString());
    }
    /*public Result yTableOprrecord(String tableCode, String operType, String operator, String operTime, String operDetailed){

      return  null;
    }*/
}
