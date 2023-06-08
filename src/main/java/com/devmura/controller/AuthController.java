package com.devmura.controller;

import com.devmura.entity.Auth;
import com.devmura.repository.AuthRepository;
import com.devmura.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    AuthService authService;

    @GetMapping
    public ResponseEntity<List<?>> getAll(){
        return authService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Auth auth) {
        return authService.save(auth);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return authService.delete(id);
    }
}
