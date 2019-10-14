package com.wkl.isien.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkl.isien.domain.Admin;
import com.wkl.isien.domain.News;
import com.wkl.isien.domain.Rotary;
import com.wkl.isien.service.IsienService;

@RestController
@RequestMapping("/isien")
public class IsienController {
	@Autowired
	IsienService is;
	
	@RequestMapping("/getRotaryList")
	public List<Rotary> getRotaryList() {
		return is.getRotaryList();
	}
	
	@RequestMapping("getSubplateById")
	public List<String> getSubplateById(int id){
		return is.getSubplateById(id);
	}
		
	@RequestMapping("/getPublishedNewsList")
	public List<News> getPublishedNewsList(){
		return is.getPublishedNewsList();
	}
	
	@RequestMapping("/getPublishedNewsListBySubplateid")
	public List<News> getPublishedNewsListBySubplateid(int subplateid){
		return is.getPublishedNewsListBySubplateid(subplateid);
	}
	
	@RequestMapping("/getNews")
	public News getNews(long id){
		return is.getNews(id);
	}
	
	@RequestMapping("/loginAdmin")
	public boolean loginAdmin(HttpServletRequest request,String login,String password){
		;
		Admin admin=is.loginAdmin(login,password);
		if(admin!=null){
			request.getSession().setAttribute("admin", admin);
			return true;
		}else{
			return false;
		}
	}
}
