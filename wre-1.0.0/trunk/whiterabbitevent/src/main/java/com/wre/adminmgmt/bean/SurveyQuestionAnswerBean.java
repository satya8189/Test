package com.wre.adminmgmt.bean;

import com.wre.model.Event;
import com.wre.model.Participants;
import com.wre.model.SurveyQuestion;

public class SurveyQuestionAnswerBean {

	private Long surQueAnsId;
    private Event event;
    private Participants participants;
    private SurveyQuestion surveyQuestion;
    
    private String question;
    
	private String answer;
    
    private String participantAnswer;
	public Long getSurQueAnsId() {
		return surQueAnsId;
	}
	public void setSurQueAnsId(Long surQueAnsId) {
		this.surQueAnsId = surQueAnsId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Participants getParticipants() {
		return participants;
	}
	public void setParticipants(Participants participants) {
		this.participants = participants;
	}
	public SurveyQuestion getSurveyQuestion() {
		return surveyQuestion;
	}
	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getParticipantAnswer() {
		return participantAnswer;
	}
	public void setParticipantAnswer(String participantAnswer) {
		this.participantAnswer = participantAnswer;
	}
    
    
}
