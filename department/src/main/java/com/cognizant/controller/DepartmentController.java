package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Department;
import com.cognizant.service.DepartmentService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/addDepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.addDepartment(department),HttpStatus.OK);
	}
	@GetMapping("/listAll")
	public ResponseEntity<List<Department>> listAll(){
		return new ResponseEntity<List<Department>>(departmentService.listAll(),HttpStatus.OK); 
	}
	@GetMapping("/listById/{id}")
	public ResponseEntity<Department> findById(@PathVariable int id){
		return new ResponseEntity<Department>(departmentService.findById(id),HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		departmentService.deleteById(id);
		return ResponseEntity.ok().build();
	
   }
}
