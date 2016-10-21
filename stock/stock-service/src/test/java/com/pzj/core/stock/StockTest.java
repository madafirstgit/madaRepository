/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.core.stock.model.CreateStockModel;
import com.pzj.core.stock.model.StockQueryRequestModel;
import com.pzj.core.stock.service.StockService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author dongchunfu
 * @version $Id: StockRuleTest.java, v 0.1 2016年7月25日 下午5:22:45 dongchunfu Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-test.xml" })
public class StockTest {
    @Autowired
    private StockService   stockService;

    ServiceContext         context = ServiceContext.getServiceContext();
    StockQueryRequestModel request = new StockQueryRequestModel();

    @Test
    public void testcreatStock() {
        CreateStockModel model = new CreateStockModel();
        List<Long> ruleIds = new ArrayList<Long>();
        ruleIds.add(2L);
        model.setRuleIds(ruleIds);
        Result<Integer> result = stockService.createStock(model, context);
        if (result.getData() != null) {
            System.out.println(result.getData());
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

}
