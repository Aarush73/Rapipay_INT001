package com.mkj.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.entity.RapipayEmployee;
import com.mkj.app.repo.RapipayEmployeeRepository;

@RestController
@RequestMapping("/public")
public class PublicWebController {

	@Autowired
	private RapipayEmployeeRepository repo;
	
	@GetMapping("/home")
	public String homepage()
	{
		return "Welcome User Its a Home Page";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "Do Login";
	}
	
	
	@GetMapping("/getemp")
	public List<RapipayEmployee> getEmp()
	{
		return repo.findAll(); 
	}
	
}
