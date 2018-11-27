package com.yuanmaxinxi.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanmaxinxi.domain.sms.Sms;
import com.yuanmaxinxi.service.sms.SmsService;

@Controller
@RequestMapping("/sms")
public class SmsController {
	@Autowired
	private SmsService smsService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Sms> list = smsService.selectAll();
		model.addAttribute("list", list);
		Map<String, String> map = smsService.selectNumber();
		model.addAttribute("obj", map);
		return "sms/list";
	}
}
