package com.yinlian.user.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by xuhao on 2018/8/21.
 */
@TableName("user_info")
@Data
@Builder
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String mobile;

    private String wxCode;

    private String openId;

    private String sessionKey;

    private String token;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
