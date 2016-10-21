package test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pzj.base.entity.SysExtraRebateStrategy;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.service.sys.IRebateStrategyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class RebateStrategyServiceImplTest {

    @Autowired
    static IRebateStrategyService service = null;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createRebateStrategy() {
        SysRebateStrategy rebateStrategy = new SysRebateStrategy();
        rebateStrategy.setCreateBy("fffffff");
        rebateStrategy.setProductName("procdut");
        rebateStrategy.setProductId(3L);
        rebateStrategy.setIsExtraRebate(1);
        rebateStrategy.setRebateCycleValue(1315);
        
        
        List<SysExtraRebateStrategy> sysExtraRebateStrategyList = new ArrayList<SysExtraRebateStrategy>();
        
        {
            SysExtraRebateStrategy ext = new SysExtraRebateStrategy();
            ext.setCreateBy("ext");
            ext.setRebateObject("ffffaaaa");
            ext.setRebateCycle("cccc");
            sysExtraRebateStrategyList.add(ext);
        }
        
        {
            SysExtraRebateStrategy ext = new SysExtraRebateStrategy();
            ext.setCreateBy("ext");
            ext.setRebateObject("ffffqqqqq");
            ext.setRebateCycle("cccc");
            sysExtraRebateStrategyList.add(ext);
        }
        
        rebateStrategy.setSysExtraRebateStrategyList(sysExtraRebateStrategyList );
        
        service.createRebateStrategy(rebateStrategy);
    }
    
    @Test
    public void UpdateRebateStrategy() {
        SysRebateStrategy rebateStrategy = new SysRebateStrategy();
        rebateStrategy.setId(2215520224935942L);
        rebateStrategy.setCreateBy("aaaaaa");
        rebateStrategy.setProductName("wwwww");
        rebateStrategy.setProductId(3L);
        rebateStrategy.setIsExtraRebate(1);
        rebateStrategy.setRebateCycleValue(1315);
        
        
        List<SysExtraRebateStrategy> sysExtraRebateStrategyList = new ArrayList<SysExtraRebateStrategy>();
        
        {
            SysExtraRebateStrategy ext = new SysExtraRebateStrategy();
            ext.setId(5L);
            ext.setCreateBy("ext");
            ext.setRebateObject("ccvb");
            ext.setRebateCycle("nnnn");
            sysExtraRebateStrategyList.add(ext);
        }
        
        {
            SysExtraRebateStrategy ext = new SysExtraRebateStrategy();
            ext.setId(6L);
            ext.setCreateBy("ext");
            ext.setRebateObject("xxxx");
            ext.setRebateCycle("fffff");
            sysExtraRebateStrategyList.add(ext);
        }
        
        rebateStrategy.setSysExtraRebateStrategyList(sysExtraRebateStrategyList );
        
        service.UpdateRebateStrategy(rebateStrategy);
    }

}
