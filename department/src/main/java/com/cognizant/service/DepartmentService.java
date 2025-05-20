package com.cognizant.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Department;
import com.cognizant.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public List<Department> listAll(){
		return departmentRepository.findAll();
	}
	
	public Department findById(int id) {
		return departmentRepository.findById(id).get();
		
	}
	
	public void deleteById(int id) {
		departmentRepository.deleteById(id);
	}

}
