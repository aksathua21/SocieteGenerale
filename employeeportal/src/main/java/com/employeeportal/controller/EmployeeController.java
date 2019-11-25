package com.employeeportal.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.domain.EmployeeEntity;
import com.employeeportal.services.EmployeeServices;

@RequestMapping("api/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;
	
	
	@PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
	public void registerEmployee(@RequestBody EmployeeEntity employeeEntity) {
		employeeServices.registerService(employeeEntity);
	}
	
	@GetMapping("/fatchemployee")
	public List<EmployeeEntity> getAllEmployee() {
		List<EmployeeEntity>  employeeList = employeeServices.getAllEmployee();
		Collections.sort(employeeList);
		return employeeList;
	}
}
