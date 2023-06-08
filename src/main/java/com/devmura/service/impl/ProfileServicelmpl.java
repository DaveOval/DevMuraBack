package com.devmura.service.impl;

import com.devmura.entity.Profile;
import com.devmura.repository.ProfileRepository;
import com.devmura.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServicelmpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (profileRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(profileRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        if (profileRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(profileRepository.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> save(Profile profile) {
        try {
            profileRepository.save(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(profile);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (profileRepository.findById(id).isPresent()) {
            profileRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
