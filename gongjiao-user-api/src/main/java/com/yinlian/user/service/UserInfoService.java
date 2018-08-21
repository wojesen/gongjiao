
package com.yinlian.user.service;


import com.yinlian.core.common.Response;
import com.yinlian.user.dto.UserInfoDto;

/**
 *
 *
 * @author jason
 */
public interface UserInfoService {

    /**
     *
     * 获取用户信息
     * @param
     * @return
     */
    Response<UserInfoDto> getUserInfo(String username);

    /**
     * 用户注册
     * @param userInfoDto
     * @return
     */
    Response register(UserInfoDto userInfoDto);

    /**
     * 用户登录
     */
    Response<UserInfoDto> login(UserInfoDto userInfoDto);

}
