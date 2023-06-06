package com.devmura.service.impl;

import com.devmura.entity.Country;
import com.devmura.repository.CountryRepository;
import com.devmura.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;


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
         return countryRepository.findById(id);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}



