package com.devmura.service;

import com.devmura.entity.Gender;

import java.util.Optional;

public interface GenderService {
     void save(Gender gender);
     void delete(Integer id);
     Optional<Gender> findById(Integer id);
     Optional <Gender>getAll();
}
