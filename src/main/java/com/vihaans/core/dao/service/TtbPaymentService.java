package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.Employee;
import com.vihaans.core.dao.model.FormDetails;
import com.vihaans.core.dao.model.TtbPayment;
import com.vihaans.core.dao.repo.TtbPaymentRepository;
import com.vihaans.core.util.AuditingActionType;


@Service
public class TtbPaymentService {


	@Autowired
	TtbPaymentRepository repository;
	
	@Transactional
	@Auditable(actionType = AuditingActionType.CREATE, failedActionType = AuditingActionType.CREATE_FAILED)
	public void add(TtbPayment ttbPayment) {
        repository.save(ttbPayment);
    }
	
	@Transactional
	@Auditable(actionType = AuditingActionType.UPDATE, failedActionType = AuditingActionType.UPDATE_FAILED)
	public void update(TtbPayment ttbPayment) 
	{
		repository.save(ttbPayment);
    }
	
	public List<TtbPayment> getTtbPayment(String companyCode) 
	{
		return repository.findByCompanyCode(companyCode);
    }
    
	public TtbPayment getTtbPaymentById(long id) 
    {
        Optional<TtbPayment> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Employee with id: " + id));
    }
	
	
}
