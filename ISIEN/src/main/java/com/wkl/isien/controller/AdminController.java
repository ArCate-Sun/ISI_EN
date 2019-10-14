package com.wkl.isien.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkl.isien.domain.Admin;
import com.wkl.isien.domain.News;
import com.wkl.isien.service.IsienService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IsienService is;
		
	@RequestMapping("/addRotary")
	public void addRotary() {
		
	}	
	
	@RequestMapping("/deleteRotary")
	public void deleteRotary(long id){
		is.deleteNews(id);
	}
	
	@RequestMapping("/getNewsList")
	public List<News> getNewsList(){
		return is.getNewsList();
	}	
	
	@RequestMapping("/getNews")
	public News getNews(long id){
		return is.getNews(id);
	}
	
	@RequestMapping("/addNews")
	public void addNews(int plateid,int subplateid,String title,String author,String content,long highlight){
		is.addNews(plateid,subplateid,title,author,content,highlight);
	}
	
	@RequestMapping("/updateNews")
	public void updateNews(int plateid,int subplateid,String title,String author,String content,long highlight){
		is.updateNews(plateid,subplateid,title,author,content,highlight);
	}
	
	@RequestMapping("/deleteNews")
	public void deleteNews(long id){
		is.deleteNews(id);
	}
	
	@RequestMapping("/withdrawNews")
	public void withdrawNews(long id){
		is.withdrawNews(id);
	}
	
	@RequestMapping("/toppingNews")
	public void toppingNews(long id){
		is.toppingNews(id);
	}
	
	@RequestMapping("/downingNews")
	public void downingNews(long id){
		is.downingNews(id);
	}
	
	@RequestMapping("/hightlightNews")
	public void hightlightNews(long id,long timespan){
		is.hightlightNews(id,timespan);
	}
	
	@RequestMapping("/updatePasswordAdmin")
	public void updatePasswordAdmin(HttpServletRequest request,String password){
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		is.updatePasswordAdmin(admin.getLogin(),password);
	}
		
}
