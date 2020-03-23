package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.IndustryAddress;
import com.vihaans.core.dao.repo.IndustryAddressRepository;
import com.vihaans.core.util.AuditingActionType;

@Service
public class IndustryAddressService 
{

	@Autowired
	IndustryAddressRepository repository;
	
	@Transactional
	@Auditable(actionType = AuditingActionType.CREATE, failedActionType = AuditingActionType.CREATE_FAILED)
	public void add(IndustryAddress address) 
	{
        repository.save(address);
    }
	
	@Transactional
	@Auditable(actionType = AuditingActionType.UPDATE, failedActionType = AuditingActionType.UPDATE_FAILED)
	public void edit(IndustryAddress address) 
	{
		repository.save(address);
    }

	@Transactional
	@Auditable(actionType = AuditingActionType.DELETE, failedActionType = AuditingActionType.DELETE_FAILED)
    public void delete(long id) 
	{
        repository.deleteById(id);
    }

	public List<IndustryAddress> getIndustryAddress(Long id) 
	{
		return repository.findByIndustryId(id);
    }
    
	public IndustryAddress getIndustryAddressById(long id) 
    {
        Optional<IndustryAddress> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a IndustryAddress with id: " + id));
    }
	
}