package net.riking.dao;

import net.riking.annotation.Select;

import java.util.List;

public interface UserDao {
	@Select("select  user from user")
	List<String> findUserList();
}
