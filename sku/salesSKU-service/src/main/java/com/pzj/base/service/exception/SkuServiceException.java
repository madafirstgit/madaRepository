package com.pzj.base.service.exception;

import com.pzj.base.service.exception.errorCode.SkuECodeGlobal;
import com.pzj.framework.exception.ServiceException;

/**
 * Created by Administrator on 2016-8-2.
 */
public class SkuServiceException extends ServiceException {
	
	private Integer errorCode = SkuECodeGlobal.serviceError;
	
	public SkuServiceException(String errMsg){
		super(errMsg);
	}
	
	public SkuServiceException(String errMsg,Throwable ex){
		super(errMsg,ex);
	}
	public SkuServiceException(Integer errorCode, String errMsg){
		super(errMsg);
		this.errorCode  = errorCode;
	}
	
	public SkuServiceException(Integer errorCode, String errMsg,Throwable ex){
		super(errMsg,ex);
		this.errorCode  = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}
	

}
