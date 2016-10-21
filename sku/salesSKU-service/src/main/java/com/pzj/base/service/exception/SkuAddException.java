package com.pzj.base.service.exception;

import com.pzj.product.global.SkuProductECodeGlobal;

public class SkuAddException extends SkuServiceException {

	
	public SkuAddException(String errMsg){
		super(SkuProductECodeGlobal.PRODUCT_ADD_ERROR,errMsg);
	}
	
	public SkuAddException(String errMsg,Throwable ex){
		super(SkuProductECodeGlobal.PRODUCT_ADD_ERROR,errMsg,ex);
	}
}
