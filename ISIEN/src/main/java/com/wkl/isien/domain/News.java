package com.wkl.isien.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int plateid;
	private int subplateid;
	private String title;
	private String author;
	private String content;
	private long highlight;
	private String highlightState;
	private String state;
	private int order;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPlateid() {
		return plateid;
	}
	public void setPlateid(int plateid) {
		this.plateid = plateid;
	}
	public int getSubplateid() {
		return subplateid;
	}
	public void setSubplateid(int subplateid) {
		this.subplateid = subplateid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getHighlight() {
		return highlight;
	}
	public void setHighlight(long highlight) {
		this.highlight = highlight;
	}
	public String getHighlightState() {
		return highlightState;
	}
	public void setHighlightState(String highlightState) {
		this.highlightState = highlightState;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}	
}
