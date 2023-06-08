package com.devmura.controller;

import com.devmura.entity.Level;
import com.devmura.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/level")
@CrossOrigin(origins = "*")
public class LevelController {
    @Autowired
    LevelService levelService;

    @GetMapping
    public ResponseEntity<List<?>> getAll(){
        return levelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Level level) {
        return levelService.save(level);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return levelService.delete(id);
    }
}
