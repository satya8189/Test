package com.wre.adminmgmt.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wre.common.dao.GenericDaoImpl;
import com.wre.model.Agenda;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Galary;
import com.wre.model.Newsfeed;
import com.wre.model.Participants;




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
	public List<EventServices> getEventDetails(String eventId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(EventServices.class);
		
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
}
















	
	 



	

	



