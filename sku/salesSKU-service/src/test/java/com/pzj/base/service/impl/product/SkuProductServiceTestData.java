package com.pzj.base.service.impl.product;

import java.util.List;

import com.pzj.JsonDataUtil;


public class SkuProductServiceTestData {
	private static SkuProductServiceTestData util = new SkuProductServiceTestData();
	
	public <T extends Object> T createTestData(String filePath,Class<T> classType){
		T result = JsonDataUtil.readObjectFromClasspath(filePath,classType);
		return result;
	}

	public <T extends Object> List<T> createTestDataList(String filePath,Class<T> classType){
		List<T> result = JsonDataUtil.readListFromClasspath(filePath,classType);
		return result;
	}
	public static SkuProductServiceTestData getInstance(){
		return util;
	}

}
