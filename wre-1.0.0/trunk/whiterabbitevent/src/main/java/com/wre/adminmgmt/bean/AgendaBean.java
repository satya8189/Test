package com.wre.adminmgmt.bean;


public class AgendaBean 
{

    private Long agenId;
    
    private String agenTitle;
    private String agenDesc;
    private String agenEndTime;
    private String agenStartTime;
    private String agenBy;
    private Long eventId;
    
	
	public Long getAgenId() {
		return agenId;
	}
	public void setAgenId(Long agenId) {
		this.agenId = agenId;
	}
	
	public String getAgenTitle() {
		return agenTitle;
	}
	public void setAgenTitle(String agenTitle) {
		this.agenTitle = agenTitle;
	}
	public String getAgenDesc() {
		return agenDesc;
	}
	public void setAgenDesc(String agenDesc) {
		this.agenDesc = agenDesc;
	}
	public String getAgenStartTime() {
		return agenStartTime;
	}
	public void setAgenStartTime(String agenStartTime) {
		this.agenStartTime = agenStartTime;
	}
	public String getAgenEndTime() {
		return agenEndTime;
	}
	public void setAgenEndTime(String agenEndTime) {
		this.agenEndTime = agenEndTime;
	}
	public String getAgenBy() {
		return agenBy;
	}
	public void setAgenBy(String agenBy) {
		this.agenBy = agenBy;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
    
    


}
