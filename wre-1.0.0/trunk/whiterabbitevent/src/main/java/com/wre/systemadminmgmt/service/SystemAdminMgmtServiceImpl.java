package com.wre.systemadminmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.ServicesBean;
import com.wre.common.util.WREConstants;
import com.wre.common.util.WREUtil;
import com.wre.model.AppIdentifier;
import com.wre.model.Client;
import com.wre.model.Event;
import com.wre.model.EventParticipant;
import com.wre.model.EventServices;
import com.wre.model.Participants;
import com.wre.model.Services;
import com.wre.model.User;
import com.wre.systemadminmgmt.bean.ClientBean;
import com.wre.systemadminmgmt.bean.EventServicesBean;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.ParticipantEventBean;
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


	public List<ClientBean> getClientBeanList() {
		List<Client> clientList = systemAdminMgmtDaoImpl.getClientBeanList();
		List<ClientBean> clientBeans = new ArrayList<ClientBean>();
		for(Client clientObj :clientList){
		ClientBean clientBean = new ClientBean();
		clientBean.setClientId(clientObj.getClientId());
		clientBean.setClientName(clientObj.getClientName());
		clientBean.setAddress(clientObj.getAddress());
		clientBean.setDescription(clientObj.getDescription());
		clientBean.setStaus(clientObj.getStaus());
		clientBeans.add(clientBean);
		}
		return clientBeans;
}


	public void saveClient(ClientBean clientBean) {
		Client clientObj = new Client();
		
		clientObj.setClientName(clientBean.getClientName());
		clientObj.setAddress(clientBean.getAddress());
		clientObj.setDescription(clientBean.getDescription());
		clientObj.setStaus(WREConstants.ACTIVE_STATUS);
		log.info("sfd---"+clientObj.getDescription());
		
		
		systemAdminMgmtDaoImpl.save(clientObj);
		
		User userObj = new User();
		userObj.setEmail(clientBean.getEmailId());
		userObj.setFirstName(clientBean.getFirstName());
		userObj.setLastName(clientBean.getLastName());
		userObj.setPhone(clientBean.getPhoneNo());
		userObj.setClient(clientObj);
		userObj.setStatus(WREConstants.ACTIVE_STATUS);
		userObj.setPassword(WREUtil.EncryptText(WREConstants.PASSWORD));
		AppIdentifier appIdentifier = new AppIdentifier();
		appIdentifier.setAppIdentifierId(WREConstants.ADMIN_ROLE);
		userObj.setAppIdentifier(appIdentifier);
		systemAdminMgmtDaoImpl.save(userObj);
		
		
	}


	public List<EventBean> getEventsList(Long clientId) {
		List<Event> eventList = systemAdminMgmtDaoImpl.getEventBeanList(clientId);
		List<EventBean> eventBeanList = new ArrayList<EventBean>();
		for(Event event:eventList){
			EventBean eventBean=new EventBean();
			eventBean.setEventId(event.getEventId());
			eventBean.setEventName(event.getEventName());
			eventBean.setEventAddress(event.getEventAddress());
			eventBean.setEventDesc(event.getEventDesc());
			eventBean.setEventTime(event.getEventTime());
			eventBean.setEventDate(event.getEventDate());
			eventBean.setEventAgenda(event.getEventAgenda());
			eventBeanList.add(eventBean);
		}
		return eventBeanList;
	}


	public List<UserBean> getUsersList(Long clientId) {
		List<User> userEntityList = systemAdminMgmtDaoImpl.getUsersList(clientId);
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		for(User users : userEntityList){
		UserBean userBean = new UserBean();
		userBean.setUserId(users.getUserId());
		userBean.setFirstName(users.getFirstName()+""+users.getLastName());
		userBeanList.add(userBean);
		}
		return userBeanList;
	}


	public EventBean saveEvent(EventBean eventBean) {
		Client client=null;
		User userObj =null;
		client=new Client();
		client.setClientId(eventBean.getClientId());
		
		if(eventBean.getUserId()==null){
			
			userObj= new User();
			userObj.setFirstName(eventBean.getUserFristName());
			userObj.setLastName(eventBean.getUserLastName());
			userObj.setEmail(eventBean.getUserEmail());
			userObj.setPhone(eventBean.getPhoneNumber());
			userObj.setStatus(WREConstants.ACTIVE_STATUS);
			userObj.setPassword(WREUtil.EncryptText(WREConstants.PASSWORD));
			AppIdentifier appIdentifier = new AppIdentifier();
			appIdentifier.setAppIdentifierId(WREConstants.ADMIN_ROLE);
			userObj.setAppIdentifier(appIdentifier);
			userObj.setClient(client);
			systemAdminMgmtDaoImpl.save(userObj);
		}else
		{
			userObj= new User();
			userObj.setUserId(eventBean.getUserId());
		}
		Event eventObj = new Event();
		
		eventObj.setEventName(eventBean.getEventName());
		eventObj.setEventDesc(eventBean.getEventDesc());
		eventObj.setEventAddress(eventBean.getEventAddress());
		eventObj.setEventAgenda(eventBean.getEventAgenda());
		eventObj.setEventTime(eventBean.getEventTime());
		eventObj.setStatus(WREConstants.ACTIVE_STATUS);
		eventObj.setEventDate(eventBean.getEventDate());
		eventObj.setUser(userObj);
		eventObj.setClient(client);
		Long eventId=(Long)systemAdminMgmtDaoImpl.save(eventObj);
		 eventBean.setEventId(eventId);
		for(String serid:eventBean.getServices()){
			
			Services service=new Services();
			service.setServiceId(Long.parseLong(serid));
			EventServices eventServices=new EventServices();
			eventServices.setEvent(eventObj);
			
			eventServices.setServices(service);
			log.info("service Id---"+service.getServiceId());
			systemAdminMgmtDaoImpl.save(eventServices);
			
		}
		return eventBean;
	}


	public List<ServicesBean> getServicesList() {
		
		List<Services>  servicesModelList = systemAdminMgmtDaoImpl.getServicesList();
		List<ServicesBean> servicesBeans = new ArrayList<ServicesBean>();
		
		for(Services services:servicesModelList){
			
			ServicesBean servicesBean = new ServicesBean();
			
			servicesBean.setServiceId(services.getServiceId());
			log.info("sas--"+servicesBean.getServiceId());
			servicesBean.setServiceName(services.getServiceName());
			servicesBean.setServiceDesc(services.getServiceDesc());
			servicesBean.setOrder(services.getOrder());
			servicesBeans.add(servicesBean);
		}
		return servicesBeans;
	}


	public EventBean getEventDetails(Long eventId) {
		Event eventEntity = systemAdminMgmtDaoImpl.getClientEventDetails(eventId);
		EventBean eventBean = null;
		if(eventEntity!= null){
			 eventBean = new EventBean();
			eventBean.setEventId(eventEntity.getEventId());
			eventBean.setEventName(eventEntity.getEventName());
			eventBean.setEventDesc(eventEntity.getEventDesc());
			eventBean.setEventAgenda(eventEntity.getEventAgenda());
			eventBean.setEventTime(eventEntity.getEventTime());
			eventBean.setEventAddress(eventEntity.getEventAddress());
			eventBean.setClientId(eventEntity.getClient().getClientId());
			
			eventBean.setEventDate(eventEntity.getEventDate());
		}
		
		return eventBean;
	}


	
	
	public List<EventServicesBean> getEventServicesList(Long eventId) {
		List<EventServices> eventServices = systemAdminMgmtDaoImpl.getEventServicesList(eventId);
		List<EventServicesBean> eventServicesBeans = new ArrayList<EventServicesBean>();
		for(EventServices eServices:eventServices){
			
			EventServicesBean eventServicesBean = new EventServicesBean();
			eventServicesBean.setEventServiceId(eServices.getEventServiceId());
			eventServicesBean.setServiceId(eServices.getServices().getServiceId());
			eventServicesBean.setServiceName(eServices.getServices().getServiceName());
			eventServicesBeans.add(eventServicesBean);
			
		}
			return eventServicesBeans;
		}

	public void updateEventDetails(EventBean eventBean) {
		Event event = systemAdminMgmtDaoImpl.getClientEventDetails(eventBean.getEventId());
		log.info("sdff"+event.getEventId());
		event.setEventId(eventBean.getEventId());
		event.setEventName(eventBean.getEventName());
		event.setEventAddress(eventBean.getEventAddress());
		event.setEventDesc(eventBean.getEventDesc());
		event.setEventDate(eventBean.getEventDate());
		event.setEventAgenda(eventBean.getEventAgenda());
		event.setEventTime(eventBean.getEventTime());
		systemAdminMgmtDaoImpl.update(event);
		systemAdminMgmtDaoImpl.deleteServices(event.getEventId());
		
  for(String serid:eventBean.getServices()){
			
			Services service=new Services();
			service.setServiceId(Long.parseLong(serid));
			EventServices eventServices=new EventServices();
			eventServices.setEvent(event);
			
			eventServices.setServices(service);
			log.info("service Id---"+service.getServiceId());
			systemAdminMgmtDaoImpl.save(eventServices);
			
		}
	}


	
	
	@Override
	public ParticipantBean getParticipantDetails(ParticipantBean participantBeanObj) {
		Participants participantObj = systemAdminMgmtDaoImpl.getParticipantDetails(participantBeanObj);
		ParticipantBean participantBean = new ParticipantBean();
		if(participantObj!=null){
		participantBean.setParticipantId(participantObj.getParticipantId());
		participantBean.setFirstName(participantObj.getFirstName());
		participantBean.setLastName(participantObj.getLastName());
		participantBean.setEmailId(participantObj.getEmail());
		participantBean.setOTP(participantObj.getOtp());
		participantBean.setPhoneNumber(participantObj.getPhone());
		participantBean.setStatus(participantObj.getStatus());
		participantBean.setRegisterId(participantObj.getRegId());
		}
		return participantBean;
	
	}


	@Override
	public List<ParticipantEventBean> getParticipantEventList(Long participantId) {
		List<EventParticipant> eventParticipants = systemAdminMgmtDaoImpl.getParticipantEventList(participantId);
		List<ParticipantEventBean> participantEventBeans = new ArrayList<ParticipantEventBean>();
		for(EventParticipant eventParticipant :eventParticipants){
			ParticipantEventBean participantEventBean = new ParticipantEventBean();
			participantEventBean.setParticipateEventId(eventParticipant.getEveParticipantId());
			participantEventBean.setEventId(eventParticipant.getEvent().getEventId());
			participantEventBean.setEventname(eventParticipant.getEvent().getEventName());
			participantEventBean.setEventDate(eventParticipant.getEvent().getEventDate());
			participantEventBean.setParticipantId(eventParticipant.getParticipants().getParticipantId());
			participantEventBean.setStatus(eventParticipant.getStatus());
			participantEventBeans.add(participantEventBean);
		}
		return participantEventBeans;
	}
	
}