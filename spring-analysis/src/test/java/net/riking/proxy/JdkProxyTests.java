package net.riking.proxy;

import net.riking.proxy.jdk.*;
import org.junit.Test;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/6/7 0007 14:29
 */
public class JdkProxyTests {

	@Test
	public void jdkProxyTest() {
		// 设置系统属性，输出生成的 .class 文件,要想看输出文件,不要在测试类中执行如下方法
		// 生成路径:classPath:com.sun.proxy
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Mouth mouth = new Head();
		InterfaceProxy interfaceProxy = new InterfaceProxy(mouth);
		Mouth mouthProxy = interfaceProxy.getProxy();
		mouthProxy.kiss("美女");
		((Nose) mouthProxy).breathe("花香");
	}


	/**
	 * 为什么JDK代理不像CGLib代理一样继承目标类反而去实现其接口呢?因为JDK代理生成的代理类，默认会继承 Proxy 类，
	 * 由于 java 是单继承，所以不能继承目标类只能实现其接口.
	 * 以下两种都可以用JDK代理
	 * 1.目标类C 如果继承了父类B,父类B 实现了接口A 这种情况还是能通过jdk代理的 生成的代理类D 继承了 Proxy 类并且实现了接口A
	 * 2.还有一种特殊情况,单纯目标类 A,生成的代理类B继承了Proxy,用Object接收生产成了三个代理方法 equals,toString 以及 hashCode
	 */
	@Test
	public void jdkProxyTest2() {
		// 设置系统属性，输出生成的 .class 文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Person person = new Person();
		InterfaceProxy interfaceProxy = new InterfaceProxy(person);
		// 无接口方式
		Object object = interfaceProxy.getProxy();
		object.hashCode();

		Nose headProxy = interfaceProxy.getProxy2();
		headProxy.breathe("吸入空气");
	}
}
