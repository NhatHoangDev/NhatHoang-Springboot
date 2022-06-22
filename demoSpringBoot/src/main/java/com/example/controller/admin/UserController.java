package com.example.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin/users")
public class UserController {
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping()
	public String index() {
		
		return "admin/users/index";
	}

	@GetMapping(params = "id")
	public String show(@RequestParam(name = "id") int id) {
		//String id = this.request.getParameter("id");
		System.out.println(id);
		return "admin/users/show";
	}
	
	@GetMapping(value = "/create")
	public String create() {
		
		return "admin/users/create";
	}
	
	@PostMapping(value = "/store")
	public String store() {
		
		return "admin/users/store";
	}
	
	@GetMapping(value = "/edit", params = "id")
	public String edit() {
		
		return "admin/users/edit";
	}
	
	@PostMapping(value = "/update", params = "id")
	public String update() {
		
		return "admin/users/update";
	}
	
	@PostMapping(value = "/delete", params = "id")
	public String delete() {
		
		return "admin/users/delete";
	}
}
