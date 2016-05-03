package com.wre.adminmgmt.dao;

import java.util.List;

import com.wre.adminmgmt.bean.EventBean;
import com.wre.common.dao.GenericDao;

public interface AdminMgmtDao  extends GenericDao<Object>{

public List<EventBean> eventList();

public List<EventBean> getEventBeanList();

public EventBean getEventDetails(String eventId);

}
