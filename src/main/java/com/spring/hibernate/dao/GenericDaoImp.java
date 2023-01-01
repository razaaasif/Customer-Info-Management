package com.spring.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GenericDaoImp implements GenericDao {
	private final String id = "id";
	private final String value = "value";
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public <T> List<T> loadAll(Class<T> className) {
		List<T> output = new ArrayList<>();
		System.out.println("loadAll() query call start");
		Query<T> query = this.getCurrentSession().createQuery("from " + className.getSimpleName(), className);
		output.addAll(query.getResultList());
		return output;
	}

	@Override
	@Transactional
	public void persist(Object obj) {
		System.out.println("\nto persist " + obj);
		this.getCurrentSession().saveOrUpdate(obj);
		System.out.println(obj + "\npersist done!");
	}

	@Override
	public <T> T getEntityByPk(Class<T> className, int id) {
		T entity = this.getCurrentSession().get(className, id);
		System.out.println("getEntityByPk() => " + entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public <T> void delete(Class<T> class1, Map<String, String> map) {
		map.forEach((a, b) -> {
			System.out.println("Key : " + a + " value : " + b);
		});
		Query<T> query = this.getCurrentSession()
				.createQuery("delete from " + class1.getSimpleName() + " where " + map.get(id) + "=:value");
		query.setParameter(value, Integer.parseInt(map.get(value)));
		query.executeUpdate();
		System.out.println("delete() finished ");
	}

}
