package com.wre.systemadminmgmt.controller;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.ServicesBean;
import com.wre.adminmgmt.service.AdminMgmtService;
import com.wre.common.util.WREConstants;
import com.wre.common.util.WREUtil;
import com.wre.systemadminmgmt.bean.ClientBean;
import com.wre.systemadminmgmt.bean.EventServicesBean;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.ParticipantEventBean;
import com.wre.systemadminmgmt.bean.UserBean;
import com.wre.systemadminmgmt.service.SystemAdminMgmtService;
@Controller
public class SystemAdminMgmtController{

	@Autowired
	@Qualifier(value="systemAdminMgmtService")
	private SystemAdminMgmtService systemAdminMgmtService;
	
	@Autowired
	@Qualifier(value = "AdminMgmtService")
	private AdminMgmtService adminMgmtService;
   
	private static final Log log = LogFactory.getLog(SystemAdminMgmtController.class);
	
	 /**
	     * This method is used to get practice logo from the stored location
	     * @param practiceId
	     * @return
	     * @author yinsol-prasad
	     */
	    @RequestMapping(value="login",method=RequestMethod.GET)
	    public ModelAndView getPracticeLogo(){
	    	ModelAndView modelAndView=new ModelAndView("login");
	    	
	    	modelAndView.addObject("userBean", new UserBean());
           return  modelAndView;
	    }
	    
	    @RequestMapping(value = "/loginAuthentication", method = RequestMethod.POST)
		public String loginAuthentication(@ModelAttribute("userBean")UserBean userBean,HttpSession session,RedirectAttributes redirectAttributes) {
			log.info("inside login method");
			UserBean userObject=systemAdminMgmtService.loginAuthentication(userBean);
			String navigationpage=null;
			if(userObject!=null){  
				 if(WREUtil.encryptData(userBean.getPassword()).equals(userObject.getPassword()))
				   {  
				         session.setAttribute(WREConstants.USER,userObject );
				         redirectAttributes.addFlashAttribute("error", "success");
				         navigationpage="redirect:/wre";
					
					  }
			   
			   else
			   {
				   log.info("password wrong");
				   redirectAttributes.addFlashAttribute("error", "Password was Wrong!!");
				   redirectAttributes.addFlashAttribute("userBean", userBean);
				   //navigationpage="redirect:/login/authenticationFailed";
				   navigationpage="redirect:login";
			   }
			}
			else{
		      log.info("email wrong");
			   redirectAttributes.addFlashAttribute("error", " Email Is Incorrect");
			   redirectAttributes.addFlashAttribute("userBean", userBean);
			   //navigationpage="redirect:/login/authenticationFailed";
			   navigationpage="redirect:login";
		   }
		     return   navigationpage;
		}

		
		@RequestMapping(value = "/wre", method = RequestMethod.GET)
		public ModelAndView  systemAdminAuthenticationSuccess(@ModelAttribute("error")String error,HttpSession session){
			ModelAndView modelAndView=null;
			UserBean userBean=(UserBean)session.getAttribute(WREConstants.USER);
			
			 if(userBean.getRoleId().equals(WREConstants.SYS_ADMIN_ROLE))
			   	{
				 	modelAndView=new ModelAndView("systemadmin/systemAdminTemplate");
				 	log.info("systemadmin login success....");
			   }else{
				   if(userBean.getRoleId().equals(WREConstants.ADMIN_ROLE))
				   {
					   modelAndView=new ModelAndView("admin/adminTemplate");
				   }
			   }
			  log.info("adminAuthenticationSuccess-------------");
			
			return modelAndView;
		}
		
		//logout method
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public ModelAndView logoutUser(HttpSession session){
			session.removeAttribute(WREConstants.USER);
			session.invalidate();
			ModelAndView modelAndView=new ModelAndView("login");
			modelAndView.addObject("userBean", new UserBean());
			return modelAndView;
		}
		
		
		//client List View page
		@RequestMapping(value="systemadmin/clientsView",method=RequestMethod.GET)
		public String ClientListViewPage(){
			log.info("we are in SystemAdminClientList Method of Controller");
			return "systemadmin/clientsView";
		}
		
		//clients List method
		@RequestMapping(value="systemadmin/clientList",method=RequestMethod.GET)
		public @ResponseBody List<ClientBean> getClientBeanList(){
			log.info("in side Eventlist method");
			return systemAdminMgmtService.getClientBeanList();
			
		}
		
		//client Create navigation method
		@RequestMapping(value="systemadmin/createClient")
		public String createClientNavigationPage(){
			log.info("we are in systemAdmin CreateNavigation Method");
			return "systemadmin/createClient";
		}
		
		@RequestMapping(value="systemadmin/saveClient",method=RequestMethod.POST)
		public @ResponseBody ClientBean saveClient(@RequestBody ClientBean clientBean){
			log.info("we are in save method of systemadminClient ");
			systemAdminMgmtService.saveClient(clientBean);
			return clientBean;
		}
		
		
		//navigation of ClientEvent List Page
		@RequestMapping(value="systemadmin/navigateEventList")
		public String navigateEventList(){
			log.info("we are in eventView Controller");
          return "systemadmin/clientEventsView";
		}
		
		//Client Event List method
				@RequestMapping(value="systemadmin/eventList",method=RequestMethod.GET)
				public @ResponseBody List<EventBean> geteventList(@RequestParam("clientId") Long clientId ){
					log.info("in side Eventlist method ----"+clientId);
					return systemAdminMgmtService.getEventsList(clientId);
					
				}
				
			//navigation of ClientEvent List Page
			@RequestMapping(value="systemadmin/navigateToEventCreate")
			public String navigateToClientEventCreate(){
				log.info("we are in eventView Controller");
	          return "systemadmin/clientEventCreate";
			}
			
