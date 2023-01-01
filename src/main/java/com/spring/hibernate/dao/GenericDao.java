package com.spring.hibernate.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao {
	public <T> List<T> loadAll(Class<T> className);

	public void persist(Object obj);

	public<T> T getEntityByPk(Class<T>className , int id);

	public <T> void delete(Class<T> class1, Map<String, String> map);
}
