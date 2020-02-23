package net.riking.lookup;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 18:24
 */
public class LookupTests {

	/**
	 * 对于类属性 bean 为原型时，注入的一种方式
	 */
	@Test
	public void lookup() {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(LookupInvoke.class);
		applicationContext.refresh();
		LookupInvoke lookupInvoke= (LookupInvoke) applicationContext.getBean("lookupInvoke");
		lookupInvoke.query();
		lookupInvoke.query();
	}
}
