package com.wre.systemadminmgmt.dao;

import java.util.List;

import com.wre.common.dao.GenericDao;
import com.wre.model.Client;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Services;
import com.wre.model.User;
import com.wre.systemadminmgmt.bean.UserBean;



public interface SystemAdminMgmtDao  extends GenericDao<Object>{

	User loginAuthentication(UserBean userBean);

	List<Client> getClientBeanList();

	List<Event> getEventBeanList(Long clientId);

	List<User> getUsersList(Long clientId);

	List<Services> getServicesList();


	Event getClientEventDetails(Long eventId);

	void deleteServices(Long eventId);

	List<EventServices> getEventServicesList(Long eventId);

	

}
