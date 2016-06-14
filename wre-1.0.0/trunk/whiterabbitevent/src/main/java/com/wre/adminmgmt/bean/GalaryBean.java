package com.wre.adminmgmt.bean;

import java.util.Date;

import com.wre.model.Event;
import com.wre.model.Participants;

public class GalaryBean
{

    private Long glaryItemId;
    
    
    private String name;
    private String path;
    private String type;
    private Date createdDate;
    private Long eventId;
    private String url;
    
    
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
	public Long getGlaryItemId()
	{
		return glaryItemId;
	}
	public void setGlaryItemId(Long glaryItemId) {
		this.glaryItemId = glaryItemId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

    

}
