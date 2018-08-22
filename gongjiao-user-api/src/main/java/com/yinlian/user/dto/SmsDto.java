package com.yinlian.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SmsDto implements Serializable {
    private static final long serialVersionUID = 9034949407668541631L;
    private String application = "platService";
    private String version = "1.0.0";
    private String sendTime;
    private String transCode = "1013";
    private String channelName = "贵州银联验证";
    private String channelId = "10009001";
    private String mobileNum;
    private String vcode;
    private String misc;
    private String respCode;
    private String respDesc;
}



