package com.pzj.base.service.impl.product;

import com.pzj.JsonDataUtil;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.service.product.IProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Administrator on 2016-9-1.
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
public class IProductInfoServiceTest {

    @Autowired
    IProductInfoService productInfoService;

    @Test
    public void queryPageByParamMap(){
        ProductInfo productInfoParam = JsonDataUtil.readObjectFromClasspath("/testData/IProductInfoServiceTest/queryPageByParamMap.json", ProductInfo.class);

        PageModel pageModel = new PageModel(1, 20);

        PageList<ProductInfo> productInfoPageList = productInfoService.queryPageByParamMap(pageModel, productInfoParam);
        assertNotNull(productInfoPageList);
    }
}
