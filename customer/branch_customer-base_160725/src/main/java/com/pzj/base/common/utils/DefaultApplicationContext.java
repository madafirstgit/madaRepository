//package com.pzj.common.utils;
//
//import javax.servlet.ServletContext;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
///**
// * spring应用上下文对象
// * @author guobo
// *
// */
//public class DefaultApplicationContext {
//	
//	private static DefaultApplicationContext instance;
//	private static ApplicationContext ctx = null;
//	private ServletContext servletContext;
//
//	public ServletContext getServletContext() {
//		return servletContext;
//	}
//
//	public void setServletContext(ServletContext servletContext) {
//		this.servletContext = servletContext;
//	}
//
//	private DefaultApplicationContext(){
//		
//	}
//	
//	public synchronized static DefaultApplicationContext getInstance() {
//		if (instance == null) {
//			instance = new DefaultApplicationContext();
//		}
//		return instance;
//	}
//
//     public synchronized Object getBean(String name,ServletContext servletContext, ApplicationContext ctx) {
//		if(ctx==null){
//			if(servletContext!=null){
//				//使用用具类从web应用空间内加载
//				ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
//			}else{
//				//使用默认的配置文件名在classpath中进行加载
//				String[] appfiles = new String[1];
//				appfiles[0] = "classpath*:/spring-context-*.xml";
//				ctx = new ClassPathXmlApplicationContext(appfiles);
//			}
//		}
//		return ctx.getBean(name);
//	}
//
//	public synchronized Object getBean(String name) {
//		return getBean(name,servletContext,ctx);
//	}
//	
//	public synchronized Object getBean(String name, ApplicationContext ctx) {
//		return getBean(name,servletContext,ctx);
//	}
//
// }
