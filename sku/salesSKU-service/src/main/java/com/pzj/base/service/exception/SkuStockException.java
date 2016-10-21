package com.pzj.base.service.exception;


import com.pzj.core.stock.global.SkuStockECodeGlobal;

public class SkuStockException extends SkuServiceException{
	private Integer errorCode = SkuStockECodeGlobal.SkuStockError;
	public SkuStockException(String errMsg) {
		super(SkuStockECodeGlobal.SkuStockError,errMsg);
	}
	public SkuStockException(String errMsg,Throwable ex) {
		super(SkuStockECodeGlobal.SkuStockError,errMsg,ex);
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	
	
	
}
