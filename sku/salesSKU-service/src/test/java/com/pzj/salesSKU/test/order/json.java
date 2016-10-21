package com.pzj.salesSKU.test.order;

import com.pzj.product.vo.BaseInfo;
import com.pzj.product.vo.JsonSkuDto;

public class json {
    public static void main(String[] args) {
        String a = "{\"baseInfo\":{\"id\":88,\"bossid\":1,\"categoryId\":11111,\"skuExtCode\":\"8989898998\",\"supplierCode\":\"supper_code\",\"inventory\":100,\"unlimitedInventory\":false,\"isSimple\":false,\"allocation\":\"D\",\"visibility\":\"all\",\"maintenanceTime\":6,\"pricePer\":\"U\",\"startPrice\":100.00,\"pkgStartPrice\":null,\"skuGrouping\":\"\",\"listImage\":null,\"skuStatus\":10,\"skuTitle\":\"88号测试产品\",\"summary\":\"<p>88号测试产品的产品</p>\",\"location\":\"上海\",\"markerTitle\":\"北京 map title\",\"markerDescription\":\"北京 map title\",\"markerLinkText\":\"北京 map title\",\"mapZoom\":6,\"emailNotification\":\"<p>test email</p>\",\"moreInfoUrl\":\"baidu.com\",\"videoUrl\":null,\"videoStartTime\":null,\"details\":\"<p>88号产品详情</p>\",\"imageInfoList\":[]},\"bookingInfo\":[{\"attrParentInfo\":{\"pkgId\":null,\"name\":null,\"display\":false,\"message\":\"该产品无套餐\"},\"timeSlots\":[{\"tsId\":239,\"startTime\":\"01:00 PM\",\"endTime\":\"02:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":240,\"startTime\":\"02:00 PM\",\"endTime\":\"03:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":241,\"startTime\":\"03:00 PM\",\"endTime\":\"04:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":242,\"startTime\":\"04:00 PM\",\"endTime\":\"05:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":243,\"startTime\":\"05:00 PM\",\"endTime\":\"06:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":244,\"startTime\":\"06:00 PM\",\"endTime\":\"07:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":245,\"startTime\":\"08:00 PM\",\"endTime\":\"11:00 PM\",\"timeLength\":3.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null}],\"attrInfos\":[{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":90.00,\"isGroup\":0,\"minNumber\":null,\"maxNumber\":null,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":1,\"weekAvailable\":\"1,2,3,4,5,6,7\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":108.00,\"weights\":30}]},{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":90.00,\"isGroup\":1,\"minNumber\":1,\"maxNumber\":1,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":1,\"weekAvailable\":\"1,2,3,4,5,6,7\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":108.00,\"weights\":30}]},{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":45.00,\"isGroup\":1,\"minNumber\":2,\"maxNumber\":2,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":1,\"weekAvailable\":\"1,2,3,4,5,6,7\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":54.00,\"weights\":30}]},{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":30.00,\"isGroup\":1,\"minNumber\":3,\"maxNumber\":3,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":1,\"weekAvailable\":\"1,2,3,4,5,6,7\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":36.00,\"weights\":30}]}],\"displayStyle\":{\"fixedStartTime\":\"08:00AM\",\"defaultLength\":1,\"fixedLength\":1,\"bookingDisplay\":null,\"showEndTimes\":null,\"showUnavailableSlots\":null,\"timeType\":\"timeslot\"}}],\"togetherBuy\":[]}";
        JsonSkuDto dto = new JsonSkuDto();
        BaseInfo bi = new BaseInfo();

        bi.setId(11111);

       // dto.setTogetherBuy(tb);
        dto.setBaseInfo(bi);
        //String b = "{\"baseInfo\":{\"id\":11111}}";
     /*   Gson gson = new Gson();
        String json = gson.toJson(dto);
        System.out.println(json);

        JsonSkuDto j = gson.fromJson(a, JsonSkuDto.class);
        System.out.println(j.getBaseInfo().getId());
        System.out.println(j.getBookingInfo().get(0).getDisplayStyle().getTimeType());
*/
    }

}
