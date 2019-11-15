package net.riking.config;

import net.riking.bean.MapperFactoryBean;
import net.riking.dao.UserDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

public class MapperScannerRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		BeanDefinitionBuilder builder = genericBeanDefinition(UserDao.class);
		GenericBeanDefinition bd= (GenericBeanDefinition) builder.getBeanDefinition();
		bd.getConstructorArgumentValues().addGenericArgumentValue(UserDao.class);
		bd.setBeanClass(MapperFactoryBean.class);
		registry.registerBeanDefinition("userDao",bd);
	}
}
