package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Heart;
import com.devmura.repository.HeartRepository;
import com.devmura.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeartServiceImpl implements HeartService {

    @Autowired
    HeartRepository heartRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (heartRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(heartRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Heart> heart = heartRepository.findById(id);
        if (heart.isPresent()) {
            return new ResponseEntity<>(heart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Heart not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Heart heart) {
        try {
            heartRepository.save(heart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(heart);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (heartRepository.findById(id).isPresent()) {
            heartRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
