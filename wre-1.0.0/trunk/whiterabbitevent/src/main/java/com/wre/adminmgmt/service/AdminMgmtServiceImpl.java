package com.wre.adminmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.adminmgmt.dao.AdminMgmtDao;
import com.wre.model.Agenda;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Newsfeed;


@Service("AdminMgmtService")
public class AdminMgmtServiceImpl implements AdminMgmtService {

	private static final Log log = LogFactory.getLog(AdminMgmtServiceImpl.class);
	@Autowired
	@Qualifier(value = "AdminMgmtDao")
	private AdminMgmtDao AdminMgmtDaoImpl;
	
	
	//this event view 
		public List<EventBean> getEventList(Long userId) {
		List<Event> eventModelist=AdminMgmtDaoImpl.getEventList(userId);
		List<EventBean> eventbeanList=new ArrayList<EventBean>();
		for(Event event: eventModelist){
			EventBean eventBean=new EventBean();
			eventBean.setEventId(event.getEventId());
		    eventBean.setEventAddress(event.getEventAddress());
			eventBean.setEventDesc(event.getEventDesc());
			eventBean.setEventName(event.getEventName());
			eventBean.setEventAgenda(event.getEventAgenda());
			eventBean.setEventDate(event.getEventDate());
			eventBean.setStatus(event.getStatus());
			eventbeanList.add(eventBean);
			}
		log.info("list size is --+"+eventbeanList.size());
		return eventbeanList;
	}

		//this event save
		public void saveEvent(EventBean eventBean) {
			Event event=new Event();
			event.setEventName(eventBean.getEventName());
            event.setEventAddress(eventBean.getEventAddress());
            event.setEventDate(eventBean.getEventDate());
            event.setEventDesc(eventBean.getEventDesc());
            event.setEventId(eventBean.getEventId());
            event.setStatus(eventBean.getStatus());
            AdminMgmtDaoImpl.save(event);
            
            
		}
		//this is Createagndo
       public void createAgendo(AgendaBean agendaBean) {
    	   Agenda agenda=new Agenda();
    	   agenda.setAgenId(agendaBean.getAgenId());
    	   agenda.setAgenStartTime(agendaBean.getAgenStartTime());
    	   agenda.setAgenDesc(agendaBean.getAgenDesc());
    	   agenda.setAgenTitle(agendaBean.getAgenTitle());
    	   agenda.setAgenEndTime(agendaBean.getAgenEndTime());
    	   agenda.setAgenBy(agendaBean.getAgenBy());
    	   
    	   
    	  
    	  Event event =new Event();
    	  event.setEventId(agendaBean.getEventId());
    	  agenda.setEvent(event);
    	   
        AdminMgmtDaoImpl.save(agenda);
    	
		}
		
		
       // this is update Event
		public void updateEvent(EventBean eventBean) {
			Event eventObj=new Event();
			eventObj.setEventName(eventBean.getEventName());
		
			eventObj.setEventAddress(eventBean.getEventAddress());
			eventObj.setEventDate(eventBean.getEventDate());
			eventObj.setEventDesc(eventBean.getEventDesc());
			eventObj.setEventId(eventBean.getEventId());
			eventObj.setStatus(eventBean.getStatus());
            AdminMgmtDaoImpl.update(eventObj);
            
		}
		
	    // this is service list
		    public List<EventBean> getEventDetailsList(String eventId) {
			
		    List<EventServices> eventServicesList=AdminMgmtDaoImpl.getEventDetails(eventId);
			List<EventBean> eventbeanList=new ArrayList<EventBean>();
			
			for(EventServices eventServicesObj:eventServicesList){
				EventBean eventOjectBean=new EventBean();
				eventOjectBean.setEventId(eventServicesObj.getEvent().getEventId());
				eventOjectBean.setServiceId(eventServicesObj.getEvent().getEventId());
				eventOjectBean.setEventName(eventServicesObj.getEvent().getEventName());
				eventOjectBean.setEventAddress(eventServicesObj.getEvent().getEventAddress());
				eventOjectBean.setEventAddress(eventServicesObj.getStatus());
				eventOjectBean.setServiceId(eventServicesObj.getServices().getServiceId());
				eventOjectBean.setServiceName(eventServicesObj.getServices().getServiceName());
				eventbeanList.add(eventOjectBean);
				}
			    log.info("list size is --+"+eventbeanList.size());
			    return eventbeanList;
		}

