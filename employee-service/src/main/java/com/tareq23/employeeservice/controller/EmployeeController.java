package com.tareq23.employeeservice.controller;

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

import com.tareq23.employeeservice.model.Employee;
import com.tareq23.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping
	public Employee add(@RequestBody Employee employee)
	{
		LOGGER.info("Empolyee Add: {}",employee);
		return employeeRepository.add(employee);
	}
	
	@GetMapping
	public List<Employee> findAll(){
		LOGGER.info("Employee find");
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id)
	{
		LOGGER.info("Employee find by id");
		return employeeRepository.findById(id);
	}
	
	@GetMapping("/department/{id}")
	public List<Employee> findByDepartment(@PathVariable Long id){
		LOGGER.info("Employee find by department");
		return employeeRepository.findByDepartment(id);
	}

}
