package test.app;

import org.junit.Test;

import com.pzj.app.service.AppEquipmentService;
import com.pzj.app.service.impl.AppEquipmentServiceImpl;
import com.pzj.app.vo.AppEquipmentVO;

public class EquipTest {
    private final AppEquipmentService service = new AppEquipmentServiceImpl();

    @Test
    public void testCreate() throws Exception {
        AppEquipmentVO vo = new AppEquipmentVO();
        vo.setUserId(1234L);
        vo.setDeviceToken("token");
        vo.setDeviceType("2");

        service.create(vo);
    }
}
