package net.riking.imports.registrar;

import net.riking.imports.registrar.bean.Log;
import net.riking.imports.registrar.repository.UserRepo;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:41
 */
public class MapperScannerRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		BeanDefinitionBuilder builder = genericBeanDefinition(UserRepo.class);
		GenericBeanDefinition bd= (GenericBeanDefinition) builder.getBeanDefinition();
		// 构造函数注入
		bd.getConstructorArgumentValues().addGenericArgumentValue(UserRepo.class);
		MutablePropertyValues mpv=new MutablePropertyValues();
		// 假设 Log 类作用是记录日志，注入方式类似 byType 或者 byName 注入，需要 set方法
		mpv.add("log", new Log());
		bd.setPropertyValues(mpv);
		bd.setBeanClass(MapperFactoryBean.class);
		registry.registerBeanDefinition("userRepo",bd);
	}
}
