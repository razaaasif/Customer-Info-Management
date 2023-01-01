package com.spring.hibernate.business.interfaces;

import java.util.List;
import java.util.Map;

import com.spring.hibernate.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void persistCustomer(Customer theCustomer);

	public Customer getCustomerById(int customerId);

	public void deleteCutomerById(Class<Customer> class1, Map<String, String> map);
}
