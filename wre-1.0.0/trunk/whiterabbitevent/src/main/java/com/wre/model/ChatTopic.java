package com.wre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wre.common.util.WREConstants;

/**
 * ChatTopic generated by hbm2java
 */
@Entity
@Table(name="chat_topic",catalog=WREConstants.CATALOG)
public class ChatTopic  implements java.io.Serializable {


     private long topicId;
     private Event event;
     private String topic;

    public ChatTopic() {
    }

	
    public ChatTopic(long topicId) {
        this.topicId = topicId;
    }
    public ChatTopic(long topicId, Event event, String topic) {
       this.topicId = topicId;
       this.event = event;
       this.topic = topic;
    }
   
     @Id 

    
    @Column(name="Topic_ID", unique=true, nullable=false)
    public long getTopicId() {
        return this.topicId;
    }
    
    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Event_ID")
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }

    
    @Column(name="Topic", length=65535)
    public String getTopic() {
        return this.topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }




}