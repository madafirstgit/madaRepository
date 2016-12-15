package test.app;

import org.junit.Test;

import com.pzj.app.service.AppFeedbackService;
import com.pzj.app.service.impl.AppFeedbackServiceImpl;
import com.pzj.app.vo.AppFeedbackVO;

public class FeedBackTest {
    private final AppFeedbackService service = new AppFeedbackServiceImpl();

    @Test
    public void testCreate() throws Exception {
        AppFeedbackVO vo = new AppFeedbackVO();
        vo.setFeedbackScenario("123123");
        service.create(vo);
    }
}
