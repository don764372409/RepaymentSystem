package com.yuanmaxinxi.domain.sms;

import java.util.Date;

public class Sms {
	private Long id;
	private String phone;
	private Date sendTime;
	private int status;
	private Long brrId;//借款人外键
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
	
}
