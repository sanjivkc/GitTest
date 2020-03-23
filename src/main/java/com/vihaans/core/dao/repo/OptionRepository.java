package com.vihaans.core.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vihaans.core.dao.model.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {}