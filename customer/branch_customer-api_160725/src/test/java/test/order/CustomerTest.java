package test.order;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.pzj.app.service.impl.AppEquipmentServiceImpl;
import com.pzj.app.service.impl.AppFeedbackServiceImpl;
import com.pzj.app.service.impl.AppMessageServiceImpl;
import com.pzj.app.vo.AppEquipmentVO;
import com.pzj.app.vo.AppFeedbackVO;
import com.pzj.app.vo.AppMessageVO;
import com.pzj.base.common.BaseVO;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.impl.ChannelServiceImpl;
import com.pzj.customer.entity.Customer;
import com.pzj.customer.entity.CustomerRelation;
import com.pzj.customer.service.CustomerServiceImpl;
import com.pzj.department.entity.Department;
import com.pzj.department.service.DepartmentServiceImpl;
import com.pzj.label.entity.LabelVo;
import com.pzj.label.service.impl.LabelServiceimpl;
import com.pzj.log.entity.OperatorLog;
import com.pzj.log.service.OperatorLogServiceImpl;
import com.pzj.menu.entity.Menu;
import com.pzj.menu.service.MenuServiceImpl;
import com.pzj.regulation.entity.RebateStrategyVo;
import com.pzj.regulation.entity.StrategyVo;
import com.pzj.regulation.service.StrategyService;
import com.pzj.regulation.service.StrategyServiceImpl;
import com.pzj.role.entity.Role;
import com.pzj.role.service.RoleServiceImpl;
import com.pzj.util.CommonEntity;
import com.pzj.util.KeyValueVo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用于测试分页查询默认按ID倒序
 * 
 * Created by Administrator on 2015-12-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class CustomerTest {
    @Autowired
    CustomerServiceImpl customerService = null;
    @Test
    public void findByUserOfficeRole2() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;

        PageList<Customer> result = customerService.findByUserOfficeRole2(
                start, size, param);

        compareCommonEntityOrder(result);
    }

    private void compareCommonEntityOrder(PageList<?> result) {
        assertNotNull(result);

        List<?> customerList = result.getResultList();
        assertNotNull(customerList);

        int size = customerList.size();
        for (int i = 1; i < size; i++) {
            CommonEntity entityA = (CommonEntity) customerList.get(i - 1);
            CommonEntity entityB = (CommonEntity) customerList.get(i);
            Long aId = entityA.getId();
            Long bId = entityB.getId();
            assertTrue(aId > bId);
        }
    }

    @Test
    public void findCustomerAuthPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;

        PageList<Customer> result = customerService
                .findCustomerAuthPageByParams(start, size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findCustomerByCRInfo() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;

        PageModel pm = new PageModel(start, size);

        PageList<Customer> result = customerService.findCustomerByCRInfo(pm,
                param, null);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findCustomerPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;

        PageList<Customer> result = customerService.findCustomerPageByParams(
                start, size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findCustomerScenicPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<Customer> result = customerService
                .findCustomerScenicPageByParams(pm, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findCustomerWDPageByParams() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<Customer> result = customerService.findCustomerWDPageByParams(
                pm, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findRefCustomerByRelation() throws Exception {
        Customer param = new Customer();
        //param.setCorporaterCredentials("11010119921201");

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);
        CustomerRelation relation = new CustomerRelation();
        relation.setRelUserId(2216619746563733L);
        relation.setRelType("5");

        PageList<Customer> result = customerService.findRefCustomerByRelation(
                relation, param, null);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findMasCustomerByRelation() throws Exception {
        Customer param = new Customer();
        //param.setCorporaterCredentials("11010119921201");

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);
        CustomerRelation relation = new CustomerRelation();
        relation.setRelUserId(2216619736763824l);
        //relation.setRelType("5");

        PageList<Customer> result = customerService.findMasCustomerByRelation(
                relation, param, null);

        compareCommonEntityOrder(result);
    }

    @Test
    public void queryPageByChannelId() throws Exception {
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Customer param = new Customer();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);
        CustomerRelation relation = new CustomerRelation();

        PageList<Customer> result = customerService.queryPageByChannelId(pm,
                param, 1L);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findMenuPageByParams() throws Exception {
        MenuServiceImpl menuService = new MenuServiceImpl();

        Menu param = new Menu();

        Integer start = 1;
        Integer size = 10;

        PageList<Menu> result = menuService.findMenuPageByParams(start, size,
                param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findByDempartmentRole() throws Exception {
        RoleServiceImpl roleService = new RoleServiceImpl();

        Role param = new Role();

        Integer start = 1;
        Integer size = 10;

        PageList<Role> result = roleService.findByDempartmentRole(start, size,
                param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findRoleAuthPageByParams() throws Exception {
        RoleServiceImpl roleService = new RoleServiceImpl();

        Role param = new Role();

        Integer start = 1;
        Integer size = 10;

        PageList<Role> result = roleService.findRoleAuthPageByParams(start,
                size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findRolePageByParams() throws Exception {
        RoleServiceImpl roleService = new RoleServiceImpl();

        Role param = new Role();

        Integer start = 1;
        Integer size = 10;

        PageList<Role> result = roleService.findRolePageByParams(start, size,
                param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findDepartmentAuthPageByParams() throws Exception {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        Department param = new Department();

        Integer start = 1;
        Integer size = 10;

        PageList<Department> result = departmentService
                .findDepartmentAuthPageByParams(start, size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void findDepartmentPageByParams() throws Exception {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        Department param = new Department();

        Integer start = 1;
        Integer size = 10;

        PageList<Department> result = departmentService
                .findDepartmentPageByParams(start, size, param);

        compareCommonEntityOrder(result);
    }

    @Test
    public void queryPageByParamMap() throws Exception {
        LabelServiceimpl labelServiceimpl = new LabelServiceimpl();

        LabelVo param = new LabelVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<LabelVo> result = labelServiceimpl.queryPageByParamMap(pm,
                param);
        compareCommonEntityOrder(result);
    }

    @Test
    public void StrategyVoqueryPageByParamMap() throws Exception {
        StrategyServiceImpl strategyService = new StrategyServiceImpl();

        StrategyVo param = new StrategyVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<StrategyVo> result = strategyService.queryPageByParamMap(pm,
                param);
        compareStrategyVoOrder(result);
    }

    private void compareStrategyVoOrder(PageList<StrategyVo> result) {
        assertNotNull(result);

        List<StrategyVo> customerList = result.getResultList();
        assertNotNull(customerList);

        int size = customerList.size();
        for (int i = 1; i < size; i++) {
            StrategyVo entityA = customerList.get(i - 1);
            StrategyVo entityB = customerList.get(i);
            Long aId = entityA.getId();
            Long bId = entityB.getId();
            assertTrue(aId > bId);
        }
    }

    @Test
    public void queryPageAuthByChannelId() throws Exception {
        StrategyServiceImpl strategyService = new StrategyServiceImpl();

        StrategyVo param = new StrategyVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<StrategyVo> result = strategyService.queryPageAuthByChannelId(
                pm, param, 1L);
        compareStrategyVoOrder(result);
    }

    @Test
    public void queryPageAuthByParamMap() throws Exception {
        StrategyServiceImpl strategyService = new StrategyServiceImpl();

        StrategyVo param = new StrategyVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<StrategyVo> result = strategyService.queryPageAuthByParamMap(
                pm, param);
        compareStrategyVoOrder(result);
    }

    @Test
    public void queryPageAuthByParamMap2() throws Exception {
        StrategyServiceImpl strategyService = new StrategyServiceImpl();

        StrategyVo param = new StrategyVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<StrategyVo> result = strategyService.queryPageAuthByParamMap(
                pm, param, null, null);
        compareStrategyVoOrder(result);
    }

    @Test
    public void StrategyVoqueryPageByChannelId() throws Exception {
        StrategyServiceImpl strategyService = new StrategyServiceImpl();

        StrategyVo param = new StrategyVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<StrategyVo> result = strategyService.queryPageByChannelId(pm,
                param, 1L);
        compareStrategyVoOrder(result);
    }

    @Test
    public void findOperatorLogByParams() throws Exception {
        OperatorLogServiceImpl operatorLogService = new OperatorLogServiceImpl();

        OperatorLog param = new OperatorLog();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<OperatorLog> result = operatorLogService
                .findOperatorLogByParams(start, size, param);
        compareCommonEntityOrder(result);
    }

    @Test
    public void ChannelVoqueryPageByParamMap() throws Exception {
        ChannelServiceImpl channelService = new ChannelServiceImpl();

        ChannelVo param = new ChannelVo();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<ChannelVo> result = channelService.queryPageByParamMap(pm,
                param);
        compareBaseVoOrder(result);
    }

    private void compareBaseVoOrder(PageList<?> result) {
        assertNotNull(result);

        List<?> customerList = result.getResultList();
        assertNotNull(customerList);

        int size = customerList.size();
        for (int i = 1; i < size; i++) {
            BaseVO entityA = (BaseVO) customerList.get(i - 1);
            BaseVO entityB = (BaseVO) customerList.get(i);
            Long aId = entityA.getId();
            Long bId = entityB.getId();
            assertTrue(aId > bId);
        }
    }

    @Test
    public void AppEquipmentVOqueryPageByParamMap() throws Exception {
        AppEquipmentServiceImpl appEquipmentService = new AppEquipmentServiceImpl();

        AppEquipmentVO param = new AppEquipmentVO();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<AppEquipmentVO> result = appEquipmentService
                .queryPageByParamMap(pm, param);
        compareBaseVoOrder(result);
    }

    @Test
    public void AppFeedbackVOqueryPageByParamMap() throws Exception {
        AppFeedbackServiceImpl appFeedbackService = new AppFeedbackServiceImpl();

        AppFeedbackVO param = new AppFeedbackVO();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<AppFeedbackVO> result = appFeedbackService
                .queryPageByParamMap(pm, param);
        compareBaseVoOrder(result);
    }

    @Test
    public void AppMessageVOqueryPageByParamMap() throws Exception {
        AppMessageServiceImpl appMessageService = new AppMessageServiceImpl();

        AppMessageVO param = new AppMessageVO();

        Integer start = 1;
        Integer size = 10;
        PageModel pm = new PageModel(start, size);

        PageList<AppMessageVO> result = appMessageService.queryPageByParamMap(
                pm, param);
        compareBaseVoOrder(result);
    }

    @Test
    public void testAddBatchAndAuth() throws Exception {
        StrategyService service = new StrategyServiceImpl();

        List<StrategyVo> beans = new ArrayList<StrategyVo>();

        StrategyVo b1 = new StrategyVo();// 政策对象

        b1.setType("1");
        b1.setName("lizhengTest");
        b1.setRemark("remark");
        b1.setStrategyExpireType(2);
        b1.setBeginDate(new Date());

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 10);
        b1.setEndDate(c.getTime());
        b1.setCheckinExpireType(3);

        b1.setCheckinExpireNum(1);
        b1.setCheckinExpireUnit(2);
        b1.setTicketVarie("2");
        b1.setPrice(123.33D);
        b1.setSettlementPrice(103.11D);
        b1.setExpire(12);
        b1.setExpireMode(2);
        b1.setStatus(2);
        b1.setPublishStatus(0);

        List<KeyValueVo> scopeList = new ArrayList<KeyValueVo>();//
        KeyValueVo scope1 = new KeyValueVo();
        scope1.setKey("channel:applicationdate");
        scope1.setValue("1");

        KeyValueVo scope2 = new KeyValueVo();
        scope2.setKey("channel:applicationdate");
        scope2.setValue("2");

        KeyValueVo scope3 = new KeyValueVo();
        scope3.setKey("channel:applicationdate");
        scope3.setValue("3");

        scopeList.add(scope1);
        scopeList.add(scope2);
        scopeList.add(scope3);
        b1.setScope(scopeList);// 适用范围

        List<KeyValueVo> salesTypeList = new ArrayList<KeyValueVo>();
        KeyValueVo salesType1 = new KeyValueVo();
        salesType1.setKey("strategy:salesType");
        salesType1.setValue("2");

        KeyValueVo salesType2 = new KeyValueVo();
        salesType2.setKey("strategy:salesType");
        salesType2.setValue("1");

        salesTypeList.add(salesType1);
        salesTypeList.add(salesType2);

        b1.setSalesType(salesTypeList);// 销售端口

        List<ChannelVo> channelList = new ArrayList<ChannelVo>();
        ChannelVo channel = new ChannelVo();
        channel.setId(123L);

        ChannelVo channel2 = new ChannelVo();
        channel2.setId(456L);

        channelList.add(channel);
        channelList.add(channel2);
        b1.setChannelList(channelList);// 设置关联的渠道

        List<Long> productIds = new ArrayList<Long>();

        productIds.add(1L);
        productIds.add(2L);
        productIds.add(3L);
        productIds.add(4L);
        productIds.add(5L);

        b1.setProductList(productIds);// 关联的产品

        List<RebateStrategyVo> rebateList = new ArrayList<RebateStrategyVo>();
        RebateStrategyVo rebate1 = new RebateStrategyVo();
        rebate1.setId(11L);

        RebateStrategyVo rebate2 = new RebateStrategyVo();
        rebate2.setId(22L);

        rebateList.add(rebate1);
        rebateList.add(rebate2);
        b1.setRebateStrategyList(rebateList);

        // =================================================
        StrategyVo b2 = new StrategyVo();
        b2.setType("1");
        b2.setName("lizhengTest");
        b2.setRemark("remark");
        b2.setStrategyExpireType(2);
        b2.setBeginDate(new Date());

        b2.setEndDate(c.getTime());
        b2.setCheckinExpireType(3);

        b2.setCheckinExpireNum(1);
        b2.setCheckinExpireUnit(2);
        b2.setTicketVarie("2");
        b2.setPrice(123.33D);
        b2.setSettlementPrice(103.11D);
        b2.setExpire(12);
        b2.setExpireMode(2);
        b2.setStatus(2);
        b2.setPublishStatus(0);

        List<KeyValueVo> scopeList2 = new ArrayList<KeyValueVo>();
        KeyValueVo scope2_1 = new KeyValueVo();
        scope2_1.setKey("channel:applicationdate");
        scope2_1.setValue("5");

        KeyValueVo scope2_2 = new KeyValueVo();
        scope2_2.setKey("channel:applicationdate");
        scope2_2.setValue("6");

        KeyValueVo scope2_3 = new KeyValueVo();
        scope2_3.setKey("channel:applicationdate");
        scope2_3.setValue("4");

        scopeList2.add(scope2_1);
        scopeList2.add(scope2_2);
        scopeList2.add(scope2_3);
        b2.setScope(scopeList2);

        List<KeyValueVo> salesTypeList2 = new ArrayList<KeyValueVo>();
        KeyValueVo salesType2_1 = new KeyValueVo();
        salesType2_1.setKey("strategy:salesType");
        salesType2_1.setValue("2");

        KeyValueVo salesType2_2 = new KeyValueVo();
        salesType2_2.setKey("strategy:salesType");
        salesType2_2.setValue("1");

        salesTypeList2.add(salesType2_1);
        salesTypeList2.add(salesType2_2);

        b2.setSalesType(salesTypeList2);

        beans.add(b1);
        beans.add(b2);
        service.createBatchAndAuth(beans);
    }

    @Test
    public void testUpdateBatchAndAuth() throws Exception {
        StrategyService service = new StrategyServiceImpl();

        List<StrategyVo> beans = new ArrayList<StrategyVo>();

        StrategyVo b1 = new StrategyVo();// 政策对象
        b1.setId(2216619736563753L);
        b1.setName("lizhengTest");
        b1.setRemark("remark");
        b1.setStrategyExpireType(2);
        b1.setBeginDate(new Date());

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 10);
        b1.setEndDate(c.getTime());
        b1.setCheckinExpireType(3);

        b1.setCheckinExpireNum(1);
        b1.setCheckinExpireUnit(2);
        b1.setTicketVarie("2");
        b1.setPrice(123.33D);
        b1.setSettlementPrice(103.11D);
        b1.setExpire(12);
        b1.setExpireMode(2);
        b1.setStatus(2);
        b1.setPublishStatus(0);

        List<KeyValueVo> scopeList = new ArrayList<KeyValueVo>();//
        KeyValueVo scope1 = new KeyValueVo();
        scope1.setKey("channel:applicationdate");
        scope1.setValue("12");

        KeyValueVo scope2 = new KeyValueVo();
        scope2.setKey("channel:applicationdate");
        scope2.setValue("22");

        KeyValueVo scope3 = new KeyValueVo();
        scope3.setKey("channel:applicationdate");
        scope3.setValue("32");

        scopeList.add(scope1);
        scopeList.add(scope2);
        scopeList.add(scope3);
        b1.setScope(scopeList);// 适用范围

        List<KeyValueVo> salesTypeList = new ArrayList<KeyValueVo>();
        KeyValueVo salesType1 = new KeyValueVo();
        salesType1.setKey("strategy:salesType");
        salesType1.setValue("22");

        KeyValueVo salesType2 = new KeyValueVo();
        salesType2.setKey("strategy:salesType");
        salesType2.setValue("12");

        salesTypeList.add(salesType1);
        salesTypeList.add(salesType2);

        b1.setSalesType(salesTypeList);// 销售端口

        List<ChannelVo> channelList = new ArrayList<ChannelVo>();
        ChannelVo channel = new ChannelVo();
        channel.setId(1234L);

        ChannelVo channel2 = new ChannelVo();
        channel2.setId(4567L);

        channelList.add(channel);
        channelList.add(channel2);
        b1.setChannelList(channelList);// 设置关联的渠道

        List<Long> productIds = new ArrayList<Long>();

        productIds.add(12L);
        productIds.add(22L);
        productIds.add(32L);
        productIds.add(42L);
        productIds.add(52L);

        b1.setProductList(productIds);// 关联的产品

        List<RebateStrategyVo> rebateList = new ArrayList<RebateStrategyVo>();
        RebateStrategyVo rebate1 = new RebateStrategyVo();
        rebate1.setId(1111L);

        RebateStrategyVo rebate2 = new RebateStrategyVo();
        rebate2.setId(2222L);

        rebateList.add(rebate1);
        rebateList.add(rebate2);
        b1.setRebateStrategyList(rebateList);

        beans.add(b1);
        service.updateBatchAndAuth(beans);
    }
}
