package com.vihaans.core.dao.service;

import com.vihaans.core.dao.model.dto.CountryDto;
import com.vihaans.core.dao.model.Country;
import com.vihaans.core.dao.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired CountryRepository repository;

    public void add(Country countryState) {
        repository.save(countryState);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Country> getCountryState() {
        return (List<Country>) repository.findAll();
    }

    public Country getCountryStateById(long id) {
        Optional<Country> optional = repository.findById(id);
        return optional.orElseThrow(() -> new NotFoundException("Couldn't find a State with id: " + id));
    }

    private Country toEntity(CountryDto dto) {
    	Country entity = new Country();
        entity.setName(dto.getName());
        
        return entity;
    }
}