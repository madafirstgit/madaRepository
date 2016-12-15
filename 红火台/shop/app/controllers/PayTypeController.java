package controllers;

import com.google.inject.Inject;
import com.hht.models.BPayType;
import com.hht.service.PayTypeService;
import com.hht.utils.JsonUtil;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * @author panghui
 * @version 1.0
 * @since 2016-11-29
 */
public class PayTypeController extends Controller {

    private PayTypeService payTypeService;

    @Inject
    public PayTypeController(PayTypeService payTypeService){
        this.payTypeService = payTypeService;
    }

    /**
     * 根据传入参数，查询支付方式列表
     *
     * @return
     */
    public Result list(){

        String params = request().body().asJson().toString();

        Logger.info("支付列表获取，传入参数："+params);

        List<BPayType> list = payTypeService.getPayTypeList(params);

        return ok(JsonUtil.objectToJson(list));
    }

}
