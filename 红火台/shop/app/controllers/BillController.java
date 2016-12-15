package controllers;

import com.alibaba.fastjson.JSONObject;
import com.hht.interceptor.Page;
import com.hht.models.YTableBill;
import com.hht.service.BillService;
import com.hht.utils.JsonUtil;
import play.Logger;
import play.data.FormFactory;
import play.db.Database;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Map;


/**
 * Created by wujiawen on 2016/11/21.
 */
public class BillController extends Controller {

    private Database db;
    private BillService billService;
    private FormFactory formFactory;

    @Inject
    public BillController(BillService billService,Database db,FormFactory formFactory){
        this.db = db;
        this.billService = billService;
        this.formFactory = formFactory;
    }

    /**
     * 根据条件查询账单
     * */
    public Result getBillList(){
        Map<String,String> map = formFactory.form().bindFromRequest().get().getData();
        Page<YTableBill,Map<String,String>> page = new Page();
        page.setPageNum(Integer.valueOf(map.get("pageNum")));
        page.setPageRecordCount(1);
        page.setParams(map);
        page = billService.getBillListPage(page);
        return ok(JsonUtil.objectToJson(page));
    }

    /**
     * 根据账单编号查询账单
     * */
    public Result getBillInfo(String billNo){
        JSONObject result = billService.getBillInfo(billNo);
        return ok(result.toString());
    }

    /**
     * 确认结账
     *
     * @return  返回结账状态
     */
    public Result confirmBillCheckOut(){

        String params = request().body().asJson().toString();

        Logger.info("确认结账接收参数："+params);

        return ok(billService.confirmCheckOut(params));
    }

    public Result testUUID(){
        String params = request().body().asJson().toString();

        Logger.info("确认结账接收参数："+params);

        return ok(billService.confirmCheckOut(params));
    }
}
