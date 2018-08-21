
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
     *
     * @param
     * @return
     */
    Response<UserInfoDto> getUserInfo(String username);
 
}
