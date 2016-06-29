package com.wre.adminmgmt.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.AppIdentifierBean;
import com.wre.adminmgmt.bean.ChatBean;
import com.wre.adminmgmt.bean.ChatTopicBean;
import com.wre.adminmgmt.bean.ContactDetailsBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.GalaryBean;
import com.wre.adminmgmt.bean.InviteBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.adminmgmt.bean.ParticipantQuriesBean;
import com.wre.adminmgmt.bean.QuestionAnswerBean;
import com.wre.adminmgmt.bean.QuestionBean;
import com.wre.adminmgmt.bean.RatingBean;
import com.wre.adminmgmt.bean.SocialMediaBean;
import com.wre.adminmgmt.bean.SpeakerBean;
import com.wre.adminmgmt.bean.SponsorBean;
import com.wre.adminmgmt.bean.SurveyQuestionAnswerBean;
import com.wre.adminmgmt.dao.AdminMgmtDao;
import com.wre.common.util.WREConstants;
import com.wre.common.util.WREUtil;
import com.wre.model.Agenda;
import com.wre.model.AppIdentifier;
import com.wre.model.ChatTopic;
import com.wre.model.ContactDetails;
import com.wre.model.Event;
import com.wre.model.EventParticipant;
import com.wre.model.EventServices;
import com.wre.model.Galary;
import com.wre.model.Newsfeed;
import com.wre.model.ParticipantQuries;
import com.wre.model.Participants;
import com.wre.model.Rating;
import com.wre.model.SocialMedia;
import com.wre.model.Speaker;
import com.wre.model.Sponcor;
import com.wre.model.SurveyQuestion;
import com.wre.model.SurveyQuestionAnswer;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.ParticipantEventBean;

@Service("AdminMgmtService")
public class AdminMgmtServiceImpl implements AdminMgmtService {

	private static final Log log = LogFactory
			.getLog(AdminMgmtServiceImpl.class);
	@Autowired
	@Qualifier(value = "AdminMgmtDao")
	private AdminMgmtDao AdminMgmtDaoImpl;

	// ==================Event Start============================================

	// this event view
	public List<EventBean> getEventList(Long userId) {
		List<Event> eventModelist = AdminMgmtDaoImpl.getEventList(userId);
		List<EventBean> eventbeanList = new ArrayList<EventBean>();
		for (Event event : eventModelist) {
			EventBean eventBean = new EventBean();
			eventBean.setEventId(event.getEventId());
			eventBean.setEventAddress(event.getEventAddress());
			eventBean.setEventDesc(event.getEventDesc());
			eventBean.setEventName(event.getEventName());
			eventBean.setEventAgenda(event.getEventAgenda());
			eventBean.setEventDate(event.getEventDate());
			eventBean.setStatus(event.getStatus());
			eventbeanList.add(eventBean);
		}
		log.info("list size is --+" + eventbeanList.size());
		return eventbeanList;
	}

	// this event save
	public void saveEvent(EventBean eventBean) {
		Event event = new Event();
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
		Event eventObj = new Event();
		eventObj.setEventName(eventBean.getEventName());

		eventObj.setEventAddress(eventBean.getEventAddress());
		eventObj.setEventDate(eventBean.getEventDate());
		eventObj.setEventDesc(eventBean.getEventDesc());
		eventObj.setEventId(eventBean.getEventId());
		eventObj.setStatus(eventBean.getStatus());
		AdminMgmtDaoImpl.update(eventObj);

	}

	// this is event list convert to eventSeviceList

	public List<EventBean> getEventDetailsList(Long eventId) {

		List<EventServices> eventServicesList = AdminMgmtDaoImpl
				.getEventDetails(eventId);
		List<EventBean> eventbeanList = new ArrayList<EventBean>();

		for (EventServices eventServicesObj : eventServicesList) {
			EventBean eventOjectBean = new EventBean();
			eventOjectBean.setEventId(eventServicesObj.getEvent().getEventId());
			eventOjectBean.setServiceId(eventServicesObj.getEvent()
					.getEventId());
			eventOjectBean.setEventName(eventServicesObj.getEvent()
					.getEventName());
			eventOjectBean.setEventAddress(eventServicesObj.getEvent()
					.getEventAddress());
			eventOjectBean.setEventAddress(eventServicesObj.getStatus());
			eventOjectBean.setServiceId(eventServicesObj.getServices()
					.getServiceId());
			eventOjectBean.setServiceName(eventServicesObj.getServices()
					.getServiceName());
			eventbeanList.add(eventOjectBean);
		}
		log.info("list size is --+" + eventbeanList.size());
		return eventbeanList;
	}

	// ==================Event End============================================

	// ==================Agendo
	// Start============================================

	// this is Createagndo
	public void createAgendo(AgendaBean agendaBean) {
		Agenda agenda = new Agenda();
		agenda.setAgenStartTime(agendaBean.getAgenStartTime());
		agenda.setAgenDesc(agendaBean.getAgenDesc());
		agenda.setAgenTitle(agendaBean.getAgenTitle());
		agenda.setAgenEndTime(agendaBean.getAgenEndTime());
		agenda.setAgenBy(agendaBean.getAgenBy());
		Event event = new Event();
		event.setEventId(agendaBean.getEventId());
		agenda.setEvent(event);
		AdminMgmtDaoImpl.save(agenda);

	}

	// this is agendaView list
	public List<AgendaBean> getAgendoDetails(Long eventId) {
		List<Agenda> agendaList = AdminMgmtDaoImpl.getAgendoDetails(eventId);
		List<AgendaBean> agendaBeanList = new ArrayList<AgendaBean>();
		for (Agenda agendaObj : agendaList) {
			AgendaBean agendaBean = new AgendaBean();
			agendaBean.setAgenId(agendaObj.getAgenId());
			agendaBean.setAgenTitle(agendaObj.getAgenTitle());
			agendaBean.setAgenDesc(agendaObj.getAgenDesc());
			agendaBean.setAgenStartTime(agendaObj.getAgenStartTime());
			agendaBean.setAgenEndTime(agendaObj.getAgenEndTime());
			agendaBean.setAgenBy(agendaObj.getAgenBy());
			agendaBeanList.add(agendaBean);
		}
		log.info("list size is --" + agendaBeanList.size());
		return agendaBeanList;
	}

	// agendo editedetails
	public AgendaBean agendoEditDetails(Long agenId) {
		AgendaBean agendaBean = null;

		Agenda agendaOject = AdminMgmtDaoImpl.agendoEditDetails(agenId);
		if (agendaOject != null) {
			agendaBean = new AgendaBean();
			agendaBean.setAgenId(agendaOject.getAgenId());
			agendaBean.setAgenBy(agendaOject.getAgenBy());
			agendaBean.setAgenDesc(agendaOject.getAgenDesc());
			agendaBean.setAgenStartTime(agendaOject.getAgenStartTime());
			agendaBean.setAgenEndTime(agendaOject.getAgenEndTime());
			agendaBean.setAgenTitle(agendaOject.getAgenTitle());
			agendaBean.setEventId(agendaOject.getEvent().getEventId());

		}
		log.info("title---" + agendaBean.getAgenTitle());
		return agendaBean;

	}

	// updateAgendo

