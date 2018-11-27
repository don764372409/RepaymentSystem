package com.yuanmaxinxi.service.sms;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.sms.SmsDAO;
import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.domain.content.Content;
import com.yuanmaxinxi.domain.sms.Sms;
import com.yuanmaxinxi.util.SMSUtil;
@Service
public class SmsService{
	@Autowired
	private SmsDAO smsDAO;
	@Transactional
	public int insert(Sms obj){
		return smsDAO.insert(obj);
	}


	@Transactional
	public int update(Sms obj){
		return smsDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return smsDAO.delete(id);
	}


	public Sms selectOneById(Long id){
		return smsDAO.selectOneById(id);
	}


	public List<Sms> selectAll(){
		return smsDAO.selectAll();
	}
	/**
	 * 查询短信余额
	 * @return
	 * @throws  
	 */
	public Map<String,String> selectNumber() {
		try {
			return SMSUtil.checkYUE();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}
	/**
	 * 发送消息
	 * @param brr
	 * @param content
	 */
	@Transactional
	public void send(Borrower brr, Content content) {
		try {
			Map<String, String> map = SMSUtil.sendmsg(brr.getPhone(), content.getContent());
			Sms sms = new Sms();
			sms.setBrrId(brr.getId());
			sms.setPhone(brr.getPhone());
			sms.setSendTime(new Date());
			int status = 0;//发送成功状态 0-失败  1-成功
			if (map.get("returnstatus").contains("Success")) {
				status = 1;
			}
			sms.setStatus(status);
			int i = insert(sms);
			if (i!=1) {
				throw new RuntimeException("添加发送记录失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}