package com.wre.model;

//Generated 16 Jun, 2016 12:13:43 PM by Hibernate Tools 4.3.1


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
* ParticipantQuries generated by hbm2java
*/
@Entity
@Table(name="participant_quries",catalog=WREConstants.CATALOG)
public class ParticipantQuries  implements java.io.Serializable {


  private Long queryId;
  private Event event;
  private Participants participants;
  private Speaker speaker;
  private String query;

 public ParticipantQuries() {
 }

 public ParticipantQuries(Event event, Participants participants, Speaker speaker, String query) {
    this.event = event;
    this.participants = participants;
    this.speaker = speaker;
    this.query = query;
 }

 @Id @GeneratedValue(strategy=IDENTITY)

 @Column(name="Query_ID", unique=true, nullable=false)
 public Long getQueryId() {
     return this.queryId;
 }
 
 public void setQueryId(Long queryId) {
     this.queryId = queryId;
 }

@ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="Event_ID")
 public Event getEvent() {
     return this.event;
 }
 
 public void setEvent(Event event) {
     this.event = event;
 }

@ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="Participant_ID")
 public Participants getParticipants() {
     return this.participants;
 }
 
 public void setParticipants(Participants participants) {
     this.participants = participants;
 }

@ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="Speaker_ID")
 public Speaker getSpeaker() {
     return this.speaker;
 }
 
 public void setSpeaker(Speaker speaker) {
     this.speaker = speaker;
 }

 
 @Column(name="Query", length=65535)
 public String getQuery() {
     return this.query;
 }
 
 public void setQuery(String query) {
     this.query = query;
 }

}