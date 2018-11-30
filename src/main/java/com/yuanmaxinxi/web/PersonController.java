package com.yuanmaxinxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.person.Person;
import com.yuanmaxinxi.domain.person.PersonType;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.person.PersonService;
import com.yuanmaxinxi.service.persontype.PersonTypeService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	@Autowired
	private PersonTypeService personTypeService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Person> list = personService.selectAll();
		model.addAttribute("list", list);
		return "person/list";
	}
	
	@RequestMapping("/showAdd")
	public String showAdd(Model model) {
		List<PersonType> list = personTypeService.selectAll();
		model.addAttribute("list", list);
		return "person/add";
	}
	@RequestMapping("/showEdit")
	public String showEdit(Long id,Model model) {
		Person obj = personService.selectOneById(id);
		model.addAttribute("obj", obj);
		List<PersonType> list = personTypeService.selectAll();
		model.addAttribute("list", list);
		return "person/edit";
	}
	@RequestMapping("/add")
	public @ResponseBody ResultDTO add(Person obj) {
		ResultDTO dto;
		try {
			personService.insert(obj);
			dto = ResultDTO.getIntance(true, "短信模板添加成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/edit")
	public @ResponseBody ResultDTO edit(Person obj) {
		ResultDTO dto;
		try {
			personService.update(obj);
			dto = ResultDTO.getIntance(true, "用户修改成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/delete")
	public @ResponseBody ResultDTO delete(Long id) {
		ResultDTO dto;
		try {
			personService.delete(id);
			dto = ResultDTO.getIntance(true, "用户删除成功.");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	
}
