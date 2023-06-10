package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Gender;
import com.devmura.repository.GenderRepository;
import com.devmura.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    GenderRepository genderRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (genderRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(genderRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Gender> gender = genderRepository.findById(id);
        if (gender.isPresent()) {
            return new ResponseEntity<>(gender, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Gender not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Gender gender) {
        try {
            genderRepository.save(gender);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(gender);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }
}
