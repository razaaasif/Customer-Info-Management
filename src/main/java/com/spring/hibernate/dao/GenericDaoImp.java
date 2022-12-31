package com.spring.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDaoImp implements GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public <T> List<T> loadAll(Class<T> className) {
		System.out.println("loadAll() starts for class " + className.getSimpleName());
		List<T> output = new ArrayList<>();
		System.out.println("loadAll() query call start");
		Query<T> query = this.getCurrentSession().createQuery("from " + className.getSimpleName(), className);
		output.addAll(query.getResultList());
		return output;
	}

	@Override
	@Transactional
	public void persist(Object obj) {
		this.getCurrentSession().persist(obj);
		System.out.println(obj + "\npersist done!");
	}

}
