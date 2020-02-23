package net.riking.inject.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.util.StringValueResolver;
/**
 * @Description 该 CarBeanFactoryPostProcessor 后置处理器是手动添加至容器中
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:13
 */
public class CarBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// 从 beanFactory 中获取 bean 名字列表
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			AbstractBeanDefinition definition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
			 if("injectByNameService".equals(beanName)) {definition.setAutowireMode(1);}
			 if("injectByTypeService".equals(beanName)) {definition.setAutowireMode(2);}
			 if("injectAutowiredByNameService".equals(beanName)) {definition.setAutowireMode(1);}
			System.out.println(beanName+"---"+definition.getAutowireMode());
			StringValueResolver valueResolver = strVal -> {
				return strVal;
			};
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			// 这一步才是真正处理 bean 的配置信息
			visitor.visitBeanDefinition(definition);
		}

	}
}