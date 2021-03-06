package net.riking.inject.service;



import org.springframework.stereotype.Service;

/**
 * 通过设置 byByName模型注入，依靠set方法中set 后面的name
 * 例如setDogService1 中的dogService1
 */
@Service
public class InjectByNameService {

	private IDogService dogService2;

	public void  query(){
		dogService2.query();
	}

	public void setDogService1(IDogService dogService2) {
		this.dogService2 = dogService2;
	}
}
