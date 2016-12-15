package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.pzj.channel.service.IStrategyService;
import com.pzj.channel.vo.queryParam.PCSstrategyParam;
import com.pzj.channel.vo.resultParam.PCStrategyResult;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/spring-context.xml"})
public class StrategyServiceTest {

    @Autowired
    private IStrategyService strategyService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testQueryValidStrategyByPCId() {
        Long productId = 2215520224936214l;
        Long channelId = 2215520224936130l;
        PCSstrategyParam param1 = new PCSstrategyParam();
        param1.setChannelId(channelId);
        param1.setProductId(productId);

        List<PCSstrategyParam> paramList = new ArrayList<PCSstrategyParam>();
        List<PCStrategyResult> list = strategyService.queryValidStrategyByProductIds(paramList);
        System.out.println("haha");

    }
}