	public void updateAgendo(AgendaBean agendaBean) {

		Agenda agendaOject = AdminMgmtDaoImpl.agendoEditDetails(agendaBean
				.getAgenId());
		agendaOject.setAgenBy(agendaBean.getAgenBy());
		agendaOject.setAgenDesc(agendaBean.getAgenDesc());
		agendaOject.setAgenEndTime(agendaBean.getAgenEndTime());
		agendaOject.setAgenStartTime(agendaBean.getAgenStartTime());
		agendaOject.setAgenTitle(agendaBean.getAgenTitle());

		AdminMgmtDaoImpl.update(agendaOject);
	}

	// ==============================Agendo
	// End============================================

	// =================================News
	// Start===========================================
	// NewsList
	public List<NewsFeedBean> getNewsList(Long eventId) {
		List<Newsfeed> newsList = AdminMgmtDaoImpl.getNewsList(eventId);
		List<NewsFeedBean> newsBeanList = new ArrayList<NewsFeedBean>();
		for (Newsfeed newsfeedOject : newsList) {
			NewsFeedBean newsFeedBean = new NewsFeedBean();
			newsFeedBean.setNewsFeedId(newsfeedOject.getNewsFeedId());
			newsFeedBean.setNewsDesc(newsfeedOject.getNewsDesc());
			newsFeedBean.setNewsTitle(newsfeedOject.getNewsTitle());
			newsFeedBean.setJsonDate(newsfeedOject.getNewsDate().toString());
			newsFeedBean.setNewsDate(newsfeedOject.getNewsDate());
			newsBeanList.add(newsFeedBean);
		}
		log.info("list size is --" + newsBeanList.size());
		return newsBeanList;
	}

	// NewsEdit
	public NewsFeedBean newsEditDetails(Long newsFeedId) {
		NewsFeedBean newsFeedBean = null;
		Newsfeed newsOjcet = AdminMgmtDaoImpl.newsEditDetails(newsFeedId);
		if (newsOjcet != null) {
			newsFeedBean = new NewsFeedBean();
			newsFeedBean.setNewsFeedId(newsOjcet.getNewsFeedId());
			newsFeedBean.setNewsDate(newsOjcet.getNewsDate());
			newsFeedBean.setNewsTitle(newsOjcet.getNewsTitle());
			newsFeedBean.setNewsDesc(newsOjcet.getNewsDesc());
			newsFeedBean.setEventId(newsOjcet.getEvent().getEventId());
		}
		log.info("NewsDesc---" + newsFeedBean.getNewsDesc());
		return newsFeedBean;
	}

	// saveNews
	public void saveNews(NewsFeedBean newsFeedBean) {
		Newsfeed newsfeed = new Newsfeed();
		newsfeed.setNewsTitle(newsFeedBean.getNewsTitle());
		newsfeed.setNewsDesc(newsFeedBean.getNewsDesc());
		newsfeed.setNewsDate(new Date());
		Event event = new Event();
		event.setEventId(newsFeedBean.getEventId());
		newsfeed.setEvent(event);
		AdminMgmtDaoImpl.save(newsfeed);
		log.info("saved news successfully");
	}

	// news update
	public void updateNews(NewsFeedBean newsFeedBean) {
		Newsfeed newsOjcet = AdminMgmtDaoImpl.newsEditDetails(newsFeedBean
				.getNewsFeedId());
		newsOjcet.setNewsTitle(newsFeedBean.getNewsTitle());
		newsOjcet.setNewsDesc(newsFeedBean.getNewsDesc());
		newsOjcet.setNewsDate(new Date());

		AdminMgmtDaoImpl.update(newsOjcet);
	}

	// ====================================News
	// End================================================

	// ====================================Galary
	// Start===========================================
	// galaryList
	public List<GalaryBean> galaryList(Long eventId, String type) {
		List<Galary> galaryList = AdminMgmtDaoImpl.galaryList(eventId, type);
		List<GalaryBean> galaryBeanList = new ArrayList<GalaryBean>();
		for (Galary galaryOject : galaryList) {
			GalaryBean galaryBeanOject = new GalaryBean();
			galaryBeanOject.setGlaryItemId(galaryOject.getGlaryItemId());
			galaryBeanOject.setName(galaryOject.getName());
			galaryBeanOject.setType(galaryOject.getType());
			galaryBeanOject.setEventId(galaryOject.getEvent().getEventId());
			galaryBeanOject.setFileName(galaryOject.getFileName());

			galaryBeanList.add(galaryBeanOject);

		}
		log.info("list size is --" + galaryBeanList.size());
		return galaryBeanList;
	}

	// Create Galery
	public void createGallery(MultipartFile file, Long eventId, String type,
			String name) {

		log.info("Enter into saveOrganizationApproveFile");
		String filePath = WREConstants.RESOURCE_PATH + eventId + WREConstants.FILE_SEPARATER
				+type+WREConstants.FILE_SEPARATER;
		if (file != null) {
			saveFile(file, filePath);
		}
		Galary galary = new Galary();
		galary.setName(name);
		galary.setType(type);
		galary.setFileName(file.getOriginalFilename());
		Event event = new Event();
		event.setEventId(eventId);
		galary.setEvent(event);
		AdminMgmtDaoImpl.save(galary);
		log.info("this is savenews successfully");
	}

	// get detailsView
	public EventBean detailsView(Long eventId,String type) {
		EventBean eventBeanOject = null;
		Event eventOject = AdminMgmtDaoImpl.detailsView(eventId);
		if (eventOject != null) {
			eventBeanOject = new EventBean();
			eventBeanOject.setEventId(eventOject.getEventId());
			eventBeanOject.setEventAddress(eventOject.getEventAddress());
			eventBeanOject.setEventAgenda(eventOject.getEventAgenda());
			eventBeanOject.setEventDesc(eventOject.getEventDesc());
			eventBeanOject.setEventName(eventOject.getEventName());
			if("app".equals(type)){
				eventBeanOject.setDate(eventOject.getEventDate().toString());
			}else{
				eventBeanOject.setEventDate(eventOject.getEventDate());
			}
			eventBeanOject.setClientId(eventOject.getClient().getClientId());
			eventBeanOject.setEventTime(eventOject.getEventTime());
			
		}

		return eventBeanOject;
	}

	// updateDetails
	public void updateDetails(EventBean eventBean) {
		Event eventObj = AdminMgmtDaoImpl.detailsView(eventBean.getEventId());
		eventObj.setEventName(eventBean.getEventName());
		eventObj.setEventAddress(eventBean.getEventAddress());
		eventObj.setEventDesc(eventBean.getEventDesc());
		eventObj.setEventAgenda(eventBean.getEventAgenda());
		AdminMgmtDaoImpl.update(eventObj);

	}

