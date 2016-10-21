package com.pzj.base.service.exception;

import com.pzj.base.service.exception.errorCode.SkuECodeGlobal;

public class SkuParamConvertException extends SkuServiceException {


	
	public SkuParamConvertException(String errMsg){
		super(SkuECodeGlobal.dataConvertError,errMsg);
	}
	
	public SkuParamConvertException(String errMsg, Throwable t){
		super(SkuECodeGlobal.dataConvertError,errMsg,t);
	}

}
