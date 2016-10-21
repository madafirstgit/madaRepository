package com.pzj.salesSKU.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.pzj.product.service.ISkuProductService;
import com.pzj.product.vo.JsonSkuDto;

@Controller
public class ImportSkuController {
	Logger logger = LoggerFactory.getLogger(ImportSkuController.class);

    @Autowired
    private ISkuProductService skuProductService;

    @RequestMapping(value = "importSku3", method = RequestMethod.GET)
    @ResponseBody
    public void importSku1() {
        String json = "[{\"bookingInfo\":[{\"attrInfos\":[],\"attrParentInfo\":{\"booking\":false,\"display\":false,\"message\":\"该产品无套餐\"},\"displayStyle\":{\"fixedLength\":1,\"fixedStartTime\":\"\",\"timeType\":\"day\"},\"timeSlots\":[{\"booking\":true,\"display\":false,\"message\":\"该产品无详细时间段\"}]}],\"togetherBuy\":[],\"baseInfo\":{\"allocation\":\"D\",\"bossid\":1,\"categoryId\":1111114,\"defaultCalendarStatus\":\"A\",\"details\":\"<p>翟文博客栈测试产品1<span class=\"redactor-invisible-space\">--产品描述</span></p>\",\"emailNotification\":\"<p>翟文博客栈测试产品1<span class=\"redactor-invisible-space\">--邮件提醒</span></p>\",\"id\":290,\"imageInfoList\":[{\"caption\":\"\",\"pictureUrl\":\"http://dev.file.service.xingzongtravel.com/test/7d263b81b4ac42969dbd0b0babfaa9e6.jpg\",\"sort\":1}],\"inventory\":10,\"isSimple\":true,\"listImage\":\"http://dev.file.service.xingzongtravel.com/test/7d263b81b4ac42969dbd0b0babfaa9e6.jpg\",\"moreInfoUrl\":\"\",\"pricePer\":\"B\",\"skuExtCode\":\"63539199207\",\"skuGrouping\":\"\",\"skuStatus\":10,\"skuTitle\":\"翟文博客栈测试产品1\",\"startPrice\":500.00,\"summary\":\"<p>翟文博客栈测试产品1--产品简介</p>\",\"unlimitedInventory\":true,\"visibility\":\"*\",\"refundConfine\":1,\"refundConfineDays\":2,\"refundConfineTime\":\"18:20:00\",\"latestPreset\":1,\"latestPresetDays\":2,\"latestPresetTime\":\"17:58:59\",\"twiceSure\":1,\"province\":\"四川省\",\"city\":\"成都市\",\"county\":\"青羊区\"}}]";
        JsonSkuDto sku = HttpJSonUtil.JsonTEntity(json);
        try {
            List<JsonSkuDto> skuList = new ArrayList<JsonSkuDto>();
            skuList.add(sku);
            skuProductService.importSku(skuList);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @RequestMapping(value = "importSku", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String importSku(@RequestBody List<JsonSkuDto> skuList) {
        try {
            skuProductService.importSku(skuList);
        } catch (Exception e) {

            e.printStackTrace();
            return "error";
        }

        return "success";
    }

    @RequestMapping(value = "importSkuStr", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String importSku(@RequestBody String skuJson) {
    	Map<String, String> returnMap = new HashMap<String,String>();
        try {
            if (StringUtils.isBlank(skuJson)) {
            	returnMap.put(ErrorGlobalCode.IMPORT_INVALID_PARAMETER, "json串为空");
            	logger.info("产品上架：json串为空");
                return  JSON.toJSONString(returnMap);

            }
            if(skuProductService == null){
            	returnMap.put(ErrorGlobalCode.IMPORT_SERVICE_NULL, "ISkuProductService服务连接不上");
            	logger.info("产品上架：ISkuProductService服务连接不上");
            	return JSON.toJSONString(returnMap);
            }

            List<JsonSkuDto> skuList = HttpJSonUtil.jsonTEntityList(skuJson);
            logger.info("产品开始上架！");
            skuProductService.importSku(skuList);
            logger.info("产品上架成功");
            returnMap.put(ErrorGlobalCode.RETURN_SUCCESS_CODE, "success");
            return JSON.toJSONString(returnMap);

        } catch (Exception e) {
            e.printStackTrace();
            returnMap.put(ErrorGlobalCode.RETURN_SUCCESS_CODE, "error");
            return JSON.toJSONString(returnMap);
        }

    }

    @RequestMapping(value = "exportSku", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String exportSku(@RequestBody List<Long> skuIdList) {
        try {
            skuProductService.exportSku(skuIdList);
        } catch (Exception e) {

            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    public static void main(String[] args) {

    }
}
