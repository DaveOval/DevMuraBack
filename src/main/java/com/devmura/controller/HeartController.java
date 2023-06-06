package com.devmura.controller;

import com.devmura.entity.Heart;
import com.devmura.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heart")
@CrossOrigin(origins = "*")
public class HeartController {
    @Autowired
    HeartService heartService;


    @GetMapping("/all")
    public ResponseEntity<List<Heart>> getAll(){
        List<Heart> heartList = heartService.getAll();
        return ResponseEntity.ok(heartList);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Heart heart) {
        heartService.save(heart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        heartService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
