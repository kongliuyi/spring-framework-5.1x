package net.riking.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJTest {



	/**
	 * 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	 */
	@Pointcut("execution(* net.riking.aop.*.testAop(..))")
	public void aspect() {
	}


	/**
	 * 配置前置通知,使用在方法 aspect() 上注册的切入点
	 * @param joinPoint  切入点对象,可以没有该参数
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before " + joinPoint);
	}

	/**
	 * 配置后置通知,使用在方法 aspect() 上注册的切入点
	 * @param joinPoint 切入点对象,可以没有该参数
	 */
	@After("aspect()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after " + joinPoint);
	}

	/**
	 * 配置环绕通知,使用在方法 aspect()上注册的切入点
	 * @param joinPoint 切入点对象,可以没有该参数
	 */
	@Around("aspect()")
	public void around(JoinPoint joinPoint) {
		long start = System.currentTimeMillis();
		try {
			((ProceedingJoinPoint) joinPoint).proceed();
			long end = System.currentTimeMillis();
			System.out.println("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			System.out.println("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
		}
	}


	/**
	 * 配置后置返回通知,使用在方法 aspect() 上注册的切入点
	 * @param joinPoint 切入点对象,可以没有该参数
	 */
	@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint) {
		System.out.println("afterReturn " + joinPoint);
	}

	/**
	 * 配置抛出异常后通知,使用在方法 aspect() 上注册的切入点
	 * @param joinPoint 切入点对象,可以没有该参数
	 * @param ex  切入点对象异常信息
	 */
	@AfterThrowing(pointcut = "aspect()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		System.out.println("afterThrow " + joinPoint + "\t" + ex.getMessage());
	}

}
