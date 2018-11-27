package com.yuanmaxinxi.webconf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.service.borrower.BorrowerService;

@Component
public class SendPhoneMessageTask {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd");
	@Autowired
	private BorrowerService borrowerService;
	@Scheduled(cron="0 06 12 ? * *")
	public void autoSendPhoneMessage() {
		int sysDate = Integer.parseInt(sdf.format(new Date()));
		//获取所有借款人
		List<Borrower> list = borrowerService.selectAll();
		for (Borrower brr : list) {
			//获取还款时间 只有日期 不要年月
			Date date = brr.getRepaymentTime();
			int time = Integer.parseInt(sdf.format(date));
			System.err.println("当前日期:"+sysDate+",还款日期:"+time);
			if (sysDate+2==time) {
				//如果系统时间是还款时间的前两天，发送    并记录
				System.err.println("发送");
			}else if(sysDate==time) {
				//如果系统时间是当款时间当天,   发送   并记录
				System.err.println("发送");
			}
		}
	}
}
