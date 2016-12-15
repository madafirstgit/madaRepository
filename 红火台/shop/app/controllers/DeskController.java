package controllers;

import com.google.inject.Inject;
import com.hht.service.DeskService;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * @author panghui
 * @version 1.0
 * @since 2016/11/18
 */
public class DeskController extends Controller{

    private DeskService deskService;

    @Inject
    public DeskController(DeskService deskService){
        this.deskService = deskService;
    }

    /**
     * 根据传入参数，操作开台
     *
     * @return
     */
    public Result openDesk(){

        String params = request().body().asJson().toString();

        Logger.info("接收参数："+params);

        return ok(deskService.openDesk(params));
    }

    /**
     * 根据传入参数，确认账单
     *
     * @return
     */
    public Result ConfirmBill(){
        String params = request().body().asJson().toString();

        Logger.info("确认账单，接收JSON参数："+params);

        return ok(deskService.operateBill(params,1));
    }


    /**
     * 根据传入参数，解锁账单
     *
     * @return
     */
    public Result unLockBill(){
        String params = request().body().asJson().toString();

        Logger.info("解锁账单，接收JSON参数："+params);

        return ok(deskService.operateBill(params,2));
    }

}
