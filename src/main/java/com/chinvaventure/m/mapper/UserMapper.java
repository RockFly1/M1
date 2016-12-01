package com.chinvaventure.m.mapper;

import org.apache.ibatis.annotations.Param;

import com.chinvaventure.m.model.User;

public interface UserMapper {
	
	/**根据名称查询用户名**/
	User selectByName(@Param("userName") String userName,@Param("userPassWord") String userPassWord);
	
	/**根据邮箱查询*/
	User selectByEamil(@Param("userEamil") String userEamil);
	
	/**插入用户信息**/
	int insertUser(@Param("records") User records);
	
	/**根据用户Eamil更新信息*/
	int updateUser(@Param("records") User records);
}