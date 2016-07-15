package com.wre.model;
// Generated Apr 27, 2016 3:07:21 PM by Hibernate Tools 4.3.1


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wre.common.util.WREConstants;

/**
 * QuestionAnswer generated by hbm2java
 */
@Entity
@Table(name="question_answer"
    ,catalog=WREConstants.CATALOG
)
public class QuestionAnswer  implements java.io.Serializable {


     private Long queAnsId;
     private Event event;
     private Participants participants;
     private User user;
     private String question;
     private String answer;
     private Integer order;
     private Date questionDate;
     private Date answeredDate;

    public QuestionAnswer() {
    }

    public QuestionAnswer(Event event, Participants participants, User user, String question, String answer, Integer order, Date questionDate, Date answeredDate) {
       this.event = event;
       this.participants = participants;
       this.user = user;
       this.question = question;
       this.answer = answer;
       this.order = order;
       this.questionDate = questionDate;
       this.answeredDate = answeredDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Que_Ans_ID", unique=true, nullable=false)
    public Long getQueAnsId() {
        return this.queAnsId;
    }
    
    public void setQueAnsId(Long queAnsId) {
        this.queAnsId = queAnsId;
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
    @JoinColumn(name="Answered_By")
    public Participants getParticipants() {
        return this.participants;
    }
    
    public void setParticipants(Participants participants) {
        this.participants = participants;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Question_By")
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="Question", length=200)
    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    
    @Column(name="Answer", length=65535)
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    
    @Column(name="Order")
    public Integer getOrder() {
        return this.order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Question_Date", length=19)
    public Date getQuestionDate() {
        return this.questionDate;
    }
    
    public void setQuestionDate(Date questionDate) {
        this.questionDate = questionDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Answered_Date", length=19)
    public Date getAnsweredDate() {
        return this.answeredDate;
    }
    
    public void setAnsweredDate(Date answeredDate) {
        this.answeredDate = answeredDate;
    }




}


