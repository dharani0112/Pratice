package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Employee;
import com.cognizant.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}
	
	

	
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.findByName(name);
	}

	
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

	
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> emp =employeeRepository.findById(id);
		Employee newemp= emp.get();
		newemp.setAge(employee.getAge());
		newemp.setId(employee.getId());
		newemp.setName(employee.getName());
		
		return employeeRepository.save(newemp);
	}


}
