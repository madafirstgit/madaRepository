package test.common;

import java.util.List;



public class TestDataGengerateUtil {
	private static TestDataGengerateUtil util = new TestDataGengerateUtil();
	
	public <T extends Object> T createTestData(String filePath,Class<T> classType){
		T result = JsonDataUtil.readObjectFromClasspath(filePath,classType);
		return result;
	}

	public <T extends Object> List<T> createTestDataList(String filePath,Class<T> classType){
		List<T> result = JsonDataUtil.readListFromClasspath(filePath,classType);
		return result;
	}
	public static TestDataGengerateUtil getInstance(){
		return util;
	}

}
