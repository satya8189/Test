package com.wre.adminmgmt.bean;

import java.util.Date;

import com.wre.model.Event;

public class NewsFeedBean {
	
	 private Long newsFeedId;
     private Event event;
     private String newsTitle;
     private String newsDesc;
     private Date newsDate;
	public Long getNewsFeedId() {
		return newsFeedId;
	}
	public void setNewsFeedId(Long newsFeedId) {
		this.newsFeedId = newsFeedId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsDesc() {
		return newsDesc;
	}
	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
     
     

}
