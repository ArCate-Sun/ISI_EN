package com.wkl.isien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {
    
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
        Object admin = request.getSession().getAttribute("admin");
        if (admin == null || admin.equals(""))  {
            return false;  
        }else{
        	return true;
        }
    }  
}