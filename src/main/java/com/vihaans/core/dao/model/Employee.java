package com.vihaans.core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mt_employee")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Employee  extends BaseModelObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;

	@Size(min = 3, max = 50)
	@Column(name = "emp_id")
	private String empId;
	
	@Size(min = 3, max = 50)
	@Column(name = "name")
	private String name;
	
	@Size(min = 3, max = 50)
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "salary")
	private double salary;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", name=" + name + ", designation=" + designation
				+ ", salary=" + salary + "]";
	}

    // API
    
    


}
