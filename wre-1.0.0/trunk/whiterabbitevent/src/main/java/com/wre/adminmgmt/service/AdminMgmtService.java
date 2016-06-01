package com.wre.adminmgmt.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.AppIdentifierBean;
import com.wre.adminmgmt.bean.ChatBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.GalaryBean;
import com.wre.adminmgmt.bean.InviteBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.adminmgmt.bean.QuestionBean;
import com.wre.adminmgmt.bean.SpeakerBean;
import com.wre.adminmgmt.bean.SponsorBean;

public interface AdminMgmtService {

public List<EventBean> getEventList( Long userId);

public 	void  saveEvent(EventBean eventBean);

public void updateEvent(EventBean eventBean);

public List<EventBean> getEventDetailsList(String eventId);

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

public void createSponsor(SponsorBean sponsorBean);

public SponsorBean getSponsorForEdit(Long sponcorId);

public void updateSponsor(SponsorBean spBean);

public List<SpeakerBean> getSpeakersList(Long eventId);

public void createSpeaker(SpeakerBean spk);

public SpeakerBean getSpeakerBySpeakerId(Long speakerId);

public void udpateSpeaker(SpeakerBean spk);

public void updateQuestionDetails(QuestionBean questionBean);

public void uploadVenuLayout(MultipartFile file, Long eventId, String type);

public List<ChatBean> getUser(String mobno);



}
