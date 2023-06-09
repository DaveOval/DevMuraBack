package com.devmura.controller;

import com.devmura.entity.*;
import com.devmura.service.AuthService;
import com.devmura.service.LevelService;
import com.devmura.service.ProfileService;
import com.devmura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    ProfileService profileService;

    @Autowired
    LevelService levelService;

    @GetMapping
    public ResponseEntity<List<?>> getUsers(){
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> savePost(@RequestBody User user){
        return userService.save(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return userService.save(user);
    }
}
