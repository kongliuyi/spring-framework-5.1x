package net.riking.inject.service;



import net.riking.inject.dao.DogDao;
import org.springframework.stereotype.Service;

/**
 * 通过设置 ByType模型注入，依靠set方法中参数类型注入，例如：
 * 1.  setsasaDog(DogDao dogDao)  中的 DogDao.class
 * 2.  setDogService212121s(IDogService dogService2) 注入IDogService.class
 * 如果IDogService.class 存在多个，则 选出最优的
 * 1）  类 被标记 @Primary
 * 2）  类 被标记 @priority 选出 最低的，如果相同则 抛出异常
 * 3）  已上方式都不存在则 会选择属性的名字（目前不行） -->例如 dogService2,但是实际中 源码 拿不到dogService2
 * 所以第三种方式不适用，具体原因待检查（源码有点绕，理清源码思路在去看）
 */
@Service
public class InjectByTypeService {
	private DogDao dogDao;

	private IDogService dogService2;

	public void  query(){
		dogDao.query();
	}

	public void setsasaDog1(DogDao dogDao) {
		this.dogDao = dogDao;
	}

/*	public void setdogService2(IDogService dogService2) {
		this.dogService2 = dogService2;
	}*/
}
