package com.vihaans.core.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.vihaans.core.dao.model.State;
import com.vihaans.core.dao.repo.StateRepository;

@Service
public class StateService 
{
	
    @Autowired StateRepository repository;

    public void add(State countryState) 
    {
        repository.save(countryState);
    }

    public void delete(long id) 
    {
        repository.deleteById(id);
    }

    public List<State> getAllState()
    {
        return (List<State>) repository.findAll();
    }
    
    public List<State> getStateByCountryCode(String countryCode) 
	{
		return repository.findByCountryCode(countryCode);
    }

    public State getStateById(long id) 
    {
        Optional<State> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a State with id: " + id));
    }
    
}