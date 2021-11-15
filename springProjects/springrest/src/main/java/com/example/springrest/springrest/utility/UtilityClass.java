package com.example.springrest.springrest.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springrest.springrest.bean.Product;
import com.example.springrest.springrest.dao.ProductDao;

@Service
public class UtilityClass implements UtilityInterface {
	
	@Autowired
	private ProductDao productdao;
	
	public double calculateEmi(int id) {
		Product prod = productdao.getById(id);

		double p = prod.getPrincipalAmount();
		double r = prod.getRoi() / 12 / 100;
		double n = prod.getTenure() * 12;

		double emi = p * r * (Math.pow((1 + r), n) / (Math.pow(1 + r, n) - 1));

		prod.setEmi(emi);
		productdao.save(prod);
		return emi;
	}
}
