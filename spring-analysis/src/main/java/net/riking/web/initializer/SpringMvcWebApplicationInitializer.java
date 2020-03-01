package net.riking.web.initializer;

import net.riking.web.config.WebConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/28 15:49
 */
public class SpringMvcWebApplicationInitializer implements MyWebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("SpringMvcWebApplicationInitializer ....");
		// 进行初始化
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(WebConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic dispatcherServlet1 = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		dispatcherServlet1.setLoadOnStartup(1);
		dispatcherServlet1.addMapping("/");
	}
}
