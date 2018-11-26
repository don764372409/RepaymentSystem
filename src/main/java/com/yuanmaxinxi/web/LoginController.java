package com.yuanmaxinxi.web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanmaxinxi.domain.user.User;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.service.user.UserService;
import com.yuanmaxinxi.util.CodeUtil;
import com.yuanmaxinxi.util.StringUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/show")
	public String show() {
		return "login";
	}
	@RequestMapping("/code")
	public void sendCode(HttpSession session,HttpServletResponse resp) {
		Map<String, Object> map = CodeUtil.generateCodeAndPic();
		session.setAttribute("code", map.get("code").toString());
		try {
			ServletOutputStream out = resp.getOutputStream();
			BufferedImage img = (BufferedImage)map.get("codePic");
			ImageIO.write(img,"jpeg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/login")
	public @ResponseBody ResultDTO login(User user,String code,HttpSession session) {
		ResultDTO dto;
		try {
			String sysCode = (String)session.getAttribute("code");
//			if (!StringUtil.isNotNullAndEmpty(sysCode)) {
//				dto = ResultDTO.getIntance(false,"请刷新页面.");
//				return dto;
//			}
//			if (!sysCode.equalsIgnoreCase(code)) {
//				dto = ResultDTO.getIntance(false,"验证码输入错误.");
//				return dto;
//			}
			User loginUser = userService.login(user);
			session.setAttribute("loginUser", loginUser);
			dto = ResultDTO.getIntance(true,"登录成功,页面跳转中...");
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false, e.getMessage());
		}
		return dto;
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
	
}
