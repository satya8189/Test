package com.wre.adminmgmt.bean;

import java.util.Date;

import com.wre.model.Client;
import com.wre.model.User;

public class EventBean 
{
	private Long eventId;
    private Client client;
    private User user;
    private String eventName;
    private String eventDesc;
    private String eventAgenda;
    private Date eventDate;
    private String eventTime;
    private String eventAddress;
    private String status;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getEventAgenda() {
		return eventAgenda;
	}
	public void setEventAgenda(String eventAgenda) {
		this.eventAgenda = eventAgenda;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventAddress() {
		return eventAddress;
	}
	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
    

}
