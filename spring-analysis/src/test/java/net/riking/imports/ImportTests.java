package net.riking.imports;

import net.riking.imports.general.ImportConfig;
import net.riking.imports.registrar.ImportRegistrarConfig;
import net.riking.imports.registrar.repository.UserRepo;
import net.riking.imports.selector.ImportSelectorConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description @Import 组件测试
 * @Author: kongLiuYi
 * @Date: 2020/2/23 17:22
 */
public class ImportTests {


	/**
	 *
	 *
	 */
	@Test
	public void  importGeneral(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(ImportConfig.class);
		applicationContext.refresh();
		applicationContext.close();
	}


	/**
	 *
	 *
	 */
	@Test
	public void  importSelector(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(ImportSelectorConfig.class);
		applicationContext.refresh();
		applicationContext.close();
	}

	/**
	 *
	 *
	 */
	@Test
	public void  importRegistrar(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(ImportRegistrarConfig.class);
		applicationContext.refresh();
		Object bean = applicationContext.getBean("&userRepo");
		System.out.println(bean.getClass());
		UserRepo userRepo= (UserRepo) applicationContext.getBean("userRepo");
		System.out.println(userRepo.getClass());
		userRepo.findUserList();
		applicationContext.close();
	}
}
