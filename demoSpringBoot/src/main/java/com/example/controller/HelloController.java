package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;


@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		User user = new User();
		user.setName("nhathoang"); 
		model.addAttribute("user", user);
		return "hello";
	}
}