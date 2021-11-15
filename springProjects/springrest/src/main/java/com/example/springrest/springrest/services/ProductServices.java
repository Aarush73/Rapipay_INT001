package com.example.springrest.springrest.services;

import java.util.List;

import com.example.springrest.springrest.bean.Product;
import com.example.springrest.springrest.exceptions.MaxAmountException;
import com.example.springrest.springrest.exceptions.NegativeException;

public interface ProductServices {
	public List<Product> getProducts();

	public Product getProductById(int id);

	public Object addProduct(Product p) throws NegativeException, MaxAmountException;

	public Product updateProduct(int id, Product updatedProduct) throws NegativeException, MaxAmountException;
	
	public void deleteProduct(int id);
}
