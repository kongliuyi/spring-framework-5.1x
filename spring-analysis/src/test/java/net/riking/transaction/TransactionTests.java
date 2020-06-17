package net.riking.transaction;

import net.riking.aop.AspectjConfig;
import net.riking.transaction.bean.Users;
import net.riking.transaction.config.AppConfig;
import net.riking.transaction.dao.IUsersDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @Description
 * @Author kongLiuYi
 * @Date 2020/3/5 0005 15:33
 */
public class TransactionTests {

	@Test
	public void transaction() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class/*, AspectjConfig.class*/);
		applicationContext.refresh();
		IUsersDao usersDao = (IUsersDao) applicationContext.getBean("usersDao");

		Users users = new Users();
		users.setName("武大郎");
		users.setAge(21);
		usersDao.insertUser(users);

		List<Users> usersList = usersDao.selectAll();
		usersList.forEach(System.out::println);
	}
}
