package com.wre.yin.whiterabbiteventapp.beans;

/**
 * Created by root on 28/6/16.
 */
public class ChatTopicBean {
    private Long chatTopicId;
    private String chatTopicName;
    private Long eventId;

    public Long getChatTopicId() {
        return chatTopicId;
    }

    public void setChatTopicId(Long chatTopicId) {
        this.chatTopicId = chatTopicId;
    }

    public String getChatTopicName() {
        return chatTopicName;
    }

    public void setChatTopicName(String chatTopicName) {
        this.chatTopicName = chatTopicName;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
