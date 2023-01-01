package com.spring.hibernate.business.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.hibernate.business.interfaces.CustomerService;
import com.spring.hibernate.dao.GenericDao;
import com.spring.hibernate.entity.Customer;

@Service
public class customerServiceImpl implements CustomerService {

	@Autowired
	private GenericDao genericDao;

	@Override
	public List<Customer> getCustomers() {
		System.out.println("getCustomers()");
		return this.genericDao.loadAll(Customer.class);
	}

	@Override
	public void persistCustomer(Customer theCustomer) {
		this.genericDao.persist(theCustomer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return this.genericDao.getEntityByPk(Customer.class, customerId);
	}

	@Override
	public void deleteCutomerById(Class<Customer> class1, Map<String, String> map) {
		this.genericDao.delete(class1, map);
	}
}
