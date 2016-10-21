package com.pzj.base.service.impl.product;


import static junit.framework.Assert.assertNotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.pzj.JsonDataUtil;
import com.pzj.channel.Channel;
import com.pzj.channel.Strategy;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.common.QueryPageBean;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.framework.context.Result;
import com.pzj.product.service.ISkuProductService;
import com.pzj.product.vo.AttrInfo;
import com.pzj.product.vo.BaseInfo;
import com.pzj.product.vo.JsonSkuDto;
import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SkuProductScenic;
import com.pzj.product.vo.product.SkuRondaRelation;
import com.pzj.product.vo.product.SkuSiteData;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.modificationParam.SpuProductModificationVO;
import com.pzj.product.vo.voParam.queryParam.ProductSaledParam;
import com.pzj.product.vo.voParam.queryParam.SkuProductForScenicQuery;
import com.pzj.product.vo.voParam.queryParam.SkuProductQueryParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductBasicInfoParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductForCommonsQueryParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductQueryParamVO;
import com.pzj.product.vo.voParam.resultParam.PCAddressResult;
import com.pzj.product.vo.voParam.resultParam.SkuCanSaledResult;
import com.pzj.product.vo.voParam.resultParam.SkuImportResult;
import com.pzj.product.vo.voParam.resultParam.SkuProductForScenic;
import com.pzj.product.vo.voParam.resultParam.SkuProductResultVO;
import com.pzj.product.vo.voParam.resultParam.SpuProductResultVO;

/**
 * Created by Administrator on 2016-7-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath*:/META-INF/spring/applicationContext.xml",
                "classpath*:/META-INF/spring/applicationContext-mybatis.xml",
                "classpath*:/META-INF/spring/redis_generate_id.xml",
                "classpath*:/META-INF/spring/spring_redis.xml",
        })
/*@ContextConfiguration(
        locations = {
                "classpath*:/client-test.xml"
        })*/
public class ISkuProductServiceTest {
    @Autowired
    ISkuProductService iSkuProductService;
    
    SkuProductServiceTestData util = SkuProductServiceTestData.getInstance();
    
  
    @Test
    public void addSkuProductAndAuth() throws Exception {
        SpuProductModificationVO spuProductModificationVO = util.createTestData("/testData/addSpuProductAndAuth.json", SpuProductModificationVO.class);
 
        Long spuProductModificationVOId = iSkuProductService.addSpuProductAndAuth(spuProductModificationVO);
 
        assertNotNull(spuProductModificationVOId); 

        System.out.println("\r\n>>>>>> " + spuProductModificationVOId);
    }

   

    @Test
    public void saveSkuProductAndAuth() throws Exception {
        SpuProductModificationVO spuProductModificationVO = util.createTestData("/testData/addSpuProductAndAuth.json", SpuProductModificationVO.class);

        Integer num = iSkuProductService.saveSpuProductAndAuth(spuProductModificationVO);

        assertNotNull(num);

        System.out.println("\r\n>>>>>> " + num);
    }

   

    @Test
    public void saveSpuProduct() throws Exception {
        SpuProduct spuProduct = util.createTestData("/testData/addSpuProductAndAuth.json", SpuProduct.class);

        Integer num = iSkuProductService.saveSpuProduct(spuProduct);

        assertNotNull(num);

        System.out.println("\r\n>>>>>> " + num);
    }

   

    @Test
    public void saveSkuProduct() throws Exception {
        SkuProduct skuProduct = util.createTestData("/testData/addSpuProductAndAuth.json", SkuProduct.class);

        Integer num = iSkuProductService.saveSkuProduct(skuProduct);

        assertNotNull(num);

        System.out.println("\r\n>>>>>> " + num);
    }

    @Test
    public void saveSkuProductByParentId() throws Exception {
        List<SkuProduct> voList = util.createTestDataList("/testData/saveSkuProductByParentId.json", SkuProduct.class);

        Integer num = iSkuProductService.saveSkuProductByParentId(voList);

        assertNotNull(num);
 
        System.out.println("\r\n>>>>>> " + num); 
    }

    @Test
    public void findSkuProductForApp() throws Exception {          
    	
        SpuProductQueryParamVO spuProductQueryParamVO = util.createTestData("/testData/findSkuProductForApp.json", SpuProductQueryParamVO.class);
        List<SpuProductResultVO> skuProductForAppList = iSkuProductService.findSkuProductForApp(spuProductQueryParamVO);
        QueryPageModel qpm = new QueryPageModel(1, 10);
        QueryPageList<SpuProductResultVO> skuProductForAppList2 = iSkuProductService.findSkuProductForApp(spuProductQueryParamVO, qpm);
        assertNotNull(skuProductForAppList);

        String jsonString = JSON.toJSONString(skuProductForAppList); 
        System.out.println(jsonString);
    }
    
