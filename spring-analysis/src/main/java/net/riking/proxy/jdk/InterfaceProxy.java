package net.riking.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/6/7 0007 14:16
 */
public class InterfaceProxy implements InvocationHandler {

	private Object target;

	public InterfaceProxy(Object target) {
		this.target = target;
	}

	/**
	 * 获取代理对象
	 *
	 * @param <T>
	 * @return
	 */
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}


	/**
	 * 获取代理对象
	 *
	 * @param <T>
	 * @return
	 */
	public <T> T getProxy2() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getSuperclass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object object = method.invoke(target, args);
		after();
		return object;
	}

	private void before() {
		System.out.println("interface proxy before ...");
	}

	private void after() {
		System.out.println("interface proxy after ...");
	}


	/**
	 * 为什么JDK代理不像CGLib代理一样继承目标类反而去实现其接口呢?因为JDK代理生成的代理类，默认会继承 Proxy 类，
	 * 由于 java 是单继承，所以不能继承目标类只能实现其接口.
	 * 以下两种都可以用JDK代理
	 * 1.目标类C 如果继承了父类B,父类B 实现了接口A 这种情况还是能通过jdk代理的 生成的代理类D 继承了 Proxy 类并且实现了接口A
	 * 2.还有一种特殊情况,单纯目标类 A,生成的代理类B继承了Proxy,用Object接收生产成了三个代理方法 equals,toString 以及 hashCode
	 */
	public static void main(String[] args) {
		// 设置系统属性，输出生成的 .class 文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Person person = new Person();
		InterfaceProxy interfaceProxy = new InterfaceProxy(person);
		Object object = interfaceProxy.getProxy();
		object.hashCode();

		Nose headProxy = interfaceProxy.getProxy2();
		headProxy.breathe("吸入空气");

	}
}
