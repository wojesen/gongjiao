/*   1:    */ package com.yinlian.user.dto;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;

/*   4:    */
/*   5:    */ public class SmsDto
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8:    */   private static final long serialVersionUID = 9034949407668541631L;
/*   9: 20 */   private String application = "platService";
/*  10: 21 */   private String version = "1.0.0";
/*  11:    */   private String sendTime;
/*  12: 23 */   private String transCode = "1013";
/*  13: 24 */   private String channelName = "贵州银联验证";
/*  14: 25 */   private String channelId = "10009001";
/*  15:    */   private String mobileNum;
/*  16:    */   private String vcode;
/*  17:    */   private String misc;
/*  18:    */   private String respCode;
/*  19:    */   private String respDesc;
/*  20:    */   
/*  21:    */   public String getApplication()
/*  22:    */   {
/*  23: 35 */     return this.application;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public void setApplication(String application)
/*  27:    */   {
/*  28: 41 */     this.application = application;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public String getVersion()
/*  32:    */   {
/*  33: 47 */     return this.version;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void setVersion(String version)
/*  37:    */   {
/*  38: 53 */     this.version = version;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public String getSendTime()
/*  42:    */   {
/*  43: 59 */     return this.sendTime;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setSendTime(String sendTime)
/*  47:    */   {
/*  48: 65 */     this.sendTime = sendTime;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String getTransCode()
/*  52:    */   {
/*  53: 71 */     return this.transCode;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setTransCode(String transCode)
/*  57:    */   {
/*  58: 77 */     this.transCode = transCode;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getChannelName()
/*  62:    */   {
/*  63: 83 */     return this.channelName;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setChannelName(String channelName)
/*  67:    */   {
/*  68: 89 */     this.channelName = channelName;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getChannelId()
/*  72:    */   {
/*  73: 95 */     return this.channelId;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setChannelId(String channelId)
/*  77:    */   {
/*  78:101 */     this.channelId = channelId;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public String getMobileNum()
/*  82:    */   {
/*  83:107 */     return this.mobileNum;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setMobileNum(String mobileNum)
/*  87:    */   {
/*  88:113 */     this.mobileNum = mobileNum;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String getVcode()
/*  92:    */   {
/*  93:119 */     return this.vcode;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setVcode(String vcode)
/*  97:    */   {
/*  98:125 */     this.vcode = vcode;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String getMisc()
/* 102:    */   {
/* 103:131 */     return this.misc;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setMisc(String misc)
/* 107:    */   {
/* 108:137 */     this.misc = misc;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String getRespCode()
/* 112:    */   {
/* 113:143 */     return this.respCode;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setRespCode(String respCode)
/* 117:    */   {
/* 118:149 */     this.respCode = respCode;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public String getRespDesc()
/* 122:    */   {
/* 123:155 */     return this.respDesc;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setRespDesc(String respDesc)
/* 127:    */   {
/* 128:161 */     this.respDesc = respDesc;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String toxml()
/* 132:    */   {
/* 133:165 */     String xmlstr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><subatm application=\"" + 
/* 134:166 */       this.application + "\" version=\"" + this.version + "\" channelName=\"" + 
/* 135:167 */       this.channelName + "\" sendTime=\"" + this.sendTime + "\" sendSeqId=\"\" transCode=\"" + 
/* 136:168 */       this.transCode + "\" channelId=\"" + this.channelId + "\"><vcode>" + this.vcode + "</vcode>" + 
/* 137:169 */       "<mobileNum>" + this.mobileNum + "</mobileNum></subatm>";
/* 138:    */     
/* 139:171 */     return xmlstr;
/* 140:    */   }
/* 141:    */ }



/* Location:           C:\Users\Administrator\Desktop\

 * Qualified Name:     com.auth.dto.SmsDTO

 * JD-Core Version:    0.7.0.1

 */