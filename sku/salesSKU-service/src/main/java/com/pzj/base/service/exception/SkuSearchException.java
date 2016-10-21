package com.pzj.base.service.exception;

import com.pzj.product.global.SkuProductECodeGlobal;

public class SkuSearchException extends SkuServiceException{

	
	public SkuSearchException(String errMsg){
		super(SkuProductECodeGlobal.PRODUCT_SEARCH_ERROR,errMsg);
	}
	
	public SkuSearchException(String errMsg,Throwable ex){
		super(SkuProductECodeGlobal.PRODUCT_SEARCH_ERROR,errMsg,ex);
	}
}
