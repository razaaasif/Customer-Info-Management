package com.spring.hibernate.business.interfaces;

import java.util.List;

import com.spring.hibernate.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
}
