/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.smp.model;

/**
 * 
 * @author Administrator
 * @version $Id: SendMessageModel.java, v 0.1 2016年10月18日 下午4:39:00 Administrator Exp $
 */
public class MessageModel implements java.io.Serializable {

    private static final long serialVersionUID = -8679869524068507635L;

    // 支持群发，多手机号用逗号分隔
	private String phoneNum;
	
	// 短信内容
	private String content;
	
	// 业务平台+优先级 编号,trade_A
	private String platPriCode;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlatPriCode() {
		return platPriCode;
	}

	public void setPlatPriCode(String platPriCode) {
		this.platPriCode = platPriCode;
	}
	
}
