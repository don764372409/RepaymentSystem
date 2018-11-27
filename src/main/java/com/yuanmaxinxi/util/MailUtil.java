package com.yuanmaxinxi.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.derby.tools.sysinfo;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MailUtil {
	private static String sendMessageUrl = "http://120.77.14.55:8888/v2sms.aspx";
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static String userId = "8814";//企业ID
	private static String username = "jmwl";//账号
	private static String password = "jmwl123";//密码
	private static String signName = "【科技】 ";//签名
	
	public static Map<String,Object> send(String phones,String content) {
		Map<String,Object> map = new HashMap<>();
		//创建客户端
		CloseableHttpClient client = HttpClients.createDefault();
		 CloseableHttpResponse response = null;
	        String resultString = "";
	        try {
	            // 创建Http Post请求
	            HttpPost httpPost = new HttpPost(sendMessageUrl);
	            // 创建参数列表
                List<NameValuePair> paramList = new ArrayList<>();
                paramList.add(new BasicNameValuePair("action","send"));
                paramList.add(new BasicNameValuePair("userid","8814"));
                Date date = new Date();
                String timestamp = sdf.format(date);
                paramList.add(new BasicNameValuePair("timestamp",timestamp));
                String sign = username+password+timestamp;
                sign = MD5Util.encode(sign);
                paramList.add(new BasicNameValuePair("sign",sign));
                paramList.add(new BasicNameValuePair("mobile",phones));
                String sendContent = new String((signName+content).getBytes(),"utf-8");
                System.err.println(sendContent);
                paramList.add(new BasicNameValuePair("content",sendContent));
                paramList.add(new BasicNameValuePair("sendTime",""));
                paramList.add(new BasicNameValuePair("extno",""));
//                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
//	            // 执行http请求
	            response = client.execute(httpPost);
	            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
	            System.err.println(resultString);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                response.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	}
	public static void main(String[] args) {
		send("15181950.14,18040395687","你好吗？");
	}
}
