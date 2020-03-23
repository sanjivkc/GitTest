package com.vihaans.core.dao.service;

import com.vihaans.core.dao.model.FilingTaxYear;
import com.vihaans.core.dao.repo.FilingTaxYearRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilingTaxYearService 
{
    @Autowired FilingTaxYearRepository repository;

    public List<FilingTaxYear> getFilingTaxYearList()
    {
        return (List<FilingTaxYear>) repository.findAll();
    }
}