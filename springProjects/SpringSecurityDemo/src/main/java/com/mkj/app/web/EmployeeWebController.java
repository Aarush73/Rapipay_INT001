package com.mkj.app.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeWebController {

	public String doClientTask()
	{
		return "Employee Info Access";
	}
}
