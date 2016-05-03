package com.wre.systemadminmgmt.controller;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wre.common.util.WREConstants;
import com.wre.common.util.WREUtil;
import com.wre.systemadminmgmt.bean.UserBean;
import com.wre.systemadminmgmt.service.SystemAdminMgmtService;
@Controller
public class SystemAdminMgmtController{

	@Autowired
	@Qualifier(value="systemAdminMgmtService")
	private SystemAdminMgmtService systemAdminMgmtService;
   
	
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
				   navigationpage="redirect:/login/authenticationFailed";
			   }
			   

			}
			 
			else{
		      log.info("email wrong");
			   redirectAttributes.addFlashAttribute("error", " Email Is Incorrect");
			   redirectAttributes.addFlashAttribute("userBean", userBean);
			   navigationpage="redirect:/login/authenticationFailed";
			
		   }
	    
		
		     return   navigationpage;
		}

		
		@RequestMapping(value = "/wre", method = RequestMethod.GET)
		public ModelAndView  systemAdminAuthenticationSuccess(@ModelAttribute("error")String error,HttpSession session){
			ModelAndView modelAndView=null;
			UserBean userBean=(UserBean)session.getAttribute(WREConstants.USER);
			 if(userBean.getRoleId().equals(WREConstants.ADMIN_ROLE))
			   {
			 modelAndView=new ModelAndView("systemadmin/systemAdminTemplate");
			   }else{
				   modelAndView=new ModelAndView("admin/adminTemplate"); 
			   }
			
			  log.info("adminAuthenticationSuccess-------------");
			
			return modelAndView;
		}
		
		

	   

	    
}
