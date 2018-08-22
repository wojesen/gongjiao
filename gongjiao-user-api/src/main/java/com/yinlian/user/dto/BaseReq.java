/*   1:    */ package com.yinlian.user.dto;
/*   2:    */ 
/*   3:    */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/*   4:    */
/*   5:    */
/*   6:    */

/*   7:    */
/*   8:    */ @XmlAccessorType(XmlAccessType.NONE)
/*   9:    */ public class BaseReq
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12:    */   private static final long serialVersionUID = -5900847891197067700L;
/*  13:    */   @XmlAttribute
/*  14:    */   private String service;
/*  15:    */   @XmlAttribute
/*  16:    */   private String sysName;
/*  17:    */   @XmlAttribute
/*  18:    */   private String sign;
/*  19:    */   @XmlAttribute
/*  20:    */   private String serialNumber;
/*  21:    */   @XmlAttribute
/*  22:    */   private String userId;
/*  23:    */   @XmlAttribute
/*  24:    */   private String termId;
/*  25:    */   @XmlAttribute
/*  26:    */   private String termAdd;
/*  27:    */   @XmlAttribute
/*  28:    */   private String termBrand;
/*  29:    */   @XmlAttribute
/*  30:    */   private String osVersion;
/*  31:    */   @XmlAttribute
/*  32:    */   private String appVersion;
/*  33:    */   @XmlAttribute
/*  34:    */   private String tokenValue;
/*  35:    */   @XmlAttribute
/*  36:    */   private String channelId;
/*  37:    */   @XmlAttribute
/*  38:    */   private String tradeId;
/*  39:    */   
/*  40:    */   public String getService()
/*  41:    */   {
/*  42: 38 */     return this.service;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setService(String service)
/*  46:    */   {
/*  47: 41 */     this.service = service;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getSysName()
/*  51:    */   {
/*  52: 44 */     return this.sysName;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setSysName(String sysName)
/*  56:    */   {
/*  57: 47 */     this.sysName = sysName;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getSign()
/*  61:    */   {
/*  62: 50 */     return this.sign;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setSign(String sign)
/*  66:    */   {
/*  67: 53 */     this.sign = sign;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getSerialNumber()
/*  71:    */   {
/*  72: 56 */     return this.serialNumber;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setSerialNumber(String serialNumber)
/*  76:    */   {
/*  77: 59 */     this.serialNumber = serialNumber;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getUserId()
/*  81:    */   {
/*  82: 62 */     return this.userId;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setUserId(String userId)
/*  86:    */   {
/*  87: 65 */     this.userId = userId;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getTermId()
/*  91:    */   {
/*  92: 68 */     return this.termId;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setTermId(String termId)
/*  96:    */   {
/*  97: 71 */     this.termId = termId;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getTermAdd()
/* 101:    */   {
/* 102: 74 */     return this.termAdd;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setTermAdd(String termAdd)
/* 106:    */   {
/* 107: 77 */     this.termAdd = termAdd;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getTermBrand()
/* 111:    */   {
/* 112: 80 */     return this.termBrand;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setTermBrand(String termBrand)
/* 116:    */   {
/* 117: 83 */     this.termBrand = termBrand;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getOsVersion()
/* 121:    */   {
/* 122: 86 */     return this.osVersion;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setOsVersion(String osVersion)
/* 126:    */   {
/* 127: 89 */     this.osVersion = osVersion;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getAppVersion()
/* 131:    */   {
/* 132: 92 */     return this.appVersion;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setAppVersion(String appVersion)
/* 136:    */   {
/* 137: 95 */     this.appVersion = appVersion;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String getTokenValue()
/* 141:    */   {
/* 142: 98 */     return this.tokenValue;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setTokenValue(String tokenValue)
/* 146:    */   {
/* 147:101 */     this.tokenValue = tokenValue;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public String getChannelId()
/* 151:    */   {
/* 152:104 */     return this.channelId;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setChannelId(String channelId)
/* 156:    */   {
/* 157:107 */     this.channelId = channelId;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public String getTradeId()
/* 161:    */   {
/* 162:110 */     return this.tradeId;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setTradeId(String tradeId)
/* 166:    */   {
/* 167:113 */     this.tradeId = tradeId;
/* 168:    */   }
/* 169:    */ }



/* Location:           C:\Users\Administrator\Desktop\

 * Qualified Name:     com.auth.dto.BaseReq

 * JD-Core Version:    0.7.0.1

 */