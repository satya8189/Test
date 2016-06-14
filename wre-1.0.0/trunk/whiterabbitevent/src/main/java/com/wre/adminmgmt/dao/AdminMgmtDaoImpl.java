package com.wre.adminmgmt.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wre.adminmgmt.bean.RatingBean;
import com.wre.common.dao.GenericDaoImpl;
import com.wre.model.Agenda;
import com.wre.model.AppIdentifier;
import com.wre.model.ChatTopic;
import com.wre.model.ContactDetails;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Galary;
import com.wre.model.Newsfeed;
import com.wre.model.Participants;
import com.wre.model.Rating;
import com.wre.model.SocialMedia;
import com.wre.model.Speaker;
import com.wre.model.Sponcor;
import com.wre.model.SurveyQuestion;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.ParticipantEventBean;




@Repository("AdminMgmtDao")
public class AdminMgmtDaoImpl extends GenericDaoImpl<Object> implements
AdminMgmtDao {
	
	private static final Log log = LogFactory
			.getLog(AdminMgmtDaoImpl.class);

	
//eventList
	public List<Event> getEventList(Long userId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Event.class);
		criteria.add(Restrictions.eq("user.userId",userId));
		criteria.setFetchMode("user", FetchMode.EAGER);
			List<Event> eventList=criteria.list();
			 return eventList;
	}



//eventServicesList
	public List<EventServices> getEventDetails(Long eventId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(EventServices.class);
		criteria.add(Restrictions.eq("event.eventId",eventId));
		criteria.setFetchMode("event", FetchMode.EAGER);
		criteria.setFetchMode("services", FetchMode.EAGER);
		List<EventServices> eventServicesList=criteria.list();
		 return eventServicesList;
	}

//event agendaList
	public List<Agenda> getAgendoDetails(Long eventId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Agenda.class);
		criteria.add(Restrictions.eq("event.eventId",eventId));
		criteria.setFetchMode("event", FetchMode.EAGER);
		List<Agenda> agendaList=criteria.list();
		return agendaList;
	}

//agendoEditDetails
	public Agenda agendoEditDetails(Long agenId) {
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Agenda.class);
		criteria.add(Restrictions.eq("agenId",agenId));
		criteria.setFetchMode("event", FetchMode.EAGER);
		Agenda a= (Agenda)criteria.uniqueResult();
		log.info("value--"+a.getAgenDesc());
		return a;
	}


//newsList
public List<Newsfeed> getNewsList(Long eventId) {
Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Newsfeed.class);
criteria.add(Restrictions.eq("event.eventId", eventId));
criteria.setFetchMode("event", FetchMode.EAGER);
List<Newsfeed> newsList=criteria.list();
return newsList;
	}


//newsEdit
public Newsfeed newsEditDetails(Long newsFeedId) {
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Newsfeed.class);
	criteria.add(Restrictions.eq("newsFeedId",newsFeedId));
	criteria.setFetchMode("event", FetchMode.EAGER);
	return (Newsfeed)criteria.uniqueResult();

	
}

//galaryList

@Override
public List<Galary> galaryList(Long eventId,String type) {
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Galary.class);
	criteria.add(Restrictions.eq("event.eventId",eventId));
	criteria.add(Restrictions.eq("type",type));
	criteria.setFetchMode("event", FetchMode.EAGER);
	List<Galary>galaryList=criteria.list();
	return galaryList;
}



@Override
public Event detailsView(Long eventId) {
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Event.class);
    criteria.add(Restrictions.eq("eventId",eventId));
	criteria.setFetchMode("event", FetchMode.EAGER);
	return (Event)criteria.uniqueResult();
	
	 
	
	
}



public Long checkMobileNumber(String number) {
	Long ParticipantId;
	
Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Participants.class);
criteria.add(Restrictions.eq("phone",number));
Participants participants=(Participants)criteria.uniqueResult();

	if(participants!=null){
		ParticipantId=participants.getParticipantId();
		
	}else
	{
		Participants	participantsOject=new Participants();
		participantsOject.setPhone(number);
		participantsOject.setOtp("welcome");
		sessionFactory.getCurrentSession().save(participantsOject);
		ParticipantId= participantsOject.getParticipantId();
		
	}
return ParticipantId;
}


/*public List<Object[]> getOrgList() {
	String query = "select o.Org_ID,o.Org_Name,o.PC_First_Name,o.PC_Last_Name,o.Created_Date,u.First_Name,coalesce(oc.Count, 0) as practices "
			+ " from organization o  join user u on o.Created_By=u.User_ID left join "
			+ "(select Org_ID,count(*) as Count from practice  group by Org_ID ) oc on o.Org_ID = oc.Org_ID group by o.Org_ID ORDER BY o.Created_Date DESC";
	SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(
			query);
	List<Object[]> orgList = (List<Object[]>) sqlQuery.list();
	return orgList;
}*/


