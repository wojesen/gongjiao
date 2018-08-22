/*  1:   */ package com.yinlian.user.dto;
/*  2:   */ 
/*  3:   */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*  4:   */
/*  5:   */
/*  6:   */

/*  7:   */
/*  8:   */ @XmlAccessorType(XmlAccessType.FIELD)
/*  9:   */ @XmlRootElement(name="msg")
/* 10:   */ public class SmsTokenReq
/* 11:   */   extends BaseReq
/* 12:   */ {
/* 13:   */   @XmlElement
/* 14:   */   private String authMobile;
/* 15:   */   @XmlElement
/* 16:   */   private String callService;
/* 17:   */   @XmlElement
/* 18:   */   private String attach;
/* 19:   */   @XmlElement
/* 20:   */   private String msgType;
/* 21:   */   @XmlElement
/* 22:   */   private String msg;
/* 23:   */   @XmlElement
/* 24:   */   private String smsCode;
/* 25:   */   
/* 26:   */   public String getAuthMobile()
/* 27:   */   {
/* 28:25 */     return this.authMobile;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setAuthMobile(String authMobile)
/* 32:   */   {
/* 33:28 */     this.authMobile = authMobile;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getCallService()
/* 37:   */   {
/* 38:31 */     return this.callService;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setCallService(String callService)
/* 42:   */   {
/* 43:34 */     this.callService = callService;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public String getAttach()
/* 47:   */   {
/* 48:37 */     return this.attach;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setAttach(String attach)
/* 52:   */   {
/* 53:40 */     this.attach = attach;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public String getMsgType()
/* 57:   */   {
/* 58:43 */     return this.msgType;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setMsgType(String msgType)
/* 62:   */   {
/* 63:46 */     this.msgType = msgType;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public String getMsg()
/* 67:   */   {
/* 68:49 */     return this.msg;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setMsg(String msg)
/* 72:   */   {
/* 73:52 */     this.msg = msg;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public String getSmsCode()
/* 77:   */   {
/* 78:55 */     return this.smsCode;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public void setSmsCode(String smsCode)
/* 82:   */   {
/* 83:58 */     this.smsCode = smsCode;
/* 84:   */   }
/* 85:   */ }



/* Location:           C:\Users\Administrator\Desktop\

 * Qualified Name:     com.auth.dto.SmsTokenReq

 * JD-Core Version:    0.7.0.1

 */