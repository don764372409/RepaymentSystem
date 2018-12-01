package com.yuanmaxinxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.borrower.Borrower;
import com.yuanmaxinxi.domain.content.Content;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.borrower.BorrowerService;
import com.yuanmaxinxi.service.content.ContentService;
import com.yuanmaxinxi.service.sms.SmsService;

@Controller
@RequestMapping("/borrower")
public class BorrowerController {
	@Autowired
	private BorrowerService borrowerService;
	@Autowired
	private ContentService contentService;
	@Autowired
	private SmsService smsService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Borrower> list = borrowerService.selectAll();
		model.addAttribute("list", list);
		return "borrower/list";
	}
	
	@RequestMapping("/showAdd")
	public String showAdd(Model model) {
//		List<Person> list = personService.selectAll();
//		model.addAttribute("list", list);
		return "borrower/add";
	}
	@RequestMapping("/showSendMessage")
	public String showSendMessage(Long id,Model model) {
		Borrower obj = borrowerService.selectOneById(id);
		model.addAttribute("obj", obj);
		List<Content> list = contentService.selectAll();
		model.addAttribute("list", list);
		return "borrower/sendMessage";
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Borrower obj = borrowerService.selectOneById(id);
		model.addAttribute("obj", obj);
//		List<Person> list = personService.selectAll();
//		model.addAttribute("list", list);
//		
//		List<Long> pIds = new ArrayList<>();
//		
//		List<Person> ps = obj.getPs();
//		for (Person person : ps) {
//			pIds.add(person.getId());
//		}
//		for (Person person : list) {
//			if (pIds.contains(person.getId())) {
//				person.setSelected(true);
//			}
//		}
		return "borrower/edit";
	}
	@RequestMapping("/sendMessage")
	public @ResponseBody ResultDTO sendMessage(Borrower borr,String content,String isSave) {
		ResultDTO dto;
		try {
			smsService.sendMessage(borr,content,isSave);
			dto = ResultDTO.getIntance(true, "短信用户修改成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Borrower borr,Long[] pId) {
		ResultDTO dto;
		try {
			borrowerService.insert(borr,pId);
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
