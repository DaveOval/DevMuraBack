package com.devmura.service.impl;

import com.devmura.entity.Heart;
import com.devmura.repository.HeartRepository;
import com.devmura.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeartServiceImpl implements HeartService {

    @Autowired
    HeartRepository heartRepository;

    @Override
    public void save(Heart heart) {
        heartRepository.save(heart);
    }

    @Override
    public void delete(Integer id) {
        heartRepository.deleteById(id);
    }

    @Override
    public Optional<Heart> findById(Integer id) {
        return heartRepository.findById(id);
    }

    @Override
    public List<Heart> getAll() {

        return heartRepository.findAll();
    }
}
