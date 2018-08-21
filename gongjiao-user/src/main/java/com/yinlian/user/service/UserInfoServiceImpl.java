package com.yinlian.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.yinlian.core.common.Response;
import com.yinlian.core.util.BeanUtils;
import com.yinlian.user.dto.UserInfoDto;
import com.yinlian.user.mapper.UserInfoMapper;
import com.yinlian.user.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by wangjinshan on 2018/08/20.
 */
@Service(version = "1.0.0")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public Response<UserInfoDto> getUserInfo(String username) {
		System.out.println("success===============================================1");
		UserInfo userInfo = userInfoMapper.selectOne(UserInfo.builder().username(username).build());
//		System.out.println("success================================================"+userInfo.getId());
		UserInfoDto userInfoDto = BeanUtils.objToBean(userInfo, UserInfoDto.class);
		return Response.ok(userInfoDto);
	}



}
