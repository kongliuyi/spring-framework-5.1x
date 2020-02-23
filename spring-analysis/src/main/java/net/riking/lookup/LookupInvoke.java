package net.riking.lookup;


import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 18:15
 */
@ComponentScan
public class LookupInvoke {

	public void query() {
		PrototypeBean bean = methodInject();
		System.out.println("Bean PrototypeBean's HashCode " + bean.hashCode());
	}


	@Lookup
	protected PrototypeBean methodInject() {
		return null;
	}
}
