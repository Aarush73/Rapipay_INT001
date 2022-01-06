package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.bean.Product;
import com.example.springdemo.services.ProductServicesInterface;

@RestController
public class MyController {
	
	@Autowired
	ProductServicesInterface prod;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return prod.getProducts();
	}
	
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable int productId) {
		return prod.getProductById(productId);
	}
	
	@PostMapping(path = "/products", consumes = "application/json")
	public Product addProduct(@RequestBody Product product) {
		return prod.addProduct(product);
	}
	
	@PutMapping(path = "/products/{productId}", consumes ="application/json")
	public Product updateProduct(@PathVariable int productId , @RequestBody Product product) {
		return prod.updateProduct(productId, product);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int productId) {
		try {
			prod.deleteProduct(productId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products/emi/{productId}")
	public double calculateEmi(@PathVariable int productId) {
		return prod.calculateEmi(productId);
	}
}
