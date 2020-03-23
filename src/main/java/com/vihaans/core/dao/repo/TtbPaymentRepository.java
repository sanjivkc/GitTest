package com.vihaans.core.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.TtbPayment;

@Repository
public interface TtbPaymentRepository extends JpaRepository<TtbPayment, Long> 
{
	
	List<TtbPayment> findByCompanyCode(String companyCode);

}
