package com.yuanmaxinxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.service.borrower.BorrowerService;

@Controller
@RequestMapping("/borrower")
public class BorrowerController {
	@Autowired
	private BorrowerService borrowerService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Borrower> list = borrowerService.selectAll();
		model.addAttribute("list", list);
		return "borrower/list";
	}
}
