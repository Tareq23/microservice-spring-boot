package com.departmentservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departmentservice.client.EmployeeClient;
import com.departmentservice.model.Department;
import com.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@PostMapping
	public Department addDepartment(@RequestBody Department department)
	{
		LOGGER.info("Department add: {}",department);
//		return department;
		return departmentRepository.add(department);
	}
	
	@GetMapping("/{id}")
	public Department getById(@PathVariable Long id) {
		LOGGER.info("Department id: {}",id);
		return departmentRepository.findById(id);
	}
	
	@GetMapping
	public List<Department> getAll(){
		LOGGER.info("Department All");
		return departmentRepository.findAll();
	}
	
	
	@GetMapping("/with-employee")
	public List<Department> findAllWithEmployees()
	{
		LOGGER.info("Department with employee");
		
		List<Department> departments = departmentRepository.findAll();
		
		departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
		return departments;
	}

}
