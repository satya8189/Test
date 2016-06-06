package com.wre.model;

//Generated 6 Jun, 2016 11:27:28 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wre.common.util.WREConstants;

/**
* ContactDetails generated by hbm2java
*/
@Entity
@Table(name="contact_details",catalog=WREConstants.CATALOG)
public class ContactDetails  implements java.io.Serializable {


  private long contactId;
  private Event event;
  private String contactName;
  private String contactEmail;
  private String contactMobile;
  private String contactAlternateMobile;

 public ContactDetails() {
 }

	
 public ContactDetails(long contactId) {
     this.contactId = contactId;
 }
 public ContactDetails(long contactId, Event event, String contactName, String contactEmail, String contactMobile, String contactAlternateMobile) {
    this.contactId = contactId;
    this.event = event;
    this.contactName = contactName;
    this.contactEmail = contactEmail;
    this.contactMobile = contactMobile;
    this.contactAlternateMobile = contactAlternateMobile;
 }

  @Id 

 
 @Column(name="Contact_ID", unique=true, nullable=false)
 public long getContactId() {
     return this.contactId;
 }
 
 public void setContactId(long contactId) {
     this.contactId = contactId;
 }

@ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="Event_ID")
 public Event getEvent() {
     return this.event;
 }
 
 public void setEvent(Event event) {
     this.event = event;
 }

 
 @Column(name="Contact_Name", length=200)
 public String getContactName() {
     return this.contactName;
 }
 
 public void setContactName(String contactName) {
     this.contactName = contactName;
 }

 
 @Column(name="Contact_Email", length=50)
 public String getContactEmail() {
     return this.contactEmail;
 }
 
 public void setContactEmail(String contactEmail) {
     this.contactEmail = contactEmail;
 }

 
 @Column(name="Contact_Mobile", length=20)
 public String getContactMobile() {
     return this.contactMobile;
 }
 
 public void setContactMobile(String contactMobile) {
     this.contactMobile = contactMobile;
 }

 
 @Column(name="Contact_Alternate_Mobile", length=20)
 public String getContactAlternateMobile() {
     return this.contactAlternateMobile;
 }
 
 public void setContactAlternateMobile(String contactAlternateMobile) {
     this.contactAlternateMobile = contactAlternateMobile;
 }
}