package com.pzj.base.service.impl.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.service.product.IProductInfoService;
import com.pzj.base.service.product.IProductScenicService;
import com.pzj.product.vo.voParam.queryParam.AppSearchQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath*:/META-INF/spring/applicationContext.xml",
                "classpath*:/META-INF/spring/applicationContext-mybatis.xml",
                "classpath*:/META-INF/spring/redis_generate_id.xml",
                "classpath*:/META-INF/spring/spring_redis.xml",
        })
public class IProductScenicServiceTest {
	
	@Autowired
	IProductScenicService iProductScenicService;
	
	@Autowired
	IProductInfoService iProductInfoService;
	
	SkuProductServiceTestData util = SkuProductServiceTestData.getInstance();
	@Test
	public void queryScenicsByAppSearchKey(){
		AppSearchQuery vo = new AppSearchQuery();
		String[] strs = {"陕西省","四川省","湖南省"};
		
				//util.createTestData("/testData/queryScenicsByAppSearchKey.json", AppSearchQuery.class);
		for(int i=0; i<3; i++){
			vo.setProvince(strs[i]);
			long start = System.currentTimeMillis();		
			System.out.println("-----------------------------------------------------"+i+"开始时间："+(System.currentTimeMillis()-start));
			iProductScenicService.queryScenicsByAppSearchKey(vo);
			System.out.println("-----------------------------------------------------"+i+"执行效率："+(System.currentTimeMillis()-start));
			
		}
		
	}
	
	@Test
	public void findByParam(){
		
	 //util.createTestData("/testData/queryScenicsByAppSearchKey.json", AppSearchQuery.class);
		ProductInfo info = new ProductInfo();
		String[] strs = {"陕西省","四川省","湖南省"};
		for(int i=0; i<3; i++){
			info.setProvince(strs[i]);
			long start = System.currentTimeMillis();	
			System.out.println("-----------------------------------------------------"+i+"开始时间："+(System.currentTimeMillis()-start));
			iProductInfoService.findListByParams(info);
			System.out.println("-----------------------------------------------------"+i+"执行效率："+(System.currentTimeMillis()-start));
			
		}
		
	}
	
	
	
	
	
	
	

}
