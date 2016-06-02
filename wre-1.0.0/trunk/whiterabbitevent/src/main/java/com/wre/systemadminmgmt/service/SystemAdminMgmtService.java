package com.wre.systemadminmgmt.service;

import java.util.List;

import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.ServicesBean;
import com.wre.model.EventServices;
import com.wre.systemadminmgmt.bean.ClientBean;
import com.wre.systemadminmgmt.bean.EventServicesBean;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.UserBean;

public interface SystemAdminMgmtService {

	UserBean loginAuthentication(UserBean userBean);

	List<ClientBean> getClientBeanList();

	void saveClient(ClientBean clientBean);

	List<EventBean> getEventsList(Long clientId);

	List<UserBean> getUsersList(Long clientId);

	void saveEvent(EventBean eventBean);

	List<ServicesBean> getServicesList();

	EventBean getEventDetails(Long eventId);


	void updateEventDetails(EventBean eventBean);

	List<EventServicesBean> getEventServicesList(Long eventId);

	ParticipantBean getParticipantDetails(ParticipantBean participantBean);

	

	

	

	

	
}