//inviteList
public List<Object[]> inviteDetails(Long eventId) {
	
	String query = "SELECT p.Participant_ID,p.FirstName,p.Last_Name,p.Phone,p.Status,p.Email FROM participants p LEFT JOIN event_participant ep ON ep.Participant_ID=p.Participant_ID"
			+ " WHERE ep.Event_ID= :evtId";
	SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(
			query);
	sqlQuery.setParameter("evtId", eventId);
	return (List<Object[]>) sqlQuery.list();
}
//surveyList

public List<SurveyQuestion> questionList(Long eventId) {
	
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SurveyQuestion.class);
	criteria.add(Restrictions.eq("event.eventId", eventId));
	criteria.setFetchMode("event", FetchMode.EAGER);
	criteria.setFetchMode("appIdentifier", FetchMode.EAGER);
	List<SurveyQuestion> surveyList=criteria.list();
	return surveyList;
	

}



@Override
public List<AppIdentifier> appList(Long appId) {
	
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(AppIdentifier.class);
	criteria.add(Restrictions.eq("appIdentifierGrp.appIdentifierGrpId", appId));
	criteria.setFetchMode("appIdentifierGrp", FetchMode.EAGER);
	List<AppIdentifier> appIdentifierBeanList=criteria.list();
	return appIdentifierBeanList;

}



@Override
public SurveyQuestion questionEdit(Long questionId) {
	
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SurveyQuestion.class);
	criteria.add(Restrictions.eq("questionId",questionId));
	criteria.setFetchMode("event", FetchMode.EAGER);
	criteria.setFetchMode("appIdentifier", FetchMode.EAGER);
   return (SurveyQuestion)criteria.uniqueResult();

	
}


//to get the sponsorsList by passing the event Id

@Override
public List<Sponcor> getSponcorsList(Long eventId)
{
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Sponcor.class);
	criteria.setFetchMode("event",FetchMode.EAGER);
	criteria.add(Restrictions.eq("event.eventId",eventId)); //eventId
	List<Sponcor> spList=criteria.list();
	log.info("in getSponcorsList--daoImpl----"+spList.size());
	return spList;
}



@Override
public Sponcor getSponsorBySponsorId(Long sponcorId) {
	// TODO Auto-generated method stub
	
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Sponcor.class);
    criteria.add(Restrictions.eq("sponcorId",sponcorId));
	criteria.setFetchMode("sponcor", FetchMode.EAGER);
  return (Sponcor) criteria.uniqueResult();
	
	//return null;
}



@Override
public List<Speaker> getSpeakersList(Long eventId) {
	// TODO Auto-generated method stub
	Criteria c=sessionFactory.getCurrentSession().createCriteria(Speaker.class);
	c.add(Restrictions.eq("event.eventId",eventId));
	c.setFetchMode("speaker",FetchMode.EAGER);
	List<Speaker> speakers=c.list();
	return speakers;
}



@Override
public Speaker getSpeakerBySpeakerId(Long speakerId) {
	// TODO Auto-generated method stub
	Criteria c=sessionFactory.getCurrentSession().createCriteria(Speaker.class);
	c.add(Restrictions.eq("speakerId",speakerId));
	c.setFetchMode("speaker",FetchMode.EAGER);
	
	return (Speaker)c.uniqueResult();
}



@Override
public List<Participants> getUser(String mobno) {

Criteria c=sessionFactory.getCurrentSession().createCriteria(Participants.class);
c.add(Restrictions.ne("phone",mobno));
return (List<Participants>)c.list();

}

public String participantRegUpdate(ParticipantBean participantBean){
	String query = "Update participants set Reg_ID=:regId where Phone=:phone";
		
	SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(
			query);
	sqlQuery.setParameter("regId", participantBean.getRegisterId());
	sqlQuery.setParameter("phone", participantBean.getPhoneNumber());
	sqlQuery.executeUpdate();
	return "sucsess";
		
}
//Services
@Override
public List<EventServices> geteventServicesList(Long eventId) {
	

		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(EventServices.class);
		
		criteria.setFetchMode("event", FetchMode.EAGER);
		criteria.setFetchMode("services", FetchMode.EAGER);
		criteria.add(Restrictions.eq("event.eventId",eventId));
		criteria.add(Restrictions.ne("services.serviceId",new Long(18)));
		//criteria.addOrder(Order.asc("services.order"));
		
		List<EventServices> eventServicesList=criteria.list();
		 return eventServicesList;
	
}

