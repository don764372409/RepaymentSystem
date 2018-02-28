package com.yuanmaxinxi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowerUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		Date nowTime = new Date();
		try {
			Date beginTime =sdf.parse("2018-1-30");
			Date endTime = sdf.parse("2018-4-29");
			System.err.println("当天日期:"+sdf.format(nowTime));
			System.err.println("借款日期:"+sdf.format(beginTime));
			System.err.println("截止日期:"+sdf.format(endTime));
			boolean b = isSend(nowTime,beginTime,endTime);
			System.err.println(b?"发短信":"不发短信");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/**
     * 判断今天是否发送短信
     * @param nowTime   当前时间
     * @param beginTime 借款时间
     * @param endTime   还款结束时间
     * @return
     */
    public static boolean isSend(Date nowTime, Date beginTime, Date endTime) {
    	//计算当月的还款日
    	return false;
    }
}
