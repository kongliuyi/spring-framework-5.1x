package net.riking.transaction.dao;

import net.riking.transaction.bean.Users;

import java.util.List;

/**
 * @Description
 * @Author kongLiuYi
 * @Date 2020/3/5 0005 14:29
 */
public interface IUsersDao {

	/**
	 * 插入
	 * @param users	用户信息
	 */
	void insertUser(Users users);

	/**
	 * 根据 id 进行删除
	 * @param id	主键
	 */
	void deleteById(Integer id);

	/**
	 * 查询
	 * @return	全部
	 */
	List<Users> selectAll();
}
