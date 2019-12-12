package net.riking.bean;


import sun.misc.Unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Dog {

	public Dog() {
		System.out.println("init dog...");
	}

	public static volatile int i=1;
	public static AtomicInteger atomicInteger=new AtomicInteger(1);


	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(		new Thread(() -> {
			for (; i <=100; ) {
     if (atomicInteger.compareAndSet(1, 2)){
				   System.out.println("t1："+i++);
		   atomicInteger.set(3);
			   }
			}
		},"t1"));
		executorService.submit(		new Thread(() -> {
			for (; i <=100; ) {
			if (atomicInteger.compareAndSet(3, 4)){
				System.out.println("t2："+i++);
				atomicInteger.set(5);
			}}
		},"t2"));
		executorService.submit(		new Thread(() -> {
		   	for (; i <=100; ) {
				if (atomicInteger.compareAndSet(5, 6)){
				System.out.println("t3："+i++);
				atomicInteger.set(1);
			}}
		},"t3"));
		executorService.shutdown();

	}
}
