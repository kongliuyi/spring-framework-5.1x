package net.riking.proxy.jdk;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/6/7 0007 14:10
 */
public class Head implements Mouth,Nose{

	public void shakeHead(){
		System.out.println("Head:shakeHead");
	}

	@Override
	public void talk(String say) {
		System.out.println("Head:"+say);
	}

	@Override
	public void kiss(String kiss) {
		System.out.println("Head:"+kiss);
	}

	@Override
	public void breathe(String breathe) {
		System.out.println("Head:"+breathe);
	}
}
