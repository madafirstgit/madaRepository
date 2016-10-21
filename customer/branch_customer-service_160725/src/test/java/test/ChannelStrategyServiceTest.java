package test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.service.sys.IChannelStrategyService;
import com.pzj.channel.service.IStrategyService;
import com.pzj.channel.vo.queryParam.PCSstrategyParam;
import com.pzj.channel.vo.resultParam.PCStrategyResult;

/**
 * Created by Administrator on 2016-5-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath*:/META-INF/spring/spring-context.xml" })
public class ChannelStrategyServiceTest {
    @Resource
    IStrategyService        channelStrategyService;
    @Resource
    IChannelStrategyService tChannelStrategyService;

    @org.junit.Test
    public void queryStrategyAndRebateByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(2216619736563717L);
        ids.add(2216619736567876L);

        // List<Strategy> strategyList =
        // channelStrategyService.queryStrategyAndRebateByIds(ids);
        //
        // assertNotNull(strategyList);
    }

    @org.junit.Test
    public void queryValidStrategyByProductIds() {
        List<PCSstrategyParam> paramList = new ArrayList<PCSstrategyParam>();
        PCSstrategyParam param = new PCSstrategyParam();
        param.setChannelId(2216619736563727l);
        param.setProductId(2216619736567542L);
        paramList.add(param);
        List<PCStrategyResult> list = channelStrategyService.queryValidStrategyByProductIds(paramList);

        System.out.println(list.size());
    }

    @org.junit.Test
    public void updateStrategyByDictVlaue() {
        SysChannelStrategy tSysChannelStrategy = new SysChannelStrategy();
        tSysChannelStrategy.setId(2216619741565336l);
        // tSysChannelStrategy.setId(2216619741565315l);
        //tSysChannelStrategy.setId(2216619736563713l);
        tSysChannelStrategy.setAdvicePrice(50.0);
        tSysChannelStrategy.setSettlementPrice(20.0);
        //tSysChannelStrategy.setDictValue("直销渠道数据字典");
        int result;
        try {
            result = tChannelStrategyService.updateStrategyByDictVlaue(tSysChannelStrategy);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
