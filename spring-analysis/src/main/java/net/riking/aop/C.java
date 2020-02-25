package net.riking.aop;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/25 12:48
 */
public class C implements B {
	public static void main(String[] args) {

		System.out.println(new C() instanceof A);
	}
}
