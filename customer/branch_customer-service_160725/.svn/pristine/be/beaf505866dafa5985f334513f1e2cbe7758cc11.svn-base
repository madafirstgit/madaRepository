package test;

import static org.junit.Assert.*;

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

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.service.sys.IRebateStrategyService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class
})
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/spring-context.xml"})
public class RebasteStrategyServiceTest {

	@Autowired
	private IRebateStrategyService rebateStrategyService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test01_queryPageByParamMap_ids() {
		PageModel pager = null;
		SysRebateStrategy entity = new SysRebateStrategy();
		
		List<Long> ids = new ArrayList<Long>();
		ids.add(6L);
		ids.add(7L);
		entity.setIds(ids);
		
		PageList<SysRebateStrategy> result = rebateStrategyService.queryPageByParamMap(pager, entity);
		
		assertNotNull(result);
		assertNotNull(result.getResultList());
		assertEquals(result.getResultList().size(), 2);
	}

}
