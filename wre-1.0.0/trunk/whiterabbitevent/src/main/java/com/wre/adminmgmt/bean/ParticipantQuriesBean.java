package com.wre.adminmgmt.bean;

public class ParticipantQuriesBean {
	
	private Long participantQueryId;
	private String query;
	private Long eventId;
	private Long participantId;
	private Long speakerId;
	public Long getParticipantQueryId() {
		return participantQueryId;
	}
	public void setParticipantQueryId(Long participantQueryId) {
		this.participantQueryId = participantQueryId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getParticipantId() {
		return participantId;
	}
	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}
	public Long getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}
	
	

}
