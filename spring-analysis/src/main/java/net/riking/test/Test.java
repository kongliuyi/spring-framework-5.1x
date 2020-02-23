package net.riking.test;

import net.riking.aop.AopBean;

import net.riking.inject.bean.CarBeanFactoryPostProcessor;
import net.riking.inject.config.AppConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2019/10/22 23:35
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new CarBeanFactoryPostProcessor());
		applicationContext.refresh();
		AopBean aopBean = (AopBean) applicationContext.getBean("aopBean");
		aopBean.testAop();
		applicationContext.close();
	}
}
