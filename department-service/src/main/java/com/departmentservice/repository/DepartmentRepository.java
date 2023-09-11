package com.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.departmentservice.model.Department;


@Repository
public class DepartmentRepository {
	
	
	private List<Department> departments;
	
	public DepartmentRepository() {
		this.departments = new ArrayList<>();
	}
	
	
	public Department add(Department department)
	{
		if(department != null) {
			departments.add(department);
		}
		return department;
	}
	
	public Department findById(Long id)
	{
		return departments.stream().filter(department -> department.getId().equals(id)).findFirst().orElseThrow();
	}
	
	public List<Department> findAll(){
		return departments;
	}

}
