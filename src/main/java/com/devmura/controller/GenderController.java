package com.devmura.controller;


import com.devmura.entity.Gender;
import com.devmura.service.GenderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gender")
@CrossOrigin(origins = "*")
public class GenderController {
    @Autowired
    GenderService genderService;

    @GetMapping("/all")
    public ResponseEntity<List<Gender>> getGender(){
        List<Gender> gender = genderService.getAll();
        return ResponseEntity.ok(gender);

    }
    @PostMapping("/save")
    public ResponseEntity<Void> saveGender(@RequestBody Gender gender){
        genderService.save(gender);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/delete/(id)")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        genderService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
