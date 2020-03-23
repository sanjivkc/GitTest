package com.vihaans.core.dao.service;

import com.vihaans.core.dao.model.FormList;
import com.vihaans.core.dao.repo.FormListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormListService 
{
    @Autowired FormListRepository repository;

    public List<FormList> getFormList()
    {
        return (List<FormList>) repository.findAll();
    }
}