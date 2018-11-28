package com.yuanmaxinxi.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.user.User;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showPassword")
	public String showPassword() {
		return "user/password";
	}
	@RequestMapping("/showPhone")
	public String show() {
		return "user/phone";
	}
	@RequestMapping("/updatePassword")
	public @ResponseBody ResultDTO updatePassword(User user,HttpSession session) {
		ResultDTO dto;
		try {
			User loginUser = (User)session.getAttribute("loginUser");
			loginUser = userService.updatePassword(loginUser,user);
			session.setAttribute("loginUser", loginUser);
			dto = ResultDTO.getIntance(true,"密码修改成功!");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
	@RequestMapping("/updatePhone")
	public @ResponseBody ResultDTO updatePhone(User user,HttpSession session) {
		ResultDTO dto;
		try {
			userService.updatePhone(user);
			User loginUser = (User)session.getAttribute("loginUser");
			loginUser.setPhone(user.getPhone());
			session.setAttribute("loginUser", loginUser);
			dto = ResultDTO.getIntance(true,"手机修改成功!");
		} catch (Exception e) {
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
	}
}
