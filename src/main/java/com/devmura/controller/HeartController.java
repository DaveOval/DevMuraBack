package com.devmura.controller;

import com.devmura.entity.Heart;
import com.devmura.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hearts")
@CrossOrigin(origins = "*")
public class HeartController {
    @Autowired
    HeartService heartService;


    @GetMapping
    public ResponseEntity<List<?>> getAll(){
        return heartService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Heart heart, @RequestParam Integer postId, @RequestParam Integer userId) {
        return heartService.saveHeart(heart, postId, userId);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return heartService.delete(id);
    }


}
