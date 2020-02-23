package net.riking.conditional;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:16
 */
public class ConditionalTests {

	/**
	 * @Conditional 注解用法
	 *
	 *  源码：三次调用判断
	 *
	 *  注：通过 @Conditional 注解， spring 衍生出很多类似注解，例如：
	 */
	@Test
	public void  conditional(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(Mouse.class);
		applicationContext.refresh();
		applicationContext.close();
	}
}
