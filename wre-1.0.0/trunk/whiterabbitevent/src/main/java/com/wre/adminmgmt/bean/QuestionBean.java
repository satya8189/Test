package com.wre.adminmgmt.bean;

import java.util.List;


public class QuestionBean 
{

    private Long questionId;
    private Long appIdentifierId;
    private Long eventId;
    private Long  userId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String appIdentifierName;
    private Long participantId ;
	private List<QuestionAnswerBean> qAList;
    
	public String getAppIdentifierName() {
		return appIdentifierName;
	}
	public void setAppIdentifierName(String appIdentifierName) {
		this.appIdentifierName = appIdentifierName;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getAppIdentifierId() {
		return appIdentifierId;
	}
	public void setAppIdentifierId(Long appIdentifierId) {
		this.appIdentifierId = appIdentifierId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Long getParticipantId() {
		return participantId;
	}
	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}
	public List<QuestionAnswerBean> getqAList() {
		return qAList;
	}
	public void setqAList(List<QuestionAnswerBean> qAList) {
		this.qAList = qAList;
	}
	@Override
	public String toString() {
		return "QuestionBean [questionId=" + questionId + ", appIdentifierId="
				+ appIdentifierId + ", eventId=" + eventId + ", userId="
				+ userId + ", question=" + question + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", answer=" + answer
				+ ", appIdentifierName=" + appIdentifierName
				+ ", participantId=" + participantId + ", qAList=" + qAList
				+ "]";
	}
	
	
}
