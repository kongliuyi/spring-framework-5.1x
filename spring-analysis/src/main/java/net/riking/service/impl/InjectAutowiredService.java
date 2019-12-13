package net.riking.service.impl;

import net.riking.dao.DogDao;
import net.riking.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Autowired 注入 不依靠 set 方法
 * 如果 属性 只存在一个，则依赖类型注入，例如：DogDao.class
 * 如果 属性 存在多个，则 选出最优的， 例如：IDogService.class
 *  1）  类 被标记 @Primary
 *  2）  类 被标记 @priority 选出 最低的，如果相同则 抛出异常
 *  3）  已上方式都不存在则 会选择属性的名字 例如 dogService1
 *
 */
@Service
public class InjectAutowiredService {
	@Autowired
	DogDao dogDooo;

	@Autowired
	IDogService dogService1;

	public void  query(){
		dogService1.query();
	}
}
