/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pzj.core.common.utils.StockRuleConstant;
import com.pzj.core.stock.enums.StockStateEnum;
import com.pzj.core.stock.model.StockRuleModel;
import com.pzj.core.stock.model.StockRuleQueryRequestModel;
import com.pzj.core.stock.service.StockRuleQueryService;
import com.pzj.core.stock.service.StockRuleService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author dongchunfu
 * @version $Id: StockRuleTest.java, v 0.1 2016年7月25日 下午5:22:45 dongchunfu Exp $
 */
public class StockRuleTest extends BaseTest {
    @Autowired
    private StockRuleService      stockRuleService;
    @Autowired
    private StockRuleQueryService stockRuleQueryService;
    ServiceContext                context = ServiceContext.getServiceContext();

    //    @Test
    public void testInsert() {
        StockRuleModel StockRuleModel = getStockRuleModel();
        Result<Long> result = stockRuleService.createStockRule(StockRuleModel, context);
        System.out.println(result.getData());
    }

    @SuppressWarnings("deprecation")
    //    @Test
    public void testUpState() {
        StockRuleModel vo = getStockRuleModel();
        vo.setId(47L);
        vo.setState(1);
        Result<Integer> result = stockRuleService.updateStockRuleState(vo, context);
        System.out.println(result.getData());
    }

    //    @Test
    public void testqueryStockRuleById() {
        StockRuleQueryRequestModel request = new StockRuleQueryRequestModel();
        request.setRuleId(2L);
        Result<StockRuleModel> result = stockRuleQueryService.queryStockRuleById(request, context);
        System.out.println(result.getData());
    }

    private StockRuleModel getStockRuleModel() {
        StockRuleModel vo = new StockRuleModel();
        vo.setName("测试库存规则1");
        vo.setCategory(1);
        vo.setType(StockRuleConstant.StockRuleType.DAILY);
        vo.setUpperLimit(10000);
        vo.setState(StockRuleConstant.StockRuleState.FORBIDDEN);
        vo.setSupplierId(1234567L);
        vo.setWhetherReturn(StockRuleConstant.WhetherReturn.NORETURN);
        return vo;
    }

    @Test
    public void testupdateStockRule() {
        StockRuleModel model = new StockRuleModel();
        model.setId(278L);
        model.setName("成人11-1407");
        model.setState(StockStateEnum.DISABLED.getState());
        model.setSupplierId(2216619741563734L);
        model.setState(1);
//        model.setWhetherReturn(3);
        Result<Integer> result = stockRuleService.updateStockRule(model, context);
        if (result.isOk()) {
            if (result.getData() != null) {
                System.out.println(result.getData());
            }
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

    //    @Test
    public void testqueryStockRulesByParam() {
        StockRuleQueryRequestModel model = new StockRuleQueryRequestModel();
        //        model.setName("one");
        //        List<Long> ruleIds = new ArrayList<>();
        //        ruleIds.add(1L);
        //        ruleIds.add(2L);
        //        model.setRuleIds(ruleIds);
        model.setRuleId(198L);
        Result<ArrayList<StockRuleModel>> result = stockRuleQueryService.queryStockRulesByParam(model, context);
        if (result.isOk()) {
            if (result.getData() != null) {
                System.out.println(result.getData());
            }
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

    //    @Test
    public void testqueryStockRule4Category() {
        StockRuleQueryRequestModel model = new StockRuleQueryRequestModel();
        //model.setName("one");
        List<Long> ruleIds = new ArrayList<>();
        ruleIds.add(1L);
        ruleIds.add(2L);
        model.setRuleIds(ruleIds);

        Result<StockRuleModel> result = stockRuleQueryService.queryStockRule4Category(model, context);
        if (result.isOk()) {
            if (result.getData() != null) {
                System.out.println(result.getData());
            }
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

    //    @Test
    public void testdeleteStockRule() {

        StockRuleModel model = new StockRuleModel();
        model.setId(3L);
        Result<Integer> result = stockRuleService.fakeDeleteStockRule(model, context);
        if (result.isOk()) {
            if (result.getData() != null) {
                System.out.println(result.getData());
            }
        } else {
            System.out.println(result.getErrorMsg());
        }
    }

}
