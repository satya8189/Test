package com.wre.adminmgmt.dao;

import java.util.List;

import com.wre.adminmgmt.bean.EventBean;
import com.wre.common.dao.GenericDao;
import com.wre.model.Agenda;
import com.wre.model.Event;
import com.wre.model.EventServices;
import com.wre.model.Galary;
import com.wre.model.Newsfeed;
import com.wre.model.Participants;

public interface AdminMgmtDao  extends GenericDao<Object>{



public List<Event> getEventList(Long userId);

public List<EventServices> getEventDetails(String eventId);

public List<Agenda> getAgendoDetails(Long eventId);

public Agenda agendoEditDetails(Long agenId);

public List<Newsfeed> getNewsList(Long eventId);

public Newsfeed newsEditDetails(Long newsFeedId);

public List<Galary> galaryList(Long eventId,String type);

public Event detailsView(Long eventId);

public Long checkMobileNumber(String number);

public List<Object[]> inviteDetails(Long eventId);


}
