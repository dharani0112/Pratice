package com.cognizant.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Department {
	
	@Id
	private int deptId;
	private String departName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="employeeId")
	private Employee employee;
	
	

}
