package com.wre.systemadminmgmt.bean;

public class ParticipantEventBean {
	private Long participateEventId ;
	private String status ;
	private Long eventId;
	private Long participateId;
	private String eventname ;
	
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public Long getParticipateEventId() {
		return participateEventId;
	}
	public void setParticipateEventId(Long participateEventId) {
		this.participateEventId = participateEventId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getParticipateId() {
		return participateId;
	}
	public void setParticipateId(Long participateId) {
		this.participateId = participateId;
	}
	
	

}
