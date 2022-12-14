package com.niveus.crud.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_mast")
public class EmpEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String empId;
	@Column(name="empName")
	public String empName;
	@Column(name="empDesignation")
	public String empDesignation;
	@Column(name="empDepartment")
	public String empDepartment;
	@Column(name="empEmailId")	
	public String empEmailId;
	
	public EmpEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpEntity(String empName, String empDesignation, String empDepartment, String empEmailId) {
		super();
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empDepartment = empDepartment;
		this.empEmailId = empEmailId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	
	
}
