package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.service.impl.ReceiveWeiXinPayNotifyServiceImpl;
import play.data.DynamicForm;

/**
 * 微信异步通知
 * @author james
 *
 */
@ImplementedBy(ReceiveWeiXinPayNotifyServiceImpl.class)
public interface ReceiveWeiXinPayNotifyService {
	
	/**
	 * 接收微信异步支付通知
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	public Boolean receiveNotify(String xmlStr) throws Exception;
	
}
