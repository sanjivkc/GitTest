package com.vihaans.core.dao.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.IndustryAddress;

@Repository
public interface IndustryAddressRepository extends JpaRepository<IndustryAddress, Long> 
{
	
	List<IndustryAddress> findByIndustryId(Long id);
	
}