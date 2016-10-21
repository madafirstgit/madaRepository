//package com.pzj.salesSKU.test.order;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
//
//import com.google.gson.Gson;
//import com.pzj.base.common.utils.QueryPageList;
//import com.pzj.base.common.utils.QueryPageModel;
//import com.pzj.base.entity.product.ProductRelease;
//import com.pzj.base.service.product.IProductReleaseService;
//import com.pzj.base.service.sku.ProductBatchDeleteService;
//import com.pzj.base.service.sku.ProductService;
//import com.pzj.product.vo.JsonSkuDto;
//import com.pzj.product.vo.TogetherBuy;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//                         DirtiesContextTestExecutionListener.class })
//@ContextConfiguration(locations = { "classpath*:/META-INF/spring/applicationContext.xml" })
//public class ProductBatchDeleteServiceImplTest {
//
//    static ApplicationContext         context = null;
//
//    /*@BeforeClass
//    public static void setUpClass() {
//    	context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
//    	System.out.println(context);
//    }*/
//    @Autowired
//    private ProductBatchDeleteService productBatchDeleteService;
//    @Autowired
//    private ProductService            ps;
//    @Autowired
//    IProductReleaseService            iprs;
//
//    /*@Before
//    public void setUp() {
//    	productBatchDeleteService = context.getBean(ProductBatchDeleteServiceImpl.class);
//    }	
//    */
//
//    @Test
//    public void testDeleteBatch() {
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(1);
//        ids.add(2);
//        ids.add(3);
//        productBatchDeleteService.deleteBatch(ids);
//    }
//
//    @Test
//    public void testInsertBatch() {
//        String a = "{\"baseInfo\":{\"id\":88,\"bossid\":1,\"categoryId\":11111,\"skuExtCode\":\"8989898998\",\"supplierCode\":\"supper_code\",\"inventory\":100,\"unlimitedInventory\":false,\"isSimple\":false,\"allocation\":\"D\",\"visibility\":\"all\",\"maintenanceTime\":6,\"pricePer\":\"U\",\"startPrice\":100.00,\"pkgStartPrice\":null,\"skuGrouping\":\"\",\"listImage\":null,\"skuStatus\":10,\"skuTitle\":\"88号测试产品\",\"summary\":\"<p>88号测试产品的产品</p>\",\"location\":\"上海\",\"markerTitle\":\"北京 map title\",\"markerDescription\":\"北京 map title\",\"markerLinkText\":\"北京 map title\",\"mapZoom\":6,\"emailNotification\":\"<p>test email</p>\",\"moreInfoUrl\":\"baidu.com\",\"videoUrl\":null,\"videoStartTime\":null,\"details\":\"<p>88号产品详情</p>\",\"imageInfoList\":[]},\"bookingInfo\":[{\"attrParentInfo\":{\"pkgId\":null,\"name\":null,\"display\":false,\"message\":\"该产品无套餐\"},\"timeSlots\":[{\"tsId\":239,\"startTime\":\"01:00 PM\",\"endTime\":\"02:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":240,\"startTime\":\"02:00 PM\",\"endTime\":\"03:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":241,\"startTime\":\"03:00 PM\",\"endTime\":\"04:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":242,\"startTime\":\"04:00 PM\",\"endTime\":\"05:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":243,\"startTime\":\"05:00 PM\",\"endTime\":\"06:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":244,\"startTime\":\"06:00 PM\",\"endTime\":\"07:00 PM\",\"timeLength\":1.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null},{\"tsId\":245,\"startTime\":\"08:00 PM\",\"endTime\":\"11:00 PM\",\"timeLength\":3.0,\"timeUnit\":\"U\",\"fixedLength\":null,\"display\":true,\"message\":null}],\"attrInfos\":[{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":90.00,\"isGroup\":0,\"minNumber\":null,\"maxNumber\":null,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":2,\"weekAvailable\":\"1,2,3\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":108.00,\"weights\":30}]},{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":90.00,\"isGroup\":1,\"minNumber\":1,\"maxNumber\":1,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":3,\"weekAvailable\":\"1,2,3,5,6,7\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":108.00,\"weights\":30}]},{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":45.00,\"isGroup\":1,\"minNumber\":2,\"maxNumber\":2,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":4,\"weekAvailable\":\"1,2,3,4,5\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":54.00,\"weights\":30}]},{\"attrId\":1,\"defaultValue\":1,\"hasPrice\":true,\"isDisplayRange\":true,\"isRequired\":false,\"params\":\"数量\",\"price\":30.00,\"isGroup\":1,\"minNumber\":3,\"maxNumber\":3,\"display\":null,\"message\":null,\"scheduleList\":[{\"scheduleId\":7,\"weekAvailable\":\",4,5,6,7\",\"scheduleName\":\"周末\",\"startDate\":\"2016-06-01\",\"endDate\":\"2016-06-04\",\"price\":36.00,\"weights\":30}]}],\"displayStyle\":{\"fixedStartTime\":\"08:00AM\",\"defaultLength\":1,\"fixedLength\":1,\"bookingDisplay\":null,\"showEndTimes\":null,\"showUnavailableSlots\":null,\"timeType\":\"timeslot\"}}],\"togetherBuy\":[]}";
//        Gson gson = new Gson();
//        JsonSkuDto j = gson.fromJson(a, JsonSkuDto.class);
//        List<TogetherBuy> tog = new ArrayList<TogetherBuy>();
//        TogetherBuy e = new TogetherBuy();
//        e.setDiscount(10.0);
//        e.setName("测试");
//        e.setTogetherType("G");
//        tog.add(e);
//        TogetherBuy f = new TogetherBuy();
//        f.setDiscount(10.0);
//        f.setName("测试2");
//        f.setTogetherType("c");
//        tog.add(f);
//        j.setTogetherBuy(tog);
//        List<JsonSkuDto> list = new ArrayList<JsonSkuDto>();
//        list.add(j);
//
//        //ps.insertBatch(list);
//    }
//
//    @Test
//    public void queryPageBySupplierIdTest() {
//        ProductRelease release = new ProductRelease();
//        release.setSupplierId("6666");
//        QueryPageModel page = new QueryPageModel();
//        page.setPageNo(1);
//        page.setPageSize(15);
//        QueryPageList<ProductRelease> s = iprs.queryPageBySupplierId(release, page);
//        List<ProductRelease> resultList = s.getResultList();
//        for (ProductRelease p : resultList) {
//            System.out.println(p.getSupplierName());
//            System.out.println(p.getName());
//            System.out.println(p.getStartDate());
//            System.out.println(p.getEndDate());
//            System.out.println(p.getProductCode());
//        }
//
//    }
//}
