package controllers;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hht.service.BillDishService;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/21.
 */
public class BillDishController extends Controller {

    private FormFactory formFactory;
    private BillDishService billDishService;

    @Inject
    private BillDishController(FormFactory formFactory,BillDishService billDishService){
        this.formFactory = formFactory;
        this.billDishService = billDishService;
    }

    /**
     * 菜品下单
     * @param
     * @return
     */
    public Result billDishOrder(){
        JSONObject result = new JSONObject();
        try{

            //获取请求参数
            DynamicForm form = formFactory.form().bindFromRequest();
            /*Map<String,String[]> map = request().body().asFormUrlEncoded();*/
            //桌台号
            String tableNo = form.get("tableNo");
            //账单号
            String billNo = form.get("billNo");
            //菜单号
            String dishListNo = form.get("dishListNo");
            //服务员号
            String waiterNo = form.get("waiterNo");
            //菜品集合JSONList
            String chooseData = form.get("chooseDataList");
            Map<String,Object> resultMap = billDishService.billDishOrder(tableNo,billNo,dishListNo,waiterNo,chooseData);
            result.putAll(resultMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok(result.toString());
    }


}
