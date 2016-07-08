package com.wre.adminmgmt.bean;

import java.util.Date;

public class EventBean 
{
	private Long eventId;
    private Long clientId;
    private Long userId;
    private String userFristName;
    private String userLastName;
    private String userEmail;
    private String phoneNumber;
    private String userName;
    private String eventName;
    private String eventDesc;
    private String eventAgenda;
    private Date eventDate;
    private String eventTime;
    private String eventAddress;
    private String status;
    private Long serviceId;
    private String serviceName;
    private String other;
    private int order;
    private String date;
    private long[] services;
    
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
    
    
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
    
    


	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getUserFristName() {
		return userFristName;
	}
	public void setUserFristName(String userFristName) {
		this.userFristName = userFristName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long[] getServices() {
		return services;
	}
	public void setServices(long[] services) {
		this.services = services;
	}






}
