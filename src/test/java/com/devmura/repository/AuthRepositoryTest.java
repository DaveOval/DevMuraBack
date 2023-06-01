package com.devmura.repository;

import com.devmura.entity.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("devmura")
class AuthRepositoryTest {
    @Autowired
    AuthRepository authRepository;

    @Test
    public void getAll(){
        List<Auth> auths = authRepository.findAll();
        auths.forEach(System.out::println);
    }

    @Test
    public void findByid() {
        Auth auth = authRepository.findById(1).get();
        System.out.println(auth);
        assertEquals(1,auth.getId());
    }
}