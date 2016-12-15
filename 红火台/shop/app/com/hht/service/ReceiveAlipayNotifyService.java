package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.service.impl.ReceiveAlipayNotifyServiceImpl;
import play.data.DynamicForm;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
@ImplementedBy(ReceiveAlipayNotifyServiceImpl.class)
public interface ReceiveAlipayNotifyService {

    public boolean receiveNotify(DynamicForm form, Map<String,String[]> map);

    public boolean refundNotify(DynamicForm form) throws Exception;
}
