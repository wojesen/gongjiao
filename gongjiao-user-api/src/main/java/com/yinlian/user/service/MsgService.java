package com.yinlian.user.service;

import com.yinlian.core.common.Response;
import com.yinlian.user.dto.SmsTokenReq;

public interface MsgService {
    /**
     * 发送短信
     * @param mreq
     * @return
     * @throws Exception
     */
    Response sendMobileMsg(SmsTokenReq mreq) throws Exception;

    /**
     * 校验短信验证码
     * @param mreq
     * @return
     * @throws Exception
     */
    Response checkSmsCode(SmsTokenReq mreq) throws Exception;
}
