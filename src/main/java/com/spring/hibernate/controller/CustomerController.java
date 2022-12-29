package com.spring.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.hibernate.business.interfaces.CustomerDAO;
import com.spring.hibernate.entity.Customer;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/")
	public String getCustomers(Model theModel) {
		List<Customer> theCustomers = this.customerDAO.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
}
