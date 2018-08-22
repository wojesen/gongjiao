package com.yinlian.user.dto;

import lombok.Data;


@Data
public class SmsTokenReq extends BaseReq {

    private String authMobile;

    private String callService;

    private String attach;

    private String msgType;

    private String msg;

    private String smsCode;
}



