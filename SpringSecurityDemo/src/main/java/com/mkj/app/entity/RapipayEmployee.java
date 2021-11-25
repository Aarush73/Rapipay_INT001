package com.mkj.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RapipayEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int age;
	private String designation;
	private String name;
	private int employeeSalary;
	private String orgName;
	public RapipayEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Override
	public String toString() {
		return "RapipayEmployee [id=" + id + ", age=" + age + ", designation=" + designation + ", name=" + name
				+ ", employeeSalary=" + employeeSalary + ", orgName=" + orgName + "]";
	}
	
	
	
}
