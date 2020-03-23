
package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.IndustryMember;
import com.vihaans.core.dao.model.TransmissionHeader;
import com.vihaans.core.dao.repo.EmployeeRepository;
import com.vihaans.core.dao.repo.TransmissionRepository;
import com.vihaans.core.util.AuditingActionType;

@Service
public class TransmissionHeaderService {
	@Autowired
	TransmissionRepository repository;
	
	@Transactional
	@Auditable(actionType = AuditingActionType.CREATE, failedActionType = AuditingActionType.CREATE_FAILED)
	public void add(TransmissionHeader transmissionHeader) {
        repository.save(transmissionHeader);
    }
	
	@Transactional
	@Auditable(actionType = AuditingActionType.UPDATE, failedActionType = AuditingActionType.UPDATE_FAILED)
	public void edit(TransmissionHeader transmissionHeader) 
	{
		repository.save(transmissionHeader);
    }
	
	public List<TransmissionHeader> getAllTransmissionHeader(String companyCode) 
	{
		return repository.findByCompanyCode(companyCode);
    }
    
	public List<TransmissionHeader> getTransmissionHeaderById(long id) 
    {
		return repository.findByIndustryMemberId(id);
    }

}

