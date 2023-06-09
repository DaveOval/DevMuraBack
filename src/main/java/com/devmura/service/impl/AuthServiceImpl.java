package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.User;
import com.devmura.repository.AuthRepository;
import com.devmura.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthRepository authRepository;


    @Override
    public ResponseEntity<List<?>> findAll() {
        if (authRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(authRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Auth> auth = authRepository.findById(id);
        if (auth.isPresent()) {
            return new ResponseEntity<>(auth, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Auth not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Auth auth) {
        try {
            authRepository.save(auth);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(auth);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (authRepository.findById(id).isPresent()) {
            authRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Optional<Auth> findAuthById(Integer id) {
        return authRepository.findById(id);
    }
}
