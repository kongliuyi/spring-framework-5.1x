package net.riking.service.impl;

import net.riking.bean.PrototypeBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class PrototypeServiceImpl {

	public void query() {
		PrototypeBean bean = methodInject();
		System.out.println("Bean PrototypeBean's HashCode " + bean.hashCode());
	}


	@Lookup
	protected PrototypeBean methodInject() {
		return null;
	}
}
