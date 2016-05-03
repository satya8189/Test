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



import com.infoyuga.cd.systemadminmgmt.bean.OrganisationBean;
import com.wre.adminmgmt.bean.EventBean;
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
			@RequestMapping(value="admin/eventcreate")
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
		    
		   //view event list
			@RequestMapping(value="admin/eventList")
			public @ResponseBody List<EventBean> getEventBeanList(){
				log.info("in side Eventlist method");
				return adminMgmtService.getEventBeanList();
				
			}
			
			
	       //save event
		    @RequestMapping(value = "admin/eventsave", method = RequestMethod.POST)
		    public @ResponseBody void saveEvent(@RequestBody EventBean eventBean) {
		    adminMgmtService.saveEvent(eventBean);
		    }
		    
		    // event details
		    @RequestMapping(value="admin/eventdetails",method=RequestMethod.GET)
		    public @ResponseBody EventBean getEventDetails(@RequestParam("eventId") String eventId){
		    	EventBean eventBean=null;
		    	eventBean=adminMgmtService.getEventDetails(eventId);
		  	    return eventBean;
		    }
		    
		 
		    
		  //update event
		    @RequestMapping(value = "event/update", method = RequestMethod.POST)
		    public @ResponseBody void updateEvent(@RequestBody EventBean eventBean) {
		    adminMgmtService.updateEvent(eventBean);
		    }
		    
		
	

}
