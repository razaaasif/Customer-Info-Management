package com.spring.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.hibernate.business.interfaces.CustomerDAO;
import com.spring.hibernate.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String getCustomers(HttpServletResponse res, Model theModel) throws IOException {
		List<Customer> theCustomers = this.customerDAO.getCustomers();
			theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
}
