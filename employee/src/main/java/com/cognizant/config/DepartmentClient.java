package com.cognizant.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.entity.Department;



@FeignClient(name ="department", url = "http://localhost:7667")
public interface DepartmentClient {

	@GetMapping("/api/v1/listAll")
	 List<Department> listAll();
	}
