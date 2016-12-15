package controllers;

import com.hht.service.ReceiveAlipayNotifyService;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
public class ReceiveAlipayNotifyController extends Controller{

    private FormFactory formFactory;
    private ReceiveAlipayNotifyService receiveAlipayNotifyService;

    @Inject
    private ReceiveAlipayNotifyController(FormFactory formFactory,ReceiveAlipayNotifyService receiveAlipayNotifyService){
        this.receiveAlipayNotifyService = receiveAlipayNotifyService;
        this.formFactory = formFactory;
    }


    /**
     * 支付宝支付回调
     */
    public Result reciveNotify() {
        try {
            DynamicForm form = formFactory.form().bindFromRequest();
            Map<String,String[]> map = request().body().asFormUrlEncoded();
            Boolean flag = receiveAlipayNotifyService.receiveNotify(form,map);
            if(flag){
                return ok("SUCCESS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok("FAIL");
    }

    /**
     * 支付宝退款回调
     */
    public Result refundNotify() {
        try {
            DynamicForm form = formFactory.form().bindFromRequest();
            Boolean flag = receiveAlipayNotifyService.refundNotify(form);
            if(flag){
                return ok("SUCCESS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok("FAIL");
    }
}
