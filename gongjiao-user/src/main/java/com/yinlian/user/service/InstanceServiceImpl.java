package com.yinlian.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinlian.user.mapper.UserMapper;
import com.yinlian.user.model.User;



/**
 * Created by wangjinshan on 2018/08/20.
 */
@Service

public class InstanceServiceImpl implements InstanceService {

	@Autowired
	UserMapper userMapper;
	@Override
	public List<Object> queryList(String name) {
		// TODO Auto-generated method stub
		System.out.println("success===============================================1");
		User user = userMapper.findUserByName("test");
		System.out.println("success================================================"+user.getId());
		User user2 = new User();
		user2.setName("张三");
		userMapper.insert(user2);
		return null;
	}

}
