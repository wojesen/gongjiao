package com.yinlian.user.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yinlian.user.model.SmsLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsLogMapper extends BaseMapper<SmsLog>{

  public SmsLog selectSmsLog(SmsLog smsLog) throws Exception;

  public int insertSmsLog(SmsLog smsLog) throws Exception;

  public SmsLog selectTotalRecord(SmsLog smsLog) throws Exception;

  public int updateSmsLog(SmsLog smsLog);
}
