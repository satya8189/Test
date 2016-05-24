package com.wre.adminmgmt.bean;

public class SponsorBean {
		
	private Long sponcorId;
    private Long eventId;
    private String eventName;
    private String sponcorDesc;
    private String sponcorName;
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
	@Override
	public String toString() {
		return "SponsorBean [sponcorId=" + sponcorId + ", eventId=" + eventId
				+ ",Event name="+ eventName +", sponcorDesc=" + sponcorDesc + ", sponcorName="
				+ sponcorName + "]";
	}
    
}