	void saveFile(MultipartFile file, String filePath) {

		log.info("Enter into saveFile(MultipartFile file, long practiceReqId,String filePath)"
				+ file);

		String name = file.getOriginalFilename();
		try {
			byte[] bytes = file.getBytes();
			// Creating the directory to store file
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ name);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

		} catch (Exception e) {
		}
		log.info("Exited from saveFile(MultipartFile file, long practiceReqId,String filePath)");

	}

	public void invite(InviteBean inviteBean) {

		String[] numbers = inviteBean.getPhone().split(",");
		for (String number : numbers) {
			Long participantId = AdminMgmtDaoImpl.checkMobileNumber(number);
			EventParticipant eventParticipant = new EventParticipant();
			Event eventObj = new Event();
			eventObj.setEventId(inviteBean.getEventId());
			eventParticipant.setEvent(eventObj);

			Participants participantsOject = new Participants();
			participantsOject.setParticipantId(participantId);

			eventParticipant.setParticipants(participantsOject);
			AdminMgmtDaoImpl.save(eventParticipant);

		}

	}

	// inviteList
	public List<InviteBean> inviteDetails(Long eventId) {
		List<Object[]> inviteList = AdminMgmtDaoImpl.inviteDetails(eventId);
		List<InviteBean> inviteBeanList = new ArrayList<InviteBean>();
		for (Object[] inviteOject : inviteList) {
			InviteBean inviteBeanOject = new InviteBean();
			inviteBeanOject.setParticipantId(((BigInteger) inviteOject[0])
					.longValue());
			inviteBeanOject.setFirstName((String) inviteOject[1]);
			inviteBeanOject.setLastName((String) inviteOject[2]);
			inviteBeanOject.setPhone((String) inviteOject[3]);
			inviteBeanOject.setStatus((String) inviteOject[4]);
			inviteBeanOject.setEmail((String) inviteOject[5]);
			inviteBeanList.add(inviteBeanOject);

		}
		log.info("list size is ---" + inviteBeanList.size());

		return inviteBeanList;
	}

	// deleteGallery
	public void deleteGallery(Long glaryItemId) {
		boolean status = false;
		log.info("Entered into deleteGallery method");
		Galary galary = new Galary();
		galary.setGlaryItemId(glaryItemId);
		AdminMgmtDaoImpl.delete(galary);

	}

	// questionBeanList
	public List<QuestionBean> questionList(Long eventId) {
		List<SurveyQuestion> surveyList = AdminMgmtDaoImpl
				.questionList(eventId);
		List<QuestionBean> questionBeanList = new ArrayList<QuestionBean>();
		for (SurveyQuestion surveyOject : surveyList) {
			QuestionBean questionBeanOject = new QuestionBean();
			questionBeanOject.setQuestionId(surveyOject.getQuestionId());
			questionBeanOject.setOptionA(surveyOject.getOptionA());
			questionBeanOject.setOptionB(surveyOject.getOptionB());
			questionBeanOject.setOptionC(surveyOject.getOptionC());
			questionBeanOject.setOptionD(surveyOject.getOptionD());
			questionBeanOject.setAnswer(surveyOject.getAnswer());
			questionBeanOject.setQuestion(surveyOject.getQuestion());
			questionBeanOject.setAppIdentifierId(surveyOject.getAppIdentifier()
					.getAppIdentifierId());
			questionBeanOject.setAppIdentifierName(surveyOject
					.getAppIdentifier().getIdentifierName());
			questionBeanList.add(questionBeanOject);
		}
		log.info("list size is --" + questionBeanList.size());
		return questionBeanList;
	}

	@Override
	public List<AppIdentifierBean> appList(Long appId) {
		List<AppIdentifier> applist = AdminMgmtDaoImpl.appList(appId);
		List<AppIdentifierBean> appIdentifierBeanList = new ArrayList<AppIdentifierBean>();
		for (AppIdentifier appIdentifierObj : applist) {
			AppIdentifierBean appIdentifierBeanObj = new AppIdentifierBean();
			appIdentifierBeanObj.setAppIdentifierId(appIdentifierObj
					.getAppIdentifierId());
			appIdentifierBeanObj.setIdentifierName(appIdentifierObj
					.getIdentifierName());
			appIdentifierBeanList.add(appIdentifierBeanObj);
		}
		return appIdentifierBeanList;
	}

	// questionCreate
	public void questionCreate(QuestionBean questionBean) {
		SurveyQuestion surveyQuestion = new SurveyQuestion();
		surveyQuestion.setQuestion(questionBean.getQuestion());
		surveyQuestion.setOptionA(questionBean.getAnswer());
		surveyQuestion.setOptionB(questionBean.getOptionB());
		surveyQuestion.setOptionC(questionBean.getOptionC());
		surveyQuestion.setOptionD(questionBean.getOptionD());
		surveyQuestion.setAnswer(questionBean.getAnswer());
		

		Event event = new Event();
		event.setEventId(questionBean.getEventId());
		surveyQuestion.setEvent(event);

		AppIdentifier appIdentifierObj = new AppIdentifier();
		appIdentifierObj.setAppIdentifierId(questionBean.getAppIdentifierId());
		surveyQuestion.setAppIdentifier(appIdentifierObj);

		// AdminMgmtDaoImpl.save(surveyQuestion);
		AdminMgmtDaoImpl.saveOrUpdate(surveyQuestion);
		log.info("this is savequestion successfully");

	}

	// questionEdit
	public QuestionBean questionEdit(Long questionId) {
		QuestionBean questionBeanOject = null;
		SurveyQuestion surveyQuestion = AdminMgmtDaoImpl
				.questionEdit(questionId);
		if (surveyQuestion != null) {

			questionBeanOject = new QuestionBean();
			questionBeanOject.setQuestionId(surveyQuestion.getQuestionId());
			questionBeanOject.setOptionA(surveyQuestion.getOptionA());
			questionBeanOject.setOptionB(surveyQuestion.getOptionB());
			questionBeanOject.setOptionC(surveyQuestion.getOptionC());
			questionBeanOject.setOptionD(surveyQuestion.getOptionD());
			questionBeanOject.setAnswer(surveyQuestion.getAnswer());
			questionBeanOject.setQuestion(surveyQuestion.getQuestion());
			questionBeanOject
					.setEventId(surveyQuestion.getEvent().getEventId());
			questionBeanOject.setAppIdentifierId(surveyQuestion
					.getAppIdentifier().getAppIdentifierId());
			questionBeanOject.setAppIdentifierName(surveyQuestion
					.getAppIdentifier().getIdentifierName());

		}
		log.info("OptionA---" + questionBeanOject.getOptionA());
		return questionBeanOject;
	}

	// updateQuestionDetails
	public void updateQuestionDetails(QuestionBean questionBean) {
		
		log.info("question data"+questionBean.toString());
		SurveyQuestion surveyQuestionOject = AdminMgmtDaoImpl
				.questionEdit(questionBean.getQuestionId());

		surveyQuestionOject.setOptionA(questionBean.getOptionA());
		surveyQuestionOject.setOptionB(questionBean.getOptionB());
		surveyQuestionOject.setOptionC(questionBean.getOptionC());
		surveyQuestionOject.setOptionD(questionBean.getOptionD());
		surveyQuestionOject.setAnswer(questionBean.getAnswer());
		surveyQuestionOject.setQuestion(questionBean.getQuestion());

		AdminMgmtDaoImpl.update(surveyQuestionOject);
	}

	// =======================sponsor start=========================
	/*********** By Taraq *************/

	@Override
	public List<SponsorBean> getSponsorsList(Long eventId) {
		// Get the Sponsors list based on the event id passed
		log.info("In getSponsorsList====" + eventId);
		List<Sponcor> sponcorList = AdminMgmtDaoImpl.getSponcorsList(eventId);
		// we are getting the list as Sponcor which is entity
		List<SponsorBean> sponsorBeanList = new ArrayList<SponsorBean>();
		log.info("sponcorlist size is --" + sponcorList.size());
		log.info("before for each");
		for (Sponcor sponcorObject : sponcorList) {
			SponsorBean sponsorBean = new SponsorBean();
			sponsorBean.setEventId(sponcorObject.getEvent().getEventId());
			sponsorBean.setEventName(sponcorObject.getEvent().getEventName());
			sponsorBean.setSponcorId(sponcorObject.getSponcorId());
			sponsorBean.setSponcorDesc(sponcorObject.getSponcorDesc());
			sponsorBean.setSponcorName(sponcorObject.getSponcorName());
			sponsorBean.setFileName(sponcorObject.getFileName());
			sponsorBeanList.add(sponsorBean);
		}

		log.info("sponcorBeanlist size is --" + sponsorBeanList);

		return sponsorBeanList;
	}

	@Override
	public void createSponsor(MultipartFile file, Long eventId, String type,
			String sponcorDesc, String sponcorName) {
		
		
		log.info("Entered into createSponsor method");
		
		String filePath = WREConstants.RESOURCE_PATH + eventId + File.separator
				+type+File.separator;

			
			if (file != null) {
				try {
					String name = file.getOriginalFilename();
					byte[] bytes = file.getBytes();
					// Creating the directory to store file
					File dir = new File(filePath);

					if (!dir.exists()) {
						dir.mkdirs();
					}
					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath() + WREConstants.FILE_SEPARATER
							+name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

				} catch (Exception e) {
					
				}
				}

		

		Sponcor sponcor = new Sponcor();
		
		sponcor.setSponcorName(sponcorName);
		sponcor.setSponcorDesc(sponcorDesc);
		sponcor.setFileName(file.getOriginalFilename());
		Event  event= new Event();
		event.setEventId(eventId);
		sponcor.setEvent(event);

		AdminMgmtDaoImpl.save(sponcor);
		log.info("this is sponcor successfully");

	}
	
	
	@Override
	public SponsorBean getSponsorForEdit(Long sponcorId) {

		SponsorBean sponsorBeanObject = null;
		Sponcor sponsorObject = AdminMgmtDaoImpl
				.getSponsorBySponsorId(sponcorId);

		if (sponsorObject != null) {
			sponsorBeanObject = new SponsorBean();
			sponsorBeanObject.setEventId(sponsorObject.getEvent().getEventId());
			sponsorBeanObject.setSponcorName(sponsorObject.getSponcorName());
			sponsorBeanObject.setSponcorId(sponsorObject.getSponcorId());
			sponsorBeanObject.setSponcorDesc(sponsorObject.getSponcorDesc());
			sponsorBeanObject.setFileName(sponsorObject.getFileName());
		}

		return sponsorBeanObject;

		// return null;
	}

	/* Update the Sponsor Data */
	public void updateSponsor(MultipartFile file,Long eventId,String type,String sponcorName,String sponcorDesc,Long sponcorId) {
		
		 log.info("Entered into createSponsor method");
			
			String filePath = WREConstants.RESOURCE_PATH + eventId + File.separator
					+type+File.separator;

			if (file != null) {

				try {
					byte[] bytes = file.getBytes();
					// Creating the directory to store file
					File dir = new File(filePath);

					if (!dir.exists()) {
						dir.mkdirs();
					}
					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath() + File.separator
							+"sponcor.png");
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

				} catch (Exception e) {
				}

			}

			Sponcor sponcor = AdminMgmtDaoImpl.getSponsorBySponsorId(sponcorId);


			
			sponcor.setSponcorName(sponcorName);
			sponcor.setSponcorDesc(sponcorDesc);
	
			if(file!=null){
				sponcor.setFileName(file.getOriginalFilename());
			}
			log.info("SerImpl...sponcor bean saving....."
					+ sponcor.getSponcorName());
			AdminMgmtDaoImpl.update(sponcor);
			
		

	}

	@Override
	public List<SpeakerBean> getSpeakersList(Long eventId) {

		List<Speaker> sl = AdminMgmtDaoImpl.getSpeakersList(eventId);
		log.info("----getSpeakersList servImpl---" + sl.size());
		// SpeakerBean sb=new SpeakerBean();
		List<SpeakerBean> speakerBeanList = new ArrayList<SpeakerBean>();

		for (Speaker s : sl) {
			SpeakerBean sb = new SpeakerBean();
			sb.setEventId(s.getEvent().getEventId());
			sb.setSpeakerId(s.getSpeakerId());
			sb.setSpeakerName(s.getSpeakerName());
			sb.setDesc(s.getDescription());
			sb.setLocation(s.getLocation());
			sb.setFileName(s.getFileName());
			sb.setRating(s.getRating());
			sb.setTitle(s.getTitle());

			log.info(s.getDescription() + "speaker bean--" + sb.toString());
			speakerBeanList.add(sb);
		}
		log.info("sp bean list size===" + speakerBeanList.size());
		return speakerBeanList;
	}

	@Override
	public void createSpeaker(MultipartFile file,Long eventId,String type,String speakerName, String location,String title,String description,String rating) {

		
		log.info("Entered into createSponsor method");
		
		String filePath = WREConstants.RESOURCE_PATH + eventId + WREConstants.FILE_SEPARATER
				+type+WREConstants.FILE_SEPARATER;

		if (file != null) {
			try {
				String name = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				File dir = new File(filePath);

				if (!dir.exists()) {
					dir.mkdirs();
				}
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + WREConstants.FILE_SEPARATER
						+name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
			}

		}

		Speaker speaker = new Speaker();
		Event event = new Event();
		event.setEventId(eventId);

		speaker.setEvent(event);
		speaker.setSpeakerName(speakerName);
		speaker.setLocation(location);
		speaker.setTitle(title);
		speaker.setDescription(description);
		speaker.setFileName(file.getOriginalFilename());
		speaker.setRating(rating);

		log.info("SerImpl...speaker bean saving....."
				+ speaker.getDescription());
		AdminMgmtDaoImpl.save(speaker);
	}

	// get speaker for edit by id
	@Override
	public SpeakerBean getSpeakerBySpeakerId(Long speakerId) {
		log.info("in getSpeBySpId=servc==" + speakerId);
		SpeakerBean sp = new SpeakerBean();
		Speaker speakerObject = AdminMgmtDaoImpl
				.getSpeakerBySpeakerId(speakerId);
		log.info("desc......." + speakerObject.getDescription());
		if (speakerObject != null) {
			sp.setEventId(speakerObject.getEvent().getEventId());
			sp.setSpeakerId(speakerObject.getSpeakerId());
			sp.setSpeakerName(speakerObject.getSpeakerName());
			sp.setDesc(speakerObject.getDescription());
			sp.setLocation(speakerObject.getLocation());
			sp.setRating(speakerObject.getRating());
			sp.setTitle(speakerObject.getTitle());
			sp.setFileName(speakerObject.getFileName());

		}
		log.info(speakerObject.getDescription() + "speaker for edit....."
				+ sp.toString());
		return sp;
	}

	@Override
	public void udpateSpeaker(MultipartFile file,Long eventId,String type,String speakerName, String location,String title,String description,String rating,Long speakerId) {

      log.info("Entered into createSponsor method");
		
		String filePath = WREConstants.RESOURCE_PATH + eventId + File.separator
				+type+File.separator;

		if (file != null) {

			try {
				String name = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				File dir = new File(filePath);

				if (!dir.exists()) {
					dir.mkdirs();
				}
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator
						+name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
			}

		}

        Speaker speaker = AdminMgmtDaoImpl.getSpeakerBySpeakerId(speakerId);


		speaker.setSpeakerName(speakerName);
		speaker.setLocation(location);
		speaker.setTitle(title);
		speaker.setDescription(description);
		speaker.setRating(rating);
		if(file!=null){
		speaker.setFileName(file.getOriginalFilename());
		}
		log.info("SerImpl...speaker bean saving....."
				+ speaker.getDescription());
		AdminMgmtDaoImpl.update(speaker);
		
	}

	// uploadVenuLayout
	public void uploadVenuLayout(MultipartFile file, Long eventId, String type) {

		log.info("Enter into uploadVenueLayout");
		String filePath = WREConstants.RESOURCE_PATH + eventId + File.separator
				+ type;

		if (file != null) {

			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				File dir = new File(filePath);

				if (!dir.exists()) {
					dir.mkdirs();
				}
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + "layout.png");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
			}

		}

	}

	public List<ChatBean> getUser(String mobno) {
		List<Participants> participantsList = AdminMgmtDaoImpl.getUser(mobno);
		List<ChatBean> chatBeanList = new ArrayList<ChatBean>();

		for (Participants participants : participantsList) {
			ChatBean chatBean = new ChatBean();
			chatBean.setMobno(participants.getPhone());
			chatBean.setName(participants.getFirstName());
			chatBean.setReg_id(participants.getRegId());
			chatBeanList.add(chatBean);
		}

		return chatBeanList;
	}

	@Override
	public void uploadEventImage(MultipartFile file, Long eventId, String type) {
		log.info("Enter into saveOrganizationApproveFile");
		String filePath = WREConstants.RESOURCE_PATH + eventId + File.separator
				+ type;

		if (file != null) {

			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				File dir = new File(filePath);

				if (!dir.exists()) {
					dir.mkdirs();
				}
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
			}

		}

		
	}
	public String participantRegUpdate(ParticipantBean participantBean){
		return AdminMgmtDaoImpl.participantRegUpdate(participantBean);
	}
	@Override
	public List<EventBean> geteventServicesList(Long eventId) {
		

			List<EventServices> eventServicesList = AdminMgmtDaoImpl
					.geteventServicesList(eventId);
			List<EventBean> eventbeanList = new ArrayList<EventBean>();

			for (EventServices eventServicesObj : eventServicesList) {
				EventBean eventOjectBean = new EventBean();
				eventOjectBean.setEventId(eventServicesObj.getEvent().getEventId());
				eventOjectBean.setServiceId(eventServicesObj.getEvent()
						.getEventId());
				eventOjectBean.setEventName(eventServicesObj.getEvent()
						.getEventName());
				eventOjectBean.setEventAddress(eventServicesObj.getEvent()
						.getEventAddress());
				eventOjectBean.setEventAddress(eventServicesObj.getStatus());
				eventOjectBean.setServiceId(eventServicesObj.getServices()
						.getServiceId());
				eventOjectBean.setServiceName(eventServicesObj.getServices()
						.getServiceName());
				eventOjectBean.setOrder(eventServicesObj.getServices().getOrder());
				eventbeanList.add(eventOjectBean);
			}
			log.info("list size is --+" + eventbeanList.size());
			return eventbeanList;
		}
	

	//=================rating
		@SuppressWarnings("unused")
		@Override
		public String saveUserRating(RatingBean ratingBean) {

			log.info("save RatingBean....." + ratingBean.toString());
			Rating ratingByUserId=AdminMgmtDaoImpl.getRatingById(ratingBean.getUserId());
			
			Rating rating=new Rating();

			String result="fail";
			//long i=(Long)AdminMgmtDaoImpl.saveOrUpdate(rating);
			rating.setEventId(ratingBean.getEventId());
			rating.setRatingId(ratingBean.getRatingId());
			rating.setSourceId(ratingBean.getSourceId());
			rating.setType(ratingBean.getType());
			rating.setUserId(ratingBean.getUserId());
			rating.setRating(ratingBean.getRating());
			
			if(ratingByUserId==null){
				long i=(Long)AdminMgmtDaoImpl.save(rating);
				if(i>0){
					result="success";
				}
			}else{
				//log.info("rating By UserID--"+ratingByUserId.getUserId());
				rating.setRatingId(ratingByUserId.getRatingId());
				AdminMgmtDaoImpl.update(rating);
				result="success";
			}
			log.info("Rating Saved..");
			return result;
		}


		@Override
		public List<RatingBean> getUserRatings(RatingBean ratingBean) {
			//gets each user rating as a list
			log.info("In getUserRatings====");
			List<Rating> ratingList = AdminMgmtDaoImpl.getUserRatingList(ratingBean);
			log.info("rating entity list"+ratingList.size());
			
			// we are getting the list as Sponcor which is entity
			List<RatingBean> ratingBeanList = new ArrayList<RatingBean>();
			
			//log.info("before for each");
			for (Rating ratingObject : ratingList) {
				
				ratingBean.setEventId(ratingObject.getEventId());
				ratingBean.setRatingId(ratingObject.getRatingId());
				ratingBean.setSourceId(ratingObject.getSourceId());
				ratingBean.setType(ratingObject.getType());
				ratingBean.setUserId(ratingObject.getUserId());
				ratingBeanList.add(ratingBean);
			}

			log.info("ratingBeanlist size is --" + ratingBeanList.size());

			return ratingBeanList;
			
		}


		@Override
		public List<RatingBean> getUserRatings(Long eventId) {
			//gets each user rating as a list
					log.info("In getUserRatingsBy EventId====");
					
					List<Rating> ratingList = AdminMgmtDaoImpl.getUserRatingList(eventId);
					log.info("rating entity list"+ratingList.size());
					
					// we are getting the list as Sponcor which is entity
					List<RatingBean> ratingBeanList = new ArrayList<RatingBean>();
					RatingBean ratingBean = new RatingBean();
					//log.info("before for each");
					for (Rating ratingObject : ratingList) {
						
						ratingBean.setEventId(ratingObject.getEventId());
						ratingBean.setRatingId(ratingObject.getRatingId());
						ratingBean.setSourceId(ratingObject.getSourceId());
						ratingBean.setType(ratingObject.getType());
						ratingBean.setUserId(ratingObject.getUserId());
						ratingBeanList.add(ratingBean);
					}
					return ratingBeanList;
		}


		@SuppressWarnings("null")
		@Override
		public List<ContactDetailsBean> adminViewContactDetails(Long eventId) {
			//get contact details to view by admin
			log.info("in adminViewContactDetails seviceImpls"+eventId);;
			List<ContactDetails> contactDetailsListEntity=AdminMgmtDaoImpl.adminViewContactDetails(eventId);
			List<ContactDetailsBean> contactDetailsBeanList=new ArrayList<ContactDetailsBean>();
		
			
			if(contactDetailsListEntity.size()>0){
				ContactDetailsBean contactDetailsBean=new ContactDetailsBean();
				for(ContactDetails contactDetails:contactDetailsListEntity)
				{
					contactDetailsBean.setContactId(contactDetails.getContactId());
					contactDetailsBean.setContactName(contactDetails.getContactName());
					contactDetailsBean.setContactMobile(contactDetails.getContactMobile());
					contactDetailsBean.setContactAlternateMobile(contactDetails.getContactAlternateMobile());
					contactDetailsBean.setContactEmail(contactDetails.getContactEmail());
					contactDetailsBean.setEventId(contactDetails.getEvent().getEventId());
					contactDetailsBeanList.add(contactDetailsBean);
					}
			}
			return contactDetailsBeanList;
		}


		@Override
		//public List<ContactDetailsBean> getContactDetailsForEdit(Long contactId) {
		public ContactDetailsBean getContactDetailsForEdit(Long contactId) {
			//get contact details to view by admin
			log.info("in adminGetContactDetailsForEdit seviceImpls"+contactId);;
			//List<ContactDetails> contactDetailsList=AdminMgmtDaoImpl.getContactDetailsForEdit(contactId);
			ContactDetails contactDetails=AdminMgmtDaoImpl.getContactDetailsForEdit(contactId);
			
			//set to contact details bean
			ContactDetailsBean contactDetailsBean = new ContactDetailsBean();
			contactDetailsBean .setContactId(contactDetails.getContactId());
			contactDetailsBean.setContactName(contactDetails.getContactName());
			contactDetailsBean.setContactEmail(contactDetails.getContactEmail());
			contactDetailsBean.setContactMobile(contactDetails.getContactMobile());
			contactDetailsBean.setContactAlternateMobile(contactDetails.getContactAlternateMobile());
			contactDetailsBean.setEventId(contactDetails.getEvent().getEventId());
			log.info("contact Name....."+contactDetails.getContactName()+"contact mobile."+contactDetails.getContactMobile());
			//return contactDetailsBeanList;
			return contactDetailsBean;
		}

		@Override 
		public String updateContactDetails(ContactDetailsBean contactDetailsBean)
		{
			log.info("in updateContactDetails..");
			ContactDetails contactDetails=new ContactDetails();
			//contactDetails.setContactId(contactDetailsBean.getContactId());
			contactDetails.setContactName(contactDetailsBean.getContactName());
			contactDetails.setContactEmail(contactDetailsBean.getContactEmail());
			contactDetails.setContactMobile(contactDetailsBean.getContactMobile());
			contactDetails.setContactAlternateMobile(contactDetailsBean.getContactAlternateMobile());
				Event event=new Event();
				event.setEventId(contactDetailsBean.getEventId());
			contactDetails.setEvent(event);
				Participants participant=new Participants();
				participant.setParticipantId(contactDetailsBean.getParticipantId());
			contactDetails.setParticipants(participant);
			contactDetails.setHelpText(contactDetailsBean.getHelpText());
			//AdminMgmtDaoImpl.update(contactDetails);
			 long r=(Long)AdminMgmtDaoImpl.save(contactDetails);
			String result="";
			log.info("save help details.."+r);
			if(r>0)
			{
				result="success";
			}
			else{
				result="fail";
			}
			return result;
		}
		
		@Override 
		public void saveContactDetails(ContactDetailsBean contactDetailsBean)
		{
			log.info("in save contactdetails serviceimpl...");
			ContactDetails contactDetails=new ContactDetails();
			contactDetails.setContactName(contactDetailsBean.getContactName());
			contactDetails.setContactEmail(contactDetailsBean.getContactEmail());
			contactDetails.setContactMobile(contactDetailsBean.getContactMobile());
			contactDetails.setContactAlternateMobile(contactDetailsBean.getContactAlternateMobile());
			Event event=new Event();
			event.setEventId(contactDetailsBean.getEventId());
			contactDetails.setEvent(event);
			AdminMgmtDaoImpl.save(contactDetails);
		}
		
		//chat_topic List
		@Override
		public List<ChatTopicBean> getChatTopicList(Long eventId) {
			List<ChatTopic> chatTopicList = AdminMgmtDaoImpl.getChatTopicList(eventId);
			List<ChatTopicBean> chatTopicBeanList = new ArrayList<ChatTopicBean>();
			for(ChatTopic chatTopics:chatTopicList)
			{
				ChatTopicBean chatTopicBean  = new ChatTopicBean();
				chatTopicBean.setChatTopicId(chatTopics.getTopicId());
				chatTopicBean.setChatTopicName(chatTopics.getTopic());
				chatTopicBean.setEventId(chatTopics.getEvent().getEventId());
				chatTopicBeanList.add(chatTopicBean);
			}
			return chatTopicBeanList;
		}
		
		//chat_topic Save method
		@Override
		public void saveChatTopic(ChatTopicBean chatTopicBean) {
			ChatTopic chatTopic = new ChatTopic();
			chatTopic.setTopic(chatTopicBean.getChatTopicName());
			Event event = new Event();
			event.setEventId(chatTopicBean.getEventId());
			chatTopic.setEvent(event);
			AdminMgmtDaoImpl.save(chatTopic);
		}
		//chat_topic getdetailsmethod
		@Override
		public ChatTopicBean getChatTopicDetails(Long chatTopicId) {
			ChatTopicBean chatTopicBean = null;
			ChatTopic chatTopicEntity = AdminMgmtDaoImpl.getChatTopicDetails(chatTopicId);
			if(chatTopicEntity!=null){
				chatTopicBean = new ChatTopicBean();
				chatTopicBean.setChatTopicId(chatTopicEntity.getTopicId());
				chatTopicBean.setChatTopicName(chatTopicEntity.getTopic());
				chatTopicBean.setEventId(chatTopicEntity.getEvent().getEventId());
			}
			return chatTopicBean;
		}
	//chat_topic UpdateMethod
		@Override
		public void chatTopicUpdate(ChatTopicBean chatTopicBean) {
			
			 AdminMgmtDaoImpl.getChatTopicDetails(chatTopicBean.getChatTopicId());
			
				
			ChatTopic chatTopicObj = new ChatTopic();
			chatTopicObj.setTopic(chatTopicBean.getChatTopicName());
			chatTopicObj.setTopicId(chatTopicBean.getChatTopicId());
			log.info("sdsd");
			Event event = new Event();
			event.setEventId(chatTopicBean.getEventId());
			chatTopicObj.setEvent(event);
			AdminMgmtDaoImpl.update(chatTopicObj);
			
		}
	
		@Override
		public void chatTopicDelete(Long chatTopicId) {
			
			ChatTopic chatTopicObj = new ChatTopic();
			chatTopicObj.setTopicId(chatTopicId);
			AdminMgmtDaoImpl.delete(chatTopicObj);
			log.info("delete chatTopic ServiceImpl");
			
		}
		
		
		//getParticipantEventBeanList
		public List<ParticipantEventBean> getParticipantEventBeanList(Long eventId,String status) {
			List<Object[]> eventParticipantList=AdminMgmtDaoImpl.getParticipantEventBeanList(eventId,status);
			List<ParticipantEventBean> participantEventBeanList=new ArrayList<ParticipantEventBean>();
			for(Object[] eventParticipantOject:eventParticipantList){
				ParticipantEventBean participantEventBeanOject=new ParticipantEventBean();
				participantEventBeanOject.setEventId(((BigInteger)eventParticipantOject[0]).longValue());
				participantEventBeanOject.setEventname((String)eventParticipantOject[1]);
				participantEventBeanOject.setFirstName((String)eventParticipantOject[2]);
				participantEventBeanOject.setLastName((String)eventParticipantOject[3]);
				participantEventBeanOject.setMobile((String)eventParticipantOject[4]);
				participantEventBeanOject.setEmailId((String)eventParticipantOject[5]);
				participantEventBeanOject.setStatus((String)eventParticipantOject[6]);
			    participantEventBeanOject.setParticipantId(((BigInteger)eventParticipantOject[7]).longValue());
			    participantEventBeanOject.setParticipateEventId(((BigInteger)eventParticipantOject[8]).longValue());
			    
		        participantEventBeanList.add(participantEventBeanOject);
			}
			log.info("eventParticipantList size is --+" + participantEventBeanList.size());
			return participantEventBeanList;
		}
		
		
		
	   //eventParticipantCreate
		public void eventParticipantSave(ParticipantEventBean participantEventBean) {
			AdminMgmtDaoImpl.eventParticipantSave(participantEventBean);
			
		}
		
		
		@Override 
		public String saveSurveyQuestionAnswer(QuestionBean questionBean)
		{
			log.info("in save SaveSurveyQuestionAnswer serviceimpl.."+questionBean.toString());
			
			List<QuestionAnswerBean> questionAnswerBeanList=questionBean.getqAList();
			
			log.info("QuestionAnswerBean List Size"+questionAnswerBeanList.size());
			//long s=0,k;
			if(questionAnswerBeanList.size()>0){
			for(QuestionAnswerBean questionAnswerBean:questionAnswerBeanList){
				//put the below login here
					SurveyQuestionAnswer surveyQuestionAnswer=new SurveyQuestionAnswer();
					Event event=new Event();
					event.setEventId(questionBean.getEventId());
				surveyQuestionAnswer.setEvent(event);//set event
					SurveyQuestion surveyQuestion=new SurveyQuestion();
					surveyQuestion.setQuestionId(questionAnswerBean.getqId());//get question id from QABean
				surveyQuestionAnswer.setSurveyQuestion(surveyQuestion);//set question
					Participants participant=new Participants();
					participant.setParticipantId(questionBean.getParticipantId());
				surveyQuestionAnswer.setParticipants(participant);//set participant
				surveyQuestionAnswer.setParticipantAnswer(questionAnswerBean.getAnswer());//set participant answer(from QABean)
				
				 //k=(Long)AdminMgmtDaoImpl.saveOrUpdate(surveyQuestionAnswer);
				AdminMgmtDaoImpl.saveOrUpdate(surveyQuestionAnswer);
				/*if(k>0){
					s++;
				}*/
			}//if s is equal to questionBeanList.size() then return success
			}
			
			//log.info("saveSurveyQA-saved-size"+s);
			String result="fail";
			//	if(s==questionAnswerBeanList.size()){
			result="success";
			/*}*/
			return result;
			
			/*
			SurveyQuestionAnswer surveyQuestionAnswer=new SurveyQuestionAnswer();
				Event event=new Event();
				event.setEventId(questionBean.getEventId());
			surveyQuestionAnswer.setEvent(event);//set event
				SurveyQuestion surveyQuestion=new SurveyQuestion();
				surveyQuestion.setQuestionId(questionBean.getQuestionId());
			surveyQuestionAnswer.setSurveyQuestion(surveyQuestion);//set question
				Participants participant=new Participants();
				participant.setParticipantId(questionBean.getParticipantId());
			surveyQuestionAnswer.setParticipants(participant);//set participant
			surveyQuestionAnswer.setParticipantAnswer(questionBean.getAnswer());//set participant answer
			
			long i=(Long)AdminMgmtDaoImpl.save(surveyQuestionAnswer);
			log.info("saveSurveyQA--"+i);*/
			
		}

		@Override
		public List<ParticipantBean> getParticipantsList(Long eventId){
			log.info("in getParticipantsList..SerImpl");
			
			List<Object[]> participantsList= AdminMgmtDaoImpl.getParticipantsList(eventId);
			List<ParticipantBean> participantsBeanList=new ArrayList<ParticipantBean>();
			for(Object[] participant: participantsList){
				ParticipantBean participantBean=new ParticipantBean();
				log.info(participant[0]+"--"+participant[1]+"=="+participant[2]);
					participantBean.setParticipantId(((BigInteger)participant[0]).longValue());
					participantBean.setFirstName((String)participant[1]);
					participantBean.setEmailId((String)participant[2]);
					
				participantsBeanList.add(participantBean);
			}
			return participantsBeanList;
		}
		
		@Override
		public List<SurveyQuestionAnswerBean> getParticipantsAnswers(Long eventId,Long participantId){
			log.info("in getParticipantsAnswers..SerImpl");
			
			List<Object[]> surveyQAList= AdminMgmtDaoImpl.getParticipantsAnswersList(eventId,participantId);
			
			
			List<SurveyQuestionAnswerBean> surveyQuestionAnswerList=new ArrayList<SurveyQuestionAnswerBean>();
			
			for(Object[] surveyQA: surveyQAList){
				SurveyQuestionAnswerBean surveyQuestionAnswerBean=new SurveyQuestionAnswerBean();
					log.info(surveyQA[0]+"--"+surveyQA[1]+"=="+surveyQA[2]);
						SurveyQuestion surveyQuestion=new SurveyQuestion();
						surveyQuestion.setQuestion((String)surveyQA[0]);
					surveyQuestionAnswerBean.setSurveyQuestion(surveyQuestion);
					surveyQuestionAnswerBean.setAnswer((String)surveyQA[1]);
					surveyQuestionAnswerBean.setParticipantAnswer((String)surveyQA[2]);
					
				surveyQuestionAnswerList.add(surveyQuestionAnswerBean);
			}
			return surveyQuestionAnswerList;
			//return null;
		}
		
		public List<SocialMediaBean> getSocialMediaList(Long eventId){
			log.info("in serviceImpl..getSocialMediaList.."+eventId);
			List<SocialMedia> socialMediaList=AdminMgmtDaoImpl.getSocialMediaList(eventId);
			log.info("got sm list.."+socialMediaList.size());
			List<SocialMediaBean> socialMediaBeanList=new ArrayList<SocialMediaBean>();
			for(SocialMedia socialMedia:socialMediaList)
			{
				SocialMediaBean socialMediaBean=new SocialMediaBean();
					socialMediaBean.setSocialId(socialMedia.getSocialId());
					socialMediaBean.setName(socialMedia.getName());
					socialMediaBean.setUrl(socialMedia.getUrl());
					socialMediaBean.setType(socialMedia.getType());
					socialMediaBean.setEventId(socialMedia.getEvent().getEventId());
				socialMediaBeanList.add(socialMediaBean);
			}
			
			return socialMediaBeanList;
			}

		@Override
		public SocialMediaBean getSocialMediaForEdit(Long socialId) {
			SocialMedia socialMediaObject=AdminMgmtDaoImpl.getSocialMediaForEdit(socialId);
			log.info("sociailMediaObject..data.."+socialMediaObject.getSocialId());
			SocialMediaBean socialMediaBean=new SocialMediaBean();
				socialMediaBean.setEventId(socialMediaObject.getEvent().getEventId());
				socialMediaBean.setName(socialMediaObject.getName());
				socialMediaBean.setUrl(socialMediaObject.getUrl());
				socialMediaBean.setSocialId(socialMediaObject.getSocialId());
				socialMediaBean.setType(socialMediaObject.getType());
			return socialMediaBean;
		}

		@Override
		public void updateSocialMedia(SocialMediaBean socialMediaBean) {
			SocialMedia socialMedia=new SocialMedia();
			
			Event event=new Event();
			event.setEventId(socialMediaBean.getEventId());
			socialMedia.setEvent(event);
			socialMedia.setSocialId(socialMediaBean.getSocialId());
			socialMedia.setName(socialMediaBean.getName());
			socialMedia.setUrl(socialMediaBean.getUrl());
			socialMedia.setType(socialMediaBean.getType());
			AdminMgmtDaoImpl.update(socialMedia);
			log.info("updated...");
		}

		@Override
		public void deleteSocialMedia(Long socialId) {
			log.info("delete socialmedia service.."+socialId);
			SocialMedia socialMedia=new SocialMedia();
			socialMedia.setSocialId(socialId);
			AdminMgmtDaoImpl.delete(socialMedia);
			log.info("deleted..");
		}

		@Override
		public void saveSocialMedia(SocialMediaBean socialMediaBean) {
			SocialMedia socialMedia=new SocialMedia();
				Event event=new Event();
				event.setEventId(socialMediaBean.getEventId());
			socialMedia.setEvent(event);
			socialMedia.setName(socialMediaBean.getName());
			socialMedia.setUrl(socialMediaBean.getUrl());
			socialMedia.setType(socialMediaBean.getType());
			AdminMgmtDaoImpl.save(socialMedia);
			log.info("socialMedia saved..");
			
		}

		@Override
		public void updateParticipant(ParticipantBean participantBean) {
			Participants participant=AdminMgmtDaoImpl.getParticipantById(participantBean.getParticipantId());
			
			participant.setParticipantId(participantBean.getParticipantId());
			participant.setEmail(participantBean.getEmailId());
			participant.setFirstName(participantBean.getFirstName());
			participant.setLastName(participantBean.getLastName());
			//participant.setOtp(participantBean.getOTP());
			participant.setPhone(participantBean.getPhoneNumber());
			participant.setStatus(participantBean.getStatus());
			//participant.setRegId(participantBean.getRegisterId());
			
			AdminMgmtDaoImpl.update(participant);
		}
		
		 //participantEdit
			public ParticipantBean participantEdit(Long participantId,Long eventId) {
				ParticipantBean participantBean = null;
				//Participants participantsObject = AdminMgmtDaoImpl.participantEdit(participantId,eventId);
				Object[] participantsObject=AdminMgmtDaoImpl.participantEdit(participantId,eventId);
				log.info("participant for network edit.PID."+participantsObject[1]);
				
					participantBean = new ParticipantBean();
				
					participantBean.setParticipantId(((BigInteger)participantsObject[0]).longValue());
					participantBean.setFirstName((String)participantsObject[1]);
					participantBean.setLastName((String)participantsObject[2]);
					participantBean.setEmailId((String)participantsObject[3]);
					participantBean.setPhoneNumber((String)participantsObject[4]);
					participantBean.setStatus((String)participantsObject[5]);
				
				return participantBean;
			}
			
			@Override
			public void updateParticipantDetails(ParticipantBean participantBean) {
				//Participants participants = AdminMgmtDaoImpl.participantEdit(participantBean.getParticipantId());
				log.info("updating participant.."+participantBean.getEmailId());
				Participants participants =new Participants();
					participants.setParticipantId(participantBean.getParticipantId());
					participants.setFirstName(participantBean.getFirstName());
					participants.setLastName(participantBean.getLastName());
					participants.setPhone(participantBean.getPhoneNumber());
					participants.setEmail(participantBean.getEmailId());
					participants.setStatus(participantBean.getStatus());
				AdminMgmtDaoImpl.update(participants);
			}
			
			// eventParticipantCreate
			public void eventParticipantStatusSave(
					ParticipantEventBean participantEventBean) {
				AdminMgmtDaoImpl.eventParticipantStatusSave(participantEventBean);

			}
			
			public String getEventParticipantStatus(Long eventId,Long participantId) {
				
				return AdminMgmtDaoImpl.getEventParticipantStatus(eventId,participantId);
			}
			
			@Override
			public String participantQueriesSave(ParticipantQuriesBean participantQuriesBean) {
				
				ParticipantQuries participantQuries = new ParticipantQuries();
				participantQuries.setQuery(participantQuriesBean.getQuery());
				Event event = new Event();
				event.setEventId(participantQuriesBean.getEventId());
				participantQuries.setEvent(event);
				Speaker speaker = new Speaker();
				speaker.setSpeakerId(participantQuriesBean.getSpeakerId());
				participantQuries.setSpeaker(speaker);
				Participants participants = new Participants();
				participants.setParticipantId(participantQuriesBean.getParticipantId());
				participantQuries.setParticipants(participants);
				long i=(Long)AdminMgmtDaoImpl.save(participantQuries);
				
				log.info("savePartcipantQueries--"+i);
				String result="fail";
				if(i>0){
					result="success";
				}
				return result;
			}

			@Override
			public void saveGalary(GalaryBean galaryBean) {
				Galary galary = new Galary();
				galary.setName(galaryBean.getName());
				galary.setType(galaryBean.getType());
				galary.setFileName(galaryBean.getFileName());
				Event event = new Event();
				event.setEventId(galaryBean.getEventId());
				galary.setEvent(event);
				AdminMgmtDaoImpl.save(galary);
			}

			@Override
			public String generateOTP(ParticipantBean participantBean) {
				String otp=WREUtil.generateRandomCode();
				participantBean.setOTP(otp);
				
				AdminMgmtDaoImpl.updateOtp(participantBean);
				
				return otp;
			}

			@Override
			public String checkOTP(ParticipantBean participantBean) {
				
				return AdminMgmtDaoImpl.checkOTP(participantBean);
			}

			@Override
			public void profileUpload(Long participantId, String fileName) {
				AdminMgmtDaoImpl.profileUpload(participantId,fileName);
				
			}

			@Override
			public String sendingOTP(ParticipantBean participantBean) {
				Participants participants = null;
				String result = null;
				participants = AdminMgmtDaoImpl.getParticipantByPhoneNumber(participantBean.getPhoneNumber());
				
				 if(participants!=null){
					  String messagedata="Dear%20User,%20your%20OTP%20is%20"+participants.getOtp()+"%20,Please%20don't%20share%20This%20OTP%20to%20other%20persons";
					           String sms_url="http://bulksmsapps.com/apisms.aspx?user=surenganne&password=Ganne@2013&genkey=758742187&sender=WRE&message="+messagedata+"&number="+participantBean.getPhoneNumber();
					           log.info("we are Sending message to "+participantBean.getPhoneNumber());
					           URL url;
					           try {
					               url = new URL(sms_url);
					               InputStream is = url.openConnection().getInputStream();
					               BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );
					               reader.close();
					               result="success";
					           } catch (Exception e) {
					               System.err.println(e);
					               result="fail";
					           }
					           System.out.println("message send successfully");
					  }else{
					   result="inavlidphoneno";
					  }
				 log.info(result);
					  return result;
			}
			

			


}

	

