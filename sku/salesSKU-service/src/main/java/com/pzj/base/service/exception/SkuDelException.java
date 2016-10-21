package com.pzj.base.service.exception;

import com.pzj.product.global.SkuProductECodeGlobal;

public class SkuDelException extends SkuServiceException{

	
	public SkuDelException(String errMsg){
		super(SkuProductECodeGlobal.PRODUCT_DEL_ERROR,errMsg);
	}
	
	public SkuDelException(String errMsg,Throwable ex){
		super(SkuProductECodeGlobal.PRODUCT_DEL_ERROR,errMsg,ex);
	}
}
