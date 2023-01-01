package com.spring.hibernate.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hibernate.business.interfaces.CustomerService;
import com.spring.hibernate.entity.Customer;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String getCustomers(Model theModel) {
		List<Customer> theCustomers = this.customerService.getCustomers();
		theCustomers.sort(Comparator.comparing(Customer::getFirstName, String.CASE_INSENSITIVE_ORDER));
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

	@GetMapping("/updateForm")
	public String update(@RequestParam("customerId") int customerId, Model theModel) {
		// get the customer from database
		Customer theCustomer = this.customerService.getCustomerById(customerId);
		theModel.addAttribute("customer", theCustomer);
		return "add-customer";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int customerId, Model theModel) {
		// get the customer from database
		Map<String, String> map = new HashMap<>();
		map.put("id", "id");
		map.put("value", Integer.toString(customerId));
		this.customerService.deleteCutomerById(Customer.class, map);
		System.out.println("Delete success!!!");
		return "redirect:/";
	}

}
