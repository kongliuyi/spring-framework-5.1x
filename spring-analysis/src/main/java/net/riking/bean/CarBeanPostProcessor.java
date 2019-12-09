package net.riking.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Bean 类型的后处理器
 */
//@Component  --->这里通过 MyImportSelector  注册进容器中
public class CarBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// 这里没有区分 bean 类型，只是用来测试打印的顺序和时间
		System.out.println("Bean name : " + beanName + ", before Initialization, time : " + System.currentTimeMillis());
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean name : " + beanName + ", after Initialization, time : " + System.currentTimeMillis());
		return null;
	}
}
