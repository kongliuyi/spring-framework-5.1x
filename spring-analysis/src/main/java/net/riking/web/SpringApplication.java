package net.riking.web;


import net.riking.web.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2019/11/22 13:35
 */
public class SpringApplication {

	private static final int port = 8078;

	public static void  run  () throws LifecycleException {
		AnnotationConfigWebApplicationContext acwc = new AnnotationConfigWebApplicationContext();
		acwc.register(WebConfig.class);
		acwc.refresh();
		File baseDir =new File(System.getProperty("java.io.tmpdir"));
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(port);
		Context context = tomcat.addContext("/", baseDir.getAbsolutePath());


		DispatcherServlet dps=new DispatcherServlet(acwc);

		 Tomcat.addServlet(context, "riking", dps);

		context.addServletMapping("/", "riking");

		tomcat.start();
		tomcat.getServer().await();
	}



	public static void  run2  () throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(port);
		String sourcePath = SpringApplication.class.getResource("/").getPath();
		String docBase = sourcePath.substring(0,sourcePath.lastIndexOf("classes")) + "resources/";
		Context context = tomcat.addWebapp("/", new File(docBase).getAbsolutePath());
		//增加tomcat-jasper等包的获取路径
		WebResourceRoot webResourceRoot = new StandardRoot(context);
		webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot,
				"/WEB-INF/classes",sourcePath,"/"));
		context.setResources(webResourceRoot);
		tomcat.start();
		tomcat.getServer().await();

	}

	public static void main(String[] args) {
		try {
			SpringApplication.run2();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
