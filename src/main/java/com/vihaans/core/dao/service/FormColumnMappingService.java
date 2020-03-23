package com.vihaans.core.dao.service;

import com.vihaans.core.dao.model.FormColumnMapping;
import com.vihaans.core.dao.repo.FormColumnMappingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormColumnMappingService 
{
    @Autowired FormColumnMappingRepository repository;

    public List<FormColumnMapping> getFormColumnMapping(Long id)
    {
        return (List<FormColumnMapping>) repository.findByFormId(id);
    }
}