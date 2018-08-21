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
}
