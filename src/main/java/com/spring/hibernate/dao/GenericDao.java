package com.spring.hibernate.dao;

import java.util.List;

public interface GenericDao {
	public <T> List<T> loadAll(Class<T> className);
}
