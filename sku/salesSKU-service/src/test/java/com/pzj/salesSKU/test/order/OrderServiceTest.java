//package com.pzj.salesSKU.test.order;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
//
//import com.pzj.base.entity.json.JsonSkuDto;
//import com.pzj.base.service.sku.ProductService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
//@ContextConfiguration(locations = { "classpath*:/META-INF/spring/applicationContext.xml" })
//public class OrderServiceTest {
//
//	static ApplicationContext context = null;
//
//	@BeforeClass
//	public static void setUpClass() {
//		context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
//		System.out.println(context);
//	}
//
//	@Before
//	public void setUp() {
//		// goodService = context.getBean(GoodService.class);
//	}
//
//	@Test
//	public void testCreateOrder() {
//		// goodService.getGoodById(1L);
//		System.out.println("haha: ");
//	}
//	@Test
//	public void testInserBathc(){
//		ProductService ps = (ProductService) context.getBean("productServiceImpl");
//		List<JsonSkuDto> list = null;
//		ps.insertBatch(list );
//	}
//	
//	
//}
