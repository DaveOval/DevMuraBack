package com.devmura.controller;

import com.devmura.dto.UserDto;
import com.devmura.entity.*;
import com.devmura.service.AuthService;
import com.devmura.service.LevelService;
import com.devmura.service.ProfileService;
import com.devmura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<?>> getUsers(){
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
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

    @GetMapping("/dto")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return userService.getAllUsers();
    }


    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
