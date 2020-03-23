package com.vihaans.core.dao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vihaans.core.dao.model.Audit;
import com.vihaans.core.dao.repo.AuditRepository;

@Service
public class AuditService {

	@Autowired
	AuditRepository repository;
	
	public void add(Audit audit) {
        repository.save(audit);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Audit> get() {
        return (List<Audit>) repository.findAll();
    }
    
    public Audit get(long id) {
        Optional<Audit> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Audit with id: " + id));
    }
	
}
