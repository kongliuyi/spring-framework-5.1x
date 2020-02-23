package net.riking.inject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 测试 两种情况下都存在，
 *  1. 例如 属性名称加了 @Autowired 注解，模型是 byName
 *  优先  byName 模式注入，若模式byName注入后， 属性dogService2 依旧为空，
 *  也就是	this.dogService2 = dogService1; 被注释 则 走 @Autowired 注入
 *
 *
 * @Author: kongLiuYi
 * @Date: 2019/10/22 23:35
 */
@Service
public class InjectAutowiredByNameService {
	@Autowired
	private IDogService dogService2;

	public void  query(){
		dogService2.query();
	}


	public void setDogService1(IDogService dogService1) {
		//this.dogService2 = dogService1;
	}
}
