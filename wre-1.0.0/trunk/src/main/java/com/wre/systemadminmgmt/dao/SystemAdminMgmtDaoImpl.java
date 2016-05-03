package com.wre.systemadminmgmt.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wre.common.dao.GenericDaoImpl;
import com.wre.model.User;
import com.wre.systemadminmgmt.bean.UserBean;


@Repository("systemAdminMgmtDao")
public class SystemAdminMgmtDaoImpl extends GenericDaoImpl<Object> implements
SystemAdminMgmtDao {

private static final Log log = LogFactory
	.getLog(SystemAdminMgmtDaoImpl.class);

public User loginAuthentication(UserBean userBean) {
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
	criteria.add(Restrictions.eq("email",userBean.getEmail()));
	criteria.setFetchMode("appIdentifier", FetchMode.EAGER);
	return (User)criteria.uniqueResult();
	
	 
} 


}
