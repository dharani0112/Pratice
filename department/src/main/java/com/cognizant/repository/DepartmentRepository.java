package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
