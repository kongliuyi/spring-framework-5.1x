package net.riking.inject.bean;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 14:13
 */
@Component
public class Cat {

	private String name;

	@Autowired
	private Sheep sheep;

	private int age;

/*
	public Cat() {
	}
*/

	@ConstructorProperties(value={"catStringOne","dog"})
	@Autowired(required = false)
	public Cat(String catStringOne, Dog dog) {
		this.name = catStringOne;
		System.out.println(name+dog.toString());
	}

	@Autowired(required = false)
	public Cat(Dog dog) {
		System.out.println(dog.toString());
	}

/*	@Autowired(required = false)
	protected Cat(String catStringOne, Dog dog, DogDao dogDao){};
	@Autowired(required = false)
	public Cat(Object o1){};
	@Autowired(required = false)
	protected Cat(Integer i, Object o1, Object o2, Object o3){};
	@Autowired(required = false)
	public Cat(Object o1, Object o2, Object o3){};
	@Autowired(required = false)
	public Cat(Object o1, Object o2){};
	@Autowired(required = false)
	protected Cat(String catStringOne,Dog dog){};*/





	/*	public Cat(int age) {
		this.age = age;
	}

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}*/

	public Sheep getSheep() {
		return sheep;
	}

	public void setSheep(Sheep sheep) {
		this.sheep = sheep;
	}

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
