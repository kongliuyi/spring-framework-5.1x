package net.riking.transaction.dao;

import net.riking.transaction.bean.Users;
import net.riking.transaction.bean.mapper.UsersRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author kongLiuYi
 * @Date 2020/3/5 0005 14:31
 */
@Repository
public class UsersDao implements IUsersDao {


	private final JdbcTemplate jdbcTemplate;

	public UsersDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Propagation.REQUIRED:这是默认的传播属性，如果外部调用方有事务，将会加入到事务，没有的话新建一个。
	 *
	 * @param user
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertUser(Users user) {
		String sql = "insert into users (name, age) values ( ?, ?)";
		jdbcTemplate.update(sql, user.getName(), user.getAge());
		System.out.println("Create record : " + user.toString());

		// 事务测试，抛出异常，让上面的插入操作回滚
		throw new RuntimeException("aa");
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		String sql = "delete from users where id = ?";
		jdbcTemplate.update(sql, id);
		System.out.println("Delete record, id = " + id);
	}


	@Override
	public List<Users> selectAll() {
		String sql = "select * from users";
		List<Users> users = jdbcTemplate.query(sql, new UsersRowMapper());
		return users;
	}

}
