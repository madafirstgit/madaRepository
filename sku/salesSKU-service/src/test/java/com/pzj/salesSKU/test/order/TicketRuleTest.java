/**
 * 
 */
package com.pzj.salesSKU.test.order;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductRuleRel;
import com.pzj.base.entity.product.TicketRule;
import com.pzj.base.service.product.IProductRuleRelService;
import com.pzj.base.service.product.ITicketRuleService;

/**
 * @Author :DongChf
 * @Date :2016年6月5日
 * @Describe:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/META-INF/spring/*.xml" })
public class TicketRuleTest {
    @Autowired
    ITicketRuleService     service;
    @Autowired
    IProductRuleRelService relService;

    @Test
    public void testInsert() {

        TicketRule entity = new TicketRule();
        entity.setName("TEST");
        entity.setRefund(true);
        List<Long> proIds = new ArrayList<>();
        proIds.add(12345l);
        proIds.add(123456l);
        entity.setProIds(proIds);
        service.insert(entity);
    }

    @Test
    public void testdelete() {
        service.delete(2216619736563738L);
    }

    @Test
    public void testInsertBatch() {
        TicketRule entity = new TicketRule();
        entity.setName("batch");
        entity.setRefund(true);
        List<Long> proIds = new ArrayList<>();
        proIds.add(1234665l);
        proIds.add(12346756l);
        entity.setProIds(proIds);
        List<TicketRule> list = new ArrayList<>();

        TicketRule entity2 = new TicketRule();
        entity2.setName("batch");
        entity2.setRefund(true);
        List<Long> proIds2 = new ArrayList<>();
        proIds2.add(1234665l);
        proIds2.add(12346756l);
        entity2.setProIds(proIds);
        list.add(entity);
        list.add(entity2);
        service.insertBatch(list);
    }

    @Test
    public void testupdate() {
        TicketRule entity = new TicketRule();
        entity.setId(2216619736563739L);
        entity.setName("dongchunfu");
        entity.setRefund(true);
        List<Long> proIds = new ArrayList<>();
        proIds.add(777888l);
        proIds.add(888777l);
        entity.setProIds(proIds);
        List<TicketRule> list = new ArrayList<>();
        list.add(entity);
        service.updateByPrimaryKey(entity);
    }

    @Test
    public void testupdateBatch() {
        TicketRule entity = new TicketRule();
        entity.setId(2216619736563739L);
        entity.setName("dongchunfu");
        entity.setRefund(true);
        List<Long> proIds = new ArrayList<>();
        proIds.add(777888l);
        proIds.add(888777l);
        entity.setProIds(proIds);

        List<TicketRule> list = new ArrayList<>();
        list.add(entity);

        TicketRule entity2 = new TicketRule();
        entity2.setId(2216619736563739L);
        entity2.setName("dongchunfu");
        entity2.setRefund(true);
        List<Long> proIds2 = new ArrayList<>();
        entity2.setProIds(proIds2);
        list.add(entity2);

        TicketRule entity3 = new TicketRule();
        entity3.setId(2216619736563739L);
        entity3.setName("dongchunfu");
        entity3.setRefund(true);
        List<Long> proIds3 = null;
        entity3.setProIds(proIds3);
        list.add(entity3);

        Integer in = service.updateBatchByPrimaryKey(list);
        System.out.println(in);
    }

    @Test
    public void testQuery() {
        TicketRule entity = new TicketRule();
        List<Long> proIds = new ArrayList<>();
        proIds.add(2216619736563719l);
        proIds.add(2216619736563739l);
        entity.setRuleIds(proIds);
        PageList<TicketRule> page = service.queryPageByParamMap(null, entity);
        System.out.println(page.getResultList().size());
    }

    @Test
    public void testQueryRel() {
        ProductRuleRel entity = new ProductRuleRel();
        List<Long> proIds = new ArrayList<>();
        proIds.add(888777l);
        proIds.add(777888l);
        entity.setpIds(proIds);
        PageList<ProductRuleRel> page = relService.queryPageByParamMap(null, entity);
        System.out.println(page.getResultList().size());
    }

    @Test
    public void testQueryPageByParamMap() {
        PageModel pager = new PageModel();
        TicketRule entity = new TicketRule();
        //entity.setId(2216619736563778l);
        List<Long> proIds = new ArrayList<>();
        proIds.add(2216619736568954L);
        proIds.add(2216619736568938L);
        entity.setProIds(proIds);
        PageList<TicketRule> page = service.queryPageByParamMap(null, entity);
        List<TicketRule> result = page.getResultList();
        System.out.println(result.size());
    }

    @Test
    public void testQueryAll() {
        //QueryPageModel pager = new QueryPageModel();
        TicketRule entity = new TicketRule();
        entity.setId(2216619736563764l);
        PageList<TicketRule> page = service.queryPageByParamMap(null, entity);
        List<TicketRule> result = page.getResultList();
        System.out.println(result.size());
    }
}
