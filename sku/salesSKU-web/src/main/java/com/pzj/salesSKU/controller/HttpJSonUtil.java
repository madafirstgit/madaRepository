package com.pzj.salesSKU.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





import com.alibaba.fastjson.JSON;

import com.fasterxml.jackson.databind.JavaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pzj.product.vo.JsonSkuDto;

public class HttpJSonUtil {
	private final static Logger logger = LoggerFactory.getLogger(HttpJSonUtil.class);
    final static Gson gson = new Gson();

    public static List<JsonSkuDto> JsonTEntityList(String json) {
    	logger.info("供应端Json:{}", json);
        json = json.replace("\\", "");
        List<JsonSkuDto> returnList = gson.fromJson(json, new TypeToken<List<JsonSkuDto>>() {
        }.getType());

        return returnList;
    }

    public static JsonSkuDto JsonTEntity(String json) {
    	logger.info("供应端Json:{}", json);
        JsonSkuDto returnEntity = gson.fromJson(json, JsonSkuDto.class);

        return returnEntity;
    }
    public static List<JsonSkuDto> jacksonTEntityList(String json) throws Exception{
    	logger.info("供应端Json:{}", json);
    	ObjectMapper mapper = new ObjectMapper();  
    	JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, JsonSkuDto.class);  
    	//如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);  
    	List<JsonSkuDto> lst =  (List<JsonSkuDto>)mapper.readValue(json, javaType); 
    	return lst;
    }
    public static List<JsonSkuDto> jsonTEntityList(String json) throws Exception{
    	logger.info("供应端Json:{}", json);
    	List<JsonSkuDto> lst =  JSON.parseArray(json, JsonSkuDto.class);
    	return lst;
    }


}