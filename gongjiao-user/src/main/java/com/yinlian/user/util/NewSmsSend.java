package com.yinlian.user.util;

import com.alibaba.fastjson.JSONObject;
import com.yinlian.core.util.ConfigUtil;
import com.yinlian.core.util.SignUtils;
import com.yinlian.user.dto.SmsDto;
import com.yinlian.user.enums.SystemRetCode;
import com.yinlian.user.enums.SystemRetField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class NewSmsSend {
	private static final Logger logger = LoggerFactory.getLogger(NewSmsSend.class);

	public SmsDto sendSmsContext(SmsDto me){
		HttpsURLConnection httpsUrlConnection = null;
		BufferedReader br = null;
		SSLContext sslContext = null;
		TrustManager trustManager = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		SSLSocketFactory sslSocketFactory = null;
		URL urlValue = null;
		HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}

			public boolean verify1(String hostname, SSLSession session) {
				// TODO Auto-generated method stub
				return false;
			}
		};		
		
//		String smsCustId     = param.get("sms.custId");
//		String smsPartnerId  = param.get("sms.partnerId");	
//		String smsNewUrl     = param.get("sms.newUrl");
//		String smsPrivateKey = param.get("sms.privateKey");  //本端私钥
//		String smsPublicKey  = param.get("sms.publicKey");   //对端公钥		
		String smsCustId     = ConfigUtil.getValue("newSms.custId");
		String smsPartnerId  = ConfigUtil.getValue("newSms.partnerId");
		String smsNewUrl     = ConfigUtil.getValue("newSms.newUrl");
		String smsPrivateKey = ConfigUtil.getValue("newSms.privateKey");  //本端私钥
		String smsPublicKey  = ConfigUtil.getValue("newSms.publicKey");   //对端公钥
		
		String receiver      = me.getMobileNum();
		String content       = me.getVcode();

		logger.info("sms.url["+smsNewUrl+"]");
		logger.info("sms.key["+smsPrivateKey+"]");

		//处理请求参数
    	JSONObject smsReq = new JSONObject();
    	smsReq.put("custId", smsCustId);
    	smsReq.put("custOrderId", String.valueOf(System.currentTimeMillis()));
    	smsReq.put("partnerId", smsPartnerId);
    	smsReq.put("phoneNum", receiver);
    	smsReq.put("smsContent", content);
    	smsReq.put("remarks", "资金归集平台");		

        try {
	        // 添加签名
	        System.out.println(SignUtils.getSignData(smsReq));
	        String sign = "no_sign";
	        // 签名建议
	        sign = SignUtils.signBySoft(smsPrivateKey, SignUtils.getSignData(smsReq));
	        smsReq.put("sign", sign);

	        // 执行请求
	        String reqMsgHasSign = smsReq.toJSONString();
	        logger.info("短信发送请求报文：" + reqMsgHasSign);
	        /*
	        //String respStr = HttpUtils.execute(smsNewUrl, reqMsgHasSign, 60000);
	        String respStr = HttpsUtil.sendDataByPost(smsNewUrl, reqMsgHasSign);
	        */
	        //开始
			sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { trustManager }, null);
			sslSocketFactory = sslContext.getSocketFactory();
			HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);

			urlValue = new URL(smsNewUrl);
			httpsUrlConnection = (HttpsURLConnection) urlValue.openConnection();

			logger.info("设置https，绕过证书。");
			httpsUrlConnection.setConnectTimeout(180000);
			httpsUrlConnection.setRequestProperty("connection", "Keep-Alive");
			httpsUrlConnection.setRequestMethod("POST");
			httpsUrlConnection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
			httpsUrlConnection.setSSLSocketFactory(sslSocketFactory);
			httpsUrlConnection.setRequestProperty("Content-Length", String.valueOf(reqMsgHasSign.getBytes().length));
			httpsUrlConnection.setDoOutput(true);
			httpsUrlConnection.setDoInput(true);
			logger.info("设置https连接参数。");
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(httpsUrlConnection.getOutputStream(), "UTF-8"));
			pw.write(reqMsgHasSign);
			pw.flush();
			pw.close();

			//int responseCode = httpUrlConnection.getResponseCode();
			br = new BufferedReader(new InputStreamReader(httpsUrlConnection.getInputStream(),"UTF-8"));
			String respStr = br.readLine();
	        //结束
	        logger.info("短信发送响应报文：" + respStr);
	        JSONObject respJson = JSONObject.parseObject(respStr);
	        if (!SystemRetCode.SUCCESS.toString().equalsIgnoreCase(respJson.getString(SystemRetField.RET_CODE.toString()))) {
				me.setRespCode("9999");
				me.setRespDesc(respJson.getString(SystemRetField.RET_DESC.toString()));
				return me;
	        }
	        String retSign = respJson.remove("sign") + "";
	        logger.info("sign:" + retSign);

	        // 验证平台签名
	        logger.info("待签名字符串：" + SignUtils.getSignData(respJson));
	        boolean signResult = SignUtils.verifyingSign(smsPublicKey, retSign, SignUtils.getSignData(respJson));
	        logger.info("验签结果：" + signResult);
	        if (!signResult) {
				me.setRespCode("9999");
				me.setRespDesc("验平台签名失败，请检查公钥是否正确或者数据是否被篡改"); 
				return me;
	        }
	        //通常意义上一次成功的通讯
	        me.setRespCode("0000");
        } catch (Exception e) {
        	logger.info("短信发送发生异常："+e);
			me.setRespCode("9999");
			me.setRespDesc("未知错误"); 
        } 
		return me;
	}	
	

}
