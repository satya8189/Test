package com.wre.adminmgmt.bean;

public class QuestionAnswerBean {

	private Long qId;
    private String answer;
	
    
	public Long getqId() {
		return qId;
	}
	public void setqId(Long qId) {
		this.qId = qId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "QuestionAnswerBean [qId=" + qId + ", answer=" + answer + "]";
	}
	
       
}
