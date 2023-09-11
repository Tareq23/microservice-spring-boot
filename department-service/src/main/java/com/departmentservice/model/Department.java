package com.departmentservice.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private Long id;
	
	private String name;
	
	private List<Employee> employees = new ArrayList<>();
	
	
	
	

	public Department() {
		super();
	}

	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
