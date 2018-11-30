package com.yuanmaxinxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanmaxinxi.domain.person.PersonType;
import com.yuanmaxinxi.service.persontype.PersonTypeService;

@Controller
@RequestMapping("/personType")
public class PersonTypeController {
	@Autowired
	private PersonTypeService personTypeService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<PersonType> list = personTypeService.selectAll();
		model.addAttribute("list", list);
		return "persontype/list";
	}
	
}
