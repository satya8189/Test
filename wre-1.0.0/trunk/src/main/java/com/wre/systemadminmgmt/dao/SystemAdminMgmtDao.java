package com.wre.systemadminmgmt.dao;

import com.wre.common.dao.GenericDao;
import com.wre.model.User;
import com.wre.systemadminmgmt.bean.UserBean;



public interface SystemAdminMgmtDao  extends GenericDao<Object>{

	User loginAuthentication(UserBean userBean);

}
