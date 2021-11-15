package com.course.app.model;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Value("Student-1")
	private int sId;
	@Value("Aarush")
	private String name;
	@Value("course-1")
	private Set<Course> courses;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", courses=" + courses + "]";
	}
	
	public void printInfo() {
		
	}
}
