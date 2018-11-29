package com.yuanmaxinxi.domain.borrower;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.yuanmaxinxi.domain.person.Person;

public class Borrower {
	private Long id;
	private String name;
	private String phone;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date loanTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date repaymentTime;
	private String number;//合同编号
	private String remark;
}
