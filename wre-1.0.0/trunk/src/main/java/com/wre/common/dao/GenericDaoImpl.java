package com.wre.common.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class GenericDaoImpl<T> implements GenericDao<T> {

	
	    @Autowired
	    public SessionFactory sessionFactory;
	    
	    public Serializable save(T object) {
	    	sessionFactory.getCurrentSession().clear();
	        return sessionFactory.getCurrentSession().save(object);
	    }

	    
	    public void saveOrUpdate(T object) {
	        sessionFactory.getCurrentSession().saveOrUpdate(object);
	    }

	    
	    public void delete(T object) {
	    	sessionFactory.getCurrentSession().clear();
	        sessionFactory.getCurrentSession().delete(object);
	    }

	    
	    public void update(T object) {
	    	sessionFactory.getCurrentSession().clear();
	        sessionFactory.getCurrentSession().update(object);
	    }

	    @SuppressWarnings("unchecked")
		
	    public T findById(Class<T> clazz, Serializable id) {
	        Session session = sessionFactory.getCurrentSession();
	        return (T) session.get(clazz, id);
	    }
	    
	   
	    public void load(Class<T> clazz, Serializable id){
	        sessionFactory.getCurrentSession().load(clazz, id);
	    }
	  
}
