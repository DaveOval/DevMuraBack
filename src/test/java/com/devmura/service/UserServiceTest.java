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
        Optional<User> optional = userRepository.findById(2);
        if (optional.isPresent()) {
            System.out.println("si existe");
        } else
            System.out.println("no existe");
    }
}