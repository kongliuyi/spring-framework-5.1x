package net.riking.imports.registrar.repository;


import net.riking.imports.registrar.anno.Select;

import java.util.List;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/23 16:46
 */
public interface UserRepo {
	@Select("select  user from user")
	List<String> findUserList();
}
