package controllers;


import com.hht.service.ReceiveWeiXinPayNotifyService;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class ReceiveWeixinNotifyController extends Controller {

	private FormFactory formFactory;
	private ReceiveWeiXinPayNotifyService receiveWeiXinPayNotifyService;

	@Inject
	public ReceiveWeixinNotifyController(FormFactory formFactory,ReceiveWeiXinPayNotifyService receiveWeiXinPayNotifyService){
		this.formFactory = formFactory;
		this.receiveWeiXinPayNotifyService = receiveWeiXinPayNotifyService;

	}

	/**
	 * 回调付款通知
	 */
	public Result reciveNotify() {
		try {

			String xmlStr = new String(request().body().asBytes().toArray());
			if(xmlStr == null){
				return ok("参数为空");
			}
			Boolean flag = receiveWeiXinPayNotifyService.receiveNotify(xmlStr);
			if(flag){
				return ok("SUCCESS");
			}else{
				return ok("FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok("FAIL");
	}

}
