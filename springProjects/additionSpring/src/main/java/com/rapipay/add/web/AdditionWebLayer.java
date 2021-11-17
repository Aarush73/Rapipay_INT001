package com.rapipay.add.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.add.service.AdditionService;

@RestController
@RequestMapping("/client")
public class AdditionWebLayer {
	
	@Autowired
	private AdditionService addService;
	
	public AdditionWebLayer() {
		System.out.println("Inside Constructor");
	}
	
	@RequestMapping("/home")
	public String come() {
		return "come";
	}
	
	@RequestMapping("/sum/{a}/{b}")
	public double sum(@PathVariable int a, @PathVariable int b) {
		return addService.sum(a, b);
	}
	
	@RequestMapping("/addition")
	public double addition(@RequestParam int a, @RequestParam int b) {
		return addService.sum(a, b);
	}
}
