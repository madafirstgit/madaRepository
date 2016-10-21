package com.pzj.base.service.exception;

import com.pzj.product.global.SkuProductECodeGlobal;

public class SkuSaveException extends SkuServiceException {

	
	public SkuSaveException(String errMsg){
		super(SkuProductECodeGlobal.PRODUCT_SAVE_ERROR,errMsg);
	}
	
	public SkuSaveException(String errMsg,Throwable ex){
		super(SkuProductECodeGlobal.PRODUCT_SAVE_ERROR,errMsg,ex);
	}
}
