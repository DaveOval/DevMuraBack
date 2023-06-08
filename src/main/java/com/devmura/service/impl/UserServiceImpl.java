package com.devmura.service.impl;

import com.devmura.entity.Auth;
import com.devmura.entity.Level;
import com.devmura.entity.Profile;
import com.devmura.entity.User;
import com.devmura.repository.UserRepository;
import com.devmura.service.AuthService;
import com.devmura.service.LevelService;
import com.devmura.service.ProfileService;
import com.devmura.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileService profileService;
    @Autowired
    LevelService levelService;
    @Autowired
    AuthService authService;


    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> save(User user) {
        try {
            if (existsByEmail(user.getEmail())) {
                throw new IllegalStateException("email already exists: " + user.getEmail());
            }
            if (existsByUsername(user.getUsername())) {
                throw new IllegalStateException("username already exists: " + user.getUsername());
            } else {
                Optional<Auth> auth = authService.findAuthById(2);
                if (auth.isPresent()) {
                    user.setAuth(auth.get());

                    userRepository.save(user);


                    Profile profile = new Profile();
                    profile.setUser(user);
                    Optional<Level> level = levelService.findLevelById(2);
                    if (level.isPresent()) {
                        profile.setLevel(level.get());
                    }
                    profileService.save(profile);

                    return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
                }
            }
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Error creating user", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<?> delete(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<?>> findAll() {
        if (userRepository.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<?>> findByNameLike(String pattern) {
        List<User> users = userRepository.findByNameLike(pattern);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<?>> findByName(String name) {
        List<User> users = userRepository.findByNameLike(name);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }


    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmailIgnoringCase(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsernameIgnoringCase(username);
    }
}

   // Customer customer = customerRepository.findById(idCustomer)
   //         .orElseThrow( ()->
   //                 new IllegalStateException("User does not exist with id: " + idCustomer));

