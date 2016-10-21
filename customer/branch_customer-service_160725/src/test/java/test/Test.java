package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.pzj.base.entity.SysUserOfficeKey;
import com.pzj.base.service.sys.IUserAuthOfficeService;
import com.pzj.channel.Strategy;
import com.pzj.channel.service.IStrategyService;
import com.pzj.channel.vo.queryParam.PCSstrategyParam;
import com.pzj.channel.vo.resultParam.PCStrategyResult;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/spring-context.xml"})
public class Test {

	@Autowired
	IUserAuthOfficeService service;
	
	@Resource
	IStrategyService channelStrategyServiceImpl;

	@org.junit.Test
	public void test() {
		List<SysUserOfficeKey> records = new ArrayList<SysUserOfficeKey>();

		SysUserOfficeKey key = new SysUserOfficeKey();
		key.setId(1L);

		records.add(key);

		service.deleteBatchByPrimaryKey(records);
	}

	@org.junit.Test
	public void test2() {
		
		/*Long distributorId = 111111111L;
		List<Long> productIds = new ArrayList<Long>();
		productIds.add(2215520224935939L);
		Map<Long, List<Strategy>> s = channelStrategyServiceImpl.getStrategyByDidAndPid(distributorId, productIds);
		System.out.println(s);
	
		*/
	}
	@org.junit.Test
	public void test3() {
		
		List<PCSstrategyParam> param = new ArrayList<PCSstrategyParam>();
		PCSstrategyParam e = new PCSstrategyParam() ;
		e.setChannelId(573845l);
		e.setProductId(2215520224935939l);
		Strategy strategyParam = new Strategy() ;
		
		e.setStrategyParam(strategyParam );
		param.add(e );
		List<PCStrategyResult> q = channelStrategyServiceImpl.queryValidStrategyByProductIds(param );
		System.out.println(q.size());
		
	}

}
