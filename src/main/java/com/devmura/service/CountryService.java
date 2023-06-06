package com.devmura.service;

import com.devmura.entity.Country;

import java.util.List;
import java.util.Optional;


public interface CountryService {
    void save (Country country);
    void delete (Integer id);
    Optional <Country> findById(Integer id);
    List <Country> getAll();



}
