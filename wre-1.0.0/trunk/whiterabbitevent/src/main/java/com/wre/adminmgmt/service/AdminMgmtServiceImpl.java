package com.wre.adminmgmt.service;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.dao.AdminMgmtDao;
import com.wre.model.Event;


@Service("AdminMgmtService")
public class AdminMgmtServiceImpl implements AdminMgmtService {

	private static final Log log = LogFactory.getLog(AdminMgmtServiceImpl.class);
	@Autowired
	@Qualifier(value = "AdminMgmtDao")
	private AdminMgmtDao AdminMgmtDaoImpl;
	
	
	//this event view 
		public List<EventBean> getEventBeanList() {
		List<EventBean> eventModelist=AdminMgmtDaoImpl.getEventBeanList();
		List<EventBean> eventbeanList=new ArrayList<EventBean>();
		for(EventBean event: eventModelist){
			EventBean eventBean=new EventBean();
			eventBean.setEventId(event.getEventId());
			eventBean.setClient(event.getClient());
			eventBean.setEventAddress(event.getEventAddress());
			eventBean.setEventDesc(event.getEventDesc());
			eventBean.setEventDate(event.getEventDate());
			eventBean.setEventDesc(event.getEventDesc());
			eventBean.setEventName(event.getEventName());
			eventBean.setEventAgenda(event.getEventAgenda());
			eventBean.setStatus(event.getStatus());
			}
		log.info("list size is --+"+eventbeanList.size());
		return eventbeanList;
	}

		//this event save
		public void saveEvent(EventBean eventBean) {
			Event event=new Event();
			event.setEventName(eventBean.getEventName());
            event.setClient(eventBean.getClient());
            event.setEventAddress(eventBean.getEventAddress());
            event.setEventDate(eventBean.getEventDate());
            event.setEventDesc(eventBean.getEventDesc());
            event.setEventId(eventBean.getEventId());
            event.setStatus(eventBean.getStatus());
            AdminMgmtDaoImpl.save(event);
            
            
		}
		
		
       // this is update Event
		public void updateEvent(EventBean eventBean) {
			Event eventObj=new Event();
			eventObj.setEventName(eventBean.getEventName());
			eventObj.setClient(eventBean.getClient());
			eventObj.setEventAddress(eventBean.getEventAddress());
			eventObj.setEventDate(eventBean.getEventDate());
			eventObj.setEventDesc(eventBean.getEventDesc());
			eventObj.setEventId(eventBean.getEventId());
			eventObj.setStatus(eventBean.getStatus());
            AdminMgmtDaoImpl.update(eventObj);
            
		}
		
	


		public EventBean getEventDetails(String eventId) {
			EventBean eventBean=null;
			Event event=null;
			eventBean=AdminMgmtDaoImpl.getEventDetails(eventId);
			if(event!=null){
				event=new Event();
				event.setEventName(eventBean.getEventName());
				 event.setClient(eventBean.getClient());
		            event.setEventAddress(eventBean.getEventAddress());
		            event.setEventDate(eventBean.getEventDate());
		            event.setEventDesc(eventBean.getEventDesc());
		            event.setStatus(eventBean.getStatus());
			}     
			return eventBean;
		}
	
	

}
