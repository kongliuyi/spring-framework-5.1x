package net.riking.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJTest {

	@Pointcut("execution(* net.riking.aop.*.testAop(..))")
	public void test() {

	}

	@Before("test()")
	public void beforeTest() {
		System.out.println("before Test");
	}


	@After("test()")
	public void afterTest() {
		System.out.println("after Test");
	}

	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint joinPoint) {
		System.out.println("around Before");
		Object o = null;
		try {
			// 调用切面的方法
			o = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around After");
		return o;
	}
}
