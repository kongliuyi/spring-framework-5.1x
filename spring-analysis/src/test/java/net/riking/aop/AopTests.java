package net.riking.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 17:50
 */
public class AopTests {
	@Test
	public void  aop(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AspectjConfig.class);
		applicationContext.refresh();
		AopBean aopBean = (AopBean) applicationContext.getBean("aopBean");
		aopBean.testAop();
		applicationContext.close();

	}
}