    @Test
    public void findSpuAddressByDistributorId() throws Exception {
        SpuProductQueryParamVO spuProductQueryParamVO = util.createTestData("/testData/findSkuProductForApp.json", SpuProductQueryParamVO.class);
        List<PCAddressResult> resultList = iSkuProductService.findSpuAddressByDistributorId(spuProductQueryParamVO);
        assertNotNull(resultList);

        System.out.println("======================================================");
        String jsonString = JSON.toJSONString(resultList);
        System.out.println(jsonString);
    }

   
    @Test
    public void findSkuProductById() throws Exception {
        Long skuProductId = 2216619736563740L;

        SkuProductResultVO skuProductResultVO = iSkuProductService.findSkuProductById(skuProductId);
        assertNotNull(skuProductResultVO);

        // 验证产品
        SkuProduct skuProduct = skuProductResultVO.getSkuProduct();
        assertNotNull(skuProduct);

        // 验证产品组
        SpuProduct spuProduct = skuProductResultVO.getSpuProduct();
        assertNotNull(spuProduct);

        // 验证景区
        List<SkuProductScenic> scenic = skuProductResultVO.getScenic();
        assertNotNull(scenic);

        // 验证景点
        List<SkuSiteData> siteDateList = skuProductResultVO.getSiteDateList();
        assertNotNull(siteDateList);

        // 验证场次区域
        List<SkuRondaRelation> rondaRelationList = skuProductResultVO.getRondaRelationList();
        assertNotNull(rondaRelationList);

        List<SkuCloseTimeSlot> closeTimeSlotList = skuProductResultVO.getCloseTimeSlotList();
        assertNotNull(closeTimeSlotList);

        List<PCStrategyResult> pcStrategyResultList = skuProductResultVO.getStrategyList();
        assertNotNull(pcStrategyResultList);

        for (PCStrategyResult pcStrategyResult : pcStrategyResultList){
            assertNotNull(pcStrategyResult.getProductId());

            Channel channel = pcStrategyResult.getChannel();
            assertNotNull(channel);

            List<Strategy> strategyList = pcStrategyResult.getStrategyList();
            assertNotNull(strategyList);

            // 有的政策没数据，所以ruleList不能测试。
            //List<SettlementRule> ruleList = pcStrategyResult.getRuleList();
            //assertNotNull(ruleList);
        }




        SkuProductResultVO fileSkuProductResultVO = JsonDataUtil.readObjectFromClasspath("/testData/findSkuProductById.json", SkuProductResultVO.class);
        String aString = JSON.toJSONString(skuProductResultVO);
        String bString = JSON.toJSONString(fileSkuProductResultVO);

        System.out.println(aString);
        System.out.println(bString);
        //assertEquals(aString, bString);
    }

    @Test
    public void findSkuproductForSupplier () throws Exception {
        //SkuProductQueryParam spuProductQueryParamVO = createFindSkuproductForSupplierData();
        SkuProductQueryParam spuProductQueryParamVO = null;
        List<SkuProductResultVO> skuproductForSupplierList = iSkuProductService.findSkuproductForSupplier(spuProductQueryParamVO);
        assertNotNull(skuproductForSupplierList);
    }

    private SkuProductQueryParam createFindSkuproductForSupplierData(){
        SkuProductQueryParam skuProductQueryParam = JsonDataUtil.readObjectFromClasspath("/testData/findSkuproductForSupplier.json", SkuProductQueryParam.class);
        return skuProductQueryParam;
    }

    @Test
    public void findSkuproductForSupplierPage () throws Exception {
        //SkuProductQueryParam spuProductQueryParamVO = createFindSkuproductForSupplierData();
        SkuProductQueryParam spuProductQueryParamVO = new SkuProductQueryParam();
        QueryPageModel queryPageModel = new QueryPageModel(1, 10);
        QueryPageList<SkuProductResultVO> skuproductForSupplierPageList = iSkuProductService.findSkuproductForSupplier(spuProductQueryParamVO, queryPageModel);
        assertNotNull(skuproductForSupplierPageList);

        QueryPageBean pageBean = skuproductForSupplierPageList.getPageBean();
        assertNotNull(pageBean);

        List<SkuProductResultVO> resultList = skuproductForSupplierPageList.getResultList();
        assertNotNull(resultList);
    }

    @Test
    public void isCanSaled() throws Exception{
        List<ProductSaledParam> productSaledParamList = createIsCanSaledData();
        List<SkuCanSaledResult> canSaled = iSkuProductService.isCanSaled(productSaledParamList);
        assertNotNull(canSaled);
    }

