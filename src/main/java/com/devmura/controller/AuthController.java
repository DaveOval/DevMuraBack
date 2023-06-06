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

    @GetMapping("/all")
    public ResponseEntity<List<Auth>> getAll(){
        List<Auth> auths = authService.getAll();
        return ResponseEntity.ok(auths);
    } 

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Auth auth) {
        authService.save(auth);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        authService.delete(id);
        return ResponseEntity.ok().build();
    }
}
