//package test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.pzj.base.service.sys.IDictService;
//import com.pzj.base.service.sys.ILogService;
//import com.pzj.base.service.sys.IMenuService;
//import com.pzj.base.service.sys.IOfficeService;
//import com.pzj.base.service.sys.IRoleAuthMenuService;
//import com.pzj.base.service.sys.IRoleAuthOfficeService;
//import com.pzj.base.service.sys.IRoleService;
//import com.pzj.base.service.sys.IUserAuthMenuService;
//import com.pzj.base.service.sys.IUserAuthOfficeService;
//import com.pzj.base.service.sys.IUserAuthRoleService;
//import com.pzj.base.service.sys.IUserService;
//import com.pzj.util.RemoteServiceFactory;
//
//public class RemoteServiceFactoryTest {
//
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @Test
//    public void getIUserServiceInstance() {
//        IUserService instance1 = RemoteServiceFactory.getIUserServiceInstance();
//        IUserService instance2 = RemoteServiceFactory.getIUserServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIMenuServiceInstance() {
//        IMenuService instance1 = RemoteServiceFactory.getIMenuServiceInstance();
//        IMenuService instance2 = RemoteServiceFactory.getIMenuServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIUserAuthMenuServiceInstance() {
//        IUserAuthMenuService instance1 = RemoteServiceFactory
//                .getIUserAuthMenuServiceInstance();
//        IUserAuthMenuService instance2 = RemoteServiceFactory
//                .getIUserAuthMenuServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIUserAuthRoleServiceInstance() {
//        IUserAuthRoleService instance1 = RemoteServiceFactory
//                .getIUserAuthRoleServiceInstance();
//        IUserAuthRoleService instance2 = RemoteServiceFactory
//                .getIUserAuthRoleServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIRoleServiceInstance() {
//        IRoleService instance1 = RemoteServiceFactory.getIRoleServiceInstance();
//        IRoleService instance2 = RemoteServiceFactory.getIRoleServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIUserAuthOfficeServiceInstance() {
//        IUserAuthOfficeService instance1 = RemoteServiceFactory
//                .getIUserAuthOfficeServiceInstance();
//        IUserAuthOfficeService instance2 = RemoteServiceFactory
//                .getIUserAuthOfficeServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIOfficeServiceInstance() {
//        IOfficeService instance1 = RemoteServiceFactory
//                .getIOfficeServiceInstance();
//        IOfficeService instance2 = RemoteServiceFactory
//                .getIOfficeServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIRoleAuthOfficeServiceInstance() {
//        IRoleAuthOfficeService instance1 = RemoteServiceFactory
//                .getIRoleAuthOfficeServiceInstance();
//        IRoleAuthOfficeService instance2 = RemoteServiceFactory
//                .getIRoleAuthOfficeServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIRoleAuthMenuServiceInstance() {
//        IRoleAuthMenuService instance1 = RemoteServiceFactory
//                .getIRoleAuthMenuServiceInstance();
//        IRoleAuthMenuService instance2 = RemoteServiceFactory
//                .getIRoleAuthMenuServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getIDictServiceInstance() {
//        IDictService instance1 = RemoteServiceFactory.getIDictServiceInstance();
//        IDictService instance2 = RemoteServiceFactory.getIDictServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//    @Test
//    public void getILogServiceInstance() {
//        ILogService instance1 = RemoteServiceFactory.getILogServiceInstance();
//        ILogService instance2 = RemoteServiceFactory.getILogServiceInstance();
//
//        assertNotNull(instance1);
//        assertNotNull(instance2);
//        assertEquals(instance1, instance2);
//    }
//
//}
