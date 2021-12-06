package com.mkj.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.entity.AppUsers;
import com.mkj.app.entity.RapipayEmployee;
import com.mkj.app.repo.AppUserRepository;
import com.mkj.app.repo.RapipayEmployeeRepository;

@RestController
@RequestMapping("/admin")
public class AdminWebController {

	@Autowired
	private RapipayEmployeeRepository empRepo;
	
	@Autowired
	private AppUserRepository userRepo;
	
	
	@GetMapping("/test")
	public String homepage()
	{
		return "Admin can add user";
	}
	
	
	@PostMapping("/adduser")
	public AppUsers addUsers(@RequestBody  AppUsers user)
	{
		return userRepo.save(user);
	}
	
	
	@PostMapping("/addemp")
	public RapipayEmployee addEmp(@RequestBody  RapipayEmployee emp)
	{
		return empRepo.save(emp);
	}
	
}


