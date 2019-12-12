package net.riking.bean;

import net.riking.dao.DogDao;
import net.riking.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * by_no 情况下 默认
 *
 */
@Service
public class Cat {
	@Autowired
	DogDao dogDooo;

	@Autowired
	IDogService dogService;

	public void setDog1(DogDao dogDooo) {
		this.dogDooo = dogDooo;
	}

	public void setDogService1222(IDogService iDogService1) {
		this.dogService = iDogService1;
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
