package com.wre.common.dao;

import java.io.Serializable;
public interface GenericDao<T> {

	/**
	 * this method having logic of deleting Generic type record  .
	 * @param T
	 * @return  
	 */
	void delete(T object);
	/**
	 * this method having Generic logic for load data By  using Generic entity type class and Identity .
	 * @param Class<T>
	 * @param Serializable
	 * @return T 
	 */
	T findById(Class<T> clazz, Serializable id);
	/**
	 * this method having Generic logic for load data By  using Generic entity type class and Identity .
	 * @param Class<T>
	 * @param Serializable
	 * @return 
	 */
	void load(Class<T> clazz, Serializable id);
	/**
	 * this method having Generic logic for Save data  .
	 * @param Class<T>
	 * @param Serializable
	 * @return T 
	 */
	Serializable save(T object);
	/**
	 * this method having Generic logic for Save or update data  .
	 * @param Class<T>
	 * @param Serializable
	 * @return T 
	 */
	void saveOrUpdate(T object);
	/**
	 * this method having Generic logic for Update data  .
	 * @param Class<T>
	 * @param Serializable
	 * @return T 
	 */
	void update(T object);
	
	
}
