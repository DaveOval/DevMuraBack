package com.devmura.service.impl;

import com.devmura.entity.Gender;
import com.devmura.repository.GenderRepository;
import com.devmura.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService{
    private final GenderRepository genderRepository;

    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public void save(Gender gender) {
        genderRepository.save(gender);
    }

    @Override
    public void delete(Integer id) {
         genderRepository.deleteById(id);
    }

    @Override
    public Optional<Gender> findById(Integer id) {
        return genderRepository.findById(id);
    }

    @Override
    public Optional <Gender> getAll() {
        return genderRepository.getAll();
    }
}
