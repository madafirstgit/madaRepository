package controllers;

import com.google.inject.Inject;
import com.hht.models.YTableBill;
import com.hht.service.BillPrintService;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Map;

/**
 * Created by Zhu Tao on 2016-11-29.
 */
public class BillPrintController extends Controller {

    private FormFactory formFactory;
    private BillPrintService billPrintService;

    @Inject
    public BillPrintController(FormFactory formFactory
    ,BillPrintService billPrintService){
        this.formFactory = formFactory;
        this.billPrintService = billPrintService;
    }

    public Result getBillPrintDetail(){
        Map<String,String> map  = formFactory.form().bindFromRequest().get().getData();
        String billNo = map.get("billNo");
        try {
            YTableBill yTableBill = billPrintService.getBillPrintDetail(billNo);
            billPrintService.printBillDetail(yTableBill);
        }catch (Exception e){
            e.printStackTrace();
            return ok("访问失败");
        }
        return ok("访问成功");
    }

}
