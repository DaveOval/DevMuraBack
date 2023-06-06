package com.devmura.service.impl;

import com.devmura.entity.Country;
import com.devmura.repository.CountryRepository;
import com.devmura.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryService countryService;


    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void delete(Integer id) {
        countryRepository.deleteById(id);

    }

    @Override
    public Optional<Country> findById(Integer id) {
        return Optional.findById();
    }

    @Override
    public List<Country> getAll() {
        return coutryRepository.findAll();
    }
}
