/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.pzj.core.stock.context.ShowResponse;
import com.pzj.core.stock.enums.OperateSeatBussinessType;
import com.pzj.core.stock.model.ShowModel;
import com.pzj.core.stock.service.ShowService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.exception.ServiceException;

/**
 * 
 * @author Administrator
 * @version $Id: ShowTest.java, v 0.1 2016年8月10日 下午6:44:40 Administrator Exp $
 */
public class ShowTest extends BaseTest {

    Logger                    logger  = LoggerFactory.getLogger(ShowTest.class);
    static ApplicationContext context = null;
    @Autowired
    private ShowService       showService;

    //    @Test
    public void testOccupySeat() {
        ShowModel showModel = new ShowModel();
        List<String> seats = new ArrayList<String>();
        seats.add("A20_26");
        showModel.setSeats(seats);
        showModel.setTransactionId("abc");
        showModel.setProductId(2216619741564407L);
        showModel.setAreaScreeingsId(16L);
        showModel.setStockId(257L);
        showModel.setOperateBusiness(OperateSeatBussinessType.ORDER_OCCUPY_SEAT.key);
        try {
            showService.occupySeat(showModel, new ServiceContext());
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
    }

    @Test
    public void testReleaseSeat() {
        ShowModel showModel = new ShowModel();
        List<String> seats = new ArrayList<String>();
        seats.add("A20_26");
        showModel.setSeats(seats);
        showModel.setTransactionId("abc");
        showModel.setProductId(2216619741564407L);
        showModel.setAreaScreeingsId(16L);
        showModel.setStockId(257L);
        showModel.setOperateBusiness(OperateSeatBussinessType.CANCLE_ORDER_RELEASE_SEAT.key);
        try {
            showService.releaseSeat(showModel, null);
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
    }

    //    @Test
    public void randomSeats() {
        ShowModel showModel = new ShowModel();
        showModel.setRandomNum(10);
        showModel.setAreaScreeingsId(1L);
        showModel.setStockId(1393L);
        Result<ShowResponse> result = null;
        try {
            result = showService.randomAssignSeat(showModel, null);
            System.out.println("result===" + result);
            ShowResponse resp = result.getData();
            System.out.println("================resp==========" + resp);
            String[] data = resp.getRandomAssignSeats();
            for (String seatNum : data) {
                System.out.println("座位号：" + seatNum);
            }
            System.out.println("返回座位：" + result.getData());
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
    }
}
