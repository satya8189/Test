package com.wre.systemadminmgmt.bean;

import java.util.Date;

public class ParticipantEventBean {
	private Long participateEventId ;
	private String status ;
	private Long eventId;
	private Long participateId;
	private String eventname ;
	private Date eventDate;
	private String firstName;
	private String lostName;
	private String mobile;
	private String emailId;
	
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLostName() {
		return lostName;
	}
	public void setLostName(String lostName) {
		this.lostName = lostName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
	

}
