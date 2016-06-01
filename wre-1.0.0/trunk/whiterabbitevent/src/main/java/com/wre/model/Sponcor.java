 package com.wre.model;
// Generated Apr 27, 2016 3:07:21 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Sponcor generated by hbm2java
 */
@Entity
@Table(name="sponcor"
    ,catalog="wre_dev"
)
public class Sponcor  implements java.io.Serializable {


     private Long sponcorId;
     private Event event;
     private String sponcorDesc;
     private String sponcorName;
     private String fileName;

    public Sponcor() {
    }

    public Sponcor(Event event, String sponcorDesc, String sponcorName, String fileName) {
       this.event = event;
       this.sponcorDesc = sponcorDesc;
       this.sponcorName = sponcorName;
       this.fileName=fileName;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Sponcor_ID", unique=true, nullable=false)
    public Long getSponcorId() {
        return this.sponcorId;
    }
    
    public void setSponcorId(Long sponcorId) {
        this.sponcorId = sponcorId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Event_ID")
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }

    
    @Column(name="Sponcor_Desc", length=65535)
    public String getSponcorDesc() {
        return this.sponcorDesc;
    }
    
    public void setSponcorDesc(String sponcorDesc) {
        this.sponcorDesc = sponcorDesc;
    }

    
    @Column(name="Sponcor_Name", length=100)
    public String getSponcorName() {
        return this.sponcorName;
    }
    
    public void setSponcorName(String sponcorName) {
        this.sponcorName = sponcorName;
    }



    @Column(name="FileName", length=200)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



}


