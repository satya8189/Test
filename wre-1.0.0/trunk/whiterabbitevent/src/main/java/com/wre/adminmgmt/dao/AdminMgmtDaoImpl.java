package com.wre.adminmgmt.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wre.common.dao.GenericDaoImpl;
import com.wre.model.Agenda;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Newsfeed;
import com.wre.model.User;




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






	public Agenda agendoEditDetails(Long agenId) {
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Agenda.class);
		criteria.add(Restrictions.eq("agenId",agenId));
		criteria.setFetchMode("event", FetchMode.EAGER);
		Agenda a= (Agenda)criteria.uniqueResult();
		log.info("value--"+a.getAgenDesc());
		return a;
	}





//newsList
public List<Newsfeed> getNewsList(Long newsFeedId) {
Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Newsfeed.class);
criteria.add(Restrictions.eq("newsFeedId", newsFeedId));
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

















	
	 



	

	


}
