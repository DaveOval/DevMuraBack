package com.devmura.service.impl;

import com.devmura.dto.UserDto;
import com.devmura.entity.*;
import com.devmura.mapper.UserMapper;
import com.devmura.repository.AuthRepository;
import com.devmura.repository.UserRepository;
import com.devmura.service.AuthService;
import com.devmura.service.LevelService;
import com.devmura.service.ProfileService;
import com.devmura.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import static com.devmura.mapper.UserMapper.mapToUserDto;

// @AllArgsConstructor // Lombok - generates a constructor with 1 parameter for each field in your class in this case UserMapper
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
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> save(User user) {
        return null;
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

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        if (userRepository.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<User> users = userRepository.findAll();
            List<UserDto> userDtos = users
                    .stream()
                    .map(user -> UserMapper.mapToUserDto(user))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(userDtos, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> saveUser(User user) {
        try {
            Set<UserRole> roles = new HashSet<>();
            User newUser = userRepository.findByUsername(user.getUsername());
            if (newUser != null) {
                throw new Exception("Username " + user.getUsername() + " already exists");
            }
            if (userRepository.existsByEmailIgnoringCase(user.getEmail())) {
                throw new Exception("Email " + user.getEmail() + " already exists");
            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                UserRole userRole = new UserRole();
                userRole.setUser(user);
                Optional<Auth> auth = authRepository.findById(2);
                if (auth.isPresent()) {
                    userRole.setAuth(auth.get());
                } else {
                    throw new Exception("Auth not found");
                }

                roles.add(userRole);

                for (UserRole ur : roles) {
                    authRepository.save(ur.getAuth());
                }
                user.getUserRoles().addAll(roles);
                Profile profile = new Profile();
                profile.setUser(user);
                Optional<Level> level = levelService.findLevelById(2);
                level.ifPresent(profile::setLevel);

                user.setProfile(profile);
                newUser = userRepository.save(user);
            }
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

