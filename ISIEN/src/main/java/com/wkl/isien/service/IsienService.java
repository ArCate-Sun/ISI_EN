package com.wkl.isien.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wkl.isien.domain.Admin;
import com.wkl.isien.domain.AdminRepository;
import com.wkl.isien.domain.News;
import com.wkl.isien.domain.NewsRepository;
import com.wkl.isien.domain.Parameter;
import com.wkl.isien.domain.ParameterRepository;
import com.wkl.isien.domain.Rotary;
import com.wkl.isien.domain.RotaryRepository;

@Service
@Transactional
public class IsienService {
	@Autowired
	private AdminRepository ar;
	@Autowired
	private NewsRepository nr;
	@Autowired
	private ParameterRepository pr;
	@Autowired
	private RotaryRepository rr;
	//轮播图获取
	public List<Rotary> getRotaryList(){
		return rr.findAll();
	}
	
	//新增轮播图，上传图片，标记url	
	public void addRotary(){
		
	}
	
	//删除轮播图
	public void deleteRotary(long id){
		rr.deleteById(id);
	}
	
	//根据板块的id获取子版块的名称
	public List<String> getSubplateById(int id){
		List<String> ls=new ArrayList<String>();
		switch(id){
		//Introduction
		case 1:
			ls.add("123");
			break;
		//Education
		case 2:
			break;
		//News
		case 3:
			break;
		//Notification
		case 4:
			break;
		}
		return ls;			
	}
	//获取新闻列表，获得所有新闻
	public List<News> getNewsList(){
		List<News> ls=nr.findAll();
		updateHighlightState(ls);				
		return ls;
	}
	//获取新闻列表，获得所有已经发布的新闻
	public List<News> getPublishedNewsList(){
		List<News> ls=nr.findByState("发布");
		updateHighlightState(ls);				
		return ls;	
	}
	//获取新闻列表，获得指定子版块ID的新闻
	public List<News> getPublishedNewsListBySubplateid(int subplateid){
		List<News> ls=nr.findByStateAndSubplateid("发布", subplateid);
		updateHighlightState(ls);				
		return ls;
	}	
	//获取新闻（新闻的id，所属板块id，所属子版块id，题目，作者，剩余高亮时间，内容，新闻状态，新闻顺序）
	public News getNews(long id){
		return nr.findById(id).orElse(null);
	}
	
	//新建新闻，保存新闻
	public void addNews(int plateid,int subplateid,String title,String author,String content,long highlight){
		News news=new News();
		news.setPlateid(plateid);
		news.setSubplateid(subplateid);
		news.setTitle(title);
		news.setAuthor(author);
		news.setContent(content);
		news.setHighlight(highlight);
		news.setState("保存");
		news.setOrder(0);
		nr.save(news);
	}
	
	//编辑新闻
	public void updateNews(int plateid,int subplateid,String title,String author,String content,long highlight){
		News news=new News();
		news.setPlateid(plateid);
		news.setSubplateid(subplateid);
		news.setTitle(title);
		news.setAuthor(author);
		news.setContent(content);
		news.setHighlight(highlight);
		news.setOrder(0);
		nr.save(news);
	}	
	//发布新闻，更新新闻状态，
	public void publishNews(long id){
		News news=nr.findById(id).orElse(null);
		if(news!=null){
			news.setState("发布");
			nr.save(news);
		}		
	}
	//删除新闻，更新新闻状态
	public void deleteNews(long id){
		nr.deleteById(id);
	}

	//撤下新闻，更新新闻状态
	public void withdrawNews(long id){
		News news=nr.findById(id).orElse(null);
		if(news!=null){
			news.setState("保存");
			nr.save(news);
		}			
	}
	//置顶新闻，更新新闻顺序
	public void toppingNews(long id){		
		Parameter p=pr.findFirstByPname("toporder");
		if(p==null){
			p=new Parameter();
			p.setPname("toporder");
			p.setPvalue("1");
		}else{
			News news=nr.findById(id).orElse(null);
			if(news!=null){
				int order=Integer.parseInt(p.getPvalue());
				news.setOrder(order);
				String norder=String.valueOf(order+1);
				p.setPvalue(norder);
				nr.save(news);
				pr.save(p);				
			}
		}
	}
	//取消置顶
	public void downingNews(long id){
		News news=nr.findById(id).orElse(null);
		if(news!=null){
			news.setOrder(0);
			nr.save(news);
		}
	}
	//设置新闻高亮的剩余时间，获得一个时间长度，与当前时间累加
	public void hightlightNews(long id,long timespan){		
		Long timenow=System.currentTimeMillis();
		News news=nr.findById(id).orElse(null);
		if(news!=null){
			news.setHighlight(timenow+timespan);
			nr.save(news);
		}
	}
	//管理员登陆
	public Admin loginAdmin(String login,String password){
		Admin admin=ar.findFirstByLoginAndPassword(login, password);
		return admin;
	}
	//修改管理员密码
	public void updatePasswordAdmin(String login,String password){
		Admin admin=ar.findFirstByLogin(login);
		admin.setPassword(password);
		ar.save(admin);		
	}
	//更新高亮状态
	public void updateHighlightState(List<News> ls){
		for(News n:ls){
			long timetarget=n.getHighlight();
			long timenow=System.currentTimeMillis();
			if(timetarget==0){
				n.setHighlightState("NO");
			}else{
				if(timetarget>timenow){
					n.setHighlightState("YES");
				}else{
					n.setHighlightState("NO");
				}				
			}			
		}
	}
}
