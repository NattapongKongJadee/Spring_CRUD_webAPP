package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// create a mapping for "/hello"

	@GetMapping("/main")
	public String sayHello(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "members/homepage";
	}
}








