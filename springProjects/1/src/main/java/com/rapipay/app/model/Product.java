package com.rapipay.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	
	@Value("HP")
	private String productName;
	
	private int productId;
	private int cost;
	
	@Autowired
	@Qualifier(value = "")
	private EMI emi;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productName,int productId, int cost) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.cost = cost;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public EMI getEmi() {
		return emi;
	}

	public void setEmi(EMI emi) {
		this.emi = emi;
	}
	
	

}