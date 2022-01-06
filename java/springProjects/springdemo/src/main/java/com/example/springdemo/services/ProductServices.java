package com.example.springdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.bean.Product;
import com.example.springdemo.dao.ProductDao;

@Service
public class ProductServices implements ProductServicesInterface{
//	List<Product> products;
	
//	public ProductServices() {
//		products = new ArrayList<>();
//		products.add(new Product("Home Loan", 50000, 3, 6.5f, true, "Aarush", LocalDate.now(), null, null));
//		products.add(new Product("Medical Loan", 10000, 1, 8, false, "Aarush", LocalDate.now(), null, null));
//	}
	
	@Autowired
	public ProductDao productdao;
	
	public List<Product> getProducts() {
		return productdao.findAll();
	}
	
	public Product getProductById(int id) {
		return productdao.getById(id);
	}
	
	public Product addProduct(Product p) {
		return productdao.save(p);
	}
	
	public Product updateProduct(int id, Product updatedProduct) {
		if(productdao.existsById(id)) {
			productdao.deleteById(id);
			updatedProduct.setProductId(id);
		}
		return productdao.save(updatedProduct);
	}
	
	public void deleteProduct(int id) {
		productdao.deleteById(id);
	}
	
	public double calculateEmi(int id) {
		Product prod = productdao.getById(id);
		
		double p = prod.getPrincipalAmount();
		double r = prod.getRoi()/12/100;
		double n = prod.getTenure()*12;
		
		double emi = p * r * (Math.pow((1 + r), n) / (Math.pow(1 + r, n) - 1));
		
		prod.setEmi(emi);
		return emi;
	}
}
