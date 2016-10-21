package com.pzj.base.service.exception;

import com.pzj.base.service.exception.errorCode.SkuECodeGlobal;

public class SkuParamNullException extends SkuServiceException {

	
	public SkuParamNullException(String errMsg){
		super(SkuECodeGlobal.paramNull,errMsg);
	}
	
	public SkuParamNullException(String errMsg,Throwable t){
		super(SkuECodeGlobal.paramNull,errMsg,t);
	}
}
