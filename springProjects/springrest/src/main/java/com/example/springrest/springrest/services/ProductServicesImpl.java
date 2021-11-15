package com.example.springrest.springrest.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springrest.springrest.bean.Product;
import com.example.springrest.springrest.dao.ProductDao;
import com.example.springrest.springrest.exceptions.MaxAmountException;
import com.example.springrest.springrest.exceptions.NegativeException;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
	public ProductDao productdao;

	public List<Product> getProducts() {
		return productdao.findAll();
	}

	public Product getProductById(int id) {
		return productdao.findById(id).get();
	}

	public Object addProduct(Product p) throws NegativeException, MaxAmountException {
		if (p.getRoi() < 0 || p.getTenure() < 0 || p.getPrincipalAmount() < 0)
			throw new NegativeException();
		else if (p.getPrincipalAmount() > 10000000)
			throw new MaxAmountException();
		p.setEmi(0.0);
		p.setUpdatedBy(null);
		p.setUpdatedOn(null);
		return productdao.save(p);
	}

	public Product updateProduct(int id, Product updatedProduct) throws NegativeException, MaxAmountException{
		Product p = productdao.findById(id).get();

		if (updatedProduct.getTenure() < 0 && updatedProduct.getRoi() < 0 && updatedProduct.getPrincipalAmount() < 0) 
			throw new NegativeException();
		else if(updatedProduct.getPrincipalAmount() > 10000000)
			throw new MaxAmountException();
		
		p.setProductName(updatedProduct.getProductName());
		p.setPrincipalAmount(updatedProduct.getPrincipalAmount());
		p.setTenure(updatedProduct.getTenure());
		p.setRoi(updatedProduct.getRoi());
		p.setActive(updatedProduct.isActive());
		p.setCreatedBy(updatedProduct.getCreatedBy());
		p.setUpdatedBy(updatedProduct.getUpdatedBy());
		p.setUpdatedOn(LocalDate.now());
		p.setEmi(updatedProduct.getEmi());

		productdao.save(p);

		return p;
	}

	public void deleteProduct(int id) throws IllegalArgumentException{
		if(!productdao.existsById(id))
			throw new IllegalArgumentException();
		productdao.deleteById(id);
	}
}
