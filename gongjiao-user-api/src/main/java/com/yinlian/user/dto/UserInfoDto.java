package com.yinlian.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xuhao on 2018/8/21.
 */
@Data
public class UserInfoDto implements Serializable {

    private Long id;

    private String username;

    private String mobile;

    private String wxCode;

    private String openId;

    private String token;

    private Integer status;


    // param部分
    private String verificationCode;

    // 登录方式，1 密码 2 验证码
    private Integer loginWay;

    // 密码
    private String password;
}
