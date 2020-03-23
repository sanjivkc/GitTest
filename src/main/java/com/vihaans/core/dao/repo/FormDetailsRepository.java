package com.vihaans.core.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.FormDetails;

@Repository
public interface FormDetailsRepository extends JpaRepository<FormDetails, Long> 
{
	
	List<FormDetails> findByCompanyCode(String companyCode);
	
	List<FormDetails> findByIndustryMemberId(Long id);
	
	List<FormDetails> findByIndustryAddressId(Long id);
	
	List<FormDetails> findByTaxYear(String year);
	
	List<FormDetails> findByStatus(String year);
	
}