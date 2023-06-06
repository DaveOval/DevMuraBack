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

    @GetMapping("/all")
    public ResponseEntity<List<Level>> getAll(){
        List<Level> levelList = levelService.getAll();
        return ResponseEntity.ok(levelList);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Level level) {
        levelService.save(level);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        levelService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
