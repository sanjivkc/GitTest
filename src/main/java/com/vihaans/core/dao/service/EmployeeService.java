package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.Employee;
import com.vihaans.core.dao.repo.EmployeeRepository;
import com.vihaans.core.util.AuditingActionType;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	@Transactional
	@Auditable(actionType = AuditingActionType.CREATE, failedActionType = AuditingActionType.CREATE_FAILED)
	public void add(Employee employee) {
        repository.save(employee);
    }

	@Transactional
	@Auditable(actionType = AuditingActionType.DELETE, failedActionType = AuditingActionType.DELETE_FAILED)
    public void delete(long id) 
	{
        repository.deleteById(id);
    }

	public List<Employee> getEmployee(String companyCode) 
	{
		return repository.findByCompanyCode(companyCode);
    }
    
	public Employee getEmployeeById(long id) 
    {
        Optional<Employee> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Employee with id: " + id));
    }
	
}
