package net.riking.inject.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.util.StringValueResolver;
/**
 * 注：该 InitBeanFactoryPostProcessor 后置处理器是在测试类手动添加至容器中
 * @Description 分析和修改 BeanDefinition，并预实例化单例
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:13
 */
public class InitBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// 从 beanFactory 中获取 bean 名字列表
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		String autowireMode = null;
		for (String beanName : beanNames) {
			AbstractBeanDefinition definition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
			// 修改 BeanDefinition 注入模型
			 if("injectByNameService".equals(beanName)) {
			 	definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
			 }
			 if("injectByTypeService".equals(beanName)) {
			 	definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
			 }
			 if("injectAutowiredByNameService".equals(beanName)) {
			 	definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
			 }

			 if(definition.getAutowireMode() == 0) {
				 autowireMode = "AUTOWIRE_NO";
			 }
			 else if (definition.getAutowireMode() == 1) {
				 autowireMode = "AUTOWIRE_BY_NAME";
			 }
			 else if (definition.getAutowireMode() == 2) {
				 autowireMode = "AUTOWIRE_BY_TYPE";
			 }
			 else if (definition.getAutowireMode() == 3) {
				 autowireMode = "AUTOWIRE_CONSTRUCTOR";
			 }
			 System.out.println(beanName+" 注入模型："+autowireMode);

			StringValueResolver valueResolver = strVal -> {
				System.out.println("逻辑处理.....");
				return strVal;
			};
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			// 这一步才是真正处理 bean 的配置信息
			visitor.visitBeanDefinition(definition);
		}

	}
}
