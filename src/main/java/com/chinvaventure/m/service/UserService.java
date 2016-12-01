/**
 * 
 */
package com.chinvaventure.m.service;

import org.apache.ibatis.annotations.Param;

import com.chinvaventure.m.model.User;

/**
 * @author Administrator
 *
 */
public interface UserService {

	/**根据名称查询用户名**/
	User selectByName (@Param("userName") String userName,@Param("userPassWord") String userPassWord);
	
	/**注册用户信息*/
	int insertUser(@Param("records") User records);
	
	/**根据Eamil查询*/
	User selectByEamil(@Param("userEamil") String userEamil);
	
    /**更新数据*/
	int updateUser(@Param("records") User records);
	
}
