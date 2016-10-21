/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.smp.exception;

import com.pzj.framework.exception.ServiceException;

/**
 * 
 * @author Administrator
 * @version $Id: SmpException.java, v 0.1 2016年10月18日 下午4:40:17 Administrator Exp $
 */
public class SmpException extends ServiceException{

	private Integer errorCode = SmpCodeGlobal.serviceError;

	private static final long serialVersionUID = 1L;

	public SmpException(String message) {
		super(message);
	}
	
	public SmpException(Integer errorCode, String errMsg){
		super(errMsg);
		this.errorCode  = errorCode;
	}
}
