package net.riking.bean;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Cat {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(() -> {
			for (int i = 1; i <=100 ; i++) {
				System.out.println("t1："+i);
			}
		});
		executorService.submit(() -> {
			for (int i = 1; i <=100 ; i++) {
				System.out.println("t2："+i);
			}
		});
		executorService.submit(() -> {
			for (int i = 1; i <100 ; i++) {
				System.out.println("t3："+i);
			}
		});
		executorService.shutdown();;
	}
}
