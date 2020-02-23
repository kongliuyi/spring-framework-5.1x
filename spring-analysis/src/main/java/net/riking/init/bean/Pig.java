package net.riking.init.bean;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:11
 */
public class Pig implements InitializingBean, DisposableBean {

	public  Pig() {
		System.out.println("init Pig....");
	}

	/**
	 * 源码 AbstractAutowireCapableBeanFactory.invokeInitMethods
	 */
	void initMethod() {
		System.out.println("调用 initMethod 初始化方法  ");
	}
	void destroyMethod() {
		System.out.println("调用 destroyMethod 销毁方法  ");
	}

	/**
	 * 源码 AbstractAutowireCapableBeanFactory.invokeInitMethods
	 */
	@Override
	public void afterPropertiesSet(){
		System.out.println("调用 afterPropertiesSet 初始化方法");
	}


	@Override
	public void destroy(){
		System.out.println("调用 destroy 销毁方法");
	}


	/**
	 * 源码：AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization
	 * 实质：CommonAnnotationBeanPostProcessor extends InitDestroyAnnotationBeanPostProcessor
	 *   InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization
	 */
	@PostConstruct
	void postConstruct() {
		System.out.println("调用注解 postConstruct 初始化方法");
	}

	@PreDestroy
	void preDestroy() {
		System.out.println("调用注解 preDestroy 销毁方法");
	}
}
