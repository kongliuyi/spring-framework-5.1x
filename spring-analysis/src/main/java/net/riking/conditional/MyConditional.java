package net.riking.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:12
 */
public class MyConditional implements Condition {

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		// TODO是否linux系统
		//1、能获取到ioc使用的beanfactory
		ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
		//2、获取类加载器
		ClassLoader classLoader = conditionContext.getClassLoader();

		//3、获取当前环境信息
		Environment environment = conditionContext.getEnvironment();
		//4、获取到bean定义的注册类
		BeanDefinitionRegistry registry = conditionContext.getRegistry();

		String property = environment.getProperty("os.name");

		System.out.println("操作系统："+property);

		//可以判断容器中的bean注册情况，也可以给容器中注册bean
		if (property.contains("Windows")){
			return true;
		}
		System.out.println("false："+property);
		return false;
	}
}
