package net.riking.service.impl;


import net.riking.service.IDogService;
import org.springframework.stereotype.Service;

@Service
public class DogService1 implements IDogService {
	@Override
	public void query() {
		System.out.println("DogService1");
	}
}
