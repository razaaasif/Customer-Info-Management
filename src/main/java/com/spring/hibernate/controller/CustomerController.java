package com.spring.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cutomer")
public class CustomerController {
	@RequestMapping("/list")
	public String getCustomers() {
		return "list-customers";
	}
}
