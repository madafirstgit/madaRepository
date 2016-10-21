/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pzj.core.product.model.ActingProductModel;
import com.pzj.core.product.model.ActingProductQueryRequstModel;
import com.pzj.core.product.model.AreaScreeingsRelModel;
import com.pzj.core.product.model.ProScreeningsQueryModel;
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.core.product.service.ActingProductService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author dongchunfu
 * @version $Id: ActingProductTest.java, v 0.1 2016年8月8日 下午7:31:19 dongchunfu Exp $
 */
public class ActingProductTest {
    //    @Resource
    //    private ActingProductService actingProductService;

    static ApplicationContext context = null;

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        System.out.println(context);
    }

    private ActingProductService actingProductService;

    @Before
    public void setUp() {
        actingProductService = context.getBean(ActingProductService.class);
    }

    //    @Test
    public void testqueryInfo4CreateActingProduct() {
        ActingProductQueryRequstModel model = new ActingProductQueryRequstModel();
        model.setScenicId(2216619736563715L);
        model.setSupplierId(2216619746563732L);
        Result<ArrayList<AreaScreeingsRelModel>> result = actingProductService.queryInfoForSkuProduct(model, ServiceContext.getServiceContext());

        if (result.getData() != null) {
            System.out.println(result.getData());
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

    //    @Test
    public void testqueryInfoForCreateActingProduct() {
        ActingProductQueryRequstModel model = new ActingProductQueryRequstModel();
        model.setScenicId(2216619741563787L);
        model.setSupplierId(2216619741564303L);
        Result<ActingProductModel> result = actingProductService.queryInfoForCreateActingProduct(model, ServiceContext.getServiceContext());
        if (result.isOk()) {
            ActingProductModel data = result.getData();
            System.out.println(data);
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

    //    @Test
    public void testqueryActProInfo() {
        ActingProductQueryRequstModel model = new ActingProductQueryRequstModel();
        model.setActProId(146L);
        Result<ActingProductModel> result = actingProductService.queryActProInfo(model, ServiceContext.getServiceContext());
        if (result.isOk()) {
            ActingProductModel data = result.getData();
            System.out.println(data);
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

    @Test
    public void testQueryScreeningsByActPro() {
        ProScreeningsQueryModel model = new ProScreeningsQueryModel();
        model.setActProId(151L);
        Result<ScreeingsModel> result = actingProductService.queryScreeningsByActProductId(model, null);
        if (null != result && null != result.getData()) {
            ScreeingsModel screenings = result.getData();
            System.out.println("----场次名称------" + screenings.getName());
            System.out.println("----场次开始------" + screenings.getStartTime());
            System.out.println("----场次结束------" + screenings.getEndTime());
            System.out.println("----场次停售------" + screenings.getEndSaleTime());
        }
    }
}
