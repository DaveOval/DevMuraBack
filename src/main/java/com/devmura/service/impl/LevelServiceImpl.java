package com.devmura.service.impl;

import com.devmura.entity.Level;
import com.devmura.repository.LevelRepository;
import com.devmura.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    LevelRepository levelRepository;

    @Override
    public void save(Level level) {
        levelRepository.save(level);
    }

    @Override
    public void delete(Integer id) {
        levelRepository.deleteById(id);
    }

    @Override
    public Optional<Level> findLevelById(Integer id) {
        return levelRepository.findById(id);
    }

    @Override
    public List<Level> getAll() {
        return levelRepository.findAll();
    }
}
