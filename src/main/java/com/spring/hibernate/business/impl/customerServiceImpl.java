package com.spring.hibernate.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.business.interfaces.CustomerService;
import com.spring.hibernate.dao.GenericDao;
import com.spring.hibernate.entity.Customer;

@Service
public class customerServiceImpl implements CustomerService {

	@Autowired
	private GenericDao genericDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		System.out.println("getCustomers()");
		return this.genericDao.loadAll(Customer.class);
	}
}
