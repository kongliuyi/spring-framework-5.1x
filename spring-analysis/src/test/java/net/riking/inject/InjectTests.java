package net.riking.inject;


import net.riking.inject.bean.CarBeanFactoryPostProcessor;
import net.riking.inject.config.AppConfig;

import net.riking.inject.service.InjectAutowiredByNameService;
import net.riking.inject.service.InjectAutowiredService;

import net.riking.inject.service.InjectByNameService;
import net.riking.inject.service.InjectByTypeService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class InjectTests {
	/**
	 * 源码在：
	 * AbstractAutowireCapableBeanFactory.populateBean -》后置处理器
	 * DefaultListableBeanFactory.determineHighestPriorityCandidate
	 */
	@Test
	public void  InjectAutowired(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new CarBeanFactoryPostProcessor());
		applicationContext.refresh();
		InjectAutowiredService autowiredService = (InjectAutowiredService) applicationContext.getBean("injectAutowiredService");
		autowiredService.query();
	}

	/**
	 * 源码在：
	 * AbstractAutowireCapableBeanFactory.populateBean
	 */
	@Test
	public void  InjectByName(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new CarBeanFactoryPostProcessor());
		applicationContext.refresh();
		InjectByNameService byNameService = (InjectByNameService) applicationContext.getBean("injectByNameService");
		byNameService.query();
	}


	/**
	 * 源码在：
	 * AbstractAutowireCapableBeanFactory.populateBean -》后置处理器
	 */
	@Test
	public void  InjectByType(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new CarBeanFactoryPostProcessor());
		applicationContext.refresh();
		InjectByTypeService byTypeService = (InjectByTypeService) applicationContext.getBean("injectByTypeService");
		byTypeService.query();
	}



	@Test
	public void  InjectAutowiredByName(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new CarBeanFactoryPostProcessor());
		applicationContext.refresh();
		InjectAutowiredByNameService injectAutowiredByNameService = (InjectAutowiredByNameService) applicationContext.getBean("injectAutowiredByNameService");
		injectAutowiredByNameService.query();
	}



}
