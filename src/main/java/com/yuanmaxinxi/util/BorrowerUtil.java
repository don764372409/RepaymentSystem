package com.yuanmaxinxi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author HOME
 *1.
当天日期:2018-02-28
借款日期:2018-02-28
截止日期:2018-05-27
不发短信
2.
当天日期:2018-03-28
借款日期:2018-02-28
截止日期:2018-05-27
当月还款日:27
提醒日:25
不发短信
3.
当天日期:2018-03-25
借款日期:2018-02-28
截止日期:2018-05-27
当月还款日:27
提醒日:25
发短信
4.
当天日期:2018-03-27
借款日期:2018-02-28
截止日期:2018-05-27
当月还款日:27
发短信
5.
当天日期:2018-04-25
借款日期:2018-02-28
截止日期:2018-05-27
当月还款日:27
提醒日:25
发短信
6.
当天日期:2018-04-27
借款日期:2018-02-28
截止日期:2018-05-27
当月还款日:27
发短信
7.
当天日期:2018-05-27
借款日期:2018-02-28
截止日期:2018-05-27
当月还款日:27
发短信
8.
当天日期:2018-05-28
借款日期:2018-02-28
截止日期:2018-05-27
提醒日:2018-03-25
不发短信
9.
当天日期:2018-02-27
借款日期:2018-01-30
截止日期:2018-04-29
提醒日:2018-02-25
当月还款日:28
提醒日:28
不发短信
10.
当天日期:2018-02-28
借款日期:2018-01-30
截止日期:2018-04-29
提醒日:2018-02-25
当月还款日:28
发短信
11.
当天日期:2018-03-29
借款日期:2018-01-30
截止日期:2018-04-29
提醒日:2018-02-25
当月还款日:29
发短信
12.
当天日期:2018-03-27
借款日期:2018-01-30
截止日期:2018-04-29
提醒日:2018-02-25
当月还款日:29
提醒日:27
发短信
13.
当天日期:2018-04-27
借款日期:2018-01-30
截止日期:2018-04-29
提醒日:2018-02-25
当月还款日:29
提醒日:27
发短信
14.
当天日期:2018-04-29
借款日期:2018-01-30
截止日期:2018-04-29
提醒日:2018-02-25
当月还款日:29
发短信
15.
当天日期:2018-01-29
借款日期:2018-01-01
截止日期:2018-12-31
提醒日:2018-01-29
当月还款日:31
提醒日:29
发短信
16.
当天日期:2018-01-31
借款日期:2018-01-01
截止日期:2018-12-31
提醒日:2018-01-29
当月还款日:31
发短信
17.
当天日期:2018-02-01
借款日期:2018-01-01
截止日期:2018-12-31
提醒日:2018-01-29
当月还款日:31
提醒日:29
不发短信

18.
当天日期:2018-02-28
借款日期:2018-01-01
截止日期:2018-12-31
提醒日:2018-01-29
当月还款日:28
发短信

19.
当天日期:2018-02-26
借款日期:2018-01-01
截止日期:2018-12-31
提醒日:2018-01-29
当月还款日:28
当月还款日:28
提醒日:26
发短信

20.
当天日期:2018-03-29
借款日期:2018-01-01
截止日期:2018-12-31
提醒日:2018-01-29
当月还款日:31
当月还款日:31
提醒日:29
发短信

 */
public class BorrowerUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	public static void main(String[] args) {
//		Date nowTime = new Date();
//		try {
//			Date beginTime =sdf.parse("2018-1-1");
//			Date endTime = sdf.parse("2018-12-31");
//			System.err.println("当天日期:"+sdf.format(nowTime));
//			System.err.println("借款日期:"+sdf.format(beginTime));
//			System.err.println("截止日期:"+sdf.format(endTime));
//			boolean b = isSend(nowTime,beginTime,endTime);
//			System.err.println(b?"发短信":"不发短信");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
	/**
     * 判断今天是否发送短信
     * @param nowTime   当前时间
     * @param beginTime 借款时间
     * @param endTime   还款结束时间
     * @return
     */
    public static boolean isSend(Date nowTime, Date beginTime, Date endTime) {
    	//计算当月的还款日
    	Calendar begin = Calendar.getInstance();
    	begin.setTime(beginTime);
    	//得到日期
    	int day = begin.get(Calendar.DAY_OF_MONTH);
    	//在获取当前月的最大天数
    	Calendar now = Calendar.getInstance();
    	now.setTime(nowTime);
    	
    	Calendar end = Calendar.getInstance();
    	end.setTime(endTime);
    	//得到借款时间的下一个月的前两天  得到第一次还款日
    	begin.add(Calendar.MONTH, 1);
    	begin.add(Calendar.DAY_OF_MONTH, -3);
    	System.err.println("提醒日:"+sdf.format(begin.getTime()));
    	if (begin.getTime().getTime()>now.getTime().getTime()||end.getTime().getTime()+24*60*60*1000<now.getTime().getTime()) {
			return false;
		}
    	//计算当月的还款日
    	begin = Calendar.getInstance();
    	begin.setTime(beginTime);
    	//得到日期
    	begin.add(Calendar.DAY_OF_MONTH, -1);
    	day = begin.get(Calendar.DAY_OF_MONTH);
    	//在获取当前月的最大天数
    	now = Calendar.getInstance();
    	now.setTime(nowTime);
    	int maxNowDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
    	//判断
    	int hkDay = 0;
    	if (day>maxNowDay) {
    		//如果还款日 大于当前月的最大天数  那么还款日 就是当前的最大天数
			hkDay = maxNowDay;
			//设置进去
			begin.set(Calendar.DAY_OF_MONTH, hkDay);
		}else {
			//否则就是还款日减一天
			hkDay = begin.get(Calendar.DAY_OF_MONTH);
		}
    	System.err.println("当月还款日:"+hkDay);
    	int nowDay=now.get(Calendar.DAY_OF_MONTH);
    	if (nowDay==hkDay) {
    		return true;
		}
    	System.err.println("当月还款日:"+hkDay);
    	//计算提醒日
    	begin.add(Calendar.DAY_OF_MONTH, -2);
		int txDay = begin.get(Calendar.DAY_OF_MONTH);
		System.err.println("提醒日:"+txDay);
    	if (nowDay==txDay) {
			return true;
		}
    	return false;
    }
}
