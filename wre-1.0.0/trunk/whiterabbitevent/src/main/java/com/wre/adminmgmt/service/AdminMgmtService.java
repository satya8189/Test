package com.wre.adminmgmt.service;

import java.util.List;

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
import com.wre.adminmgmt.bean.QuestionBean;
import com.wre.adminmgmt.bean.RatingBean;
import com.wre.adminmgmt.bean.SpeakerBean;
import com.wre.adminmgmt.bean.SponsorBean;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.ParticipantEventBean;

public interface AdminMgmtService {

public List<EventBean> getEventList( Long userId);

public 	void  saveEvent(EventBean eventBean);

public void updateEvent(EventBean eventBean);

public List<EventBean> getEventDetailsList(Long eventId);

public List<AgendaBean> getAgendoDetails(Long eventId);

public void createAgendo(AgendaBean agendaBean);

public AgendaBean agendoEditDetails(Long agenId);

public void updateAgendo(AgendaBean agendaBean);

public List<NewsFeedBean> getNewsList(Long eventId);

public NewsFeedBean newsEditDetails(Long newsFeedId);

public void updateNews(NewsFeedBean newsFeedBean);

public void saveNews(NewsFeedBean newsFeedBean);

public List<GalaryBean> galaryList(Long eventId,String type);

public EventBean detailsView(Long eventId);

public void updateDetails(EventBean eventBean);

public void createGallery(MultipartFile file, Long eventId, String type,
		  String name);

public void invite(InviteBean inviteBean);

public List<InviteBean> inviteDetails(Long eventId);

public void deleteGallery(Long glaryItemId);

public List<QuestionBean> questionList(Long eventId);

public void questionCreate(QuestionBean questionBean);

public List<AppIdentifierBean> appList(Long appId);

public QuestionBean questionEdit(Long questionId);

public List<SponsorBean> getSponsorsList(Long eventId);

public SponsorBean getSponsorForEdit(Long sponcorId);

public void updateSponsor(MultipartFile file,Long eventId,String type,String sponcorName,String sponcorDesc,Long sponcorId);

public List<SpeakerBean> getSpeakersList(Long eventId);

public void createSpeaker(MultipartFile file,Long eventId,String type,String speakerName, String location,String title,String description,String rating);

public SpeakerBean getSpeakerBySpeakerId(Long speakerId);

public void udpateSpeaker(MultipartFile file,Long eventId,String type,String speakerName, String location,String title,String description,String rating,Long speakerId);

public void updateQuestionDetails(QuestionBean questionBean);

public void uploadVenuLayout(MultipartFile file, Long eventId, String type);

public List<ChatBean> getUser(String mobno);

public void uploadEventImage(MultipartFile file, Long eventId, String type);

public void createSponsor(MultipartFile file, Long eventId, String type,
		String sponcorDesc, String speakerName);

public List<EventBean> geteventServicesList(Long eventId);
public String participantRegUpdate(ParticipantBean participantBean);

public List<ContactDetailsBean> adminViewContactDetails(Long eventId);

void saveContactDetails(ContactDetailsBean contactDetailsBean);

void updateContactDetails(ContactDetailsBean contactDetailsBean);

ContactDetailsBean getContactDetailsForEdit(Long contactId);

List<RatingBean> getUserRatings(Long eventId);

List<RatingBean> getUserRatings(RatingBean ratingBean);

void saveUserRating(RatingBean ratingBean);

public List<ChatTopicBean> getChatTopicList(Long eventId);

public void saveChatTopic(ChatTopicBean chatTopicBean);

public ChatTopicBean getChatTopicDetails(Long chatTopicId);

public void chatTopicUpdate(ChatTopicBean chatTopicBean);

public void chatTopicDelete(Long chatTopicId);

public List<ParticipantEventBean> getParticipantEventBeanList(Long eventId,
		String status);

public void eventParticipantSave(ParticipantEventBean participantEventBean);


public void saveSurveyQuestionAnswer(QuestionBean questionBean);

public List<ParticipantBean> getParticipantsList(Long eventId);




}
