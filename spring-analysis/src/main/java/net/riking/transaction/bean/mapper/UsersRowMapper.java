package net.riking.transaction.bean.mapper;

import net.riking.transaction.bean.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description
 * @Author kongLiuYi
 * @Date 2020/3/5 0005 14:26
 */
public class UsersRowMapper implements RowMapper<Users> {
	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		users.setId(rs.getInt("id"));
		users.setName(rs.getString("name"));
		users.setAge(rs.getInt("age"));
		return users;
	}
}
