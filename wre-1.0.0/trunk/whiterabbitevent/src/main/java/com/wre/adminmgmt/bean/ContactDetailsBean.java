package com.wre.adminmgmt.bean;

import com.wre.model.Event;

public class ContactDetailsBean {

	  private long contactId;
	  private long eventId;
	  private String contactName;
	  private String contactEmail;
	  private String contactMobile;
	  private String contactAlternateMobile;
	  
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getContactAlternateMobile() {
		return contactAlternateMobile;
	}
	public void setContactAlternateMobile(String contactAlternateMobile) {
		this.contactAlternateMobile = contactAlternateMobile;
	}
	
	@Override
	public String toString() {
		return "ContactDetailsBean [contactId=" + contactId + ", eventId="
				+ eventId + ", contactName=" + contactName + ", contactEmail="
				+ contactEmail + ", contactMobile=" + contactMobile
				+ ", contactAlternateMobile=" + contactAlternateMobile + "]";
	}
	
}