@Override
public List<Rating> getUserRatingList(RatingBean ratingBean) {

Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Rating.class);
//criteria.add(Restrictions.ne("phone",mobno));
return (List<Rating>)criteria.list();
}



@Override
public List<Rating> getUserRatingList(Long eventId) {
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Rating.class);
	criteria.add(Restrictions.eq("eventId", eventId));
	return (List<Rating>)criteria.list();
}

//===============Help-Contact

@Override
public List<ContactDetails> adminViewContactDetails(Long eventId) {
	log.info("adminViewContactDetails daoImpl.."+eventId);
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ContactDetails.class);
	criteria.setFetchMode("event",FetchMode.EAGER);
	criteria.add(Restrictions.eq("event.eventId", eventId));
	return (List<ContactDetails>)criteria.list();
	}


@Override
//public List<ContactDetails> getContactDetailsForEdit(Long contactId) {
public ContactDetails getContactDetailsForEdit(Long contactId) {
	log.info("admingetContactDetailsForEdit daoImpl.."+contactId);
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ContactDetails.class);
	criteria.add(Restrictions.eq("contactId", contactId));
	//return (List<ContactDetails>)criteria.list();
	return (ContactDetails)criteria.uniqueResult();
}

@Override
public List<ChatTopic> getChatTopicList(Long eventId) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ChatTopic.class);
	criteria.add(Restrictions.eq("event.eventId", eventId));
	criteria.setFetchMode("event", FetchMode.EAGER);
	return (List<ChatTopic>)criteria.list();
}



//chat topic Details
@Override
public ChatTopic getChatTopicDetails(Long chatTopicId) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ChatTopic.class);
	criteria.add(Restrictions.eq("topicId", chatTopicId));
	criteria.setFetchMode("event", FetchMode.EAGER);
	return (ChatTopic)criteria.uniqueResult();
}

public List<Object[]>  getParticipantEventBeanList(Long eventId,String status) {
	String query = 
	"SELECT e.Event_ID,e.Event_Name,p.FirstName,p.Last_Name,p.Phone,p.Email,ep.Status,p.Participant_ID,ep.Eve_Participant_ID  FROM event_participant ep"
			+ " LEFT JOIN  wre_dev.event e ON e.Event_ID=ep.Event_ID "
			+ " LEFT JOIN participants p ON p.Participant_ID=ep.Participant_ID WHERE ep.Event_ID=:id";

	SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(
			query);
	sqlQuery.setParameter("id", eventId);
	List<Object[]> eventParticipantList = (List<Object[]>) sqlQuery.list();
	return eventParticipantList;
	
}

public void eventParticipantSave(
		ParticipantEventBean participantEventBean) {
	String query = 
			"Update event_participant set Status=:status WHERE Event_ID=:eid and Participant_ID=:pid";

			SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(
					query);
			sqlQuery.setParameter("status", participantEventBean.getStatus());
			sqlQuery.setParameter("eid", participantEventBean.getEventId());
			sqlQuery.setParameter("pid", participantEventBean.getParticipateId());
			sqlQuery.executeUpdate();

}

@Override
public List<Object[]> getParticipantsList(Long eventId){
	log.info("in getParticipantsList...DAOImpl");
	/*Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Participants.class);
	criteria.add(Restrictions.eq("event_participant.eventId", eventId));
	*/
	String sql="select p.participant_Id,p.firstname,p.email from participants p,event_participant ep where p.participant_id=ep.Participant_ID and ep.Event_ID= :eventId";
	SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
    	query.setParameter("eventId",eventId);
    	//query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	
    return (List<Object[]>)query.list();
}

		@Override
		public List<Object[]> getParticipantsAnswersList(Long eventId,Long participantId){
			log.info("in getParticipantsAnswersList...DAOImpl");
			
			String sql="select sq.Question,sq.Answer,sqa.Participant_Answer from survey_question sq,survey_question_answer sqa where sqa.Participant_id= :participantId and sqa.Event_ID= :eventId and sqa.Question_ID=sq.Question_ID;";
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		    	query.setParameter("participantId",participantId);
		    	query.setParameter("eventId",eventId);
		    	//query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		    	return (List<Object[]>)query.list();
		}



		@Override
		public List<SocialMedia> getSocialMediaList(Long eventId) {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SocialMedia.class);
			criteria.add(Restrictions.eq("event.eventId",eventId));
			return (List<SocialMedia>)criteria.list();
		}



		@Override
		public SocialMedia getSocialMediaForEdit(Long socialId) {
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SocialMedia.class);
			criteria.add(Restrictions.eq("socialId",socialId));
			return (SocialMedia)criteria.uniqueResult();
		}


}












	
	 



	

	



