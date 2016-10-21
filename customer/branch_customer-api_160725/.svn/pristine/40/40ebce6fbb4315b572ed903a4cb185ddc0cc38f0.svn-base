package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.pzj.regulation.entity.StrategySettlementRule;
import com.pzj.regulation.entity.StrategyVo;
import com.pzj.regulation.service.StrategyService;
import com.pzj.regulation.service.StrategyServiceImpl;
import com.pzj.regulation.service.StrategySettlementRuleService;
import com.pzj.regulation.service.impl.StrategySettlementRuleServiceImpl;

public class StrategySettlementRuleTest extends TestCase {
    StrategyService strategyService = new StrategyServiceImpl();
    StrategySettlementRuleService settlementService = new StrategySettlementRuleServiceImpl();

    public void testCreateStrategy() throws Exception {
        StrategyVo vo = new StrategyVo();
        vo.setName("测试减免结算");
        StrategySettlementRule rule1 = new StrategySettlementRule();
        rule1.setProductId(2215520224936472l);
        rule1.setNotTotalSettlementType(2);
        rule1.setReduceSettlementMoney(100.00);

        StrategySettlementRule rule2 = new StrategySettlementRule();
        rule2.setProductId(2215520224936472l);
        rule2.setNotTotalSettlementType(2);
        rule2.setReduceSettlementMoney(1250.00);

        List<StrategySettlementRule> ruleList = new ArrayList<StrategySettlementRule>();
        ruleList.add(rule1);
        ruleList.add(rule2);
        vo.setSettlementRuleList(ruleList);

        List<StrategyVo> beans = new ArrayList<StrategyVo>();
        beans.add(vo);
        strategyService.createBatchAndAuth(beans);
        System.out.println("hahahahahahhahahahahha");

    }

    public void testUpdateStrategy() throws Exception {
        StrategyVo vo = new StrategyVo();
        vo.setId(2216619736563772l);
        StrategySettlementRule rule1 = new StrategySettlementRule();
        rule1.setProductId(2215520224936472l);
        rule1.setNotTotalSettlementType(2);
        rule1.setReduceSettlementMoney(300.00);
        rule1.setId(2216619736563716l);

        // StrategySettlementRule rule2 = new StrategySettlementRule();
        // rule2.setProductId(2215520224936472l);
        // rule2.setNotTotalSettlementType(2);
        // rule2.setReduceSettlementMoney(1250.00);

        List<StrategySettlementRule> ruleList = new ArrayList<StrategySettlementRule>();
        ruleList.add(rule1);
        // ruleList.add(rule2);
        vo.setSettlementRuleList(ruleList);

        List<StrategyVo> beans = new ArrayList<StrategyVo>();
        beans.add(vo);
        strategyService.updateBatchAndAuth(beans);
        System.out.println("hahahahahahhahahahahha");

    }

    public void testQuery() throws Exception {
        StrategySettlementRule vo = new StrategySettlementRule();
        List<Long> ids = new ArrayList<Long>();
        ids.add(2216619736563772l);
        ids.add(2216619736563773l);
        vo.setQueryStartegyIdList(ids);
        List list = settlementService.queryByParamMap(vo);
        System.out.println("JHHHHHHHHHHHHHHHHHHHHHHHHHHHHh");

    }

    public void testCreate() throws Exception {
        StrategySettlementRule vo = new StrategySettlementRule();
        vo.setProductId(2215520224936472l);
        vo.setStrategyId(123627l);
        vo.setNotTotalSettlementType(2);
        vo.setReduceSettlementMoney(100.00);
        Long num = settlementService.create(vo);
        System.out.println(" num = " + num);
    }

    public void testUpdate() throws Exception {
        StrategySettlementRule vo = new StrategySettlementRule();
        vo.setProductId(2215520224936472l);
        vo.setStrategyId(123627l);
        vo.setNotTotalSettlementType(2);
        vo.setReduceSettlementMoney(100.00);
        Long num = settlementService.create(vo);
        System.out.println(" num = " + num);
    }

}
