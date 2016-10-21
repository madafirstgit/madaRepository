package test;

import static junit.framework.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.common.TestDataGengerateUtil;

import com.pzj.channel.service.IStrategyService;
import com.pzj.channel.vo.queryParam.StrategyJudgeParam;
import com.pzj.channel.vo.resultParam.StrategyJudgeResult;
import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2016-5-20.
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {
		"classpath*:/META-INF/spring/spring-context.xml",


		
})
public class IStrategyServiceTest {  
	
    @Autowired
    IStrategyService strategyService;   
    
    TestDataGengerateUtil util = TestDataGengerateUtil.getInstance();
    
    @Test 
    public void judgeHaveValidStrategyByCPid(){      
    	List<StrategyJudgeParam> params = new ArrayList<StrategyJudgeParam>();
    	StrategyJudgeParam param = new  StrategyJudgeParam();
    	params.add(param);
        List<Long> channelIds = new ArrayList<Long>();
        channelIds.add(2216619736563714L);
        param.setChannelIds(channelIds);
        param.setProductId(2216619741564673L);
    	
    	
    			/*util.createTestDataList("/testData/judgeHaveValidStrategyByCPid.json", StrategyJudgeParam.class);*/
    	Result<ArrayList<StrategyJudgeResult>> result = strategyService.judgeHaveValidStrategyByCPid(params);
    	assertNotNull(result);
    	System.out.println("查询数据："+result.getData());  
    	System.out.println("ErrorMsg :"+ result.getErrorMsg());
    }  
    
}
