package com.yuanmaxinxi.domain.borrower;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

public class Borrower {
	private Long id;
	private String name;
	private String phone;
	private String name11;
	private String phone11;
	private String name12;
	private String phone12;
	private String name21;
	private String phone21;
	private String name22;
	private String phone22;
	private String name23;
	private String phone23;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date loanTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date repaymentTime;
	private String number;//合同编号
	private String remark;//备注
	private List<Map<String,String>> ps = new ArrayList<>();
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName11() {
		return name11;
	}
	public void setName11(String name11) {
		this.name11 = name11;
	}
	public String getPhone11() {
		return phone11;
	}
	public void setPhone11(String phone11) {
		this.phone11 = phone11;
	}
	public String getName12() {
		return name12;
	}
	public void setName12(String name12) {
		this.name12 = name12;
	}
	public String getPhone12() {
		return phone12;
	}
	public void setPhone12(String phone12) {
		this.phone12 = phone12;
	}
	public String getName21() {
		return name21;
	}
	public void setName21(String name21) {
		this.name21 = name21;
	}
	public String getPhone21() {
		return phone21;
	}
	public void setPhone21(String phone21) {
		this.phone21 = phone21;
	}
	public String getName22() {
		return name22;
	}
	public void setName22(String name22) {
		this.name22 = name22;
	}
	public String getPhone22() {
		return phone22;
	}
	public void setPhone22(String phone22) {
		this.phone22 = phone22;
	}
	public String getName23() {
		return name23;
	}
	public void setName23(String name23) {
		this.name23 = name23;
	}
	public String getPhone23() {
		return phone23;
	}
	public void setPhone23(String phone23) {
		this.phone23 = phone23;
	}
	public List<Map<String, String>> getPs() {
		return ps;
	}
	public void setPs(List<Map<String, String>> ps) {
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
	@Override
	public String toString() {
		return "Borrower [id=" + id + ", name=" + name + ", phone=" + phone + ", name11=" + name11 + ", phone11="
				+ phone11 + ", name12=" + name12 + ", phone12=" + phone12 + ", name21=" + name21 + ", phone21="
				+ phone21 + ", name22=" + name22 + ", phone22=" + phone22 + ", name23=" + name23 + ", phone23="
				+ phone23 + ", loanTime=" + loanTime + ", repaymentTime=" + repaymentTime + ", number=" + number
				+ ", ps=" + ps + "]";
	}
}
