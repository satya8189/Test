package com.wre.model;

//Generated 16 Jun, 2016 12:13:43 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wre.common.util.WREConstants;

/**
* Participants generated by hbm2java
*/
@Entity
@Table(name="participants",catalog=WREConstants.CATALOG)
public class Participants  implements java.io.Serializable {


  private Long participantId;
  private String email;
  private String firstName;
  private String lastName;
  private String otp;
  private String phone;
  private String status;
  private String regId;
  private String profilePic;
  private String designation;
  private String company;
  private Set<Galary> galaries = new HashSet<Galary>(0);
  private Set<EventParticipant> eventParticipants = new HashSet<EventParticipant>(0);
  private Set<SurveyQuestionAnswer> surveyQuestionAnswers = new HashSet<SurveyQuestionAnswer>(0);
  private Set<ContactDetails> contactDetailses = new HashSet<ContactDetails>(0);
  private Set<QuestionAnswer> questionAnswers = new HashSet<QuestionAnswer>(0);
  private Set<Message> messages = new HashSet<Message>(0);
  private Set<Help> helps = new HashSet(0);
  private Set<ParticipantQuries> participantQurieses = new HashSet(0);

 public Participants() {
 }

 public Participants(String email, String firstName, String lastName, String otp, String phone, String status, String regId,String profilePic,String designation,String company, Set<Galary> galaries, Set<EventParticipant> eventParticipants, Set<SurveyQuestionAnswer> surveyQuestionAnswers, Set<ContactDetails> contactDetailses, Set<QuestionAnswer> questionAnswers, Set<Message> messages,Set<Help> helps,Set<ParticipantQuries> participantQurieses ) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.otp = otp;
    this.phone = phone;
    this.status = status;
    this.regId = regId;
    this.profilePic=profilePic;
    this.designation=designation;
    this.company=company;
    this.galaries = galaries;
    this.eventParticipants = eventParticipants;
    this.surveyQuestionAnswers = surveyQuestionAnswers;
    this.contactDetailses = contactDetailses;
    this.questionAnswers = questionAnswers;
    this.messages = messages;
    this.helps=helps;
    this.participantQurieses=participantQurieses;
 }

  @Id @GeneratedValue(strategy=IDENTITY)

 
 @Column(name="Participant_ID", unique=true, nullable=false)
 public Long getParticipantId() {
     return this.participantId;
 }
 
 public void setParticipantId(Long participantId) {
     this.participantId = participantId;
 }

 
 @Column(name="Email", length=100)
 public String getEmail() {
     return this.email;
 }
 
 public void setEmail(String email) {
     this.email = email;
 }

 
 @Column(name="FirstName", length=100)
 public String getFirstName() {
     return this.firstName;
 }
 
 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 
 @Column(name="Last_Name", length=100)
 public String getLastName() {
     return this.lastName;
 }
 
 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 
 @Column(name="OTP", length=20)
 public String getOtp() {
     return this.otp;
 }
 
 public void setOtp(String otp) {
     this.otp = otp;
 }

 
 @Column(name="Phone", length=20)
 public String getPhone() {
     return this.phone;
 }
 
 public void setPhone(String phone) {
     this.phone = phone;
 }

 
 @Column(name="Status", length=20)
 public String getStatus() {
     return this.status;
 }
 
 public void setStatus(String status) {
     this.status = status;
 }

 
 @Column(name="Reg_ID", length=65535)
 public String getRegId() {
     return this.regId;
 }
 
 public void setRegId(String regId) {
     this.regId = regId;
 }
 
 @Column(name="Profile_Pic", length=50)
public String getProfilePic() {
	return profilePic;
}

public void setProfilePic(String profilePic) {
	this.profilePic = profilePic;
}

@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
 public Set<Galary> getGalaries() {
     return this.galaries;
 }
 
 public void setGalaries(Set<Galary> galaries) {
     this.galaries = galaries;
 }

@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
 public Set<EventParticipant> getEventParticipants() {
     return this.eventParticipants;
 }
 
 public void setEventParticipants(Set<EventParticipant> eventParticipants) {
     this.eventParticipants = eventParticipants;
 }

@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
 public Set<SurveyQuestionAnswer> getSurveyQuestionAnswers() {
     return this.surveyQuestionAnswers;
 }
 
 public void setSurveyQuestionAnswers(Set<SurveyQuestionAnswer> surveyQuestionAnswers) {
     this.surveyQuestionAnswers = surveyQuestionAnswers;
 }

@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
 public Set<ContactDetails> getContactDetailses() {
     return this.contactDetailses;
 }
 
 public void setContactDetailses(Set<ContactDetails> contactDetailses) {
     this.contactDetailses = contactDetailses;
 }

@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
 public Set<QuestionAnswer> getQuestionAnswers() {
     return this.questionAnswers;
 }
 
 public void setQuestionAnswers(Set<QuestionAnswer> questionAnswers) {
     this.questionAnswers = questionAnswers;
 }

@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
 public Set<Message> getMessages() {
     return this.messages;
 }
 
 public void setMessages(Set<Message> messages) {
     this.messages = messages;
 }
 @Column(name="Designation", length=100)
public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}
@Column(name="Company", length=200)
public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}
 
@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
public Set<Help> getHelps() {
    return this.helps;
}

public void setHelps(Set<Help> helps) {
    this.helps = helps;
}

@OneToMany(fetch=FetchType.LAZY, mappedBy="participants")
    public Set<ParticipantQuries> getParticipantQurieses() {
        return this.participantQurieses;
    }
    
    public void setParticipantQurieses(Set<ParticipantQuries> participantQurieses) {
        this.participantQurieses = participantQurieses;
    }


}