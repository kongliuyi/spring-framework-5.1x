package net.riking.web;


import net.riking.web.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2019/11/22 13:35
 */
public class SpringApplication {

	public static void  run  () throws LifecycleException {
		AnnotationConfigWebApplicationContext acwc = new AnnotationConfigWebApplicationContext();
		acwc.register(WebConfig.class);
		acwc.refresh();
		File baseDir =new File(System.getProperty("java.io.tmpdir"));
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8081);
		Context context = tomcat.addContext("/", baseDir.getAbsolutePath());


		DispatcherServlet dps=new DispatcherServlet(acwc);

		 Tomcat.addServlet(context, "riking", dps);

		context.addServletMapping("/", "riking");

		tomcat.start();
		tomcat.getServer().await();






	}

	public static void main(String[] args) {
		try {
			SpringApplication.run();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
