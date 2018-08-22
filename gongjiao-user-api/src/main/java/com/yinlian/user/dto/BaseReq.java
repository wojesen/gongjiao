package com.yinlian.user.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class BaseReq implements Serializable {
    private static final long serialVersionUID = -5900847891197067700L;

    private String service;

    private String sysName;

    private String sign;

    private String serialNumber;

    private String userId;

    private String termId;

    private String termAdd;

    private String termBrand;

    private String osVersion;

    private String appVersion;

    private String tokenValue;

    private String channelId;

    private String tradeId;
}



