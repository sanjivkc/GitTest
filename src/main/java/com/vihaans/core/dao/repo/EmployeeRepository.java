package com.vihaans.core.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
	
	List<Employee> findByCompanyCode(String companyCode);

}