package com.pzj.base.service.impl.product;


import static junit.framework.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.JsonDataUtil;
import com.pzj.core.stock.model.query.SkuParam;
import com.pzj.core.stock.model.query.StockListParam;
import com.pzj.core.stock.model.query.StockParam;
import com.pzj.core.stock.model.result.JudgeRelationResult;
import com.pzj.core.stock.model.result.SkuRondaRelationResult;
import com.pzj.core.stock.model.result.SkuStockListResult;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
import com.pzj.core.stock.model.result.SkuStockResult;
import com.pzj.core.stock.service.ISkuStockService;
import com.pzj.framework.context.Result;

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
public class ISkuStockServiceTest {
    @Autowired
    ISkuStockService iSkuStockService;
    
    /**
     * 根据库存规则id判断是否有有效的产品与其绑定
     * @param vo 查询参数
     * @return
     */
    @Test
    public void testFindStockSkuRelationByStockId(){
    	StockParam vo = JsonDataUtil.readObjectFromClasspath("/testData/skuStockData/findStockSkuRelationByStockId.json", StockParam.class);
    	Result<JudgeRelationResult> result = iSkuStockService.judgeValidSkuByStockRuleId(vo);
    	assertNotNull(result);
    	System.out.println("查询数据："+result.getData()); 
    	System.out.println("ErrorMsg :"+ result.getErrorMsg());
    	
    }
    
    /**
     * 根据库存规则id获取有效的产品集合
     * @param vo 查询参数
     * @return
     */
    @Test
    public void testFindStockSkuByStockId(){
    	StockParam vo = JsonDataUtil.readObjectFromClasspath("/testData/skuStockData/findStockSkuByStockId.json", StockParam.class);
    	Result<ArrayList<SkuStockResult>> result = iSkuStockService.findStockSkuByStockRuleId(vo);
    	assertNotNull(result); 
    	System.out.println("查询数据："+result.getData());
    	System.out.println("ErrorMsg :"+ result.getErrorMsg());
    	
    }
    
    
    /**
     * 根据库存规则id集合获取有效的产品集合
     * @param vo 查询参数
     * @return
     */
    @Test
    public void testFindStockSkuByStockIds(){
    	StockListParam vo = JsonDataUtil.readObjectFromClasspath("/testData/skuStockData/findStockSkuByStockIds.json", StockListParam.class);
    	Result<ArrayList<SkuStockListResult>> result = iSkuStockService.findStockSkuByStockRuleIds(vo);
    	assertNotNull(result);
    	assertNotNull(result.getData());
    	System.out.println("查询数据："+result.getData());
    	System.out.println("ErrorMsg :"+ result.getErrorMsg());
    	
    }
    
    
    
    /**
     * 根据产品id获取产品对应的场次区域信息
     * @param vo
     * @return
     */
    @Test
    public void testFindSkuRondaRelationByProductId(){
    	SkuParam vo = JsonDataUtil.readObjectFromClasspath("/testData/skuStockData/findStockSkuByStockIds.json", SkuParam.class);
    	Result<SkuRondaRelationResult> result = iSkuStockService.findSkuRondaRelationBySkuId(vo);
    	assertNotNull(result);
    	assertNotNull(result.getData());
    	System.out.println("查询数据："+result.getData());
    	System.out.println("ErrorMsg :"+ result.getErrorMsg());
    }
    
    
    
    /**
     * 获取所有的产品库存有效关系
     * @return 
     */
    @Test
    public void testGetAllValidSkuRondaRelation(){
    	Result<ArrayList<SkuStockRelationResult>> result = iSkuStockService.getAllValidSkuRondaRelation();
    	assertNotNull(result);
    	assertNotNull(result.getData());
    	System.out.println("查询数据："+result.getData());
    	System.out.println("ErrorMsg :"+ result.getErrorMsg());
    }
  
}
