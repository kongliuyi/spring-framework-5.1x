package net.riking.init;


import net.riking.init.config.LifeCycleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description Bean 的生命周期调用测试
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:18
 */
public class InitBeanTests {

	/**
	 * 1.通过 @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod") 注解
	 *   调用 bean 的初始化方法以及销毁方法
	 * 2.通过实现 InitializingBean, DisposableBean 接口，调用 bean 的初始化方法以及销毁方法
	 * 3.通过 @PostConstruct 和 @PreDestroy 注解，调用 bean 的初始化方法以及销毁方法
	 * 4.通过后置处理器调用 postProcessBeforeInitialization 和 postProcessAfterInitialization 初始化方法
	 *
	 * 注意：Spring 不会对一个 prototype bean的整个生命周期负责，
	 * 容器在初始化、配置、装饰或者是装配完一个 prototype 实例后，
	 * 将它交给客户端，随后就对该prototype实例不闻不问了。
	 * 所以如果 bean 是 prototype 的话，spring 只能管初始化方法，而销毁方法是不会管的
	 */
	@Test
	public void  initAndDestroyMethod(){
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(LifeCycleConfig.class);
		applicationContext.refresh();
		applicationContext.close();
	}

}
