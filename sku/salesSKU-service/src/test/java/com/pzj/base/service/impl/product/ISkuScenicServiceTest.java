package com.pzj.base.service.impl.product;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.pzj.framework.context.Result;
import com.pzj.product.service.ISkuScenicService;
import com.pzj.product.vo.product.SkuScenic;
import com.pzj.product.vo.voParam.queryParam.SkuScenicQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath*:/META-INF/spring/applicationContext.xml",
                "classpath*:/META-INF/spring/applicationContext-mybatis.xml",
                "classpath*:/META-INF/spring/redis_generate_id.xml",
                "classpath*:/META-INF/spring/spring_redis.xml",
        })
public class ISkuScenicServiceTest {
	@Autowired
	ISkuScenicService skuScenicService;
	
	SkuProductServiceTestData util = SkuProductServiceTestData.getInstance();
	
	@Test
	public void findSkuScenicByName(){
		SkuScenicQuery query = util.createTestData("/testData/skuScenicData/findSkuScenicByName.json", SkuScenicQuery.class);
	    Result<ArrayList<SkuScenic>> result = skuScenicService.findSkuScenicByName(query);
	    assertNotNull(result);
        assertNotNull(result.getData());
        System.out.println("-------------------------strat---------------------------");
        System.out.println("json : " + JSON.toJSONString(result));
        
        System.out.println("-------------------------end---------------------------");
	}

}
