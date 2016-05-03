package com.wre.adminmgmt.service;

import java.util.List;

import com.wre.adminmgmt.bean.EventBean;

public interface AdminMgmtService {

public List<EventBean> getEventBeanList();

public 	void  saveEvent(EventBean eventBean);

public void updateEvent(EventBean eventBean);

public EventBean getEventDetails(String eventId);

}
