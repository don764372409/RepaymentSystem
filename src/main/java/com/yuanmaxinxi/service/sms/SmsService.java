package com.yuanmaxinxi.service.sms;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuanmaxinxi.dao.content.ContentDAO;
import com.yuanmaxinxi.dao.sms.SmsDAO;
import com.yuanmaxinxi.dao.user.UserDAO;
import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.domain.content.Content;
import com.yuanmaxinxi.domain.sms.Sms;
import com.yuanmaxinxi.domain.user.User;
import com.yuanmaxinxi.util.SMSUtil;
@Service
public class SmsService{
	@Autowired
	private SmsDAO smsDAO;
	@Autowired
	private ContentDAO contentDAO;
	@Autowired
	private UserDAO userDAO;
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
			sms.setPhone("借款人ID："+brr.getId()+"|借款人手机号:"+brr.getPhone());
			sms.setSendTime(new Date());
			sms.setContent(content.getContent());
			int status = 0;//发送成功状态 0-失败  1-成功
			if (map.get("returnstatus").contains("Success")) {
				status = 1;
			}
			//发送失败  给管理员发送消息
			if (status==0) {
				User user = userDAO.selectOneByUsername("admin");
				//设置管理的ID为0
				Borrower b = new Borrower();
				b.setId(0L);
				b.setPhone(user.getPhone());
				Content c = new Content();
				c.setContent("借款人姓名："+brr.getName()+" 手机号码:"+sms.getPhone()+" 紧急联系人：姓名："+brr.getName2()+" 电话："+brr.getPhone2()+" 短信未发送成功.");
				sendErrorMessage(b,c);
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
	@Transactional
	public void sendErrorMessage(Borrower brr, Content content) {
		try {
			Map<String, String> map = SMSUtil.sendmsg(brr.getPhone(), content.getContent());
			Sms sms = new Sms();
			sms.setBrrId(brr.getId());
			sms.setPhone("管理员:"+brr.getPhone());
			sms.setSendTime(new Date());
			sms.setContent(content.getContent());
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
	/**
	 * 点击短信列表中的发送短信
	 * @param borr
	 * @param content
	 * @param isSave
	 */
	@Transactional
	public void sendMessage(Borrower borr, String content, String isSave) {
		Content ct = new Content();
		ct.setContent(content);
		//要保存新的模板
		if ("yes".equals(isSave)) {
			ct.setDefaultUse(0);
			ct.setTitle("新模板");
			int i = contentDAO.insert(ct);
			if (i!=1) {
				throw new RuntimeException("添加新模板失败");
			}
		}
		send(borr, ct);
	}

}