package com.course.app.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Course {
	
	@Value("course-1")
	private int cId;
	@Value("Spring Course")
	private String name;
	@Value("65000")
	private float fee;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", name=" + name + ", fee=" + fee + "]";
	}
}
