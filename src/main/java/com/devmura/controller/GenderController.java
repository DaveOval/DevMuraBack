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

    @GetMapping
    public ResponseEntity<List<?>> getGender(){
        return genderService.findAll();
    }
    @PostMapping
    public ResponseEntity<?> saveGender(@RequestBody Gender gender){
        return genderService.save(gender);
    }
    @DeleteMapping("(id)")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return genderService.delete(id);
    }
}
