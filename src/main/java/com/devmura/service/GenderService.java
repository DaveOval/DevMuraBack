package com.devmura.service;

import com.devmura.entity.Gender;
import com.devmura.entity.User;

import java.util.List;
import java.util.Optional;

public interface GenderService {
     void save(Gender gender);
     void delete(Integer id);
     Optional<Gender> findById(Integer id);
     List<Gender> getAll();
     List<Gender> findAll();
}
