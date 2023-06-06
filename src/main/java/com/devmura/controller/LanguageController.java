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
@RequestMapping("/api/language")
@CrossOrigin(origins = "*")
public class LanguageController {

    @Autowired
    LanguageService languageService;
    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Language>> getAll(){
        List<Language> languageList = languageRepository.findAll();
        return ResponseEntity.ok(languageList);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Language language) {
        languageService.save(language);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        languageService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
