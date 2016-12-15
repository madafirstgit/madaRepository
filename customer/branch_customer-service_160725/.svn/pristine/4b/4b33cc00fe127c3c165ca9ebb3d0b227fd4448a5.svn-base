//package test;
//
//import java.util.List;
//
//import junit.framework.TestCase;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.pzj.entity.SysUser;
//import com.pzj.service.sys.IUserService;
//
//public class SpringMybatisTest extends TestCase {
//
//	private static IUserService userService;
//
//	private static ApplicationContext act;
//	static {
//		// act = new ClassPathXmlApplicationContext(new
//		// String[]{"resources/spring-context.xml","resources/spring-context-mybatis.xml"});
//		String[] appfiles = new String[1];
//		appfiles[0] = "classpath*:/spring-context.xml";
//		act = new ClassPathXmlApplicationContext(appfiles);
//		userService = (IUserService) act.getBean("userService");
//	}
//
//	@Test
//	public void testSelectById() {
//		SysUser sysUser = new SysUser();
//		sysUser.setUsername("三");
//		List<SysUser> page = userService.findUserByParams(sysUser);
//		System.out.println(page.size());
//	}
//	// // @Test
//	// public void testSelectById(){
//	// SysUser users=new SysUser();
//	// users.setUserId(1l);
//	// SysUser user = userService.getUser(users);
//	//
//	// System.out.println("user:"+user.getLoginName());
//	// }
//	//
//
//	// public void testAdd(){
//	// SysUser user = new SysUser();
//	// user.setLoginName("sssyy");
//	// user.setLoginPasswd("fdsafs");
//	// int idnum=userService.addUser(user);
//	// System.out.println(idnum);
//	// }
//}
