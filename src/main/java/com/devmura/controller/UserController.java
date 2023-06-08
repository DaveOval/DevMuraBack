package com.devmura.controller;

import com.devmura.entity.User;
import com.devmura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public String saveUser(@RequestBody User user) {
        try {
            if (userService.existsByEmail(user.getEmail())) {
                return "Email already exists";
            } else if (userService.existsByUsername(user.getUsername())) {
                return "Username already exists";
            } else {
                userService.save(user);
                return "User saved";
            }
        } catch (Exception e) {
            return "Error saving user";
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (userService.findById(id) == null){
            return ResponseEntity.notFound().build();
        } else {
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Integer id) {
        try {
            if (userService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(userService.findById(id));
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
