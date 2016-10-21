package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.google.common.collect.Lists;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.service.sys.ISpcreRelationService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/spring-context.xml"})
public class SpcreRelationTest {

	@Autowired
	private ISpcreRelationService spcreRelationService;

	@Test
	public void testUpdate() {
		SysSpcreRelationKey to = new SysSpcreRelationKey();
		to.setChannelId("517");
		to.setStrategyId("579");
		to.setStatus("4");
		List<SysSpcreRelationKey> rlist = new ArrayList<SysSpcreRelationKey>();
		rlist.add(to);
		spcreRelationService.updateByChannelStrategy(rlist);
	}

	@Test
	public void testFind() {
		PageModel pager = new PageModel(1, 20);
		SysSpcreRelationKey entity = new SysSpcreRelationKey();
		List<Long> statusList = Lists.newArrayList();
		statusList.add(1L);
		statusList.add(2L);
		entity.setStatusList(statusList);
		PageList pageList = spcreRelationService.findPageSpcreRelation(pager,
				entity);
		System.out.println(pageList.getResultList().size()
				+ "=======================");

	}
}
