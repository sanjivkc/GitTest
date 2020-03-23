package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.FormDetails;
import com.vihaans.core.dao.repo.FormDetailsRepository;
import com.vihaans.core.util.AuditingActionType;

@Service
public class FormDetailsService 
{
	@Autowired
	FormDetailsRepository repository;
	
	@Transactional
	@Auditable(actionType = AuditingActionType.CREATE, failedActionType = AuditingActionType.CREATE_FAILED)
	public void add(FormDetails form) 
	{
        repository.save(form);
    }
	
	@Transactional
	@Auditable(actionType = AuditingActionType.UPDATE, failedActionType = AuditingActionType.UPDATE_FAILED)
	public void edit(FormDetails form) 
	{
		repository.save(form);
    }

	@Transactional
	@Auditable(actionType = AuditingActionType.DELETE, failedActionType = AuditingActionType.DELETE_FAILED)
    public void delete(long id) 
	{
        repository.deleteById(id);
    }

	public List<FormDetails> getFormDetails(String companyCode) 
	{
		return repository.findByCompanyCode(companyCode);
    }
	
	public List<FormDetails> getFormDetailsByMember(Long id) 
	{
		return repository.findByIndustryMemberId(id);
    }
    
	public FormDetails getFormDetailsById(long id) 
    {
        Optional<FormDetails> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a FormDetails with id: " + id));
    }
	
	public List<FormDetails> getFormDetailsByAddress(Long id) 
	{
		return repository.findByIndustryAddressId(id);
    }
	
	public List<FormDetails> getFormDetailsByTaxYear(String year) 
	{
		return repository.findByTaxYear(year);
    }
	
	public List<FormDetails> findByStatus(String status){
		return repository.findByStatus(status);
    }
}