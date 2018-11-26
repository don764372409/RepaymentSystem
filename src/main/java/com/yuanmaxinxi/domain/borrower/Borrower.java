package com.yuanmaxinxi.domain.borrower;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Borrower {
	private Long id;
	private String name;
	private String phone;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date loanTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date repaymentTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLoanTime() {
		return loanTime;
	}
	public void setLoanTime(Date loanTime) {
		this.loanTime = loanTime;
	}
	public Date getRepaymentTime() {
		return repaymentTime;
	}
	public void setRepaymentTime(Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	public String toString() {
		return "Borrower [id=" + id + ", name=" + name + ", phone=" + phone + ", loanTime=" + loanTime
				+ ", repaymentTime=" + repaymentTime + "]";
	}
}
