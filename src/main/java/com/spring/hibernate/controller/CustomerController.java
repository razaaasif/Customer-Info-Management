package com.spring.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.hibernate.business.interfaces.CustomerService;
import com.spring.hibernate.entity.Customer;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String getCustomers(Model theModel) {
		List<Customer> theCustomers = this.customerService.getCustomers();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {

		theModel.addAttribute("customer", new Customer());
		return "add-customer";
	}

	@PostMapping("/persist")
	public String persist(@ModelAttribute("customer") Customer theCustomer) {
		System.out.println("Saving Customer : " + theCustomer);
		this.customerService.persistCustomer(theCustomer);
		return "redirect:/";
	}
}
