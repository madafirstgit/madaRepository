/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pzj.core.stock.model.SeatModel;
import com.pzj.core.stock.service.SeatService;
import com.pzj.framework.exception.ServiceException;

/**
 * 
 * @author Administrator
 * @version $Id: SeatTest.java, v 0.1 2016年8月11日 下午2:06:41 Administrator Exp $
 */
public class SeatTest {
    Logger                    logger  = LoggerFactory.getLogger(SeatTest.class);
    static ApplicationContext context = null;

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        System.out.println(context);
    }

    private SeatService seatService;

    @Before
    public void setUp() {
        seatService = context.getBean(SeatService.class);
    }

    @Test
    public void testAddSeat() {
        SeatModel seatModel = new SeatModel();
        seatModel.setSeatChartId(4L);
        try {
            seatService.createSeat(seatModel, null);
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
    }
}
