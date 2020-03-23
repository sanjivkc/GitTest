package com.vihaans.core.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.IndustryAddress;
import com.vihaans.core.dao.model.IndustryMember;
import com.vihaans.core.dao.model.TransmissionHeader;

@Repository
public interface TransmissionRepository extends JpaRepository<TransmissionHeader, Long> {
	
	List<TransmissionHeader> findByCompanyCode(String companyCode);
	
	
	List<TransmissionHeader> findByIndustryMemberId(Long id);
}
