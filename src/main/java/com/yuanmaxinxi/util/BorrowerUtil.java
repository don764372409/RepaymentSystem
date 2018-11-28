package com.yuanmaxinxi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BorrowerUtil {
//	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	public static void main(String[] args) {
//		Date nowTime = new Date();
//		try {
//			Date beginTime =sdf.parse("2018-10-30");
//			Date endTime = sdf.parse("2019-10-30");
//			boolean b = isSend(nowTime,beginTime,endTime);
//			System.err.println(b);
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
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        //从下个月减2天开始发
        begin.add(Calendar.MARCH, 1);
//        System.err.println("还款日:"+sdf.format(begin.getTime()));
        //下个月的还款时间
        //提醒时间
        begin.add(Calendar.DAY_OF_MONTH,-2);
//        System.err.println("还款提醒日:"+sdf.format(begin.getTime()));
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
        	//在还款期限类
        	//还款日的前两天是今天
        	int i = begin.get(Calendar.DAY_OF_MONTH);
        	System.err.println("还款日提醒日:"+i);
        	int now = date.get(Calendar.DAY_OF_MONTH);
        	System.err.println("今天:"+now);
        	if (i==now) {
				return true;
			}
			begin.add(Calendar.DAY_OF_MONTH, 2);
			i = begin.get(Calendar.DAY_OF_MONTH);
			System.err.println("还款日:"+i);
			//还款日是今天
			if (i==now) {
				return true;
			}
            return false;
        } else {
            return false;
        }
    }
}
