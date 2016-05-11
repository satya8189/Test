package com.wre.adminmgmt.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.adminmgmt.service.AdminMgmtService;


@Controller
public class AdminMgmtController {
	
	@Autowired
	@Qualifier(value="AdminMgmtService")
	private AdminMgmtService adminMgmtService;
    private static final Log log = LogFactory.getLog(AdminMgmtController.class);
    
          // event view page
	       @RequestMapping(value="admin/eventView")
		   public String eventView(){
			log.info("navigate to eventView page");
		    return "admin/eventView";
		   }
	       
	       //create event
			@RequestMapping(value="admin/eventCreate")
			public String  eventCreate(){
				log.info("in side eventCreate method");
				 return "admin/eventCreate";
					}
		
	       
	       //update page 
		    @RequestMapping("admin/eventEdit")
		    public String eventEdit() {
		    	log.info("Inside eventEdit method()");
		        return "admin/eventUpdate";
		    }
		    
		    
		    
		  //eventViewDetailsPage
		    @RequestMapping("admin/eventViewDetails")
		    public String eventViewDetails() {
		    	log.info("Inside eventViewDetails method()");
		        return "admin/eventViewDetails";
		    }
		    
		   
		    //agendoViewDetailsPage
			    @RequestMapping("admin/navigetAgendoDetails")
			    public String agendoViewDetails() {
			    	log.info("Inside agendoViewDetails method()");
			        return "admin/agendoViewDetails";
			    }
		    
			    
			  //agendoCreatePage
				@RequestMapping(value="admin/agendoCreate")
				public String  agendoCreate(){
					log.info("in side agendoCreate method");
					 return "admin/agendoCreate";
						}
				
				 //agendoEdit
				@RequestMapping(value="admin/agendoEdit")
				public String  agendoEdit(){
					log.info("in side agendoEdit method");
					 return "admin/agendoEdit";
						}
				
				 //admin/newsFeedView
			    @RequestMapping(value="admin/newsFeedView")
					public String  newsFeedView(){
						log.info("in side newsFeedView method");
						 return "admin/newsFeedView";
							}
					
			    
			    //admin/newsEdit
			    @RequestMapping(value="admin/newsFeedEdit")
					public String  newsFeedEdit(){
						log.info("in side newsFeedEdit method");
						 return "admin/newsFeedEdit";
							}
				
				
		    
		
		   //view event list
			@RequestMapping(value="admin/eventList")
			public @ResponseBody List<EventBean> getEventList(@RequestParam("userId") Long userId){
				log.info("in side Eventlist method----"+userId);
				List<EventBean> eventList=adminMgmtService.getEventList(userId);
				return eventList;
				
			}
			
			
			//News List
			@RequestMapping(value="admin/newsList")
			public @ResponseBody List<NewsFeedBean> getNewsList(@RequestParam("newsFeedId") Long newsFeedId){
				log.info("in side newsList method----"+newsFeedId);
				List<NewsFeedBean> newsList=adminMgmtService.getNewsList(newsFeedId);
				return newsList;
				
			}
			
			
	       //save event
		    @RequestMapping(value = "admin/saveEvent", method = RequestMethod.POST)
		    public @ResponseBody void saveEvent(@RequestBody EventBean eventBean) {
		    	log.info("in side saveEvent method");
		    adminMgmtService.saveEvent(eventBean);
		    }
		    

		    //create agendo
			    @RequestMapping(value = "admin/createAgendo", method = RequestMethod.POST)
			    public @ResponseBody void createAgendo(@RequestBody AgendaBean agendaBean) {
			    	log.info("in side save method");
			    adminMgmtService.createAgendo(agendaBean);
			    }
		    
		    // event details
		    @RequestMapping(value="admin/eventdetailsList",method=RequestMethod.GET)
		    public @ResponseBody List<EventBean>getEventDetails(@RequestParam("eventId") String eventId){
		       List<EventBean> eventList=adminMgmtService.getEventDetailsList(eventId);
				return eventList;
				
		    }
		    
		 //update event
		    @RequestMapping(value = "event/update", method = RequestMethod.POST)
		    public @ResponseBody void updateEvent(@RequestBody EventBean eventBean) {
		    adminMgmtService.updateEvent(eventBean);
		    }
		    
		    // admin/agendoDetails
		    
		    @RequestMapping(value="admin/agendoDetails")
			public @ResponseBody List<AgendaBean> getAgendoDetails(@RequestParam("eventId") Long eventId){
				log.info("in side AgendoDetails method----"+eventId);
				List<AgendaBean> agendoList=adminMgmtService.getAgendoDetails(eventId);
				return agendoList;
				
			}
		    //agendo edit
		    @RequestMapping(value="admin/agendoEditDetails",method=RequestMethod.GET)
		    public @ResponseBody AgendaBean agendoEditDetails(@RequestParam("agenId") Long agenId){
		  
		    	return adminMgmtService.agendoEditDetails(agenId);
		  	    
		    }

		  // agendoupdate
		    @RequestMapping(value ="agendo/update", method = RequestMethod.POST)
		    public @ResponseBody void updateAgendo(@RequestBody AgendaBean agendaBean) {
		    	System.out.println("agendaBean update"+agendaBean.getAgenTitle());
		    	adminMgmtService.updateAgendo(agendaBean);
		    }
		   
		   
		    //news edit
		    @RequestMapping(value="admin/newsEditDetails",method=RequestMethod.GET)
		    public @ResponseBody NewsFeedBean newsEditDetails(@RequestParam("newsFeedId") Long newsFeedId){
		    	NewsFeedBean newsFeedBean= adminMgmtService.newsEditDetails(newsFeedId);
		    	System.out.println("dafs---"+newsFeedBean.getNewsTitle());
		    	return newsFeedBean;
		    
		  	  }
		    //news/update
		    
		    @RequestMapping(value ="news/update", method = RequestMethod.POST)
		    public @ResponseBody void updateNews(@RequestBody NewsFeedBean newsFeedBean) {
		    	System.out.println("newsFeedBean update"+newsFeedBean.getNewsDesc());
		    	adminMgmtService.updateNews(newsFeedBean);
		    }
		   
		    

}