		// this is agendaView list
		public List<AgendaBean> getAgendoDetails(Long eventId) {
			List<Agenda> agendaList=AdminMgmtDaoImpl.getAgendoDetails(eventId);
			
			List<AgendaBean> agendaBeanList=new ArrayList<AgendaBean>();
			for(Agenda agendaObj:agendaList)
			{
				AgendaBean agendaBean=new AgendaBean();
				
				agendaBean.setAgenId(agendaObj.getAgenId());
				agendaBean.setAgenTitle(agendaObj.getAgenTitle());
				agendaBean.setAgenDesc(agendaObj.getAgenDesc());
				agendaBean.setAgenStartTime(agendaObj.getAgenStartTime());
				agendaBean.setAgenEndTime(agendaObj.getAgenEndTime());
				agendaBean.setAgenBy(agendaObj.getAgenBy());
				agendaBeanList.add(agendaBean);
				}
			
			log.info("list size is --"+agendaBeanList.size());
			return agendaBeanList;
		}
		
		public AgendaBean agendoEditDetails(Long agenId) {
			AgendaBean agendaBean=null;
			
			Agenda agendaOject=AdminMgmtDaoImpl.agendoEditDetails(agenId);
			if(agendaOject!=null){
			agendaBean=new AgendaBean();
			agendaBean.setAgenId(agendaOject.getAgenId());
			agendaBean.setAgenBy(agendaOject.getAgenBy());
			agendaBean.setAgenDesc(agendaOject.getAgenDesc());
			agendaBean.setAgenStartTime(agendaOject.getAgenStartTime());
			agendaBean.setAgenEndTime(agendaOject.getAgenEndTime());
			agendaBean.setAgenTitle(agendaOject.getAgenTitle());
			agendaBean.setEventId(agendaOject.getEvent().getEventId());
			
		}
			log.info("title---"+agendaBean.getAgenTitle());
			return agendaBean;

	}
		

	//updateAgendo

		public void updateAgendo(AgendaBean agendaBean) {
			
			Agenda agendaOject=AdminMgmtDaoImpl.agendoEditDetails(agendaBean.getAgenId());
			agendaOject.setAgenBy(agendaBean.getAgenBy());
			agendaOject.setAgenDesc(agendaBean.getAgenDesc());
			agendaOject.setAgenEndTime(agendaBean.getAgenEndTime());
			agendaOject.setAgenStartTime(agendaBean.getAgenStartTime());
			agendaOject.setAgenTitle(agendaBean.getAgenTitle() );
			  
			
	       AdminMgmtDaoImpl.update(agendaOject);
		}
		
		//NewsList
		public List<NewsFeedBean> getNewsList(Long newsFeedId) {
			List<Newsfeed> newsList=AdminMgmtDaoImpl.getNewsList(newsFeedId);
			List<NewsFeedBean> newsBeanList=new ArrayList<NewsFeedBean>();
			for(Newsfeed newsfeedOject:newsList)
			{
				NewsFeedBean newsFeedBean=new NewsFeedBean();
				newsFeedBean.setNewsFeedId(newsfeedOject.getNewsFeedId());
				newsFeedBean.setNewsDesc(newsfeedOject.getNewsDesc());
				newsFeedBean.setNewsTitle(newsfeedOject.getNewsTitle());
				newsFeedBean.setNewsDate(newsfeedOject.getNewsDate());
				newsBeanList.add(newsFeedBean);
			}
		   log.info("list size is --"+newsBeanList.size());
			return newsBeanList;
		}

		//NewsEdit
				public NewsFeedBean newsEditDetails(Long newsFeedId) {
					NewsFeedBean newsFeedBean=null;
					Newsfeed newsOjcet=AdminMgmtDaoImpl.newsEditDetails(newsFeedId);
					if(newsOjcet!=null){
						newsFeedBean=new NewsFeedBean();
						newsFeedBean.setNewsFeedId(newsOjcet.getNewsFeedId());
						newsFeedBean.setNewsDate(newsOjcet.getNewsDate());
						newsFeedBean.setNewsTitle(newsOjcet.getNewsTitle());
						newsFeedBean.setNewsDesc(newsOjcet.getNewsDesc());
						newsFeedBean.setEvent(newsOjcet.getEvent());
					}
					log.info("NewsDesc---"+newsFeedBean.getNewsDesc());
					return newsFeedBean;
				}

				public void updateNews(NewsFeedBean newsFeedBean) {
					Newsfeed newsOjcet=AdminMgmtDaoImpl.newsEditDetails(newsFeedBean.getNewsFeedId());
					
					newsOjcet.setNewsFeedId(newsFeedBean.getNewsFeedId());  
					newsOjcet.setNewsDate(newsFeedBean.getNewsDate());
					newsOjcet.setNewsTitle(newsFeedBean.getNewsTitle());
					newsOjcet.setNewsDate(newsFeedBean.getNewsDate());
					
			       AdminMgmtDaoImpl.update(newsOjcet);
					
					
				}
		

		
}


		
		


	