			@RequestMapping(value="systemadmin/getUsersList",method=RequestMethod.GET)
			public @ResponseBody List<UserBean> getUsersList(@RequestParam("clientId") Long clientId){
				log.info("getUsersListmethod of systemadminController");
				List<UserBean> l= systemAdminMgmtService.getUsersList(clientId);
				log.info("value--"+l.size());
				return l;
			}
	    
			@RequestMapping(value="systemadmin/saveEvent",method=RequestMethod.POST)
			public @ResponseBody EventBean saveEvent(@RequestBody EventBean eventBean){
				log.info("we are in save method of systemadminClient ");
				eventBean=systemAdminMgmtService.saveEvent(eventBean);
				return eventBean;
				
			}
			
			
	@RequestMapping(value = "systemadmin/uploadEventHomeLogo", method = RequestMethod.POST)
	public @ResponseBody
	void uploadPracticeLogo(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("type") String type) {

		try {
			byte[] bytes = file.getBytes();
			File dir = new File(WREConstants.RESOURCE_PATH + File.separator
					+ eventId + File.separator + type);
			if (!dir.exists())
				dir.mkdirs();
			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ WREConstants.EVENT_HOME_LOGO);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		} catch (IOException e) {
			log.error(e);
		}
	}
			
			
			@RequestMapping(value="systemadmin/servicesList",method=RequestMethod.GET)
			public  @ResponseBody List<ServicesBean> getServicesList(){
				log.info("we are in get ServicesList");
				List<ServicesBean> s = systemAdminMgmtService.getServicesList();
				log.info("list size"+s.size());
				return s;
			}
			
			@RequestMapping(value="systemadmin/navigatetoClientEventEdit")
			public String navigateToEventEdit(){
				log.info("we are in navigation of clientEventEdit");
				return "systemadmin/clientEventEdit";
				
			}
			
			@RequestMapping(value="systemadmin/editEvent",method=RequestMethod.GET)
			public @ResponseBody EventBean getEventDetails(@RequestParam("eventId") Long eventId){
				log.info("we are in editClientEventController");
				return systemAdminMgmtService.getEventDetails(eventId);
			}
			@RequestMapping(value="systemadmin/updateEvent",method=RequestMethod.POST)
			public @ResponseBody void updateEvent(@RequestBody EventBean eventBean){
				log.info("we are in updateEventController");
				systemAdminMgmtService.updateEventDetails(eventBean);
				log.info("event"+eventBean.getEventId());
				
			}
			
			@RequestMapping(value="systemadmin/getEventServices",method=RequestMethod.GET)
			public @ResponseBody List<EventServicesBean> getEventServices(@RequestParam("eventId") Long eventId){
				return systemAdminMgmtService.getEventServicesList(eventId);
			}
			
			//systemadmin/eventView
			
			@RequestMapping(value="systemadmin/eventView")
			public String eventView(){
				log.info("we are in systemAdmin eventView");
				return "systemadmin/eventView";
				
			}
			
			//systemadmin/imageUpload
			
			@RequestMapping(value="systemadmin/imageUpload")
			public String imageUpload(){
				log.info("we are in systemAdmin imageUpload");
				return "systemadmin/imageUpload";
				
			}
			//get participants Details
			@RequestMapping(value="systemadmin/getParticipantDetails",method=RequestMethod.POST)
			public @ResponseBody ParticipantBean getParticipantDetails(@RequestBody ParticipantBean participantBean){
				return systemAdminMgmtService.getParticipantDetails(participantBean);
				
			}
			//get participantsEventList 
			@RequestMapping(value="systemadmin/getParticipantEventList",method=RequestMethod.GET)
			public @ResponseBody List<ParticipantEventBean> getParticipantEventList(@RequestParam("participantId") Long participantId){
				return systemAdminMgmtService.getParticipantEventList(participantId);
			}
			
			//get participantEventServicesList
			
			@RequestMapping(value="/participantlogin",method=RequestMethod.POST)
			public @ResponseBody ParticipantBean participantLogin(@RequestBody ParticipantBean participantBean){
				ParticipantBean pbean=null;
				 pbean=systemAdminMgmtService.getParticipantDetails(participantBean);
				/*log.info("we are in getParticipantDetails");
				if(pbean!=null){
				String otp	=adminMgmtService.generateOTP(pbean);
				pbean.setOTP(otp);
				 adminMgmtService.sendingOTP(pbean);
					log.info("we are in generateOTP");

				}*/
				
			
				return pbean;
				
			}
			
			@RequestMapping(value="systemadmin/serviceListView")
			public String goToServiceListView(){
				log.info("we are in serviceListView..");
				return "systemadmin/serviceView";
				
			}

		
			@RequestMapping(value="systemadmin/sendSMS")
		    public  String sendSMS(@RequestParam("message") String message,@RequestParam("mobileNumber") String mobileNumber,@RequestParam("sender") String sender) {
		      String res="success";
		      String messagedata;
		    	String s[]=message.split(",");
		    	  messagedata="Dear";
		    System.out.println("message--"+messagedata);
		     
		    	  String sms_url="http://bulksmsapps.com/apisms.aspx?user=surenganne&password=Ganne@2013&genkey=758742187&sender="+sender+"&message="+messagedata+"&number="+mobileNumber;
		          URL url;
		          try {
		              url = new URL(sms_url);
		              InputStream is = url.openConnection().getInputStream();
		              BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
		              reader.close();
		          } catch (Exception e) {
		              System.err.println(e);
		             res="fail";
		          }
		          System.out.println("message send successfully");
		          return "{\"result\":\"" + res + "\"}";
		    }
			
			
}
