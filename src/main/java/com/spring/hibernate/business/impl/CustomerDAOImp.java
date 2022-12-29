package com.spring.hibernate.business.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.business.interfaces.CustomerDAO;
import com.spring.hibernate.dao.GenericDao;
import com.spring.hibernate.entity.Customer;

@Component
public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	private GenericDao genericDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		System.out.println("getCustomers()");
		return this.genericDao.loadAll(Customer.class);
	}
}
