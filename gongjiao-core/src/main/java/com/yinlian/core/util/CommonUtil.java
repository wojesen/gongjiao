package com.yinlian.core.util;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CommonUtil {
	
	
	private static final Pattern MOBILE_PATTERN = Pattern.compile("^((\\+{0,1}86|17951|12593){0,1})1[0-9]{10}");
	
	// 验证带区号的
	private static final Pattern PHONE_PATTERN_WHITH_PREFIX = Pattern.compile("^[0][1-9]{2,3}[0-9]{5,10}$");  
	
	// 验证没有区号的 
	private static final Pattern PHONE_PATTERN_NO_PREFIX = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         

	
	private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]*"); 
	// MD5简单加密
	public static String mD5Purity(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0){
					i += 256;
				}
				if (i < 16){
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			plainText = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return plainText;
	}
	
	// 生成4位随机数验证码
	public static int getCode(){
		return new SecureRandom().nextInt(9000)+1000;
		//return (int) (Math.random()*9000+1000);
	}
	
	/**
	 * 随机产生指定长度的0-9的数字
	 * 
	 * @param length
	 * @return
	 */
	public static String generateCode(int length) {
		StringBuffer code = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int r = new SecureRandom().nextInt(10);
			//int r = (int) (Math.random() * 10);
			code.append(r);
		}
		return code.toString();
	}
	
	public static String getChannelOrderId(){
		String channelOrderId = ""+System.currentTimeMillis()+CommonUtil.generateCode(3);
		return channelOrderId;
	}
	
	 /**
     * 解压缩
     * @param compressed
     * @return
     */
    @SuppressWarnings("unused")
	public static final String decompress(byte[] compressed) {
        if (compressed == null){
        	return null;
        }
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        String decompressed;
        try {
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            ZipEntry entry = zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            //decompressed = out.toString();
            decompressed = out.toString("GBK");
        } catch (IOException e) {
            decompressed = null;
            throw new RuntimeException("解压缩字符串数据出错", e);
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
        }
        return decompressed;
    }
	
	/**
     *
     * 创建日期2014年7月21日17:11:56
     * 修改日期
     * 使用Base64加密算法加密字符串
     *return
     */
    public static String encodeStr(String plainText){
        byte[] b=plainText.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        String s=new String(b);
        return s;
    }
    
    /**
     *
     * 创建日期2014年7月21日17:11:56
     * 修改日期 
     * 将base64编码的字符集s进行解码
     *return
     */
    public static String decodeStr(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        String s=new String(b);
        return s;
    }
	
	// 生成code
	public static String getCodeByStr(String str){
		if(str == null) {
			return null;
		}
		Date time = new Date();
		// 生成随机唯一ID
		String need = mD5Purity(UUID.randomUUID().toString());
		return mD5Purity(encodeStr(str+time.toString()+need));
	}
	
	// date格式转换成long
	public static long getLongTimeByDate(Date dateTime){
		long lSysTime1 = dateTime.getTime() / 1000; 
		return lSysTime1;
	}
	
	// 时间字符串转换成long
	public static long getLongTimeByDate(String dateTime) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if(null != dateTime && !"".equals(dateTime)){
				date = df.parse(dateTime);
			}
			else {
				throw new Exception("日期时间不能为空!");
			}
			
		} catch (ParseException e) {
			throw new Exception(e.toString());
		}
		return date.getTime()/1000;
	}
	
	// 根据身份证号码计算年龄
	public static int getAgeByCardId(String cardId){
		int age = 0;
		if(cardId == null || "".equals(cardId)){
			return age;
		}
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
		age = new Integer(sdf.format(date)) - new Integer(cardId.substring(6,10));
		return age;
	}

	/**
	 * 手机号码验证
	 * @throws Exception 
	 * 
	 */
	public static boolean isMobile(String str) {
		//去除17951,86,12593
		str = str.replaceAll("-", "").replace(" ", "");
		boolean b = false;
		Matcher m1 = MOBILE_PATTERN.matcher(str);
		if (m1.matches()) {
			b = true;
		}else{
			b = false;
		}
		return b;
	}
	 /** 
	  * 电话号码验证 
	  *  
	  * @param  str 
	  * @return 验证通过返回true 
	  */  
	 public static boolean isPhone(String str) {
        Pattern p1 = null,p2 = null;
        Matcher m = null;
        boolean b = false;
        if(str.length() >9)
        {   m = PHONE_PATTERN_WHITH_PREFIX.matcher(str);
            b = m.matches();
        }else{
            m = PHONE_PATTERN_NO_PREFIX.matcher(str);
            b = m.matches();
        }
        return b;
    } 
	 
	 public static String[] getPhonesByPhone(String phone){
		String[] phones = null;
		String[] prefixs = new String[]{"86","17951","17901","12593","17909"};
		StringBuffer str = new StringBuffer();
		// 如果不是手机号，直接退出
		if(!isMobile(phone)){
			return phones;
		}
		String phone1 = "";
		String phone2 = "";
		if(phone.indexOf("-")>0){
			phone1 = phone.replaceAll("-", "").replaceAll(" ", "");
			phone2 = phone;
		}else{
			phone1 = phone;
			String str1 = phone.substring(0,3);
			String str2 = phone.substring(3,7);
			String str3 = phone.substring(7,phone.length());
			phone2 = str1 + "-" +str2+"-"+str3;
		}
		str.append(phone1+",");
		str.append(phone2+",");
		for (int i = 0; i < prefixs.length; i++) {
			str.append(prefixs[i]+phone1+",");
			str.append(prefixs[i]+phone2+",");
		}
		phones = str.toString().split(",");
		return phones;
	 }
	 /**
	  * 信鸽返回类型
	  */
	 public static String xingeReturnMsg(String code){
		 String msg = "";
		 if(code != null && !"".equals(code)){
			 if("0".equals(code)){
				 msg = "发送成功";
			 }else if("-1".equals(code)){
				 msg = "参数错误";
			 }else if("-2".equals(code)){
				 msg = "请求时间戳不在有效期内";
			 }else if("-3".equals(code)){
				 msg = "sign校验无效，检查access id和secret key";
			 }else if("20".equals(code)){
				 msg = "鉴权错误";
			 }else if("40".equals(code)){
				 msg = "推送的用户ID没有在信鸽中注册";
			 }else if("48".equals(code)){
				 msg = "推送的账号没有在信鸽中注册";
			 }else if("73".equals(code)){
				 msg = "消息字符数超限";
			 }else if("76".equals(code)){
				 msg = "请求过于频繁，请稍后再试";
			 }else{
				 msg = "内部错误";
			 }
		 }
		 return msg;
	 }
	 
	 /**
	  * Long类型转换成日期类型
	  * @param time
	  * @return
	  */
	 public static String convertLongToDate(Long time){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		Date dt = new Date(time * 1000);
		String sDateTime = sdf.format(dt);
		return sDateTime;
	 }
	 /**
	  * Long类型转换成日期类型
	  * @param time
	  * @return
	  */
	 public static String convertLongToNewDate(Long time){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		Date dt = new Date(time * 1000);
		String sDateTime = sdf.format(dt);
		return sDateTime;
	 }
	 /**
	  * Long类型转换成时间类型
	  * @param time
	  * @return
	  */
	 public static String convertLongToDateTime(Long time){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date(time * 1000);
		String sDateTime = sdf.format(dt);
		return sDateTime;
	 }

	public static String convertLongToDateTime(Long time,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dt = new Date(time * 1000);
		String sDateTime = sdf.format(dt);
		return sDateTime;
	}

	public static Long convertDateTimeToLong(String dateTime) {
		long rand = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d2 = null;
		try {
			d2 = sdf.parse(dateTime);
			// 将String to Date类型
			rand = d2.getTime();
			return rand / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}

	//删除文件夹
	//param folderPath 文件夹完整绝对路径
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//删除指定文件夹下所有文件
	//param path 文件夹完整绝对路径
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
        if (tempList == null || tempList.length == 0) {
            return true;
        }
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Convert hex string to byte[]
	 *
	 * @param hexString
	 *            the hex string
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	public static String covertDiget2Cap(String code){
		StringBuffer result = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "零");
		map.put("1", "一");
		map.put("2", "二");
		map.put("3", "三");
		map.put("4", "四");
		map.put("5", "五");
		map.put("6", "六");
		map.put("7", "七");
		map.put("8", "八");
		map.put("9", "九");
		if(null != code && !"".equals(code)){
			int length = code.length();
			char[] c = code.toCharArray();
			for(int i = 0; i < length; i++){
				result.append(map.get(c[i]+""));
			}
		}

		return result.toString();
	}

	/**
	 * 替换所有特殊符号
	 * @param str
	 * @return
	 */
	public static String StringFilter(String str) {
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？_-]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * Convert char to byte
	 *
	 * @param c
	 *            char
	 * @return byte
	 */
	public static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	/**
	 * 详细设计： 1.指定日期加day天
	 */
	public static synchronized Date addDay(Date date,int day) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, day);
		return gc.getTime();
	}

	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	 /**
      *  格式化日期
      *
      *  @param  dateStr
      *                        字符型日期
      *                        格式
      *  @return  返回日期
      */
	public static Date parseDate(String dateStr) {
		Date date = null;
		try {
			java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			date = (Date) df.parse(dateStr);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 获取前一天的0点0分0秒
	 * @author lichao
	 * @time 2015年1月14日10:53:07
	 * @return
	 */
	public static Long getStartTime(){
		Long startTime = 0L;
		Date ydate = CommonUtil.addDay(new Date(),-1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String day = format.format(ydate);
		String startDay = day+" 00:00:00";
		startTime = CommonUtil.convertDateTimeToLong(startDay);
		return startTime;
	}
	/**
	 * 获取前一天的23点59分59秒
	 * @author lichao
	 * @time 2015年1月14日10:53:07
	 * @return
	 */
	public static Long getEndTime(){
		Long endTime = 0L;
		Date ydate = CommonUtil.addDay(new Date(),-1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String day = format.format(ydate);
		String endDay = day+" 23:59:59";
		endTime = CommonUtil.convertDateTimeToLong(endDay);
		return endTime;
	}

	/**
	 * 格式化手机号
	 */
	public static String getPhoneFormat(String phone){
		String retPhone =  phone.replaceAll("-","").replaceAll(" ", "").replaceAll("17951","")
				.replaceAll("\\+86","").replaceAll("12593","").replaceAll("\\+","")
				.replaceAll("\\(","").replaceAll("\\)","").replaceAll("\\<", "")
				.replaceAll("\\>", "").replaceAll("\\*", "").replaceAll("\\#", "");
		return retPhone;
	}

	public static void main(String[] args) {

	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * @param beginDateStr
	 * @param endDateStr
	 * @return
	 * long
	 * @author lichao
	 */
	public static long getDaySub(String beginDateStr,String endDateStr)
	{
		long day=0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		Date endDate;
		try
		{
			beginDate = format.parse(beginDateStr);
			endDate= format.parse(endDateStr);
			day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
		} catch (ParseException e)
		{

		}
		return day;
	}

    public static Long convertDateToLong(String date) {
        long rand = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = null;
        try {
            d2 = sdf.parse(date);
            // 将String to Date类型
            rand = d2.getTime();
            return rand / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }

	/**
	 * 四舍五入保留小数位
	 * @param num 需要格式的对象
	 * @param digits 需要保留的位数
	 */
	public static double keepLongDigits(double num,int digits) {
		BigDecimal bg = BigDecimal.valueOf(num);
		double f1 = bg.setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	/*
	 * 校验字段串是否为纯数字
	 */
	public static boolean isNumeric(String str){ 
		 Matcher isNum = NUMBER_PATTERN.matcher(str);
		 if( !isNum.matches() ){
		     return false; 
		 } 
		  return true; 
	}
}
