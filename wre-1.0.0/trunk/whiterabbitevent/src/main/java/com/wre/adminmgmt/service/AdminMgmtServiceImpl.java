package com.wre.adminmgmt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.GalaryBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.adminmgmt.dao.AdminMgmtDao;
import com.wre.model.Agenda;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Galary;
import com.wre.model.Newsfeed;


@Service("AdminMgmtService")
public class AdminMgmtServiceImpl implements AdminMgmtService {

	private static final Log log = LogFactory.getLog(AdminMgmtServiceImpl.class);
	@Autowired
	@Qualifier(value = "AdminMgmtDao")
	private AdminMgmtDao AdminMgmtDaoImpl;
	
	//==================Event Start============================================
	
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
				
				 // this is event list convert to eventSeviceList
				
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
		
		//==================Event End============================================
			    
	  //==================Agendo Start============================================	    
			    
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
		//agendo editedetails
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
		
	//	==============================Agendo End============================================
		
	//=================================News Start===========================================	
		//NewsList
		public List<NewsFeedBean> getNewsList(Long eventId) {
			List<Newsfeed> newsList=AdminMgmtDaoImpl.getNewsList(eventId);
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
						newsFeedBean.setEventId(newsOjcet.getEvent().getEventId());
						}
					log.info("NewsDesc---"+newsFeedBean.getNewsDesc());
					return newsFeedBean;
				}
				
				
      //saveNews
				public void saveNews(NewsFeedBean newsFeedBean) {
					Newsfeed newsfeed=new Newsfeed();
					newsfeed.setNewsFeedId(newsFeedBean.getNewsFeedId());
		            newsfeed.setNewsTitle(newsFeedBean.getNewsTitle());
		            newsfeed.setNewsDesc(newsFeedBean.getNewsDesc());
		            
		             Event event=new Event();
		             event.setEventId(newsFeedBean.getEventId());
		             newsfeed.setEvent(event);
		             AdminMgmtDaoImpl.save(newsfeed);
		             log.info("this is savenews successfully");
				}
				
				//news update	
				public void updateNews(NewsFeedBean newsFeedBean) {
					Newsfeed newsOjcet=AdminMgmtDaoImpl.newsEditDetails(newsFeedBean.getNewsFeedId());
					newsOjcet.setNewsTitle(newsFeedBean.getNewsTitle());
					newsOjcet.setNewsDesc(newsFeedBean.getNewsDesc());
					newsOjcet.setNewsDate(new Date());
					
					 AdminMgmtDaoImpl.update(newsOjcet);
			}
				
				
					
				
				
	//====================================News End================================================
				
	//====================================Galary Start===========================================			
				//galaryList
				public List<GalaryBean> galaryList(Long eventId) {
					List<Galary> galaryList=AdminMgmtDaoImpl.galaryList(eventId);
					List<GalaryBean> galaryBeanList=new ArrayList<GalaryBean>();
					for(Galary galaryOject:galaryList)
					{
						GalaryBean galaryBeanOject=new GalaryBean();
						galaryBeanOject.setGlaryItemId(galaryOject.getGlaryItemId());
						galaryBeanOject.setName(galaryOject.getName());
						galaryBeanOject.setType(galaryOject.getType());
					
						galaryBeanList.add(galaryBeanOject);
			
					}
					log.info("list size is --"+galaryBeanList.size());
					return galaryBeanList;
				}
				//Create Galery
				public void createGallery(GalaryBean galaryBean) {
					Galary galary=new Galary();
					galary.setName(galaryBean.getName());
					galary.setType(galaryBean.getType());
					Event event=new Event();
					event.setEventId(galaryBean.getEventId());
					galary.setEvent(event);
					AdminMgmtDaoImpl.save(galary);
					log.info("this is savenews successfully");
					
				}

				//get detailsView
				  public EventBean detailsView(Long eventId) {
			        	 EventBean eventBeanOject=null;
			        	 Event eventOject=AdminMgmtDaoImpl.detailsView(eventId);
			        	 if(eventOject!=null){
			        		 eventBeanOject=new EventBean();
			        		 eventBeanOject.setEventId(eventOject.getEventId());
			        		 eventBeanOject.setEventAddress(eventOject.getEventAddress());
			        		 eventBeanOject.setEventAgenda(eventOject.getEventAgenda());
			        		 eventBeanOject.setEventDesc(eventOject.getEventDesc());
			        		 eventBeanOject.setEventName(eventOject.getEventName());
			        	 }
								
								return eventBeanOject;
							}
				  

					//updateDetails
					public void updateDetails(EventBean eventBean) {
						Event eventObj=AdminMgmtDaoImpl.detailsView(eventBean.getEventId());
						eventObj.setEventName(eventBean.getEventName());
					    eventObj.setEventAddress(eventBean.getEventAddress());
					    eventObj.setEventDesc(eventBean.getEventDesc());
					    eventObj.setEventAgenda(eventBean.getEventAgenda());
				       AdminMgmtDaoImpl.update(eventObj);
			            
					}
					
					

					
					
}

			


				
				
				
				

		



		
		


	



