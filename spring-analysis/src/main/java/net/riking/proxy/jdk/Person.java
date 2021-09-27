package net.riking.proxy.jdk;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/6/7 0007 14:08
 */
public class Person  extends Head {

	@Override
	public void breathe(String breathe) {
		System.out.println("Person:"+breathe);
		see("妹子");
	}

	@Override
	public void shakeHead() {
		System.out.println("Person:shakeHead");
	}

	@Override
	public void talk(String say) {
		System.out.println("talk:"+say);
	}

	@Override
	public void kiss(String kiss) {
		System.out.println("kiss"+kiss);
		see("妹子");
	}

	//@Override
	private void see(String see) {
		System.out.println("see:"+see);
	}


}
