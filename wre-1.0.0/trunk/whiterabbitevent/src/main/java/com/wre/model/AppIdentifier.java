package com.wre.model;
// Generated Apr 27, 2016 3:07:21 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wre.common.util.WREConstants;

/**
 * AppIdentifier generated by hbm2java
 */
@Entity
@Table(name="app_identifier"
    ,catalog=WREConstants.CATALOG
)
public class AppIdentifier  implements java.io.Serializable {


     private Long appIdentifierId;
     private AppIdentifierGrp appIdentifierGrp;
     private String identifierName;
     private String identifierDesc;
     private Integer appIdentifierOrder;
     private Date createdOn;
     private Date updatedOn;
     private Set<SurveyQuestion> surveyQuestions = new HashSet(0);
     private Set<User> users = new HashSet(0);

    public AppIdentifier() {
    }

    public AppIdentifier(AppIdentifierGrp appIdentifierGrp, String identifierName, String identifierDesc, Integer appIdentifierOrder, Date createdOn, Date updatedOn, Set<SurveyQuestion> surveyQuestions, Set<User> users) {
       this.appIdentifierGrp = appIdentifierGrp;
       this.identifierName = identifierName;
       this.identifierDesc = identifierDesc;
       this.appIdentifierOrder = appIdentifierOrder;
       this.createdOn = createdOn;
       this.updatedOn = updatedOn;
       this.surveyQuestions = surveyQuestions;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="AppIdentifier_ID", unique=true, nullable=false)
    public Long getAppIdentifierId() {
        return this.appIdentifierId;
    }
    
    public void setAppIdentifierId(Long appIdentifierId) {
        this.appIdentifierId = appIdentifierId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    //@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)//changed
    @JoinColumn(name="AppIdentifier_Grp_ID")
    public AppIdentifierGrp getAppIdentifierGrp() {
        return this.appIdentifierGrp;
    }
    
    public void setAppIdentifierGrp(AppIdentifierGrp appIdentifierGrp) {
        this.appIdentifierGrp = appIdentifierGrp;
    }

    
    @Column(name="Identifier_Name", length=100)
    public String getIdentifierName() {
        return this.identifierName;
    }
    
    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    
    @Column(name="Identifier_Desc", length=100)
    public String getIdentifierDesc() {
        return this.identifierDesc;
    }
    
    public void setIdentifierDesc(String identifierDesc) {
        this.identifierDesc = identifierDesc;
    }

    
    @Column(name="AppIdentifier_Order")
    public Integer getAppIdentifierOrder() {
        return this.appIdentifierOrder;
    }
    
    public void setAppIdentifierOrder(Integer appIdentifierOrder) {
        this.appIdentifierOrder = appIdentifierOrder;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Created_On", length=19)
    public Date getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Updated_On", length=19)
    public Date getUpdatedOn() {
        return this.updatedOn;
    }
    
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="appIdentifier")
    //@OneToMany(fetch=FetchType.LAZY, mappedBy="appIdentifier",cascade = CascadeType.ALL)
    public Set<SurveyQuestion> getSurveyQuestions() {
        return this.surveyQuestions;
    }
    
    public void setSurveyQuestions(Set<SurveyQuestion> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="appIdentifier")
    //@OneToMany(fetch=FetchType.LAZY, mappedBy="appIdentifier",cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }

}


