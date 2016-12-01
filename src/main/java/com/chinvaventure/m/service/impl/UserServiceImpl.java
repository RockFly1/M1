/**
 * 
 */
package com.chinvaventure.m.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinvaventure.m.mapper.UserMapper;
import com.chinvaventure.m.model.User;
import com.chinvaventure.m.service.UserService;

/**
 * user service
 * @author Administrator
 *
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	//注入user
	@Autowired
	private UserMapper userMapper;
	


	@Override
	public int insertUser(User records) {
		
		return userMapper.insertUser(records);
	}


	@Override
	public User selectByName(String userName, String userPassWord) {
		
		return userMapper.selectByName(userName, userPassWord);
	}


	@Override
	public User selectByEamil(String userEamil) {
	
		return userMapper.selectByEamil(userEamil);
	}


	@Override
	public int updateUser(User records) {
		
		return userMapper.updateUser(records);
	}

}
