package net.riking.inject;

import net.riking.bean.CarBeanFactoryPostProcessor;
import net.riking.config.AppConfig;
import net.riking.service.impl.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Inject {
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
		InjectAutowiredService autowiredService = (InjectAutowiredService) applicationContext.getBean("cat");
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

	@Test
	public   void methodInject(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		PrototypeServiceImpl prototypeServiceImpl= (PrototypeServiceImpl) applicationContext.getBean("prototypeServiceImpl");
		prototypeServiceImpl.query();
		prototypeServiceImpl.query();
	}

}
