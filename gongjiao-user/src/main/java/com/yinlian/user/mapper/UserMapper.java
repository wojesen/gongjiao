package com.yinlian.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yinlian.user.model.User;

/**
* Created by Administrator on 2016/9/2.
*/
@Mapper
public interface UserMapper {
	
	
	@Select("select * from user where phone = #{phone}")
	User findUserByName(@Param("phone")String phone);
	
	@Insert("INSERT INTO user(name) VALUES(#{user.name})")
	@Options(useGeneratedKeys = true, keyProperty = "user.id")
	int insert(@Param("user")User user);
}