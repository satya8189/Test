package com.wre.systemadminmgmt.service;

import com.wre.systemadminmgmt.bean.UserBean;

public interface SystemAdminMgmtService {

	UserBean loginAuthentication(UserBean userBean);

}
