package com.spring.hibernate.controller;

import org.springframework.stereotype.Controller;

@Controller

public class MainController {
//	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
