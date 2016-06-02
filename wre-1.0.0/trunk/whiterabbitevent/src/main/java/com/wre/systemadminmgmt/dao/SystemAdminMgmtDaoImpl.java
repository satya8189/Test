package com.wre.systemadminmgmt.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wre.common.dao.GenericDaoImpl;
import com.wre.model.Client;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Participants;
import com.wre.model.Services;
import com.wre.model.User;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.UserBean;


@Repository("systemAdminMgmtDao")
public class SystemAdminMgmtDaoImpl extends GenericDaoImpl<Object> implements
SystemAdminMgmtDao {

private static final Log log = LogFactory
	.getLog(SystemAdminMgmtDaoImpl.class);

public User loginAuthentication(UserBean userBean) {
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
	criteria.add(Restrictions.eq("email",userBean.getEmail()));
	criteria.setFetchMode("appIdentifier", FetchMode.EAGER);
	return (User)criteria.uniqueResult();
	
	 
}

public List<Client> getClientBeanList() {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Client.class);
	@SuppressWarnings("unchecked")
	List<Client> clientModelList = criteria.list();
	return clientModelList;
}

public List<Event> getEventBeanList(Long clientId) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
	criteria.add(Restrictions.eq("client.clientId",clientId));
	criteria.setFetchMode("client", FetchMode.EAGER);
	criteria.setFetchMode("user", FetchMode.EAGER); 
	return (List<Event>)criteria.list();
}

public List<User> getUsersList(Long clientId) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
	criteria.add(Restrictions.eq("client.clientId",clientId ));
	criteria.setFetchMode("client", FetchMode.EAGER);
	criteria.setFetchMode("user", FetchMode.EAGER);
	
	return (List<User>)criteria.list();
}

public List<Services> getServicesList() {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Services.class);
	log.info("we are in ServicesListDaoImpl");
	return (List<Services>)criteria.list();
}



public Event getClientEventDetails(Long eventId) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
	criteria.add(Restrictions.eq("eventId", eventId));
	criteria.setFetchMode("eventServiceses", FetchMode.EAGER);
	criteria.setFetchMode("client", FetchMode.EAGER);
	return (Event) criteria.uniqueResult();
}


public void deleteServices(Long eventId){
	
	String query="DELETE FROM event_services WHERE  Event_ID=:event_id";
	SQLQuery sqlQuery=sessionFactory.getCurrentSession().createSQLQuery(query);
	sqlQuery.setParameter("event_id", eventId);
	sqlQuery.executeUpdate();
	System.out.println("Services Deleted Successfully");
}

public List<EventServices> getEventServicesList(Long eventId) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EventServices.class);
	criteria.add(Restrictions.eq("event.eventId", eventId));
	criteria.setFetchMode("services", FetchMode.EAGER);
	return (List<EventServices>)criteria.list();
}



@Override
public Participants getParticipantDetails(ParticipantBean participantBean) {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Participants.class);
	criteria.add(Restrictions.eq("phone",participantBean.getPhoneNumber()));
	return (Participants)criteria.uniqueResult();
}






}
