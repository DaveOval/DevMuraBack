package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Level;
import com.devmura.repository.LevelRepository;
import com.devmura.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    LevelRepository levelRepository;


    @Override
    public ResponseEntity<List<?>> findAll() {
        if (levelRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(levelRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Level> level = levelRepository.findById(id);
        if (level.isPresent()) {
            return new ResponseEntity<>(level, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Level not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Level level) {
        try {
            levelRepository.save(level);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(level);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (levelRepository.findById(id).isPresent()) {
            levelRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Optional<Level> findLevelById(Integer id) {
        return levelRepository.findById(id);
    }
}
