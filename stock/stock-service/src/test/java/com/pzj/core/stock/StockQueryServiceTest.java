/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pzj.core.stock.model.CheckStockModel;
import com.pzj.core.stock.model.StockDateListQueryModel;
import com.pzj.core.stock.model.StockModel;
import com.pzj.core.stock.model.StockQueryRequestModel;
import com.pzj.core.stock.model.UserOccupyStockModel;
import com.pzj.core.stock.service.StockQueryService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author Administrator
 * @version $Id: StockQueryServiceTest.java, v 0.1 2016年7月22日 下午6:09:31 Administrator Exp $
 */
public class StockQueryServiceTest {
    private final static Logger logger = LoggerFactory.getLogger(StockQueryServiceTest.class);


    static ApplicationContext context = null;

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        System.out.println(context);
    }

    private StockQueryService stockQueryService;

    @Before
    public void setUp() {
        stockQueryService = context.getBean(StockQueryService.class);
    }

        @Test
    public void testQueryStock() {
        logger.debug(" ===============================================", context);
        StockQueryRequestModel request = new StockQueryRequestModel();
        Long stockId = -374L;
        request.setStockId(stockId);
        ServiceContext serviceContext = ServiceContext.getServiceContext();
        Result<StockModel> result = stockQueryService.queryStockById(request, serviceContext);
        if (!result.isOk())
            System.out.println("getErrorMsg=" + result.getErrorMsg());
        if (null != result && null != result.getData())
            System.out.println("=======stock==========" + result.getData().getUsedNum());
    }

    @Test
    public void queryStockByRule() {
        StockQueryRequestModel model = new StockQueryRequestModel();
        model.setRuleId(231L);
        model.setStockTime("20160905");
        Result<StockModel> result = stockQueryService.queryStockByRule(model, new ServiceContext());
        StockModel stockModel = result.getData();
        if (!result.isOk())
            System.out.println("======queryStockByRule getErrorMsg===" + result.getErrorMsg());
        if (null != stockModel)
            System.out.println("=======stock id==========" + stockModel.getId());
        System.out.println(stockModel);
    }

    //    @Test
    public void queryStockByDateList() {
        StockDateListQueryModel model = new StockDateListQueryModel();
        model.setStockRuleId(26L);
        ArrayList<String> stockTimeList = new ArrayList<String>();
        stockTimeList.add("2016-08-31");
        stockTimeList.add("2016-09-01");
        stockTimeList.add("2016-09-02");
        model.setStockTimeList(stockTimeList);
        Result<ArrayList<StockModel>> result = stockQueryService.queryStockByDateList(model, ServiceContext.getServiceContext());
        ArrayList<StockModel> stockModelList = result.getData();
        if (!result.isOk())
            System.out.println("======queryStockByDateList getErrorMsg===" + result.getErrorMsg());
        if (null != stockModelList) {
            for (StockModel stockModel : stockModelList) {
                System.out.println("=======stock id==========" + stockModel.getId());
                System.out.println("=======stock stockDate==========" + stockModel.getStockDate());
            }
        }
    }

    //    @Test
    public void queryUserBatchOccupyStock() {
        UserOccupyStockModel model = new UserOccupyStockModel();
        model.setStockRuleId(101L);
        model.setUserId(2216619746563732L);
        Result<UserOccupyStockModel> result = stockQueryService.queryUserBatchOccupyStock(model, ServiceContext.getServiceContext());
        UserOccupyStockModel userstock = result.getData();
        List<StockModel> stockModelList = userstock.getStockModelList();
        if (!result.isOk())
            System.out.println("======queryStockByDateList getErrorMsg===" + result.getErrorMsg());
        if (null != stockModelList) {
            for (StockModel stockModel : stockModelList) {
                System.out.println("=======stock id==========" + stockModel.getId());
                System.out.println("=======stock stockDate==========" + stockModel.getStockDate());
                System.out.println("=======stock userNum==========" + stockModel.getUsedNum());
            }
        }
    }

    //    @Test
    //    public void queryStockByDate() {
    //        StockQueryRequestModel model = new StockQueryRequestModel();
    //        model.setRuleId(113L);
    //        model.setStockTime("2016-08-26");
    //        Result<StockModel> result = stockQueryService.queryStockByDate(model, ServiceContext.getServiceContext());
    //        StockModel stockModel = result.getData();
    //        if (!result.isOk())
    //            System.out.println("======queryStockByDate getErrorMsg===" + result.getErrorMsg());
    //        if (null != stockModel) {
    //            System.out.println("=======stock id==========" + stockModel.getId());
    //            System.out.println("=======stock userNum==========" + stockModel.getUsedNum());
    //        }
    //        System.out.println(stockModel);
    //    }

    //    @Test
    public void judgeStockIsEnough() {
        CheckStockModel checkStockModel = new CheckStockModel();
        checkStockModel.setStockRuleId(261L);
        checkStockModel.setStockTime("20160906");
        checkStockModel.setOccupyNum(5);
        Result<Boolean> result = stockQueryService.judgeStockIsEnough(checkStockModel, ServiceContext.getServiceContext());
        if (result.isOk()) {
            System.out.println("##################---judgeStockIsEnough data---" + result.getData());
        }
    }

    //    @Test
    public void queryallStocks() {
        StockQueryRequestModel model = new StockQueryRequestModel();
        model.setRuleId(2L);
        model.setStockTime("2016-08-26");

        List<Long> stockIds = new ArrayList<Long>();
        //stockIds.add(26L);

        model.setStockIds(stockIds);
        ServiceContext context2 = new ServiceContext();
        Result<ArrayList<StockModel>> result = stockQueryService.queryAllStocks(model, context2);
        ArrayList<StockModel> data = result.getData();
        if (!result.isOk())
            System.out.println("======queryStockByDate getErrorMsg===" + result.getErrorMsg());
        if (null != data)
            System.out.println("=======stock id==========" + data);
        System.out.println("=======stock id==========" + data.size());
    }
}
