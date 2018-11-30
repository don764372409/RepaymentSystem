package com.yuanmaxinxi.domain.sms;

import java.util.Date;

import com.yuanmaxinxi.domain.borrower.Borrower;

public class Sms {
	private Long id;
	private String phone;
	private Date sendTime;
	private int status;
	private Long brrId;//借款人外键
	private Borrower borrower;
	private String content;//短信发送内容
	
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getBrrId() {
		return brrId;
	}
	public void setBrrId(Long brrId) {
		this.brrId = brrId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Sms [id=" + id + ", phone=" + phone + ", sendTime=" + sendTime + ", status=" + status + ", brrId="
				+ brrId + ", borrower=" + borrower + ", content=" + content + "]";
	}
	
}
