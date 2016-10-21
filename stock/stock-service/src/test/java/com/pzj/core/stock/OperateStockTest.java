/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.enums.OperateStockBussinessType;
import com.pzj.core.stock.model.CreateStockModel;
import com.pzj.core.stock.model.OccupyStockRequestModel;
import com.pzj.core.stock.model.StockBatchLockModel;
import com.pzj.core.stock.service.StockService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;

/**
 * 
 * @author Administrator
 * @version $Id: OperateStockTest.java, v 0.1 2016年8月10日 下午1:48:46 Administrator Exp $
 */
public class OperateStockTest {
    Logger                    logger  = LoggerFactory.getLogger(OperateStockTest.class);
    static ApplicationContext context = null;

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        System.out.println(context);
    }

    private StockService stockService;

    @Before
    public void setUp() {
        stockService = context.getBean(StockService.class);
    }

    //    @Test
    public void createStock() {
        ServiceContext context = new ServiceContext();

        CreateStockModel model = new CreateStockModel();
        List<Long> ruleIds = new ArrayList<Long>();
        ruleIds.add(281L);
        model.setRuleIds(ruleIds);
        Result<Integer> result = stockService.createStock(model, context);
        if (!result.isOk())
            System.out.println("=======error msg========" + result.getErrorMsg());
        System.out.println("---------createStock result data:-------" + result.getData());
    }

    //    @Test
    public void testOccupyStock() {
        OccupyStockRequestModel requestModel = new OccupyStockRequestModel();
        requestModel.setTransactionId("abc");
        requestModel.setProductId(1234L);
        requestModel.setStockId(231L);
        requestModel.setStockNum(1);

        Result<Boolean> result = null;
        try {
            result = stockService.occupyStock(requestModel, null);
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
        if (CommonUtils.checkObjectIsNull(result)) {
            return;
        }
        if (result.isOk()) {
            System.out.println("操作返回结果：" + result.getData());
        } else {
            System.out.println("错误信息：" + result.getErrorMsg());
        }
    }

    //    @Test
    public void testReleaseStock() {
        OccupyStockRequestModel requestModel = new OccupyStockRequestModel();
        requestModel.setTransactionId("abc");
        requestModel.setProductId(1234L);
        requestModel.setStockId(231L);
        requestModel.setStockNum(1);

        Result<Boolean> result = null;
        try {
            result = stockService.releaseStock(requestModel, null);
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }

        if (!result.isOk()) {
            System.out.println("错误信息：" + result.getErrorMsg());
        }
    }

    //    @Test
    public void batchOccupyStock() {
        //        int count = 0;
        //        while (count < 100) {
        //            count++;

        StockBatchLockModel stockBatchLockModel = new StockBatchLockModel();
        Map<Long, Integer> operateStockMap = new HashMap<Long, Integer>();
        operateStockMap.put(1019L, 11);
        //        operateStockMap.put(1020L, 1);
        //        operateStockMap.put(1021L, 1);
        //        operateStockMap.put(1024L, 1);
        //        operateStockMap.put(1025L, 1);
        //        operateStockMap.put(1026L, 1);
        //        operateStockMap.put(1027L, 1);
        stockBatchLockModel.setOperateStockMap(operateStockMap);
        stockBatchLockModel.setOperateType(OperateStockBussinessType.BATCH_RELEASE_STOCK.key);
        stockBatchLockModel.setUserId(2216619746563732L);

        Result<Boolean> result = null;
        try {
            result = stockService.stockBatchLock(stockBatchLockModel, null);
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
        if (!result.isOk()) {
            System.out.println("错误信息：" + result.getErrorMsg());
        } else {
            System.out.println("操作返回结果：" + result.getData());
        }
        //        }

    }
}
