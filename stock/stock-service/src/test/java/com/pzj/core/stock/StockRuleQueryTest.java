/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pzj.core.stock.model.StockRuleModel;
import com.pzj.core.stock.model.StockRuleQueryRequestModel;
import com.pzj.core.stock.service.StockRuleQueryService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.entity.QueryResult;

/**
 * 
 * @author Administrator
 * @version $Id: StockRuleQueryTest.java, v 0.1 2016年8月30日 下午3:04:28 Administrator Exp $
 */
public class StockRuleQueryTest {
    static ApplicationContext context = null;

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        System.out.println(context);
    }

    private StockRuleQueryService stockRuleQueryService;

    @Before
    public void setUp() {
        stockRuleQueryService = context.getBean(StockRuleQueryService.class);
    }

    @Test
    public void testqueryStockRulePage() {
        StockRuleQueryRequestModel request = new StockRuleQueryRequestModel();
        request.setSupplierId(2216619746563732L);
        request.setVagueName("sd");
        request.setCurrentPage(1);
        request.setPageSize(20);
        //        request.setState(2);
        //        List<Long> ruleIds = new ArrayList<Long>();
        //        //ruleIds.add(1234567L);
        //        ruleIds.add(1L);
        //        ruleIds.add(2L);
        //        ruleIds.add(15L);
        //        ruleIds.add(87L);
        //        request.setRuleIds(ruleIds);
        Result<QueryResult<StockRuleModel>> result = stockRuleQueryService.queryStockRulePage(request, ServiceContext.getServiceContext());
        QueryResult<StockRuleModel> data = result.getData();
        List<StockRuleModel> records = data.getRecords();
        for (StockRuleModel vo1 : records) {
            System.out.println("state====" + vo1.getState());
            System.out.println("id====" + vo1.getId());
            System.out.println("name====" + vo1.getName());
        }
    }
}
