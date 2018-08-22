package com.yinlian.user.service;

import com.yinlian.core.common.Response;
import com.yinlian.user.dto.SmsTokenReq;

public interface MsgService
{
  Response sendMobileMsg(SmsTokenReq mreq) throws Exception;

  Response checkSmsCode(SmsTokenReq mreq) throws Exception;
}
