package com.vihaans.core.dao.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.IndustryMember;

@Repository
public interface IndustryMemberRepository extends JpaRepository<IndustryMember, Long> 
{
	
	List<IndustryMember> findByCompanyCode(String companyCode);
	
}