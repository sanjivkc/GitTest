package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.IndustryMember;
import com.vihaans.core.dao.repo.IndustryMemberRepository;
import com.vihaans.core.util.AuditingActionType;

@Service
public class IndustryMemberService 
{

	@Autowired
	IndustryMemberRepository repository;
	
	@Transactional
	@Auditable(actionType = AuditingActionType.CREATE, failedActionType = AuditingActionType.CREATE_FAILED)
	public void add(IndustryMember member) 
	{
        repository.save(member);
    }
	
	@Transactional
	@Auditable(actionType = AuditingActionType.UPDATE, failedActionType = AuditingActionType.UPDATE_FAILED)
	public void edit(IndustryMember member) 
	{
		repository.save(member);
    }

	@Transactional
	@Auditable(actionType = AuditingActionType.DELETE, failedActionType = AuditingActionType.DELETE_FAILED)
    public void delete(long id) 
	{
        repository.deleteById(id);
    }

	public List<IndustryMember> getIndustryMember(String companyCode) 
	{
		return repository.findByCompanyCode(companyCode);
    }
    
	public IndustryMember getIndustryMemberById(long id) 
    {
        Optional<IndustryMember> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a IndustryMember with id: " + id));
    }
	
}