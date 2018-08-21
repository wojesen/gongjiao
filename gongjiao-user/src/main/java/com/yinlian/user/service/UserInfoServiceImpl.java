package com.yinlian.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.ImmutableMap;
import com.yinlian.core.common.Response;
import com.yinlian.core.util.BeanUtils;
import com.yinlian.core.util.CommonUtil;
import com.yinlian.user.dto.UserInfoDto;
import com.yinlian.user.mapper.UserInfoMapper;
import com.yinlian.user.model.UserInfo;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Objects;


/**
 * Created by wangjinshan on 2018/08/20.
 */
@Service(version = "1.0.0", filter = "default,extendExceptionFilter")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public Response<UserInfoDto> getUserInfo(String username) {
		System.out.println("success===============================================1");
		UserInfo userInfo = userInfoMapper.selectOne(UserInfo.builder().username(username).build());
		System.out.println("success================================================"+userInfo.getId());
		UserInfoDto userInfoDto = BeanUtils.objToBean(userInfo, UserInfoDto.class);
		return Response.ok(userInfoDto);
	}

	@Override
	public Response register(UserInfoDto userInfoDto) {
		//获取微信凭证
		Map<String, String> wxMap = getOpenIdAndSessionKey(userInfoDto.getWxCode(), "appId", "secret");
		if(!wxMap.containsKey("openId") || !wxMap.containsKey("sessionKey")){
			return Response.fail("获取微信凭证失败");
		}
		//校验短信验证码
		if(!checkVerificationCode(userInfoDto.getMobile(), userInfoDto.getVerificationCode())){
			return Response.fail("验证码错误");
		}
		UserInfo userInfo = BeanUtils.objToBean(userInfoDto, UserInfo.class);
		userInfo.setPassword(CommonUtil.mD5Purity(userInfo.getPassword()));
		userInfo.setOpenId(MapUtils.getString(wxMap, "openId"));
		userInfo.setSessionKey(MapUtils.getString(wxMap, "sessionKey"));
		userInfo.setToken(CommonUtil.mD5Purity(userInfo.getSessionKey()));
		userInfoMapper.insert(userInfo);
		UserInfoDto userInfoResult = BeanUtils.objToBean(userInfo, UserInfoDto.class);
		return Response.ok(userInfoResult);
	}

	@Override
	public Response<UserInfoDto> login(UserInfoDto userInfoDto) {
		if(userInfoDto.getLoginWay() == null){
			return Response.fail("登录方式为空");
		}
		//密码登录
		if(userInfoDto.getLoginWay() == 1){
			UserInfo userInfo = (UserInfo) redisTemplate.opsForHash().get("USER:LOGIN:USERNAME", userInfoDto.getUsername());
			if(Objects.isNull(userInfo)){
				userInfo = userInfoMapper.selectOne(UserInfo.builder().username(userInfoDto.getUsername()).build());
			}
			if(Objects.isNull(userInfo)){
				return Response.fail("用户名密码错误");
			}
			if(!StringUtils.equals(userInfo.getPassword(), CommonUtil.mD5Purity(userInfoDto.getPassword()))){
				return Response.fail("用户名密码错误");
			}
			UserInfoDto userInfoResult = BeanUtils.objToBean(userInfo, UserInfoDto.class);
			return Response.ok(userInfoResult);
		}else if (userInfoDto.getLoginWay() == 2){ //验证码登录
			UserInfo userInfo = (UserInfo) redisTemplate.opsForHash().get("USER:LOGIN:MOBILE", userInfoDto.getMobile());
			if(Objects.isNull(userInfo)){
				userInfo = userInfoMapper.selectOne(UserInfo.builder().mobile(userInfoDto.getMobile()).build());
			}
			if(Objects.isNull(userInfo)){
				return Response.fail("手机号未绑定用户");
			}
			if(!checkVerificationCode(userInfoDto.getMobile(), userInfoDto.getVerificationCode())){
				return Response.fail("验证码错误");
			}
			UserInfoDto userInfoResult = BeanUtils.objToBean(userInfo, UserInfoDto.class);
			return Response.ok(userInfoResult);
		}else { // openId, token登陆
			UserInfo userInfo = (UserInfo) redisTemplate.opsForHash().get("USER:LOGIN:OPENID", userInfoDto.getOpenId());
			if(Objects.isNull(userInfo)){
				userInfo = userInfoMapper.selectOne(UserInfo.builder().openId(userInfoDto.getOpenId()).build());
			}
			if(Objects.isNull(userInfo)){
				return Response.fail("openId不存在");
			}
			if(!StringUtils.equals(userInfo.getToken(), userInfoDto.getToken())){
				return Response.fail("token不存在");
			}
			UserInfoDto userInfoResult = BeanUtils.objToBean(userInfo, UserInfoDto.class);
			return Response.ok(userInfoResult);
		}
	}



	//todo 获取微信凭证
	private Map<String, String> getOpenIdAndSessionKey(String wxCode, String appId, String secret){
		return ImmutableMap.of("openId", "openId", "sessionKey", "sessionKey");
	}

	//todo 校验短信验证码
	private Boolean checkVerificationCode(String mobile, String verificationCode){
		return Boolean.TRUE;
	}
}
