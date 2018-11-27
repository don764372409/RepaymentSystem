package com.yuanmaxinxi;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class RepaymentSystemApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(RepaymentSystemApplication.class, args);
	}
}
