package net.riking.imports.registrar;


import net.riking.imports.registrar.anno.Select;
import net.riking.imports.registrar.bean.Log;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:43
 */
public class MapperFactoryBean<T>  implements FactoryBean<T>, InvocationHandler {

	private Log log;

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

	public void setLog(Log log) {
		this.log = log;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Select annotation = method.getAnnotation(Select.class);
		log.info(annotation.value()[0]);
		return null;
	}
}
