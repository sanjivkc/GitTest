package com.vihaans.core.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.FormColumnMapping;

@Repository
public interface FormColumnMappingRepository extends JpaRepository<FormColumnMapping, Long> 
{
	List<FormColumnMapping> findByFormId(Long id);
}