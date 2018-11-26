package com.yuanmaxinxi.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MailUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	public static void send() {
		String url = "http://120.77.14.55:8888/v2sms.aspx";
		String content="";
		String phones="15181950314,15215097887";
		//创建客户端
		CloseableHttpClient client = HttpClients.createDefault();
		 CloseableHttpResponse response = null;
	        String resultString = "";
	        try {
	            // 创建Http Post请求
	            HttpPost httpPost = new HttpPost(url);
	            // 创建参数列表
                List<NameValuePair> paramList = new ArrayList<>();
                paramList.add(new BasicNameValuePair("action","send"));
                paramList.add(new BasicNameValuePair("userid","12"));
                Date date = new Date();
                String timestamp = sdf.format(date);
                paramList.add(new BasicNameValuePair("timestamp",timestamp));
                String sign = "testmima"+timestamp;
                sign = MD5Util.encode(sign);
                paramList.add(new BasicNameValuePair("sign",sign));
                paramList.add(new BasicNameValuePair("mobile",phones));
                paramList.add(new BasicNameValuePair("content","你好吗?"));
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

	}
	public static void main(String[] args) {
		send();
	}
}
