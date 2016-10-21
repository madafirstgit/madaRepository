package com.pzj.base.service.impl.product;

import static junit.framework.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.product.vo.voParam.queryParam.CloseTimeSlotQueryParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.JsonDataUtil;
import com.pzj.product.service.ICloseTimeSlotService;
import com.pzj.product.vo.product.SkuCloseTimeSlot;

/**
 * Created by Administrator on 2016-7-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/*.xml")
public class ICloseTimeSlotServiceTest {
    @Autowired
    ICloseTimeSlotService iCloseTimeSlotService;

    @Test
    public void addCloseTimeSlot() throws Exception {
        SkuCloseTimeSlot skuCloseTimeSlot = JsonDataUtil.readObjectFromClasspath("/testData/addCloseTimeSlot.json", SkuCloseTimeSlot.class);

        Long num = iCloseTimeSlotService.addCloseTimeSlot(skuCloseTimeSlot);
        assertNotNull(num);
        System.out.println(num);
    }

    @Test
    public void addBatchCloseTimeSlotList() throws Exception {
        List<SkuCloseTimeSlot> skuCloseTimeSlotList = JsonDataUtil.readListFromClasspath("/testData/addBatchCloseTimeSlot.json", SkuCloseTimeSlot.class);

        Integer num = iCloseTimeSlotService.addBatchCloseTimeSlot(skuCloseTimeSlotList);
        System.out.println(num);

    }

    @Test
    public void saveCloseTimeSlot() throws Exception {
        SkuCloseTimeSlot skuCloseTimeSlot = JsonDataUtil.readObjectFromClasspath("/testData/saveCloseTimeSlot.json", SkuCloseTimeSlot.class);

        Integer num = iCloseTimeSlotService.saveCloseTimeSlot(skuCloseTimeSlot);
        System.out.println(num);
    }

    @Test
    public void saveBatchCloseTimeSlot() throws Exception {
        List<SkuCloseTimeSlot> skuCloseTimeSlotList = JsonDataUtil.readListFromClasspath("/testData/saveBatchCloseTimeSlot.json", SkuCloseTimeSlot.class);

        Integer num = iCloseTimeSlotService.saveBatchCloseTimeSlot(skuCloseTimeSlotList);
        System.out.println(num);
    }

    @Test
    public void delCloseTimeSlot() throws Exception {
        Long id = null;
        Integer num = iCloseTimeSlotService.delCloseTimeSlot(id);
        System.out.println(num);
    }

    @Test
    public void delBatchCloseTimeSlot() throws Exception {
        List<Long> idList = createDelBatchCloseTimeSlotData();
        Integer num = iCloseTimeSlotService.delBatchCloseTimeSlot(idList);
        System.out.println(num);

    }

    private List<Long> createDelBatchCloseTimeSlotData(){
        List<Long> idList = new ArrayList<>();

        return idList;
    }

    @Test
    public void querySkuCloseTimeSlotByParams(){
        CloseTimeSlotQueryParam skuCloseTimeSlotParam = JsonDataUtil.readObjectFromClasspath("/testData/querySkuCloseTimeSlotByParams.json", CloseTimeSlotQueryParam.class);
        List<SkuCloseTimeSlot> skuCloseTimeSlotList = iCloseTimeSlotService.querySkuCloseTimeSlotByParams(skuCloseTimeSlotParam);
        assertNotNull(skuCloseTimeSlotList);
    }
}
