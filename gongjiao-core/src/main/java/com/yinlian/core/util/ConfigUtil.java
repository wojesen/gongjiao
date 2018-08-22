/*  1:   */ package com.yinlian.core.util;
/*  2:   */ 
/*  3:   */

/*  4:   */ import java.util.ResourceBundle;

/*  5:   */
/*  6:   */ public class ConfigUtil
/*  7:   */ {
/*  8: 6 */   public static ResourceBundle resourceBundle = null;
/*  9:   */   
/* 10:   */   static
/* 11:   */   {
/* 12: 9 */     if (resourceBundle == null) {
/* 13:10 */       resourceBundle = ResourceBundle.getBundle("value");
/* 14:   */     }
/* 15:   */   }
/* 16:   */   
/* 17:   */   public static String getValue(String refName)
/* 18:   */   {
/* 19:   */     try
/* 20:   */     {
/* 21:16 */       if (refName != null) {
/* 22:17 */         return resourceBundle.getString(refName);
/* 23:   */       }
/* 24:   */     }
/* 25:   */     catch (Exception e)
/* 26:   */     {
/* 27:21 */       e.printStackTrace();
/* 28:22 */       return null;
/* 29:   */     }
/* 30:24 */     return null;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public static void main(String[] args)
/* 34:   */   {
/* 35:28 */     String value = getValue("UPOP_BASE_URL");
/* 36:29 */     System.out.println(value);
/* 37:   */   }
/* 38:   */ }



/* Location:           C:\Users\Administrator\Desktop\

 * Qualified Name:     com.auth.util.ConfigUtil

 * JD-Core Version:    0.7.0.1

 */