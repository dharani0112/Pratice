package com.cognizant.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.config.DepartmentClient;
import com.cognizant.entity.Department;
import com.cognizant.entity.Employee;
import com.cognizant.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.OK);
	}
	@PostMapping("/addDepartment")
	public ResponseEntity<Department> addEmployee(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentClient.addDepartment(department),HttpStatus.OK);
	}
	@GetMapping("/listAll")
	public ResponseEntity<List<Employee>> listAll(){
		return new ResponseEntity<List<Employee>>(employeeService.listAll(),HttpStatus.OK); 
	}
	
	@GetMapping("/listAllDept")
	public ResponseEntity<List<Department>> listAllDept(){
		return new ResponseEntity<List<Department>>(departmentClient.listAll(),HttpStatus.OK); 
	}
	@GetMapping("/listById/{id}")
	public ResponseEntity<Employee> findById(@PathVariable int id){
		return new ResponseEntity<Employee>(employeeService.findById(id),HttpStatus.OK);
	}
	@GetMapping("/listByName/{name}")
	public ResponseEntity<List<Employee>> findByName(@PathVariable String name){
		return new ResponseEntity<List<Employee>>(employeeService.findByName(name),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().build();
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee),HttpStatus.OK);
	}

}
