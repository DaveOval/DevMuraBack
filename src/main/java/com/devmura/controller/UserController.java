package com.devmura.controller;

import com.devmura.entity.Auth;
import com.devmura.entity.Level;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
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
                Optional<Auth> auth = authService.findAuthById(2);
                if (auth.isPresent()) {
                    user.setAuth(auth.get());

                    userService.save(user);


                    Profile profile = new Profile();
                    profile.setUser(user);
                    Optional<Level> level = levelService.findLevelById(2);
                    if (level.isPresent()) {
                        profile.setLevel(level.get());
                    }
                    profileService.save(profile);

                    return "User saved";
                } else {
                    return "Error saving user: Auth not found";
                }
            }
        } catch (Exception e) {
            return "Error saving user: " + e.getMessage();
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
