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
/*
import com.pzj.base.entity.SysSupplierAgent; 
import com.pzj.dao.SysSupplierAgentMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class
})
@ContextConfiguration(locations = { "classpath*:/spring-context.xml" })
public class SysSupplierAgentMapperTest {
    
    @Autowired
    SysSupplierAgentMapper mapper;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testInsert(){
    	SysSupplierAgent r = new SysSupplierAgent();
    	r.setId(1111l);
    	r.setAgentId(111132323l);
    	r.setSupplierId(12345l);
		mapper.insert(r);
    }
    @Test
    public void testInsertBatch(){
    	List<SysSupplierAgent> list = new ArrayList<SysSupplierAgent>();
    	for(int i = 0;i <10;i++){
	    	SysSupplierAgent r = new SysSupplierAgent();
	    	r.setId(1111l+i);
	    	r.setAgentId(111132323l+i);
	    	r.setSupplierId(12345l+i);
	    	list.add(r);
    	}
		mapper.insertBatch(list);
    }
}
*/