package net.riking.init.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * Bean 类型的后处理器
 * @Description 通过后置处理器初始化 Bean
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:13
 */
@Component
public class CarBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 源码：AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean name : " + beanName + ", before Initialization, time : " + System.currentTimeMillis());
		return null;
	}

	/**
	 * 源码：AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean name : " + beanName + ", after Initialization, time : " + System.currentTimeMillis());
		return null;
	}
}
