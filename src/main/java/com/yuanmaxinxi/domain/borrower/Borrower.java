package com.yuanmaxinxi.domain.borrower;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.yuanmaxinxi.domain.person.Person;
import com.yuanmaxinxi.domain.person.PersonType;

public class Borrower {
	private Long id;
	private String name;
	private String phone;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date loanTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date repaymentTime;
	private String number;//合同编号
	private Long typeId;
	private PersonType type;
	private List<Person> ps = new ArrayList<>();
	
	public List<Person> getPs() {
		return ps;
	}
	public void setPs(List<Person> ps) {
		this.ps = ps;
	}
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public PersonType getType() {
		return type;
	}
	public void setType(PersonType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Borrower [id=" + id + ", name=" + name + ", phone=" + phone + ", loanTime=" + loanTime
				+ ", repaymentTime=" + repaymentTime + ", number=" + number + ", typeId=" + typeId + ", type=" + type
				+ "]";
	}
}
