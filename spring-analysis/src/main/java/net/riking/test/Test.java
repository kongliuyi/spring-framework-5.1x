package net.riking.test;

import net.riking.aop.AopBean;
import net.riking.bean.CarBeanFactoryPostProcessor;
import net.riking.config.AppConfig;
import net.riking.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new CarBeanFactoryPostProcessor());
		applicationContext.refresh();
		/*AopBean aopBean = (AopBean) applicationContext.getBean("aopBean");
		aopBean.testAop();*/
		UserDao userDao= (UserDao) applicationContext.getBean("userDao");
		userDao.findUserList();
	}
}
