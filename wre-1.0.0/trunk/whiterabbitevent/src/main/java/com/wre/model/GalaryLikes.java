package com.wre.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wre.common.util.WREConstants;

/**
 * GalaryLikes generated by hbm2java
 */
@Entity
@Table(name="galary_likes"
    ,catalog=WREConstants.CATALOG
)
public class GalaryLikes  implements java.io.Serializable {


     private Long galaryLikeId;
     private Galary galary;
     private Participants participants;
     private String status;

    public GalaryLikes() {
    }

    public GalaryLikes(Galary galary, Participants participants, String status) {
       this.galary = galary;
       this.participants = participants;
       this.status = status;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
        @Column(name="Galary_LikeID", unique=true, nullable=false)
         public Long getGalaryLikeId() {
        return this.galaryLikeId;
    }
    
    public void setGalaryLikeId(Long galaryLikeId) {
        this.galaryLikeId = galaryLikeId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Galary_Item_ID")
    public Galary getGalary() {
        return this.galary;
    }
    
    public void setGalary(Galary galary) {
        this.galary = galary;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Paticipant_ID")
    public Participants getParticipants() {
        return this.participants;
    }
    
    public void setParticipants(Participants participants) {
        this.participants = participants;
    }

    
  
    @Column(name="Status", length=30)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}