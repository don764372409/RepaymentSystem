package com.yuanmaxinxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.content.Content;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.content.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Content> list = contentService.selectAll();
		model.addAttribute("list", list);
		return "content/list";
	}
	
	@RequestMapping("/showAdd")
	public String showAdd() {
		return "content/add";
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Content obj = contentService.selectOneById(id);
		model.addAttribute("obj", obj);
		return "content/edit";
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Content obj) {
		ResultDTO dto;
		try {
			contentService.insert(obj);
			dto = ResultDTO.getIntance(true, "短信模板添加成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/edit")
	public @ResponseBody ResultDTO edit(Content obj) {
		ResultDTO dto;
		try {
			contentService.update(obj);
			dto = ResultDTO.getIntance(true, "短信模板修改成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/delete")
	public @ResponseBody ResultDTO delete(Long id) {
		ResultDTO dto;
		try {
			contentService.delete(id);
			dto = ResultDTO.getIntance(true, "短信模板删除成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	
}
