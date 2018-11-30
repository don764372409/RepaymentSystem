package com.yuanmaxinxi.service.sms;
import java.text.SimpleDateFormat;
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
import com.yuanmaxinxi.service.borrower.BorrowerService;
import com.yuanmaxinxi.util.SMSUtil;
@Service
public class SmsService{
	@Autowired
	private SmsDAO smsDAO;
	@Autowired
	private ContentDAO contentDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BorrowerService borrowerService;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		List<Sms> list = smsDAO.selectAll();
		for (Sms sms : list) {
			if (sms.getBrrId()!=null||sms.getBrrId()>0) {
				Borrower brr = borrowerService.selectOneById(sms.getBrrId());
				sms.setBorrower(brr);
			}
		}
		return list;
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
			sms.setContent(content.getContent());
			int status = 0;//发送成功状态 0-失败  1-成功
			if (map.get("returnstatus").contains("Success")) {
				status = 1;
			}
			//发送失败  给管理员发送消息
			if (status==0) {
				User user = userDAO.selectOneByUsername("admin");
				String ct = ("合同编号:"+brr.getNumber() +" 联系人姓名："+brr.getName()+" 电话:"+brr.getPhone()+" 时间："+sdf.format(new Date())+" 短信未发送成功.");
				sendErrorMessage(ct,user.getPhone());
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
	public void sendErrorMessage(String content,String phone) {
		try {
			Map<String, String> map = SMSUtil.sendmsg(phone, content);
			Sms sms = new Sms();
			sms.setBrrId(0L);
			sms.setPhone(phone);
			sms.setSendTime(new Date());
			sms.setContent("向管理员发送失败记录短信");
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
		send(borrowerService.selectOneById(borr.getId()), ct);
	}

}