package com.example.springdemo.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private int principalAmount;
	private float tenure;
	private float roi;
	private boolean isActive;
	private String createdBy;
	private LocalDate createdOn;
	private String updatedBy;
	private LocalDate updatedOn;
	private double emi;
	
//	public Product() {}
//
//	public Product(String productName, int principalAmount, float tenure, float roi, boolean isActive,
//			String createdBy, LocalDate createdOn, String updatedBy,LocalDate updatedOn) {
//		this.productName = productName;
//		this.principalAmount = principalAmount;
//		this.tenure = tenure;
//		this.roi = roi;
//		this.isActive = isActive;
//		this.createdBy = createdBy;
//		this.createdOn = createdOn;
//		this.updatedBy = updatedBy;
//		this.updatedOn = updatedOn;
//	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(int principalAmount) {
		this.principalAmount = principalAmount;
	}

	public float getTenure() {
		return tenure;
	}

	public void setTenure(float tenure) {
		this.tenure = tenure;
	}

	public float getRoi() {
		return roi;
	}

	public void setRoi(float roi) {
		this.roi = roi;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Product [Id : "+productId+" ,Name : "+productName+" ,Principal-Amount : "+principalAmount+" ,Tenure : "+tenure+" ,Rate of Interest : "+roi+" ,Active : "+isActive+" , Created-By : "+createdBy+" ,Date of Creation : "+createdOn+" ,Updated-By : "+updatedBy+" ,Updated-On : "+updatedOn+"]";
	}
}

