package com.yuanmaxinxi.web.conf;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.domain.content.Content;
import com.yuanmaxinxi.service.borrower.BorrowerService;
import com.yuanmaxinxi.service.content.ContentService;
import com.yuanmaxinxi.service.sms.SmsService;
import com.yuanmaxinxi.util.BorrowerUtil;

@Component
public class SendPhoneMessageTask {
	@Autowired
	private BorrowerService borrowerService;
	@Autowired
	private SmsService smsService;
	@Autowired
	private ContentService contentService;
	@Scheduled(cron="0 45 15 ? * *")
	public void autoSendPhoneMessage() {
		Content content = contentService.selectDefaultContent();
		Date now = new Date();
		//获取所有借款人
		List<Borrower> list = borrowerService.selectAll();
		for (Borrower brr : list) {
			boolean isSend = BorrowerUtil.isSend(now, brr.getLoanTime(), brr.getRepaymentTime());
			if (isSend) {
				System.err.println("发送短信");
				smsService.send(brr, content);
			}
		}
		System.err.println("执行任务");
	}
}
