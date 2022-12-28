package com.spring.hibernate.business.interfaces;

import java.util.List;

import com.spring.hibernate.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

}
