package net.riking.aop;

import org.springframework.stereotype.Component;

@Component
public class AopBean {

	public void testAop() {
		System.out.println("I am the true aop bean");
	}
}
