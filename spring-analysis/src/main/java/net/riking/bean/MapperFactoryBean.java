package net.riking.bean;

import net.riking.annotation.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class MapperFactoryBean<T>  implements FactoryBean<T>, InvocationHandler {
	private Class<T> mapperInterface;

	private boolean addToConfig = true;

	public MapperFactoryBean() {
		//intentionally empty
	}

	public MapperFactoryBean(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public T getObject() throws Exception {
     T proxy = (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, this);
		return proxy;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Select annotation = method.getAnnotation(Select.class);
		System.out.println(annotation.value()[0]);

		return null;
	}
}
