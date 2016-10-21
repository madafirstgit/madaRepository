/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.smp.service;

import com.pzj.core.smp.model.MessageModel;

/**
 * 
 * @author Administrator
 * @version $Id: MessageSender.java, v 0.1 2016年10月18日 下午4:40:00 Administrator Exp $
 */
public interface SmsSender {
	
	/**
	 * @param messageModel
	 * @return 
	 */
	public String smsSend(MessageModel messageModel);
}
