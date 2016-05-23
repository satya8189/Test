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
import org.springframework.web.multipart.MultipartFile;


import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.GalaryBean;
import com.wre.adminmgmt.bean.InviteBean;
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
				
			    //admin/newsFeedCreate
			        @RequestMapping(value="admin/newsFeedCreate")
					public String  newsFeedCreate(){
						log.info("in side newsFeedCreate method");
						 return "admin/newsFeedCreate";
							}
			        
			       /* admin/galleryView*/
			        
			        @RequestMapping(value="admin/galleryView")
			        public String galleryView(){
			        	log.info("in side galleryView");
			        	return "admin/galleryView";
			        }
			        
			        //admin/galleryCreate
			        
			        @RequestMapping(value="admin/galleryCreate")
			        public String galleryCreate(){
			        	log.info("in side galleryCreate");
			        	return "admin/galleryCreate";
			        }
			        
			        // detailsView page
				       @RequestMapping(value="admin/detailsView")
					   public String detailsView(){
						log.info("navigate to detailsView page");
					    return "admin/detailsView";
					   }
				       
				       //admin/editDetailsView
				        @RequestMapping(value="admin/editDetailsView")
					   public String editDetailsView(){
						log.info("navigate to editDetailsView page");
					    return "admin/editDetailsView";
				       }
				       
				       //admin/invite
				        
				        @RequestMapping(value="admin/invite")
						   public String invite(){
							log.info("navigate to invite page");
						    return "admin/invite";
					       }
				        
				         //admin/inviteList
				        @RequestMapping(value="admin/inviteList")
						   public String inviteList(){
							log.info("navigate inviteList page");
						    return "admin/inviteList";
					       }
				        
				        
				       //admin/videoView
				        @RequestMapping(value="admin/videoView")
						   public String videoView(){
							log.info("navigate videoView page");
						    return "admin/videoView";
					       }
				        
				        //admin/documentView
				        
				        @RequestMapping(value="admin/documentView")
						   public String documentView(){
							log.info("navigate documentView page");
						    return "admin/documentView";
					       }
				        
				        //admin/documetnCreate
				         @RequestMapping(value="admin/documentCreate")
						   public String documentCreate(){
							log.info("navigate documentCreate page");
						    return "admin/documentCreate";
					       }
				        
				        //admin/videoUploadView
				        
				        @RequestMapping(value="admin/videoUpload")
						   public String videoUpload(){
							log.info("navigate videoUpload page");
						    return "admin/videoUpload";
					       }

			 //view event list
			@RequestMapping(value="admin/eventList")
			public @ResponseBody List<EventBean> getEventList(@RequestParam("userId") Long userId){
				log.info("in side Eventlist method----"+userId);
				List<EventBean> eventList=adminMgmtService.getEventList(userId);
				return eventList;
				
			}
			
			 //save event
		    @RequestMapping(value = "admin/saveEvent", method = RequestMethod.POST)
		    public @ResponseBody void saveEvent(@RequestBody EventBean eventBean) {
		    	log.info("in side saveEvent method");
		    adminMgmtService.saveEvent(eventBean);
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
		    
		    //create agendo
		    @RequestMapping(value = "admin/createAgendo", method = RequestMethod.POST)
		    public @ResponseBody void createAgendo(@RequestBody AgendaBean agendaBean) {
		    	log.info("in side save method");
		    adminMgmtService.createAgendo(agendaBean);
		    }
		    
		    @RequestMapping(value = "admin/createGallery", method = RequestMethod.POST)
		       public @ResponseBody void createGallery(@RequestParam(value="file", required=true) MultipartFile file,
		                        @RequestParam("eventId") Long eventId,@RequestParam("name") String name,@RequestParam("type") String type) {
		        log.info("in side savegallery method");
		        log.info("id--"+eventId);
		        log.info("file name---"+file.getOriginalFilename());
		       adminMgmtService.createGallery(file,eventId,type,name);
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
		    	AgendaBean agendaBean=adminMgmtService.agendoEditDetails(agenId);
		     return agendaBean;
		  	    
		    }

		  // agendoupdate
		    @RequestMapping(value ="agendo/update", method = RequestMethod.POST)
		    public @ResponseBody void updateAgendo(@RequestBody AgendaBean agendaBean) {
		    	System.out.println("agendaBean update"+agendaBean.getAgenTitle());
		    	adminMgmtService.updateAgendo(agendaBean);
		    }
		    
    
		   //saveNews
		     @RequestMapping(value = "admin/saveNews", method = RequestMethod.POST)
		    public @ResponseBody void saveNews(@RequestBody NewsFeedBean newsFeedBean) {
		    	log.info("in side saveNews method");
		    adminMgmtService.saveNews(newsFeedBean);
		   
		    }
		     
		    //News List
				@RequestMapping(value="admin/newsList")
				public @ResponseBody List<NewsFeedBean> getNewsList(@RequestParam("eventId") Long eventId){
					log.info("in side newsList method----"+eventId);
					List<NewsFeedBean> newsList=adminMgmtService.getNewsList(eventId);
					return newsList;
					
			}
				
		   //news edit
			    @RequestMapping(value="admin/newsEditDetails",method=RequestMethod.GET,produces="application/json")
			    public @ResponseBody NewsFeedBean newsEditDetails(@RequestParam("newsFeedId") Long newsFeedId){
			    	NewsFeedBean newsFeedBean=adminMgmtService.newsEditDetails(newsFeedId);
			    	return newsFeedBean;
			    
			  	  }
			   
				
		    //news/update
			    
			    @RequestMapping(value ="news/update", method = RequestMethod.POST)
			    public @ResponseBody void updateNews(@RequestBody NewsFeedBean newsFeedBean) {
			    	System.out.println("newsFeedBean update"+newsFeedBean.getNewsDesc());
			    	adminMgmtService.updateNews(newsFeedBean);
			    }
			   
			
	          //admin/galleryList
				@RequestMapping(value="admin/galaryList")
				public @ResponseBody List<GalaryBean> galaryList(@RequestParam("eventId") Long eventId,@RequestParam("type") String type){
					log.info("in side galaryList method----"+eventId);
					List<GalaryBean> galaryList=adminMgmtService.galaryList(eventId,type);
			
					return galaryList;
				}
				//admin/detailsView
				
				 @RequestMapping(value="admin/Viewdetails",method=RequestMethod.GET)
				    public @ResponseBody EventBean detailsView(@RequestParam ("eventId")  Long eventId){
					EventBean eventBean=adminMgmtService.detailsView(eventId);
				     return eventBean;
				  	    
				    }
				 
				 //details/update
				 
				 @RequestMapping(value = "details/update", method = RequestMethod.POST)
				    public @ResponseBody void updateDetails(@RequestBody EventBean eventBean) {
				    adminMgmtService.updateDetails(eventBean);
				    }
				    
				 //admin/createGallery
			     
			    
			     
			    
			   
			   //admin/invite 
			     
			    @RequestMapping(value = "admin/invite", method = RequestMethod.POST)
			    public @ResponseBody void invite(@RequestBody InviteBean inviteBean) {
			    	log.info("in side invite method");
			    adminMgmtService.invite(inviteBean);
			   
			    }
			    
			   //admin/inviteDetails
				@RequestMapping(value="admin/inviteDetails")
				public @ResponseBody List<InviteBean> inviteDetails(@RequestParam("eventId") Long eventId){
					log.info("in side inviteDetails method----"+eventId);
					List<InviteBean> inviteList=adminMgmtService.inviteDetails(eventId);
			
					return inviteList;
			    
			}
				
				 //for deleteGallery
				@RequestMapping(value = "admin/deleteGallery", method = RequestMethod.POST)
				 public @ResponseBody void  deleteGallery(@RequestBody GalaryBean galaryBean) {
				  log.info("Entered into delete  galary  method----------"+galaryBean.getGlaryItemId());
					adminMgmtService.deleteGallery(galaryBean.getGlaryItemId());
			
				 }
}


