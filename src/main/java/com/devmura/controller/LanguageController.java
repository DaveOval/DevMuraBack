package com.devmura.controller;

import com.devmura.entity.Language;
import com.devmura.repository.LanguageRepository;
import com.devmura.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin(origins = "*")
public class LanguageController {

    @Autowired
    LanguageService languageService;
    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping
    public ResponseEntity<List<?>> getAll(){
        return languageService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Language language) {
        return languageService.save(language);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return languageService.delete(id);
    }

}
