package com.example.springdemo.services;

import java.util.List;

import com.example.springdemo.bean.Product;

public interface ProductServicesInterface {
	public List<Product> getProducts();
	
	public Product getProductById(int id);
	
	public Product addProduct(Product p);
	
	public Product updateProduct(int id, Product updatedProduct);
	
	public void deleteProduct(int id);
	
	public double calculateEmi(int id);

}
