package com.devmura.service;

import com.devmura.entity.User;
import com.devmura.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("devmura")
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findById() {
        userRepository.findById(1);
    }


    @Test
    void existsByEmail() {
        boolean exists = userRepository.existsByEmailIgnoringCase("chfdsfen@gmail.com");
        if (exists) {
            System.out.println("Email exists");
        } else {
            System.out.println("Email does not exist");
        }

    }

    @Test
    void existsByUsername() {
        boolean exists = userRepository.existsByUsernameIgnoringCase("alex_t");
        if (exists) {
            System.out.println("Username exists");
        } else {
            System.out.println("Username does not exist");
        }
    }
}