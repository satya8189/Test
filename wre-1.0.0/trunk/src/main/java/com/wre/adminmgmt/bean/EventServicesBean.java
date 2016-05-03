package com.wre.adminmgmt.bean;

import com.wre.model.Event;
import com.wre.model.Services;

public class EventServicesBean
{
	 private Long eventServiceId;
     private Event event;
     private Services services;
     private String status;
     
     
	public Long getEventServiceId() {
		return eventServiceId;
	}
	public void setEventServiceId(Long eventServiceId) {
		this.eventServiceId = eventServiceId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
     
     

}
