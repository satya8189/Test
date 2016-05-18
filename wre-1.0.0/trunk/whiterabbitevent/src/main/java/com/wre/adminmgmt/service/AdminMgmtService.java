package com.wre.adminmgmt.service;

import java.util.List;

import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.GalaryBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.model.Event;

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

public List<GalaryBean> galaryList(Long eventId);

public EventBean detailsView(Long eventId);

public void updateDetails(EventBean eventBean);

public void createGallery(GalaryBean galaryBean);

}
