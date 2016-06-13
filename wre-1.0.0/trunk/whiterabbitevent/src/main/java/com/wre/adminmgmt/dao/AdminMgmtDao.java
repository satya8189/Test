package com.wre.adminmgmt.dao;

import java.util.List;

import com.wre.adminmgmt.bean.RatingBean;
import com.wre.common.dao.GenericDao;
import com.wre.model.Agenda;
import com.wre.model.AppIdentifier;
import com.wre.model.ChatTopic;
import com.wre.model.ContactDetails;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Galary;
import com.wre.model.Newsfeed;
import com.wre.model.Participants;
import com.wre.model.Rating;
import com.wre.model.Speaker;
import com.wre.model.Sponcor;
import com.wre.model.SurveyQuestion;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.ParticipantEventBean;

public interface AdminMgmtDao  extends GenericDao<Object>{



public List<Event> getEventList(Long userId);

public List<EventServices> getEventDetails(Long eventId);

public List<Agenda> getAgendoDetails(Long eventId);

public Agenda agendoEditDetails(Long agenId);

public List<Newsfeed> getNewsList(Long eventId);

public Newsfeed newsEditDetails(Long newsFeedId);

public List<Galary> galaryList(Long eventId,String type);

public Event detailsView(Long eventId);

public Long checkMobileNumber(String number);

public List<Object[]> inviteDetails(Long eventId);

public List<SurveyQuestion> questionList(Long eventId);

public List<AppIdentifier> appList(Long appId);

public SurveyQuestion questionEdit(Long questionId);


public List<Sponcor> getSponcorsList(Long eventId);

public Sponcor getSponsorBySponsorId(Long sponcorId);

public List<Speaker> getSpeakersList(Long eventId);

public Speaker getSpeakerBySpeakerId(Long speakerId);
public List<Participants> getUser(String mobno);

public List<EventServices> geteventServicesList(Long eventId);
public String participantRegUpdate(ParticipantBean participantBean);

public List<Rating> getUserRatingList(RatingBean ratingBean);

public List<ContactDetails> adminViewContactDetails(Long eventId);

public ContactDetails getContactDetailsForEdit(Long contactId);

public List<Rating> getUserRatingList(Long eventId);

public List<ChatTopic> getChatTopicList(Long eventId);

public ChatTopic getChatTopicDetails(Long chatTopicId);

public List<Object[]> getParticipantEventBeanList(Long eventId,
		String status);

public void eventParticipantSave(
		ParticipantEventBean participantEventBean);

public List<Object[]> getParticipantsList(Long eventId);

public List<Object[]> getParticipantsAnswersList(Long eventId,
		Long participantId);

}
