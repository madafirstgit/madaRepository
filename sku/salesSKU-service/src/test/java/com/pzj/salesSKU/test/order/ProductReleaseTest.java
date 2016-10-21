package com.pzj.salesSKU.test.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.pzj.base.common.utils.DateUtil;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.service.product.IProductReleaseService;
import com.pzj.base.service.product.IProductScenicService;
import com.pzj.product.service.ISkuProductService;
import com.pzj.product.vo.product.SkuProduct;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
                         DirtiesContextTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath*:/META-INF/spring/*.xml" })
public class ProductReleaseTest {

    @Autowired
    IProductReleaseService productReleaseService;
    
    @Autowired
    ISkuProductService skuProductService;
    
    @Autowired
    IProductScenicService productScenicService;
    
   
    
    @Test
    public void testInsert(){
    	ProductScenic entity = new ProductScenic();
    	entity.setName("hahahaqqqq");
    	Long id = productScenicService.insert(entity);
    }

    @Test
    public void testQueryPageh() {
    	
    }

    @Test
    public void testQueryByScenic() {
        ProductRelease release = new ProductRelease();
        release.setScenicId(2216619736565930l);

      //  QueryPageList<ProductRelease> pl = productReleaseService.queryByScenic(release, null, "1");
        System.out.println("haha");
    }
    
    @Test
    public void testIsCanRefund(){
    	List<Long> productIds = new ArrayList<Long>();
    	productIds.add(2216619736568814l);
    	 Calendar   playDate   =   Calendar.getInstance(); 
    	 playDate.add(Calendar.HOUR_OF_DAY, 14);
    	 Date refundDate = new Date();
    	Map<Long, Boolean> result = productReleaseService.isCanRefund(productIds, playDate.getTime(), null, refundDate, true);
    	System.out.println("hahahahha");

  }
    @Test
    public void testQueryByParam(){
    	ProductRelease entity = new ProductRelease();
    	SimpleDateFormat format = new SimpleDateFormat("2016-09-10");
    	
    	productReleaseService.findListByParams(entity);
    }
    
    @Test
    public void findSkuProductById(){
    	Long id = 2216619736569831l;
    	//SkuProduct pro = skuProductService.findSkuProductById(id);
    	//System.out.println(pro.toString());
    	
    }
    
    @Test
    public void testAdvicePrice(){
    	Long id = 2216619736568955l;
    	Double newPrice = 111.0;
    	Long returnId = productReleaseService.adjustPrice(id, newPrice, null, null);
    	System.out.println("新产品id = "+returnId);
    }
   public static void main(String[] args) {
	   int yearShift = 64 - 24;

		int typeShift = yearShift - 8;
		
		Long id = 0l;
		id &= Long.MAX_VALUE;
		id |= (Long.valueOf(0) << typeShift);
		id |= (Long.valueOf(DateUtil.getCurYear()) << yearShift);
       System.out.println("id = "+id);
}
}
