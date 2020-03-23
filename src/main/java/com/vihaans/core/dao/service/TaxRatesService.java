package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vihaans.core.dao.Auditable;
import com.vihaans.core.dao.model.IndustryMember;
import com.vihaans.core.dao.model.TaxRates;
import com.vihaans.core.dao.repo.IndustryMemberRepository;
import com.vihaans.core.dao.repo.TaxRatesRepository;
import com.vihaans.core.util.AuditingActionType;

@Service
public class TaxRatesService 
{

	@Autowired
	TaxRatesRepository repository;
	
	public List<TaxRates> findByProductName(String productName) 
	{
		return repository.findByProductName(productName);
    }
	
	public List<TaxRates> findByProductCategory(String productCategory) 
	{
		return repository.findByProductCategory(productCategory);
    }
    
	public TaxRates findById(long id) 
    {
        Optional<TaxRates> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Tax Rates with id: " + id));
    }
	
}