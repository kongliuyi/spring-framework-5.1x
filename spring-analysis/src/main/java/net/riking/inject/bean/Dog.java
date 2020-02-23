package net.riking.inject.bean;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:13
 */
public class Dog {

	public Dog() {
		System.out.println("init dog...");
	}


	public static volatile int i=1;
	public static AtomicInteger atomicInteger=new AtomicInteger(1);


	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(	() -> {
			for (; i <=100; ) {
     if (atomicInteger.compareAndSet(1, 2)){
		 System.out.println(Thread.currentThread().getName() + "-" + i++);
		   atomicInteger.set(3);
			   }
			}
		});
		executorService.submit(	() -> {
			for (; i <=100; ) {
			if (atomicInteger.compareAndSet(3, 4)){
				System.out.println(Thread.currentThread().getName() + "-" + i++);
				atomicInteger.set(5);
			}}
		});
		executorService.submit(	() -> {
		   	for (; i <=100; ) {
				if (atomicInteger.compareAndSet(5, 6)){
					System.out.println(Thread.currentThread().getName() + "-" + i++);
					atomicInteger.set(1);
			}}
		});
		executorService.shutdown();

	}
}
