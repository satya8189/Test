package com.wre.model;

//Generated 13 Jun, 2016 3:48:00 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wre.common.util.WREConstants;

/**
* SocialMedia generated by hbm2java
*/
@Entity
@Table(name="social_media",catalog=WREConstants.CATALOG)
public class SocialMedia  implements java.io.Serializable {


  private Long socialId;
  private Event event;
  private String name;
  private String url;

 public SocialMedia() {
 }

 public SocialMedia(Event event, String name, String url) {
    this.event = event;
    this.name = name;
    this.url = url;
 }

  @Id @GeneratedValue(strategy=IDENTITY)

 
 @Column(name="Social_ID", unique=true, nullable=false)
 public Long getSocialId() {
     return this.socialId;
 }
 
 public void setSocialId(Long socialId) {
     this.socialId = socialId;
 }

@ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="Event_ID")
 public Event getEvent() {
     return this.event;
 }
 
 public void setEvent(Event event) {
     this.event = event;
 }

 
 @Column(name="Name", length=100)
 public String getName() {
     return this.name;
 }
 
 public void setName(String name) {
     this.name = name;
 }

 
 @Column(name="Url", length=65535)
 public String getUrl() {
     return this.url;
 }
 
 public void setUrl(String url) {
     this.url = url;
 }




}
