package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Language;
import com.devmura.repository.LanguageRepository;
import com.devmura.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageRepository languageRepository;


    @Override
    public ResponseEntity<List<?>> findAll() {
        if (languageRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(languageRepository.findAll());
        }
    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<Language> language = languageRepository.findById(id);
        if (language.isPresent()) {
            return new ResponseEntity<>(language, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Language not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(Language language) {
        try {
            languageRepository.save(language);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(language);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (languageRepository.findById(id).isPresent()) {
            languageRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
