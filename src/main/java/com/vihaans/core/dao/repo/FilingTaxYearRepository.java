package com.vihaans.core.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.FilingTaxYear;

@Repository
public interface FilingTaxYearRepository extends JpaRepository<FilingTaxYear, Long> {}