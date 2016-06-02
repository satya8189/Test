package com.wre.adminmgmt.bean;

import org.springframework.web.multipart.MultipartFile;

import com.wre.model.Event;

public class SpeakerBean {
	
	private Long speakerId;
    private Long eventId;
    private String eventName;
    private String speakerName;
    private String location;
    private String title;
    private String description;
    private String rating;
    private String type;
   private String fileName;

    
	public Long getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDesc(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
