package com.vihaans.core.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.TaxRates;

@Repository
public interface TaxRatesRepository extends JpaRepository<TaxRates, Long> 
{
	
	List<TaxRates> findByProductName(String productName);
	
	List<TaxRates> findByProductCategory(String productCategory);
	
}