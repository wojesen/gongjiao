package com.yinlian.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yinlian.core.common.Response;
import com.yinlian.core.util.ConfigUtil;
import com.yinlian.core.util.DateUtil;
import com.yinlian.user.dto.SmsDto;
import com.yinlian.user.dto.SmsTokenReq;
import com.yinlian.user.mapper.SmsLogMapper;
import com.yinlian.user.model.SmsLog;
import com.yinlian.user.util.NewSmsSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description：发送短信服务
 */
@Service(version = "1.0.0")
@Slf4j
public class MsgServiceImpl implements MsgService {

    @Autowired
    private SmsLogMapper smsLogMapper;

    @Override
    public Response sendMobileMsg(SmsTokenReq mreq) throws Exception{
        //(1) 判断短信发送条件
        //(2) 获取短信模板
        //(3) 发送短信
        //(4) Token和短信的关系？ 分开记录，并非所有Token都有短信
        //-------------------------------
        //控制短信发送条数
        //-------------------------------
        int MAX_SEND_TIME=100;
        int totalRecord = 0;
        if(ConfigUtil.getValue("sms.maxSendTime")!=null)
        {
            MAX_SEND_TIME=Integer.valueOf(ConfigUtil.getValue("sms.maxSendTime"));
        }

        SmsLog smsLog = new SmsLog();
        smsLog.setMobile(mreq.getAuthMobile());
        smsLog.setMaxSendTimes(MAX_SEND_TIME);
        smsLog.setTime(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
        smsLog = smsLogMapper.selectTotalRecord(smsLog);
        if(null!=smsLog){
            totalRecord = smsLog.getTotalRecord();
        }

        //短信条数已发送到最大数
        if(totalRecord == MAX_SEND_TIME){
            return Response.fail("短信条数已发送到最大数");
        }

        //-------------------------------
        //控制短信发送频率
        //-------------------------------
        smsLog = new SmsLog();
        smsLog.setMobile(mreq.getAuthMobile());
        smsLog = smsLogMapper.selectSmsLog(smsLog);
        if(null!=smsLog){
            int SEND_SMS_FREQUENCY = 30; //默认发送频率为30秒
            if(ConfigUtil.getValue("sms.sendSmsFrequency")!=null)
            {
                SEND_SMS_FREQUENCY=Integer.valueOf(ConfigUtil.getValue("sms.sendSmsFrequency"));
            }

            long long1 = System.currentTimeMillis();
            long long2 = DateUtil.getDate(smsLog.getTime(), "yyyy-MM-dd HH:mm:ss").getTime();
            if(long1-long2<SEND_SMS_FREQUENCY*1000l){
                return Response.fail("短信发送频率超频");
            }
        }
        //-------------------------------
        //获取短信模板
        //-------------------------------
        String msgType = (null==mreq.getMsgType()||"".equals(mreq.getMsgType())?"DEFAULT":mreq.getMsgType());
        //查询短信模板

        //若不为空，则取短信模板
        String finalSendMsg = mreq.getMsg();
        log.info("发送短信msg："+finalSendMsg+"-------------------");
        //-------------------------------
        //发送短信
        //-------------------------------
        SmsDto smsDataTo = new SmsDto();
        smsDataTo.setMobileNum(mreq.getAuthMobile());
        smsDataTo.setVcode(finalSendMsg);
//		smsDataTo = callSendSmsInterface(smsDataTo);    //2017-7-13 wq,屏蔽，方便测试

        //2017-7-17 wq：接入银联新短信接口===========
        NewSmsSend newSmsSend = new NewSmsSend();
        newSmsSend.sendSmsContext(smsDataTo);
        //=======end=========

        //-------------------------------
        //记录发送短信
        //-------------------------------
        smsLog = new SmsLog();
        smsLog.setTradeId(mreq.getTradeId());
        smsLog.setSerialNumber(mreq.getSerialNumber());
        smsLog.setMobile(mreq.getAuthMobile());
        smsLog.setMsgType(msgType);
//		smsLog.setVerifiCode(mreq.getMsg().equals(finalSendMsg)?"":mreq.getMsg());
        smsLog.setVerifiCode(mreq.getMsg());//2017-6-28 wq ：把验证码存入
        smsLog.setMsg(finalSendMsg);
        smsLog.setTime(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
        smsLog.setStatus(smsDataTo.getRespCode());
        smsLog.setErrorTimes("0");
        smsLogMapper.insertSmsLog(smsLog);
        return Response.ok(smsDataTo.getRespCode());
    }

    @Override
    public Response checkSmsCode(SmsTokenReq mreq) throws Exception{
        //(1) 获取短信验证码
        //(2) 校验短信
        String smsCheckResult = "1"; //0:超时 1@:不对 2:错误次数太多 3:正确
        SmsLog smsLog = new SmsLog();
        smsLog.setMobile(mreq.getAuthMobile());
        smsLog = smsLogMapper.selectSmsLog(smsLog);
        if(null!=smsLog){
            String errorTimes =smsLog.getErrorTimes();
            if(null == errorTimes || "".equals(errorTimes))
                errorTimes = "0";
            long long1 = System.currentTimeMillis();
            long long2 = DateUtil.getDate(smsLog.getTime(), "yyyy-MM-dd HH:mm:ss").getTime();
            if(Integer.valueOf(errorTimes)>= 4){ //错误次数超限
                smsCheckResult = "2";
            }else if(long1-long2>Integer.valueOf(ConfigUtil.getValue("sms.validTime"))*60*1000l){ //有效期5分钟，超时
                smsCheckResult = "0";
            }else if(mreq.getSmsCode().equals(smsLog.getVerifiCode())){ //验证正确
                //2017-4-8 zhangh修改验证码验证    //2017-6-28 wq ：修改回去
//			}else if(mreq.getSmsCode().equals(smsLog.getMsg())){ //验证正确
                smsCheckResult = "3";
            }else if(!mreq.getSmsCode().equals(smsLog.getVerifiCode())){ //验证码不对
                //2017-4-8 zhangh修改验证码验证                //2017-6-28 wq ：修改回去
//			}else if(!mreq.getSmsCode().equals(smsLog.getMsg())){ //验证码不对
                //错误次数增加
                errorTimes = String.valueOf(Integer.valueOf(errorTimes)+1);
                //更新数据库错误次数
                SmsLog smsLogUp = new SmsLog();
                smsLogUp.setMobile(mreq.getAuthMobile());
                smsLogUp.setId(smsLog.getId());
                smsLogUp.setErrorTimes(errorTimes);
                smsLogMapper.updateSmsLog(smsLogUp);
                smsCheckResult = "1@" + String.valueOf(5 - Integer.valueOf(errorTimes));
            }else{
                smsCheckResult = "1@";
            }
        }
        return Response.ok(smsCheckResult);
    }
}
