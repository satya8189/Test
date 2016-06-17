package com.wre.adminmgmt.bean;

import com.wre.model.Event;

public class SocialMediaBean {

	  private Long socialId;
	  private String name;
	  private String url;
	  private Long eventId;
	  private String type;
	  
    public Long getSocialId() {
		return socialId;
	}
	public void setSocialId(Long socialId) {
		this.socialId = socialId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SocialMediaBean [socialId=" + socialId + ", name=" + name
				+ ", url=" + url + ", eventId=" + eventId + ", type=" + type
				+ "]";
	}
	
	
}
