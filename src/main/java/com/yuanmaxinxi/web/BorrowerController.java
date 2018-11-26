package com.yuanmaxinxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.dto.ResultDTO;
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
	
	@RequestMapping("/showAdd")
	public String showAdd() {
		return "borrower/add";
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Borrower obj = borrowerService.selectOneById(id);
		model.addAttribute("obj", obj);
		return "borrower/edit";
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Borrower borr) {
		ResultDTO dto;
		try {
			borrowerService.insert(borr);
			dto = ResultDTO.getIntance(true, "短信用户添加成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/edit")
	public @ResponseBody ResultDTO edit(Borrower borr) {
		ResultDTO dto;
		try {
			borrowerService.update(borr);
			dto = ResultDTO.getIntance(true, "短信用户修改成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/delete")
	public @ResponseBody ResultDTO delete(Long id) {
		ResultDTO dto;
		try {
			borrowerService.delete(id);
			dto = ResultDTO.getIntance(true, "短信用户删除成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	
}
