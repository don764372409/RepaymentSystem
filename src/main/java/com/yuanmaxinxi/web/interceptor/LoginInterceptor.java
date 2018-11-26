package com.yuanmaxinxi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.yuanmaxinxi.domain.user.User;

public class LoginInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if (loginUser==null) {
			response.sendRedirect("/login/show");
			return false;
		}
        return true;
    }
}
