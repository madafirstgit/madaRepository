/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pzj.core.stock.model.SeatChartModel;
import com.pzj.core.stock.service.SeatChartService;
import com.pzj.framework.context.Result;
import com.pzj.framework.exception.ServiceException;
import com.pzj.framework.toolkit.Check;

/**
 * 
 * @author Administrator
 * @version $Id: SeatChartTest.java, v 0.1 2016年8月11日 下午2:07:01 Administrator Exp $
 */
public class SeatChartTest {

    Logger                    logger  = LoggerFactory.getLogger(SeatChartTest.class);
    static ApplicationContext context = null;

    private SeatChartService  seatChartService;

    @BeforeClass
    public static void setUpClass() {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        System.out.println(context);
    }

    @Before
    public void setUp() {
        seatChartService = context.getBean(SeatChartService.class);
    }

    @Test
    public void testAddSeatChart() {
        //        String aAreaSeatMaps = "A2,_,_,_,24,22,20,18,16,_,_,_,_,_,17,19,21,23,25,_;A3,_,_,_,26,24,22,20,18,_,_,_,_,_,17,19,21,23,25,_;A4,_,_,_,26,24,22,20,18,_,_,_,_,_,19,21,23,25,27,_;A5,_,_,_,28,26,24,22,20,_,_,_,_,_,19,21,23,25,27,_;A6,_,_,32,30,28,26,24,22,_,_,_,_,_,19,21,23,25,27,29,_;A7,_,_,32,30,28,26,24,22,_,_,_,_,_,21,23,25,27,29,31,_;A8,_,_,32,30,28,26,24,22,_,_,_,_,_,23,25,27,29,31,33,_;A9,_,_,34,32,30,28,26,24,_,_,_,_,_,23,25,27,29,31,33,_;A10,38,36,34,32,30,28,26,_,_,_,_,_,23,25,27,29,31,33,35,_;A11,38,36,34,32,30,28,26,_,_,_,_,_,25,27,29,31,33,35,37,_;A12,38,36,34,32,30,28,26,_,_,_,_,_,23,25,27,29,31,33,35,_;_,_,_,_,_,_,_,_,_,_,_,_,_,_;A13,_,36,34,32,30,28,26,_,_,_,_,_,25,27,29,31,33,35,_;A14,_,_,34,32,30,28,26,_,_,_,_,_,23,25,27,29,31,_;A15,_,_,_,30,28,26,24,_,_,_,_,_,23,25,27,29,_;A16,_,_,_,32,30,28,26,_,_,_,_,_,23,25,27,29,_;A17,_,_,_,30,28,26,24,_,_,_,_,_,23,25,27,29,_;A18,_,_,32,30,28,26,24,_,_,_,_,_,21,23,25,27,29,_;A19,_,_,30,28,26,24,22,_,_,_,_,_,21,23,25,27,29,_;A20,_,_,_,26,24,22,20,_,_,_,_,_,17,19,21,23,_;A21,_,_,_,_,_,30,28,_,_,_,_,_,25,27,_";
        //        String bAreaSeatMaps = "B1,_,_,_,_,_,_,_,_,_,_,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33,31;B2,_,_,_,_,_,_,_,_,_,_,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33,31;B3,_,_,_,_,_,_,_,_,_,_,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33,31;B4,_,_,_,_,_,_,_,_,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33,31;B5,_,_,_,_,_,_,_,_,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33,31;B6,_,_,_,_,_,_,_,_,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33;B7,_,_,_,_,_,_,_,_,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33;B8,_,_,_,_,_,_,_,_,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33;B9,_,_,_,_,_,_,_,_,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33;B10,_,_,_,_,_,_,_,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35,33;B11,_,_,_,_,91,89,_,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35;B12,_,95,93,91,89,_,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37,35;B13,97,95,93,91,_,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37;B14,99,97,95,93,_,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37;B15,99,97,95,93,_,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37;B16,99,97,95,93,_,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37;B17,99,97,95,93,_,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39,37;B18,103,101,99,97,_,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39;B19,105,103,101,99,_,97,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39;B20,105,103,101,99,_,97,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41,39;B21,105,103,101,_,99,97,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41;B22,105,103,101,_,99,97,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41;B23,103,101,_,99,97,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41;B24,105,103,101,99,97,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43,41;B25,_,103,101,99,97,95,93,91,89,87,85,83,81,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43;B26,_,_,_,_,_,_,_,_,_,_,_,_,_,_,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43;B27,_,_,_,_,_,_,_,_,_,_,_,_,_,79,77,75,73,71,69,67,65,63,61,59,57,55,53,51,49,47,45,43;B28,_,_,_,_,_,_,_,_,_,_,_,_,_,57,55,53,51,49,47,45,43";
        String vipAreaSeatMaps = "VIPA6,_,_,_,_,_,_,20,18,16,14,12,10,8,6,4,2,1,3,5,7,9,11,13,15,17,_;VIPA7,_,_,_,_,_,20,18,16,14,12,10,8,6,4,2,1,3,5,7,9,11,13,15,17,19,_;VIPA8,_,_,_,_,20,18,16,14,12,10,8,6,4,2,1,3,5,7,9,11,13,15,17,19,21,_;VIPA9,_,_,_,22,20,18,16,14,12,10,8,6,4,2,1,3,5,7,9,11,13,15,17,19,21,_;VIPA10,_,_,24,22,20,18,16,14,12,10,8,6,4,2,1,3,5,7,9,11,_;";
        SeatChartModel seatChartModel = new SeatChartModel();
        seatChartModel.setScenicId(2216619741563800L);
        seatChartModel.setAreaId(4L);
        seatChartModel.setSeatMaps(vipAreaSeatMaps);

        try {
            seatChartService.addSeatChart(seatChartModel, null);
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
    }

    //    @Test
    public void testQuerySeatChart() {
        SeatChartModel seatChartModel = new SeatChartModel();
        seatChartModel.setScenicId(12345L);
        seatChartModel.setAreaId(114L);
        try {
            Result<ArrayList<SeatChartModel>> result = seatChartService.querySeatChartByScenicAndAreaRel(seatChartModel, null);
            if (result.isOk() && !Check.NuNCollections(result.getData())) {
                ArrayList<SeatChartModel> seatChartList = result.getData();
                System.out.println("seatChartList size======" + seatChartList.size());
                SeatChartModel chartModel = seatChartList.get(0);
                System.out.println("chartModel getScenicId======" + chartModel.getScenicId());
                System.out.println("chartModel getAreaId======" + chartModel.getAreaId());
                System.out.println("chartModel getSeatMaps======" + chartModel.getSeatMaps());
                System.out.println("chartModel getSort======" + chartModel.getSort());
                System.out.println("chartModel getTotalSeats======" + chartModel.getTotalSeats());
            }

        } catch (Exception e) {
            if (e instanceof ServiceException) {
                logger.error("异常：" + e.getMessage());
            } else {
                logger.error("未处理异常：", e);
            }
        }
    }
}
