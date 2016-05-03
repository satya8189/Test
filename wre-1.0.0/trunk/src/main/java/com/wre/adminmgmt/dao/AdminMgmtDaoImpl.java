package com.wre.adminmgmt.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wre.adminmgmt.bean.EventBean;
import com.wre.common.dao.GenericDaoImpl;
import com.wre.model.Event;
import com.wre.model.User;




@Repository("AdminMgmtDao")
public class AdminMgmtDaoImpl extends GenericDaoImpl<Object> implements
AdminMgmtDao {
	
	private static final Log log = LogFactory
			.getLog(AdminMgmtDaoImpl.class);

	

	public List<EventBean> getEventBeanList() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Event.class);
			List<Event> eventList=criteria.list();
			 return (List<EventBean>)criteria.list();
		}
	



	public List<EventBean> eventList() {
		// TODO Auto-generated method stub
		return null;
	}




	public EventBean getEventDetails(String eventId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Event.class);
		return null;
	}



	



	

	


}
