package com.wre.adminmgmt.bean;

public class SponsorBean {
		
	private Long sponcorId;
    private Long eventId;
    private String eventName;
    private String sponcorDesc;
    private String sponcorName;
    private String fileName;
    private String url;
	public Long getSponcorId() {
		return sponcorId;
	}
	public void setSponcorId(Long sponcorId) {
		this.sponcorId = sponcorId;
	}
	public String getSponcorDesc() {
		return sponcorDesc;
	}
	public void setSponcorDesc(String sponcorDesc) {
		this.sponcorDesc = sponcorDesc;
	}
	public String getSponcorName() {
		return sponcorName;
	}
	public void setSponcorName(String sponcorName) {
		this.sponcorName = sponcorName;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "SponsorBean [sponcorId=" + sponcorId + ", eventId=" + eventId
				+ ", eventName=" + eventName + ", sponcorDesc=" + sponcorDesc
				+ ", sponcorName=" + sponcorName + ", fileName=" + fileName
				+ ", url=" + url + "]";
	}
	
}
