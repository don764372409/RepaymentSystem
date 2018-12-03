package com.yuanmaxinxi.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SMSUtil {
	static String id = "8814"; // 帐号的ID
	static String ac = "jmwl"; // 帐号
	static String pw = "jmwl123"; // 帐号的密码
	static String signName = "【掌骏传媒】"; // 需要下发的短信内容
	static String xml = "http://sms.izjun.cn";

	static Date date = new Date();
	static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
	static String dateStr = sf.format(date);// 时间戳，年月日时分秒
	static String str = ac + pw + dateStr;// MD5加密，账号+密码+时间戳 把帐号和密码写上去
	static String sign = MD5Encode(str);// MD5加密值

	/*
	 * mobile  手机号码  多个用,逗号隔开
	 * content  发送内容  默认签名:【掌俊传媒】
	 * 
	 */
	public static Map<String,String> sendmsg(String mobile,String content) throws Exception { // 发送短信的接口调用
		System.err.println("发送电话："+mobile);
		System.err.println("发送内容："+content);
		String urlString = xml + "/v2sms.aspx?";
		String send = "action=send&userid=" + id + "&timestamp=" + dateStr + "&sign=" + sign + "&mobile=" + mobile
				+ "&content=" + signName+content + "&sendTime=&extno=";
		URL url = new URL(urlString);
		HttpURLConnection hp = (HttpURLConnection) url.openConnection();
		byte[] b = send.getBytes("utf-8");
		hp.setRequestMethod("POST");
		hp.setDoOutput(true);
		hp.setDoInput(true);
		OutputStream out = hp.getOutputStream();
		out.write(b);
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(hp.getInputStream(), "utf-8"));
		String result="";
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			result+=inputLine;
		}
		in.close();
		hp.disconnect();
		return XmlUtil.xmlToMap1(result);
	}

	public static Map<String,String> checkYUE() throws Exception { // 查询余额的接口调用
		String urlString = xml + "/v2sms.aspx?";
		String send = "action=overage&userid=" + id + "&timestamp=" + dateStr + "&sign=" + sign;
		URL url = new URL(urlString);
		HttpURLConnection hp = (HttpURLConnection) url.openConnection();
		byte[] b = send.getBytes("utf-8");
		hp.setRequestMethod("POST");
		hp.setDoOutput(true);
		hp.setDoInput(true);
		OutputStream out = hp.getOutputStream();
		out.write(b);
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(hp.getInputStream(), "utf-8"));
		String result="";
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			result+=inputLine;
		}
		in.close();
		hp.disconnect();
		return XmlUtil.xmlToMap2(result);
	}
	public final static String MD5Encode(String s) {
		try {
			byte[] btInput = s.getBytes("utf-8");
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(val));
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
