package net.riking.inject.service;


import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2019/10/22 23:35
 */
@Service
public class DogService1 implements IDogService {
	@Override
	public void query() {
		System.out.println("DogService1");
	}
}