    private List<ProductSaledParam> createIsCanSaledData(){
        List<ProductSaledParam> productSaledParamList = JsonDataUtil.readListFromClasspath("/testData/IsCanSaledData.json", ProductSaledParam.class);
        return productSaledParamList;
    }

    @Test
    public void importSku() throws Exception {
        List<JsonSkuDto> jsonSkuDtoList = JsonDataUtil.readListFromClasspath("/testData/importSku.json", JsonSkuDto.class);
       Result<SkuImportResult> num = iSkuProductService.importSku(jsonSkuDtoList);
        assertNotNull(num);
    }

    private List<JsonSkuDto> createImportSkuData(){
        List<JsonSkuDto> jsonSkuDtoList = new ArrayList<>();

        {
            BaseInfo baseInfo = null;

            List<SkuCloseTimeSlot>  timeSlotsList = null;

            List<AttrInfo> attrInfosList = null;

            JsonSkuDto jsonSkuDto = new JsonSkuDto();
            jsonSkuDto.setBaseInfo(baseInfo);
            jsonSkuDto.setTimeSlots(timeSlotsList);
            jsonSkuDto.setAttrInfos(attrInfosList);
       

            jsonSkuDtoList.add(jsonSkuDto);
        }

        return jsonSkuDtoList;
    }

    @Test
    public void findSpuproductForSupplier(){
        QueryPageModel pageModel = new QueryPageModel(1, 20, "releasee.publish_date desc");
        SkuProductQueryParam skuProductQueryParam = JsonDataUtil.readObjectFromClasspath("/testData/findSpuproductForSupplier.json", SkuProductQueryParam.class);
        QueryPageList<SpuProductResultVO> spuproductForSupplier = iSkuProductService.findSpuproductForSupplier(skuProductQueryParam, pageModel);
        assertNotNull(spuproductForSupplier);

        List<SpuProductResultVO> resultList = spuproductForSupplier.getResultList();
        for (SpuProductResultVO resultVO : resultList){
            System.out.println(resultVO.getSpuProduct().getId());
        }
    }

    @Test
    public void findSpuProductBasicInfoByParams(){
        SpuProductBasicInfoParam skuProductQueryParam = JsonDataUtil.readObjectFromClasspath("/testData/findSpuProductBasicInfoByParams.json", SpuProductBasicInfoParam.class);
        //Result<SpuProductBasicInfoResult> basicInfoResultResult = iSkuProductService.findSpuProductBasicInfoByParams(skuProductQueryParam);
        //assertNotNull(basicInfoResultResult);


    }

    @Test
    public void findSkuProductForScenic(){
        SkuProductForScenicQuery query = JsonDataUtil.readObjectFromClasspath("/testData/findSkuProductForScenic.json", SkuProductForScenicQuery.class);;
        QueryPageModel pageModel = new QueryPageModel(1, 10);
        Result<QueryPageList<SkuProductForScenic>> pageListResult = iSkuProductService.findSkuProductForScenic(query, pageModel);
        assertNotNull(pageListResult);

        QueryPageList<SkuProductForScenic> data = pageListResult.getData();
        assertNotNull(data);

        List<SkuProductForScenic> resultList = data.getResultList();
        assertNotNull(resultList);

        SkuProductForScenic skuProductForScenic = resultList.get(0);
        assertNotNull(skuProductForScenic.getSkuProduct());
        assertNotNull(skuProductForScenic.getSpuProduct());
        assertNotNull(skuProductForScenic.getStrategyList());
    }


    @Test
    public void findSpuProductForCommons(){
        SpuProductForCommonsQueryParam query = JsonDataUtil.readObjectFromClasspath("/testData/findSpuProductForCommons.json", SpuProductForCommonsQueryParam.class);;



        QueryPageModel pageModel = new QueryPageModel(1, 10);
        Result<QueryPageList<SpuProductResultVO>> pageListResult = iSkuProductService.findSpuProductForCommons(query, pageModel);
        assertNotNull(pageListResult);

        QueryPageList<SpuProductResultVO> data = pageListResult.getData();
        assertNotNull(data);

        List<SpuProductResultVO> resultList = data.getResultList();
        assertNotNull(resultList);

        SpuProductResultVO skuProductForScenic = resultList.get(0);
        assertNotNull(skuProductForScenic.getSkuProductList());
        assertNotNull(skuProductForScenic.getSpuProduct());
        assertNotNull(skuProductForScenic.getStrategyList());
    }



    @Test
    public void findSpuProductById(){
        Long id = 2216619741564345L;
        Result<SpuProductResultVO> result = iSkuProductService.findSpuProductById(id);
        assertNotNull(result);

    }

    public static void main(String[] args) {
        Double aa  = 10000000.0;
        System.out.println(aa.toString());
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(aa));
    }
}
