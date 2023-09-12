package com.departmentservice.client;

import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.departmentservice.model.Employee;



@HttpExchange
public interface EmployeeClient {
	
	@GetExchange("/employee/department/{id}")
	public List<Employee> findByDepartment(@PathVariable("id") Long id);

}
