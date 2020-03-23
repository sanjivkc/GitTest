package com.vihaans.core.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vihaans.core.dao.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> 
{
	
	List<State> findByCountryCode(String countryCode);
	
}