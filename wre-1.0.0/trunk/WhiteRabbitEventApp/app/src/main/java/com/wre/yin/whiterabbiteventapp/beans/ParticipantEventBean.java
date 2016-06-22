package com.wre.yin.whiterabbiteventapp.beans;

import java.util.Date;

/**
 * Created by root on 3/6/16.
 */
public class ParticipantEventBean {
    private Long participateEventId;
    private String status;
    private Long eventId;
    private Long participantId;
    private String eventname;
    private Date eventDate;
    private String firstName;
    private String lastName;
    private String mobile;
    private String emailId;

    public Long getParticipateEventId() {
        return participateEventId;
    }

    public void setParticipateEventId(Long participateEventId) {
        this.participateEventId = participateEventId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
