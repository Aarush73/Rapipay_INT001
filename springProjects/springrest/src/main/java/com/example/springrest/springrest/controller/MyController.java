package com.example.springrest.springrest.controller;

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

import com.example.springrest.springrest.bean.Product;
import com.example.springrest.springrest.exceptions.MaxAmountException;
import com.example.springrest.springrest.exceptions.NegativeException;
import com.example.springrest.springrest.services.ProductServices;
import com.example.springrest.springrest.utility.UtilityClass;

import javassist.NotFoundException;
import springfox.documentation.service.ResponseMessage;

@RestController
public class MyController {

	@Autowired
	ProductServices prod;

	@Autowired
	UtilityClass prodUtility;

	@GetMapping("/products")
	public List<Product> getProducts() {
		return prod.getProducts();
	}

	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable int productId) throws NotFoundException{
		return prod.getProductById(productId);
	}

	@PostMapping(path = "/products", consumes = "application/json")
	public Object addProduct(@RequestBody Product product) throws NegativeException, MaxAmountException {
		try {
			return prod.addProduct(product);
		} catch (NegativeException e) {
//			System.out.println(e);
//			return new ResponseMessage(400, e.toString(), null, null);
			return e;
		} catch (MaxAmountException e1) {
//			System.out.println(e1);
		    return e1;
		} catch (Exception e2) {
			return e2;
		}
	}

	@PutMapping(path = "/products/{productId}", consumes = "application/json")
	public Object updateProduct(@PathVariable int productId, @RequestBody Product product) throws NegativeException, MaxAmountException {
		try {
			return prod.updateProduct(productId, product);
		} catch (NegativeException e) {
			System.out.println(e);
			return e;
		} catch (MaxAmountException e1) {
			System.out.println(e1);
			return e1;
		} catch (Exception e2) {
			return e2;
		}
	}

	@DeleteMapping("/products/{productId}")
	public Object deleteProduct(@PathVariable int productId) throws IllegalArgumentException{
		try {
			prod.deleteProduct(productId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IllegalArgumentException e1) {
			System.out.println(e1);
			return new ResponseMessage(404, e1.toString(), null, null);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/products/emi/{productId}")
	public double calculateEmi(@PathVariable int productId) {
		return prodUtility.calculateEmi(productId);
	}
}
