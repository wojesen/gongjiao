package com.yinlian.core.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpsUtil {
	public static String sendXMLDataByPost(String postUrl, String xmlData) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(postUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setRequestProperty("Content-type", "text/xml");
			httpConn.setConnectTimeout(60000);
			httpConn.setReadTimeout(60000);
			// 发送请求
			httpConn.getOutputStream().write(xmlData.getBytes("utf-8"));
			httpConn.getOutputStream().flush();
			httpConn.getOutputStream().close();
			// 获取输入流
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
			char[] buf = new char[1024];
			int length = 0;
			while ((length = reader.read(buf)) > 0) {
				sb.append(buf, 0, length);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String sendDataByPost(String postUrl, String data) throws Exception{
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(postUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setRequestProperty("Content-type", "application/json");
			httpConn.setConnectTimeout(60000);
			httpConn.setReadTimeout(60000);
			// 发送请求
			httpConn.getOutputStream().write(data.getBytes("utf-8"));
			httpConn.getOutputStream().flush();
			httpConn.getOutputStream().close();
			// 获取输入流
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
			char[] buf = new char[1024];
			int length = 0;
			while ((length = reader.read(buf)) > 0) {
				sb.append(buf, 0, length);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 95516短信平台发送
	 */
	public static String readContentFromPost(String url, String accessId, String receiver, String content, String sign) {
		// Post请求的url，与get不同的是不需要带参数
		StringBuilder sb = new StringBuilder();
		try {
			URL postUrl = new URL(url);
			// 打开连接
			HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
			// 设置是否向connection输出，因为这个是post请求，参数要放在
			// http正文内，因此需要设为true
			connection.setDoOutput(true);
			// Read from the connection. Default is true.
			connection.setDoInput(true);
			// 默认是 GET方式
			connection.setRequestMethod("POST");
			// Post 请求不能使用缓存
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
			// 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
			// 进行编码
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
			// 要注意的是connection.getOutputStream会隐含的进行connect。
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			// The URL-encoded contend
			// 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
			String a = "accessId=" + accessId + "&receiver=" + receiver + "&content=" + content + "&sign=" + sign;
			// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
			out.writeBytes(a);
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			char[] buf = new char[1024];
			int length = 0;
			while ((length = reader.read(buf)) > 0) {
				sb.append(buf, 0, length);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
