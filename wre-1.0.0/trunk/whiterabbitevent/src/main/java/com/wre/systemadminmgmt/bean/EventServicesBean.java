package com.wre.systemadminmgmt.bean;

public class EventServicesBean {
	
	private Long eventServiceId ;
	private String status;
	private Long eventId;
	private Long serviceId;
	private String serviceName;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Long getEventServiceId() {
		return eventServiceId;
	}
	public void setEventServiceId(Long eventServiceId) {
		this.eventServiceId = eventServiceId;
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
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	

}
