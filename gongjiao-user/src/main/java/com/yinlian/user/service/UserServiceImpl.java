package com.yinlian.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinlian.user.mapper.UserMapper;
import com.yinlian.user.model.User;



/**
 * Created by wangjinshan on 2018/08/20.
 */
@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	@Override
	public User queryList(String name) {
		// TODO Auto-generated method stub
		System.out.println("success===============================================1");
		User user = userMapper.findUserByName("test");
		System.out.println("success================================================"+user.getId());
//		User user2 = new User();
//		user2.setName("张三");
//		userMapper.insert(user2);
		return user;
	}

}
