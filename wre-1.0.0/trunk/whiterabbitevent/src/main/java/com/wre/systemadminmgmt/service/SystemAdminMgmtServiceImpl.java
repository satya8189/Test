package com.wre.systemadminmgmt.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wre.model.AppIdentifier;
import com.wre.model.User;
import com.wre.systemadminmgmt.bean.UserBean;
import com.wre.systemadminmgmt.dao.SystemAdminMgmtDao;


@Service("systemAdminMgmtService")
public class SystemAdminMgmtServiceImpl implements SystemAdminMgmtService{
	
	private static final Log log = LogFactory.getLog(SystemAdminMgmtServiceImpl.class);
	@Autowired
	@Qualifier(value = "systemAdminMgmtDao")
	private SystemAdminMgmtDao systemAdminMgmtDaoImpl;
	
	
	public UserBean loginAuthentication(UserBean userBean) {
		User user=systemAdminMgmtDaoImpl.loginAuthentication(userBean);
		UserBean userObject=null;
		if(user!=null)
		{
		    userObject=new UserBean();
		    userObject.setUserId(user.getUserId());
			userObject.setFirstName(user.getFirstName());
			userObject.setEmail(user.getEmail());
			userObject.setPhone(user.getPhone());
			userObject.setStatus(user.getStatus());
			userObject.setPassword(user.getPassword());
			if(user.getAppIdentifier()!=null)
			{
				userObject.setRoleId(user.getAppIdentifier().getAppIdentifierId());
				userObject.setRoleName(user.getAppIdentifier().getIdentifierName());
			}
		
			
		}
		
		
		return userObject;
	}
	

}
