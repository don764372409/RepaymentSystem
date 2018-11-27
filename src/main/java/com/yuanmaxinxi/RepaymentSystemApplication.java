package com.yuanmaxinxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.yuanmaxinxi.util.DBUtil;


@SpringBootApplication
@EnableScheduling
public class RepaymentSystemApplication {
	public static void main(String[] args) {
		DBUtil.createTableBaseData();
		SpringApplication.run(RepaymentSystemApplication.class, args);
	}
}
